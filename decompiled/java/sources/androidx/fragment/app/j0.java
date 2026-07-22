package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
class j0 implements androidx.lifecycle.d, q.d, androidx.lifecycle.e0 {

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f1119c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.lifecycle.d0 f1120d;

    /* renamed from: f, reason: collision with root package name */
    private androidx.lifecycle.j f1121f = null;

    /* renamed from: g, reason: collision with root package name */
    private q.c f1122g = null;

    j0(Fragment fragment, androidx.lifecycle.d0 d0Var) {
        this.f1119c = fragment;
        this.f1120d = d0Var;
    }

    void a(e.a aVar) {
        this.f1121f.h(aVar);
    }

    void b() {
        if (this.f1121f == null) {
            this.f1121f = new androidx.lifecycle.j(this);
            q.c a4 = q.c.a(this);
            this.f1122g = a4;
            a4.c();
        }
    }

    boolean c() {
        return this.f1121f != null;
    }

    void d(Bundle bundle) {
        this.f1122g.d(bundle);
    }

    void e(Bundle bundle) {
        this.f1122g.e(bundle);
    }

    void f(e.b bVar) {
        this.f1121f.n(bVar);
    }

    @Override // androidx.lifecycle.d
    public p.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f1119c.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        p.d dVar = new p.d();
        if (application != null) {
            dVar.c(a0.a.f1275g, application);
        }
        dVar.c(androidx.lifecycle.u.f1324a, this.f1119c);
        dVar.c(androidx.lifecycle.u.f1325b, this);
        if (this.f1119c.getArguments() != null) {
            dVar.c(androidx.lifecycle.u.f1326c, this.f1119c.getArguments());
        }
        return dVar;
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.e getLifecycle() {
        b();
        return this.f1121f;
    }

    @Override // q.d
    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f1122g.b();
    }

    @Override // androidx.lifecycle.e0
    public androidx.lifecycle.d0 getViewModelStore() {
        b();
        return this.f1120d;
    }
}
