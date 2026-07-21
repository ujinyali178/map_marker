import 'dart:math';

import 'package:equatable/equatable.dart';
import 'package:latlong2/latlong.dart';

class NavStep extends Equatable {
  final String instruction;
  final double distance;
  final double duration;
  final String? modifier;
  final String? mode;
  final List<LatLng> geometry;

  const NavStep({
    required this.instruction,
    required this.distance,
    required this.duration,
    this.modifier,
    this.mode,
    this.geometry = const [],
  });

  @override
  List<Object?> get props =>
      [instruction, distance, duration, modifier, mode, geometry];
}

class NavDestination extends Equatable {
  final String id;
  final String name;
  final double latitude;
  final double longitude;

  const NavDestination({
    required this.id,
    required this.name,
    required this.latitude,
    required this.longitude,
  });

  @override
  List<Object?> get props => [id, name, latitude, longitude];
}

class NavState extends Equatable {
  final bool isActive;
  final NavDestination? destinationPoi;
  final List<LatLng> routePoints;
  final double routeDistance;
  final double routeDuration;
  final double remainingDistance;
  final double remainingDuration;
  final int currentStep;
  final List<NavStep> steps;
  final String? error;

  const NavState({
    this.isActive = false,
    this.destinationPoi,
    this.routePoints = const [],
    this.routeDistance = 0.0,
    this.routeDuration = 0.0,
    this.remainingDistance = 0.0,
    this.remainingDuration = 0.0,
    this.currentStep = 0,
    this.steps = const [],
    this.error,
  });

  NavState copyWith({
    bool? isActive,
    NavDestination? destinationPoi,
    List<LatLng>? routePoints,
    double? routeDistance,
    double? routeDuration,
    double? remainingDistance,
    double? remainingDuration,
    int? currentStep,
    List<NavStep>? steps,
    String? error,
    bool clearError = false,
    bool clearDestination = false,
  }) {
    return NavState(
      isActive: isActive ?? this.isActive,
      destinationPoi:
          clearDestination ? null : (destinationPoi ?? this.destinationPoi),
      routePoints: routePoints ?? this.routePoints,
      routeDistance: routeDistance ?? this.routeDistance,
      routeDuration: routeDuration ?? this.routeDuration,
      remainingDistance: remainingDistance ?? this.remainingDistance,
      remainingDuration: remainingDuration ?? this.remainingDuration,
      currentStep: currentStep ?? this.currentStep,
      steps: steps ?? this.steps,
      error: clearError ? null : (error ?? this.error),
    );
  }

  double get remainingDistanceKm => remainingDistance / 1000.0;
  double get remainingDurationMin => remainingDuration / 60.0;
  double get routeDistanceKm => routeDistance / 1000.0;
  double get routeDurationMin => routeDuration / 60.0;

  @override
  List<Object?> get props => [
        isActive,
        destinationPoi,
        routePoints,
        routeDistance,
        routeDuration,
        remainingDistance,
        remainingDuration,
        currentStep,
        steps,
        error,
      ];
}
