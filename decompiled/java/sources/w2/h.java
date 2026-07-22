package w2;

import i2.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes2.dex */
public final /* synthetic */ class h {
    public static final l1 a(g0 g0Var, i2.g gVar, i0 i0Var, p2.p<? super g0, ? super i2.d<? super g2.q>, ? extends Object> pVar) {
        i2.g e3 = b0.e(g0Var, gVar);
        a u1Var = i0Var.c() ? new u1(e3, pVar) : new a2(e3, true);
        u1Var.B0(i0Var, u1Var, pVar);
        return u1Var;
    }

    public static /* synthetic */ l1 b(g0 g0Var, i2.g gVar, i0 i0Var, p2.p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gVar = i2.h.f2693c;
        }
        if ((i3 & 2) != 0) {
            i0Var = i0.DEFAULT;
        }
        return g.a(g0Var, gVar, i0Var, pVar);
    }

    public static final <T> Object c(i2.g gVar, p2.p<? super g0, ? super i2.d<? super T>, ? extends Object> pVar, i2.d<? super T> dVar) {
        Object D0;
        Object c3;
        i2.g context = dVar.getContext();
        i2.g d3 = b0.d(context, gVar);
        p1.e(d3);
        if (d3 == context) {
            kotlinx.coroutines.internal.z zVar = new kotlinx.coroutines.internal.z(d3, dVar);
            D0 = b3.b.b(zVar, zVar, pVar);
        } else {
            e.b bVar = i2.e.f2690a;
            if (kotlin.jvm.internal.k.a(d3.a(bVar), context.a(bVar))) {
                e2 e2Var = new e2(d3, dVar);
                Object c4 = kotlinx.coroutines.internal.f0.c(d3, null);
                try {
                    Object b4 = b3.b.b(e2Var, e2Var, pVar);
                    kotlinx.coroutines.internal.f0.a(d3, c4);
                    D0 = b4;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.f0.a(d3, c4);
                    throw th;
                }
            } else {
                p0 p0Var = new p0(d3, dVar);
                b3.a.d(pVar, p0Var, p0Var, null, 4, null);
                D0 = p0Var.D0();
            }
        }
        c3 = j2.d.c();
        if (D0 == c3) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return D0;
    }
}
