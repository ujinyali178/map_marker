package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.d0;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.platform.y;
import io.flutter.view.TextureRegistry;
import io.flutter.view.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import t1.p;
import u1.d;
import w1.b;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class v extends SurfaceView implements u1.d, TextureRegistry, b.c, d0.e {
    private boolean A;
    private final h.k B;

    /* renamed from: c, reason: collision with root package name */
    private final i1.a f3619c;

    /* renamed from: d, reason: collision with root package name */
    private final FlutterRenderer f3620d;

    /* renamed from: f, reason: collision with root package name */
    private final t1.j f3621f;

    /* renamed from: g, reason: collision with root package name */
    private final t1.b f3622g;

    /* renamed from: h, reason: collision with root package name */
    private final t1.g f3623h;

    /* renamed from: i, reason: collision with root package name */
    private final t1.h f3624i;

    /* renamed from: j, reason: collision with root package name */
    private final t1.k f3625j;

    /* renamed from: k, reason: collision with root package name */
    private final t1.p f3626k;

    /* renamed from: l, reason: collision with root package name */
    private final t1.r f3627l;

    /* renamed from: m, reason: collision with root package name */
    private final InputMethodManager f3628m;

    /* renamed from: n, reason: collision with root package name */
    private final io.flutter.plugin.editing.m f3629n;

    /* renamed from: o, reason: collision with root package name */
    private final v1.b f3630o;

    /* renamed from: p, reason: collision with root package name */
    private final w1.b f3631p;

    /* renamed from: q, reason: collision with root package name */
    private final d0 f3632q;

    /* renamed from: r, reason: collision with root package name */
    private final io.flutter.embedding.android.c f3633r;

    /* renamed from: s, reason: collision with root package name */
    private io.flutter.view.h f3634s;

    /* renamed from: t, reason: collision with root package name */
    private final SurfaceHolder.Callback f3635t;

    /* renamed from: u, reason: collision with root package name */
    private final g f3636u;

    /* renamed from: v, reason: collision with root package name */
    private final List<u1.a> f3637v;

    /* renamed from: w, reason: collision with root package name */
    private final List<d> f3638w;

    /* renamed from: x, reason: collision with root package name */
    private final AtomicLong f3639x;

    /* renamed from: y, reason: collision with root package name */
    private t f3640y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3641z;

    class a implements h.k {
        a() {
        }

        @Override // io.flutter.view.h.k
        public void a(boolean z3, boolean z4) {
            v.this.J(z3, z4);
        }
    }

    class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i4, int i5) {
            v.this.q();
            v.this.f3640y.o().onSurfaceChanged(i4, i5);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            v.this.q();
            v.this.f3640y.o().onSurfaceCreated(surfaceHolder.getSurface());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            v.this.q();
            v.this.f3640y.o().onSurfaceDestroyed();
        }
    }

    class c implements u1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ io.flutter.plugin.platform.g f3644a;

        c(io.flutter.plugin.platform.g gVar) {
            this.f3644a = gVar;
        }

        @Override // u1.a
        public void onPostResume() {
            this.f3644a.E();
        }
    }

    public interface d {
        void a();
    }

    public interface e {
    }

    final class f implements TextureRegistry.SurfaceTextureEntry {

        /* renamed from: a, reason: collision with root package name */
        private final long f3646a;

        /* renamed from: b, reason: collision with root package name */
        private final SurfaceTextureWrapper f3647b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3648c;

        /* renamed from: d, reason: collision with root package name */
        private SurfaceTexture.OnFrameAvailableListener f3649d = new a();

        class a implements SurfaceTexture.OnFrameAvailableListener {
            a() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (f.this.f3648c || v.this.f3640y == null) {
                    return;
                }
                v.this.f3640y.o().markTextureFrameAvailable(f.this.f3646a);
            }
        }

        f(long j3, SurfaceTexture surfaceTexture) {
            this.f3646a = j3;
            this.f3647b = new SurfaceTextureWrapper(surfaceTexture);
            surfaceTexture().setOnFrameAvailableListener(this.f3649d, new Handler());
        }

        public SurfaceTextureWrapper c() {
            return this.f3647b;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.f3646a;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.f3648c) {
                return;
            }
            this.f3648c = true;
            surfaceTexture().setOnFrameAvailableListener(null);
            this.f3647b.release();
            v.this.f3640y.o().unregisterTexture(this.f3646a);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public /* synthetic */ void setOnFrameConsumedListener(TextureRegistry.a aVar) {
            w.a(this, aVar);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public /* synthetic */ void setOnTrimMemoryListener(TextureRegistry.b bVar) {
            w.b(this, bVar);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            return this.f3647b.surfaceTexture();
        }
    }

    static final class g {

        /* renamed from: a, reason: collision with root package name */
        float f3652a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        int f3653b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f3654c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f3655d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f3656e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f3657f = 0;

        /* renamed from: g, reason: collision with root package name */
        int f3658g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f3659h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f3660i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f3661j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f3662k = 0;

        /* renamed from: l, reason: collision with root package name */
        int f3663l = 0;

        /* renamed from: m, reason: collision with root package name */
        int f3664m = 0;

        /* renamed from: n, reason: collision with root package name */
        int f3665n = 0;

        /* renamed from: o, reason: collision with root package name */
        int f3666o = 0;

        /* renamed from: p, reason: collision with root package name */
        int f3667p = -1;

        g() {
        }
    }

    private enum h {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public v(Context context, AttributeSet attributeSet, t tVar) {
        super(context, attributeSet);
        this.f3639x = new AtomicLong(0L);
        this.f3641z = false;
        this.A = false;
        this.B = new a();
        Activity e3 = e2.h.e(getContext());
        if (e3 == null) {
            throw new IllegalArgumentException("Bad context");
        }
        this.f3640y = tVar == null ? new t(e3.getApplicationContext()) : tVar;
        i1.a n3 = this.f3640y.n();
        this.f3619c = n3;
        FlutterRenderer flutterRenderer = new FlutterRenderer(this.f3640y.o());
        this.f3620d = flutterRenderer;
        this.f3641z = this.f3640y.o().getIsSoftwareRenderingEnabled();
        g gVar = new g();
        this.f3636u = gVar;
        gVar.f3652a = context.getResources().getDisplayMetrics().density;
        gVar.f3667p = ViewConfiguration.get(context).getScaledTouchSlop();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.f3640y.k(this, e3);
        b bVar = new b();
        this.f3635t = bVar;
        getHolder().addCallback(bVar);
        this.f3637v = new ArrayList();
        this.f3638w = new ArrayList();
        this.f3621f = new t1.j(n3);
        this.f3622g = new t1.b(n3);
        this.f3623h = new t1.g(n3);
        t1.h hVar = new t1.h(n3);
        this.f3624i = hVar;
        t1.k kVar = new t1.k(n3);
        this.f3625j = kVar;
        this.f3627l = new t1.r(n3);
        this.f3626k = new t1.p(n3);
        o(new c(new io.flutter.plugin.platform.g(e3, kVar)));
        this.f3628m = (InputMethodManager) getContext().getSystemService("input_method");
        y f3 = this.f3640y.p().f();
        io.flutter.plugin.editing.m mVar = new io.flutter.plugin.editing.m(this, new t1.s(n3), f3);
        this.f3629n = mVar;
        this.f3632q = new d0(this);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3631p = new w1.b(this, new t1.i(n3));
        } else {
            this.f3631p = null;
        }
        v1.b bVar2 = new v1.b(context, hVar);
        this.f3630o = bVar2;
        this.f3633r = new io.flutter.embedding.android.c(flutterRenderer, false);
        f3.E(flutterRenderer);
        this.f3640y.p().f().D(mVar);
        this.f3640y.o().setLocalizationPlugin(bVar2);
        bVar2.d(getResources().getConfiguration());
        L();
    }

    private void D() {
    }

    private void E() {
        I();
    }

    private void G() {
        io.flutter.view.h hVar = this.f3634s;
        if (hVar != null) {
            hVar.S();
            this.f3634s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z3, boolean z4) {
        boolean z5 = false;
        if (!this.f3641z && !z3 && !z4) {
            z5 = true;
        }
        setWillNotDraw(z5);
    }

    private void L() {
        this.f3626k.d().f(getResources().getConfiguration().fontScale).g(DateFormat.is24HourFormat(getContext())).e((getResources().getConfiguration().uiMode & 48) == 32 ? p.c.dark : p.c.light).a();
    }

    private void M() {
        if (v()) {
            FlutterJNI o3 = this.f3640y.o();
            g gVar = this.f3636u;
            o3.setViewportMetrics(gVar.f3652a, gVar.f3653b, gVar.f3654c, gVar.f3655d, gVar.f3656e, gVar.f3657f, gVar.f3658g, gVar.f3659h, gVar.f3660i, gVar.f3661j, gVar.f3662k, gVar.f3663l, gVar.f3664m, gVar.f3665n, gVar.f3666o, gVar.f3667p, new int[0], new int[0], new int[0]);
        }
    }

    private h r() {
        Context context = getContext();
        int i3 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i3 == 2) {
            if (rotation == 1) {
                return h.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? h.LEFT : h.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return h.BOTH;
            }
        }
        return h.NONE;
    }

    private int u(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private boolean v() {
        t tVar = this.f3640y;
        return tVar != null && tVar.r();
    }

    public void A() {
        this.f3623h.c();
    }

    public void B() {
        this.f3623h.d();
    }

    public void C() {
        this.f3621f.a();
    }

    public TextureRegistry.SurfaceTextureEntry F(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        f fVar = new f(this.f3639x.getAndIncrement(), surfaceTexture);
        this.f3640y.o().registerTexture(fVar.id(), fVar.c());
        return fVar;
    }

    public void H(d dVar) {
        this.f3638w.remove(dVar);
    }

    void I() {
        io.flutter.view.h hVar = this.f3634s;
        if (hVar != null) {
            hVar.T();
        }
    }

    public void K(u uVar) {
        q();
        E();
        this.f3640y.s(uVar);
        D();
    }

    @Override // u1.d
    public d.c a(d.C0107d c0107d) {
        return null;
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f3629n.j(sparseArray);
    }

    @Override // u1.d
    public /* synthetic */ d.c b() {
        return u1.c.a(this);
    }

    @Override // w1.b.c
    public PointerIcon c(int i3) {
        return PointerIcon.getSystemIcon(getContext(), i3);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return this.f3640y.p().f().G(view);
    }

    @Override // u1.d
    public void d(String str, d.a aVar) {
        this.f3640y.d(str, aVar);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        g1.b.b("FlutterView", "dispatchKeyEvent: " + keyEvent.toString());
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (v() && this.f3632q.a(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // u1.d
    public void e(String str, d.a aVar, d.c cVar) {
        this.f3640y.e(str, aVar, cVar);
    }

    @Override // u1.d
    public void f(String str, ByteBuffer byteBuffer) {
        i(str, byteBuffer, null);
    }

    @Override // io.flutter.embedding.android.d0.e
    public void g(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.h hVar = this.f3634s;
        if (hVar == null || !hVar.C()) {
            return null;
        }
        return this.f3634s;
    }

    @Override // io.flutter.embedding.android.d0.e
    public u1.d getBinaryMessenger() {
        return this;
    }

    public Bitmap getBitmap() {
        q();
        return this.f3640y.o().getBitmap();
    }

    public i1.a getDartExecutor() {
        return this.f3619c;
    }

    float getDevicePixelRatio() {
        return this.f3636u.f3652a;
    }

    public t getFlutterNativeView() {
        return this.f3640y;
    }

    public h1.b getPluginRegistry() {
        return this.f3640y.p();
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry h() {
        throw new UnsupportedOperationException("Image textures are not supported in this mode.");
    }

    @Override // u1.d
    public void i(String str, ByteBuffer byteBuffer, d.b bVar) {
        if (v()) {
            this.f3640y.i(str, byteBuffer, bVar);
            return;
        }
        g1.b.a("FlutterView", "FlutterView.send called on a detached view, channel=" + str);
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer j() {
        throw new UnsupportedOperationException("SurfaceProducer textures are not supported in this mode.");
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry k() {
        return F(new SurfaceTexture(0));
    }

    @Override // io.flutter.embedding.android.d0.e
    public boolean l(KeyEvent keyEvent) {
        return this.f3629n.q(keyEvent);
    }

    public void o(u1.a aVar) {
        this.f3637v.add(aVar);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets;
        Insets insets2;
        Insets insets3;
        DisplayCutout displayCutout;
        Insets waterfallInsets;
        Insets systemGestureInsets;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 29) {
            systemGestureInsets = windowInsets.getSystemGestureInsets();
            g gVar = this.f3636u;
            gVar.f3663l = systemGestureInsets.top;
            gVar.f3664m = systemGestureInsets.right;
            gVar.f3665n = systemGestureInsets.bottom;
            gVar.f3666o = systemGestureInsets.left;
        }
        boolean z3 = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z4 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i3 >= 30) {
            int navigationBars = z4 ? 0 | WindowInsets$Type.navigationBars() : 0;
            if (z3) {
                navigationBars |= WindowInsets$Type.statusBars();
            }
            insets = windowInsets.getInsets(navigationBars);
            g gVar2 = this.f3636u;
            gVar2.f3655d = insets.top;
            gVar2.f3656e = insets.right;
            gVar2.f3657f = insets.bottom;
            gVar2.f3658g = insets.left;
            insets2 = windowInsets.getInsets(WindowInsets$Type.ime());
            g gVar3 = this.f3636u;
            gVar3.f3659h = insets2.top;
            gVar3.f3660i = insets2.right;
            gVar3.f3661j = insets2.bottom;
            gVar3.f3662k = insets2.left;
            insets3 = windowInsets.getInsets(WindowInsets$Type.systemGestures());
            g gVar4 = this.f3636u;
            gVar4.f3663l = insets3.top;
            gVar4.f3664m = insets3.right;
            gVar4.f3665n = insets3.bottom;
            gVar4.f3666o = insets3.left;
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                waterfallInsets = displayCutout.getWaterfallInsets();
                g gVar5 = this.f3636u;
                gVar5.f3655d = Math.max(Math.max(gVar5.f3655d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                g gVar6 = this.f3636u;
                gVar6.f3656e = Math.max(Math.max(gVar6.f3656e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                g gVar7 = this.f3636u;
                gVar7.f3657f = Math.max(Math.max(gVar7.f3657f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                g gVar8 = this.f3636u;
                gVar8.f3658g = Math.max(Math.max(gVar8.f3658g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            h hVar = h.NONE;
            if (!z4) {
                hVar = r();
            }
            this.f3636u.f3655d = z3 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f3636u.f3656e = (hVar == h.RIGHT || hVar == h.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f3636u.f3657f = (z4 && u(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f3636u.f3658g = (hVar == h.LEFT || hVar == h.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            g gVar9 = this.f3636u;
            gVar9.f3659h = 0;
            gVar9.f3660i = 0;
            gVar9.f3661j = u(windowInsets);
            this.f3636u.f3662k = 0;
        }
        M();
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        io.flutter.view.h hVar = new io.flutter.view.h(this, new t1.a(this.f3619c, getFlutterNativeView().o()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().f());
        this.f3634s = hVar;
        hVar.b0(this.B);
        J(this.f3634s.C(), this.f3634s.E());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3630o.d(configuration);
        L();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f3629n.n(this, this.f3632q, editorInfo);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        G();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (v() && this.f3633r.j(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !v() ? super.onHoverEvent(motionEvent) : this.f3634s.L(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i3) {
        super.onProvideAutofillVirtualStructure(viewStructure, i3);
        this.f3629n.y(viewStructure, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        g gVar = this.f3636u;
        gVar.f3653b = i3;
        gVar.f3654c = i4;
        M();
        super.onSizeChanged(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!v()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.f3633r.k(motionEvent);
    }

    public void p(d dVar) {
        this.f3638w.add(dVar);
    }

    void q() {
        if (!v()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public void s() {
        if (v()) {
            getHolder().removeCallback(this.f3635t);
            G();
            this.f3640y.l();
            this.f3640y = null;
        }
    }

    public void setInitialRoute(String str) {
        this.f3621f.c(str);
    }

    public t t() {
        if (!v()) {
            return null;
        }
        getHolder().removeCallback(this.f3635t);
        this.f3640y.m();
        t tVar = this.f3640y;
        this.f3640y = null;
        return tVar;
    }

    public void w() {
        this.A = true;
        Iterator it = new ArrayList(this.f3638w).iterator();
        while (it.hasNext()) {
            ((d) it.next()).a();
        }
    }

    public void x() {
        this.f3640y.o().notifyLowMemoryWarning();
        this.f3627l.a();
    }

    public void y() {
        this.f3623h.c();
    }

    public void z() {
        Iterator<u1.a> it = this.f3637v.iterator();
        while (it.hasNext()) {
            it.next().onPostResume();
        }
        this.f3623h.e();
    }
}
