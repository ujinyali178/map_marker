import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../map_cubit/map_state.dart';
import 'settings_state.dart';

class SettingsCubit extends Cubit<SettingsState> {
  static const _keyMapType = 'settings_map_type';
  static const _keyDefaultZoom = 'settings_default_zoom';
  static const _keyDistanceUnit = 'settings_distance_unit';
  static const _keyShowLabels = 'settings_show_labels';
  static const _keyShowPoiImages = 'settings_show_poi_images';
  static const _keyOfflineMaps = 'settings_offline_maps';
  static const _keyAutoSync = 'settings_auto_sync';
  static const _keyThemeMode = 'settings_theme_mode';

  SettingsCubit() : super(const SettingsState());

  Future<void> loadSettings() async {
    final prefs = await SharedPreferences.getInstance();

    final mapTypeIndex = prefs.getInt(_keyMapType) ?? MapTypeOption.google.index;
    final defaultZoom = prefs.getDouble(_keyDefaultZoom) ?? 14.0;
    final distanceUnitIndex =
        prefs.getInt(_keyDistanceUnit) ?? DistanceUnit.km.index;
    final showLabels = prefs.getBool(_keyShowLabels) ?? true;
    final showPoiImages = prefs.getBool(_keyShowPoiImages) ?? true;
    final offlineMaps = prefs.getBool(_keyOfflineMaps) ?? false;
    final autoSync = prefs.getBool(_keyAutoSync) ?? true;
    final themeModeIndex = prefs.getInt(_keyThemeMode) ?? ThemeModeOption.system.index;

    emit(SettingsState(
      mapType: MapTypeOption.values[mapTypeIndex.clamp(0, MapTypeOption.values.length - 1)],
      defaultZoom: defaultZoom,
      distanceUnit: DistanceUnit.values[distanceUnitIndex.clamp(0, DistanceUnit.values.length - 1)],
      showLabels: showLabels,
      showPoiImages: showPoiImages,
      offlineMapsEnabled: offlineMaps,
      autoSync: autoSync,
      themeMode: ThemeModeOption.values[themeModeIndex.clamp(0, ThemeModeOption.values.length - 1)],
    ));
  }

  Future<void> updateMapType(MapTypeOption mapType) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt(_keyMapType, mapType.index);
    emit(state.copyWith(mapType: mapType));
  }

  Future<void> updateDefaultZoom(double zoom) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setDouble(_keyDefaultZoom, zoom);
    emit(state.copyWith(defaultZoom: zoom));
  }

  Future<void> updateDistanceUnit(DistanceUnit unit) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt(_keyDistanceUnit, unit.index);
    emit(state.copyWith(distanceUnit: unit));
  }

  Future<void> updateShowLabels(bool show) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyShowLabels, show);
    emit(state.copyWith(showLabels: show));
  }

  Future<void> updateShowPoiImages(bool show) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyShowPoiImages, show);
    emit(state.copyWith(showPoiImages: show));
  }

  Future<void> updateOfflineMaps(bool enabled) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyOfflineMaps, enabled);
    emit(state.copyWith(offlineMapsEnabled: enabled));
  }

  Future<void> updateAutoSync(bool enabled) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setBool(_keyAutoSync, enabled);
    emit(state.copyWith(autoSync: enabled));
  }

  Future<void> updateThemeMode(ThemeModeOption mode) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt(_keyThemeMode, mode.index);
    emit(state.copyWith(themeMode: mode));
  }
}
