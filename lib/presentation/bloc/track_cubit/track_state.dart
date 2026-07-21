import 'package:equatable/equatable.dart';

import '../../../data/models/track_model.dart';
import '../../../data/models/track_point.dart' as data;

export '../../../data/models/track_model.dart' show TrackModel;
export '../../../data/models/track_point.dart' show TrackPoint;

class TrackState extends Equatable {
  final bool isRecording;
  final bool isPaused;
  final TrackModel? currentTrack;
  final int pointsCount;
  final double distance;
  final Duration duration;
  final double currentSpeed;
  final List<TrackModel> savedTracks;
  final bool isLoading;
  final String? error;

  const TrackState({
    this.isRecording = false,
    this.isPaused = false,
    this.currentTrack,
    this.pointsCount = 0,
    this.distance = 0.0,
    this.duration = Duration.zero,
    this.currentSpeed = 0.0,
    this.savedTracks = const [],
    this.isLoading = false,
    this.error,
  });

  TrackState copyWith({
    bool? isRecording,
    bool? isPaused,
    TrackModel? currentTrack,
    int? pointsCount,
    double? distance,
    Duration? duration,
    double? currentSpeed,
    List<TrackModel>? savedTracks,
    bool? isLoading,
    String? error,
    bool clearError = false,
  }) {
    return TrackState(
      isRecording: isRecording ?? this.isRecording,
      isPaused: isPaused ?? this.isPaused,
      currentTrack: currentTrack ?? this.currentTrack,
      pointsCount: pointsCount ?? this.pointsCount,
      distance: distance ?? this.distance,
      duration: duration ?? this.duration,
      currentSpeed: currentSpeed ?? this.currentSpeed,
      savedTracks: savedTracks ?? this.savedTracks,
      isLoading: isLoading ?? this.isLoading,
      error: clearError ? null : (error ?? this.error),
    );
  }

  String get distanceFormatted {
    if (distance >= 1000) return '${(distance / 1000).toStringAsFixed(2)} km';
    return '${distance.toStringAsFixed(0)} m';
  }

  String get durationFormatted {
    final hours = duration.inHours;
    final minutes = duration.inMinutes.remainder(60);
    final seconds = duration.inSeconds.remainder(60);
    if (hours > 0) {
      return '${hours.toString().padLeft(2, '0')}:${minutes.toString().padLeft(2, '0')}:${seconds.toString().padLeft(2, '0')}';
    }
    return '${minutes.toString().padLeft(2, '0')}:${seconds.toString().padLeft(2, '0')}';
  }

  @override
  List<Object?> get props => [
    isRecording, isPaused, currentTrack, pointsCount, distance, duration,
    currentSpeed, savedTracks, isLoading, error,
  ];
}
