import 'package:drift/drift.dart';

import '../models/sync_model.dart';
import '../sources/local/app_database.dart';

class SyncRepository {
  final AppDatabase _database;

  SyncRepository(this._database);

  Future<SyncState> getSyncState() async {
    try {
      final row = await _database.getSyncState();
      if (row == null) {
        return const SyncState();
      }
      return _rowToModel(row);
    } catch (e) {
      throw SyncRepositoryException('Failed to fetch sync state: $e');
    }
  }

  Stream<SyncState?> watchSyncState() {
    return _database.watchSyncState().map((row) {
      if (row == null) return null;
      return _rowToModel(row);
    });
  }

  Future<void> updateSyncState(SyncState state) async {
    try {
      await _database.updateSyncState(_modelToCompanion(state));
    } catch (e) {
      throw SyncRepositoryException('Failed to update sync state: $e');
    }
  }

  SyncState _rowToModel(SyncStateTableData row) {
    return SyncState(
      interfaceType: _parseInterfaceType(row.interfaceType),
      accountName: row.accountName,
      cloudFolderId: row.cloudFolderId,
      lastSyncTime: row.lastSyncTime != null
          ? DateTime.fromMillisecondsSinceEpoch(row.lastSyncTime!)
          : null,
      hasRemoteChanges: row.hasRemoteChanges == 1,
      isReadOnly: row.isReadOnly == 1,
      shareUrl: row.shareUrl,
    );
  }

  SyncStateTableCompanion _modelToCompanion(SyncState model) {
    return SyncStateTableCompanion(
      interfaceType: Value(model.interfaceType.name),
      accountName: Value(model.accountName),
      cloudFolderId: Value(model.cloudFolderId),
      lastSyncTime: model.lastSyncTime != null
          ? Value(model.lastSyncTime!.millisecondsSinceEpoch)
          : const Value.absent(),
      hasRemoteChanges: Value(model.hasRemoteChanges ? 1 : 0),
      isReadOnly: Value(model.isReadOnly ? 1 : 0),
      shareUrl: Value(model.shareUrl),
    );
  }

  SyncInterfaceType _parseInterfaceType(String value) {
    return SyncInterfaceType.values.firstWhere(
      (e) => e.name == value,
      orElse: () => SyncInterfaceType.none,
    );
  }
}

class SyncRepositoryException implements Exception {
  final String message;
  SyncRepositoryException(this.message);

  @override
  String toString() => 'SyncRepositoryException: $message';
}
