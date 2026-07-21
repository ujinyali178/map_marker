import 'dart:math';

class DistanceCalculator {
  DistanceCalculator._();

  static const double _earthRadius = 6371000.0;

  static double calculateDistance(
      double lat1, double lng1, double lat2, double lng2) {
    final dLat = _toRadians(lat2 - lat1);
    final dLng = _toRadians(lng2 - lng1);
    final a = sin(dLat / 2) * sin(dLat / 2) +
        cos(_toRadians(lat1)) *
            cos(_toRadians(lat2)) *
            sin(dLng / 2) *
            sin(dLng / 2);
    final c = 2 * atan2(sqrt(a), sqrt(1 - a));
    return _earthRadius * c;
  }

  static String formatDistance(double meters) {
    if (meters >= 1000) {
      final km = meters / 1000;
      if (km >= 100) {
        return '${km.toStringAsFixed(0)} km';
      }
      return '${km.toStringAsFixed(1)} km';
    }
    return '${meters.toStringAsFixed(0)} m';
  }

  static String formatDuration(double seconds) {
    if (seconds.isNaN || seconds.isInfinite || seconds <= 0) {
      return '0 min';
    }
    final duration = Duration(seconds: seconds.round());
    final hours = duration.inHours;
    final minutes = duration.inMinutes.remainder(60);
    final secs = duration.inSeconds.remainder(60);

    if (hours > 0) {
      final hoursStr = hours.toString().padLeft(2, '0');
      final minsStr = minutes.toString().padLeft(2, '0');
      final secsStr = secs.toString().padLeft(2, '0');
      return '$hoursStr:$minsStr:$secsStr';
    }
    return '$minutes min';
  }

  static double calculateSpeed(double distanceMeters, double durationSeconds) {
    if (durationSeconds <= 0) return 0;
    final hours = durationSeconds / 3600;
    final km = distanceMeters / 1000;
    return km / hours;
  }

  static double _toRadians(double degrees) {
    return degrees * pi / 180;
  }
}
