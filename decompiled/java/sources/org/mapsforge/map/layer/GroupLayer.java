package org.mapsforge.map.layer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public class GroupLayer extends Layer {
    public final List<Layer> layers = new ArrayList();

    @Override // org.mapsforge.map.layer.Layer
    public void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        Iterator<Layer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().draw(boundingBox, b4, canvas, point);
        }
    }

    @Override // org.mapsforge.map.layer.Layer
    public void onDestroy() {
        Iterator<Layer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // org.mapsforge.map.layer.Layer
    public boolean onLongPress(LatLong latLong, Point point, Point point2) {
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (this.layers.get(size).onLongPress(latLong, point, point2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mapsforge.map.layer.Layer
    public boolean onTap(LatLong latLong, Point point, Point point2) {
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (this.layers.get(size).onTap(latLong, point, point2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized void setDisplayModel(DisplayModel displayModel) {
        super.setDisplayModel(displayModel);
        Iterator<Layer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().setDisplayModel(displayModel);
        }
    }
}
