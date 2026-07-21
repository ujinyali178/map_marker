import 'package:drift/drift.dart';

import '../models/sync_model.dart';
import '../sources/local/app_database.dart';

class SyncRepository {
  final AppDatabase _database;

  SyncRepository(this._database);

  Future<SyncModel> getSyncState() async {
    try {
      final row = await _database.getSyncState();
      if (row == null) {
        return const SyncModel();
      }
      return _rowToModel(row);
    } catch (e) {
      throw SyncRepositoryException('Failed to fetch sync state: $e');
    }
  }

  Stream<SyncModel?> watchSyncState() {
    return _database.watchSyncState().map((row) {
      if (row == null) return null;
      return _rowToModel(row);
    });
  }

  Future<void> updateSyncState(SyncModel state) async {
    try {
      await _database.updateSyncState(_modelToCompanion(state));
    } catch (e) {
      throw SyncRepositoryException('Failed to update sync state: $e');
    }
  }

  SyncModel _rowToModel(SyncStateTableData row) {
    return SyncModel(
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

  SyncStateTableCompanion _modelToCompanion(SyncModel model) {
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

  SyncStateInterfaceType _parseInterfaceType(String value) {
    return SyncStateInterfaceType.values.firstWhere(
      (e) => e.name == value,
      orElse: () => SyncStateInterfaceType.none,
    );
  }
}

class SyncRepositoryException implements Exception {
  final String message;
  SyncRepositoryException(this.message);

  @override
  String toString() => 'SyncRepositoryException: $message';
}
