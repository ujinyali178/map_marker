import 'package:equatable/equatable.dart';

import '../map_cubit/map_state.dart';

enum DistanceUnit { km, miles }
enum ThemeModeOption { light, dark, system }

class SettingsState extends Equatable {
  final MapTypeOption mapType;
  final double defaultZoom;
  final DistanceUnit distanceUnit;
  final bool showLabels;
  final bool showPoiImages;
  final bool offlineMapsEnabled;
  final bool autoSync;
  final ThemeModeOption themeMode;

  const SettingsState({
    this.mapType = MapTypeOption.osm,
    this.defaultZoom = 14.0,
    this.distanceUnit = DistanceUnit.km,
    this.showLabels = true,
    this.showPoiImages = true,
    this.offlineMapsEnabled = false,
    this.autoSync = true,
    this.themeMode = ThemeModeOption.system,
  });

  SettingsState copyWith({
    MapTypeOption? mapType,
    double? defaultZoom,
    DistanceUnit? distanceUnit,
    bool? showLabels,
    bool? showPoiImages,
    bool? offlineMapsEnabled,
    bool? autoSync,
    ThemeModeOption? themeMode,
  }) {
    return SettingsState(
      mapType: mapType ?? this.mapType,
      defaultZoom: defaultZoom ?? this.defaultZoom,
      distanceUnit: distanceUnit ?? this.distanceUnit,
      showLabels: showLabels ?? this.showLabels,
      showPoiImages: showPoiImages ?? this.showPoiImages,
      offlineMapsEnabled: offlineMapsEnabled ?? this.offlineMapsEnabled,
      autoSync: autoSync ?? this.autoSync,
      themeMode: themeMode ?? this.themeMode,
    );
  }

  @override
  List<Object?> get props => [
        mapType,
        defaultZoom,
        distanceUnit,
        showLabels,
        showPoiImages,
        offlineMapsEnabled,
        autoSync,
        themeMode,
      ];
}
