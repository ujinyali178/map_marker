package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* loaded from: /root/release/classes.dex */
public class p extends TextureView implements io.flutter.embedding.engine.renderer.e {

    /* renamed from: c, reason: collision with root package name */
    private boolean f2846c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2847d;

    /* renamed from: f, reason: collision with root package name */
    private FlutterRenderer f2848f;

    /* renamed from: g, reason: collision with root package name */
    private Surface f2849g;

    /* renamed from: h, reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f2850h;

    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i4) {
            g1.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            p.this.f2846c = true;
            if (p.this.q()) {
                p.this.m();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            g1.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            p.this.f2846c = false;
            if (p.this.q()) {
                p.this.n();
            }
            if (p.this.f2849g == null) {
                return true;
            }
            p.this.f2849g.release();
            p.this.f2849g = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i4) {
            g1.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (p.this.q()) {
                p.this.l(i3, i4);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2846c = false;
        this.f2847d = false;
        this.f2850h = new a();
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, int i4) {
        if (this.f2848f == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        g1.b.f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i3 + " x " + i4);
        this.f2848f.A(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f2848f == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f2849g;
        if (surface != null) {
            surface.release();
            this.f2849g = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f2849g = surface2;
        this.f2848f.y(surface2, this.f2847d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        FlutterRenderer flutterRenderer = this.f2848f;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.z();
        Surface surface = this.f2849g;
        if (surface != null) {
            surface.release();
            this.f2849g = null;
        }
    }

    private void o() {
        setSurfaceTextureListener(this.f2850h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return (this.f2848f == null || this.f2847d) ? false : true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        if (this.f2848f == null) {
            g1.b.g("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (p()) {
            g1.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m();
        }
        this.f2847d = false;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b(FlutterRenderer flutterRenderer) {
        g1.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f2848f != null) {
            g1.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f2848f.z();
        }
        this.f2848f = flutterRenderer;
        a();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c() {
        if (this.f2848f == null) {
            g1.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f2847d = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f2848f == null) {
            g1.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            g1.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            n();
        }
        this.f2848f = null;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f2848f;
    }

    boolean p() {
        return this.f2846c;
    }

    public void setRenderSurface(Surface surface) {
        this.f2849g = surface;
    }
}
