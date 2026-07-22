package org.mapsforge.map.layer.overlay;

import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
public class FixedPixelCircle extends Circle {
    private boolean scaleRadius;

    public FixedPixelCircle(LatLong latLong, float f3, Paint paint, Paint paint2) {
        this(latLong, f3, paint, paint2, false);
    }

    public FixedPixelCircle(LatLong latLong, float f3, Paint paint, Paint paint2, boolean z3) {
        super(latLong, f3, paint, paint2, z3);
        this.scaleRadius = true;
    }

    public synchronized boolean contains(Point point, Point point2) {
        return point.distance(point2) < ((double) Math.max(this.displayModel.getScaleFactor() * 10.0f, getRadius() * (this.scaleRadius ? this.displayModel.getScaleFactor() : 1.0f)));
    }

    @Override // org.mapsforge.map.layer.overlay.Circle
    protected int getRadiusInPixels(double d3, byte b4) {
        return (int) (getRadius() * (this.scaleRadius ? this.displayModel.getScaleFactor() : 1.0f));
    }

    public boolean isScaleRadius() {
        return this.scaleRadius;
    }

    public void setScaleRadius(boolean z3) {
        this.scaleRadius = z3;
    }
}
