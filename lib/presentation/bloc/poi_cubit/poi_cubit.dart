import 'package:collection/collection.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:uuid/uuid.dart';

import '../../../data/models/poi_model.dart';
import '../../../data/repositories/poi_repository.dart';
import 'poi_state.dart';

class PoiCubit extends Cubit<PoiState> {
  final PoiRepository _poiRepository;

  PoiCubit(this._poiRepository) : super(const PoiState());

  Future<void> loadPois() async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      final pois = await _poiRepository.getAllPois();
      emit(state.copyWith(isLoading: false, pois: pois));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> loadPoisByFolder(String folderId) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      final pois = await _poiRepository.getPoisByFolder(folderId);
      emit(state.copyWith(isLoading: false, pois: pois));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> addPoi(PoiModel poi) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      await _poiRepository.addPoi(poi);
      final pois = await _poiRepository.getAllPois();
      emit(state.copyWith(isLoading: false, pois: pois));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> updatePoi(PoiModel poi) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      await _poiRepository.updatePoi(poi);
      final pois = await _poiRepository.getAllPois();
      emit(state.copyWith(isLoading: false, pois: pois));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> deletePoi(String poiId) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      await _poiRepository.deletePoi(poiId);
      final pois = await _poiRepository.getAllPois();
      emit(state.copyWith(
        isLoading: false,
        pois: pois,
        clearSelectedPoi: state.selectedPoi?.id == poiId,
      ));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> toggleFavorite(String poiId) async {
    try {
      await _poiRepository.toggleFavorite(poiId);
      final pois = await _poiRepository.getAllPois();
      final updatedSelected = state.selectedPoi?.id == poiId
          ? pois.firstWhereOrNull((p) => p.id == poiId)
          : state.selectedPoi;
      emit(state.copyWith(
        pois: pois,
        selectedPoi: updatedSelected,
      ));
    } catch (e) {
      emit(state.copyWith(error: e.toString()));
    }
  }

  Future<List<PoiModel>> searchPois(String query) async {
    if (query.isEmpty) return state.pois;
    try {
      return await _poiRepository.searchPois(query);
    } catch (e) {
      return [];
    }
  }

  void selectPoi(PoiModel? poi) {
    emit(state.copyWith(
      selectedPoi: poi,
      clearSelectedPoi: poi == null,
    ));
  }

  PoiModel createNewPoi({
    required String name,
    required double latitude,
    required double longitude,
    String description = '',
    String note = '',
    int color = 0xFF4CAF50,
    String iconKey = 'default',
    String? folderId,
    List<String> images = const [],
  }) {
    final now = DateTime.now();
    return PoiModel(
      id: const Uuid().v4(),
      name: name,
      description: description,
      latitude: latitude,
      longitude: longitude,
      color: color,
      iconKey: iconKey,
      folderId: folderId,
      images: images,
      createdAt: now,
      updatedAt: now,
    );
  }
}
