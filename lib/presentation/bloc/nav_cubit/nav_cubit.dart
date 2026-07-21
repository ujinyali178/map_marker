import 'dart:async';
import 'dart:convert';
import 'dart:math';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:geolocator/geolocator.dart';
import 'package:latlong2/latlong.dart';
import 'package:http/http.dart' as http;

import 'nav_state.dart';

class NavigationCubit extends Cubit<NavState> {
  StreamSubscription<Position>? _positionSubscription;
  Timer? _updateTimer;

  NavigationCubit() : super(const NavState());

  Future<void> startNavigation(NavDestination destination) async {
    emit(state.copyWith(isActive: true, clearError: true, clearDestination: true));

    try {
      final position = await Geolocator.getCurrentPosition(
        locationSettings: const LocationSettings(
          accuracy: LocationAccuracy.high,
        ),
      );

      final origin = LatLng(position.latitude, position.longitude);
      final dest = LatLng(destination.latitude, destination.longitude);

      await _fetchRoute(origin, dest, destination);

      _startPositionUpdates(destination);
    } catch (e) {
      emit(state.copyWith(
        isActive: false,
        error: e.toString(),
      ));
    }
  }

  void stopNavigation() {
    _positionSubscription?.cancel();
    _positionSubscription = null;
    _updateTimer?.cancel();
    _updateTimer = null;

    emit(const NavState());
  }

  void updateCurrentPosition() {
    if (!state.isActive || state.routePoints.isEmpty) return;

    Geolocator.getCurrentPosition(
      locationSettings: const LocationSettings(
        accuracy: LocationAccuracy.high,
      ),
    ).then((position) {
      _updateNavigationState(LatLng(position.latitude, position.longitude));
    });
  }

  Future<void> _fetchRoute(
    LatLng origin,
    LatLng destination,
    NavDestination destPoi,
  ) async {
    final url = Uri.parse(
      'https://router.project-osrm.org/route/v1/driving/'
      '${origin.longitude},${origin.latitude};'
      '${destination.longitude},${destination.latitude}'
      '?overview=full&geometries=geojson&steps=true',
    );

    final response = await http.get(url);

    if (response.statusCode != 200) {
      emit(state.copyWith(
        isActive: false,
        error: 'Failed to fetch route: HTTP ${response.statusCode}',
      ));
      return;
    }

    final data = json.decode(response.body);

    if (data['code'] != 'Ok' || (data['routes'] as List).isEmpty) {
      emit(state.copyWith(
        isActive: false,
        error: 'No route found',
      ));
      return;
    }

    final route = data['routes'][0];
    final geometry = route['geometry'];
    final coords = geometry['coordinates'] as List;
    final routePoints = coords
        .map<LatLng>((coord) => LatLng(coord[1] as double, coord[0] as double))
        .toList();

    final legs = route['legs'] as List;
    final steps = <NavStep>[];
    double totalDistance = 0;
    double totalDuration = 0;

    for (final leg in legs) {
      totalDistance += (leg['distance'] as num).toDouble();
      totalDuration += (leg['duration'] as num).toDouble();

      for (final step in leg['steps'] as List) {
        final stepGeometry = step['geometry']['coordinates'] as List;
        final stepPoints = stepGeometry
            .map<LatLng>(
                (c) => LatLng(c[1] as double, c[0] as double))
            .toList();

        steps.add(NavStep(
          instruction: step['name'] as String? ?? '',
          distance: (step['distance'] as num).toDouble(),
          duration: (step['duration'] as num).toDouble(),
          modifier: step['maneuver']?['modifier'] as String?,
          mode: step['mode'] as String?,
          geometry: stepPoints,
        ));
      }
    }

    emit(state.copyWith(
      isActive: true,
      destinationPoi: destPoi,
      routePoints: routePoints,
      routeDistance: totalDistance,
      routeDuration: totalDuration,
      remainingDistance: totalDistance,
      remainingDuration: totalDuration,
      currentStep: 0,
      steps: steps,
      clearError: true,
    ));
  }

  void _startPositionUpdates(NavDestination destination) {
    _positionSubscription?.cancel();
    _positionSubscription = Geolocator.getPositionStream(
      locationSettings: const LocationSettings(
        accuracy: LocationAccuracy.high,
        distanceFilter: 5,
      ),
    ).listen(
      (position) {
        _updateNavigationState(LatLng(position.latitude, position.longitude));
      },
      onError: (e) {
        emit(state.copyWith(error: e.toString()));
      },
    );
  }

  void _updateNavigationState(LatLng currentPos) {
    if (state.routePoints.isEmpty) return;

    // Find closest point on route
    double minDist = double.infinity;
    int closestIndex = 0;
    for (int i = 0; i < state.routePoints.length; i++) {
      final d = _haversine(currentPos, state.routePoints[i]);
      if (d < minDist) {
        minDist = d;
        closestIndex = i;
      }
    }

    // Calculate remaining distance from closest point to end
    double remainingDist = 0;
    for (int i = closestIndex; i < state.routePoints.length - 1; i++) {
      remainingDist += _haversine(state.routePoints[i], state.routePoints[i + 1]);
    }

    // Estimate remaining duration based on average speed
    final avgSpeed = state.routeDistance / max(state.routeDuration, 1);
    final remainingDur = remainingDist / max(avgSpeed, 1);

    // Determine current step
    int stepIndex = state.currentStep;
    double accumulated = 0;
    for (int i = 0; i < state.steps.length; i++) {
      accumulated += state.steps[i].distance;
      if (accumulated >= (state.routeDistance - remainingDist)) {
        stepIndex = i;
        break;
      }
    }

    emit(state.copyWith(
      remainingDistance: remainingDist,
      remainingDuration: remainingDur,
      currentStep: stepIndex,
    ));

    // Check if arrived
    if (remainingDist < 20) {
      stopNavigation();
    }
  }

  double _haversine(LatLng a, LatLng b) {
    const r = 6371000.0; // Earth radius in meters
    final dLat = _toRad(b.latitude - a.latitude);
    final dLon = _toRad(b.longitude - a.longitude);
    final lat1 = _toRad(a.latitude);
    final lat2 = _toRad(b.latitude);

    final h = sin(dLat / 2) * sin(dLat / 2) +
        cos(lat1) * cos(lat2) * sin(dLon / 2) * sin(dLon / 2);
    return 2 * r * asin(sqrt(h));
  }

  double _toRad(double deg) => deg * pi / 180;

  @override
  Future<void> close() {
    _positionSubscription?.cancel();
    _updateTimer?.cancel();
    return super.close();
  }
}
