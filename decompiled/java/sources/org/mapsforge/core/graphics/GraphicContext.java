package org.mapsforge.core.graphics;

import org.mapsforge.core.model.Rectangle;

/* loaded from: /root/release/classes2.dex */
public interface GraphicContext {
    void drawBitmap(Bitmap bitmap, int i3, int i4);

    void drawBitmap(Bitmap bitmap, int i3, int i4, float f3, Filter filter);

    void drawBitmap(Bitmap bitmap, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    void drawBitmap(Bitmap bitmap, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f3, Filter filter);

    void drawBitmap(Bitmap bitmap, Matrix matrix);

    void drawBitmap(Bitmap bitmap, Matrix matrix, float f3, Filter filter);

    void drawCircle(int i3, int i4, int i5, Paint paint);

    void drawLine(int i3, int i4, int i5, int i6, Paint paint);

    void drawPath(Path path, Paint paint);

    void drawPathText(String str, Path path, Paint paint);

    void drawText(String str, int i3, int i4, Paint paint);

    void drawTextRotated(String str, int i3, int i4, int i5, int i6, Paint paint);

    void fillColor(int i3);

    void fillColor(Color color);

    boolean isAntiAlias();

    boolean isFilterBitmap();

    void resetClip();

    void setAntiAlias(boolean z3);

    void setClip(int i3, int i4, int i5, int i6);

    void setClip(int i3, int i4, int i5, int i6, boolean z3);

    void setClipDifference(int i3, int i4, int i5, int i6);

    void setFilterBitmap(boolean z3);

    void shadeBitmap(Bitmap bitmap, Rectangle rectangle, Rectangle rectangle2, float f3);
}
