package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
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
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.embedding.android.d0;
import io.flutter.embedding.android.n;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import w1.b;

/* loaded from: /root/release/classes.dex */
public class v extends FrameLayout implements b.c, d0.e {

    /* renamed from: c, reason: collision with root package name */
    private o f2852c;

    /* renamed from: d, reason: collision with root package name */
    private p f2853d;

    /* renamed from: f, reason: collision with root package name */
    private n f2854f;

    /* renamed from: g, reason: collision with root package name */
    io.flutter.embedding.engine.renderer.e f2855g;

    /* renamed from: h, reason: collision with root package name */
    private io.flutter.embedding.engine.renderer.e f2856h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<io.flutter.embedding.engine.renderer.d> f2857i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2858j;

    /* renamed from: k, reason: collision with root package name */
    private io.flutter.embedding.engine.a f2859k;

    /* renamed from: l, reason: collision with root package name */
    private final Set<f> f2860l;

    /* renamed from: m, reason: collision with root package name */
    private w1.b f2861m;

    /* renamed from: n, reason: collision with root package name */
    private io.flutter.plugin.editing.m f2862n;

    /* renamed from: o, reason: collision with root package name */
    private io.flutter.plugin.editing.f f2863o;

    /* renamed from: p, reason: collision with root package name */
    private v1.b f2864p;

    /* renamed from: q, reason: collision with root package name */
    private d0 f2865q;

    /* renamed from: r, reason: collision with root package name */
    private io.flutter.embedding.android.c f2866r;

    /* renamed from: s, reason: collision with root package name */
    private io.flutter.view.h f2867s;

    /* renamed from: t, reason: collision with root package name */
    private TextServicesManager f2868t;

    /* renamed from: u, reason: collision with root package name */
    private i0 f2869u;

    /* renamed from: v, reason: collision with root package name */
    private final FlutterRenderer.g f2870v;

    /* renamed from: w, reason: collision with root package name */
    private final h.k f2871w;

    /* renamed from: x, reason: collision with root package name */
    private final ContentObserver f2872x;

    /* renamed from: y, reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f2873y;

    /* renamed from: z, reason: collision with root package name */
    private final androidx.core.util.a<WindowLayoutInfo> f2874z;

    class a implements h.k {
        a() {
        }

        @Override // io.flutter.view.h.k
        public void a(boolean z3, boolean z4) {
            v.this.z(z3, z4);
        }
    }

    class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            super.onChange(z3);
            if (v.this.f2859k == null) {
                return;
            }
            g1.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
            v.this.B();
        }
    }

    class c implements io.flutter.embedding.engine.renderer.d {
        c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void b() {
            v.this.f2858j = false;
            Iterator it = v.this.f2857i.iterator();
            while (it.hasNext()) {
                ((io.flutter.embedding.engine.renderer.d) it.next()).b();
            }
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            v.this.f2858j = true;
            Iterator it = v.this.f2857i.iterator();
            while (it.hasNext()) {
                ((io.flutter.embedding.engine.renderer.d) it.next()).e();
            }
        }
    }

    class d implements androidx.core.util.a<WindowLayoutInfo> {
        d() {
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            v.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
        }
    }

    class e implements io.flutter.embedding.engine.renderer.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlutterRenderer f2879a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f2880b;

        e(FlutterRenderer flutterRenderer, Runnable runnable) {
            this.f2879a = flutterRenderer;
            this.f2880b = runnable;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void b() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            this.f2879a.t(this);
            this.f2880b.run();
            v vVar = v.this;
            if ((vVar.f2855g instanceof n) || vVar.f2854f == null) {
                return;
            }
            v.this.f2854f.d();
            v.this.x();
        }
    }

    public interface f {
        void a();

        void b(io.flutter.embedding.engine.a aVar);
    }

    private enum g {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    private v(Context context, AttributeSet attributeSet, o oVar) {
        super(context, attributeSet);
        this.f2857i = new HashSet();
        this.f2860l = new HashSet();
        this.f2870v = new FlutterRenderer.g();
        this.f2871w = new a();
        this.f2872x = new b(new Handler(Looper.getMainLooper()));
        this.f2873y = new c();
        this.f2874z = new d();
        this.f2852c = oVar;
        this.f2855g = oVar;
        u();
    }

    private v(Context context, AttributeSet attributeSet, p pVar) {
        super(context, attributeSet);
        this.f2857i = new HashSet();
        this.f2860l = new HashSet();
        this.f2870v = new FlutterRenderer.g();
        this.f2871w = new a();
        this.f2872x = new b(new Handler(Looper.getMainLooper()));
        this.f2873y = new c();
        this.f2874z = new d();
        this.f2853d = pVar;
        this.f2855g = pVar;
        u();
    }

    public v(Context context, o oVar) {
        this(context, (AttributeSet) null, oVar);
    }

    public v(Context context, p pVar) {
        this(context, (AttributeSet) null, pVar);
    }

    private void C() {
        if (!v()) {
            g1.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f2870v.f3021a = getResources().getDisplayMetrics().density;
        this.f2870v.f3036p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f2859k.t().x(this.f2870v);
    }

    private g o() {
        Context context = getContext();
        int i3 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i3 == 2) {
            if (rotation == 1) {
                return g.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? g.LEFT : g.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return g.BOTH;
            }
        }
        return g.NONE;
    }

    private int t(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void u() {
        View view;
        g1.b.f("FlutterView", "Initializing FlutterView");
        if (this.f2852c != null) {
            g1.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f2852c;
        } else if (this.f2853d != null) {
            g1.b.f("FlutterView", "Internally using a FlutterTextureView.");
            view = this.f2853d;
        } else {
            g1.b.f("FlutterView", "Internally using a FlutterImageView.");
            view = this.f2854f;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean w(SpellCheckerInfo spellCheckerInfo) {
        return spellCheckerInfo.getPackageName().equals("com.google.android.inputmethod.latin");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        n nVar = this.f2854f;
        if (nVar != null) {
            nVar.g();
            removeView(this.f2854f);
            this.f2854f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z3, boolean z4) {
        boolean z5 = false;
        if (!this.f2859k.t().n() && !z3 && !z4) {
            z5 = true;
        }
        setWillNotDraw(z5);
    }

    public void A(Runnable runnable) {
        if (this.f2854f == null) {
            g1.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        io.flutter.embedding.engine.renderer.e eVar = this.f2856h;
        if (eVar == null) {
            g1.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f2855g = eVar;
        this.f2856h = null;
        FlutterRenderer t3 = this.f2859k.t();
        if (this.f2859k != null && t3 != null) {
            this.f2855g.a();
            t3.f(new e(t3, runnable));
        } else {
            this.f2854f.d();
            x();
            runnable.run();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void B() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 0
            r2 = 1
            r3 = 32
            if (r0 != r3) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1a
            t1.p$c r0 = t1.p.c.dark
            goto L1c
        L1a:
            t1.p$c r0 = t1.p.c.light
        L1c:
            android.view.textservice.TextServicesManager r3 = r6.f2868t
            if (r3 == 0) goto L43
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L41
            java.util.List r3 = io.flutter.embedding.android.r.a(r3)
            java.util.stream.Stream r3 = io.flutter.embedding.android.s.a(r3)
            io.flutter.embedding.android.u r4 = new io.flutter.embedding.android.u
            r4.<init>()
            boolean r3 = r3.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.f2868t
            boolean r4 = io.flutter.embedding.android.t.a(r4)
            if (r4 == 0) goto L43
            if (r3 == 0) goto L43
        L41:
            r3 = 1
            goto L44
        L43:
            r3 = 0
        L44:
            io.flutter.embedding.engine.a r4 = r6.f2859k
            t1.p r4 = r4.v()
            t1.p$b r4 = r4.d()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            t1.p$b r4 = r4.f(r5)
            android.content.res.Resources r5 = r6.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            t1.p$b r4 = r4.c(r5)
            t1.p$b r3 = r4.d(r3)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r2)
            if (r4 != r2) goto L7d
            r1 = 1
        L7d:
            t1.p$b r1 = r3.b(r1)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            t1.p$b r1 = r1.g(r2)
            t1.p$b r0 = r1.e(r0)
            r0.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.v.B():void");
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f2862n.j(sparseArray);
    }

    @Override // w1.b.c
    public PointerIcon c(int i3) {
        return PointerIcon.getSystemIcon(getContext(), i3);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        io.flutter.embedding.engine.a aVar = this.f2859k;
        return aVar != null ? aVar.q().G(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (v() && this.f2865q.a(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // io.flutter.embedding.android.d0.e
    public void g(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.h hVar = this.f2867s;
        if (hVar == null || !hVar.C()) {
            return null;
        }
        return this.f2867s;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.f2859k;
    }

    @Override // io.flutter.embedding.android.d0.e
    public u1.d getBinaryMessenger() {
        return this.f2859k.k();
    }

    public n getCurrentImageSurface() {
        return this.f2854f;
    }

    public boolean j() {
        n nVar = this.f2854f;
        if (nVar != null) {
            return nVar.e();
        }
        return false;
    }

    public void k(io.flutter.embedding.engine.renderer.d dVar) {
        this.f2857i.add(dVar);
    }

    @Override // io.flutter.embedding.android.d0.e
    public boolean l(KeyEvent keyEvent) {
        return this.f2862n.q(keyEvent);
    }

    public void m(n nVar) {
        io.flutter.embedding.engine.a aVar = this.f2859k;
        if (aVar != null) {
            nVar.b(aVar.t());
        }
    }

    public void n(io.flutter.embedding.engine.a aVar) {
        g1.b.f("FlutterView", "Attaching to a FlutterEngine: " + aVar);
        if (v()) {
            if (aVar == this.f2859k) {
                g1.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                g1.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                s();
            }
        }
        this.f2859k = aVar;
        FlutterRenderer t3 = aVar.t();
        this.f2858j = t3.m();
        this.f2855g.b(t3);
        t3.f(this.f2873y);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2861m = new w1.b(this, this.f2859k.n());
        }
        this.f2862n = new io.flutter.plugin.editing.m(this, this.f2859k.y(), this.f2859k.q());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.f2868t = textServicesManager;
            this.f2863o = new io.flutter.plugin.editing.f(textServicesManager, this.f2859k.w());
        } catch (Exception unused) {
            g1.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.f2864p = this.f2859k.m();
        this.f2865q = new d0(this);
        this.f2866r = new io.flutter.embedding.android.c(this.f2859k.t(), false);
        io.flutter.view.h hVar = new io.flutter.view.h(this, aVar.h(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f2859k.q());
        this.f2867s = hVar;
        hVar.b0(this.f2871w);
        z(this.f2867s.C(), this.f2867s.E());
        this.f2859k.q().a(this.f2867s);
        this.f2859k.q().E(this.f2859k.t());
        this.f2862n.p().restartInput(this);
        B();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.f2872x);
        C();
        aVar.q().F(this);
        Iterator<f> it = this.f2860l.iterator();
        while (it.hasNext()) {
            it.next().b(aVar);
        }
        if (this.f2858j) {
            this.f2873y.e();
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets;
        Insets insets2;
        Insets insets3;
        DisplayCutout displayCutout;
        Insets waterfallInsets;
        Insets systemGestureInsets;
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 29) {
            systemGestureInsets = windowInsets.getSystemGestureInsets();
            FlutterRenderer.g gVar = this.f2870v;
            gVar.f3032l = systemGestureInsets.top;
            gVar.f3033m = systemGestureInsets.right;
            gVar.f3034n = systemGestureInsets.bottom;
            gVar.f3035o = systemGestureInsets.left;
        }
        boolean z3 = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z4 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i3 >= 30) {
            int navigationBars = z4 ? 0 | WindowInsets$Type.navigationBars() : 0;
            if (z3) {
                navigationBars |= WindowInsets$Type.statusBars();
            }
            insets = windowInsets.getInsets(navigationBars);
            FlutterRenderer.g gVar2 = this.f2870v;
            gVar2.f3024d = insets.top;
            gVar2.f3025e = insets.right;
            gVar2.f3026f = insets.bottom;
            gVar2.f3027g = insets.left;
            insets2 = windowInsets.getInsets(WindowInsets$Type.ime());
            FlutterRenderer.g gVar3 = this.f2870v;
            gVar3.f3028h = insets2.top;
            gVar3.f3029i = insets2.right;
            gVar3.f3030j = insets2.bottom;
            gVar3.f3031k = insets2.left;
            insets3 = windowInsets.getInsets(WindowInsets$Type.systemGestures());
            FlutterRenderer.g gVar4 = this.f2870v;
            gVar4.f3032l = insets3.top;
            gVar4.f3033m = insets3.right;
            gVar4.f3034n = insets3.bottom;
            gVar4.f3035o = insets3.left;
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.g gVar5 = this.f2870v;
                gVar5.f3024d = Math.max(Math.max(gVar5.f3024d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.g gVar6 = this.f2870v;
                gVar6.f3025e = Math.max(Math.max(gVar6.f3025e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.g gVar7 = this.f2870v;
                gVar7.f3026f = Math.max(Math.max(gVar7.f3026f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.g gVar8 = this.f2870v;
                gVar8.f3027g = Math.max(Math.max(gVar8.f3027g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            g gVar9 = g.NONE;
            if (!z4) {
                gVar9 = o();
            }
            this.f2870v.f3024d = z3 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f2870v.f3025e = (gVar9 == g.RIGHT || gVar9 == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f2870v.f3026f = (z4 && t(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f2870v.f3027g = (gVar9 == g.LEFT || gVar9 == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.g gVar10 = this.f2870v;
            gVar10.f3028h = 0;
            gVar10.f3029i = 0;
            gVar10.f3030j = t(windowInsets);
            this.f2870v.f3031k = 0;
        }
        g1.b.f("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f2870v.f3024d + ", Left: " + this.f2870v.f3027g + ", Right: " + this.f2870v.f3025e + "\nKeyboard insets: Bottom: " + this.f2870v.f3030j + ", Left: " + this.f2870v.f3031k + ", Right: " + this.f2870v.f3029i + "System Gesture Insets - Left: " + this.f2870v.f3035o + ", Top: " + this.f2870v.f3032l + ", Right: " + this.f2870v.f3033m + ", Bottom: " + this.f2870v.f3030j);
        C();
        return onApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2869u = r();
        Activity e3 = e2.h.e(getContext());
        i0 i0Var = this.f2869u;
        if (i0Var == null || e3 == null) {
            return;
        }
        i0Var.a(e3, androidx.core.content.a.getMainExecutor(getContext()), this.f2874z);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f2859k != null) {
            g1.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.f2864p.d(configuration);
            B();
            e2.h.c(getContext(), this.f2859k);
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !v() ? super.onCreateInputConnection(editorInfo) : this.f2862n.n(this, this.f2865q, editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        i0 i0Var = this.f2869u;
        if (i0Var != null) {
            i0Var.b(this.f2874z);
        }
        this.f2869u = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (v() && this.f2866r.j(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !v() ? super.onHoverEvent(motionEvent) : this.f2867s.L(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i3) {
        super.onProvideAutofillVirtualStructure(viewStructure, i3);
        this.f2862n.y(viewStructure, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        g1.b.f("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i5 + " x " + i6 + ", it is now " + i3 + " x " + i4);
        FlutterRenderer.g gVar = this.f2870v;
        gVar.f3022b = i3;
        gVar.f3023c = i4;
        C();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!v()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.f2866r.k(motionEvent);
    }

    public void p() {
        this.f2855g.c();
        n nVar = this.f2854f;
        if (nVar == null) {
            n q3 = q();
            this.f2854f = q3;
            addView(q3);
        } else {
            nVar.k(getWidth(), getHeight());
        }
        this.f2856h = this.f2855g;
        n nVar2 = this.f2854f;
        this.f2855g = nVar2;
        io.flutter.embedding.engine.a aVar = this.f2859k;
        if (aVar != null) {
            nVar2.b(aVar.t());
        }
    }

    public n q() {
        return new n(getContext(), getWidth(), getHeight(), n.b.background);
    }

    protected i0 r() {
        try {
            return new i0(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public void s() {
        g1.b.f("FlutterView", "Detaching from a FlutterEngine: " + this.f2859k);
        if (!v()) {
            g1.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        Iterator<f> it = this.f2860l.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        getContext().getContentResolver().unregisterContentObserver(this.f2872x);
        this.f2859k.q().P();
        this.f2859k.q().d();
        this.f2867s.S();
        this.f2867s = null;
        this.f2862n.p().restartInput(this);
        this.f2862n.o();
        this.f2865q.d();
        io.flutter.plugin.editing.f fVar = this.f2863o;
        if (fVar != null) {
            fVar.b();
        }
        w1.b bVar = this.f2861m;
        if (bVar != null) {
            bVar.c();
        }
        FlutterRenderer t3 = this.f2859k.t();
        this.f2858j = false;
        t3.t(this.f2873y);
        t3.z();
        t3.w(false);
        io.flutter.embedding.engine.renderer.e eVar = this.f2856h;
        if (eVar != null && this.f2855g == this.f2854f) {
            this.f2855g = eVar;
        }
        this.f2855g.d();
        x();
        this.f2856h = null;
        this.f2859k = null;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        io.flutter.embedding.engine.renderer.e eVar = this.f2855g;
        if (eVar instanceof o) {
            ((o) eVar).setVisibility(i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        r7 = r7.getDisplayCutout();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void setWindowInfoListenerDisplayFeatures(androidx.window.layout.WindowLayoutInfo r7) {
        /*
            r6 = this;
            java.util.List r7 = r7.getDisplayFeatures()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        Ld:
            boolean r1 = r7.hasNext()
            java.lang.String r2 = "FlutterView"
            if (r1 == 0) goto L92
            java.lang.Object r1 = r7.next()
            androidx.window.layout.DisplayFeature r1 = (androidx.window.layout.DisplayFeature) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "WindowInfoTracker Display Feature reported with bounds = "
            r3.append(r4)
            android.graphics.Rect r4 = r1.getBounds()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r4 = " and type = "
            r3.append(r4)
            java.lang.Class r4 = r1.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            g1.b.f(r2, r3)
            boolean r2 = r1 instanceof androidx.window.layout.FoldingFeature
            if (r2 == 0) goto L80
            r2 = r1
            androidx.window.layout.FoldingFeature r2 = (androidx.window.layout.FoldingFeature) r2
            androidx.window.layout.FoldingFeature$OcclusionType r3 = r2.getOcclusionType()
            androidx.window.layout.FoldingFeature$OcclusionType r4 = androidx.window.layout.FoldingFeature.OcclusionType.FULL
            if (r3 != r4) goto L59
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r3 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.HINGE
            goto L5b
        L59:
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r3 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.FOLD
        L5b:
            androidx.window.layout.FoldingFeature$State r4 = r2.getState()
            androidx.window.layout.FoldingFeature$State r5 = androidx.window.layout.FoldingFeature.State.FLAT
            if (r4 != r5) goto L66
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r2 = io.flutter.embedding.engine.renderer.FlutterRenderer.c.POSTURE_FLAT
            goto L73
        L66:
            androidx.window.layout.FoldingFeature$State r2 = r2.getState()
            androidx.window.layout.FoldingFeature$State r4 = androidx.window.layout.FoldingFeature.State.HALF_OPENED
            if (r2 != r4) goto L71
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r2 = io.flutter.embedding.engine.renderer.FlutterRenderer.c.POSTURE_HALF_OPENED
            goto L73
        L71:
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r2 = io.flutter.embedding.engine.renderer.FlutterRenderer.c.UNKNOWN
        L73:
            io.flutter.embedding.engine.renderer.FlutterRenderer$b r4 = new io.flutter.embedding.engine.renderer.FlutterRenderer$b
            android.graphics.Rect r1 = r1.getBounds()
            r4.<init>(r1, r3, r2)
            r0.add(r4)
            goto Ld
        L80:
            io.flutter.embedding.engine.renderer.FlutterRenderer$b r2 = new io.flutter.embedding.engine.renderer.FlutterRenderer$b
            android.graphics.Rect r1 = r1.getBounds()
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r3 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.UNKNOWN
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r4 = io.flutter.embedding.engine.renderer.FlutterRenderer.c.UNKNOWN
            r2.<init>(r1, r3, r4)
            r0.add(r2)
            goto Ld
        L92:
            int r7 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r7 < r1) goto Ldb
            android.view.WindowInsets r7 = r6.getRootWindowInsets()
            if (r7 == 0) goto Ldb
            android.view.DisplayCutout r7 = androidx.core.view.f0.a(r7)
            if (r7 == 0) goto Ldb
            java.util.List r7 = r7.getBoundingRects()
            java.util.Iterator r7 = r7.iterator()
        Lac:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Ldb
            java.lang.Object r1 = r7.next()
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "DisplayCutout area reported with bounds = "
            r3.append(r4)
            java.lang.String r4 = r1.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            g1.b.f(r2, r3)
            io.flutter.embedding.engine.renderer.FlutterRenderer$b r3 = new io.flutter.embedding.engine.renderer.FlutterRenderer$b
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r4 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.CUTOUT
            r3.<init>(r1, r4)
            r0.add(r3)
            goto Lac
        Ldb:
            io.flutter.embedding.engine.renderer.FlutterRenderer$g r7 = r6.f2870v
            r7.f3037q = r0
            r6.C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.v.setWindowInfoListenerDisplayFeatures(androidx.window.layout.WindowLayoutInfo):void");
    }

    public boolean v() {
        io.flutter.embedding.engine.a aVar = this.f2859k;
        return aVar != null && aVar.t() == this.f2855g.getAttachedRenderer();
    }

    public void y(io.flutter.embedding.engine.renderer.d dVar) {
        this.f2857i.remove(dVar);
    }
}
