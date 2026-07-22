package org.mapsforge.map.android.rotation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

/* loaded from: /root/release/classes2.dex */
public class SmoothCanvas extends Canvas {
    Canvas delegate;
    private final Paint smooth = new Paint(2);

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        return this.delegate.clipPath(path);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path, Region.Op op) {
        return this.delegate.clipPath(path, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f3, float f4, float f5, float f6) {
        return this.delegate.clipRect(f3, f4, f5, f6);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f3, float f4, float f5, float f6, Region.Op op) {
        return this.delegate.clipRect(f3, f4, f5, f6, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int i3, int i4, int i5, int i6) {
        return this.delegate.clipRect(i3, i4, i5, i6);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        return this.delegate.clipRect(rect);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect, Region.Op op) {
        return this.delegate.clipRect(rect, op);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF) {
        return this.delegate.clipRect(rectF);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF, Region.Op op) {
        return this.delegate.clipRect(rectF, op);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        this.delegate.concat(matrix);
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int i3, int i4, int i5, int i6) {
        this.delegate.drawARGB(i3, i4, i5, i6);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF rectF, float f3, float f4, boolean z3, Paint paint) {
        this.delegate.drawArc(rectF, f3, f4, z3, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float f3, float f4, Paint paint) {
        if (paint == null) {
            paint = this.smooth;
        } else {
            paint.setFilterBitmap(true);
        }
        this.delegate.drawBitmap(bitmap, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        if (paint == null) {
            paint = this.smooth;
        } else {
            paint.setFilterBitmap(true);
        }
        this.delegate.drawBitmap(bitmap, matrix, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        if (paint == null) {
            paint = this.smooth;
        } else {
            paint.setFilterBitmap(true);
        }
        this.delegate.drawBitmap(bitmap, rect, rect2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        if (paint == null) {
            paint = this.smooth;
        } else {
            paint.setFilterBitmap(true);
        }
        this.delegate.drawBitmap(bitmap, rect, rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i3, int i4, int i5, int i6, int i7, int i8, boolean z3, Paint paint) {
        Paint paint2 = paint;
        if (paint2 == null) {
            paint2 = this.smooth;
        } else {
            paint2.setFilterBitmap(true);
        }
        this.delegate.drawBitmap(iArr, i3, i4, i5, i6, i7, i8, z3, paint2);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int i3, int i4, float[] fArr, int i5, int[] iArr, int i6, Paint paint) {
        this.delegate.drawBitmapMesh(bitmap, i3, i4, fArr, i5, iArr, i6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f3, float f4, float f5, Paint paint) {
        this.delegate.drawCircle(f3, f4, f5, paint);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i3) {
        this.delegate.drawColor(i3);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i3, PorterDuff.Mode mode) {
        this.delegate.drawColor(i3, mode);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f3, float f4, float f5, float f6, Paint paint) {
        this.delegate.drawLine(f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, int i3, int i4, Paint paint) {
        this.delegate.drawLines(fArr, i3, i4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, Paint paint) {
        this.delegate.drawLines(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF rectF, Paint paint) {
        this.delegate.drawOval(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        this.delegate.drawPaint(paint);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        this.delegate.drawPath(path, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        this.delegate.drawPicture(picture);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect rect) {
        this.delegate.drawPicture(picture, rect);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF rectF) {
        this.delegate.drawPicture(picture, rectF);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f3, float f4, Paint paint) {
        this.delegate.drawPoint(f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i3, int i4, Paint paint) {
        this.delegate.drawPoints(fArr, i3, i4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, Paint paint) {
        this.delegate.drawPoints(fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPosText(String str, float[] fArr, Paint paint) {
        this.delegate.drawPosText(str, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPosText(char[] cArr, int i3, int i4, float[] fArr, Paint paint) {
        this.delegate.drawPosText(cArr, i3, i4, fArr, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int i3, int i4, int i5) {
        this.delegate.drawRGB(i3, i4, i5);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f3, float f4, float f5, float f6, Paint paint) {
        this.delegate.drawRect(f3, f4, f5, f6, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect rect, Paint paint) {
        this.delegate.drawRect(rect, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rectF, Paint paint) {
        this.delegate.drawRect(rectF, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rectF, float f3, float f4, Paint paint) {
        this.delegate.drawRoundRect(rectF, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence charSequence, int i3, int i4, float f3, float f4, Paint paint) {
        this.delegate.drawText(charSequence, i3, i4, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, float f3, float f4, Paint paint) {
        this.delegate.drawText(str, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, int i3, int i4, float f3, float f4, Paint paint) {
        this.delegate.drawText(str, i3, i4, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] cArr, int i3, int i4, float f3, float f4, Paint paint) {
        this.delegate.drawText(cArr, i3, i4, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String str, Path path, float f3, float f4, Paint paint) {
        this.delegate.drawTextOnPath(str, path, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] cArr, int i3, int i4, Path path, float f3, float f4, Paint paint) {
        this.delegate.drawTextOnPath(cArr, i3, i4, path, f3, f4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode vertexMode, int i3, float[] fArr, int i4, float[] fArr2, int i5, int[] iArr, int i6, short[] sArr, int i7, int i8, Paint paint) {
        this.delegate.drawVertices(vertexMode, i3, fArr, i4, fArr2, i5, iArr, i6, sArr, i7, i8, paint);
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect rect) {
        return this.delegate.getClipBounds(rect);
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        return this.delegate.getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        return this.delegate.getHeight();
    }

    @Override // android.graphics.Canvas
    public void getMatrix(Matrix matrix) {
        this.delegate.getMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        return this.delegate.getSaveCount();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        return this.delegate.getWidth();
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        return this.delegate.isOpaque();
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f3, float f4, float f5, float f6, Canvas.EdgeType edgeType) {
        return this.delegate.quickReject(f3, f4, f5, f6, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        return this.delegate.quickReject(path, edgeType);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        return this.delegate.quickReject(rectF, edgeType);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        this.delegate.restore();
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int i3) {
        this.delegate.restoreToCount(i3);
    }

    @Override // android.graphics.Canvas
    public void rotate(float f3) {
        this.delegate.rotate(f3);
    }

    @Override // android.graphics.Canvas
    public int save() {
        return this.delegate.save();
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f3, float f4, float f5, float f6, Paint paint, int i3) {
        return this.delegate.saveLayer(f3, f4, f5, f6, paint, i3);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint, int i3) {
        return this.delegate.saveLayer(rectF, paint, i3);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f3, float f4, float f5, float f6, int i3, int i4) {
        return this.delegate.saveLayerAlpha(f3, f4, f5, f6, i3, i4);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i3, int i4) {
        return this.delegate.saveLayerAlpha(rectF, i3, i4);
    }

    @Override // android.graphics.Canvas
    public void scale(float f3, float f4) {
        this.delegate.scale(f3, f4);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap bitmap) {
        this.delegate.setBitmap(bitmap);
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter drawFilter) {
        this.delegate.setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        this.delegate.setMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public void skew(float f3, float f4) {
        this.delegate.skew(f3, f4);
    }

    @Override // android.graphics.Canvas
    public void translate(float f3, float f4) {
        this.delegate.translate(f3, f4);
    }
}
