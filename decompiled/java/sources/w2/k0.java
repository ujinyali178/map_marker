package w2;

import g2.k;

/* loaded from: /root/release/classes2.dex */
public final class k0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(i2.d<?> dVar) {
        Object a4;
        if (dVar instanceof kotlinx.coroutines.internal.f) {
            return dVar.toString();
        }
        try {
            k.a aVar = g2.k.f2549c;
            a4 = g2.k.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            k.a aVar2 = g2.k.f2549c;
            a4 = g2.k.a(g2.l.a(th));
        }
        if (g2.k.b(a4) != null) {
            a4 = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) a4;
    }
}
