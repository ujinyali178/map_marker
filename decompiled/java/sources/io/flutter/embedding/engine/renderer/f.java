package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;

/* loaded from: /root/release/classes.dex */
final class f implements TextureRegistry.SurfaceProducer, TextureRegistry.GLTextureConsumer {

    /* renamed from: a, reason: collision with root package name */
    private final long f3041a;

    /* renamed from: b, reason: collision with root package name */
    private int f3042b;

    /* renamed from: c, reason: collision with root package name */
    private int f3043c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3044d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f3045e;

    /* renamed from: f, reason: collision with root package name */
    private final TextureRegistry.SurfaceTextureEntry f3046f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f3047g;

    /* renamed from: h, reason: collision with root package name */
    private final FlutterJNI f3048h;

    f(long j3, Handler handler, FlutterJNI flutterJNI, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        this.f3041a = j3;
        this.f3047g = handler;
        this.f3048h = flutterJNI;
        this.f3046f = surfaceTextureEntry;
    }

    protected void finalize() {
        try {
            if (this.f3044d) {
                return;
            }
            release();
            this.f3047g.post(new FlutterRenderer.f(this.f3041a, this.f3048h));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public int getHeight() {
        return this.f3043c;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public Surface getSurface() {
        if (this.f3045e == null) {
            this.f3045e = new Surface(this.f3046f.surfaceTexture());
        }
        return this.f3045e;
    }

    @Override // io.flutter.view.TextureRegistry.GLTextureConsumer
    public SurfaceTexture getSurfaceTexture() {
        return this.f3046f.surfaceTexture();
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public int getWidth() {
        return this.f3042b;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public long id() {
        return this.f3041a;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void release() {
        this.f3046f.release();
        this.f3044d = true;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void scheduleFrame() {
        this.f3048h.markTextureFrameAvailable(this.f3041a);
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void setSize(int i3, int i4) {
        this.f3042b = i3;
        this.f3043c = i4;
        getSurfaceTexture().setDefaultBufferSize(i3, i4);
    }
}
