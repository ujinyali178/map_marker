package b3;

import g2.k;
import g2.l;
import g2.q;
import i2.d;
import j2.c;
import kotlinx.coroutines.internal.g;
import p2.p;

/* loaded from: /root/release/classes2.dex */
public final class a {
    private static final void a(d<?> dVar, Throwable th) {
        k.a aVar = k.f2549c;
        dVar.resumeWith(k.a(l.a(th)));
        throw th;
    }

    public static final void b(d<? super q> dVar, d<?> dVar2) {
        d b4;
        try {
            b4 = c.b(dVar);
            k.a aVar = k.f2549c;
            g.c(b4, k.a(q.f2555a), null, 2, null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static final <R, T> void c(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r3, d<? super T> dVar, p2.l<? super Throwable, q> lVar) {
        d a4;
        d b4;
        try {
            a4 = c.a(pVar, r3, dVar);
            b4 = c.b(a4);
            k.a aVar = k.f2549c;
            g.b(b4, k.a(q.f2555a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, d dVar, p2.l lVar, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, dVar, lVar);
    }
}
