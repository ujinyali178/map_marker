package k2;

import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3746a;

    static {
        a aVar;
        Object newInstance;
        try {
            newInstance = m2.a.class.newInstance();
            k.d(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassNotFoundException unused) {
                    Object newInstance2 = l2.a.class.newInstance();
                    k.d(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        try {
                            if (newInstance2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            aVar = (a) newInstance2;
                        } catch (ClassCastException e3) {
                            ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                            ClassLoader classLoader2 = a.class.getClassLoader();
                            if (k.a(classLoader, classLoader2)) {
                                throw e3;
                            }
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e3);
                        }
                    } catch (ClassNotFoundException unused2) {
                        aVar = new a();
                    }
                }
            } catch (ClassCastException e4) {
                ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = a.class.getClassLoader();
                if (k.a(classLoader3, classLoader4)) {
                    throw e4;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e4);
            }
        } catch (ClassNotFoundException unused3) {
            Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            k.d(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassCastException e5) {
                    ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    if (k.a(classLoader5, classLoader6)) {
                        throw e5;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e5);
                }
            } catch (ClassNotFoundException unused4) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                k.d(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance4;
                } catch (ClassCastException e6) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    if (k.a(classLoader7, classLoader8)) {
                        throw e6;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e6);
                }
            }
        }
        if (newInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        aVar = (a) newInstance;
        f3746a = aVar;
    }
}
