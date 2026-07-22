package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.e;
import androidx.savedstate.a;
import p.a;

/* loaded from: /root/release/classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b<q.d> f1324a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b<e0> f1325b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b<Bundle> f1326c = new a();

    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    public static final class b implements a.b<q.d> {
        b() {
        }
    }

    public static final class c implements a.b<e0> {
        c() {
        }
    }

    static final class d extends kotlin.jvm.internal.l implements p2.l<p.a, w> {

        /* renamed from: c, reason: collision with root package name */
        public static final d f1327c = new d();

        d() {
            super(1);
        }

        @Override // p2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w invoke(p.a initializer) {
            kotlin.jvm.internal.k.e(initializer, "$this$initializer");
            return new w();
        }
    }

    public static final t a(p.a aVar) {
        kotlin.jvm.internal.k.e(aVar, "<this>");
        q.d dVar = (q.d) aVar.a(f1324a);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        e0 e0Var = (e0) aVar.a(f1325b);
        if (e0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f1326c);
        String str = (String) aVar.a(a0.c.f1280c);
        if (str != null) {
            return b(dVar, e0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final t b(q.d dVar, e0 e0Var, String str, Bundle bundle) {
        v d3 = d(dVar);
        w e3 = e(e0Var);
        t tVar = e3.f().get(str);
        if (tVar != null) {
            return tVar;
        }
        t a4 = t.f1317f.a(d3.b(str), bundle);
        e3.f().put(str, a4);
        return a4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends q.d & e0> void c(T t3) {
        kotlin.jvm.internal.k.e(t3, "<this>");
        e.b b4 = t3.getLifecycle().b();
        if (!(b4 == e.b.INITIALIZED || b4 == e.b.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t3.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            v vVar = new v(t3.getSavedStateRegistry(), t3);
            t3.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", vVar);
            t3.getLifecycle().a(new SavedStateHandleAttacher(vVar));
        }
    }

    public static final v d(q.d dVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        a.c c3 = dVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        v vVar = c3 instanceof v ? (v) c3 : null;
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final w e(e0 e0Var) {
        kotlin.jvm.internal.k.e(e0Var, "<this>");
        p.c cVar = new p.c();
        cVar.a(kotlin.jvm.internal.r.b(w.class), d.f1327c);
        return (w) new a0(e0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", w.class);
    }
}
