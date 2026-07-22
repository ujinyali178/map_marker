package y;

import android.location.Location;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class y {
    private static boolean a(Location location) {
        boolean isMock;
        if (Build.VERSION.SDK_INT < 31) {
            return location.isFromMockProvider();
        }
        isMock = location.isMock();
        return isMock;
    }

    public static Map<String, Object> b(Location location) {
        boolean hasSpeedAccuracy;
        float speedAccuracyMetersPerSecond;
        boolean hasBearingAccuracy;
        float bearingAccuracyDegrees;
        boolean hasVerticalAccuracy;
        float verticalAccuracyMeters;
        if (location == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(location.getLatitude()));
        hashMap.put("longitude", Double.valueOf(location.getLongitude()));
        hashMap.put("timestamp", Long.valueOf(location.getTime()));
        hashMap.put("is_mocked", Boolean.valueOf(a(location)));
        if (location.hasAltitude()) {
            hashMap.put("altitude", Double.valueOf(location.getAltitude()));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            hasVerticalAccuracy = location.hasVerticalAccuracy();
            if (hasVerticalAccuracy) {
                verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                hashMap.put("altitude_accuracy", Float.valueOf(verticalAccuracyMeters));
            }
        }
        if (location.hasAccuracy()) {
            hashMap.put("accuracy", Double.valueOf(location.getAccuracy()));
        }
        if (location.hasBearing()) {
            hashMap.put("heading", Double.valueOf(location.getBearing()));
        }
        if (i3 >= 26) {
            hasBearingAccuracy = location.hasBearingAccuracy();
            if (hasBearingAccuracy) {
                bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                hashMap.put("heading_accuracy", Float.valueOf(bearingAccuracyDegrees));
            }
        }
        if (location.hasSpeed()) {
            hashMap.put("speed", Double.valueOf(location.getSpeed()));
        }
        if (i3 >= 26) {
            hasSpeedAccuracy = location.hasSpeedAccuracy();
            if (hasSpeedAccuracy) {
                speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                hashMap.put("speed_accuracy", Double.valueOf(speedAccuracyMetersPerSecond));
            }
        }
        if (location.getExtras() != null) {
            if (location.getExtras().containsKey("geolocator_mslAltitude")) {
                hashMap.put("altitude", Double.valueOf(location.getExtras().getDouble("geolocator_mslAltitude")));
            }
            if (location.getExtras().containsKey("geolocator_mslSatelliteCount")) {
                hashMap.put("gnss_satellite_count", Double.valueOf(location.getExtras().getDouble("geolocator_mslSatelliteCount")));
            }
            if (location.getExtras().containsKey("geolocator_mslSatellitesUsedInFix")) {
                hashMap.put("gnss_satellites_used_in_fix", Double.valueOf(location.getExtras().getDouble("geolocator_mslSatellitesUsedInFix")));
            }
        }
        return hashMap;
    }
}
