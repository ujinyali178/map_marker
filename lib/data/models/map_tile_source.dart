import 'package:equatable/equatable.dart';

enum MapTileProvider {
  osm,
  google,
  satellite,
  terrain,
  hybrid,
}

class MapTileSource extends Equatable {
  final String id;
  final String name;
  final String urlTemplate;
  final String attribution;
  final MapTileProvider provider;
  final bool isDefault;

  const MapTileSource({
    required this.id,
    required this.name,
    required this.urlTemplate,
    this.attribution = '',
    required this.provider,
    this.isDefault = false,
  });

  MapTileSource copyWith({
    String? id,
    String? name,
    String? urlTemplate,
    String? attribution,
    MapTileProvider? provider,
    bool? isDefault,
  }) {
    return MapTileSource(
      id: id ?? this.id,
      name: name ?? this.name,
      urlTemplate: urlTemplate ?? this.urlTemplate,
      attribution: attribution ?? this.attribution,
      provider: provider ?? this.provider,
      isDefault: isDefault ?? this.isDefault,
    );
  }

  factory MapTileSource.fromJson(Map<String, dynamic> json) {
    return MapTileSource(
      id: json['id'] as String,
      name: json['name'] as String,
      urlTemplate: json['urlTemplate'] as String,
      attribution: json['attribution'] as String? ?? '',
      provider: _parseProvider(json['provider'] as String?),
      isDefault: json['isDefault'] as bool? ?? false,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'urlTemplate': urlTemplate,
      'attribution': attribution,
      'provider': provider.name,
      'isDefault': isDefault,
    };
  }

  static MapTileProvider _parseProvider(String? value) {
    if (value == null) return MapTileProvider.osm;
    return MapTileProvider.values.firstWhere(
      (e) => e.name == value,
      orElse: () => MapTileProvider.osm,
    );
  }

  static const osmDefault = MapTileSource(
    id: 'osm-standard',
    name: 'OpenStreetMap',
    urlTemplate: 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
    attribution: '&copy; OpenStreetMap contributors',
    provider: MapTileProvider.osm,
    isDefault: true,
  );

  static const satelliteDefault = MapTileSource(
    id: 'esri-satellite',
    name: 'Satellite',
    urlTemplate:
        'https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}',
    attribution: '&copy; Esri',
    provider: MapTileProvider.satellite,
  );

  static const terrainDefault = MapTileSource(
    id: 'stamen-terrain',
    name: 'Terrain',
    urlTemplate:
        'https://tiles.stadiamaps.com/tiles/stamen_terrain/{z}/{x}/{y}.png',
    attribution: '&copy; Stadia Maps',
    provider: MapTileProvider.terrain,
  );

  @override
  List<Object?> get props => [
        id,
        name,
        urlTemplate,
        attribution,
        provider,
        isDefault,
      ];
}
