package org.mapsforge.map.view;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.GraphicContext;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.FrameBufferModel;
import org.mapsforge.map.view.FrameBufferBitmap;

/* loaded from: /root/release/classes2.dex */
public class FrameBufferHA2 extends FrameBuffer {
    private final FrameBufferBitmap.Lock allowSwap;
    private final FrameBufferBitmap lmBitmap;
    private MapPosition lmMapPosition;
    private final FrameBufferBitmap odBitmap;

    public FrameBufferHA2(FrameBufferModel frameBufferModel, DisplayModel displayModel, GraphicFactory graphicFactory) {
        super(frameBufferModel, displayModel, graphicFactory);
        this.lmBitmap = new FrameBufferBitmap();
        this.odBitmap = new FrameBufferBitmap();
        FrameBufferBitmap.Lock lock = new FrameBufferBitmap.Lock();
        this.allowSwap = lock;
        lock.disable();
    }

    private void swapBitmaps() {
        synchronized (this.allowSwap) {
            if (this.allowSwap.isEnabled()) {
                FrameBufferBitmap.swap(this.odBitmap, this.lmBitmap);
                this.frameBufferModel.setMapPosition(this.lmMapPosition);
                this.allowSwap.disable();
            }
        }
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public void adjustMatrix(float f3, float f4, float f5, Dimension dimension, float f6, float f7) {
        synchronized (this.matrix) {
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
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public synchronized void destroy() {
        this.odBitmap.destroy();
        this.lmBitmap.destroy();
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public void draw(GraphicContext graphicContext) {
        graphicContext.fillColor(this.displayModel.getBackgroundColor());
        swapBitmaps();
        synchronized (this.matrix) {
            Bitmap lock = this.odBitmap.lock();
            if (lock != null) {
                graphicContext.drawBitmap(lock, this.matrix);
            }
        }
        this.odBitmap.release();
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public void frameFinished(MapPosition mapPosition) {
        synchronized (this.allowSwap) {
            this.lmMapPosition = mapPosition;
            this.lmBitmap.release();
            this.allowSwap.enable();
        }
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public Bitmap getDrawingBitmap() {
        Bitmap lock;
        synchronized (this.allowSwap) {
            this.allowSwap.waitDisabled();
            lock = this.lmBitmap.lock();
            if (lock != null) {
                lock.setBackgroundColor(this.displayModel.getBackgroundColor());
            }
        }
        return lock;
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public void setDimension(Dimension dimension) {
        synchronized (this.matrix) {
            Dimension dimension2 = this.dimension;
            if (dimension2 == null || !dimension2.equals(dimension)) {
                this.dimension = dimension;
                synchronized (this.allowSwap) {
                    this.odBitmap.create(this.graphicFactory, dimension, this.displayModel.getBackgroundColor(), false);
                    this.lmBitmap.create(this.graphicFactory, dimension, this.displayModel.getBackgroundColor(), false);
                }
            }
        }
    }
}
