import 'dart:async';
import 'dart:convert';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:geolocator/geolocator.dart';
import 'package:latlong2/latlong.dart';
import 'package:uuid/uuid.dart';

import 'live_location_state.dart';

class LiveLocationCubit extends Cubit<LiveLocationState> {
  StreamSubscription<Position>? _positionSubscription;
  Timer? _durationTimer;
  DateTime? _startTime;

  LiveLocationCubit() : super(const LiveLocationState());

  Future<void> startSharing({Duration? maxDuration}) async {
    emit(state.copyWith(isSharing: true, clearError: true));

    try {
      bool serviceEnabled = await Geolocator.isLocationServiceEnabled();
      if (!serviceEnabled) {
        emit(state.copyWith(
          isSharing: false,
          error: 'Location services are disabled.',
        ));
        return;
      }

      LocationPermission permission = await Geolocator.checkPermission();
      if (permission == LocationPermission.denied) {
        permission = await Geolocator.requestPermission();
        if (permission == LocationPermission.denied) {
          emit(state.copyWith(
            isSharing: false,
            error: 'Location permission denied.',
          ));
          return;
        }
      }

      if (permission == LocationPermission.deniedForever) {
        emit(state.copyWith(
          isSharing: false,
          error: 'Location permission permanently denied.',
        ));
        return;
      }

      _startTime = DateTime.now();
      _startDurationTimer();
      _startPositionStream();

      final link = _generateShareableLink();
      emit(state.copyWith(shareLink: link));
    } catch (e) {
      emit(state.copyWith(
        isSharing: false,
        error: e.toString(),
      ));
    }
  }

  void stopSharing() {
    _positionSubscription?.cancel();
    _positionSubscription = null;
    _durationTimer?.cancel();
    _durationTimer = null;
    _startTime = null;

    emit(const LiveLocationState());
  }

  String? getShareableLink() {
    return state.shareLink;
  }

  void _startPositionStream() {
    _positionSubscription = Geolocator.getPositionStream(
      locationSettings: const LocationSettings(
        accuracy: LocationAccuracy.high,
        distanceFilter: 5,
      ),
    ).listen(
      (position) {
        final loc = LatLng(position.latitude, position.longitude);
        emit(state.copyWith(
          currentLocation: loc,
          accuracy: position.accuracy,
        ));
      },
      onError: (e) {
        emit(state.copyWith(error: e.toString()));
      },
    );
  }

  void _startDurationTimer() {
    _durationTimer = Timer.periodic(const Duration(seconds: 1), (_) {
      if (_startTime != null) {
        final elapsed = DateTime.now().difference(_startTime!);
        emit(state.copyWith(duration: elapsed));
      }
    });
  }

  String _generateShareableLink() {
    const uuid = Uuid();
    final shareId = uuid.v4();

    final lat = state.currentLocation?.latitude ?? 0.0;
    final lng = state.currentLocation?.longitude ?? 0.0;

    return 'https://mapmarker.app/live?share=$shareId&lat=$lat&lng=$lng';
  }

  @override
  Future<void> close() {
    _positionSubscription?.cancel();
    _durationTimer?.cancel();
    return super.close();
  }
}
