package org.mapsforge.map.layer;

import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public abstract class Layer {
    private Redrawer assignedRedrawer;
    protected DisplayModel displayModel;
    private boolean visible = true;

    final synchronized void assign(Redrawer redrawer) {
        if (this.assignedRedrawer != null) {
            throw new IllegalStateException("layer already assigned");
        }
        this.assignedRedrawer = redrawer;
        onAdd();
    }

    public abstract void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point);

    public synchronized DisplayModel getDisplayModel() {
        return this.displayModel;
    }

    public LatLong getPosition() {
        return null;
    }

    public final boolean isVisible() {
        return this.visible;
    }

    protected void onAdd() {
    }

    public void onDestroy() {
    }

    public boolean onLongPress(LatLong latLong, Point point, Point point2) {
        return false;
    }

    protected void onRemove() {
    }

    public boolean onScroll(float f3, float f4, float f5, float f6) {
        return false;
    }

    public boolean onTap(LatLong latLong, Point point, Point point2) {
        return false;
    }

    public final synchronized void requestRedraw() {
        Redrawer redrawer = this.assignedRedrawer;
        if (redrawer != null) {
            redrawer.redrawLayers();
        }
    }

    public synchronized void setDisplayModel(DisplayModel displayModel) {
        this.displayModel = displayModel;
    }

    public final void setVisible(boolean z3) {
        setVisible(z3, true);
    }

    public void setVisible(boolean z3, boolean z4) {
        this.visible = z3;
        if (z4) {
            requestRedraw();
        }
    }

    final synchronized void unassign() {
        if (this.assignedRedrawer == null) {
            throw new IllegalStateException("layer is not assigned");
        }
        this.assignedRedrawer = null;
        onRemove();
    }
}
