import 'package:equatable/equatable.dart';

class TrackPoint extends Equatable {
  final double latitude;
  final double longitude;
  final double? altitude;
  final DateTime timestamp;
  final double? speed;

  const TrackPoint({
    required this.latitude,
    required this.longitude,
    this.altitude,
    required this.timestamp,
    this.speed,
  });

  TrackPoint copyWith({
    double? latitude,
    double? longitude,
    double? altitude,
    DateTime? timestamp,
    double? speed,
  }) {
    return TrackPoint(
      latitude: latitude ?? this.latitude,
      longitude: longitude ?? this.longitude,
      altitude: altitude ?? this.altitude,
      timestamp: timestamp ?? this.timestamp,
      speed: speed ?? this.speed,
    );
  }

  factory TrackPoint.fromJson(Map<String, dynamic> json) {
    return TrackPoint(
      latitude: (json['latitude'] as num).toDouble(),
      longitude: (json['longitude'] as num).toDouble(),
      altitude: (json['altitude'] as num?)?.toDouble(),
      timestamp: DateTime.parse(json['timestamp'] as String),
      speed: (json['speed'] as num?)?.toDouble(),
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'latitude': latitude,
      'longitude': longitude,
      'altitude': altitude,
      'timestamp': timestamp.toIso8601String(),
      'speed': speed,
    };
  }

  @override
  List<Object?> get props => [latitude, longitude, altitude, timestamp, speed];
}
