import 'dart:convert';

import 'package:drift/drift.dart';

import '../models/poi_model.dart';
import '../sources/local/app_database.dart';

class PoiRepository {
  final AppDatabase _database;

  PoiRepository(this._database);

  Future<List<PoiModel>> getAllPois() async {
    try {
      final rows = await _database.getAllPois();
      return rows.map(_rowToModel).toList();
    } catch (e) {
      throw PoiRepositoryException('Failed to fetch POIs: $e');
    }
  }

  Future<List<PoiModel>> getPoisByFolder(String folderId) async {
    try {
      final rows = await _database.getPoisByFolder(folderId);
      return rows.map(_rowToModel).toList();
    } catch (e) {
      throw PoiRepositoryException('Failed to fetch POIs for folder: $e');
    }
  }

  Stream<List<PoiModel>> watchAllPois() {
    return _database.watchAllPois().map((rows) => rows.map(_rowToModel).toList());
  }

  Stream<List<PoiModel>> watchPoisByFolder(String folderId) {
    return _database
        .watchPoisByFolder(folderId)
        .map((rows) => rows.map(_rowToModel).toList());
  }

  Future<void> addPoi(PoiModel poi) async {
    try {
      await _database.insertPoi(_modelToCompanion(poi));
    } catch (e) {
      throw PoiRepositoryException('Failed to add POI: $e');
    }
  }

  Future<void> updatePoi(PoiModel poi) async {
    try {
      final updated = poi.copyWith(updatedAt: DateTime.now());
      final success = await _database.updatePoi(_modelToCompanion(updated));
      if (!success) {
        throw PoiRepositoryException('POI not found for update');
      }
    } catch (e) {
      if (e is PoiRepositoryException) rethrow;
      throw PoiRepositoryException('Failed to update POI: $e');
    }
  }

  Future<void> deletePoi(String id) async {
    try {
      final deleted = await _database.deletePoi(id);
      if (deleted == 0) {
        throw PoiRepositoryException('POI not found for deletion');
      }
    } catch (e) {
      if (e is PoiRepositoryException) rethrow;
      throw PoiRepositoryException('Failed to delete POI: $e');
    }
  }

  Future<List<PoiModel>> searchPois(String query) async {
    try {
      final rows = await _database.searchPois(query);
      return rows.map(_rowToModel).toList();
    } catch (e) {
      throw PoiRepositoryException('Failed to search POIs: $e');
    }
  }

  Future<void> toggleFavorite(String id) async {
    try {
      final poi = await _database.getPoiById(id);
      if (poi == null) {
        throw PoiRepositoryException('POI not found for toggling favorite');
      }
      await _database.toggleFavorite(id, isFavorite: poi.isFavorite == 0);
    } catch (e) {
      if (e is PoiRepositoryException) rethrow;
      throw PoiRepositoryException('Failed to toggle favorite: $e');
    }
  }

  PoiModel _rowToModel(PoiTableData row) {
    return PoiModel(
      id: row.id,
      name: row.name,
      description: row.description,
      latitude: row.latitude,
      longitude: row.longitude,
      color: row.color,
      iconKey: row.iconKey,
      folderId: row.folderId,
      images: List<String>.from(jsonDecode(row.images) as List),
      createdAt: DateTime.fromMillisecondsSinceEpoch(row.createdAt),
      updatedAt: DateTime.fromMillisecondsSinceEpoch(row.updatedAt),
      isFavorite: row.isFavorite == 1,
      note: row.note,
    );
  }

  PoiTableCompanion _modelToCompanion(PoiModel model) {
    return PoiTableCompanion(
      id: Value(model.id),
      name: Value(model.name),
      description: Value(model.description),
      latitude: Value(model.latitude),
      longitude: Value(model.longitude),
      color: Value(model.color),
      iconKey: Value(model.iconKey),
      folderId: Value(model.folderId),
      images: Value(jsonEncode(model.images)),
      createdAt: Value(model.createdAt.millisecondsSinceEpoch),
      updatedAt: Value(model.updatedAt.millisecondsSinceEpoch),
      isFavorite: Value(model.isFavorite ? 1 : 0),
      note: Value(model.note),
    );
  }
}

class PoiRepositoryException implements Exception {
  final String message;
  PoiRepositoryException(this.message);

  @override
  String toString() => 'PoiRepositoryException: $message';
}
