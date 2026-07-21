import 'package:equatable/equatable.dart';
import 'package:latlong2/latlong.dart';

class RouteResult extends Equatable {
  final List<LatLng> points;
  final double distanceMeters;
  final int durationSeconds;
  final String polylineEncoded;

  const RouteResult({
    this.points = const [],
    this.distanceMeters = 0.0,
    this.durationSeconds = 0,
    this.polylineEncoded = '',
  });

  RouteResult copyWith({
    List<LatLng>? points,
    double? distanceMeters,
    int? durationSeconds,
    String? polylineEncoded,
  }) {
    return RouteResult(
      points: points ?? this.points,
      distanceMeters: distanceMeters ?? this.distanceMeters,
      durationSeconds: durationSeconds ?? this.durationSeconds,
      polylineEncoded: polylineEncoded ?? this.polylineEncoded,
    );
  }

  factory RouteResult.fromJson(Map<String, dynamic> json) {
    return RouteResult(
      points: (json['points'] as List<dynamic>?)
              ?.map((e) => LatLng(
                    (e['latitude'] as num).toDouble(),
                    (e['longitude'] as num).toDouble(),
                  ))
              .toList() ??
          [],
      distanceMeters: (json['distanceMeters'] as num?)?.toDouble() ?? 0.0,
      durationSeconds: json['durationSeconds'] as int? ?? 0,
      polylineEncoded: json['polylineEncoded'] as String? ?? '',
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'points': points
          .map((e) => {'latitude': e.latitude, 'longitude': e.longitude})
          .toList(),
      'distanceMeters': distanceMeters,
      'durationSeconds': durationSeconds,
      'polylineEncoded': polylineEncoded,
    };
  }

  String get formattedDistance {
    if (distanceMeters < 1000) {
      return '${distanceMeters.round()} m';
    }
    return '${(distanceMeters / 1000).toStringAsFixed(1)} km';
  }

  String get formattedDuration {
    final hours = durationSeconds ~/ 3600;
    final minutes = (durationSeconds % 3600) ~/ 60;
    if (hours > 0) {
      return '${hours}h ${minutes}m';
    }
    return '${minutes}m';
  }

  @override
  List<Object?> get props => [
        points,
        distanceMeters,
        durationSeconds,
        polylineEncoded,
      ];
}
