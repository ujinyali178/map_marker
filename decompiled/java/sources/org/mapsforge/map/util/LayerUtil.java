package org.mapsforge.map.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.TilePosition;

/* loaded from: /root/release/classes2.dex */
public final class LayerUtil {
    private LayerUtil() {
        throw new IllegalStateException();
    }

    public static List<MapElementContainer> collisionFreeOrdered(List<MapElementContainer> list) {
        Collections.sort(list, Collections.reverseOrder());
        LinkedList linkedList = new LinkedList();
        for (MapElementContainer mapElementContainer : list) {
            boolean z3 = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((MapElementContainer) it.next()).clashesWith(mapElementContainer)) {
                    z3 = false;
                    break;
                }
            }
            if (z3) {
                linkedList.add(mapElementContainer);
            }
        }
        return linkedList;
    }

    public static Tile getLowerRight(BoundingBox boundingBox, byte b4, int i3) {
        return new Tile(MercatorProjection.longitudeToTileX(boundingBox.maxLongitude, b4), MercatorProjection.latitudeToTileY(boundingBox.minLatitude, b4), b4, i3);
    }

    public static List<TilePosition> getTilePositions(BoundingBox boundingBox, byte b4, Point point, int i3) {
        int longitudeToTileX = MercatorProjection.longitudeToTileX(boundingBox.minLongitude, b4);
        int latitudeToTileY = MercatorProjection.latitudeToTileY(boundingBox.maxLatitude, b4);
        int longitudeToTileX2 = MercatorProjection.longitudeToTileX(boundingBox.maxLongitude, b4);
        int latitudeToTileY2 = MercatorProjection.latitudeToTileY(boundingBox.minLatitude, b4);
        ArrayList arrayList = new ArrayList(((longitudeToTileX2 - longitudeToTileX) + 1) * ((latitudeToTileY2 - latitudeToTileY) + 1));
        while (latitudeToTileY <= latitudeToTileY2) {
            for (int i4 = longitudeToTileX; i4 <= longitudeToTileX2; i4++) {
                arrayList.add(new TilePosition(new Tile(i4, latitudeToTileY, b4, i3), new Point(MercatorProjection.tileToPixel(i4, i3) - point.f4076x, MercatorProjection.tileToPixel(latitudeToTileY, i3) - point.f4077y)));
            }
            latitudeToTileY++;
        }
        return arrayList;
    }

    public static Set<Tile> getTiles(BoundingBox boundingBox, byte b4, int i3) {
        int longitudeToTileX = MercatorProjection.longitudeToTileX(boundingBox.minLongitude, b4);
        int longitudeToTileX2 = MercatorProjection.longitudeToTileX(boundingBox.maxLongitude, b4);
        int latitudeToTileY = MercatorProjection.latitudeToTileY(boundingBox.minLatitude, b4);
        HashSet hashSet = new HashSet();
        for (int latitudeToTileY2 = MercatorProjection.latitudeToTileY(boundingBox.maxLatitude, b4); latitudeToTileY2 <= latitudeToTileY; latitudeToTileY2++) {
            for (int i4 = longitudeToTileX; i4 <= longitudeToTileX2; i4++) {
                hashSet.add(new Tile(i4, latitudeToTileY2, b4, i3));
            }
        }
        return hashSet;
    }

    public static Set<Tile> getTiles(Tile tile, Tile tile2) {
        HashSet hashSet = new HashSet();
        for (int i3 = tile.tileY; i3 <= tile2.tileY; i3++) {
            for (int i4 = tile.tileX; i4 <= tile2.tileX; i4++) {
                hashSet.add(new Tile(i4, i3, tile.zoomLevel, tile.tileSize));
            }
        }
        return hashSet;
    }

    public static Tile getUpperLeft(BoundingBox boundingBox, byte b4, int i3) {
        return new Tile(MercatorProjection.longitudeToTileX(boundingBox.minLongitude, b4), MercatorProjection.latitudeToTileY(boundingBox.maxLatitude, b4), b4, i3);
    }
}
