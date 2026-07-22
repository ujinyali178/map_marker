package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public class n extends View implements io.flutter.embedding.engine.renderer.e {

    /* renamed from: c, reason: collision with root package name */
    private ImageReader f2828c;

    /* renamed from: d, reason: collision with root package name */
    private Image f2829d;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f2830f;

    /* renamed from: g, reason: collision with root package name */
    private FlutterRenderer f2831g;

    /* renamed from: h, reason: collision with root package name */
    private b f2832h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2833i;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2834a;

        static {
            int[] iArr = new int[b.values().length];
            f2834a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2834a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        background,
        overlay
    }

    public n(Context context, int i3, int i4, b bVar) {
        this(context, h(i3, i4), bVar);
    }

    n(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f2833i = false;
        this.f2828c = imageReader;
        this.f2832h = bVar;
        i();
    }

    private void f() {
        Image image = this.f2829d;
        if (image != null) {
            image.close();
            this.f2829d = null;
        }
    }

    private static ImageReader h(int i3, int i4) {
        int i5;
        int i6;
        ImageReader newInstance;
        if (i3 <= 0) {
            j("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i3));
            i5 = 1;
        } else {
            i5 = i3;
        }
        if (i4 <= 0) {
            j("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i4));
            i6 = 1;
        } else {
            i6 = i4;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return ImageReader.newInstance(i5, i6, 1, 3);
        }
        newInstance = ImageReader.newInstance(i5, i6, 1, 3, 768L);
        return newInstance;
    }

    private void i() {
        setAlpha(BitmapDescriptorFactory.HUE_RED);
    }

    private static void j(String str, Object... objArr) {
        g1.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    private void l() {
        HardwareBuffer hardwareBuffer;
        Bitmap wrapHardwareBuffer;
        if (Build.VERSION.SDK_INT >= 29) {
            hardwareBuffer = this.f2829d.getHardwareBuffer();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            this.f2830f = wrapHardwareBuffer;
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f2829d.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f2829d.getHeight();
        Bitmap bitmap = this.f2830f;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f2830f.getHeight() != height) {
            this.f2830f = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f2830f.copyPixelsFromBuffer(buffer);
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b(FlutterRenderer flutterRenderer) {
        if (a.f2834a[this.f2832h.ordinal()] == 1) {
            flutterRenderer.B(this.f2828c.getSurface());
        }
        setAlpha(1.0f);
        this.f2831g = flutterRenderer;
        this.f2833i = true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c() {
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f2833i) {
            setAlpha(BitmapDescriptorFactory.HUE_RED);
            e();
            this.f2830f = null;
            f();
            invalidate();
            this.f2833i = false;
        }
    }

    public boolean e() {
        if (!this.f2833i) {
            return false;
        }
        Image acquireLatestImage = this.f2828c.acquireLatestImage();
        if (acquireLatestImage != null) {
            f();
            this.f2829d = acquireLatestImage;
            invalidate();
        }
        return acquireLatestImage != null;
    }

    public void g() {
        this.f2828c.close();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f2831g;
    }

    public ImageReader getImageReader() {
        return this.f2828c;
    }

    public Surface getSurface() {
        return this.f2828c.getSurface();
    }

    public void k(int i3, int i4) {
        if (this.f2831g == null) {
            return;
        }
        if (i3 == this.f2828c.getWidth() && i4 == this.f2828c.getHeight()) {
            return;
        }
        f();
        g();
        this.f2828c = h(i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2829d != null) {
            l();
        }
        Bitmap bitmap = this.f2830f;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        if (!(i3 == this.f2828c.getWidth() && i4 == this.f2828c.getHeight()) && this.f2832h == b.background && this.f2833i) {
            k(i3, i4);
            this.f2831g.B(this.f2828c.getSurface());
        }
    }
}
