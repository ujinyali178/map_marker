package w2;

import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes2.dex */
public final /* synthetic */ class q1 {
    public static final t a(l1 l1Var) {
        return new o1(l1Var);
    }

    public static /* synthetic */ t b(l1 l1Var, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l1Var = null;
        }
        return p1.a(l1Var);
    }

    public static final void c(i2.g gVar, CancellationException cancellationException) {
        l1 l1Var = (l1) gVar.a(l1.f4484e);
        if (l1Var != null) {
            l1Var.t(cancellationException);
        }
    }

    public static /* synthetic */ void d(i2.g gVar, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        p1.c(gVar, cancellationException);
    }

    public static final void e(i2.g gVar) {
        l1 l1Var = (l1) gVar.a(l1.f4484e);
        if (l1Var != null) {
            p1.f(l1Var);
        }
    }

    public static final void f(l1 l1Var) {
        if (!l1Var.isActive()) {
            throw l1Var.h();
        }
    }
}
