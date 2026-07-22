package kotlin.jvm.internal;

/* loaded from: /root/release/classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static final s f3769a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2.c[] f3770b;

    static {
        s sVar = null;
        try {
            sVar = (s) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (sVar == null) {
            sVar = new s();
        }
        f3769a = sVar;
        f3770b = new t2.c[0];
    }

    public static t2.e a(i iVar) {
        return f3769a.a(iVar);
    }

    public static t2.c b(Class cls) {
        return f3769a.b(cls);
    }

    public static t2.d c(Class cls) {
        return f3769a.c(cls, "");
    }

    public static t2.f d(n nVar) {
        return f3769a.d(nVar);
    }

    public static String e(h hVar) {
        return f3769a.e(hVar);
    }

    public static String f(l lVar) {
        return f3769a.f(lVar);
    }
}
