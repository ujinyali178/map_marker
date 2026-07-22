package org.mapsforge.map.view;

import java.util.logging.Logger;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.GraphicContext;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.model.MapPosition;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.FrameBufferModel;

/* loaded from: /root/release/classes2.dex */
public class FrameBufferHA extends FrameBuffer {
    private static final Logger LOGGER = Logger.getLogger(FrameBufferHA.class.getName());
    private boolean allowBitmapSwap;
    private final Object lmBitmapLock;
    private MapPosition lmMapPosition;

    public FrameBufferHA(FrameBufferModel frameBufferModel, DisplayModel displayModel, GraphicFactory graphicFactory) {
        super(frameBufferModel, displayModel, graphicFactory);
        this.allowBitmapSwap = true;
        this.lmBitmapLock = new Object();
    }

    private void freeLmBitmap(MapPosition mapPosition) {
        synchronized (this.lmBitmapLock) {
            this.lmMapPosition = mapPosition;
            this.allowBitmapSwap = true;
        }
    }

    private void lockLmBitmap() {
        synchronized (this.lmBitmapLock) {
            if (this.lmBitmap != null && this.allowBitmapSwap) {
                try {
                    this.lmBitmapLock.wait();
                } catch (InterruptedException unused) {
                    LOGGER.fine("FrameBufferHA interrupted");
                }
            }
            this.allowBitmapSwap = false;
        }
    }

    private void swapBitmaps() {
        synchronized (this.lmBitmapLock) {
            if (this.allowBitmapSwap) {
                Bitmap bitmap = this.odBitmap;
                this.odBitmap = this.lmBitmap;
                this.lmBitmap = bitmap;
                this.frameBufferModel.setMapPosition(this.lmMapPosition);
                this.allowBitmapSwap = false;
                this.lmBitmapLock.notify();
            }
        }
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public void draw(GraphicContext graphicContext) {
        graphicContext.fillColor(this.displayModel.getBackgroundColor());
        swapBitmaps();
        Bitmap bitmap = this.odBitmap;
        if (bitmap != null) {
            graphicContext.drawBitmap(bitmap, this.matrix);
        }
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public void frameFinished(MapPosition mapPosition) {
        freeLmBitmap(mapPosition);
    }

    @Override // org.mapsforge.map.view.FrameBuffer
    public Bitmap getDrawingBitmap() {
        lockLmBitmap();
        return super.getDrawingBitmap();
    }
}
