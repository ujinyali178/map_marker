package io.flutter.plugin.platform;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* loaded from: /root/release/classes.dex */
public class b implements p {

    /* renamed from: a, reason: collision with root package name */
    private TextureRegistry.ImageTextureEntry f3128a;

    /* renamed from: b, reason: collision with root package name */
    private ImageReader f3129b;

    /* renamed from: c, reason: collision with root package name */
    private int f3130c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f3131d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f3132e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    private final ImageReader.OnImageAvailableListener f3133f = new a();

    class a implements ImageReader.OnImageAvailableListener {
        a() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                image = imageReader.acquireLatestImage();
            } catch (IllegalStateException e3) {
                g1.b.b("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e3.toString());
                image = null;
            }
            if (image == null) {
                return;
            }
            b.this.f3128a.pushImage(image);
        }
    }

    public b(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f3128a = imageTextureEntry;
    }

    private void c() {
        if (this.f3129b != null) {
            this.f3128a.pushImage(null);
            this.f3129b.close();
            this.f3129b = null;
        }
    }

    @Override // io.flutter.plugin.platform.p
    public void a(int i3, int i4) {
        if (this.f3129b != null && this.f3130c == i3 && this.f3131d == i4) {
            return;
        }
        c();
        this.f3130c = i3;
        this.f3131d = i4;
        this.f3129b = d();
    }

    protected ImageReader d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            return f();
        }
        if (i3 >= 29) {
            return e();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    protected ImageReader e() {
        ImageReader newInstance;
        newInstance = ImageReader.newInstance(this.f3130c, this.f3131d, 34, 4, 256L);
        newInstance.setOnImageAvailableListener(this.f3133f, this.f3132e);
        return newInstance;
    }

    protected ImageReader f() {
        ImageReader.Builder builder = new ImageReader.Builder(this.f3130c, this.f3131d);
        builder.setMaxImages(4);
        builder.setImageFormat(34);
        builder.setUsage(256L);
        ImageReader build = builder.build();
        build.setOnImageAvailableListener(this.f3133f, this.f3132e);
        return build;
    }

    @Override // io.flutter.plugin.platform.p
    public int getHeight() {
        return this.f3131d;
    }

    @Override // io.flutter.plugin.platform.p
    public long getId() {
        return this.f3128a.id();
    }

    @Override // io.flutter.plugin.platform.p
    public Surface getSurface() {
        return this.f3129b.getSurface();
    }

    @Override // io.flutter.plugin.platform.p
    public int getWidth() {
        return this.f3130c;
    }

    @Override // io.flutter.plugin.platform.p
    public void release() {
        c();
        this.f3128a = null;
    }

    @Override // io.flutter.plugin.platform.p
    public /* synthetic */ void scheduleFrame() {
        o.a(this);
    }
}
