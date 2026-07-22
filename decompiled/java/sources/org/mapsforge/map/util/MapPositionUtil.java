package org.mapsforge.map.util;

import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.MercatorProjection;

/* loaded from: /root/release/classes2.dex */
public final class MapPositionUtil {
    private MapPositionUtil() {
        throw new IllegalStateException();
    }

    public static BoundingBox getBoundingBox(MapPosition mapPosition, Dimension dimension, int i3) {
        long mapSize = MercatorProjection.getMapSize(mapPosition.zoomLevel, i3);
        double longitudeToPixelX = MercatorProjection.longitudeToPixelX(mapPosition.latLong.longitude, mapSize);
        double latitudeToPixelY = MercatorProjection.latitudeToPixelY(mapPosition.latLong.latitude, mapSize);
        int i4 = dimension.width / 2;
        double d3 = i4;
        double d4 = dimension.height / 2;
        double d5 = mapSize;
        return new BoundingBox(MercatorProjection.pixelYToLatitude(Math.min(d5, latitudeToPixelY + d4), mapSize), MercatorProjection.pixelXToLongitude(Math.max(0.0d, longitudeToPixelX - d3), mapSize), MercatorProjection.pixelYToLatitude(Math.max(0.0d, latitudeToPixelY - d4), mapSize), MercatorProjection.pixelXToLongitude(Math.min(d5, longitudeToPixelX + d3), mapSize));
    }

    public static Point getTopLeftPoint(MapPosition mapPosition, Dimension dimension, int i3) {
        LatLong latLong = mapPosition.latLong;
        int i4 = dimension.width / 2;
        int i5 = dimension.height / 2;
        long mapSize = MercatorProjection.getMapSize(mapPosition.zoomLevel, i3);
        return new Point(Math.round(MercatorProjection.longitudeToPixelX(latLong.longitude, mapSize)) - i4, Math.round(MercatorProjection.latitudeToPixelY(latLong.latitude, mapSize)) - i5);
    }
}
