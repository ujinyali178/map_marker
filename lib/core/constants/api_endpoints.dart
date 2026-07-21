class ApiEndpoints {
  ApiEndpoints._();

  static const String osrmRouting = 'https://router.project-osrm.org/route/v1/driving/';

  static const String nominatimSearch = 'https://nominatim.openstreetmap.org/search';

  static const String osmTile = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png';

  static const String googleTile = 'http://mt0.google.com/vt/lyrs=m&hl=en&x={x}&y={y}&z={z}&s=Ga';

  static const String satelliteTile = 'http://mt0.google.com/vt/lyrs=s&hl=en&x={x}&y={y}&z={z}&s=Ga';

  static const String terrainTile = 'http://mt0.google.com/vt/lyrs=p&hl=en&x={x}&y={y}&z={z}&s=Ga';
}
