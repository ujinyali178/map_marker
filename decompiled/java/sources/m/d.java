package m;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import h2.e0;
import h2.j0;
import h2.v;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import m.d;

/* loaded from: /root/release/classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3928a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static c f3929b = c.f3940e;

    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface b {
        void a(n nVar);
    }

    public static final class c {

        /* renamed from: d, reason: collision with root package name */
        public static final a f3939d = new a(null);

        /* renamed from: e, reason: collision with root package name */
        public static final c f3940e;

        /* renamed from: a, reason: collision with root package name */
        private final Set<a> f3941a;

        /* renamed from: b, reason: collision with root package name */
        private final b f3942b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<String, Set<Class<? extends n>>> f3943c;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        static {
            Set b4;
            Map d3;
            b4 = j0.b();
            d3 = e0.d();
            f3940e = new c(b4, null, d3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Set<? extends a> flags, b bVar, Map<String, ? extends Set<Class<? extends n>>> allowedViolations) {
            kotlin.jvm.internal.k.e(flags, "flags");
            kotlin.jvm.internal.k.e(allowedViolations, "allowedViolations");
            this.f3941a = flags;
            this.f3942b = bVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends n>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f3943c = linkedHashMap;
        }

        public final Set<a> a() {
            return this.f3941a;
        }

        public final b b() {
            return this.f3942b;
        }

        public final Map<String, Set<Class<? extends n>>> c() {
            return this.f3943c;
        }
    }

    private d() {
    }

    private final c c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                w parentFragmentManager = fragment.getParentFragmentManager();
                kotlin.jvm.internal.k.d(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.B0() != null) {
                    c B0 = parentFragmentManager.B0();
                    kotlin.jvm.internal.k.b(B0);
                    return B0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f3929b;
    }

    private final void d(final c cVar, final n nVar) {
        Fragment a4 = nVar.a();
        final String name = a4.getClass().getName();
        if (cVar.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, nVar);
        }
        if (cVar.b() != null) {
            q(a4, new Runnable() { // from class: m.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(d.c.this, nVar);
                }
            });
        }
        if (cVar.a().contains(a.PENALTY_DEATH)) {
            q(a4, new Runnable() { // from class: m.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(name, nVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c policy, n violation) {
        kotlin.jvm.internal.k.e(policy, "$policy");
        kotlin.jvm.internal.k.e(violation, "$violation");
        policy.b().a(violation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, n violation) {
        kotlin.jvm.internal.k.e(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void g(n nVar) {
        if (w.I0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + nVar.a().getClass().getName(), nVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(Fragment fragment, String previousFragmentId) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        kotlin.jvm.internal.k.e(previousFragmentId, "previousFragmentId");
        m.a aVar = new m.a(fragment, previousFragmentId);
        d dVar = f3928a;
        dVar.g(aVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_FRAGMENT_REUSE) && dVar.r(c3, fragment.getClass(), aVar.getClass())) {
            dVar.d(c3, aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        e eVar = new e(fragment, viewGroup);
        d dVar = f3928a;
        dVar.g(eVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && dVar.r(c3, fragment.getClass(), eVar.getClass())) {
            dVar.d(c3, eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Fragment fragment) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        f fVar = new f(fragment);
        d dVar = f3928a;
        dVar.g(fVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && dVar.r(c3, fragment.getClass(), fVar.getClass())) {
            dVar.d(c3, fVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Fragment fragment) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        g gVar = new g(fragment);
        d dVar = f3928a;
        dVar.g(gVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && dVar.r(c3, fragment.getClass(), gVar.getClass())) {
            dVar.d(c3, gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(Fragment fragment) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        h hVar = new h(fragment);
        d dVar = f3928a;
        dVar.g(hVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && dVar.r(c3, fragment.getClass(), hVar.getClass())) {
            dVar.d(c3, hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(Fragment fragment) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        j jVar = new j(fragment);
        d dVar = f3928a;
        dVar.g(jVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && dVar.r(c3, fragment.getClass(), jVar.getClass())) {
            dVar.d(c3, jVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(Fragment violatingFragment, Fragment targetFragment, int i3) {
        kotlin.jvm.internal.k.e(violatingFragment, "violatingFragment");
        kotlin.jvm.internal.k.e(targetFragment, "targetFragment");
        k kVar = new k(violatingFragment, targetFragment, i3);
        d dVar = f3928a;
        dVar.g(kVar);
        c c3 = dVar.c(violatingFragment);
        if (c3.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && dVar.r(c3, violatingFragment.getClass(), kVar.getClass())) {
            dVar.d(c3, kVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(Fragment fragment, boolean z3) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        l lVar = new l(fragment, z3);
        d dVar = f3928a;
        dVar.g(lVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && dVar.r(c3, fragment.getClass(), lVar.getClass())) {
            dVar.d(c3, lVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(Fragment fragment, ViewGroup container) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        kotlin.jvm.internal.k.e(container, "container");
        o oVar = new o(fragment, container);
        d dVar = f3928a;
        dVar.g(oVar);
        c c3 = dVar.c(fragment);
        if (c3.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && dVar.r(c3, fragment.getClass(), oVar.getClass())) {
            dVar.d(c3, oVar);
        }
    }

    private final void q(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler g3 = fragment.getParentFragmentManager().v0().g();
            kotlin.jvm.internal.k.d(g3, "fragment.parentFragmentManager.host.handler");
            if (!kotlin.jvm.internal.k.a(g3.getLooper(), Looper.myLooper())) {
                g3.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    private final boolean r(c cVar, Class<? extends Fragment> cls, Class<? extends n> cls2) {
        boolean k3;
        Set<Class<? extends n>> set = cVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (!kotlin.jvm.internal.k.a(cls2.getSuperclass(), n.class)) {
            k3 = v.k(set, cls2.getSuperclass());
            if (k3) {
                return false;
            }
        }
        return !set.contains(cls2);
    }
}
