package org.mapsforge.map.datastore;

import java.util.List;
import java.util.Locale;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Tag;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public abstract class MapDataStore {
    protected String preferredLanguage;

    public MapDataStore() {
        this(null);
    }

    public MapDataStore(String str) {
        this.preferredLanguage = str;
    }

    public static String extract(String str, String str2) {
        String str3 = null;
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] split = str.split("\r");
        if (str2 == null || str2.trim().isEmpty()) {
            return split[0];
        }
        for (int i3 = 1; i3 < split.length; i3++) {
            String[] split2 = split[i3].split("\b");
            if (split2.length == 2) {
                if (split2[0].equalsIgnoreCase(str2)) {
                    return split2[1];
                }
                if (str3 == null && !split2[0].contains("-") && (str2.contains("-") || str2.contains("_"))) {
                    Locale locale = Locale.ENGLISH;
                    if (str2.toLowerCase(locale).startsWith(split2[0].toLowerCase(locale))) {
                        str3 = split2[1];
                    }
                }
            }
        }
        return str3 != null ? str3 : split[0];
    }

    public abstract BoundingBox boundingBox();

    public abstract void close();

    protected String extractLocalized(String str) {
        return extract(str, this.preferredLanguage);
    }

    public abstract long getDataTimestamp(Tile tile);

    public MapReadResult readLabels(Tile tile) {
        return readMapData(tile);
    }

    public MapReadResult readLabels(Tile tile, Tile tile2) {
        if (tile.tileX > tile2.tileX || tile.tileY > tile2.tileY) {
            new IllegalArgumentException("upperLeft tile must be above and left of lowerRight tile");
        }
        MapReadResult mapReadResult = new MapReadResult();
        for (int i3 = tile.tileX; i3 <= tile2.tileX; i3++) {
            for (int i4 = tile.tileY; i4 <= tile2.tileY; i4++) {
                mapReadResult.add(readLabels(new Tile(i3, i4, tile.zoomLevel, tile.tileSize)), false);
            }
        }
        return mapReadResult;
    }

    public abstract MapReadResult readMapData(Tile tile);

    public MapReadResult readMapData(Tile tile, Tile tile2) {
        if (tile.tileX > tile2.tileX || tile.tileY > tile2.tileY) {
            new IllegalArgumentException("upperLeft tile must be above and left of lowerRight tile");
        }
        MapReadResult mapReadResult = new MapReadResult();
        for (int i3 = tile.tileX; i3 <= tile2.tileX; i3++) {
            for (int i4 = tile.tileY; i4 <= tile2.tileY; i4++) {
                mapReadResult.add(readMapData(new Tile(i3, i4, tile.zoomLevel, tile.tileSize)), false);
            }
        }
        return mapReadResult;
    }

    public abstract MapReadResult readPoiData(Tile tile);

    public MapReadResult readPoiData(Tile tile, Tile tile2) {
        if (tile.tileX > tile2.tileX || tile.tileY > tile2.tileY) {
            new IllegalArgumentException("upperLeft tile must be above and left of lowerRight tile");
        }
        MapReadResult mapReadResult = new MapReadResult();
        for (int i3 = tile.tileX; i3 <= tile2.tileX; i3++) {
            for (int i4 = tile.tileY; i4 <= tile2.tileY; i4++) {
                mapReadResult.add(readPoiData(new Tile(i3, i4, tile.zoomLevel, tile.tileSize)), false);
            }
        }
        return mapReadResult;
    }

    public abstract LatLong startPosition();

    public abstract Byte startZoomLevel();

    public abstract boolean supportsTile(Tile tile);

    public boolean wayAsLabelTagFilter(List<Tag> list) {
        return false;
    }
}
