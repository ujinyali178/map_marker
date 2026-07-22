package org.mapsforge.core.graphics;

import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public interface Bitmap {
    void compress(OutputStream outputStream);

    void decrementRefCount();

    int getHeight();

    int getWidth();

    void incrementRefCount();

    boolean isDestroyed();

    void scaleTo(int i3, int i4);

    void setBackgroundColor(int i3);
}
