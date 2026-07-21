import 'dart:convert';
import 'dart:io';

import 'package:drift/drift.dart';
import 'package:drift/native.dart';
import 'package:path/path.dart' as p;
import 'package:path_provider/path_provider.dart';

part 'app_database.g.dart';

class PoiTable extends Table {
  TextColumn get id => text()();
  TextColumn get name => text()();
  TextColumn get description => text().withDefault(const Constant(''))();
  RealColumn get latitude => real()();
  RealColumn get longitude => real()();
  IntColumn get color => integer().withDefault(const Constant(0xFF4CAF50))();
  TextColumn get iconKey => text().withDefault(const Constant('default'))();
  TextColumn get folderId => text().nullable()();
  TextColumn get images => text().withDefault(const Constant('[]'))();
  IntColumn get createdAt => integer()();
  IntColumn get updatedAt => integer()();
  IntColumn get isFavorite => integer().withDefault(const Constant(0))();
  TextColumn get note => text().withDefault(const Constant(''))();

  @override
  Set<Column> get primaryKey => {id};

  @override
  List<Set<Column>> get uniqueKeys => [];
}

class FolderTable extends Table {
  TextColumn get id => text()();
  TextColumn get name => text()();
  IntColumn get color => integer().withDefault(const Constant(0xFF757575))();
  TextColumn get parentId => text().nullable()();
  IntColumn get createdAt => integer()();
  IntColumn get sortOrder => integer().withDefault(const Constant(0))();

  @override
  Set<Column> get primaryKey => {id};
}

class WorkspaceTable extends Table {
  TextColumn get id => text()();
  TextColumn get name => text()();
  IntColumn get createdAt => integer()();
  IntColumn get isActive => integer().withDefault(const Constant(0))();

  @override
  Set<Column> get primaryKey => {id};
}

class TrackTable extends Table {
  TextColumn get id => text()();
  TextColumn get name => text()();
  IntColumn get startedAt => integer()();
  IntColumn get finishedAt => integer().nullable()();
  RealColumn get distanceMeters => real().withDefault(const Constant(0.0))();

  @override
  Set<Column> get primaryKey => {id};
}

class TrackPointTable extends Table {
  IntColumn get id => integer().autoIncrement()();
  TextColumn get trackId => text()();
  RealColumn get latitude => real()();
  RealColumn get longitude => real()();
  RealColumn get altitude => real().nullable()();
  IntColumn get timestamp => integer()();
  RealColumn get speed => real().nullable()();
}

class SyncStateTable extends Table {
  IntColumn get id => integer()();
  TextColumn get interfaceType => text().withDefault(const Constant('none'))();
  TextColumn get accountName => text().withDefault(const Constant(''))();
  TextColumn get cloudFolderId => text().withDefault(const Constant(''))();
  IntColumn get lastSyncTime => integer().nullable()();
  IntColumn get hasRemoteChanges => integer().withDefault(const Constant(0))();
  IntColumn get isReadOnly => integer().withDefault(const Constant(0))();
  TextColumn get shareUrl => text().withDefault(const Constant(''))();

  @override
  Set<Column> get primaryKey => {id};
}

@DriftDatabase(tables: [
  PoiTable,
  FolderTable,
  WorkspaceTable,
  TrackTable,
  TrackPointTable,
  SyncStateTable,
])
class AppDatabase extends _$AppDatabase {
  AppDatabase() : super(_openConnection());

  AppDatabase.forTesting(super.e);

  @override
  int get schemaVersion => 1;

  @override
  MigrationStrategy get migration => MigrationStrategy(
        onCreate: (m) async {
          await m.createAll();
          await into(syncStateTable).insert(
            SyncStateTableCompanion.insert(
              id: const Value(0),
              interfaceType: const Value('none'),
              accountName: const Value(''),
              cloudFolderId: const Value(''),
              hasRemoteChanges: const Value(0),
              isReadOnly: const Value(0),
              shareUrl: const Value(''),
            ),
          );
        },
      );

  // ─── POI CRUD ─────────────────────────────────────────────────────────

  Future<List<PoiTableData>> getAllPois() async {
    return (select(poiTable)
          ..orderBy([(t) => OrderingTerm.asc(t.name)]))
        .get();
  }

  Future<List<PoiTableData>> getPoisByFolder(String folderId) async {
    return (select(poiTable)
          ..where((t) => t.folderId.equals(folderId))
          ..orderBy([(t) => OrderingTerm.asc(t.name)]))
        .get();
  }

  Stream<List<PoiTableData>> watchAllPois() {
    return (select(poiTable)
          ..orderBy([(t) => OrderingTerm.desc(t.updatedAt)]))
        .watch();
  }

  Stream<List<PoiTableData>> watchPoisByFolder(String folderId) {
    return (select(poiTable)
          ..where((t) => t.folderId.equals(folderId))
          ..orderBy([(t) => OrderingTerm.asc(t.name)]))
        .watch();
  }

  Future<PoiTableData?> getPoiById(String id) async {
    return (select(poiTable)..where((t) => t.id.equals(id))).getSingleOrNull();
  }

  Future<int> insertPoi(PoiTableCompanion entry) {
    return into(poiTable).insert(entry, mode: InsertMode.replace);
  }

  Future<bool> updatePoi(PoiTableCompanion entry) {
    return update(poiTable).replace(entry);
  }

  Future<int> deletePoi(String id) {
    return (delete(poiTable)..where((t) => t.id.equals(id))).go();
  }

  Future<int> toggleFavorite(String id, {required bool isFavorite}) async {
    return (update(poiTable)..where((t) => t.id.equals(id))).write(
      PoiTableCompanion(
        isFavorite: Value(isFavorite ? 1 : 0),
        updatedAt: Value(DateTime.now().millisecondsSinceEpoch),
      ),
    );
  }

  Future<List<PoiTableData>> searchPois(String query) async {
    final pattern = '%$query%';
    return (select(poiTable)
          ..where(
              (t) => t.name.like(pattern) | t.description.like(pattern) | t.note.like(pattern))
          ..orderBy([(t) => OrderingTerm.asc(t.name)]))
        .get();
  }

  // ─── Folder CRUD ──────────────────────────────────────────────────────

  Future<List<FolderTableData>> getAllFolders() async {
    return (select(folderTable)
          ..orderBy([(t) => OrderingTerm.asc(t.sortOrder), (t) => OrderingTerm.asc(t.name)]))
        .get();
  }

  Stream<List<FolderTableData>> watchAllFolders() {
    return (select(folderTable)
          ..orderBy([(t) => OrderingTerm.asc(t.sortOrder), (t) => OrderingTerm.asc(t.name)]))
        .watch();
  }

  Future<FolderTableData?> getFolderById(String id) async {
    return (select(folderTable)..where((t) => t.id.equals(id))).getSingleOrNull();
  }

  Future<int> insertFolder(FolderTableCompanion entry) {
    return into(folderTable).insert(entry, mode: InsertMode.replace);
  }

  Future<bool> updateFolder(FolderTableCompanion entry) {
    return update(folderTable).replace(entry);
  }

  Future<int> deleteFolder(String id) {
    return (delete(folderTable)..where((t) => t.id.equals(id))).go();
  }

  Future<int> getPoisCountByFolder(String folderId) async {
    final count = poiTable.id.count();
    final query = selectOnly(poiTable)
      ..addColumns([count])
      ..where(poiTable.folderId.equals(folderId));
    final result = await query.getSingle();
    return result.read(count) ?? 0;
  }

  // ─── Workspace CRUD ───────────────────────────────────────────────────

  Future<List<WorkspaceTableData>> getAllWorkspaces() async {
    return select(workspaceTable).get();
  }

  Stream<List<WorkspaceTableData>> watchAllWorkspaces() {
    return select(workspaceTable).watch();
  }

  Future<WorkspaceTableData?> getActiveWorkspace() async {
    return (select(workspaceTable)
          ..where((t) => t.isActive.equals(1))
          ..limit(1))
        .getSingleOrNull();
  }

  Future<int> insertWorkspace(WorkspaceTableCompanion entry) {
    return into(workspaceTable).insert(entry, mode: InsertMode.replace);
  }

  Future<bool> updateWorkspace(WorkspaceTableCompanion entry) {
    return update(workspaceTable).replace(entry);
  }

  Future<int> deleteWorkspace(String id) {
    return (delete(workspaceTable)..where((t) => t.id.equals(id))).go();
  }

  Future<void> setActiveWorkspace(String id) async {
    await customUpdate(
      'UPDATE workspace_table SET is_active = 0 WHERE is_active = 1',
    );
    await (update(workspaceTable)..where((t) => t.id.equals(id))).write(
      const WorkspaceTableCompanion(isActive: Value(1)),
    );
  }

  // ─── Track CRUD ───────────────────────────────────────────────────────

  Future<List<TrackTableData>> getAllTracks() async {
    return (select(trackTable)
          ..orderBy([(t) => OrderingTerm.desc(t.startedAt)]))
        .get();
  }

  Stream<List<TrackTableData>> watchAllTracks() {
    return (select(trackTable)
          ..orderBy([(t) => OrderingTerm.desc(t.startedAt)]))
        .watch();
  }

  Future<TrackTableData?> getTrackById(String id) async {
    return (select(trackTable)..where((t) => t.id.equals(id))).getSingleOrNull();
  }

  Future<int> insertTrack(TrackTableCompanion entry) {
    return into(trackTable).insert(entry, mode: InsertMode.replace);
  }

  Future<bool> updateTrack(TrackTableCompanion entry) {
    return update(trackTable).replace(entry);
  }

  Future<int> deleteTrack(String id) async {
    await (delete(trackPointTable)..where((t) => t.trackId.equals(id))).go();
    return (delete(trackTable)..where((t) => t.id.equals(id))).go();
  }

  Future<void> finishTrack(String id, {required double distanceMeters}) async {
    await (update(trackTable)..where((t) => t.id.equals(id))).write(
      TrackTableCompanion(
        finishedAt: Value(DateTime.now().millisecondsSinceEpoch),
        distanceMeters: Value(distanceMeters),
      ),
    );
  }

  // ─── TrackPoint CRUD ──────────────────────────────────────────────────

  Future<List<TrackPointTableData>> getPointsByTrack(String trackId) async {
    return (select(trackPointTable)
          ..where((t) => t.trackId.equals(trackId))
          ..orderBy([(t) => OrderingTerm.asc(t.timestamp)]))
        .get();
  }

  Stream<List<TrackPointTableData>> watchPointsByTrack(String trackId) {
    return (select(trackPointTable)
          ..where((t) => t.trackId.equals(trackId))
          ..orderBy([(t) => OrderingTerm.asc(t.timestamp)]))
        .watch();
  }

  Future<int> insertTrackPoint(TrackPointTableCompanion entry) {
    return into(trackPointTable).insert(entry);
  }

  Future<int> deletePointsByTrack(String trackId) {
    return (delete(trackPointTable)..where((t) => t.trackId.equals(trackId))).go();
  }

  // ─── Sync State ───────────────────────────────────────────────────────

  Future<SyncStateTableData?> getSyncState() async {
    return (select(syncStateTable)..where((t) => t.id.equals(0))).getSingleOrNull();
  }

  Stream<SyncStateTableData?> watchSyncState() {
    return (select(syncStateTable)..where((t) => t.id.equals(0))).watchSingleOrNull();
  }

  Future<void> updateSyncState(SyncStateTableCompanion entry) async {
    await (update(syncStateTable)..where((t) => t.id.equals(0))).write(entry);
  }
}

LazyDatabase _openConnection() {
  return LazyDatabase(() async {
    final dbFolder = await getApplicationDocumentsDirectory();
    final file = File(p.join(dbFolder.path, 'map_marker.db'));
    return NativeDatabase.createInBackground(file);
  });
}
