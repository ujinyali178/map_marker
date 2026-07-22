package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /root/release/classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f1169a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final w f1170b;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final boolean f1171a;
    }

    q(w wVar) {
        this.f1170b = wVar;
    }

    void a(Fragment fragment, Bundle bundle, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void b(Fragment fragment, boolean z3) {
        this.f1170b.v0().f();
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().b(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void d(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().d(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void e(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().e(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void f(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().f(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void g(Fragment fragment, boolean z3) {
        this.f1170b.v0().f();
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().g(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void i(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().i(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void k(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().k(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void l(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().l(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }

    void n(Fragment fragment, boolean z3) {
        Fragment y02 = this.f1170b.y0();
        if (y02 != null) {
            y02.getParentFragmentManager().x0().n(fragment, true);
        }
        Iterator<a> it = this.f1169a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z3 || next.f1171a) {
                next.getClass();
                throw null;
            }
        }
    }
}
