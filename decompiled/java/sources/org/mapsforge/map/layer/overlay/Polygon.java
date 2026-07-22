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

/* loaded from: /root/release/classes2.dex */
public class Polygon extends Layer {
    private BoundingBox boundingBox;
    private final GraphicFactory graphicFactory;
    private final boolean keepAligned;
    private final List<LatLong> latLongs;
    private Paint paintFill;
    private Paint paintStroke;

    public Polygon(Paint paint, Paint paint2, GraphicFactory graphicFactory) {
        this(paint, paint2, graphicFactory, false);
    }

    public Polygon(Paint paint, Paint paint2, GraphicFactory graphicFactory, boolean z3) {
        this.latLongs = new CopyOnWriteArrayList();
        this.keepAligned = z3;
        this.paintFill = paint;
        this.paintStroke = paint2;
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

    public synchronized boolean contains(LatLong latLong) {
        return LatLongUtils.contains(this.latLongs, latLong);
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        if (this.latLongs.size() >= 2 && (this.paintStroke != null || this.paintFill != null)) {
            BoundingBox boundingBox2 = this.boundingBox;
            if (boundingBox2 == null || boundingBox2.intersects(boundingBox)) {
                Iterator<LatLong> it = this.latLongs.iterator();
                Path createPath = this.graphicFactory.createPath();
                LatLong next = it.next();
                long mapSize = MercatorProjection.getMapSize(b4, this.displayModel.getTileSize());
                createPath.moveTo((float) (MercatorProjection.longitudeToPixelX(next.longitude, mapSize) - point.f4076x), (float) (MercatorProjection.latitudeToPixelY(next.latitude, mapSize) - point.f4077y));
                while (it.hasNext()) {
                    LatLong next2 = it.next();
                    createPath.lineTo((float) (MercatorProjection.longitudeToPixelX(next2.longitude, mapSize) - point.f4076x), (float) (MercatorProjection.latitudeToPixelY(next2.latitude, mapSize) - point.f4077y));
                }
                Paint paint = this.paintStroke;
                if (paint != null) {
                    if (this.keepAligned) {
                        paint.setBitmapShaderShift(point);
                    }
                    canvas.drawPath(createPath, this.paintStroke);
                }
                Paint paint2 = this.paintFill;
                if (paint2 != null) {
                    if (this.keepAligned) {
                        paint2.setBitmapShaderShift(point);
                    }
                    canvas.drawPath(createPath, this.paintFill);
                }
            }
        }
    }

    public List<LatLong> getLatLongs() {
        return this.latLongs;
    }

    public synchronized Paint getPaintFill() {
        return this.paintFill;
    }

    public synchronized Paint getPaintStroke() {
        return this.paintStroke;
    }

    public boolean isKeepAligned() {
        return this.keepAligned;
    }

    public synchronized void setPaintFill(Paint paint) {
        this.paintFill = paint;
    }

    public synchronized void setPaintStroke(Paint paint) {
        this.paintStroke = paint;
    }

    public synchronized void setPoints(List<LatLong> list) {
        this.latLongs.clear();
        this.latLongs.addAll(list);
        updatePoints();
    }
}
