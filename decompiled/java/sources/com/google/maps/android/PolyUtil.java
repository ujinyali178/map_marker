package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* loaded from: /root/release/classes.dex */
public class PolyUtil {
    public static final double DEFAULT_TOLERANCE = 0.1d;

    private PolyUtil() {
    }

    public static boolean containsLocation(double d3, double d4, List<LatLng> list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        double radians = Math.toRadians(d3);
        double radians2 = Math.toRadians(d4);
        LatLng latLng = list.get(size - 1);
        double radians3 = Math.toRadians(latLng.latitude);
        double radians4 = Math.toRadians(latLng.longitude);
        double d5 = radians3;
        int i3 = 0;
        for (LatLng latLng2 : list) {
            double wrap = MathUtil.wrap(radians2 - radians4, -3.141592653589793d, 3.141592653589793d);
            if (radians == d5 && wrap == 0.0d) {
                return true;
            }
            double radians5 = Math.toRadians(latLng2.latitude);
            double radians6 = Math.toRadians(latLng2.longitude);
            if (intersects(d5, radians5, MathUtil.wrap(radians6 - radians4, -3.141592653589793d, 3.141592653589793d), radians, wrap, z3)) {
                i3++;
            }
            d5 = radians5;
            radians4 = radians6;
        }
        return (i3 & 1) != 0;
    }

    public static boolean containsLocation(LatLng latLng, List<LatLng> list, boolean z3) {
        return containsLocation(latLng.latitude, latLng.longitude, list, z3);
    }

    public static List<LatLng> decode(String str) {
        int i3;
        int i4;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int i8 = 1;
            int i9 = 0;
            while (true) {
                i3 = i5 + 1;
                int charAt = (str.charAt(i5) - '?') - 1;
                i8 += charAt << i9;
                i9 += 5;
                if (charAt < 31) {
                    break;
                }
                i5 = i3;
            }
            int i10 = ((i8 & 1) != 0 ? ~(i8 >> 1) : i8 >> 1) + i6;
            int i11 = 1;
            int i12 = 0;
            while (true) {
                i4 = i3 + 1;
                int charAt2 = (str.charAt(i3) - '?') - 1;
                i11 += charAt2 << i12;
                i12 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i3 = i4;
            }
            int i13 = i11 & 1;
            int i14 = i11 >> 1;
            if (i13 != 0) {
                i14 = ~i14;
            }
            i7 += i14;
            arrayList.add(new LatLng(i10 * 1.0E-5d, i7 * 1.0E-5d));
            i6 = i10;
            i5 = i4;
        }
        return arrayList;
    }

    public static double distanceToLine(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng2.equals(latLng3)) {
            return SphericalUtil.computeDistanceBetween(latLng3, latLng);
        }
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double radians5 = Math.toRadians(latLng3.latitude);
        double radians6 = Math.toRadians(latLng3.longitude);
        double cos = Math.cos(radians3);
        double d3 = radians5 - radians3;
        double d4 = (radians6 - radians4) * cos;
        double d5 = (((radians - radians3) * d3) + (((radians2 - radians4) * cos) * d4)) / ((d3 * d3) + (d4 * d4));
        if (d5 <= 0.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng2);
        }
        if (d5 >= 1.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng3);
        }
        double d6 = latLng2.latitude;
        double d7 = d6 + ((latLng3.latitude - d6) * d5);
        double d8 = latLng2.longitude;
        return SphericalUtil.computeDistanceBetween(latLng, new LatLng(d7, d8 + (d5 * (latLng3.longitude - d8))));
    }

    public static String encode(List<LatLng> list) {
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = 0;
        long j4 = 0;
        for (LatLng latLng : list) {
            long round = Math.round(latLng.latitude * 100000.0d);
            long round2 = Math.round(latLng.longitude * 100000.0d);
            encode(round - j3, stringBuffer);
            encode(round2 - j4, stringBuffer);
            j3 = round;
            j4 = round2;
        }
        return stringBuffer.toString();
    }

    private static void encode(long j3, StringBuffer stringBuffer) {
        long j4 = j3 << 1;
        if (j3 < 0) {
            j4 = ~j4;
        }
        while (j4 >= 32) {
            stringBuffer.append(Character.toChars((int) ((32 | (31 & j4)) + 63)));
            j4 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j4 + 63)));
    }

    private static boolean intersects(double d3, double d4, double d5, double d6, double d7, boolean z3) {
        if ((d7 >= 0.0d && d7 >= d5) || ((d7 < 0.0d && d7 < d5) || d6 <= -1.5707963267948966d || d3 <= -1.5707963267948966d || d4 <= -1.5707963267948966d || d3 >= 1.5707963267948966d || d4 >= 1.5707963267948966d || d5 <= -3.141592653589793d)) {
            return false;
        }
        double d8 = (((d5 - d7) * d3) + (d4 * d7)) / d5;
        if (d3 >= 0.0d && d4 >= 0.0d && d6 < d8) {
            return false;
        }
        if ((d3 <= 0.0d && d4 <= 0.0d && d6 >= d8) || d6 >= 1.5707963267948966d) {
            return true;
        }
        if (z3) {
            if (Math.tan(d6) < tanLatGC(d3, d4, d5, d7)) {
                return false;
            }
        } else if (MathUtil.mercator(d6) < mercatorLatRhumb(d3, d4, d5, d7)) {
            return false;
        }
        return true;
    }

    public static boolean isClosedPolygon(List<LatLng> list) {
        return list.get(0).equals(list.get(list.size() - 1));
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z3) {
        return isLocationOnEdge(latLng, list, z3, 0.1d);
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z3, double d3) {
        return isLocationOnEdgeOrPath(latLng, list, true, z3, d3);
    }

    private static boolean isLocationOnEdgeOrPath(LatLng latLng, List<LatLng> list, boolean z3, boolean z4, double d3) {
        return locationIndexOnEdgeOrPath(latLng, list, z3, z4, d3) >= 0;
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z3) {
        return isLocationOnPath(latLng, list, z3, 0.1d);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z3, double d3) {
        return isLocationOnEdgeOrPath(latLng, list, false, z3, d3);
    }

    private static boolean isOnSegmentGC(double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double havDistance = MathUtil.havDistance(d3, d7, d4 - d8);
        if (havDistance <= d9) {
            return true;
        }
        double havDistance2 = MathUtil.havDistance(d5, d7, d6 - d8);
        if (havDistance2 <= d9) {
            return true;
        }
        double havFromSin = MathUtil.havFromSin(MathUtil.sinFromHav(havDistance) * sinDeltaBearing(d3, d4, d5, d6, d7, d8));
        if (havFromSin > d9) {
            return false;
        }
        double havDistance3 = MathUtil.havDistance(d3, d5, d4 - d6);
        double d10 = ((1.0d - (havDistance3 * 2.0d)) * havFromSin) + havDistance3;
        if (havDistance > d10 || havDistance2 > d10) {
            return false;
        }
        if (havDistance3 < 0.74d) {
            return true;
        }
        double d11 = 1.0d - (2.0d * havFromSin);
        return MathUtil.sinSumFromHav((havDistance - havFromSin) / d11, (havDistance2 - havFromSin) / d11) > 0.0d;
    }

    public static int locationIndexOnEdgeOrPath(LatLng latLng, List<LatLng> list, boolean z3, boolean z4, double d3) {
        List<LatLng> list2;
        int i3;
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        double d4 = d3 / 6371009.0d;
        double hav = MathUtil.hav(d4);
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        if (z3) {
            i3 = size - 1;
            list2 = list;
        } else {
            list2 = list;
            i3 = 0;
        }
        LatLng latLng2 = list2.get(i3);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        if (z4) {
            double d5 = radians3;
            double d6 = radians4;
            int i4 = 0;
            for (LatLng latLng3 : list) {
                double radians5 = Math.toRadians(latLng3.latitude);
                double radians6 = Math.toRadians(latLng3.longitude);
                if (isOnSegmentGC(d5, d6, radians5, radians6, radians, radians2, hav)) {
                    return Math.max(0, i4 - 1);
                }
                i4++;
                d5 = radians5;
                d6 = radians6;
            }
            return -1;
        }
        double d7 = radians - d4;
        double d8 = radians + d4;
        double mercator = MathUtil.mercator(radians3);
        double mercator2 = MathUtil.mercator(radians);
        double[] dArr = new double[3];
        int i5 = 0;
        for (LatLng latLng4 : list) {
            double d9 = mercator2;
            double radians7 = Math.toRadians(latLng4.latitude);
            double mercator3 = MathUtil.mercator(radians7);
            double radians8 = Math.toRadians(latLng4.longitude);
            if (Math.max(radians3, radians7) >= d7 && Math.min(radians3, radians7) <= d8) {
                double wrap = MathUtil.wrap(radians8 - radians4, -3.141592653589793d, 3.141592653589793d);
                double wrap2 = MathUtil.wrap(radians2 - radians4, -3.141592653589793d, 3.141592653589793d);
                dArr[0] = wrap2;
                dArr[1] = wrap2 + 6.283185307179586d;
                dArr[2] = wrap2 - 6.283185307179586d;
                for (int i6 = 0; i6 < 3; i6++) {
                    double d10 = dArr[i6];
                    double d11 = mercator3 - mercator;
                    double d12 = (wrap * wrap) + (d11 * d11);
                    double clamp = d12 > 0.0d ? MathUtil.clamp(((d10 * wrap) + ((d9 - mercator) * d11)) / d12, 0.0d, 1.0d) : 0.0d;
                    if (MathUtil.havDistance(radians, MathUtil.inverseMercator(mercator + (clamp * d11)), d10 - (clamp * wrap)) < hav) {
                        return Math.max(0, i5 - 1);
                    }
                }
            }
            i5++;
            radians4 = radians8;
            radians3 = radians7;
            mercator2 = d9;
            mercator = mercator3;
        }
        return -1;
    }

    public static int locationIndexOnPath(LatLng latLng, List<LatLng> list, boolean z3) {
        return locationIndexOnPath(latLng, list, z3, 0.1d);
    }

    public static int locationIndexOnPath(LatLng latLng, List<LatLng> list, boolean z3, double d3) {
        return locationIndexOnEdgeOrPath(latLng, list, false, z3, d3);
    }

    private static double mercatorLatRhumb(double d3, double d4, double d5, double d6) {
        return ((MathUtil.mercator(d3) * (d5 - d6)) + (MathUtil.mercator(d4) * d6)) / d5;
    }

    public static List<LatLng> simplify(List<LatLng> list, double d3) {
        int size = list.size();
        if (size < 1) {
            throw new IllegalArgumentException("Polyline must have at least 1 point");
        }
        double d4 = 0.0d;
        if (d3 <= 0.0d) {
            throw new IllegalArgumentException("Tolerance must be greater than zero");
        }
        boolean isClosedPolygon = isClosedPolygon(list);
        LatLng latLng = null;
        if (isClosedPolygon) {
            latLng = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(new LatLng(latLng.latitude + 1.0E-11d, latLng.longitude + 1.0E-11d));
        }
        Stack stack = new Stack();
        double[] dArr = new double[size];
        int i3 = 0;
        dArr[0] = 1.0d;
        int i4 = size - 1;
        dArr[i4] = 1.0d;
        if (size > 2) {
            stack.push(new int[]{0, i4});
            int i5 = 0;
            while (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                double d5 = d4;
                for (int i6 = iArr[0] + 1; i6 < iArr[1]; i6++) {
                    double distanceToLine = distanceToLine(list.get(i6), list.get(iArr[0]), list.get(iArr[1]));
                    if (distanceToLine > d5) {
                        d5 = distanceToLine;
                        i5 = i6;
                    }
                }
                if (d5 > d3) {
                    dArr[i5] = d5;
                    stack.push(new int[]{iArr[0], i5});
                    stack.push(new int[]{i5, iArr[1]});
                }
                d4 = 0.0d;
            }
        }
        if (isClosedPolygon) {
            list.remove(list.size() - 1);
            list.add(latLng);
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng2 : list) {
            if (dArr[i3] != 0.0d) {
                arrayList.add(latLng2);
            }
            i3++;
        }
        return arrayList;
    }

    private static double sinDeltaBearing(double d3, double d4, double d5, double d6, double d7, double d8) {
        double sin = Math.sin(d3);
        double cos = Math.cos(d5);
        double cos2 = Math.cos(d7);
        double d9 = d8 - d4;
        double d10 = d6 - d4;
        double sin2 = Math.sin(d9) * cos2;
        double sin3 = Math.sin(d10) * cos;
        double d11 = sin * 2.0d;
        double sin4 = Math.sin(d7 - d3) + (cos2 * d11 * MathUtil.hav(d9));
        double sin5 = Math.sin(d5 - d3) + (d11 * cos * MathUtil.hav(d10));
        double d12 = ((sin2 * sin2) + (sin4 * sin4)) * ((sin3 * sin3) + (sin5 * sin5));
        if (d12 <= 0.0d) {
            return 1.0d;
        }
        return ((sin2 * sin5) - (sin4 * sin3)) / Math.sqrt(d12);
    }

    private static double tanLatGC(double d3, double d4, double d5, double d6) {
        return ((Math.tan(d3) * Math.sin(d5 - d6)) + (Math.tan(d4) * Math.sin(d6))) / Math.sin(d5);
    }
}
