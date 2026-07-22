package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import e2.h;
import i1.a;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import t1.i;
import t1.j;
import t1.k;
import t1.n;
import t1.o;
import t1.p;
import t1.q;
import t1.r;
import t1.s;

/* loaded from: /root/release/classes.dex */
public class a implements h.a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f2910a;

    /* renamed from: b, reason: collision with root package name */
    private final FlutterRenderer f2911b;

    /* renamed from: c, reason: collision with root package name */
    private final i1.a f2912c;

    /* renamed from: d, reason: collision with root package name */
    private final c f2913d;

    /* renamed from: e, reason: collision with root package name */
    private final v1.b f2914e;

    /* renamed from: f, reason: collision with root package name */
    private final t1.a f2915f;

    /* renamed from: g, reason: collision with root package name */
    private final t1.c f2916g;

    /* renamed from: h, reason: collision with root package name */
    private final t1.g f2917h;

    /* renamed from: i, reason: collision with root package name */
    private final t1.h f2918i;

    /* renamed from: j, reason: collision with root package name */
    private final i f2919j;

    /* renamed from: k, reason: collision with root package name */
    private final j f2920k;

    /* renamed from: l, reason: collision with root package name */
    private final t1.b f2921l;

    /* renamed from: m, reason: collision with root package name */
    private final o f2922m;

    /* renamed from: n, reason: collision with root package name */
    private final k f2923n;

    /* renamed from: o, reason: collision with root package name */
    private final n f2924o;

    /* renamed from: p, reason: collision with root package name */
    private final p f2925p;

    /* renamed from: q, reason: collision with root package name */
    private final q f2926q;

    /* renamed from: r, reason: collision with root package name */
    private final r f2927r;

    /* renamed from: s, reason: collision with root package name */
    private final s f2928s;

    /* renamed from: t, reason: collision with root package name */
    private final y f2929t;

    /* renamed from: u, reason: collision with root package name */
    private final Set<b> f2930u;

    /* renamed from: v, reason: collision with root package name */
    private final b f2931v;

    /* renamed from: io.flutter.embedding.engine.a$a, reason: collision with other inner class name */
    class C0086a implements b {
        C0086a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
            g1.b.f("FlutterEngine", "onPreEngineRestart()");
            Iterator it = a.this.f2930u.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b();
            }
            a.this.f2929t.m0();
            a.this.f2922m.g();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public a(Context context, k1.d dVar, FlutterJNI flutterJNI, y yVar, String[] strArr, boolean z3, boolean z4) {
        this(context, dVar, flutterJNI, yVar, strArr, z3, z4, null);
    }

    public a(Context context, k1.d dVar, FlutterJNI flutterJNI, y yVar, String[] strArr, boolean z3, boolean z4, d dVar2) {
        AssetManager assets;
        this.f2930u = new HashSet();
        this.f2931v = new C0086a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        g1.a e3 = g1.a.e();
        flutterJNI = flutterJNI == null ? e3.d().a() : flutterJNI;
        this.f2910a = flutterJNI;
        i1.a aVar = new i1.a(flutterJNI, assets);
        this.f2912c = aVar;
        aVar.n();
        j1.a a4 = g1.a.e().a();
        this.f2915f = new t1.a(aVar, flutterJNI);
        t1.c cVar = new t1.c(aVar);
        this.f2916g = cVar;
        this.f2917h = new t1.g(aVar);
        t1.h hVar = new t1.h(aVar);
        this.f2918i = hVar;
        this.f2919j = new i(aVar);
        this.f2920k = new j(aVar);
        this.f2921l = new t1.b(aVar);
        this.f2923n = new k(aVar);
        this.f2924o = new n(aVar, context.getPackageManager());
        this.f2922m = new o(aVar, z4);
        this.f2925p = new p(aVar);
        this.f2926q = new q(aVar);
        this.f2927r = new r(aVar);
        this.f2928s = new s(aVar);
        if (a4 != null) {
            a4.e(cVar);
        }
        v1.b bVar = new v1.b(context, hVar);
        this.f2914e = bVar;
        dVar = dVar == null ? e3.c() : dVar;
        if (!flutterJNI.isAttached()) {
            dVar.n(context.getApplicationContext());
            dVar.f(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f2931v);
        flutterJNI.setPlatformViewsController(yVar);
        flutterJNI.setLocalizationPlugin(bVar);
        flutterJNI.setDeferredComponentManager(e3.a());
        if (!flutterJNI.isAttached()) {
            f();
        }
        this.f2911b = new FlutterRenderer(flutterJNI);
        this.f2929t = yVar;
        yVar.g0();
        c cVar2 = new c(context.getApplicationContext(), this, dVar, dVar2);
        this.f2913d = cVar2;
        bVar.d(context.getResources().getConfiguration());
        if (z3 && dVar.e()) {
            s1.a.a(this);
        }
        h.c(context, this);
        cVar2.d(new x1.a(s()));
    }

    private void f() {
        g1.b.f("FlutterEngine", "Attaching to JNI.");
        this.f2910a.attachToNative();
        if (!z()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean z() {
        return this.f2910a.isAttached();
    }

    a A(Context context, a.b bVar, String str, List<String> list, y yVar, boolean z3, boolean z4) {
        if (z()) {
            return new a(context, null, this.f2910a.spawn(bVar.f2650c, bVar.f2649b, str, list), yVar, null, z3, z4);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    @Override // e2.h.a
    public void a(float f3, float f4, float f5) {
        this.f2910a.updateDisplayMetrics(0, f3, f4, f5);
    }

    public void e(b bVar) {
        this.f2930u.add(bVar);
    }

    public void g() {
        g1.b.f("FlutterEngine", "Destroying.");
        Iterator<b> it = this.f2930u.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2913d.h();
        this.f2929t.i0();
        this.f2912c.o();
        this.f2910a.removeEngineLifecycleListener(this.f2931v);
        this.f2910a.setDeferredComponentManager(null);
        this.f2910a.detachFromNativeAndReleaseResources();
        if (g1.a.e().a() != null) {
            g1.a.e().a().destroy();
            this.f2916g.c(null);
        }
    }

    public t1.a h() {
        return this.f2915f;
    }

    public n1.b i() {
        return this.f2913d;
    }

    public t1.b j() {
        return this.f2921l;
    }

    public i1.a k() {
        return this.f2912c;
    }

    public t1.g l() {
        return this.f2917h;
    }

    public v1.b m() {
        return this.f2914e;
    }

    public i n() {
        return this.f2919j;
    }

    public j o() {
        return this.f2920k;
    }

    public k p() {
        return this.f2923n;
    }

    public y q() {
        return this.f2929t;
    }

    public m1.b r() {
        return this.f2913d;
    }

    public n s() {
        return this.f2924o;
    }

    public FlutterRenderer t() {
        return this.f2911b;
    }

    public o u() {
        return this.f2922m;
    }

    public p v() {
        return this.f2925p;
    }

    public q w() {
        return this.f2926q;
    }

    public r x() {
        return this.f2927r;
    }

    public s y() {
        return this.f2928s;
    }
}
