package org.mapsforge.core.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mapsforge.core.util.LatLongUtils;

/* loaded from: /root/release/classes2.dex */
public class LatLong implements Comparable<LatLong> {
    private static final Pattern WKT_POINT_PATTERN = Pattern.compile(".*POINT\\s?\\(([\\d\\.]+)\\s([\\d\\.]+)\\).*");
    public final double latitude;
    public final double longitude;

    public LatLong(double d3, double d4) {
        this.latitude = LatLongUtils.validateLatitude(d3);
        this.longitude = LatLongUtils.validateLongitude(d4);
    }

    public LatLong(String str) {
        Matcher matcher = WKT_POINT_PATTERN.matcher(str);
        matcher.matches();
        this.longitude = LatLongUtils.validateLongitude(Double.parseDouble(matcher.group(1)));
        this.latitude = LatLongUtils.validateLatitude(Double.parseDouble(matcher.group(2)));
    }

    public static LatLong fromMicroDegrees(int i3, int i4) {
        return new LatLong(LatLongUtils.microdegreesToDegrees(i3), LatLongUtils.microdegreesToDegrees(i4));
    }

    public static LatLong fromString(String str) {
        String[] split = str.split("[,;:\\s]");
        if (split.length == 2) {
            return new LatLong(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        }
        throw new IllegalArgumentException("cannot read coordinate, not a valid format");
    }

    @Override // java.lang.Comparable
    public int compareTo(LatLong latLong) {
        double d3 = this.latitude;
        double d4 = latLong.latitude;
        if (d3 > d4) {
            return 1;
        }
        double d5 = this.longitude;
        double d6 = latLong.longitude;
        if (d5 > d6) {
            return 1;
        }
        return (d3 < d4 || d5 < d6) ? -1 : 0;
    }

    public LatLong destinationPoint(double d3, float f3) {
        return LatLongUtils.destinationPoint(this, d3, f3);
    }

    public double distance(LatLong latLong) {
        return LatLongUtils.distance(this, latLong);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLong)) {
            return false;
        }
        LatLong latLong = (LatLong) obj;
        return this.latitude == latLong.latitude && this.longitude == latLong.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public int getLatitudeE6() {
        return LatLongUtils.degreesToMicrodegrees(this.latitude);
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getLongitudeE6() {
        return LatLongUtils.degreesToMicrodegrees(this.longitude);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i3 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i3 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public double sphericalDistance(LatLong latLong) {
        return LatLongUtils.sphericalDistance(this, latLong);
    }

    public String toString() {
        return "latitude=" + this.latitude + ", longitude=" + this.longitude;
    }

    public double vincentyDistance(LatLong latLong) {
        return LatLongUtils.vincentyDistance(this, latLong);
    }
}
