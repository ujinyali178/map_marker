package kotlinx.coroutines.internal;

import g2.k;
import java.util.concurrent.CancellationException;
import w2.c2;
import w2.e2;
import w2.l1;
import w2.w0;

/* loaded from: /root/release/classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final b0 f3795a = new b0("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f3796b = new b0("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(i2.d<? super T> dVar, Object obj, p2.l<? super Throwable, g2.q> lVar) {
        boolean z3;
        if (!(dVar instanceof f)) {
            dVar.resumeWith(obj);
            return;
        }
        f fVar = (f) dVar;
        Object b4 = w2.z.b(obj, lVar);
        if (fVar.f3784g.m(fVar.getContext())) {
            fVar.f3786i = b4;
            fVar.f4495f = 1;
            fVar.f3784g.g(fVar.getContext(), fVar);
            return;
        }
        w0 a4 = c2.f4452a.a();
        if (a4.C()) {
            fVar.f3786i = b4;
            fVar.f4495f = 1;
            a4.y(fVar);
            return;
        }
        a4.A(true);
        try {
            l1 l1Var = (l1) fVar.getContext().a(l1.f4484e);
            if (l1Var == null || l1Var.isActive()) {
                z3 = false;
            } else {
                CancellationException h3 = l1Var.h();
                fVar.a(b4, h3);
                k.a aVar = g2.k.f2549c;
                fVar.resumeWith(g2.k.a(g2.l.a(h3)));
                z3 = true;
            }
            if (!z3) {
                i2.d<T> dVar2 = fVar.f3785h;
                Object obj2 = fVar.f3787j;
                i2.g context = dVar2.getContext();
                Object c3 = f0.c(context, obj2);
                e2<?> g3 = c3 != f0.f3788a ? w2.b0.g(dVar2, context, c3) : null;
                try {
                    fVar.f3785h.resumeWith(obj);
                    g2.q qVar = g2.q.f2555a;
                    if (g3 == null || g3.D0()) {
                        f0.a(context, c3);
                    }
                } catch (Throwable th) {
                    if (g3 == null || g3.D0()) {
                        f0.a(context, c3);
                    }
                    throw th;
                }
            }
            while (a4.E()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(i2.d dVar, Object obj, p2.l lVar, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
