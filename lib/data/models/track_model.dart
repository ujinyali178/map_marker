import 'package:equatable/equatable.dart';

import 'track_point.dart';

class TrackModel extends Equatable {
  final String id;
  final String name;
  final List<TrackPoint> points;
  final DateTime startedAt;
  final DateTime? finishedAt;
  final double distanceMeters;

  const TrackModel({
    required this.id,
    required this.name,
    this.points = const [],
    required this.startedAt,
    this.finishedAt,
    this.distanceMeters = 0.0,
  });

  TrackModel copyWith({
    String? id,
    String? name,
    List<TrackPoint>? points,
    DateTime? startedAt,
    DateTime? finishedAt,
    double? distanceMeters,
  }) {
    return TrackModel(
      id: id ?? this.id,
      name: name ?? this.name,
      points: points ?? this.points,
      startedAt: startedAt ?? this.startedAt,
      finishedAt: finishedAt ?? this.finishedAt,
      distanceMeters: distanceMeters ?? this.distanceMeters,
    );
  }

  factory TrackModel.fromJson(Map<String, dynamic> json) {
    return TrackModel(
      id: json['id'] as String,
      name: json['name'] as String,
      points: (json['points'] as List<dynamic>?)
              ?.map((e) => TrackPoint.fromJson(e as Map<String, dynamic>))
              .toList() ??
          [],
      startedAt: DateTime.parse(json['startedAt'] as String),
      finishedAt: json['finishedAt'] != null
          ? DateTime.parse(json['finishedAt'] as String)
          : null,
      distanceMeters: (json['distanceMeters'] as num?)?.toDouble() ?? 0.0,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'points': points.map((e) => e.toJson()).toList(),
      'startedAt': startedAt.toIso8601String(),
      'finishedAt': finishedAt?.toIso8601String(),
      'distanceMeters': distanceMeters,
    };
  }

  bool get isRecording => finishedAt == null;

  Duration get duration =>
      (finishedAt ?? DateTime.now()).difference(startedAt);

  @override
  List<Object?> get props => [
        id,
        name,
        points,
        startedAt,
        finishedAt,
        distanceMeters,
      ];
}
