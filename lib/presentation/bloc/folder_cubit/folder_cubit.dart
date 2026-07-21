import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:uuid/uuid.dart';

import '../../../data/models/folder_model.dart';
import '../../../data/repositories/folder_repository.dart';
import '../../../data/repositories/poi_repository.dart';
import 'folder_state.dart';

class FolderCubit extends Cubit<FolderState> {
  final FolderRepository _folderRepository;
  final PoiRepository _poiRepository;

  FolderCubit(this._folderRepository, this._poiRepository)
      : super(const FolderState());

  Future<void> loadFolders() async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      final folders = await _folderRepository.getAllFolders();
      emit(state.copyWith(isLoading: false, folders: folders));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> addFolder(FolderModel folder) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      await _folderRepository.addFolder(folder);
      final folders = await _folderRepository.getAllFolders();
      emit(state.copyWith(isLoading: false, folders: folders));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> updateFolder(FolderModel folder) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      await _folderRepository.updateFolder(folder);
      final folders = await _folderRepository.getAllFolders();
      emit(state.copyWith(isLoading: false, folders: folders));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  Future<void> deleteFolder(String folderId) async {
    emit(state.copyWith(isLoading: true, clearError: true));
    try {
      await _poiRepository.clearFolderForPois(folderId);
      await _folderRepository.deleteFolder(folderId);
      final folders = await _folderRepository.getAllFolders();
      emit(state.copyWith(isLoading: false, folders: folders));
    } catch (e) {
      emit(state.copyWith(isLoading: false, error: e.toString()));
    }
  }

  FolderModel createNewFolder({
    required String name,
    int color = 0xFF757575,
    String? parentId,
  }) {
    final now = DateTime.now();
    return FolderModel(
      id: const Uuid().v4(),
      name: name,
      color: color,
      parentId: parentId,
      createdAt: now,
    );
  }
}
