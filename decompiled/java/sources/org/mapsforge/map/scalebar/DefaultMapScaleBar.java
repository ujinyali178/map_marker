package org.mapsforge.map.scalebar;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Cap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FontFamily;
import org.mapsforge.core.graphics.FontStyle;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.IMapViewPosition;
import org.mapsforge.map.model.MapViewDimension;
import org.mapsforge.map.scalebar.MapScaleBar;

/* loaded from: /root/release/classes2.dex */
public class DefaultMapScaleBar extends MapScaleBar {
    private static final int BITMAP_HEIGHT = 40;
    private static final int BITMAP_WIDTH = 120;
    private static final int DEFAULT_HORIZONTAL_MARGIN = 5;
    private static final int DEFAULT_VERTICAL_MARGIN = 0;
    private static final int SCALE_BAR_MARGIN = 10;
    private static final float STROKE_EXTERNAL = 4.0f;
    private static final float STROKE_INTERNAL = 2.0f;
    private static final int TEXT_MARGIN = 1;
    private final Paint paintScaleBar;
    private final Paint paintScaleBarStroke;
    private final Paint paintScaleText;
    private final Paint paintScaleTextStroke;
    private ScaleBarMode scaleBarMode;
    private DistanceUnitAdapter secondaryDistanceUnitAdapter;

    /* renamed from: org.mapsforge.map.scalebar.DefaultMapScaleBar$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition;

        static {
            int[] iArr = new int[MapScaleBar.ScaleBarPosition.values().length];
            $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition = iArr;
            try {
                iArr[MapScaleBar.ScaleBarPosition.BOTTOM_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[MapScaleBar.ScaleBarPosition.BOTTOM_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[MapScaleBar.ScaleBarPosition.BOTTOM_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[MapScaleBar.ScaleBarPosition.TOP_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[MapScaleBar.ScaleBarPosition.TOP_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[MapScaleBar.ScaleBarPosition.TOP_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum ScaleBarMode {
        BOTH,
        SINGLE
    }

    public DefaultMapScaleBar(IMapViewPosition iMapViewPosition, MapViewDimension mapViewDimension, GraphicFactory graphicFactory, DisplayModel displayModel) {
        this(iMapViewPosition, mapViewDimension, graphicFactory, displayModel, displayModel.getScaleFactor());
    }

    public DefaultMapScaleBar(IMapViewPosition iMapViewPosition, MapViewDimension mapViewDimension, GraphicFactory graphicFactory, DisplayModel displayModel, float f3) {
        super(iMapViewPosition, mapViewDimension, displayModel, graphicFactory, (int) (120.0f * f3), (int) (40.0f * f3), f3);
        setMarginHorizontal((int) (5.0f * f3));
        setMarginVertical((int) (f3 * BitmapDescriptorFactory.HUE_RED));
        this.scaleBarMode = ScaleBarMode.BOTH;
        this.secondaryDistanceUnitAdapter = ImperialUnitAdapter.INSTANCE;
        Color color = Color.BLACK;
        Style style = Style.FILL;
        this.paintScaleBar = createScaleBarPaint(color, STROKE_INTERNAL, style);
        Color color2 = Color.WHITE;
        Style style2 = Style.STROKE;
        this.paintScaleBarStroke = createScaleBarPaint(color2, STROKE_EXTERNAL, style2);
        this.paintScaleText = createTextPaint(color, BitmapDescriptorFactory.HUE_RED, style);
        this.paintScaleTextStroke = createTextPaint(color2, STROKE_INTERNAL, style2);
    }

    private Paint createScaleBarPaint(Color color, float f3, Style style) {
        Paint createPaint = this.graphicFactory.createPaint();
        createPaint.setColor(color);
        createPaint.setStrokeWidth(f3 * this.scale);
        createPaint.setStyle(style);
        createPaint.setStrokeCap(Cap.SQUARE);
        return createPaint;
    }

    private Paint createTextPaint(Color color, float f3, Style style) {
        Paint createPaint = this.graphicFactory.createPaint();
        createPaint.setColor(color);
        createPaint.setStrokeWidth(f3 * this.scale);
        createPaint.setStyle(style);
        createPaint.setTypeface(FontFamily.DEFAULT, FontStyle.BOLD);
        createPaint.setTextSize(this.scale * 12.0f);
        return createPaint;
    }

    private void drawScaleBar(Canvas canvas, int i3, int i4, Paint paint, float f3) {
        Canvas canvas2;
        Paint paint2;
        int round;
        int round2;
        int round3;
        float height;
        float height2;
        float width;
        float f4;
        int round4;
        int max = Math.max(i3, i4);
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[this.scaleBarPosition.ordinal()]) {
            case 1:
                if (i4 == 0) {
                    float f5 = f3 * 10.0f;
                    canvas2 = canvas;
                    paint2 = paint;
                    canvas2.drawLine(Math.round((canvas.getWidth() - max) * 0.5f), Math.round(canvas.getHeight() - f5), Math.round((canvas.getWidth() + max) * 0.5f), Math.round(canvas.getHeight() - f5), paint2);
                    canvas2.drawLine(Math.round((canvas.getWidth() - max) * 0.5f), Math.round(canvas.getHeight() * 0.5f), Math.round((canvas.getWidth() - max) * 0.5f), Math.round(canvas.getHeight() - f5), paint2);
                    round = Math.round((canvas.getWidth() + max) * 0.5f);
                    round2 = Math.round(canvas.getHeight() * 0.5f);
                    round3 = Math.round((canvas.getWidth() + max) * 0.5f);
                    height = canvas.getHeight() - f5;
                    round4 = Math.round(height);
                    canvas2.drawLine(round, round2, round3, round4, paint2);
                    break;
                }
                float f6 = f3 * STROKE_EXTERNAL * 0.5f;
                canvas2 = canvas;
                canvas2.drawLine(Math.round(f6), Math.round(canvas.getHeight() * 0.5f), Math.round(max + f6), Math.round(canvas.getHeight() * 0.5f), paint);
                f4 = f3 * 10.0f;
                canvas.drawLine(Math.round(f6), Math.round(f4), Math.round(f6), Math.round(canvas.getHeight() - f4), paint);
                float f7 = i3 + f6;
                paint2 = paint;
                canvas2.drawLine(Math.round(f7), Math.round(f4), Math.round(f7), Math.round(canvas.getHeight() * 0.5f), paint2);
                float f8 = f6 + i4;
                round = Math.round(f8);
                round2 = Math.round(canvas.getHeight() * 0.5f);
                round3 = Math.round(f8);
                height = canvas.getHeight() - f4;
                round4 = Math.round(height);
                canvas2.drawLine(round, round2, round3, round4, paint2);
            case 2:
                if (i4 == 0) {
                    float f9 = f3 * STROKE_EXTERNAL * 0.5f;
                    float f10 = f3 * 10.0f;
                    float f11 = max + f9;
                    canvas2 = canvas;
                    canvas2.drawLine(Math.round(f9), Math.round(canvas.getHeight() - f10), Math.round(f11), Math.round(canvas.getHeight() - f10), paint);
                    canvas.drawLine(Math.round(f9), Math.round(canvas.getHeight() * 0.5f), Math.round(f9), Math.round(canvas.getHeight() - f10), paint);
                    round = Math.round(f11);
                    round2 = Math.round(canvas.getHeight() * 0.5f);
                    round3 = Math.round(f11);
                    height2 = canvas.getHeight() - f10;
                    round4 = Math.round(height2);
                    paint2 = paint;
                    canvas2.drawLine(round, round2, round3, round4, paint2);
                    break;
                }
                float f62 = f3 * STROKE_EXTERNAL * 0.5f;
                canvas2 = canvas;
                canvas2.drawLine(Math.round(f62), Math.round(canvas.getHeight() * 0.5f), Math.round(max + f62), Math.round(canvas.getHeight() * 0.5f), paint);
                f4 = f3 * 10.0f;
                canvas.drawLine(Math.round(f62), Math.round(f4), Math.round(f62), Math.round(canvas.getHeight() - f4), paint);
                float f72 = i3 + f62;
                paint2 = paint;
                canvas2.drawLine(Math.round(f72), Math.round(f4), Math.round(f72), Math.round(canvas.getHeight() * 0.5f), paint2);
                float f82 = f62 + i4;
                round = Math.round(f82);
                round2 = Math.round(canvas.getHeight() * 0.5f);
                round3 = Math.round(f82);
                height = canvas.getHeight() - f4;
                round4 = Math.round(height);
                canvas2.drawLine(round, round2, round3, round4, paint2);
            case 3:
                if (i4 == 0) {
                    float width2 = canvas.getWidth();
                    float f12 = f3 * STROKE_EXTERNAL * 0.5f;
                    float f13 = max;
                    float f14 = f3 * 10.0f;
                    canvas2 = canvas;
                    paint2 = paint;
                    canvas2.drawLine(Math.round((width2 - f12) - f13), Math.round(canvas.getHeight() - f14), Math.round(canvas.getWidth() - f12), Math.round(canvas.getHeight() - f14), paint2);
                    canvas2.drawLine(Math.round(canvas.getWidth() - f12), Math.round(canvas.getHeight() * 0.5f), Math.round(canvas.getWidth() - f12), Math.round(canvas.getHeight() - f14), paint2);
                    round = Math.round((canvas.getWidth() - f12) - f13);
                    round2 = Math.round(canvas.getHeight() * 0.5f);
                    round3 = Math.round((canvas.getWidth() - f12) - f13);
                    height = canvas.getHeight() - f14;
                    round4 = Math.round(height);
                    canvas2.drawLine(round, round2, round3, round4, paint2);
                    break;
                }
                float width3 = canvas.getWidth();
                float f15 = STROKE_EXTERNAL * f3 * 0.5f;
                canvas2 = canvas;
                paint2 = paint;
                canvas2.drawLine(Math.round(width3 - f15), Math.round(canvas.getHeight() * 0.5f), Math.round((canvas.getWidth() - f15) - max), Math.round(canvas.getHeight() * 0.5f), paint2);
                f4 = f3 * 10.0f;
                canvas2.drawLine(Math.round(canvas.getWidth() - f15), Math.round(f4), Math.round(canvas.getWidth() - f15), Math.round(canvas.getHeight() - f4), paint2);
                float f16 = i3;
                canvas2.drawLine(Math.round((canvas.getWidth() - f15) - f16), Math.round(f4), Math.round((canvas.getWidth() - f15) - f16), Math.round(canvas.getHeight() * 0.5f), paint2);
                float f17 = i4;
                round = Math.round((canvas.getWidth() - f15) - f17);
                round2 = Math.round(canvas.getHeight() * 0.5f);
                round3 = Math.round((canvas.getWidth() - f15) - f17);
                height = canvas.getHeight() - f4;
                round4 = Math.round(height);
                canvas2.drawLine(round, round2, round3, round4, paint2);
            case 4:
                if (i4 == 0) {
                    float f18 = f3 * 10.0f;
                    canvas2 = canvas;
                    paint2 = paint;
                    canvas2.drawLine(Math.round((canvas.getWidth() - max) * 0.5f), Math.round(f18), Math.round((canvas.getWidth() + max) * 0.5f), Math.round(f18), paint2);
                    canvas2.drawLine(Math.round((canvas.getWidth() - max) * 0.5f), Math.round(f18), Math.round((canvas.getWidth() - max) * 0.5f), Math.round(canvas.getHeight() * 0.5f), paint2);
                    round = Math.round((canvas.getWidth() + max) * 0.5f);
                    round2 = Math.round(f18);
                    width = (canvas.getWidth() + max) * 0.5f;
                    round3 = Math.round(width);
                    height = canvas.getHeight() * 0.5f;
                    round4 = Math.round(height);
                    canvas2.drawLine(round, round2, round3, round4, paint2);
                    break;
                }
                float f622 = f3 * STROKE_EXTERNAL * 0.5f;
                canvas2 = canvas;
                canvas2.drawLine(Math.round(f622), Math.round(canvas.getHeight() * 0.5f), Math.round(max + f622), Math.round(canvas.getHeight() * 0.5f), paint);
                f4 = f3 * 10.0f;
                canvas.drawLine(Math.round(f622), Math.round(f4), Math.round(f622), Math.round(canvas.getHeight() - f4), paint);
                float f722 = i3 + f622;
                paint2 = paint;
                canvas2.drawLine(Math.round(f722), Math.round(f4), Math.round(f722), Math.round(canvas.getHeight() * 0.5f), paint2);
                float f822 = f622 + i4;
                round = Math.round(f822);
                round2 = Math.round(canvas.getHeight() * 0.5f);
                round3 = Math.round(f822);
                height = canvas.getHeight() - f4;
                round4 = Math.round(height);
                canvas2.drawLine(round, round2, round3, round4, paint2);
            case 5:
                if (i4 == 0) {
                    float f19 = f3 * STROKE_EXTERNAL * 0.5f;
                    float f20 = f3 * 10.0f;
                    float f21 = max + f19;
                    canvas2 = canvas;
                    canvas2.drawLine(Math.round(f19), Math.round(f20), Math.round(f21), Math.round(f20), paint);
                    canvas.drawLine(Math.round(f19), Math.round(f20), Math.round(f19), Math.round(canvas.getHeight() * 0.5f), paint);
                    round = Math.round(f21);
                    round2 = Math.round(f20);
                    round3 = Math.round(f21);
                    height2 = canvas.getHeight() * 0.5f;
                    round4 = Math.round(height2);
                    paint2 = paint;
                    canvas2.drawLine(round, round2, round3, round4, paint2);
                    break;
                }
                float f6222 = f3 * STROKE_EXTERNAL * 0.5f;
                canvas2 = canvas;
                canvas2.drawLine(Math.round(f6222), Math.round(canvas.getHeight() * 0.5f), Math.round(max + f6222), Math.round(canvas.getHeight() * 0.5f), paint);
                f4 = f3 * 10.0f;
                canvas.drawLine(Math.round(f6222), Math.round(f4), Math.round(f6222), Math.round(canvas.getHeight() - f4), paint);
                float f7222 = i3 + f6222;
                paint2 = paint;
                canvas2.drawLine(Math.round(f7222), Math.round(f4), Math.round(f7222), Math.round(canvas.getHeight() * 0.5f), paint2);
                float f8222 = f6222 + i4;
                round = Math.round(f8222);
                round2 = Math.round(canvas.getHeight() * 0.5f);
                round3 = Math.round(f8222);
                height = canvas.getHeight() - f4;
                round4 = Math.round(height);
                canvas2.drawLine(round, round2, round3, round4, paint2);
            case 6:
                if (i4 == 0) {
                    float width4 = canvas.getWidth();
                    float f22 = f3 * STROKE_EXTERNAL * 0.5f;
                    float f23 = max;
                    int round5 = Math.round((width4 - f22) - f23);
                    float f24 = f3 * 10.0f;
                    canvas2 = canvas;
                    paint2 = paint;
                    canvas2.drawLine(round5, Math.round(f24), Math.round(canvas.getWidth() - f22), Math.round(f24), paint2);
                    canvas2.drawLine(Math.round(canvas.getWidth() - f22), Math.round(f24), Math.round(canvas.getWidth() - f22), Math.round(canvas.getHeight() * 0.5f), paint2);
                    round = Math.round((canvas.getWidth() - f22) - f23);
                    round2 = Math.round(f24);
                    width = (canvas.getWidth() - f22) - f23;
                    round3 = Math.round(width);
                    height = canvas.getHeight() * 0.5f;
                    round4 = Math.round(height);
                    canvas2.drawLine(round, round2, round3, round4, paint2);
                    break;
                }
                float width32 = canvas.getWidth();
                float f152 = STROKE_EXTERNAL * f3 * 0.5f;
                canvas2 = canvas;
                paint2 = paint;
                canvas2.drawLine(Math.round(width32 - f152), Math.round(canvas.getHeight() * 0.5f), Math.round((canvas.getWidth() - f152) - max), Math.round(canvas.getHeight() * 0.5f), paint2);
                f4 = f3 * 10.0f;
                canvas2.drawLine(Math.round(canvas.getWidth() - f152), Math.round(f4), Math.round(canvas.getWidth() - f152), Math.round(canvas.getHeight() - f4), paint2);
                float f162 = i3;
                canvas2.drawLine(Math.round((canvas.getWidth() - f152) - f162), Math.round(f4), Math.round((canvas.getWidth() - f152) - f162), Math.round(canvas.getHeight() * 0.5f), paint2);
                float f172 = i4;
                round = Math.round((canvas.getWidth() - f152) - f172);
                round2 = Math.round(canvas.getHeight() * 0.5f);
                round3 = Math.round((canvas.getWidth() - f152) - f172);
                height = canvas.getHeight() - f4;
                round4 = Math.round(height);
                canvas2.drawLine(round, round2, round3, round4, paint2);
        }
    }

    private void drawScaleText(Canvas canvas, String str, String str2, Paint paint, float f3) {
        int round;
        float height;
        float f4;
        float f5;
        float f6;
        int round2;
        float f7;
        int round3;
        float height2;
        float f8;
        float f9;
        float f10;
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$map$scalebar$MapScaleBar$ScaleBarPosition[this.scaleBarPosition.ordinal()]) {
            case 1:
                if (str2.length() == 0) {
                    round = Math.round((canvas.getWidth() - this.paintScaleTextStroke.getTextWidth(str)) * 0.5f);
                    height = ((canvas.getHeight() - (10.0f * f3)) - ((STROKE_EXTERNAL * f3) * 0.5f)) - (f3 * 1.0f);
                    round2 = Math.round(height);
                    canvas.drawText(str, round, round2, paint);
                    break;
                }
                float f11 = STROKE_EXTERNAL * f3;
                f7 = f3 * 1.0f;
                float f12 = f11 + f7;
                float f13 = f11 * 0.5f;
                canvas.drawText(str, Math.round(f12), Math.round(((canvas.getHeight() * 0.5f) - f13) - f7), paint);
                round3 = Math.round(f12);
                height2 = (canvas.getHeight() * 0.5f) + f13;
                canvas.drawText(str2, round3, Math.round(height2 + f7 + this.paintScaleTextStroke.getTextHeight(str2)), paint);
                break;
            case 2:
                if (str2.length() == 0) {
                    f4 = STROKE_EXTERNAL * f3;
                    f5 = 1.0f * f3;
                    f6 = f4 + f5;
                    round = Math.round(f6);
                    height = ((canvas.getHeight() - (f3 * 10.0f)) - (f4 * 0.5f)) - f5;
                    round2 = Math.round(height);
                    canvas.drawText(str, round, round2, paint);
                    break;
                }
                float f112 = STROKE_EXTERNAL * f3;
                f7 = f3 * 1.0f;
                float f122 = f112 + f7;
                float f132 = f112 * 0.5f;
                canvas.drawText(str, Math.round(f122), Math.round(((canvas.getHeight() * 0.5f) - f132) - f7), paint);
                round3 = Math.round(f122);
                height2 = (canvas.getHeight() * 0.5f) + f132;
                canvas.drawText(str2, round3, Math.round(height2 + f7 + this.paintScaleTextStroke.getTextHeight(str2)), paint);
                break;
            case 3:
                if (str2.length() == 0) {
                    float width = canvas.getWidth();
                    f4 = STROKE_EXTERNAL * f3;
                    f5 = 1.0f * f3;
                    f6 = ((width - f4) - f5) - this.paintScaleTextStroke.getTextWidth(str);
                    round = Math.round(f6);
                    height = ((canvas.getHeight() - (f3 * 10.0f)) - (f4 * 0.5f)) - f5;
                    round2 = Math.round(height);
                    canvas.drawText(str, round, round2, paint);
                    break;
                }
                float width2 = canvas.getWidth();
                float f14 = STROKE_EXTERNAL * f3;
                f7 = f3 * 1.0f;
                float f15 = f14 * 0.5f;
                canvas.drawText(str, Math.round(((width2 - f14) - f7) - this.paintScaleTextStroke.getTextWidth(str)), Math.round(((canvas.getHeight() * 0.5f) - f15) - f7), paint);
                round3 = Math.round(((canvas.getWidth() - f14) - f7) - this.paintScaleTextStroke.getTextWidth(str2));
                height2 = (canvas.getHeight() * 0.5f) + f15;
                canvas.drawText(str2, round3, Math.round(height2 + f7 + this.paintScaleTextStroke.getTextHeight(str2)), paint);
                break;
            case 4:
                if (str2.length() == 0) {
                    round = Math.round((canvas.getWidth() - this.paintScaleTextStroke.getTextWidth(str)) * 0.5f);
                    round2 = Math.round((10.0f * f3) + (STROKE_EXTERNAL * f3 * 0.5f) + (f3 * 1.0f) + this.paintScaleTextStroke.getTextHeight(str));
                    canvas.drawText(str, round, round2, paint);
                    break;
                }
                float f1122 = STROKE_EXTERNAL * f3;
                f7 = f3 * 1.0f;
                float f1222 = f1122 + f7;
                float f1322 = f1122 * 0.5f;
                canvas.drawText(str, Math.round(f1222), Math.round(((canvas.getHeight() * 0.5f) - f1322) - f7), paint);
                round3 = Math.round(f1222);
                height2 = (canvas.getHeight() * 0.5f) + f1322;
                canvas.drawText(str2, round3, Math.round(height2 + f7 + this.paintScaleTextStroke.getTextHeight(str2)), paint);
                break;
            case 5:
                if (str2.length() == 0) {
                    f8 = STROKE_EXTERNAL * f3;
                    f9 = 1.0f * f3;
                    f10 = f8 + f9;
                    round = Math.round(f10);
                    round2 = Math.round((f3 * 10.0f) + (f8 * 0.5f) + f9 + this.paintScaleTextStroke.getTextHeight(str));
                    canvas.drawText(str, round, round2, paint);
                    break;
                }
                float f11222 = STROKE_EXTERNAL * f3;
                f7 = f3 * 1.0f;
                float f12222 = f11222 + f7;
                float f13222 = f11222 * 0.5f;
                canvas.drawText(str, Math.round(f12222), Math.round(((canvas.getHeight() * 0.5f) - f13222) - f7), paint);
                round3 = Math.round(f12222);
                height2 = (canvas.getHeight() * 0.5f) + f13222;
                canvas.drawText(str2, round3, Math.round(height2 + f7 + this.paintScaleTextStroke.getTextHeight(str2)), paint);
                break;
            case 6:
                if (str2.length() == 0) {
                    float width3 = canvas.getWidth();
                    f8 = STROKE_EXTERNAL * f3;
                    f9 = 1.0f * f3;
                    f10 = ((width3 - f8) - f9) - this.paintScaleTextStroke.getTextWidth(str);
                    round = Math.round(f10);
                    round2 = Math.round((f3 * 10.0f) + (f8 * 0.5f) + f9 + this.paintScaleTextStroke.getTextHeight(str));
                    canvas.drawText(str, round, round2, paint);
                    break;
                }
                float width22 = canvas.getWidth();
                float f142 = STROKE_EXTERNAL * f3;
                f7 = f3 * 1.0f;
                float f152 = f142 * 0.5f;
                canvas.drawText(str, Math.round(((width22 - f142) - f7) - this.paintScaleTextStroke.getTextWidth(str)), Math.round(((canvas.getHeight() * 0.5f) - f152) - f7), paint);
                round3 = Math.round(((canvas.getWidth() - f142) - f7) - this.paintScaleTextStroke.getTextWidth(str2));
                height2 = (canvas.getHeight() * 0.5f) + f152;
                canvas.drawText(str2, round3, Math.round(height2 + f7 + this.paintScaleTextStroke.getTextHeight(str2)), paint);
                break;
        }
    }

    public ScaleBarMode getScaleBarMode() {
        return this.scaleBarMode;
    }

    public DistanceUnitAdapter getSecondaryDistanceUnitAdapter() {
        return this.secondaryDistanceUnitAdapter;
    }

    @Override // org.mapsforge.map.scalebar.MapScaleBar
    protected void redraw(Canvas canvas) {
        canvas.fillColor(Color.TRANSPARENT);
        MapScaleBar.ScaleBarLengthAndValue calculateScaleBarLengthAndValue = calculateScaleBarLengthAndValue();
        ScaleBarMode scaleBarMode = this.scaleBarMode;
        ScaleBarMode scaleBarMode2 = ScaleBarMode.BOTH;
        MapScaleBar.ScaleBarLengthAndValue calculateScaleBarLengthAndValue2 = scaleBarMode == scaleBarMode2 ? calculateScaleBarLengthAndValue(this.secondaryDistanceUnitAdapter) : new MapScaleBar.ScaleBarLengthAndValue(0, 0);
        drawScaleBar(canvas, calculateScaleBarLengthAndValue.scaleBarLength, calculateScaleBarLengthAndValue2.scaleBarLength, this.paintScaleBarStroke, this.scale);
        drawScaleBar(canvas, calculateScaleBarLengthAndValue.scaleBarLength, calculateScaleBarLengthAndValue2.scaleBarLength, this.paintScaleBar, this.scale);
        String scaleText = this.distanceUnitAdapter.getScaleText(calculateScaleBarLengthAndValue.scaleBarValue);
        String scaleText2 = this.scaleBarMode == scaleBarMode2 ? this.secondaryDistanceUnitAdapter.getScaleText(calculateScaleBarLengthAndValue2.scaleBarValue) : "";
        drawScaleText(canvas, scaleText, scaleText2, this.paintScaleTextStroke, this.scale);
        drawScaleText(canvas, scaleText, scaleText2, this.paintScaleText, this.scale);
    }

    public void setScaleBarMode(ScaleBarMode scaleBarMode) {
        this.scaleBarMode = scaleBarMode;
        this.redrawNeeded = true;
    }

    public void setSecondaryDistanceUnitAdapter(DistanceUnitAdapter distanceUnitAdapter) {
        if (distanceUnitAdapter == null) {
            throw new IllegalArgumentException("adapter must not be null");
        }
        this.secondaryDistanceUnitAdapter = distanceUnitAdapter;
        this.redrawNeeded = true;
    }
}
