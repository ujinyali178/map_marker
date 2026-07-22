package org.mapsforge.map.layer.overlay;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.model.Rectangle;
import org.mapsforge.core.util.MercatorProjection;
import org.mapsforge.map.layer.Layer;

/* loaded from: /root/release/classes2.dex */
public class Marker extends Layer {
    private Bitmap bitmap;
    private int horizontalOffset;
    private LatLong latLong;
    private int verticalOffset;

    public Marker(LatLong latLong, Bitmap bitmap, int i3, int i4) {
        this.latLong = latLong;
        this.bitmap = bitmap;
        this.horizontalOffset = i3;
        this.verticalOffset = i4;
    }

    public synchronized boolean contains(Point point, Point point2) {
        double d3;
        double d4;
        int i3;
        double d5;
        double d6;
        int i4;
        double max = Math.max(this.displayModel.getScaleFactor() * 20.0f, this.bitmap.getWidth());
        double max2 = Math.max(this.displayModel.getScaleFactor() * 20.0f, this.bitmap.getHeight());
        d3 = point.f4076x;
        d4 = max / 2.0d;
        i3 = this.horizontalOffset;
        d5 = point.f4077y;
        d6 = max2 / 2.0d;
        i4 = this.verticalOffset;
        return new Rectangle((d3 - d4) + i3, (d5 - d6) + i4, d3 + d4 + i3, d5 + d6 + i4).contains(point2);
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized void draw(BoundingBox boundingBox, byte b4, Canvas canvas, Point point) {
        Bitmap bitmap;
        if (this.latLong != null && (bitmap = this.bitmap) != null && !bitmap.isDestroyed()) {
            long mapSize = MercatorProjection.getMapSize(b4, this.displayModel.getTileSize());
            double longitudeToPixelX = MercatorProjection.longitudeToPixelX(this.latLong.longitude, mapSize);
            double latitudeToPixelY = MercatorProjection.latitudeToPixelY(this.latLong.latitude, mapSize);
            int width = this.bitmap.getWidth() / 2;
            int height = this.bitmap.getHeight() / 2;
            int i3 = (int) (((longitudeToPixelX - point.f4076x) - width) + this.horizontalOffset);
            int i4 = (int) (((latitudeToPixelY - point.f4077y) - height) + this.verticalOffset);
            if (new Rectangle(0.0d, 0.0d, canvas.getWidth(), canvas.getHeight()).intersects(new Rectangle(i3, i4, this.bitmap.getWidth() + i3, this.bitmap.getHeight() + i4))) {
                canvas.drawBitmap(this.bitmap, i3, i4);
            }
        }
    }

    public synchronized Bitmap getBitmap() {
        return this.bitmap;
    }

    public synchronized int getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public synchronized LatLong getLatLong() {
        return this.latLong;
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized LatLong getPosition() {
        return this.latLong;
    }

    public synchronized int getVerticalOffset() {
        return this.verticalOffset;
    }

    @Override // org.mapsforge.map.layer.Layer
    public synchronized void onDestroy() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.decrementRefCount();
        }
    }

    public synchronized void setBitmap(Bitmap bitmap) {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            Bitmap bitmap3 = this.bitmap;
            if (bitmap3 != null) {
                bitmap3.decrementRefCount();
            }
            this.bitmap = bitmap;
        }
    }

    public synchronized void setHorizontalOffset(int i3) {
        this.horizontalOffset = i3;
    }

    public synchronized void setLatLong(LatLong latLong) {
        this.latLong = latLong;
    }

    public synchronized void setVerticalOffset(int i3) {
        this.verticalOffset = i3;
    }
}
