package org.mapsforge.core.util;

import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public final class MercatorProjection {
    private static final int DUMMY_TILE_SIZE = 256;
    public static final double EARTH_CIRCUMFERENCE = 4.0075016686E7d;
    public static final double LATITUDE_MAX = 85.05112877980659d;
    public static final double LATITUDE_MIN = -85.05112877980659d;

    private MercatorProjection() {
        throw new IllegalStateException();
    }

    public static double calculateGroundResolution(double d3, long j3) {
        return (Math.cos(d3 * 0.017453292519943295d) * 4.0075016686E7d) / j3;
    }

    public static double calculateGroundResolutionWithScaleFactor(double d3, double d4, int i3) {
        return (Math.cos(d3 * 0.017453292519943295d) * 4.0075016686E7d) / getMapSizeWithScaleFactor(d4, i3);
    }

    public static LatLong fromPixels(double d3, double d4, long j3) {
        return new LatLong(pixelYToLatitude(d4, j3), pixelXToLongitude(d3, j3));
    }

    public static LatLong fromPixelsWithScaleFactor(double d3, double d4, double d5, int i3) {
        return new LatLong(pixelYToLatitudeWithScaleFactor(d4, d5, i3), pixelXToLongitudeWithScaleFactor(d3, d5, i3));
    }

    public static long getMapSize(byte b4, int i3) {
        if (b4 >= 0) {
            return i3 << b4;
        }
        throw new IllegalArgumentException("zoom level must not be negative: " + ((int) b4));
    }

    public static long getMapSizeWithScaleFactor(double d3, int i3) {
        if (d3 >= 1.0d) {
            return (long) (i3 * Math.pow(2.0d, scaleFactorToZoomLevel(d3)));
        }
        throw new IllegalArgumentException("scale factor must not < 1 " + d3);
    }

    public static Point getPixel(LatLong latLong, long j3) {
        return new Point(longitudeToPixelX(latLong.longitude, j3), latitudeToPixelY(latLong.latitude, j3));
    }

    public static Point getPixelAbsolute(LatLong latLong, long j3) {
        return getPixelRelative(latLong, j3, 0.0d, 0.0d);
    }

    public static Point getPixelRelative(LatLong latLong, long j3, double d3, double d4) {
        return new Point(longitudeToPixelX(latLong.longitude, j3) - d3, latitudeToPixelY(latLong.latitude, j3) - d4);
    }

    public static Point getPixelRelative(LatLong latLong, long j3, Point point) {
        return getPixelRelative(latLong, j3, point.f4076x, point.f4077y);
    }

    public static Point getPixelRelativeToTile(LatLong latLong, Tile tile) {
        return getPixelRelative(latLong, tile.mapSize, tile.getOrigin());
    }

    public static Point getPixelWithScaleFactor(LatLong latLong, double d3, int i3) {
        return new Point(longitudeToPixelXWithScaleFactor(latLong.longitude, d3, i3), latitudeToPixelYWithScaleFactor(latLong.latitude, d3, i3));
    }

    public static double latitudeToPixelY(double d3, byte b4, int i3) {
        double sin = Math.sin(d3 * 0.017453292519943295d);
        long mapSize = getMapSize(b4, i3);
        double log = 0.5d - (Math.log((sin + 1.0d) / (1.0d - sin)) / 12.566370614359172d);
        double d4 = mapSize;
        return Math.min(Math.max(0.0d, log * d4), d4);
    }

    public static double latitudeToPixelY(double d3, long j3) {
        double sin = Math.sin(d3 * 0.017453292519943295d);
        double log = 0.5d - (Math.log((sin + 1.0d) / (1.0d - sin)) / 12.566370614359172d);
        double d4 = j3;
        return Math.min(Math.max(0.0d, log * d4), d4);
    }

    public static double latitudeToPixelYWithScaleFactor(double d3, double d4, int i3) {
        double sin = Math.sin(d3 * 0.017453292519943295d);
        long mapSizeWithScaleFactor = getMapSizeWithScaleFactor(d4, i3);
        double log = 0.5d - (Math.log((sin + 1.0d) / (1.0d - sin)) / 12.566370614359172d);
        double d5 = mapSizeWithScaleFactor;
        return Math.min(Math.max(0.0d, log * d5), d5);
    }

    public static int latitudeToTileY(double d3, byte b4) {
        return pixelYToTileY(latitudeToPixelY(d3, b4, 256), b4, 256);
    }

    public static int latitudeToTileYWithScaleFactor(double d3, double d4) {
        return pixelYToTileYWithScaleFactor(latitudeToPixelYWithScaleFactor(d3, d4, 256), d4, 256);
    }

    public static double longitudeToPixelX(double d3, byte b4, int i3) {
        return ((d3 + 180.0d) / 360.0d) * getMapSize(b4, i3);
    }

    public static double longitudeToPixelX(double d3, long j3) {
        return ((d3 + 180.0d) / 360.0d) * j3;
    }

    public static double longitudeToPixelXWithScaleFactor(double d3, double d4, int i3) {
        return ((d3 + 180.0d) / 360.0d) * getMapSizeWithScaleFactor(d4, i3);
    }

    public static int longitudeToTileX(double d3, byte b4) {
        return pixelXToTileX(longitudeToPixelX(d3, b4, 256), b4, 256);
    }

    public static int longitudeToTileXWithScaleFactor(double d3, double d4) {
        return pixelXToTileXWithScaleFactor(longitudeToPixelXWithScaleFactor(d3, d4, 256), d4, 256);
    }

    public static double metersToPixels(float f3, double d3, long j3) {
        return f3 / calculateGroundResolution(d3, j3);
    }

    public static double metersToPixelsWithScaleFactor(float f3, double d3, double d4, int i3) {
        return f3 / calculateGroundResolutionWithScaleFactor(d3, d4, i3);
    }

    public static double pixelXToLongitude(double d3, long j3) {
        if (d3 >= 0.0d) {
            double d4 = j3;
            if (d3 <= d4) {
                return ((d3 / d4) - 0.5d) * 360.0d;
            }
        }
        throw new IllegalArgumentException("invalid pixelX coordinate " + j3 + ": " + d3);
    }

    public static double pixelXToLongitudeWithScaleFactor(double d3, double d4, int i3) {
        long mapSizeWithScaleFactor = getMapSizeWithScaleFactor(d4, i3);
        if (d3 >= 0.0d) {
            double d5 = mapSizeWithScaleFactor;
            if (d3 <= d5) {
                return ((d3 / d5) - 0.5d) * 360.0d;
            }
        }
        throw new IllegalArgumentException("invalid pixelX coordinate at scale " + d4 + ": " + d3);
    }

    public static int pixelXToTileX(double d3, byte b4, int i3) {
        return (int) Math.min(Math.max(d3 / i3, 0.0d), Math.pow(2.0d, b4) - 1.0d);
    }

    public static int pixelXToTileXWithScaleFactor(double d3, double d4, int i3) {
        return (int) Math.min(Math.max(d3 / i3, 0.0d), d4 - 1.0d);
    }

    public static double pixelYToLatitude(double d3, long j3) {
        if (d3 >= 0.0d) {
            double d4 = j3;
            if (d3 <= d4) {
                return 90.0d - ((Math.atan(Math.exp((-(0.5d - (d3 / d4))) * 6.283185307179586d)) * 360.0d) / 3.141592653589793d);
            }
        }
        throw new IllegalArgumentException("invalid pixelY coordinate " + j3 + ": " + d3);
    }

    public static double pixelYToLatitudeWithScaleFactor(double d3, double d4, int i3) {
        long mapSizeWithScaleFactor = getMapSizeWithScaleFactor(d4, i3);
        if (d3 >= 0.0d) {
            double d5 = mapSizeWithScaleFactor;
            if (d3 <= d5) {
                return 90.0d - ((Math.atan(Math.exp((-(0.5d - (d3 / d5))) * 6.283185307179586d)) * 360.0d) / 3.141592653589793d);
            }
        }
        throw new IllegalArgumentException("invalid pixelY coordinate at scale " + d4 + ": " + d3);
    }

    public static int pixelYToTileY(double d3, byte b4, int i3) {
        return (int) Math.min(Math.max(d3 / i3, 0.0d), Math.pow(2.0d, b4) - 1.0d);
    }

    public static int pixelYToTileYWithScaleFactor(double d3, double d4, int i3) {
        return (int) Math.min(Math.max(d3 / i3, 0.0d), d4 - 1.0d);
    }

    public static double scaleFactorToZoomLevel(double d3) {
        return Math.log(d3) / Math.log(2.0d);
    }

    public static long tileToPixel(long j3, int i3) {
        return j3 * i3;
    }

    public static double tileXToLongitude(long j3, byte b4) {
        return pixelXToLongitude(j3 * 256, getMapSize(b4, 256));
    }

    public static double tileXToLongitudeWithScaleFactor(long j3, double d3) {
        return pixelXToLongitudeWithScaleFactor(j3 * 256, d3, 256);
    }

    public static double tileYToLatitude(long j3, byte b4) {
        return pixelYToLatitude(j3 * 256, getMapSize(b4, 256));
    }

    public static double tileYToLatitudeWithScaleFactor(long j3, double d3) {
        return pixelYToLatitudeWithScaleFactor(j3 * 256, d3, 256);
    }

    public static double zoomLevelToScaleFactor(byte b4) {
        return Math.pow(2.0d, b4);
    }
}
