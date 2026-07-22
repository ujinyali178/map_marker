package w2;

import g2.k;

/* loaded from: /root/release/classes2.dex */
public final class z {
    public static final <T> Object a(Object obj, i2.d<? super T> dVar) {
        if (obj instanceof v) {
            k.a aVar = g2.k.f2549c;
            obj = g2.l.a(((v) obj).f4525a);
        }
        return g2.k.a(obj);
    }

    public static final <T> Object b(Object obj, p2.l<? super Throwable, g2.q> lVar) {
        Throwable b4 = g2.k.b(obj);
        return b4 == null ? lVar != null ? new w(obj, lVar) : obj : new v(b4, false, 2, null);
    }

    public static final <T> Object c(Object obj, k<?> kVar) {
        Throwable b4 = g2.k.b(obj);
        return b4 == null ? obj : new v(b4, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, p2.l lVar, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
