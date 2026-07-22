package org.mapsforge.core.graphics;

import org.mapsforge.core.model.Point;

/* loaded from: /root/release/classes2.dex */
public interface Paint {
    int getColor();

    float getStrokeWidth();

    int getTextHeight(String str);

    int getTextWidth(String str);

    boolean isTransparent();

    void setBitmapShader(Bitmap bitmap);

    void setBitmapShaderShift(Point point);

    void setColor(int i3);

    void setColor(Color color);

    void setDashPathEffect(float[] fArr);

    void setStrokeCap(Cap cap);

    void setStrokeJoin(Join join);

    void setStrokeWidth(float f3);

    void setStyle(Style style);

    void setTextAlign(Align align);

    void setTextSize(float f3);

    void setTypeface(FontFamily fontFamily, FontStyle fontStyle);
}
