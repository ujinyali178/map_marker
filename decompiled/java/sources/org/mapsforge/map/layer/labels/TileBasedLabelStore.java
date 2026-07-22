package org.mapsforge.map.layer.labels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.Tile;
import org.mapsforge.core.util.WorkingSetCache;
import org.mapsforge.map.util.LayerUtil;

/* loaded from: /root/release/classes2.dex */
public class TileBasedLabelStore extends WorkingSetCache<Tile, List<MapElementContainer>> implements LabelStore {
    private static final long serialVersionUID = 1;
    private Set<Tile> lastVisibleTileSet;
    private int version;

    public TileBasedLabelStore(int i3) {
        super(i3);
        this.lastVisibleTileSet = new HashSet();
    }

    private synchronized List<MapElementContainer> getVisibleItems(Set<Tile> set) {
        ArrayList arrayList;
        this.lastVisibleTileSet = set;
        arrayList = new ArrayList();
        for (Tile tile : this.lastVisibleTileSet) {
            if (containsKey(tile)) {
                arrayList.addAll(get(tile));
            }
        }
        return arrayList;
    }

    public void destroy() {
        clear();
    }

    @Override // org.mapsforge.map.layer.labels.LabelStore
    public int getVersion() {
        return this.version;
    }

    @Override // org.mapsforge.map.layer.labels.LabelStore
    public synchronized List<MapElementContainer> getVisibleItems(Tile tile, Tile tile2) {
        return getVisibleItems(LayerUtil.getTiles(tile, tile2));
    }

    @Override // org.mapsforge.core.util.LRUCache, java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<Tile, List<MapElementContainer>> entry) {
        return size() > this.capacity;
    }

    public synchronized boolean requiresTile(Tile tile) {
        boolean z3;
        if (this.lastVisibleTileSet.contains(tile)) {
            z3 = containsKey(tile) ? false : true;
        }
        return z3;
    }

    public synchronized void storeMapItems(Tile tile, List<MapElementContainer> list) {
        put(tile, LayerUtil.collisionFreeOrdered(list));
        this.version++;
    }
}
