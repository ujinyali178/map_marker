package org.mapsforge.map.layer.labels;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.util.LayerUtil;

/* loaded from: /root/release/classes2.dex */
public class ThreadedLabelLayer extends LabelLayer {
    ExecutorService executorService;
    Future<?> future;
    Tile requestedLowerRight;
    Tile requestedUpperLeft;

    public ThreadedLabelLayer(GraphicFactory graphicFactory, LabelStore labelStore) {
        super(graphicFactory, labelStore);
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override // org.mapsforge.map.layer.labels.LabelLayer, org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        Tile upperLeft = LayerUtil.getUpperLeft(boundingBox, b4, this.displayModel.getTileSize());
        Tile lowerRight = LayerUtil.getLowerRight(boundingBox, b4, this.displayModel.getTileSize());
        if (!upperLeft.equals(this.upperLeft) || !lowerRight.equals(this.lowerRight) || this.lastLabelStoreVersion != this.labelStore.getVersion()) {
            getData(upperLeft, lowerRight);
        }
        Tile tile = this.upperLeft;
        if (tile == null || !Tile.tileAreasOverlap(tile, this.lowerRight, upperLeft, lowerRight)) {
            return;
        }
        draw(canvas, point);
    }

    protected void getData(final Tile tile, final Tile tile2) {
        if (tile.equals(this.requestedUpperLeft) && tile2.equals(this.requestedLowerRight)) {
            return;
        }
        this.requestedUpperLeft = tile;
        this.requestedLowerRight = tile2;
        Future<?> future = this.future;
        if (future != null) {
            future.cancel(false);
        }
        this.future = this.executorService.submit(new Runnable() { // from class: org.mapsforge.map.layer.labels.ThreadedLabelLayer.1
            @Override // java.lang.Runnable
            public void run() {
                List<MapElementContainer> visibleItems = ThreadedLabelLayer.this.labelStore.getVisibleItems(tile, tile2);
                ThreadedLabelLayer.this.elementsToDraw = LayerUtil.collisionFreeOrdered(visibleItems);
                Collections.sort(ThreadedLabelLayer.this.elementsToDraw);
                ThreadedLabelLayer threadedLabelLayer = ThreadedLabelLayer.this;
                threadedLabelLayer.upperLeft = tile;
                threadedLabelLayer.lowerRight = tile2;
                threadedLabelLayer.lastLabelStoreVersion = threadedLabelLayer.labelStore.getVersion();
                ThreadedLabelLayer.this.requestRedraw();
            }
        });
    }

    @Override // org.mapsforge.map.layer.Layer
    public void onDestroy() {
        this.executorService.shutdownNow();
    }
}
