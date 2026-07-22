package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* loaded from: /root/release/classes.dex */
public class o extends SurfaceView implements io.flutter.embedding.engine.renderer.e {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f2838c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2839d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2840f;

    /* renamed from: g, reason: collision with root package name */
    private FlutterRenderer f2841g;

    /* renamed from: h, reason: collision with root package name */
    private final SurfaceHolder.Callback f2842h;

    /* renamed from: i, reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f2843i;

    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
            g1.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (o.this.p()) {
                o.this.k(i4, i5);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            g1.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            o.this.f2839d = true;
            if (o.this.p()) {
                o.this.l();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            g1.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            o.this.f2839d = false;
            if (o.this.p()) {
                o.this.m();
            }
        }
    }

    class b implements io.flutter.embedding.engine.renderer.d {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void b() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            g1.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            o.this.setAlpha(1.0f);
            if (o.this.f2841g != null) {
                o.this.f2841g.t(this);
            }
        }
    }

    private o(Context context, AttributeSet attributeSet, boolean z3) {
        super(context, attributeSet);
        this.f2839d = false;
        this.f2840f = false;
        this.f2842h = new a();
        this.f2843i = new b();
        this.f2838c = z3;
        n();
    }

    public o(Context context, boolean z3) {
        this(context, null, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3, int i4) {
        if (this.f2841g == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        g1.b.f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i3 + " x " + i4);
        this.f2841g.A(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f2841g == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f2841g.y(getHolder().getSurface(), this.f2840f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        FlutterRenderer flutterRenderer = this.f2841g;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.z();
    }

    private void n() {
        if (this.f2838c) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f2842h);
        setAlpha(BitmapDescriptorFactory.HUE_RED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return (this.f2841g == null || this.f2840f) ? false : true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        FlutterRenderer flutterRenderer = this.f2841g;
        if (flutterRenderer == null) {
            g1.b.g("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        flutterRenderer.f(this.f2843i);
        if (o()) {
            g1.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            l();
        }
        this.f2840f = false;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b(FlutterRenderer flutterRenderer) {
        g1.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f2841g != null) {
            g1.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f2841g.z();
            this.f2841g.t(this.f2843i);
        }
        this.f2841g = flutterRenderer;
        a();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c() {
        if (this.f2841g == null) {
            g1.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f2840f = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f2841g == null) {
            g1.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            g1.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            m();
        }
        setAlpha(BitmapDescriptorFactory.HUE_RED);
        this.f2841g.t(this.f2843i);
        this.f2841g = null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = iArr[0];
        region.op(i3, iArr[1], (getRight() + i3) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f2841g;
    }

    boolean o() {
        return this.f2839d;
    }
}
