package org.mapsforge.core.model;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Serializable;
import java.util.List;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.core.util.MercatorProjection;

/* loaded from: /root/release/classes2.dex */
public class BoundingBox implements Serializable {
    private static final long serialVersionUID = 1;
    public final double maxLatitude;
    public final double maxLongitude;
    public final double minLatitude;
    public final double minLongitude;

    public BoundingBox(double d3, double d4, double d5, double d6) {
        LatLongUtils.validateLatitude(d3);
        LatLongUtils.validateLongitude(d4);
        LatLongUtils.validateLatitude(d5);
        LatLongUtils.validateLongitude(d6);
        if (d3 > d5) {
            throw new IllegalArgumentException("invalid latitude range: " + d3 + ' ' + d5);
        }
        if (d4 <= d6) {
            this.minLatitude = d3;
            this.minLongitude = d4;
            this.maxLatitude = d5;
            this.maxLongitude = d6;
            return;
        }
        throw new IllegalArgumentException("invalid longitude range: " + d4 + ' ' + d6);
    }

    public BoundingBox(List<LatLong> list) {
        double d3 = Double.NEGATIVE_INFINITY;
        double d4 = Double.POSITIVE_INFINITY;
        double d5 = Double.POSITIVE_INFINITY;
        double d6 = Double.NEGATIVE_INFINITY;
        for (LatLong latLong : list) {
            double d7 = latLong.latitude;
            double d8 = latLong.longitude;
            d4 = Math.min(d4, d7);
            d5 = Math.min(d5, d8);
            d3 = Math.max(d3, d7);
            d6 = Math.max(d6, d8);
        }
        this.minLatitude = d4;
        this.minLongitude = d5;
        this.maxLatitude = d3;
        this.maxLongitude = d6;
    }

    public static BoundingBox fromString(String str) {
        double[] parseCoordinateString = LatLongUtils.parseCoordinateString(str, 4);
        return new BoundingBox(parseCoordinateString[0], parseCoordinateString[1], parseCoordinateString[2], parseCoordinateString[3]);
    }

    public boolean contains(double d3, double d4) {
        return this.minLatitude <= d3 && this.maxLatitude >= d3 && this.minLongitude <= d4 && this.maxLongitude >= d4;
    }

    public boolean contains(LatLong latLong) {
        return contains(latLong.latitude, latLong.longitude);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoundingBox)) {
            return false;
        }
        BoundingBox boundingBox = (BoundingBox) obj;
        return Double.doubleToLongBits(this.maxLatitude) == Double.doubleToLongBits(boundingBox.maxLatitude) && Double.doubleToLongBits(this.maxLongitude) == Double.doubleToLongBits(boundingBox.maxLongitude) && Double.doubleToLongBits(this.minLatitude) == Double.doubleToLongBits(boundingBox.minLatitude) && Double.doubleToLongBits(this.minLongitude) == Double.doubleToLongBits(boundingBox.minLongitude);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        return new BoundingBox(Math.min(this.minLatitude, boundingBox.minLatitude), Math.min(this.minLongitude, boundingBox.minLongitude), Math.max(this.maxLatitude, boundingBox.maxLatitude), Math.max(this.maxLongitude, boundingBox.maxLongitude));
    }

    public BoundingBox extendCoordinates(double d3, double d4) {
        return contains(d3, d4) ? this : new BoundingBox(Math.max(-85.05112877980659d, Math.min(this.minLatitude, d3)), Math.max(-180.0d, Math.min(this.minLongitude, d4)), Math.min(85.05112877980659d, Math.max(this.maxLatitude, d3)), Math.min(180.0d, Math.max(this.maxLongitude, d4)));
    }

    public BoundingBox extendCoordinates(LatLong latLong) {
        return extendCoordinates(latLong.latitude, latLong.longitude);
    }

    public BoundingBox extendDegrees(double d3, double d4) {
        if (d3 == 0.0d && d4 == 0.0d) {
            return this;
        }
        if (d3 < 0.0d || d4 < 0.0d) {
            throw new IllegalArgumentException("BoundingBox extend operation does not accept negative values");
        }
        return new BoundingBox(Math.max(-85.05112877980659d, this.minLatitude - d3), Math.max(-180.0d, this.minLongitude - d4), Math.min(85.05112877980659d, this.maxLatitude + d3), Math.min(180.0d, this.maxLongitude + d4));
    }

    public BoundingBox extendMargin(float f3) {
        if (f3 == 1.0f) {
            return this;
        }
        if (f3 <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("BoundingBox extend operation does not accept negative or zero values");
        }
        double d3 = f3;
        double latitudeSpan = ((getLatitudeSpan() * d3) - getLatitudeSpan()) * 0.5d;
        double longitudeSpan = ((getLongitudeSpan() * d3) - getLongitudeSpan()) * 0.5d;
        return new BoundingBox(Math.max(-85.05112877980659d, this.minLatitude - latitudeSpan), Math.max(-180.0d, this.minLongitude - longitudeSpan), Math.min(85.05112877980659d, this.maxLatitude + latitudeSpan), Math.min(180.0d, this.maxLongitude + longitudeSpan));
    }

    public BoundingBox extendMeters(int i3) {
        if (i3 == 0) {
            return this;
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("BoundingBox extend operation does not accept negative values");
        }
        double latitudeDistance = LatLongUtils.latitudeDistance(i3);
        double longitudeDistance = LatLongUtils.longitudeDistance(i3, Math.max(Math.abs(this.minLatitude), Math.abs(this.maxLatitude)));
        return new BoundingBox(Math.max(-85.05112877980659d, this.minLatitude - latitudeDistance), Math.max(-180.0d, this.minLongitude - longitudeDistance), Math.min(85.05112877980659d, this.maxLatitude + latitudeDistance), Math.min(180.0d, this.maxLongitude + longitudeDistance));
    }

    public LatLong getCenterPoint() {
        return new LatLong(this.minLatitude + ((this.maxLatitude - this.minLatitude) / 2.0d), this.minLongitude + ((this.maxLongitude - this.minLongitude) / 2.0d));
    }

    public double getLatitudeSpan() {
        return this.maxLatitude - this.minLatitude;
    }

    public double getLongitudeSpan() {
        return this.maxLongitude - this.minLongitude;
    }

    public Rectangle getPositionRelativeToTile(Tile tile) {
        Point pixelRelativeToTile = MercatorProjection.getPixelRelativeToTile(new LatLong(this.maxLatitude, this.minLongitude), tile);
        Point pixelRelativeToTile2 = MercatorProjection.getPixelRelativeToTile(new LatLong(this.minLatitude, this.maxLongitude), tile);
        return new Rectangle(pixelRelativeToTile.f4076x, pixelRelativeToTile.f4077y, pixelRelativeToTile2.f4076x, pixelRelativeToTile2.f4077y);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.maxLatitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.maxLongitude);
        int i3 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.minLatitude);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.minLongitude);
        return (i4 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean intersects(BoundingBox boundingBox) {
        if (this == boundingBox) {
            return true;
        }
        return this.maxLatitude >= boundingBox.minLatitude && this.maxLongitude >= boundingBox.minLongitude && this.minLatitude <= boundingBox.maxLatitude && this.minLongitude <= boundingBox.maxLongitude;
    }

    public boolean intersectsArea(LatLong[][] latLongArr) {
        LatLong[][] latLongArr2 = latLongArr;
        if (latLongArr2.length == 0 || latLongArr2[0].length == 0) {
            return false;
        }
        for (LatLong[] latLongArr3 : latLongArr2) {
            for (LatLong latLong : latLongArr3) {
                if (contains(latLong)) {
                    return true;
                }
            }
        }
        LatLong latLong2 = latLongArr2[0][0];
        double d3 = latLong2.latitude;
        double d4 = latLong2.longitude;
        int length = latLongArr2.length;
        double d5 = d3;
        double d6 = d5;
        double d7 = d4;
        double d8 = d7;
        int i3 = 0;
        while (i3 < length) {
            LatLong[] latLongArr4 = latLongArr2[i3];
            int length2 = latLongArr4.length;
            double d9 = d8;
            int i4 = 0;
            while (i4 < length2) {
                LatLong latLong3 = latLongArr4[i4];
                d5 = Math.min(d5, latLong3.latitude);
                d6 = Math.max(d6, latLong3.latitude);
                d7 = Math.min(d7, latLong3.longitude);
                d9 = Math.max(d9, latLong3.longitude);
                i4++;
                length = length;
            }
            i3++;
            latLongArr2 = latLongArr;
            d8 = d9;
        }
        return intersects(new BoundingBox(d5, d7, d6, d8));
    }

    public String toString() {
        return "minLatitude=" + this.minLatitude + ", minLongitude=" + this.minLongitude + ", maxLatitude=" + this.maxLatitude + ", maxLongitude=" + this.maxLongitude;
    }
}
