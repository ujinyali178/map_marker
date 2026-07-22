package org.mapsforge.map.view;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.GraphicContext;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Matrix;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.FrameBufferModel;

/* loaded from: /root/release/classes2.dex */
public class FrameBuffer {
    static final boolean IS_TRANSPARENT = false;
    Dimension dimension;
    final DisplayModel displayModel;
    final FrameBufferModel frameBufferModel;
    final GraphicFactory graphicFactory;
    Bitmap lmBitmap;
    final Matrix matrix;
    Bitmap odBitmap;

    public FrameBuffer(FrameBufferModel frameBufferModel, DisplayModel displayModel, GraphicFactory graphicFactory) {
        this.frameBufferModel = frameBufferModel;
        this.displayModel = displayModel;
        this.graphicFactory = graphicFactory;
        this.matrix = graphicFactory.createMatrix();
    }

    private void destroyBitmaps() {
        Bitmap bitmap = this.odBitmap;
        if (bitmap != null) {
            bitmap.decrementRefCount();
            this.odBitmap = null;
        }
        Bitmap bitmap2 = this.lmBitmap;
        if (bitmap2 != null) {
            bitmap2.decrementRefCount();
            this.lmBitmap = null;
        }
    }

    public synchronized void adjustMatrix(float f3, float f4, float f5, Dimension dimension, float f6, float f7) {
        if (this.dimension == null) {
            return;
        }
        this.matrix.reset();
        centerFrameBufferToMapView(dimension);
        if (f6 == BitmapDescriptorFactory.HUE_RED && f7 == BitmapDescriptorFactory.HUE_RED) {
            this.matrix.translate(f3, f4);
        }
        scale(f5, f6, f7);
    }

    void centerFrameBufferToMapView(Dimension dimension) {
        Dimension dimension2 = this.dimension;
        this.matrix.translate((dimension2.width - dimension.width) / (-2.0f), (dimension2.height - dimension.height) / (-2.0f));
    }

    public synchronized void destroy() {
        destroyBitmaps();
    }

    public synchronized void draw(GraphicContext graphicContext) {
        graphicContext.fillColor(this.displayModel.getBackgroundColor());
        Bitmap bitmap = this.odBitmap;
        if (bitmap != null) {
            graphicContext.drawBitmap(bitmap, this.matrix);
        }
    }

    public void frameFinished(MapPosition mapPosition) {
        synchronized (this) {
            Bitmap bitmap = this.odBitmap;
            this.odBitmap = this.lmBitmap;
            this.lmBitmap = bitmap;
        }
        this.frameBufferModel.setMapPosition(mapPosition);
    }

    public synchronized Dimension getDimension() {
        return this.dimension;
    }

    public synchronized Bitmap getDrawingBitmap() {
        Bitmap bitmap = this.lmBitmap;
        if (bitmap != null) {
            bitmap.setBackgroundColor(this.displayModel.getBackgroundColor());
        }
        return this.lmBitmap;
    }

    void scale(float f3, float f4, float f5) {
        if (f3 != 1.0f) {
            Point center = this.dimension.getCenter();
            this.matrix.scale(f3, f3, (float) (f4 + center.f4076x), (float) (f5 + center.f4077y));
        }
    }

    public synchronized void setDimension(Dimension dimension) {
        int i3;
        Dimension dimension2 = this.dimension;
        if (dimension2 == null || !dimension2.equals(dimension)) {
            this.dimension = dimension;
            destroyBitmaps();
            int i4 = dimension.width;
            if (i4 > 0 && (i3 = dimension.height) > 0) {
                this.odBitmap = this.graphicFactory.createBitmap(i4, i3, false);
                this.lmBitmap = this.graphicFactory.createBitmap(dimension.width, dimension.height, false);
            }
        }
    }
}
