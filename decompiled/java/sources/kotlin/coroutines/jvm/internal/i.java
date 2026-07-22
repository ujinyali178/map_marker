package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;

/* loaded from: /root/release/classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f3748a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final a f3749b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static a f3750c;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f3751a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f3752b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f3753c;

        public a(Method method, Method method2, Method method3) {
            this.f3751a = method;
            this.f3752b = method2;
            this.f3753c = method3;
        }
    }

    private i() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f3750c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f3749b;
            f3750c = aVar3;
            return aVar3;
        }
    }

    public final String b(kotlin.coroutines.jvm.internal.a continuation) {
        kotlin.jvm.internal.k.e(continuation, "continuation");
        a aVar = f3750c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == f3749b) {
            return null;
        }
        Method method = aVar.f3751a;
        Object invoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f3752b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f3753c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
