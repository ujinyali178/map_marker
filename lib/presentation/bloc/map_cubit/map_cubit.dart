import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:geolocator/geolocator.dart';
import 'package:latlong2/latlong.dart';

import 'map_state.dart';

class MapCubit extends Cubit<MapState> {
  StreamSubscription<Position>? _positionSubscription;
  final Map<String, Marker> _markerMap = {};
  final Map<String, Polyline> _polylineMap = {};

  MapCubit() : super(const MapState());

  void moveCamera(LatLng position, {double? zoom}) {
    emit(state.copyWith(
      cameraPosition: position,
      zoom: zoom,
    ));
  }

  void setMapType(MapTypeOption type) {
    emit(state.copyWith(mapType: type));
  }

  void addMarker({
    required String markerId,
    required LatLng position,
    String? title,
    String? snippet,
  }) {
    final marker = Marker(
      point: position,
      width: 40,
      height: 40,
      child: const Icon(Icons.location_on, color: Colors.red, size: 30),
    );
    _markerMap[markerId] = marker;
    emit(state.copyWith(markers: _markerMap.values.toList()));
  }

  void removeMarker(String markerId) {
    _markerMap.remove(markerId);
    emit(state.copyWith(markers: _markerMap.values.toList()));
  }

  void updateMarkers(List<Marker> markers) {
    _markerMap.clear();
    for (int i = 0; i < markers.length; i++) {
      _markerMap['marker_$i'] = markers[i];
    }
    emit(state.copyWith(markers: markers));
  }

  void setRoute({
    required String polylineId,
    required List<LatLng> points,
    int color = 0xFF4CAF50,
    double width = 5.0,
  }) {
    final polyline = Polyline(
      points: points,
      color: Color(color),
      strokeWidth: width,
    );
    _polylineMap[polylineId] = polyline;
    emit(state.copyWith(polylines: _polylineMap.values.toList()));
  }

  void clearRoute({String? polylineId}) {
    if (polylineId != null) {
      _polylineMap.remove(polylineId);
      emit(state.copyWith(polylines: _polylineMap.values.toList()));
    } else {
      _polylineMap.clear();
      emit(state.copyWith(polylines: const <Polyline>[]));
    }
  }

  Future<void> getCurrentLocation() async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      bool serviceEnabled = await Geolocator.isLocationServiceEnabled();
      if (!serviceEnabled) {
        emit(state.copyWith(
          isLoading: false,
          error: 'Location services are disabled.',
        ));
        return;
      }

      LocationPermission permission = await Geolocator.checkPermission();
      if (permission == LocationPermission.denied) {
        permission = await Geolocator.requestPermission();
        if (permission == LocationPermission.denied) {
          emit(state.copyWith(
            isLoading: false,
            error: 'Location permission denied.',
          ));
          return;
        }
      }

      if (permission == LocationPermission.deniedForever) {
        emit(state.copyWith(
          isLoading: false,
          error: 'Location permission permanently denied.',
        ));
        return;
      }

      final position = await Geolocator.getCurrentPosition(
        locationSettings: const LocationSettings(
          accuracy: LocationAccuracy.high,
        ),
      );

      final currentLoc = LatLng(position.latitude, position.longitude);
      emit(state.copyWith(
        isLoading: false,
        currentLocation: currentLoc,
        heading: position.heading ?? 0,
        cameraPosition: currentLoc,
        clearError: true,
      ));
    } catch (e) {
      emit(state.copyWith(
        isLoading: false,
        error: e.toString(),
      ));
    }
  }

  void startLocationStream() {
    _positionSubscription?.cancel();
    _positionSubscription = Geolocator.getPositionStream(
      locationSettings: const LocationSettings(
        accuracy: LocationAccuracy.high,
        distanceFilter: 10,
      ),
    ).listen(
      (position) {
        final currentLoc = LatLng(position.latitude, position.longitude);
        emit(state.copyWith(
          currentLocation: currentLoc,
          heading: position.heading ?? 0,
        ));
      },
      onError: (e) {
        emit(state.copyWith(error: e.toString()));
      },
    );
  }

  void stopLocationStream() {
    _positionSubscription?.cancel();
    _positionSubscription = null;
  }

  @override
  Future<void> close() {
    _positionSubscription?.cancel();
    return super.close();
  }
}
