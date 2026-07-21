import 'package:drift/drift.dart';

import '../models/folder_model.dart';
import '../sources/local/app_database.dart';

class FolderRepository {
  final AppDatabase _database;

  FolderRepository(this._database);

  Future<List<FolderModel>> getAllFolders() async {
    try {
      final rows = await _database.getAllFolders();
      return rows.map(_rowToModel).toList();
    } catch (e) {
      throw FolderRepositoryException('Failed to fetch folders: $e');
    }
  }

  Stream<List<FolderModel>> watchAllFolders() {
    return _database
        .watchAllFolders()
        .map((rows) => rows.map(_rowToModel).toList());
  }

  Future<void> addFolder(FolderModel folder) async {
    try {
      await _database.insertFolder(_modelToCompanion(folder));
    } catch (e) {
      throw FolderRepositoryException('Failed to add folder: $e');
    }
  }

  Future<void> updateFolder(FolderModel folder) async {
    try {
      final success = await _database.updateFolder(_modelToCompanion(folder));
      if (!success) {
        throw FolderRepositoryException('Folder not found for update');
      }
    } catch (e) {
      if (e is FolderRepositoryException) rethrow;
      throw FolderRepositoryException('Failed to update folder: $e');
    }
  }

  Future<void> deleteFolder(String id) async {
    try {
      final deleted = await _database.deleteFolder(id);
      if (deleted == 0) {
        throw FolderRepositoryException('Folder not found for deletion');
      }
    } catch (e) {
      if (e is FolderRepositoryException) rethrow;
      throw FolderRepositoryException('Failed to delete folder: $e');
    }
  }

  Future<int> getPoisCount(String folderId) async {
    try {
      return await _database.getPoisCountByFolder(folderId);
    } catch (e) {
      throw FolderRepositoryException('Failed to get POIs count: $e');
    }
  }

  FolderModel _rowToModel(FolderTableData row) {
    return FolderModel(
      id: row.id,
      name: row.name,
      color: row.color,
      parentId: row.parentId,
      createdAt: DateTime.fromMillisecondsSinceEpoch(row.createdAt),
      sortOrder: row.sortOrder,
    );
  }

  FolderTableCompanion _modelToCompanion(FolderModel model) {
    return FolderTableCompanion(
      id: Value(model.id),
      name: Value(model.name),
      color: Value(model.color),
      parentId: Value(model.parentId),
      createdAt: Value(model.createdAt.millisecondsSinceEpoch),
      sortOrder: Value(model.sortOrder),
    );
  }
}

class FolderRepositoryException implements Exception {
  final String message;
  FolderRepositoryException(this.message);

  @override
  String toString() => 'FolderRepositoryException: $message';
}
