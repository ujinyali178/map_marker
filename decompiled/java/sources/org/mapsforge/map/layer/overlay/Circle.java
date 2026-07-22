package org.mapsforge.map.layer.overlay;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Rectangle;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.Layer;

/* loaded from: /root/release/classes2.dex */
public class Circle extends Layer {
    private final boolean keepAligned;
    private LatLong latLong;
    private Paint paintFill;
    private Paint paintStroke;
    private float radius;

    public Circle(LatLong latLong, float f3, Paint paint, Paint paint2) {
        this(latLong, f3, paint, paint2, false);
    }

    public Circle(LatLong latLong, float f3, Paint paint, Paint paint2, boolean z3) {
        this.keepAligned = z3;
        this.latLong = latLong;
        setRadiusInternal(f3);
        this.paintFill = paint;
        this.paintStroke = paint2;
    }

    private void setRadiusInternal(float f3) {
        if (f3 >= BitmapDescriptorFactory.HUE_RED && !Float.isNaN(f3)) {
            this.radius = f3;
            return;
        }
        throw new IllegalArgumentException("invalid radius: " + f3);
    }

    public synchronized boolean contains(Point point, Point point2, double d3, byte b4) {
        return point.distance(point2) < ((double) Math.max(this.displayModel.getScaleFactor() * 10.0f, (float) getRadiusInPixels(d3, b4)));
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        LatLong latLong = this.latLong;
        if (latLong != null && (this.paintStroke != null || this.paintFill != null)) {
            double d3 = latLong.latitude;
            double d4 = latLong.longitude;
            long mapSize = MercatorProjection.getMapSize(b4, this.displayModel.getTileSize());
            int longitudeToPixelX = (int) (MercatorProjection.longitudeToPixelX(d4, mapSize) - point.f4076x);
            int latitudeToPixelY = (int) (MercatorProjection.latitudeToPixelY(d3, mapSize) - point.f4077y);
            int radiusInPixels = getRadiusInPixels(d3, b4);
            if (new Rectangle(0.0d, 0.0d, canvas.getWidth(), canvas.getHeight()).intersectsCircle(longitudeToPixelX, latitudeToPixelY, radiusInPixels)) {
                Paint paint = this.paintStroke;
                if (paint != null) {
                    if (this.keepAligned) {
                        paint.setBitmapShaderShift(point);
                    }
                    canvas.drawCircle(longitudeToPixelX, latitudeToPixelY, radiusInPixels, this.paintStroke);
                }
                Paint paint2 = this.paintFill;
                if (paint2 != null) {
                    if (this.keepAligned) {
                        paint2.setBitmapShaderShift(point);
                    }
                    canvas.drawCircle(longitudeToPixelX, latitudeToPixelY, radiusInPixels, this.paintFill);
                }
            }
        }
    }

    public synchronized Paint getPaintFill() {
        return this.paintFill;
    }

    public synchronized Paint getPaintStroke() {
        return this.paintStroke;
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized LatLong getPosition() {
        return this.latLong;
    }

    public synchronized float getRadius() {
        return this.radius;
    }

    protected int getRadiusInPixels(double d3, byte b4) {
        return (int) MercatorProjection.metersToPixels(this.radius, d3, MercatorProjection.getMapSize(b4, this.displayModel.getTileSize()));
    }

    public boolean isKeepAligned() {
        return this.keepAligned;
    }

    public synchronized void setLatLong(LatLong latLong) {
        this.latLong = latLong;
    }

    public synchronized void setPaintFill(Paint paint) {
        this.paintFill = paint;
    }

    public synchronized void setPaintStroke(Paint paint) {
        this.paintStroke = paint;
    }

    public synchronized void setRadius(float f3) {
        setRadiusInternal(f3);
    }
}
