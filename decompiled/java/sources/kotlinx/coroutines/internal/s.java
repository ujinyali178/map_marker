package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import w2.v1;

/* loaded from: /root/release/classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f3826a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f3827b;

    /* renamed from: c, reason: collision with root package name */
    public static final v1 f3828c;

    static {
        s sVar = new s();
        f3826a = sVar;
        f3827b = c0.e("kotlinx.coroutines.fast.service.loader", true);
        f3828c = sVar.a();
    }

    private s() {
    }

    private final v1 a() {
        u2.b a4;
        List<r> e3;
        Object next;
        v1 e4;
        try {
            if (f3827b) {
                e3 = h.f3798a.c();
            } else {
                a4 = u2.f.a(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator());
                e3 = u2.h.e(a4);
            }
            Iterator<T> it = e3.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c3 = ((r) next).c();
                    do {
                        Object next2 = it.next();
                        int c4 = ((r) next2).c();
                        if (c3 < c4) {
                            next = next2;
                            c3 = c4;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            return (rVar == null || (e4 = t.e(rVar, e3)) == null) ? t.b(null, null, 3, null) : e4;
        } catch (Throwable th) {
            return t.b(th, null, 2, null);
        }
    }
}
