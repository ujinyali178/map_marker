import 'package:drift/drift.dart';

import '../models/track_model.dart';
import '../models/track_point.dart';
import '../sources/local/app_database.dart';

class TrackRepository {
  final AppDatabase _database;

  TrackRepository(this._database);

  Future<List<TrackModel>> getAllTracks() async {
    try {
      final rows = await _database.getAllTracks();
      final tracks = <TrackModel>[];
      for (final row in rows) {
        final points = await _database.getPointsByTrack(row.id);
        tracks.add(_rowToModel(row, points));
      }
      return tracks;
    } catch (e) {
      throw TrackRepositoryException('Failed to fetch tracks: $e');
    }
  }

  Stream<List<TrackModel>> watchAllTracks() {
    return _database.watchAllTracks().asyncMap((rows) async {
      final tracks = <TrackModel>[];
      for (final row in rows) {
        final points = await _database.getPointsByTrack(row.id);
        tracks.add(_rowToModel(row, points));
      }
      return tracks;
    });
  }

  Future<TrackModel?> getTrackById(String id) async {
    try {
      final row = await _database.getTrackById(id);
      if (row == null) return null;
      final points = await _database.getPointsByTrack(id);
      return _rowToModel(row, points);
    } catch (e) {
      throw TrackRepositoryException('Failed to fetch track: $e');
    }
  }

  Future<void> startTrack(TrackModel track) async {
    try {
      await _database.insertTrack(TrackTableCompanion(
        id: Value(track.id),
        name: Value(track.name),
        startedAt: Value(track.startedAt.millisecondsSinceEpoch),
        finishedAt: const Value.absent(),
        distanceMeters: const Value(0.0),
      ));
    } catch (e) {
      throw TrackRepositoryException('Failed to start track: $e');
    }
  }

  Future<void> addPoint(String trackId, TrackPoint point) async {
    try {
      await _database.insertTrackPoint(TrackPointTableCompanion(
        trackId: Value(trackId),
        latitude: Value(point.latitude),
        longitude: Value(point.longitude),
        altitude: Value(point.altitude),
        timestamp: Value(point.timestamp.millisecondsSinceEpoch),
        speed: Value(point.speed),
      ));
    } catch (e) {
      throw TrackRepositoryException('Failed to add track point: $e');
    }
  }

  Future<void> finishTrack(String id, {required double distanceMeters}) async {
    try {
      final track = await _database.getTrackById(id);
      if (track == null) {
        throw TrackRepositoryException('Track not found for finishing');
      }
      await _database.finishTrack(id, distanceMeters: distanceMeters);
    } catch (e) {
      if (e is TrackRepositoryException) rethrow;
      throw TrackRepositoryException('Failed to finish track: $e');
    }
  }

  Future<void> deleteTrack(String id) async {
    try {
      final deleted = await _database.deleteTrack(id);
      if (deleted == 0) {
        throw TrackRepositoryException('Track not found for deletion');
      }
    } catch (e) {
      if (e is TrackRepositoryException) rethrow;
      throw TrackRepositoryException('Failed to delete track: $e');
    }
  }

  TrackModel _rowToModel(TrackTableData row, List<TrackPointTableData> points) {
    return TrackModel(
      id: row.id,
      name: row.name,
      points: points
          .map((p) => TrackPoint(
                latitude: p.latitude,
                longitude: p.longitude,
                altitude: p.altitude,
                timestamp: DateTime.fromMillisecondsSinceEpoch(p.timestamp),
                speed: p.speed,
              ))
          .toList(),
      startedAt: DateTime.fromMillisecondsSinceEpoch(row.startedAt),
      finishedAt: row.finishedAt != null
          ? DateTime.fromMillisecondsSinceEpoch(row.finishedAt!)
          : null,
      distanceMeters: row.distanceMeters,
    );
  }
}

class TrackRepositoryException implements Exception {
  final String message;
  TrackRepositoryException(this.message);

  @override
  String toString() => 'TrackRepositoryException: $message';
}
