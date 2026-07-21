import 'dart:async';

import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:uuid/uuid.dart';

import '../../../data/models/poi_model.dart';
import '../../../data/repositories/poi_repository.dart';
import 'poi_state.dart';

class PoiCubit extends Cubit<PoiState> {
  final PoiRepository _poiRepository;
  StreamSubscription<List<PoiModel>>? _poisSubscription;

  PoiCubit(this._poiRepository) : super(const PoiState());

  Future<void> loadPois() async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      _poisSubscription?.cancel();
      _poisSubscription = _poiRepository.watchAllPois().listen(
        (pois) {
          emit(state.copyWith(isLoading: false, pois: pois));
        },
        onError: (e) {
          emit(state.copyWith(isLoading: false, error: e.toString()));
        },
      );
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> loadPoisByFolder(String folderId) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      _poisSubscription?.cancel();
      _poisSubscription =
          _poiRepository.watchPoisByFolder(folderId).listen(
        (pois) {
          emit(state.copyWith(isLoading: false, pois: pois));
        },
        onError: (e) {
          emit(state.copyWith(isLoading: false, error: e.toString()));
        },
      );
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> addPoi(PoiModel poi) async {
    try {
      await _poiRepository.addPoi(poi);
    } catch (e) {
      emit(state.copyWith(error: e.toString()));
    }
  }

  Future<void> updatePoi(PoiModel poi) async {
    try {
      await _poiRepository.updatePoi(poi);
    } catch (e) {
      emit(state.copyWith(error: e.toString()));
    }
  }

  Future<void> deletePoi(String poiId) async {
    try {
      await _poiRepository.deletePoi(poiId);
      if (state.selectedPoi?.id == poiId) {
        emit(state.copyWith(clearSelectedPoi: true));
      }
    } catch (e) {
      emit(state.copyWith(error: e.toString()));
    }
  }

  Future<void> toggleFavorite(String poiId) async {
    try {
      await _poiRepository.toggleFavorite(poiId);
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

  @override
  Future<void> close() {
    _poisSubscription?.cancel();
    return super.close();
  }
}
