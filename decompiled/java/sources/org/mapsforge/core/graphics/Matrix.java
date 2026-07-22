package org.mapsforge.core.graphics;

/* loaded from: /root/release/classes2.dex */
public interface Matrix {
    void reset();

    void rotate(float f3);

    void rotate(float f3, float f4, float f5);

    void scale(float f3, float f4);

    void scale(float f3, float f4, float f5, float f6);

    void translate(float f3, float f4);
}
