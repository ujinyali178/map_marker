package org.mapsforge.map.layer.tilestore;

import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.TileLayer;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.queue.Job;
import org.mapsforge.map.model.IMapViewPosition;

/* loaded from: /root/release/classes2.dex */
public class TileStoreLayer extends TileLayer<Job> {
    public TileStoreLayer(TileCache tileCache, IMapViewPosition iMapViewPosition, GraphicFactory graphicFactory, boolean z3) {
        super(tileCache, iMapViewPosition, graphicFactory.createMatrix(), z3, false);
    }

    @Override // org.mapsforge.map.layer.TileLayer
    protected Job createJob(Tile tile) {
        return new Job(tile, this.isTransparent);
    }

    @Override // org.mapsforge.map.layer.TileLayer
    protected boolean isTileStale(Tile tile, TileBitmap tileBitmap) {
        return false;
    }
}
