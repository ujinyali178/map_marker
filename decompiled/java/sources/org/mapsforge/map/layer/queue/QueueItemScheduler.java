package org.mapsforge.map.layer.queue;

import java.util.Collection;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.model.Tile;
import org.mapsforge.core.util.MercatorProjection;

/* loaded from: /root/release/classes2.dex */
final class QueueItemScheduler {
    static final double PENALTY_PER_ZOOM_LEVEL = 10.0d;

    private QueueItemScheduler() {
        throw new IllegalStateException();
    }

    private static double calculatePriority(Tile tile, MapPosition mapPosition, int i3) {
        double tileYToLatitude = MercatorProjection.tileYToLatitude(tile.tileY, tile.zoomLevel);
        double tileXToLongitude = MercatorProjection.tileXToLongitude(tile.tileX, tile.zoomLevel);
        long mapSize = MercatorProjection.getMapSize(mapPosition.zoomLevel, i3);
        double d3 = i3 / 2;
        double longitudeToPixelX = MercatorProjection.longitudeToPixelX(tileXToLongitude, mapSize) + d3;
        double latitudeToPixelY = MercatorProjection.latitudeToPixelY(tileYToLatitude, mapSize) + d3;
        LatLong latLong = mapPosition.latLong;
        return Math.hypot(longitudeToPixelX - MercatorProjection.longitudeToPixelX(latLong.longitude, mapSize), latitudeToPixelY - MercatorProjection.latitudeToPixelY(latLong.latitude, mapSize)) + (i3 * PENALTY_PER_ZOOM_LEVEL * Math.abs(tile.zoomLevel - mapPosition.zoomLevel));
    }

    static <T extends Job> void schedule(Collection<QueueItem<T>> collection, MapPosition mapPosition, int i3) {
        for (QueueItem<T> queueItem : collection) {
            queueItem.setPriority(calculatePriority(queueItem.object.tile, mapPosition, i3));
        }
    }
}
