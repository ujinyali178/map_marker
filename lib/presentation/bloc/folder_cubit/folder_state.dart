import 'package:equatable/equatable.dart';

import '../../../data/models/folder_model.dart';

export '../../../data/models/folder_model.dart' show FolderModel;

class FolderState extends Equatable {
  final List<FolderModel> folders;
  final bool isLoading;
  final String? error;

  const FolderState({
    this.folders = const [],
    this.isLoading = false,
    this.error,
  });

  FolderState copyWith({
    List<FolderModel>? folders,
    bool? isLoading,
    String? error,
    bool clearError = false,
  }) {
    return FolderState(
      folders: folders ?? this.folders,
      isLoading: isLoading ?? this.isLoading,
      error: clearError ? null : (error ?? this.error),
    );
  }

  @override
  List<Object?> get props => [folders, isLoading, error];
}
