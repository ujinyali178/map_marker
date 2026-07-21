import 'package:equatable/equatable.dart';

import '../../../data/models/poi_model.dart';

export '../../../data/models/poi_model.dart' show PoiModel;

class PoiState extends Equatable {
  final List<PoiModel> pois;
  final bool isLoading;
  final String? error;
  final PoiModel? selectedPoi;

  const PoiState({
    this.pois = const [],
    this.isLoading = false,
    this.error,
    this.selectedPoi,
  });

  PoiState copyWith({
    List<PoiModel>? pois,
    bool? isLoading,
    String? error,
    PoiModel? selectedPoi,
    bool clearError = false,
    bool clearSelectedPoi = false,
  }) {
    return PoiState(
      pois: pois ?? this.pois,
      isLoading: isLoading ?? this.isLoading,
      error: clearError ? null : (error ?? this.error),
      selectedPoi: clearSelectedPoi ? null : (selectedPoi ?? this.selectedPoi),
    );
  }

  @override
  List<Object?> get props => [pois, isLoading, error, selectedPoi];
}
