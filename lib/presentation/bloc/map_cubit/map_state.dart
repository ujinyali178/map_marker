import 'package:equatable/equatable.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';

enum MapTypeOption { osm, google, satellite, terrain, hybrid }

class MapState extends Equatable {
  final LatLng cameraPosition;
  final double zoom;
  final MapTypeOption mapType;
  final List<Marker> markers;
  final List<Polyline> polylines;
  final LatLng? currentLocation;
  final double heading;
  final bool isLoading;
  final String? error;

  const MapState({
    this.cameraPosition = const LatLng(-6.2088, 106.8456),
    this.zoom = 14.0,
    this.mapType = MapTypeOption.osm,
    this.markers = const <Marker>[],
    this.polylines = const <Polyline>[],
    this.currentLocation,
    this.heading = 0,
    this.isLoading = false,
    this.error,
  });

  MapState copyWith({
    LatLng? cameraPosition,
    double? zoom,
    MapTypeOption? mapType,
    List<Marker>? markers,
    List<Polyline>? polylines,
    LatLng? currentLocation,
    double? heading,
    bool? isLoading,
    String? error,
    bool clearError = false,
    bool clearCurrentLocation = false,
  }) {
    return MapState(
      cameraPosition: cameraPosition ?? this.cameraPosition,
      zoom: zoom ?? this.zoom,
      mapType: mapType ?? this.mapType,
      markers: markers ?? this.markers,
      polylines: polylines ?? this.polylines,
      currentLocation: clearCurrentLocation ? null : (currentLocation ?? this.currentLocation),
      heading: heading ?? this.heading,
      isLoading: isLoading ?? this.isLoading,
      error: clearError ? null : (error ?? this.error),
    );
  }

  @override
  List<Object?> get props => [
        cameraPosition,
        zoom,
        mapType,
        markers,
        polylines,
        currentLocation,
        heading,
        isLoading,
        error,
      ];
}
