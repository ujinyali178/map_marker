package org.mapsforge.map.layer.renderer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
public class TileDependencies {
    Map<Tile, Map<Tile, Set<MapElementContainer>>> overlapData = new HashMap();
    Set<Tile> tilesInProgress = new HashSet();

    TileDependencies() {
    }

    void addOverlappingElement(Tile tile, Tile tile2, MapElementContainer mapElementContainer) {
        if (!this.overlapData.containsKey(tile)) {
            this.overlapData.put(tile, new HashMap());
        }
        if (!this.overlapData.get(tile).containsKey(tile2)) {
            this.overlapData.get(tile).put(tile2, new HashSet());
        }
        this.overlapData.get(tile).get(tile2).add(mapElementContainer);
    }

    synchronized void addTileInProgress(Tile tile) {
        this.tilesInProgress.add(tile);
    }

    Set<MapElementContainer> getOverlappingElements(Tile tile, Tile tile2) {
        return (this.overlapData.containsKey(tile) && this.overlapData.get(tile).containsKey(tile2)) ? this.overlapData.get(tile).get(tile2) : new HashSet(0);
    }

    synchronized boolean isTileInProgress(Tile tile) {
        return this.tilesInProgress.contains(tile);
    }

    void removeTileData(Tile tile) {
        this.overlapData.remove(tile);
    }

    void removeTileData(Tile tile, Tile tile2) {
        if (this.overlapData.containsKey(tile)) {
            this.overlapData.get(tile).remove(tile2);
        }
    }

    synchronized void removeTileInProgress(Tile tile) {
        this.tilesInProgress.remove(tile);
    }
}
