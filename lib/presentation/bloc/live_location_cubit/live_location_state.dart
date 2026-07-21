import 'package:equatable/equatable.dart';
import 'package:latlong2/latlong.dart';

class LiveLocationState extends Equatable {
  final bool isSharing;
  final LatLng? currentLocation;
  final double? accuracy;
  final String? shareLink;
  final Duration duration;
  final String? error;

  const LiveLocationState({
    this.isSharing = false,
    this.currentLocation,
    this.accuracy,
    this.shareLink,
    this.duration = Duration.zero,
    this.error,
  });

  LiveLocationState copyWith({
    bool? isSharing,
    LatLng? currentLocation,
    double? accuracy,
    String? shareLink,
    Duration? duration,
    String? error,
    bool clearError = false,
    bool clearLocation = false,
    bool clearShareLink = false,
  }) {
    return LiveLocationState(
      isSharing: isSharing ?? this.isSharing,
      currentLocation:
          clearLocation ? null : (currentLocation ?? this.currentLocation),
      accuracy: accuracy ?? this.accuracy,
      shareLink: clearShareLink ? null : (shareLink ?? this.shareLink),
      duration: duration ?? this.duration,
      error: clearError ? null : (error ?? this.error),
    );
  }

  String get durationFormatted {
    final hours = duration.inHours;
    final minutes = duration.inMinutes.remainder(60);
    final seconds = duration.inSeconds.remainder(60);
    if (hours > 0) {
      return '${hours}h ${minutes}m ${seconds}s';
    }
    return '${minutes}m ${seconds}s';
  }

  @override
  List<Object?> get props => [
        isSharing,
        currentLocation,
        accuracy,
        shareLink,
        duration,
        error,
      ];
}
