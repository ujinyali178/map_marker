package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class SphericalUtil {
    private SphericalUtil() {
    }

    static double computeAngleBetween(LatLng latLng, LatLng latLng2) {
        return distanceRadians(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    public static double computeArea(List<LatLng> list) {
        return Math.abs(computeSignedArea(list));
    }

    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return computeAngleBetween(latLng, latLng2) * 6371009.0d;
    }

    public static double computeHeading(LatLng latLng, LatLng latLng2) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude) - radians2;
        return MathUtil.wrap(Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4)))), -180.0d, 180.0d);
    }

    public static double computeLength(List<LatLng> list) {
        double d3 = 0.0d;
        if (list.size() < 2) {
            return 0.0d;
        }
        LatLng latLng = null;
        for (LatLng latLng2 : list) {
            if (latLng != null) {
                d3 += distanceRadians(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
            }
            latLng = latLng2;
        }
        return d3 * 6371009.0d;
    }

    public static LatLng computeOffset(LatLng latLng, double d3, double d4) {
        double d5 = d3 / 6371009.0d;
        double radians = Math.toRadians(d4);
        double radians2 = Math.toRadians(latLng.latitude);
        double radians3 = Math.toRadians(latLng.longitude);
        double cos = Math.cos(d5);
        double sin = Math.sin(d5);
        double sin2 = Math.sin(radians2);
        double cos2 = sin * Math.cos(radians2);
        double cos3 = (cos * sin2) + (Math.cos(radians) * cos2);
        return new LatLng(Math.toDegrees(Math.asin(cos3)), Math.toDegrees(radians3 + Math.atan2(cos2 * Math.sin(radians), cos - (sin2 * cos3))));
    }

    public static LatLng computeOffsetOrigin(LatLng latLng, double d3, double d4) {
        double radians = Math.toRadians(d4);
        double d5 = d3 / 6371009.0d;
        double cos = Math.cos(d5);
        double sin = Math.sin(d5) * Math.cos(radians);
        double sin2 = Math.sin(d5) * Math.sin(radians);
        double sin3 = Math.sin(Math.toRadians(latLng.latitude));
        double d6 = cos * cos;
        double d7 = sin * sin;
        double d8 = ((d7 * d6) + (d6 * d6)) - ((d6 * sin3) * sin3);
        if (d8 < 0.0d) {
            return null;
        }
        double d9 = sin * sin3;
        double d10 = d6 + d7;
        double sqrt = (d9 + Math.sqrt(d8)) / d10;
        double d11 = (sin3 - (sin * sqrt)) / cos;
        double atan2 = Math.atan2(d11, sqrt);
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            atan2 = Math.atan2(d11, (d9 - Math.sqrt(d8)) / d10);
        }
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            return null;
        }
        return new LatLng(Math.toDegrees(atan2), Math.toDegrees(Math.toRadians(latLng.longitude) - Math.atan2(sin2, (cos * Math.cos(atan2)) - (sin * Math.sin(atan2)))));
    }

    public static double computeSignedArea(List<LatLng> list) {
        return computeSignedArea(list, 6371009.0d);
    }

    static double computeSignedArea(List<LatLng> list, double d3) {
        int size = list.size();
        double d4 = 0.0d;
        if (size < 3) {
            return 0.0d;
        }
        LatLng latLng = list.get(size - 1);
        double tan = Math.tan((1.5707963267948966d - Math.toRadians(latLng.latitude)) / 2.0d);
        double radians = Math.toRadians(latLng.longitude);
        double d5 = tan;
        double d6 = radians;
        for (LatLng latLng2 : list) {
            double tan2 = Math.tan((1.5707963267948966d - Math.toRadians(latLng2.latitude)) / 2.0d);
            double radians2 = Math.toRadians(latLng2.longitude);
            d4 += polarTriangleArea(tan2, radians2, d5, d6);
            d5 = tan2;
            d6 = radians2;
        }
        return d4 * d3 * d3;
    }

    private static double distanceRadians(double d3, double d4, double d5, double d6) {
        return MathUtil.arcHav(MathUtil.havDistance(d3, d5, d4 - d6));
    }

    public static LatLng interpolate(LatLng latLng, LatLng latLng2, double d3) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double cos = Math.cos(radians);
        double cos2 = Math.cos(radians3);
        double computeAngleBetween = computeAngleBetween(latLng, latLng2);
        double sin = Math.sin(computeAngleBetween);
        if (sin < 1.0E-6d) {
            double d4 = latLng.latitude;
            double d5 = d4 + ((latLng2.latitude - d4) * d3);
            double d6 = latLng.longitude;
            return new LatLng(d5, d6 + ((latLng2.longitude - d6) * d3));
        }
        double sin2 = Math.sin((1.0d - d3) * computeAngleBetween) / sin;
        double sin3 = Math.sin(computeAngleBetween * d3) / sin;
        double d7 = cos * sin2;
        double d8 = cos2 * sin3;
        double cos3 = (Math.cos(radians2) * d7) + (Math.cos(radians4) * d8);
        double sin4 = (d7 * Math.sin(radians2)) + (d8 * Math.sin(radians4));
        return new LatLng(Math.toDegrees(Math.atan2((sin2 * Math.sin(radians)) + (Math.sin(radians3) * sin3), Math.sqrt((cos3 * cos3) + (sin4 * sin4)))), Math.toDegrees(Math.atan2(sin4, cos3)));
    }

    private static double polarTriangleArea(double d3, double d4, double d5, double d6) {
        double d7 = d4 - d6;
        double d8 = d3 * d5;
        return Math.atan2(Math.sin(d7) * d8, (d8 * Math.cos(d7)) + 1.0d) * 2.0d;
    }
}
