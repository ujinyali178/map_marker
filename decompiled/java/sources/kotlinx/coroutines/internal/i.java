package kotlinx.coroutines.internal;

import g2.k;

/* loaded from: /root/release/classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3799a;

    static {
        Object a4;
        try {
            k.a aVar = g2.k.f2549c;
            a4 = g2.k.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            k.a aVar2 = g2.k.f2549c;
            a4 = g2.k.a(g2.l.a(th));
        }
        f3799a = g2.k.d(a4);
    }

    public static final boolean a() {
        return f3799a;
    }
}
