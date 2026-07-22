package kotlinx.coroutines.internal;

import g2.k;

/* loaded from: /root/release/classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3774a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3775b;

    static {
        Object a4;
        Object a5;
        try {
            k.a aVar = g2.k.f2549c;
            a4 = g2.k.a(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            k.a aVar2 = g2.k.f2549c;
            a4 = g2.k.a(g2.l.a(th));
        }
        if (g2.k.b(a4) != null) {
            a4 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f3774a = (String) a4;
        try {
            a5 = g2.k.a(a0.class.getCanonicalName());
        } catch (Throwable th2) {
            k.a aVar3 = g2.k.f2549c;
            a5 = g2.k.a(g2.l.a(th2));
        }
        if (g2.k.b(a5) != null) {
            a5 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f3775b = (String) a5;
    }

    public static final <E extends Throwable> E a(E e3) {
        return e3;
    }
}
