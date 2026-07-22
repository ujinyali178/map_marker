package org.mapsforge.core.graphics;

/* loaded from: /root/release/classes2.dex */
public interface TileBitmap extends Bitmap {
    long getTimestamp();

    boolean isExpired();

    void setExpiration(long j3);

    void setTimestamp(long j3);
}
