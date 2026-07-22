package org.mapsforge.map.android.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.base.Ascii;
import org.mapsforge.core.graphics.Canvas;
import org.mapsforge.core.graphics.Filter;
import org.mapsforge.core.graphics.Path;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Dimension;
import org.mapsforge.core.model.Rectangle;

/* loaded from: /root/release/classes2.dex */
class AndroidCanvas implements Canvas {
    private static final float[] INVERT_MATRIX = {-1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED};
    private final Paint bitmapPaint;
    android.graphics.Canvas canvas;
    private ColorFilter grayscaleFilter;
    private ColorFilter grayscaleInvertFilter;
    private HilshadingTemps hillshadingTemps;
    private ColorFilter invertFilter;

    /* renamed from: org.mapsforge.map.android.graphics.AndroidCanvas$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Filter;

        static {
            int[] iArr = new int[Filter.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Filter = iArr;
            try {
                iArr[Filter.GRAYSCALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Filter[Filter.GRAYSCALE_INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Filter[Filter.INVERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class HilshadingTemps {
        private final Rect adr;
        private final Rect asr;
        private Bitmap neutralShadingPixel;
        private Bitmap scaleTemp;
        private final Paint shadePaint;
        private Bitmap shiftTemp;
        private final android.graphics.Canvas tmpCanvas;
        private Matrix tmpMatrix;

        private HilshadingTemps() {
            this.asr = new Rect(0, 0, 0, 0);
            this.adr = new Rect(0, 0, 0, 0);
            this.tmpCanvas = new android.graphics.Canvas();
            this.neutralShadingPixel = AndroidGraphicFactory.INSTANCE.createMonoBitmap(1, 1, new byte[]{Ascii.DEL}, 0, (BoundingBox) null).bitmap;
            Paint paint = new Paint();
            this.shadePaint = paint;
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
        }

        /* synthetic */ HilshadingTemps(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Bitmap internalUseBitmap(Bitmap bitmap, int i3, int i4, Bitmap.Config config) {
            if (bitmap != null) {
                if (bitmap.getWidth() >= i3 && bitmap.getHeight() >= i4 && bitmap.getConfig().equals(config)) {
                    this.tmpCanvas.setBitmap(bitmap);
                    this.tmpCanvas.drawColor(Color.argb(0, 0, 0, 0), PorterDuff.Mode.SRC);
                    return bitmap;
                }
                bitmap.recycle();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, config);
            this.tmpCanvas.setBitmap(createBitmap);
            return createBitmap;
        }

        Rect useAdr(int i3, int i4, int i5, int i6) {
            Rect rect = this.adr;
            rect.left = i3;
            rect.top = i4;
            rect.right = i5;
            rect.bottom = i6;
            return rect;
        }

        Paint useAlphaPaint(int i3) {
            this.shadePaint.setAlpha(i3);
            return this.shadePaint;
        }

        Rect useAsr(int i3, int i4, int i5, int i6) {
            Rect rect = this.asr;
            rect.left = i3;
            rect.top = i4;
            rect.right = i5;
            rect.bottom = i6;
            return rect;
        }

        android.graphics.Canvas useCanvas() {
            return this.tmpCanvas;
        }

        Matrix useMatrix() {
            if (this.tmpMatrix == null) {
                this.tmpMatrix = new Matrix();
            }
            this.tmpMatrix.reset();
            return this.tmpMatrix;
        }

        Bitmap useNeutralShadingPixel() {
            return this.neutralShadingPixel;
        }

        Bitmap useScaleBitmap(int i3, int i4, Bitmap.Config config) {
            Bitmap internalUseBitmap = internalUseBitmap(this.scaleTemp, i3, i4, config);
            this.scaleTemp = internalUseBitmap;
            return internalUseBitmap;
        }

        Bitmap useShiftBitmap(int i3, int i4, Bitmap.Config config) {
            Bitmap internalUseBitmap = internalUseBitmap(this.shiftTemp, i3, i4, config);
            this.shiftTemp = internalUseBitmap;
            return internalUseBitmap;
        }
    }

    AndroidCanvas() {
        Paint paint = new Paint();
        this.bitmapPaint = paint;
        this.hillshadingTemps = null;
        this.canvas = new android.graphics.Canvas();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        createFilters();
    }

    AndroidCanvas(android.graphics.Canvas canvas) {
        this.bitmapPaint = new Paint();
        this.hillshadingTemps = null;
        this.canvas = canvas;
        createFilters();
    }

    private void applyFilter(Filter filter) {
        Paint paint;
        ColorFilter colorFilter;
        if (filter == Filter.NONE) {
            return;
        }
        int i3 = AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Filter[filter.ordinal()];
        if (i3 == 1) {
            paint = this.bitmapPaint;
            colorFilter = this.grayscaleFilter;
        } else if (i3 == 2) {
            paint = this.bitmapPaint;
            colorFilter = this.grayscaleInvertFilter;
        } else {
            if (i3 != 3) {
                return;
            }
            paint = this.bitmapPaint;
            colorFilter = this.invertFilter;
        }
        paint.setColorFilter(colorFilter);
    }

    private void createFilters() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(BitmapDescriptorFactory.HUE_RED);
        this.grayscaleFilter = new ColorMatrixColorFilter(colorMatrix);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.setSaturation(BitmapDescriptorFactory.HUE_RED);
        float[] fArr = INVERT_MATRIX;
        colorMatrix2.postConcat(new ColorMatrix(fArr));
        this.grayscaleInvertFilter = new ColorMatrixColorFilter(colorMatrix2);
        this.invertFilter = new ColorMatrixColorFilter(fArr);
    }

    private void setClipInternal(int i3, int i4, int i5, int i6, Region.Op op) {
        this.canvas.clipRect(i3, i4, i3 + i5, i4 + i6, op);
    }

    @Override // org.mapsforge.core.graphics.Canvas
    public void destroy() {
        this.canvas = null;
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawBitmap(org.mapsforge.core.graphics.Bitmap bitmap, int i3, int i4) {
        Bitmap bitmap2 = AndroidGraphicFactory.getBitmap(bitmap);
        if (AndroidGraphicFactory.MONO_ALPHA_BITMAP.equals(bitmap2.getConfig())) {
            this.canvas.drawColor(Color.argb(0, 0, 0, 0), PorterDuff.Mode.SRC);
        }
        this.canvas.drawBitmap(bitmap2, i3, i4, this.bitmapPaint);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawBitmap(org.mapsforge.core.graphics.Bitmap bitmap, int i3, int i4, float f3, Filter filter) {
        int alpha = this.bitmapPaint.getAlpha();
        if (f3 != 1.0f) {
            this.bitmapPaint.setAlpha((int) (f3 * 255.0f));
        }
        applyFilter(filter);
        this.canvas.drawBitmap(AndroidGraphicFactory.getBitmap(bitmap), i3, i4, this.bitmapPaint);
        if (filter != Filter.NONE) {
            this.bitmapPaint.setColorFilter(null);
        }
        if (f3 != 1.0f) {
            this.bitmapPaint.setAlpha(alpha);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawBitmap(org.mapsforge.core.graphics.Bitmap bitmap, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.canvas.drawBitmap(AndroidGraphicFactory.getBitmap(bitmap), new Rect(i3, i4, i5, i6), new Rect(i7, i8, i9, i10), this.bitmapPaint);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawBitmap(org.mapsforge.core.graphics.Bitmap bitmap, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f3, Filter filter) {
        int alpha = this.bitmapPaint.getAlpha();
        if (f3 != 1.0f) {
            this.bitmapPaint.setAlpha((int) (f3 * 255.0f));
        }
        applyFilter(filter);
        this.canvas.drawBitmap(AndroidGraphicFactory.getBitmap(bitmap), new Rect(i3, i4, i5, i6), new Rect(i7, i8, i9, i10), this.bitmapPaint);
        if (filter != Filter.NONE) {
            this.bitmapPaint.setColorFilter(null);
        }
        if (f3 != 1.0f) {
            this.bitmapPaint.setAlpha(alpha);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawBitmap(org.mapsforge.core.graphics.Bitmap bitmap, org.mapsforge.core.graphics.Matrix matrix) {
        this.canvas.drawBitmap(AndroidGraphicFactory.getBitmap(bitmap), AndroidGraphicFactory.getMatrix(matrix), this.bitmapPaint);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawBitmap(org.mapsforge.core.graphics.Bitmap bitmap, org.mapsforge.core.graphics.Matrix matrix, float f3, Filter filter) {
        int alpha = this.bitmapPaint.getAlpha();
        if (f3 != 1.0f) {
            this.bitmapPaint.setAlpha((int) (f3 * 255.0f));
        }
        applyFilter(filter);
        this.canvas.drawBitmap(AndroidGraphicFactory.getBitmap(bitmap), AndroidGraphicFactory.getMatrix(matrix), this.bitmapPaint);
        if (filter != Filter.NONE) {
            this.bitmapPaint.setColorFilter(null);
        }
        if (f3 != 1.0f) {
            this.bitmapPaint.setAlpha(alpha);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawCircle(int i3, int i4, int i5, org.mapsforge.core.graphics.Paint paint) {
        if (paint.isTransparent()) {
            return;
        }
        this.canvas.drawCircle(i3, i4, i5, AndroidGraphicFactory.getPaint(paint));
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawLine(int i3, int i4, int i5, int i6, org.mapsforge.core.graphics.Paint paint) {
        if (paint.isTransparent()) {
            return;
        }
        this.canvas.drawLine(i3, i4, i5, i6, AndroidGraphicFactory.getPaint(paint));
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawPath(Path path, org.mapsforge.core.graphics.Paint paint) {
        if (paint.isTransparent()) {
            return;
        }
        this.canvas.drawPath(AndroidGraphicFactory.getPath(path), AndroidGraphicFactory.getPaint(paint));
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawPathText(String str, Path path, org.mapsforge.core.graphics.Paint paint) {
        if (str == null || str.trim().isEmpty() || paint.isTransparent()) {
            return;
        }
        Paint paint2 = AndroidGraphicFactory.getPaint(paint);
        this.canvas.drawTextOnPath(str, AndroidGraphicFactory.getPath(path), BitmapDescriptorFactory.HUE_RED, paint2.getTextSize() / 4.0f, paint2);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawText(String str, int i3, int i4, org.mapsforge.core.graphics.Paint paint) {
        if (str == null || str.trim().isEmpty() || paint.isTransparent()) {
            return;
        }
        this.canvas.drawText(str, i3, i4, AndroidGraphicFactory.getPaint(paint));
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void drawTextRotated(String str, int i3, int i4, int i5, int i6, org.mapsforge.core.graphics.Paint paint) {
        if (str == null || str.trim().isEmpty() || paint.isTransparent()) {
            return;
        }
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(i3, i4);
        path.lineTo(i5, i6);
        this.canvas.drawTextOnPath(str, path, BitmapDescriptorFactory.HUE_RED, 3.0f, AndroidGraphicFactory.getPaint(paint));
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void fillColor(int i3) {
        this.canvas.drawColor(i3, ((i3 >> 24) & 255) == 0 ? PorterDuff.Mode.CLEAR : PorterDuff.Mode.SRC_OVER);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void fillColor(org.mapsforge.core.graphics.Color color) {
        fillColor(AndroidGraphicFactory.getColor(color));
    }

    @Override // org.mapsforge.core.graphics.Canvas
    public Dimension getDimension() {
        return new Dimension(getWidth(), getHeight());
    }

    @Override // org.mapsforge.core.graphics.Canvas
    public int getHeight() {
        return this.canvas.getHeight();
    }

    @Override // org.mapsforge.core.graphics.Canvas
    public int getWidth() {
        return this.canvas.getWidth();
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public boolean isAntiAlias() {
        return this.bitmapPaint.isAntiAlias();
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public boolean isFilterBitmap() {
        return this.bitmapPaint.isFilterBitmap();
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void resetClip() {
        if (Build.VERSION.SDK_INT < 26) {
            this.canvas.clipRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, getWidth(), getHeight(), Region.Op.REPLACE);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void setAntiAlias(boolean z3) {
        this.bitmapPaint.setAntiAlias(z3);
    }

    @Override // org.mapsforge.core.graphics.Canvas
    public void setBitmap(org.mapsforge.core.graphics.Bitmap bitmap) {
        this.canvas.setBitmap(AndroidGraphicFactory.getBitmap(bitmap));
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void setClip(int i3, int i4, int i5, int i6) {
        setClip(i3, i4, i5, i6, false);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void setClip(int i3, int i4, int i5, int i6, boolean z3) {
        if (Build.VERSION.SDK_INT < 26) {
            setClipInternal(i3, i4, i5, i6, Region.Op.REPLACE);
        } else if (z3) {
            this.canvas.clipRect(i3, i4, i5 + i3, i6 + i4);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void setClipDifference(int i3, int i4, int i5, int i6) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.canvas.clipOutRect(i3, i4, i5 + i3, i6 + i4);
        } else {
            setClipInternal(i3, i4, i5, i6, Region.Op.DIFFERENCE);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void setFilterBitmap(boolean z3) {
        this.bitmapPaint.setFilterBitmap(z3);
    }

    @Override // org.mapsforge.core.graphics.GraphicContext
    public void shadeBitmap(org.mapsforge.core.graphics.Bitmap bitmap, Rectangle rectangle, Rectangle rectangle2, float f3) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        this.canvas.save();
        AnonymousClass1 anonymousClass1 = null;
        if (this.hillshadingTemps == null) {
            this.hillshadingTemps = new HilshadingTemps(anonymousClass1);
        }
        HilshadingTemps hilshadingTemps = this.hillshadingTemps;
        Paint useAlphaPaint = hilshadingTemps.useAlphaPaint((int) (255.0f * f3));
        if (bitmap == null) {
            if (rectangle2 != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.canvas.clipRect((float) rectangle2.left, (float) rectangle2.top, (float) rectangle2.right, (float) rectangle2.bottom);
                } else {
                    this.canvas.clipRect((float) rectangle2.left, (float) rectangle2.top, (float) rectangle2.right, (float) rectangle2.bottom, Region.Op.REPLACE);
                }
            }
            this.canvas.drawBitmap(this.hillshadingTemps.useNeutralShadingPixel(), this.hillshadingTemps.useAsr(0, 0, 1, 1), this.hillshadingTemps.useAdr(0, 0, this.canvas.getWidth(), this.canvas.getHeight()), useAlphaPaint);
        } else {
            Bitmap bitmap4 = AndroidGraphicFactory.getBitmap(bitmap);
            double width = rectangle2.getWidth() / rectangle.getWidth();
            double height = rectangle2.getHeight() / rectangle.getHeight();
            if (width >= 1.0d || height >= 1.0d) {
                double d3 = rectangle.left;
                double min = Math.min(rectangle.left, (d3 - Math.floor(d3)) + 1.0d);
                double min2 = Math.min(bitmap.getWidth() - rectangle.right, (Math.floor(rectangle.right) + 2.0d) - rectangle.right);
                int ceil = (int) Math.ceil((width * min2) + (width * min) + ((rectangle.right - rectangle.left) * width));
                double d4 = rectangle.top;
                double min3 = Math.min(rectangle.top, (d4 - Math.floor(d4)) + 1.0d);
                double min4 = Math.min(bitmap.getHeight() - rectangle.bottom, (Math.floor(rectangle.bottom) + 2.0d) - rectangle.bottom);
                int ceil2 = (int) Math.ceil((height * min4) + (height * min3) + ((rectangle.bottom - rectangle.top) * height));
                int round = (int) Math.round(rectangle.left - min);
                int round2 = (int) Math.round(rectangle.top - min3);
                int round3 = (int) Math.round(rectangle.right + min2);
                int round4 = (int) Math.round(rectangle.bottom + min4);
                android.graphics.Canvas useCanvas = hilshadingTemps.useCanvas();
                if (round == 0 && round2 == 0) {
                    round3++;
                    bitmap3 = Bitmap.createBitmap(round3, round4, bitmap4.getConfig());
                    useCanvas.setBitmap(bitmap3);
                    bitmap2 = bitmap4;
                    useCanvas.drawBitmap(bitmap2, 1.0f, BitmapDescriptorFactory.HUE_RED, (Paint) null);
                    round++;
                } else {
                    bitmap2 = bitmap4;
                    bitmap3 = bitmap2;
                }
                Rect useAsr = hilshadingTemps.useAsr(round, round2, round3, round4);
                Rect useAdr = hilshadingTemps.useAdr(0, 0, ceil, ceil2);
                Bitmap useScaleBitmap = hilshadingTemps.useScaleBitmap(ceil, ceil2, bitmap2.getConfig());
                useCanvas.setBitmap(useScaleBitmap);
                useCanvas.drawBitmap(bitmap3, useAsr, useAdr, this.bitmapPaint);
                this.canvas.clipRect((float) rectangle2.left, (float) rectangle2.top, (float) rectangle2.right, (float) rectangle2.bottom);
                this.canvas.drawBitmap(useScaleBitmap, (int) Math.round(rectangle2.left - r6), (int) Math.round(rectangle2.top - r9), useAlphaPaint);
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.canvas.clipRect((float) rectangle2.left, (float) rectangle2.top, (float) rectangle2.right, (float) rectangle2.bottom);
                } else {
                    this.canvas.clipRect((float) rectangle2.left, (float) rectangle2.top, (float) rectangle2.right, (float) rectangle2.bottom, Region.Op.REPLACE);
                }
                Matrix useMatrix = hilshadingTemps.useMatrix();
                useMatrix.preTranslate((float) rectangle2.left, (float) rectangle2.top);
                useMatrix.preScale((float) width, (float) height);
                useMatrix.preTranslate((float) (-rectangle.left), (float) (-rectangle.top));
                this.canvas.drawBitmap(bitmap4, useMatrix, useAlphaPaint);
            }
        }
        this.canvas.restore();
    }
}
