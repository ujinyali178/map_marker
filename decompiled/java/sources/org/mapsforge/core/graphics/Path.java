package org.mapsforge.core.graphics;

/* loaded from: /root/release/classes2.dex */
public interface Path {
    void clear();

    void close();

    boolean isEmpty();

    void lineTo(float f3, float f4);

    void moveTo(float f3, float f4);

    void setFillRule(FillRule fillRule);
}
