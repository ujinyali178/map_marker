class AppConstants {
  AppConstants._();

  static const double defaultLatitude = -6.2088;
  static const double defaultLongitude = 106.8456;
  static const double defaultZoom = 13.0;
  static const double minZoom = 2.0;
  static const double maxZoom = 19.0;

  static const String databaseName = 'map_marker.db';
  static const int databaseVersion = 1;

  static const String appName = 'Map Marker';
  static const String appVersion = '1.0.0';

  static const int maxImagesPerPoi = 10;
  static const int maxImageSizeBytes = 5 * 1024 * 1024;
  static const int imageThumbnailSize = 200;

  static const Duration syncInterval = Duration(minutes: 15);
  static const Duration trackRecordInterval = Duration(seconds: 5);
  static const double trackMinDistanceMeters = 5.0;

  static const String poiTableName = 'pois';
  static const String folderTableName = 'folders';
  static const String trackTableName = 'tracks';
  static const String trackPointTableName = 'track_points';
  static const String workspaceTableName = 'workspaces';
  static const String syncTableName = 'sync_state';
  static const String tileSourceTableName = 'tile_sources';

  static const String defaultWorkspaceId = 'default';
  static const String defaultFolderName = 'Uncategorized';

  static const double routeSimplificationTolerance = 5.0;
  static const int maxTrackPoints = 50000;
}
