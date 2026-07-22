package w2;

import g2.k;

/* loaded from: /root/release/classes2.dex */
public final class r0 {
    public static final <T> void a(q0<? super T> q0Var, int i3) {
        i2.d<? super T> c3 = q0Var.c();
        boolean z3 = i3 == 4;
        if (z3 || !(c3 instanceof kotlinx.coroutines.internal.f) || b(i3) != b(q0Var.f4495f)) {
            d(q0Var, c3, z3);
            return;
        }
        c0 c0Var = ((kotlinx.coroutines.internal.f) c3).f3784g;
        i2.g context = c3.getContext();
        if (c0Var.m(context)) {
            c0Var.g(context, q0Var);
        } else {
            e(q0Var);
        }
    }

    public static final boolean b(int i3) {
        return i3 == 1 || i3 == 2;
    }

    public static final boolean c(int i3) {
        return i3 == 2;
    }

    public static final <T> void d(q0<? super T> q0Var, i2.d<? super T> dVar, boolean z3) {
        Object f3;
        Object i3 = q0Var.i();
        Throwable d3 = q0Var.d(i3);
        if (d3 != null) {
            k.a aVar = g2.k.f2549c;
            f3 = g2.l.a(d3);
        } else {
            k.a aVar2 = g2.k.f2549c;
            f3 = q0Var.f(i3);
        }
        Object a4 = g2.k.a(f3);
        if (!z3) {
            dVar.resumeWith(a4);
            return;
        }
        kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) dVar;
        i2.d<T> dVar2 = fVar.f3785h;
        Object obj = fVar.f3787j;
        i2.g context = dVar2.getContext();
        Object c3 = kotlinx.coroutines.internal.f0.c(context, obj);
        e2<?> g3 = c3 != kotlinx.coroutines.internal.f0.f3788a ? b0.g(dVar2, context, c3) : null;
        try {
            fVar.f3785h.resumeWith(a4);
            g2.q qVar = g2.q.f2555a;
        } finally {
            if (g3 == null || g3.D0()) {
                kotlinx.coroutines.internal.f0.a(context, c3);
            }
        }
    }

    private static final void e(q0<?> q0Var) {
        w0 a4 = c2.f4452a.a();
        if (a4.C()) {
            a4.y(q0Var);
            return;
        }
        a4.A(true);
        try {
            d(q0Var, q0Var.c(), true);
            do {
            } while (a4.E());
        } finally {
            try {
            } finally {
            }
        }
    }
}
