package org.mapsforge.core.util;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
public final class LatLongUtils {
    private static final double CONVERSION_FACTOR = 1000000.0d;
    private static final String DELIMITER = ",";
    public static final double EQUATORIAL_RADIUS = 6378137.0d;
    public static final double INVERSE_FLATTENING = 298.257223563d;
    public static final double LATITUDE_MAX = 90.0d;
    public static final double LATITUDE_MIN = -90.0d;
    public static final double LONGITUDE_MAX = 180.0d;
    public static final double LONGITUDE_MIN = -180.0d;
    public static final double POLAR_RADIUS = 6356752.3142d;

    private LatLongUtils() {
        throw new IllegalStateException();
    }

    public static boolean contains(List<LatLong> list, LatLong latLong) {
        int size = list.size() - 1;
        boolean z3 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if ((list.get(i3).latitude > latLong.latitude) != (list.get(size).latitude > latLong.latitude) && latLong.longitude < (((list.get(size).longitude - list.get(i3).longitude) * (latLong.latitude - list.get(i3).latitude)) / (list.get(size).latitude - list.get(i3).latitude)) + list.get(i3).longitude) {
                z3 = !z3;
            }
            size = i3;
        }
        return z3;
    }

    public static boolean contains(LatLong[] latLongArr, LatLong latLong) {
        int length = latLongArr.length - 1;
        boolean z3 = false;
        for (int i3 = 0; i3 < latLongArr.length; i3++) {
            LatLong latLong2 = latLongArr[i3];
            double d3 = latLong2.latitude;
            double d4 = latLong.latitude;
            boolean z4 = d3 > d4;
            LatLong latLong3 = latLongArr[length];
            double d5 = latLong3.latitude;
            if (z4 != (d5 > d4)) {
                double d6 = latLong.longitude;
                double d7 = latLong3.longitude;
                double d8 = latLong2.longitude;
                if (d6 < (((d7 - d8) * (d4 - d3)) / (d5 - d3)) + d8) {
                    z3 = !z3;
                }
            }
            length = i3;
        }
        return z3;
    }

    public static int degreesToMicrodegrees(double d3) {
        return (int) (d3 * CONVERSION_FACTOR);
    }

    public static LatLong destinationPoint(LatLong latLong, double d3, float f3) {
        double radians = Math.toRadians(f3);
        double d4 = d3 / 6378137.0d;
        double radians2 = Math.toRadians(latLong.latitude);
        double radians3 = Math.toRadians(latLong.longitude);
        double asin = Math.asin((Math.sin(radians2) * Math.cos(d4)) + (Math.cos(radians2) * Math.sin(d4) * Math.cos(radians)));
        return new LatLong(Math.toDegrees(asin), Math.toDegrees(radians3 + Math.atan2(Math.sin(radians) * Math.sin(d4) * Math.cos(radians2), Math.cos(d4) - (Math.sin(radians2) * Math.sin(asin)))));
    }

    public static double distance(LatLong latLong, LatLong latLong2) {
        return Math.hypot(latLong.longitude - latLong2.longitude, latLong.latitude - latLong2.latitude);
    }

    public static double distanceSegmentPoint(double d3, double d4, double d5, double d6, double d7, double d8) {
        Point nearestSegmentPoint = nearestSegmentPoint(d3, d4, d5, d6, d7, d8);
        return Math.hypot(nearestSegmentPoint.f4076x - d7, nearestSegmentPoint.f4077y - d8);
    }

    public static LatLong fromString(String str) {
        double[] parseCoordinateString = parseCoordinateString(str, 2);
        return new LatLong(parseCoordinateString[0], parseCoordinateString[1]);
    }

    public static boolean isClosedWay(LatLong[] latLongArr) {
        return latLongArr[0].distance(latLongArr[latLongArr.length - 1]) < 1.0E-9d;
    }

    public static double latitudeDistance(int i3) {
        return (i3 * 360) / 4.007501668557849E7d;
    }

    public static double longitudeDistance(int i3, double d3) {
        return (i3 * 360) / (Math.cos(Math.toRadians(d3)) * 4.007501668557849E7d);
    }

    public static double microdegreesToDegrees(int i3) {
        return i3 / CONVERSION_FACTOR;
    }

    public static Point nearestSegmentPoint(double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d5 - d3;
        double d10 = d6 - d4;
        double d11 = (d9 * d9) + (d10 * d10);
        if (d11 == 0.0d) {
            return new Point(d3, d4);
        }
        double d12 = (((d7 - d3) * d9) + ((d8 - d4) * d10)) / d11;
        return d12 < 0.0d ? new Point(d3, d4) : d12 > 1.0d ? new Point(d5, d6) : new Point(d3 + (d9 * d12), d4 + (d12 * d10));
    }

    public static double[] parseCoordinateString(String str, int i3) {
        boolean z3 = true;
        StringTokenizer stringTokenizer = new StringTokenizer(str, DELIMITER, true);
        ArrayList arrayList = new ArrayList(i3);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            z3 = !z3;
            if (!z3) {
                arrayList.add(nextToken);
            }
        }
        if (z3) {
            throw new IllegalArgumentException("invalid coordinate delimiter: " + str);
        }
        if (arrayList.size() != i3) {
            throw new IllegalArgumentException("invalid number of coordinate values: " + str);
        }
        double[] dArr = new double[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            dArr[i4] = Double.parseDouble((String) arrayList.get(i4));
        }
        return dArr;
    }

    public static double sphericalDistance(LatLong latLong, LatLong latLong2) {
        double radians = Math.toRadians(latLong2.latitude - latLong.latitude);
        double d3 = radians / 2.0d;
        double radians2 = Math.toRadians(latLong2.longitude - latLong.longitude) / 2.0d;
        double sin = (Math.sin(d3) * Math.sin(d3)) + (Math.cos(Math.toRadians(latLong.latitude)) * Math.cos(Math.toRadians(latLong2.latitude)) * Math.sin(radians2) * Math.sin(radians2));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6378137.0d;
    }

    public static double validateLatitude(double d3) {
        if (!Double.isNaN(d3) && d3 >= -90.0d && d3 <= 90.0d) {
            return d3;
        }
        throw new IllegalArgumentException("invalid latitude: " + d3);
    }

    public static double validateLongitude(double d3) {
        if (!Double.isNaN(d3) && d3 >= -180.0d && d3 <= 180.0d) {
            return d3;
        }
        throw new IllegalArgumentException("invalid longitude: " + d3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00f4, code lost:
    
        if (r12 != 0.0d) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00f6, code lost:
    
        return 0.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00f7, code lost:
    
        r14 = (r14 * (java.lang.Math.pow(6378137.0d, 2.0d) - java.lang.Math.pow(6356752.3142d, 2.0d))) / java.lang.Math.pow(6356752.3142d, 2.0d);
        r4 = (r14 / 1024.0d) * ((r14 * (((74.0d - (47.0d * r14)) * r14) - 128.0d)) + 256.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0176, code lost:
    
        return ((((r14 / 16384.0d) * (((((320.0d - (175.0d * r14)) * r14) - 768.0d) * r14) + 4096.0d)) + 1.0d) * 6356752.3142d) * (r16 - ((r4 * r10) * (r28 + ((r4 / 4.0d) * ((r2 * r38) - ((((r4 / 6.0d) * r28) * (((r10 * 4.0d) * r10) - 3.0d)) * (((4.0d * r28) * r28) - 3.0d)))))));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static double vincentyDistance(org.mapsforge.core.model.LatLong r40, org.mapsforge.core.model.LatLong r41) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mapsforge.core.util.LatLongUtils.vincentyDistance(org.mapsforge.core.model.LatLong, org.mapsforge.core.model.LatLong):double");
    }

    public static byte zoomForBounds(Dimension dimension, BoundingBox boundingBox, int i3) {
        long mapSize = MercatorProjection.getMapSize((byte) 0, i3);
        double floor = Math.floor(Math.min((-Math.log(Math.abs(MercatorProjection.longitudeToPixelX(boundingBox.maxLongitude, mapSize) - MercatorProjection.longitudeToPixelX(boundingBox.minLongitude, mapSize)) / dimension.width)) / Math.log(2.0d), (-Math.log(Math.abs(MercatorProjection.latitudeToPixelY(boundingBox.maxLatitude, mapSize) - MercatorProjection.latitudeToPixelY(boundingBox.minLatitude, mapSize)) / dimension.height)) / Math.log(2.0d)));
        if (floor < 0.0d) {
            return (byte) 0;
        }
        return floor > 127.0d ? Ascii.DEL : (byte) floor;
    }
}
