package com.google.maps.android;

/* loaded from: /root/release/classes.dex */
class MathUtil {
    static final double EARTH_RADIUS = 6371009.0d;

    MathUtil() {
    }

    static double arcHav(double d3) {
        return Math.asin(Math.sqrt(d3)) * 2.0d;
    }

    static double clamp(double d3, double d4, double d5) {
        return d3 < d4 ? d4 : d3 > d5 ? d5 : d3;
    }

    static double hav(double d3) {
        double sin = Math.sin(d3 * 0.5d);
        return sin * sin;
    }

    static double havDistance(double d3, double d4, double d5) {
        return hav(d3 - d4) + (hav(d5) * Math.cos(d3) * Math.cos(d4));
    }

    static double havFromSin(double d3) {
        double d4 = d3 * d3;
        return (d4 / (Math.sqrt(1.0d - d4) + 1.0d)) * 0.5d;
    }

    static double inverseMercator(double d3) {
        return (Math.atan(Math.exp(d3)) * 2.0d) - 1.5707963267948966d;
    }

    static double mercator(double d3) {
        return Math.log(Math.tan((d3 * 0.5d) + 0.7853981633974483d));
    }

    static double mod(double d3, double d4) {
        return ((d3 % d4) + d4) % d4;
    }

    static double sinFromHav(double d3) {
        return Math.sqrt(d3 * (1.0d - d3)) * 2.0d;
    }

    static double sinSumFromHav(double d3, double d4) {
        double sqrt = Math.sqrt((1.0d - d3) * d3);
        double sqrt2 = Math.sqrt((1.0d - d4) * d4);
        return ((sqrt + sqrt2) - (((sqrt * d4) + (sqrt2 * d3)) * 2.0d)) * 2.0d;
    }

    static double wrap(double d3, double d4, double d5) {
        return (d3 < d4 || d3 >= d5) ? mod(d3 - d4, d5 - d4) + d4 : d3;
    }
}
