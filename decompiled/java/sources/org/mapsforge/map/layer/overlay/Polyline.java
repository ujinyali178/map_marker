package org.mapsforge.map.layer.overlay;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Path;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.Layer;
import org.mapsforge.map.util.MapViewProjection;

/* loaded from: /root/release/classes2.dex */
public class Polyline extends Layer {
    private static final byte STROKE_MIN_ZOOM = 12;
    private BoundingBox boundingBox;
    private final GraphicFactory graphicFactory;
    private final boolean keepAligned;
    private final List<LatLong> latLongs;
    private Paint paintStroke;
    private double strokeIncrease;

    public Polyline(Paint paint, GraphicFactory graphicFactory) {
        this(paint, graphicFactory, false);
    }

    public Polyline(Paint paint, GraphicFactory graphicFactory, boolean z3) {
        this.latLongs = new CopyOnWriteArrayList();
        this.strokeIncrease = 1.0d;
        this.keepAligned = z3;
        this.paintStroke = paint;
        this.graphicFactory = graphicFactory;
    }

    private void updatePoints() {
        this.boundingBox = this.latLongs.isEmpty() ? null : new BoundingBox(this.latLongs);
    }

    public synchronized void addPoint(LatLong latLong) {
        this.latLongs.add(latLong);
        updatePoints();
    }

    public synchronized void addPoints(List<LatLong> list) {
        this.latLongs.addAll(list);
        updatePoints();
    }

    public synchronized void clear() {
        this.latLongs.clear();
        updatePoints();
    }

    public synchronized boolean contains(Point point, MapViewProjection mapViewProjection) {
        double max = Math.max(this.displayModel.getScaleFactor() * 10.0f, this.paintStroke.getStrokeWidth() / 2.0f);
        Point point2 = null;
        int i3 = 0;
        while (i3 < this.latLongs.size() - 1) {
            if (i3 == 0) {
                point2 = mapViewProjection.toPixels(this.latLongs.get(i3));
            }
            int i4 = i3 + 1;
            Point pixels = mapViewProjection.toPixels(this.latLongs.get(i4));
            if (LatLongUtils.distanceSegmentPoint(point2.f4076x, point2.f4077y, pixels.f4076x, pixels.f4077y, point.f4076x, point.f4077y) <= max) {
                return true;
            }
            point2 = pixels;
            i3 = i4;
        }
        return false;
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        if (!this.latLongs.isEmpty() && this.paintStroke != null) {
            BoundingBox boundingBox2 = this.boundingBox;
            if (boundingBox2 == null || boundingBox2.intersects(boundingBox)) {
                Iterator<LatLong> it = this.latLongs.iterator();
                if (it.hasNext()) {
                    LatLong next = it.next();
                    long mapSize = MercatorProjection.getMapSize(b4, this.displayModel.getTileSize());
                    float longitudeToPixelX = (float) (MercatorProjection.longitudeToPixelX(next.longitude, mapSize) - point.f4076x);
                    float latitudeToPixelY = (float) (MercatorProjection.latitudeToPixelY(next.latitude, mapSize) - point.f4077y);
                    Path createPath = this.graphicFactory.createPath();
                    createPath.moveTo(longitudeToPixelX, latitudeToPixelY);
                    while (it.hasNext()) {
                        LatLong next2 = it.next();
                        createPath.lineTo((float) (MercatorProjection.longitudeToPixelX(next2.longitude, mapSize) - point.f4076x), (float) (MercatorProjection.latitudeToPixelY(next2.latitude, mapSize) - point.f4077y));
                    }
                    if (this.keepAligned) {
                        this.paintStroke.setBitmapShaderShift(point);
                    }
                    float strokeWidth = this.paintStroke.getStrokeWidth();
                    double d3 = this.strokeIncrease;
                    if (d3 > 1.0d) {
                        this.paintStroke.setStrokeWidth(((float) Math.pow(d3, Math.max(b4 - 12, 0))) * strokeWidth);
                    }
                    canvas.drawPath(createPath, this.paintStroke);
                    this.paintStroke.setStrokeWidth(strokeWidth);
                }
            }
        }
    }

    public List<LatLong> getLatLongs() {
        return this.latLongs;
    }

    public synchronized Paint getPaintStroke() {
        return this.paintStroke;
    }

    public synchronized double getStrokeIncrease() {
        return this.strokeIncrease;
    }

    public boolean isKeepAligned() {
        return this.keepAligned;
    }

    public synchronized void setPaintStroke(Paint paint) {
        this.paintStroke = paint;
    }

    public synchronized void setPoints(List<LatLong> list) {
        this.latLongs.clear();
        this.latLongs.addAll(list);
        updatePoints();
    }

    public synchronized void setStrokeIncrease(double d3) {
        this.strokeIncrease = d3;
    }
}
