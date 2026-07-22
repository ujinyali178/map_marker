package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.f0;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.y;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import t1.m;

/* loaded from: /root/release/classes.dex */
public class y implements s {

    /* renamed from: w, reason: collision with root package name */
    private static Class[] f3199w = {SurfaceView.class};

    /* renamed from: x, reason: collision with root package name */
    private static boolean f3200x = true;

    /* renamed from: y, reason: collision with root package name */
    private static boolean f3201y = true;

    /* renamed from: b, reason: collision with root package name */
    private io.flutter.embedding.android.c f3203b;

    /* renamed from: c, reason: collision with root package name */
    private Context f3204c;

    /* renamed from: d, reason: collision with root package name */
    private io.flutter.embedding.android.v f3205d;

    /* renamed from: e, reason: collision with root package name */
    private TextureRegistry f3206e;

    /* renamed from: f, reason: collision with root package name */
    private io.flutter.plugin.editing.m f3207f;

    /* renamed from: g, reason: collision with root package name */
    private t1.m f3208g;

    /* renamed from: o, reason: collision with root package name */
    private int f3216o = 0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3217p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3218q = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3222u = false;

    /* renamed from: v, reason: collision with root package name */
    private final m.g f3223v = new a();

    /* renamed from: a, reason: collision with root package name */
    private final n f3202a = new n();

    /* renamed from: i, reason: collision with root package name */
    final HashMap<Integer, i0> f3210i = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final io.flutter.plugin.platform.a f3209h = new io.flutter.plugin.platform.a();

    /* renamed from: j, reason: collision with root package name */
    final HashMap<Context, View> f3211j = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<c> f3214m = new SparseArray<>();

    /* renamed from: r, reason: collision with root package name */
    private final HashSet<Integer> f3219r = new HashSet<>();

    /* renamed from: s, reason: collision with root package name */
    private final HashSet<Integer> f3220s = new HashSet<>();

    /* renamed from: n, reason: collision with root package name */
    private final SparseArray<r> f3215n = new SparseArray<>();

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray<k> f3212k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private final SparseArray<l1.a> f3213l = new SparseArray<>();

    /* renamed from: t, reason: collision with root package name */
    private final io.flutter.embedding.android.f0 f3221t = io.flutter.embedding.android.f0.a();

    class a implements m.g {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(i0 i0Var, float f3, m.b bVar) {
            y.this.z0(i0Var);
            if (y.this.f3204c != null) {
                f3 = y.this.V();
            }
            bVar.a(new m.c(y.this.w0(i0Var.f(), f3), y.this.w0(i0Var.e(), f3)));
        }

        @Override // t1.m.g
        public void a(m.f fVar) {
            int i3 = fVar.f4232a;
            float f3 = y.this.f3204c.getResources().getDisplayMetrics().density;
            if (y.this.c(i3)) {
                y.this.f3210i.get(Integer.valueOf(i3)).c(y.this.x0(f3, fVar, true));
                return;
            }
            k kVar = (k) y.this.f3212k.get(i3);
            if (kVar == null) {
                g1.b.b("PlatformViewsController", "Sending touch to an unknown view with id: " + i3);
                return;
            }
            View view = kVar.getView();
            if (view != null) {
                view.dispatchTouchEvent(y.this.x0(f3, fVar, false));
                return;
            }
            g1.b.b("PlatformViewsController", "Sending touch to a null view with id: " + i3);
        }

        @Override // t1.m.g
        public void b(boolean z3) {
            y.this.f3218q = z3;
        }

        @Override // t1.m.g
        public void c(m.d dVar) {
            y.this.S(19);
            y.this.T(dVar);
            y.this.H(y.this.M(dVar, false), dVar);
        }

        @Override // t1.m.g
        public void d(int i3, int i4) {
            View view;
            StringBuilder sb;
            String str;
            if (!y.A0(i4)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i4 + "(view id: " + i3 + ")");
            }
            if (y.this.c(i3)) {
                view = y.this.f3210i.get(Integer.valueOf(i3)).g();
            } else {
                k kVar = (k) y.this.f3212k.get(i3);
                if (kVar == null) {
                    sb = new StringBuilder();
                    str = "Setting direction to an unknown view with id: ";
                    sb.append(str);
                    sb.append(i3);
                    g1.b.b("PlatformViewsController", sb.toString());
                }
                view = kVar.getView();
            }
            if (view != null) {
                view.setLayoutDirection(i4);
                return;
            }
            sb = new StringBuilder();
            str = "Setting direction to a null view with id: ";
            sb.append(str);
            sb.append(i3);
            g1.b.b("PlatformViewsController", sb.toString());
        }

        @Override // t1.m.g
        public void e(m.e eVar, final m.b bVar) {
            int y02 = y.this.y0(eVar.f4230b);
            int y03 = y.this.y0(eVar.f4231c);
            int i3 = eVar.f4229a;
            if (y.this.c(i3)) {
                final float V = y.this.V();
                final i0 i0Var = y.this.f3210i.get(Integer.valueOf(i3));
                y.this.d0(i0Var);
                i0Var.k(y02, y03, new Runnable() { // from class: io.flutter.plugin.platform.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.a.this.k(i0Var, V, bVar);
                    }
                });
                return;
            }
            k kVar = (k) y.this.f3212k.get(i3);
            r rVar = (r) y.this.f3215n.get(i3);
            if (kVar == null || rVar == null) {
                g1.b.b("PlatformViewsController", "Resizing unknown platform view with id: " + i3);
                return;
            }
            if (y02 > rVar.getRenderTargetWidth() || y03 > rVar.getRenderTargetHeight()) {
                rVar.b(y02, y03);
            }
            ViewGroup.LayoutParams layoutParams = rVar.getLayoutParams();
            layoutParams.width = y02;
            layoutParams.height = y03;
            rVar.setLayoutParams(layoutParams);
            View view = kVar.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = y02;
                layoutParams2.height = y03;
                view.setLayoutParams(layoutParams2);
            }
            bVar.a(new m.c(y.this.v0(rVar.getRenderTargetWidth()), y.this.v0(rVar.getRenderTargetHeight())));
        }

        @Override // t1.m.g
        public long f(m.d dVar) {
            y.this.T(dVar);
            int i3 = dVar.f4216a;
            if (y.this.f3215n.get(i3) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i3);
            }
            if (y.this.f3206e == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i3);
            }
            if (y.this.f3205d == null) {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i3);
            }
            k M = y.this.M(dVar, true);
            View view = M.getView();
            if (view.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            if (!(Build.VERSION.SDK_INT >= 23 && !e2.h.f(view, y.f3199w))) {
                if (dVar.f4223h == m.d.a.TEXTURE_WITH_HYBRID_FALLBACK) {
                    y.this.H(M, dVar);
                    return -2L;
                }
                if (!y.this.f3222u) {
                    return y.this.J(M, dVar);
                }
            }
            return y.this.I(M, dVar);
        }

        @Override // t1.m.g
        public void g(int i3, double d3, double d4) {
            if (y.this.c(i3)) {
                return;
            }
            r rVar = (r) y.this.f3215n.get(i3);
            if (rVar == null) {
                g1.b.b("PlatformViewsController", "Setting offset for unknown platform view with id: " + i3);
                return;
            }
            int y02 = y.this.y0(d3);
            int y03 = y.this.y0(d4);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rVar.getLayoutParams();
            layoutParams.topMargin = y02;
            layoutParams.leftMargin = y03;
            rVar.setLayoutParams(layoutParams);
        }

        @Override // t1.m.g
        public void h(int i3) {
            View view;
            StringBuilder sb;
            String str;
            if (y.this.c(i3)) {
                view = y.this.f3210i.get(Integer.valueOf(i3)).g();
            } else {
                k kVar = (k) y.this.f3212k.get(i3);
                if (kVar == null) {
                    sb = new StringBuilder();
                    str = "Clearing focus on an unknown view with id: ";
                    sb.append(str);
                    sb.append(i3);
                    g1.b.b("PlatformViewsController", sb.toString());
                }
                view = kVar.getView();
            }
            if (view != null) {
                view.clearFocus();
                return;
            }
            sb = new StringBuilder();
            str = "Clearing focus on a null view with id: ";
            sb.append(str);
            sb.append(i3);
            g1.b.b("PlatformViewsController", sb.toString());
        }

        @Override // t1.m.g
        public void i(int i3) {
            k kVar = (k) y.this.f3212k.get(i3);
            if (kVar == null) {
                g1.b.b("PlatformViewsController", "Disposing unknown platform view with id: " + i3);
                return;
            }
            if (kVar.getView() != null) {
                View view = kVar.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            y.this.f3212k.remove(i3);
            try {
                kVar.a();
            } catch (RuntimeException e3) {
                g1.b.c("PlatformViewsController", "Disposing platform view threw an exception", e3);
            }
            if (y.this.c(i3)) {
                i0 i0Var = y.this.f3210i.get(Integer.valueOf(i3));
                View g3 = i0Var.g();
                if (g3 != null) {
                    y.this.f3211j.remove(g3.getContext());
                }
                i0Var.d();
                y.this.f3210i.remove(Integer.valueOf(i3));
                return;
            }
            r rVar = (r) y.this.f3215n.get(i3);
            if (rVar != null) {
                rVar.removeAllViews();
                rVar.a();
                rVar.c();
                ViewGroup viewGroup2 = (ViewGroup) rVar.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(rVar);
                }
                y.this.f3215n.remove(i3);
                return;
            }
            l1.a aVar = (l1.a) y.this.f3213l.get(i3);
            if (aVar != null) {
                aVar.removeAllViews();
                aVar.b();
                ViewGroup viewGroup3 = (ViewGroup) aVar.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(aVar);
                }
                y.this.f3213l.remove(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean A0(int i3) {
        return i3 == 0 || i3 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(k kVar, m.d dVar) {
        S(19);
        g1.b.e("PlatformViewsController", "Using hybrid composition for platform view: " + dVar.f4216a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long J(k kVar, final m.d dVar) {
        S(20);
        g1.b.e("PlatformViewsController", "Hosting view in a virtual display for platform view: " + dVar.f4216a);
        p e02 = e0(this.f3206e);
        i0 b4 = i0.b(this.f3204c, this.f3209h, kVar, e02, y0(dVar.f4218c), y0(dVar.f4219d), dVar.f4216a, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.w
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                y.this.a0(dVar, view, z3);
            }
        });
        if (b4 != null) {
            this.f3210i.put(Integer.valueOf(dVar.f4216a), b4);
            View view = kVar.getView();
            this.f3211j.put(view.getContext(), view);
            return e02.getId();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + dVar.f4217b + " with id: " + dVar.f4216a);
    }

    private void R() {
        while (this.f3212k.size() > 0) {
            this.f3223v.i(this.f3212k.keyAt(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= i3) {
            return;
        }
        throw new IllegalStateException("Trying to use platform views with API " + i4 + ", required API level is: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(m.d dVar) {
        if (A0(dVar.f4222g)) {
            return;
        }
        throw new IllegalStateException("Trying to create a view with unknown direction value: " + dVar.f4222g + "(view id: " + dVar.f4216a + ")");
    }

    private void U(boolean z3) {
        for (int i3 = 0; i3 < this.f3214m.size(); i3++) {
            int keyAt = this.f3214m.keyAt(i3);
            c valueAt = this.f3214m.valueAt(i3);
            if (this.f3219r.contains(Integer.valueOf(keyAt))) {
                this.f3205d.m(valueAt);
                z3 &= valueAt.e();
            } else {
                if (!this.f3217p) {
                    valueAt.d();
                }
                valueAt.setVisibility(8);
                this.f3205d.removeView(valueAt);
            }
        }
        for (int i4 = 0; i4 < this.f3213l.size(); i4++) {
            int keyAt2 = this.f3213l.keyAt(i4);
            l1.a aVar = this.f3213l.get(keyAt2);
            if (!this.f3220s.contains(Integer.valueOf(keyAt2)) || (!z3 && this.f3218q)) {
                aVar.setVisibility(8);
            } else {
                aVar.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float V() {
        return this.f3204c.getResources().getDisplayMetrics().density;
    }

    private void Y() {
        if (!this.f3218q || this.f3217p) {
            return;
        }
        this.f3205d.p();
        this.f3217p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(m.d dVar, View view, boolean z3) {
        if (z3) {
            this.f3208g.d(dVar.f4216a);
            return;
        }
        io.flutter.plugin.editing.m mVar = this.f3207f;
        if (mVar != null) {
            mVar.k(dVar.f4216a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(m.d dVar, View view, boolean z3) {
        if (z3) {
            this.f3208g.d(dVar.f4216a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(int i3, View view, boolean z3) {
        if (z3) {
            this.f3208g.d(i3);
            return;
        }
        io.flutter.plugin.editing.m mVar = this.f3207f;
        if (mVar != null) {
            mVar.k(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0() {
        U(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(i0 i0Var) {
        io.flutter.plugin.editing.m mVar = this.f3207f;
        if (mVar == null) {
            return;
        }
        mVar.t();
        i0Var.h();
    }

    private static p e0(TextureRegistry textureRegistry) {
        if (f3201y && Build.VERSION.SDK_INT >= 29) {
            TextureRegistry.SurfaceProducer j3 = textureRegistry.j();
            g1.b.e("PlatformViewsController", "PlatformView is using SurfaceProducer backend");
            return new f0(j3);
        }
        if (!f3200x || Build.VERSION.SDK_INT < 29) {
            TextureRegistry.SurfaceTextureEntry k3 = textureRegistry.k();
            g1.b.e("PlatformViewsController", "PlatformView is using SurfaceTexture backend");
            return new h0(k3);
        }
        TextureRegistry.ImageTextureEntry h3 = textureRegistry.h();
        g1.b.e("PlatformViewsController", "PlatformView is using ImageReader backend");
        return new b(h3);
    }

    private void f0(k kVar) {
        io.flutter.embedding.android.v vVar = this.f3205d;
        if (vVar == null) {
            g1.b.e("PlatformViewsController", "null flutterView");
        } else {
            kVar.h(vVar);
        }
    }

    private static MotionEvent.PointerCoords p0(Object obj, float f3) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        double d3 = f3;
        pointerCoords.toolMajor = (float) (((Double) list.get(3)).doubleValue() * d3);
        pointerCoords.toolMinor = (float) (((Double) list.get(4)).doubleValue() * d3);
        pointerCoords.touchMajor = (float) (((Double) list.get(5)).doubleValue() * d3);
        pointerCoords.touchMinor = (float) (((Double) list.get(6)).doubleValue() * d3);
        pointerCoords.x = (float) (((Double) list.get(7)).doubleValue() * d3);
        pointerCoords.y = (float) (((Double) list.get(8)).doubleValue() * d3);
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> q0(Object obj, float f3) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(p0(it.next(), f3));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties r0(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> s0(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(r0(it.next()));
        }
        return arrayList;
    }

    private void t0() {
        if (this.f3205d == null) {
            g1.b.b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i3 = 0; i3 < this.f3214m.size(); i3++) {
            this.f3205d.removeView(this.f3214m.valueAt(i3));
        }
        this.f3214m.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v0(double d3) {
        return w0(d3, V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w0(double d3, float f3) {
        return (int) Math.round(d3 / f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y0(double d3) {
        return (int) Math.round(d3 * V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(i0 i0Var) {
        io.flutter.plugin.editing.m mVar = this.f3207f;
        if (mVar == null) {
            return;
        }
        mVar.F();
        i0Var.i();
    }

    public void C(Context context, TextureRegistry textureRegistry, i1.a aVar) {
        if (this.f3204c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.f3204c = context;
        this.f3206e = textureRegistry;
        t1.m mVar = new t1.m(aVar);
        this.f3208g = mVar;
        mVar.e(this.f3223v);
    }

    public void D(io.flutter.plugin.editing.m mVar) {
        this.f3207f = mVar;
    }

    public void E(FlutterRenderer flutterRenderer) {
        this.f3203b = new io.flutter.embedding.android.c(flutterRenderer, true);
    }

    public void F(io.flutter.embedding.android.v vVar) {
        this.f3205d = vVar;
        for (int i3 = 0; i3 < this.f3215n.size(); i3++) {
            this.f3205d.addView(this.f3215n.valueAt(i3));
        }
        for (int i4 = 0; i4 < this.f3213l.size(); i4++) {
            this.f3205d.addView(this.f3213l.valueAt(i4));
        }
        for (int i5 = 0; i5 < this.f3212k.size(); i5++) {
            this.f3212k.valueAt(i5).h(this.f3205d);
        }
    }

    public boolean G(View view) {
        if (view == null || !this.f3211j.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.f3211j.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public long I(k kVar, final m.d dVar) {
        r rVar;
        long j3;
        S(23);
        g1.b.e("PlatformViewsController", "Hosting view in view hierarchy for platform view: " + dVar.f4216a);
        int y02 = y0(dVar.f4218c);
        int y03 = y0(dVar.f4219d);
        if (this.f3222u) {
            rVar = new r(this.f3204c);
            j3 = -1;
        } else {
            p e02 = e0(this.f3206e);
            r rVar2 = new r(this.f3204c, e02);
            long id = e02.getId();
            rVar = rVar2;
            j3 = id;
        }
        rVar.setTouchProcessor(this.f3203b);
        rVar.b(y02, y03);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(y02, y03);
        int y04 = y0(dVar.f4220e);
        int y05 = y0(dVar.f4221f);
        layoutParams.topMargin = y04;
        layoutParams.leftMargin = y05;
        rVar.setLayoutParams(layoutParams);
        View view = kVar.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(y02, y03));
        view.setImportantForAccessibility(4);
        rVar.addView(view);
        rVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.v
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z3) {
                y.this.Z(dVar, view2, z3);
            }
        });
        this.f3205d.addView(rVar);
        this.f3215n.append(dVar.f4216a, rVar);
        f0(kVar);
        return j3;
    }

    public FlutterOverlaySurface K() {
        return L(new c(this.f3205d.getContext(), this.f3205d.getWidth(), this.f3205d.getHeight(), this.f3209h));
    }

    public FlutterOverlaySurface L(c cVar) {
        int i3 = this.f3216o;
        this.f3216o = i3 + 1;
        this.f3214m.put(i3, cVar);
        return new FlutterOverlaySurface(i3, cVar.getSurface());
    }

    public k M(m.d dVar, boolean z3) {
        l b4 = this.f3202a.b(dVar.f4217b);
        if (b4 == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + dVar.f4217b);
        }
        k a4 = b4.a(z3 ? new MutableContextWrapper(this.f3204c) : this.f3204c, dVar.f4216a, dVar.f4224i != null ? b4.b().b(dVar.f4224i) : null);
        View view = a4.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        view.setLayoutDirection(dVar.f4222g);
        this.f3212k.put(dVar.f4216a, a4);
        f0(a4);
        return a4;
    }

    public void N() {
        for (int i3 = 0; i3 < this.f3214m.size(); i3++) {
            c valueAt = this.f3214m.valueAt(i3);
            valueAt.d();
            valueAt.g();
        }
    }

    public void O() {
        t1.m mVar = this.f3208g;
        if (mVar != null) {
            mVar.e(null);
        }
        N();
        this.f3208g = null;
        this.f3204c = null;
        this.f3206e = null;
    }

    public void P() {
        for (int i3 = 0; i3 < this.f3215n.size(); i3++) {
            this.f3205d.removeView(this.f3215n.valueAt(i3));
        }
        for (int i4 = 0; i4 < this.f3213l.size(); i4++) {
            this.f3205d.removeView(this.f3213l.valueAt(i4));
        }
        N();
        t0();
        this.f3205d = null;
        this.f3217p = false;
        for (int i5 = 0; i5 < this.f3212k.size(); i5++) {
            this.f3212k.valueAt(i5).s();
        }
    }

    public void Q() {
        this.f3207f = null;
    }

    public m W() {
        return this.f3202a;
    }

    void X(final int i3) {
        k kVar = this.f3212k.get(i3);
        if (kVar == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.f3213l.get(i3) != null) {
            return;
        }
        View view = kVar.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.f3204c;
        l1.a aVar = new l1.a(context, context.getResources().getDisplayMetrics().density, this.f3203b);
        aVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.t
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z3) {
                y.this.b0(i3, view2, z3);
            }
        });
        this.f3213l.put(i3, aVar);
        view.setImportantForAccessibility(4);
        aVar.addView(view);
        this.f3205d.addView(aVar);
    }

    @Override // io.flutter.plugin.platform.s
    public void a(io.flutter.view.h hVar) {
        this.f3209h.c(hVar);
    }

    @Override // io.flutter.plugin.platform.s
    public View b(int i3) {
        if (c(i3)) {
            return this.f3210i.get(Integer.valueOf(i3)).g();
        }
        k kVar = this.f3212k.get(i3);
        if (kVar == null) {
            return null;
        }
        return kVar.getView();
    }

    @Override // io.flutter.plugin.platform.s
    public boolean c(int i3) {
        return this.f3210i.containsKey(Integer.valueOf(i3));
    }

    @Override // io.flutter.plugin.platform.s
    public void d() {
        this.f3209h.c(null);
    }

    public void g0() {
    }

    public void h0() {
        this.f3219r.clear();
        this.f3220s.clear();
    }

    public void i0() {
        R();
    }

    public void j0(int i3, int i4, int i5, int i6, int i7) {
        if (this.f3214m.get(i3) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i3 + ") doesn't exist");
        }
        Y();
        c cVar = this.f3214m.get(i3);
        if (cVar.getParent() == null) {
            this.f3205d.addView(cVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = i5;
        cVar.setLayoutParams(layoutParams);
        cVar.setVisibility(0);
        cVar.bringToFront();
        this.f3219r.add(Integer.valueOf(i3));
    }

    public void k0(int i3, int i4, int i5, int i6, int i7, int i8, int i9, FlutterMutatorsStack flutterMutatorsStack) {
        Y();
        X(i3);
        l1.a aVar = this.f3213l.get(i3);
        aVar.a(flutterMutatorsStack, i4, i5, i6, i7);
        aVar.setVisibility(0);
        aVar.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
        View view = this.f3212k.get(i3).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.f3220s.add(Integer.valueOf(i3));
    }

    public void l0() {
        boolean z3 = false;
        if (this.f3217p && this.f3220s.isEmpty()) {
            this.f3217p = false;
            this.f3205d.A(new Runnable() { // from class: io.flutter.plugin.platform.u
                @Override // java.lang.Runnable
                public final void run() {
                    y.this.c0();
                }
            });
        } else {
            if (this.f3217p && this.f3205d.j()) {
                z3 = true;
            }
            U(z3);
        }
    }

    public void m0() {
        R();
    }

    public void n0() {
        Iterator<i0> it = this.f3210i.values().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    public void o0(int i3) {
        if (i3 < 40) {
            return;
        }
        Iterator<i0> it = this.f3210i.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void u0(boolean z3) {
        this.f3222u = z3;
    }

    public MotionEvent x0(float f3, m.f fVar, boolean z3) {
        MotionEvent b4 = this.f3221t.b(f0.a.c(fVar.f4247p));
        if (!z3 && b4 != null) {
            return b4;
        }
        return MotionEvent.obtain(fVar.f4233b.longValue(), fVar.f4234c.longValue(), fVar.f4235d, fVar.f4236e, (MotionEvent.PointerProperties[]) s0(fVar.f4237f).toArray(new MotionEvent.PointerProperties[fVar.f4236e]), (MotionEvent.PointerCoords[]) q0(fVar.f4238g, f3).toArray(new MotionEvent.PointerCoords[fVar.f4236e]), fVar.f4239h, fVar.f4240i, fVar.f4241j, fVar.f4242k, fVar.f4243l, fVar.f4244m, fVar.f4245n, fVar.f4246o);
    }
}
