import 'dart:async';
import 'dart:math';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:geolocator/geolocator.dart';
import 'package:latlong2/latlong.dart';
import 'package:uuid/uuid.dart';

import '../../../data/repositories/track_repository.dart';
import '../../../data/models/track_point.dart' as data;
import '../../../data/models/track_model.dart';
import 'track_state.dart';

class TrackCubit extends Cubit<TrackState> {
  final TrackRepository _trackRepository;
  StreamSubscription<Position>? _positionSubscription;
  Timer? _durationTimer;
  DateTime? _pauseTime;
  Duration _pausedDuration = Duration.zero;

  LatLng? _lastPosition;

  TrackCubit(this._trackRepository) : super(const TrackState());

  Future<void> loadTracks() async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      final tracks = await _trackRepository.getAllTracks();
      emit(state.copyWith(isLoading: false, savedTracks: tracks));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> startRecording() async {
    emit(state.copyWith(isRecording: true, isPaused: false, clearError: true));

    try {
      bool serviceEnabled = await Geolocator.isLocationServiceEnabled();
      if (!serviceEnabled) {
        emit(state.copyWith(isRecording: false, error: 'Location services are disabled.'));
        return;
      }

      LocationPermission permission = await Geolocator.checkPermission();
      if (permission == LocationPermission.denied) {
        permission = await Geolocator.requestPermission();
        if (permission == LocationPermission.denied) {
          emit(state.copyWith(isRecording: false, error: 'Location permission denied.'));
          return;
        }
      }
      if (permission == LocationPermission.deniedForever) {
        emit(state.copyWith(isRecording: false, error: 'Location permission permanently denied.'));
        return;
      }

      const uuid = Uuid();

      final track = TrackModel(
        id: uuid.v4(),
        name: 'Track ${DateTime.now().day}/${DateTime.now().month}',
        startedAt: DateTime.now(),
      );

      await _trackRepository.startTrack(track);

      _pausedDuration = Duration.zero;
      _pauseTime = null;

      emit(state.copyWith(
        isRecording: true, isPaused: false,
        currentTrack: track,
        pointsCount: 0, distance: 0.0,
        duration: Duration.zero, currentSpeed: 0.0,
        clearError: true,
      ));

      _startDurationTimer();
      _startPositionStream();
    } catch (e) {
      emit(state.copyWith(isRecording: false, error: e.toString()));
    }
  }

  Future<void> stopRecording() async {
    _positionSubscription?.cancel();
    _positionSubscription = null;
    _durationTimer?.cancel();
    _durationTimer = null;

    if (state.currentTrack != null) {
      try {
        await _trackRepository.finishTrack(
          state.currentTrack!.id,
          distanceMeters: state.distance,
        );
        final saved = await _trackRepository.getTrackById(state.currentTrack!.id);
        emit(state.copyWith(isRecording: false, isPaused: false, currentTrack: saved));
      } catch (e) {
        emit(state.copyWith(isRecording: false, error: e.toString()));
      }
    }
  }

  void pauseRecording() {
    if (!state.isRecording || state.isPaused) return;
    _positionSubscription?.cancel();
    _positionSubscription = null;
    _durationTimer?.cancel();
    _durationTimer = null;
    _pauseTime = DateTime.now();
    emit(state.copyWith(isPaused: true));
  }

  void resumeRecording() {
    if (!state.isRecording || !state.isPaused) return;
    if (_pauseTime != null) {
      _pausedDuration += DateTime.now().difference(_pauseTime!);
    }
    _pauseTime = null;
    _startDurationTimer();
    _startPositionStream();
    emit(state.copyWith(isPaused: false));
  }

  void _startPositionStream() {
    _positionSubscription = Geolocator.getPositionStream(
      locationSettings: const LocationSettings(
        accuracy: LocationAccuracy.high,
        distanceFilter: 5,
      ),
    ).listen(
      (position) => _addTrackPoint(position),
      onError: (e) => emit(state.copyWith(error: e.toString())),
    );
  }

  void _startDurationTimer() {
    _durationTimer = Timer.periodic(const Duration(seconds: 1), (_) {
      if (state.currentTrack != null && !state.isPaused) {
        final elapsed = DateTime.now().difference(state.currentTrack!.startedAt) - _pausedDuration;
        emit(state.copyWith(duration: elapsed));
      }
    });
  }

  void _addTrackPoint(Position position) {
    final point = data.TrackPoint(
      latitude: position.latitude,
      longitude: position.longitude,
      altitude: position.altitude,
      timestamp: position.timestamp,
      speed: position.speed,
    );

    try {
      _trackRepository.addPoint(state.currentTrack!.id, point);
    } catch (_) {}

    final currentPoint = LatLng(position.latitude, position.longitude);
    double newDistance = state.distance;
    if (_lastPosition != null) {
      newDistance += _haversine(_lastPosition!, currentPoint);
    }
    _lastPosition = currentPoint;

    emit(state.copyWith(
      pointsCount: state.pointsCount + 1,
      distance: newDistance,
      currentSpeed: position.speed,
    ));
  }

  double _haversine(LatLng a, LatLng b) {
    const r = 6371000.0;
    final dLat = _toRad(b.latitude - a.latitude);
    final dLon = _toRad(b.longitude - a.longitude);
    final lat1 = _toRad(a.latitude);
    final lat2 = _toRad(b.latitude);
    final h = sin(dLat / 2) * sin(dLat / 2) + cos(lat1) * cos(lat2) * sin(dLon / 2) * sin(dLon / 2);
    return 2 * r * asin(sqrt(h));
  }

  double _toRad(double deg) => deg * pi / 180;

  @override
  Future<void> close() {
    _positionSubscription?.cancel();
    _durationTimer?.cancel();
    return super.close();
  }
}
