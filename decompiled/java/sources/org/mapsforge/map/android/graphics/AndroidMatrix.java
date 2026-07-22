package org.mapsforge.map.android.graphics;

import org.mapsforge.core.graphics.Matrix;

/* loaded from: /root/release/classes2.dex */
class AndroidMatrix implements Matrix {
    final android.graphics.Matrix matrix = new android.graphics.Matrix();

    AndroidMatrix() {
    }

    @Override // org.mapsforge.core.graphics.Matrix
    public void reset() {
        this.matrix.reset();
    }

    @Override // org.mapsforge.core.graphics.Matrix
    public void rotate(float f3) {
        this.matrix.preRotate((float) Math.toDegrees(f3));
    }

    @Override // org.mapsforge.core.graphics.Matrix
    public void rotate(float f3, float f4, float f5) {
        this.matrix.preRotate((float) Math.toDegrees(f3), f4, f5);
    }

    @Override // org.mapsforge.core.graphics.Matrix
    public void scale(float f3, float f4) {
        this.matrix.preScale(f3, f4);
    }

    @Override // org.mapsforge.core.graphics.Matrix
    public void scale(float f3, float f4, float f5, float f6) {
        this.matrix.preScale(f3, f4, f5, f6);
    }

    @Override // org.mapsforge.core.graphics.Matrix
    public void translate(float f3, float f4) {
        this.matrix.preTranslate(f3, f4);
    }
}
