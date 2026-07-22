package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import m1.a;
import n1.c;
import u1.n;

/* loaded from: /root/release/classes.dex */
class c implements m1.b, n1.b {

    /* renamed from: b, reason: collision with root package name */
    private final io.flutter.embedding.engine.a f2936b;

    /* renamed from: c, reason: collision with root package name */
    private final a.b f2937c;

    /* renamed from: e, reason: collision with root package name */
    private io.flutter.embedding.android.d<Activity> f2939e;

    /* renamed from: f, reason: collision with root package name */
    private C0087c f2940f;

    /* renamed from: i, reason: collision with root package name */
    private Service f2943i;

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f2945k;

    /* renamed from: m, reason: collision with root package name */
    private ContentProvider f2947m;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends m1.a>, m1.a> f2935a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<? extends m1.a>, n1.a> f2938d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private boolean f2941g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<? extends m1.a>, r1.a> f2942h = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private final Map<Class<? extends m1.a>, o1.a> f2944j = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private final Map<Class<? extends m1.a>, p1.a> f2946l = new HashMap();

    private static class b implements a.InterfaceC0098a {

        /* renamed from: a, reason: collision with root package name */
        final k1.d f2948a;

        private b(k1.d dVar) {
            this.f2948a = dVar;
        }
    }

    /* renamed from: io.flutter.embedding.engine.c$c, reason: collision with other inner class name */
    private static class C0087c implements n1.c {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f2949a;

        /* renamed from: b, reason: collision with root package name */
        private final HiddenLifecycleReference f2950b;

        /* renamed from: c, reason: collision with root package name */
        private final Set<n.d> f2951c = new HashSet();

        /* renamed from: d, reason: collision with root package name */
        private final Set<n.a> f2952d = new HashSet();

        /* renamed from: e, reason: collision with root package name */
        private final Set<n.b> f2953e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private final Set<n.e> f2954f = new HashSet();

        /* renamed from: g, reason: collision with root package name */
        private final Set<n.g> f2955g = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        private final Set<c.a> f2956h = new HashSet();

        public C0087c(Activity activity, androidx.lifecycle.e eVar) {
            this.f2949a = activity;
            this.f2950b = new HiddenLifecycleReference(eVar);
        }

        @Override // n1.c
        public void a(n.a aVar) {
            this.f2952d.add(aVar);
        }

        @Override // n1.c
        public void b(n.d dVar) {
            this.f2951c.add(dVar);
        }

        @Override // n1.c
        public void c(n.d dVar) {
            this.f2951c.remove(dVar);
        }

        @Override // n1.c
        public void d(n.a aVar) {
            this.f2952d.remove(aVar);
        }

        boolean e(int i3, int i4, Intent intent) {
            boolean z3;
            Iterator it = new HashSet(this.f2952d).iterator();
            while (true) {
                while (it.hasNext()) {
                    z3 = ((n.a) it.next()).a(i3, i4, intent) || z3;
                }
                return z3;
            }
        }

        void f(Intent intent) {
            Iterator<n.b> it = this.f2953e.iterator();
            while (it.hasNext()) {
                it.next().onNewIntent(intent);
            }
        }

        boolean g(int i3, String[] strArr, int[] iArr) {
            boolean z3;
            Iterator<n.d> it = this.f2951c.iterator();
            while (true) {
                while (it.hasNext()) {
                    z3 = it.next().onRequestPermissionsResult(i3, strArr, iArr) || z3;
                }
                return z3;
            }
        }

        @Override // n1.c
        public Object getLifecycle() {
            return this.f2950b;
        }

        void h(Bundle bundle) {
            Iterator<c.a> it = this.f2956h.iterator();
            while (it.hasNext()) {
                it.next().b(bundle);
            }
        }

        @Override // n1.c
        public Activity i() {
            return this.f2949a;
        }

        void j(Bundle bundle) {
            Iterator<c.a> it = this.f2956h.iterator();
            while (it.hasNext()) {
                it.next().onSaveInstanceState(bundle);
            }
        }

        void k() {
            Iterator<n.e> it = this.f2954f.iterator();
            while (it.hasNext()) {
                it.next().onUserLeaveHint();
            }
        }
    }

    c(Context context, io.flutter.embedding.engine.a aVar, k1.d dVar, d dVar2) {
        this.f2936b = aVar;
        this.f2937c = new a.b(context, aVar, aVar.k(), aVar.t(), aVar.q().W(), new b(dVar), dVar2);
    }

    private void g(Activity activity, androidx.lifecycle.e eVar) {
        this.f2940f = new C0087c(activity, eVar);
        this.f2936b.q().u0(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("enable-software-rendering", false) : false);
        this.f2936b.q().C(activity, this.f2936b.t(), this.f2936b.k());
        for (n1.a aVar : this.f2938d.values()) {
            if (this.f2941g) {
                aVar.d(this.f2940f);
            } else {
                aVar.j(this.f2940f);
            }
        }
        this.f2941g = false;
    }

    private void i() {
        this.f2936b.q().O();
        this.f2939e = null;
        this.f2940f = null;
    }

    private void j() {
        if (o()) {
            e();
            return;
        }
        if (r()) {
            m();
        } else if (p()) {
            k();
        } else if (q()) {
            l();
        }
    }

    private boolean o() {
        return this.f2939e != null;
    }

    private boolean p() {
        return this.f2945k != null;
    }

    private boolean q() {
        return this.f2947m != null;
    }

    private boolean r() {
        return this.f2943i != null;
    }

    @Override // n1.b
    public boolean a(int i3, int i4, Intent intent) {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#onActivityResult");
        try {
            boolean e3 = this.f2940f.e(i3, i4, intent);
            if (f3 != null) {
                f3.close();
            }
            return e3;
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public void b(Bundle bundle) {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#onRestoreInstanceState");
        try {
            this.f2940f.h(bundle);
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public void c(io.flutter.embedding.android.d<Activity> dVar, androidx.lifecycle.e eVar) {
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            io.flutter.embedding.android.d<Activity> dVar2 = this.f2939e;
            if (dVar2 != null) {
                dVar2.c();
            }
            j();
            this.f2939e = dVar;
            g(dVar.d(), eVar);
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m1.b
    public void d(m1.a aVar) {
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#add " + aVar.getClass().getSimpleName());
        try {
            if (n(aVar.getClass())) {
                g1.b.g("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar + ") but it was already registered with this FlutterEngine (" + this.f2936b + ").");
                if (f3 != null) {
                    f3.close();
                    return;
                }
                return;
            }
            g1.b.f("FlutterEngineCxnRegstry", "Adding plugin: " + aVar);
            this.f2935a.put(aVar.getClass(), aVar);
            aVar.b(this.f2937c);
            if (aVar instanceof n1.a) {
                n1.a aVar2 = (n1.a) aVar;
                this.f2938d.put(aVar.getClass(), aVar2);
                if (o()) {
                    aVar2.j(this.f2940f);
                }
            }
            if (aVar instanceof r1.a) {
                r1.a aVar3 = (r1.a) aVar;
                this.f2942h.put(aVar.getClass(), aVar3);
                if (r()) {
                    aVar3.a(null);
                }
            }
            if (aVar instanceof o1.a) {
                o1.a aVar4 = (o1.a) aVar;
                this.f2944j.put(aVar.getClass(), aVar4);
                if (p()) {
                    aVar4.a(null);
                }
            }
            if (aVar instanceof p1.a) {
                p1.a aVar5 = (p1.a) aVar;
                this.f2946l.put(aVar.getClass(), aVar5);
                if (q()) {
                    aVar5.a(null);
                }
            }
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public void e() {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            Iterator<n1.a> it = this.f2938d.values().iterator();
            while (it.hasNext()) {
                it.next().i();
            }
            i();
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public void f() {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
        try {
            this.f2941g = true;
            Iterator<n1.a> it = this.f2938d.values().iterator();
            while (it.hasNext()) {
                it.next().h();
            }
            i();
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void h() {
        g1.b.f("FlutterEngineCxnRegstry", "Destroying.");
        j();
        u();
    }

    public void k() {
        if (!p()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
        try {
            Iterator<o1.a> it = this.f2944j.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void l() {
        if (!q()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#detachFromContentProvider");
        try {
            Iterator<p1.a> it = this.f2946l.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void m() {
        if (!r()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#detachFromService");
        try {
            Iterator<r1.a> it = this.f2942h.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f2943i = null;
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean n(Class<? extends m1.a> cls) {
        return this.f2935a.containsKey(cls);
    }

    @Override // n1.b
    public void onNewIntent(Intent intent) {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#onNewIntent");
        try {
            this.f2940f.f(intent);
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
        try {
            boolean g3 = this.f2940f.g(i3, strArr, iArr);
            if (f3 != null) {
                f3.close();
            }
            return g3;
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public void onSaveInstanceState(Bundle bundle) {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#onSaveInstanceState");
        try {
            this.f2940f.j(bundle);
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // n1.b
    public void onUserLeaveHint() {
        if (!o()) {
            g1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#onUserLeaveHint");
        try {
            this.f2940f.k();
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void s(Class<? extends m1.a> cls) {
        m1.a aVar = this.f2935a.get(cls);
        if (aVar == null) {
            return;
        }
        e2.e f3 = e2.e.f("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
        try {
            if (aVar instanceof n1.a) {
                if (o()) {
                    ((n1.a) aVar).i();
                }
                this.f2938d.remove(cls);
            }
            if (aVar instanceof r1.a) {
                if (r()) {
                    ((r1.a) aVar).b();
                }
                this.f2942h.remove(cls);
            }
            if (aVar instanceof o1.a) {
                if (p()) {
                    ((o1.a) aVar).b();
                }
                this.f2944j.remove(cls);
            }
            if (aVar instanceof p1.a) {
                if (q()) {
                    ((p1.a) aVar).b();
                }
                this.f2946l.remove(cls);
            }
            aVar.e(this.f2937c);
            this.f2935a.remove(cls);
            if (f3 != null) {
                f3.close();
            }
        } catch (Throwable th) {
            if (f3 != null) {
                try {
                    f3.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void t(Set<Class<? extends m1.a>> set) {
        Iterator<Class<? extends m1.a>> it = set.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    public void u() {
        t(new HashSet(this.f2935a.keySet()));
        this.f2935a.clear();
    }
}
