package org.mapsforge.map.view;

import java.util.logging.Logger;
import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.model.Dimension;

/* loaded from: /root/release/classes2.dex */
class FrameBufferBitmap {
    private static final Logger LOGGER = Logger.getLogger(FrameBufferBitmap.class.getName());
    private Bitmap bitmap = null;
    private BitmapRequest bitmapRequest = null;
    private final Object bitmapRequestSync = new Object();
    private final Lock frameLock = new Lock();

    private static class BitmapRequest {
        private final int color;
        private final Dimension dimension;
        private final GraphicFactory factory;
        private final boolean isTransparent;

        BitmapRequest(GraphicFactory graphicFactory, Dimension dimension, int i3, boolean z3) {
            this.factory = graphicFactory;
            this.dimension = dimension;
            this.color = i3;
            this.isTransparent = z3;
        }

        Bitmap create() {
            int i3;
            Dimension dimension = this.dimension;
            int i4 = dimension.width;
            if (i4 <= 0 || (i3 = dimension.height) <= 0) {
                return null;
            }
            Bitmap createBitmap = this.factory.createBitmap(i4, i3, this.isTransparent);
            createBitmap.setBackgroundColor(this.color);
            return createBitmap;
        }
    }

    static class Lock {
        private boolean enabled = false;

        Lock() {
        }

        synchronized void disable() {
            this.enabled = false;
            notifyAll();
        }

        synchronized void enable() {
            this.enabled = true;
        }

        boolean isEnabled() {
            return this.enabled;
        }

        synchronized void waitDisabled() {
            while (this.enabled) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    FrameBufferBitmap.LOGGER.fine("Frame buffer interrupted");
                }
            }
        }
    }

    FrameBufferBitmap() {
    }

    private void createBitmapIfRequested() {
        synchronized (this.bitmapRequestSync) {
            if (this.bitmapRequest != null) {
                destroyBitmap();
                this.bitmap = this.bitmapRequest.create();
                this.bitmapRequest = null;
            }
        }
    }

    private void destroyBitmap() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.decrementRefCount();
            this.bitmap = null;
        }
    }

    static void swap(FrameBufferBitmap frameBufferBitmap, FrameBufferBitmap frameBufferBitmap2) {
        Bitmap bitmap = frameBufferBitmap.bitmap;
        frameBufferBitmap.bitmap = frameBufferBitmap2.bitmap;
        frameBufferBitmap2.bitmap = bitmap;
        BitmapRequest bitmapRequest = frameBufferBitmap.bitmapRequest;
        frameBufferBitmap.bitmapRequest = frameBufferBitmap2.bitmapRequest;
        frameBufferBitmap2.bitmapRequest = bitmapRequest;
    }

    void create(GraphicFactory graphicFactory, Dimension dimension, int i3, boolean z3) {
        synchronized (this.bitmapRequestSync) {
            this.bitmapRequest = new BitmapRequest(graphicFactory, dimension, i3, z3);
        }
    }

    void destroy() {
        synchronized (this.frameLock) {
            if (this.bitmap != null) {
                this.frameLock.waitDisabled();
                destroyBitmap();
            }
        }
    }

    Bitmap lock() {
        Bitmap bitmap;
        synchronized (this.frameLock) {
            createBitmapIfRequested();
            if (this.bitmap != null) {
                this.frameLock.enable();
            }
            bitmap = this.bitmap;
        }
        return bitmap;
    }

    void release() {
        synchronized (this.frameLock) {
            this.frameLock.disable();
        }
    }
}
