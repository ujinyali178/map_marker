package b3;

import g2.k;
import g2.l;
import i2.d;
import i2.g;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.z;
import p2.p;
import w2.t1;
import w2.v;

/* loaded from: /root/release/classes2.dex */
public final class b {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r3, d<? super T> dVar) {
        Object a4;
        Object c3;
        d a5 = h.a(dVar);
        try {
            g context = dVar.getContext();
            Object c4 = f0.c(context, null);
            try {
                a4 = ((p) t.a(pVar, 2)).invoke(r3, a5);
                c3 = j2.d.c();
                if (a4 == c3) {
                    return;
                }
            } finally {
                f0.a(context, c4);
            }
        } catch (Throwable th) {
            k.a aVar = k.f2549c;
            a4 = l.a(th);
        }
        a5.resumeWith(k.a(a4));
    }

    public static final <T, R> Object b(z<? super T> zVar, R r3, p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        Object vVar;
        Object c3;
        Object b02;
        Object c4;
        try {
            vVar = ((p) t.a(pVar, 2)).invoke(r3, zVar);
        } catch (Throwable th) {
            vVar = new v(th, false, 2, null);
        }
        c3 = j2.d.c();
        if (vVar == c3 || (b02 = zVar.b0(vVar)) == t1.f4512b) {
            c4 = j2.d.c();
            return c4;
        }
        if (b02 instanceof v) {
            throw ((v) b02).f4525a;
        }
        return t1.h(b02);
    }
}
