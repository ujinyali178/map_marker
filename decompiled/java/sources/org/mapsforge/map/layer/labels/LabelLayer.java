package org.mapsforge.map.layer.labels;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Matrix;
import org.mapsforge.core.mapelements.MapElementContainer;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.util.LayerUtil;

/* loaded from: /root/release/classes2.dex */
public class LabelLayer extends Layer {
    protected List<MapElementContainer> elementsToDraw;
    protected final LabelStore labelStore;
    protected int lastLabelStoreVersion = -1;
    protected Tile lowerRight;
    protected final Matrix matrix;
    protected Tile upperLeft;

    public LabelLayer(GraphicFactory graphicFactory, LabelStore labelStore) {
        this.labelStore = labelStore;
        this.matrix = graphicFactory.createMatrix();
    }

    protected void draw(Canvas canvas, Point point) {
        Iterator<MapElementContainer> it = this.elementsToDraw.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas, point, this.matrix, this.displayModel.getFilter());
        }
    }

    @Override // org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        Tile upperLeft = LayerUtil.getUpperLeft(boundingBox, b4, this.displayModel.getTileSize());
        Tile lowerRight = LayerUtil.getLowerRight(boundingBox, b4, this.displayModel.getTileSize());
        if (!upperLeft.equals(this.upperLeft) || !lowerRight.equals(this.lowerRight) || this.lastLabelStoreVersion != this.labelStore.getVersion()) {
            this.upperLeft = upperLeft;
            this.lowerRight = lowerRight;
            this.lastLabelStoreVersion = this.labelStore.getVersion();
            List<MapElementContainer> collisionFreeOrdered = LayerUtil.collisionFreeOrdered(this.labelStore.getVisibleItems(this.upperLeft, this.lowerRight));
            this.elementsToDraw = collisionFreeOrdered;
            Collections.sort(collisionFreeOrdered);
        }
        draw(canvas, point);
    }
}
