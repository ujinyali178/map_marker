package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* loaded from: /root/release/classes.dex */
public class h0 implements p {

    /* renamed from: a, reason: collision with root package name */
    private final TextureRegistry.SurfaceTextureEntry f3153a;

    /* renamed from: b, reason: collision with root package name */
    private SurfaceTexture f3154b;

    /* renamed from: c, reason: collision with root package name */
    private Surface f3155c;

    /* renamed from: d, reason: collision with root package name */
    private int f3156d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f3157e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3158f = false;

    /* renamed from: g, reason: collision with root package name */
    private final TextureRegistry.b f3159g;

    class a implements TextureRegistry.b {
        a() {
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i3) {
            if (i3 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            h0.this.f3158f = true;
        }
    }

    public h0(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        a aVar = new a();
        this.f3159g = aVar;
        if (Build.VERSION.SDK_INT < 23) {
            throw new UnsupportedOperationException("Platform views cannot be displayed below API level 23You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
        }
        this.f3153a = surfaceTextureEntry;
        this.f3154b = surfaceTextureEntry.surfaceTexture();
        surfaceTextureEntry.setOnTrimMemoryListener(aVar);
    }

    private void d() {
        Surface surface = this.f3155c;
        if (surface == null || this.f3158f) {
            if (surface != null) {
                surface.release();
                this.f3155c = null;
            }
            this.f3155c = c();
            this.f3158f = false;
        }
    }

    @Override // io.flutter.plugin.platform.p
    public void a(int i3, int i4) {
        this.f3156d = i3;
        this.f3157e = i4;
        SurfaceTexture surfaceTexture = this.f3154b;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i3, i4);
        }
    }

    protected Surface c() {
        return new Surface(this.f3154b);
    }

    @Override // io.flutter.plugin.platform.p
    public int getHeight() {
        return this.f3157e;
    }

    @Override // io.flutter.plugin.platform.p
    public long getId() {
        return this.f3153a.id();
    }

    @Override // io.flutter.plugin.platform.p
    public Surface getSurface() {
        boolean isReleased;
        d();
        SurfaceTexture surfaceTexture = this.f3154b;
        if (surfaceTexture == null) {
            return null;
        }
        isReleased = surfaceTexture.isReleased();
        if (isReleased) {
            return null;
        }
        return this.f3155c;
    }

    @Override // io.flutter.plugin.platform.p
    public int getWidth() {
        return this.f3156d;
    }

    @Override // io.flutter.plugin.platform.p
    public void release() {
        this.f3154b = null;
        Surface surface = this.f3155c;
        if (surface != null) {
            surface.release();
            this.f3155c = null;
        }
    }

    @Override // io.flutter.plugin.platform.p
    public /* synthetic */ void scheduleFrame() {
        o.a(this);
    }
}
