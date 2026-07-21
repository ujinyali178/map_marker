import 'dart:async';

import 'package:flutter_bloc/flutter_bloc.dart';

import '../../../data/repositories/sync_repository.dart';
import 'sync_state.dart';

class SyncCubit extends Cubit<SyncState> {
  final SyncRepository _syncRepository;

  SyncCubit(this._syncRepository) : super(const SyncState());

  Future<void> loadState() async {
    try {
      final syncModel = await _syncRepository.getSyncState();
      emit(SyncState(
        isConnected: syncModel.isConnected,
        interfaceType: syncModel.interfaceType,
        accountName: syncModel.accountName.isNotEmpty ? syncModel.accountName : null,
        lastSyncTime: syncModel.lastSyncTime,
      ));
    } catch (_) {}
  }

  Future<void> connectToGoogleDrive() async {
    emit(state.copyWith(isConnected: false, clearError: true));
    try {
      await Future.delayed(const Duration(seconds: 1));
      emit(state.copyWith(
        isConnected: true,
        interfaceType: SyncInterfaceType.googleDrive,
        accountName: 'user@gmail.com',
      ));
    } catch (e) {
      emit(state.copyWith(isConnected: false, error: 'Failed to connect to Google Drive: $e'));
    }
  }

  Future<void> connectToDropbox() async {
    emit(state.copyWith(isConnected: false, clearError: true));
    try {
      await Future.delayed(const Duration(seconds: 1));
      emit(state.copyWith(
        isConnected: true,
        interfaceType: SyncInterfaceType.dropbox,
        accountName: 'user@dropbox.com',
      ));
    } catch (e) {
      emit(state.copyWith(isConnected: false, error: 'Failed to connect to Dropbox: $e'));
    }
  }

  Future<void> syncNow() async {
    if (!state.isConnected || state.isSyncing) return;
    emit(state.copyWith(isSyncing: true, progress: 0.0, clearError: true));
    try {
      for (int i = 0; i <= 100; i += 10) {
        await Future.delayed(const Duration(milliseconds: 200));
        emit(state.copyWith(progress: i / 100.0));
      }
      emit(state.copyWith(isSyncing: false, progress: 1.0, lastSyncTime: DateTime.now()));
    } catch (e) {
      emit(state.copyWith(isSyncing: false, progress: 0.0, error: 'Sync failed: $e'));
    }
  }

  void disconnect() {
    emit(const SyncState());
  }
}
