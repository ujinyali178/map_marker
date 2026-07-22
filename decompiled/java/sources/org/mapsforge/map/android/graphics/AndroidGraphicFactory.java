package org.mapsforge.map.android.graphics;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.Display;
import org.mapsforge.core.graphics.GraphicFactory;
import org.mapsforge.core.graphics.Position;
import org.mapsforge.core.graphics.ResourceBitmap;
import org.mapsforge.core.graphics.TileBitmap;
import org.mapsforge.core.mapelements.PointTextContainer;
import org.mapsforge.core.mapelements.SymbolContainer;
import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.model.DisplayModel;

/* loaded from: /root/release/classes2.dex */
public final class AndroidGraphicFactory implements GraphicFactory {
    public static final boolean DEBUG_BITMAPS = false;
    public static final boolean KEEP_RESOURCE_BITMAPS = true;
    private final Application application;
    private File svgCacheDir;
    public static AndroidGraphicFactory INSTANCE = new AndroidGraphicFactory(null);
    public static final Bitmap.Config NON_TRANSPARENT_BITMAP = Bitmap.Config.RGB_565;
    public static final Bitmap.Config TRANSPARENT_BITMAP = Bitmap.Config.ARGB_8888;
    public static final Bitmap.Config MONO_ALPHA_BITMAP = Bitmap.Config.ALPHA_8;

    /* renamed from: org.mapsforge.map.android.graphics.AndroidGraphicFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mapsforge$core$graphics$Color;

        static {
            int[] iArr = new int[Color.values().length];
            $SwitchMap$org$mapsforge$core$graphics$Color = iArr;
            try {
                iArr[Color.BLACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Color[Color.BLUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Color[Color.GREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Color[Color.RED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Color[Color.TRANSPARENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$mapsforge$core$graphics$Color[Color.WHITE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private AndroidGraphicFactory(Application application) {
        this.application = application;
        if (application != null) {
            DisplayModel.setDeviceScaleFactor(application.getResources().getDisplayMetrics().scaledDensity);
        }
    }

    public static void clearResourceFileCache() {
        AndroidSvgBitmapStore.clear();
    }

    public static void clearResourceMemoryCache() {
        AndroidResourceBitmap.clearResourceBitmaps();
    }

    public static Bitmap convertToAndroidBitmap(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 28 && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, TRANSPARENT_BITMAP);
        Canvas canvas = new Canvas(createBitmap);
        Rect bounds = drawable.getBounds();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        drawable.setBounds(bounds);
        return createBitmap;
    }

    public static org.mapsforge.core.graphics.Bitmap convertToBitmap(Drawable drawable) {
        return new AndroidBitmap(convertToAndroidBitmap(drawable));
    }

    public static org.mapsforge.core.graphics.Bitmap convertToBitmap(Drawable drawable, Paint paint) {
        Bitmap copy = convertToAndroidBitmap(drawable).copy(TRANSPARENT_BITMAP, true);
        new Canvas(copy).drawBitmap(copy, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        return new AndroidBitmap(copy);
    }

    public static org.mapsforge.core.graphics.Canvas createGraphicContext(Canvas canvas) {
        return new AndroidCanvas(canvas);
    }

    public static void createInstance(Application application) {
        INSTANCE = new AndroidGraphicFactory(application);
    }

    public static Bitmap getBitmap(org.mapsforge.core.graphics.Bitmap bitmap) {
        return ((AndroidBitmap) bitmap).bitmap;
    }

    public static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    public static Canvas getCanvas(org.mapsforge.core.graphics.Canvas canvas) {
        return ((AndroidCanvas) canvas).canvas;
    }

    static int getColor(Color color) {
        switch (AnonymousClass1.$SwitchMap$org$mapsforge$core$graphics$Color[color.ordinal()]) {
            case 1:
                return -16777216;
            case 2:
                return -16776961;
            case 3:
                return -16711936;
            case 4:
                return -65536;
            case 5:
                return 0;
            case 6:
                return -1;
            default:
                throw new IllegalArgumentException("unknown color: " + color);
        }
    }

    static Matrix getMatrix(org.mapsforge.core.graphics.Matrix matrix) {
        return ((AndroidMatrix) matrix).matrix;
    }

    public static Paint getPaint(org.mapsforge.core.graphics.Paint paint) {
        return ((AndroidPaint) paint).paint;
    }

    static Path getPath(org.mapsforge.core.graphics.Path path) {
        return ((AndroidPath) path).path;
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Bitmap createBitmap(int i3, int i4) {
        return new AndroidBitmap(i3, i4, TRANSPARENT_BITMAP);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Bitmap createBitmap(int i3, int i4, boolean z3) {
        return z3 ? new AndroidBitmap(i3, i4, TRANSPARENT_BITMAP) : new AndroidBitmap(i3, i4, NON_TRANSPARENT_BITMAP);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Canvas createCanvas() {
        return new AndroidCanvas();
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public int createColor(int i3, int i4, int i5, int i6) {
        return android.graphics.Color.argb(i3, i4, i5, i6);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public int createColor(Color color) {
        return getColor(color);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Matrix createMatrix() {
        return new AndroidMatrix();
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public AndroidHillshadingBitmap createMonoBitmap(int i3, int i4, byte[] bArr, int i5, BoundingBox boundingBox) {
        int i6 = i5 * 2;
        AndroidHillshadingBitmap androidHillshadingBitmap = new AndroidHillshadingBitmap(i3 + i6, i4 + i6, i5, boundingBox);
        if (bArr != null) {
            androidHillshadingBitmap.bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        }
        return androidHillshadingBitmap;
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Paint createPaint() {
        return new AndroidPaint();
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Paint createPaint(org.mapsforge.core.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public org.mapsforge.core.graphics.Path createPath() {
        return new AndroidPath();
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public PointTextContainer createPointTextContainer(Point point, Display display, int i3, String str, org.mapsforge.core.graphics.Paint paint, org.mapsforge.core.graphics.Paint paint2, SymbolContainer symbolContainer, Position position, int i4) {
        return new AndroidPointTextContainer(point, display, i3, str, paint, paint2, symbolContainer, position, i4);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public ResourceBitmap createResourceBitmap(InputStream inputStream, float f3, int i3, int i4, int i5, int i6) {
        return new AndroidResourceBitmap(inputStream, f3, i3, i4, i5, i6);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public TileBitmap createTileBitmap(int i3, boolean z3) {
        return new AndroidTileBitmap(i3, z3);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public TileBitmap createTileBitmap(InputStream inputStream, int i3, boolean z3) {
        return new AndroidTileBitmap(inputStream, i3, z3);
    }

    public boolean deleteFile(String str) {
        return this.svgCacheDir != null ? new File(this.svgCacheDir, str).delete() : this.application.deleteFile(str);
    }

    public String[] fileList() {
        File file = this.svgCacheDir;
        return file != null ? file.list() : this.application.fileList();
    }

    public FileInputStream openFileInput(String str) {
        return this.svgCacheDir != null ? new FileInputStream(new File(this.svgCacheDir, str)) : this.application.openFileInput(str);
    }

    public FileOutputStream openFileOutput(String str, int i3) {
        if (this.svgCacheDir != null) {
            return new FileOutputStream(new File(this.svgCacheDir, str), i3 == 32768);
        }
        return this.application.openFileOutput(str, i3);
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public InputStream platformSpecificSources(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(str2);
        String sb2 = sb.toString();
        try {
            return this.application.getAssets().open(sb2);
        } catch (IOException unused) {
            throw new FileNotFoundException("invalid resource: " + sb2);
        }
    }

    @Override // org.mapsforge.core.graphics.GraphicFactory
    public ResourceBitmap renderSvg(InputStream inputStream, float f3, int i3, int i4, int i5, int i6) {
        return new AndroidSvgBitmap(inputStream, i6, f3, i3, i4, i5);
    }

    public void setSvgCacheDir(File file) {
        this.svgCacheDir = file;
    }
}
