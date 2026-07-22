package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

/* loaded from: /root/release/classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f1310a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Integer> f1311b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends c>>> f1312c = new HashMap();

    private l() {
    }

    private final c a(Constructor<? extends c> constructor, Object obj) {
        try {
            c newInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.k.d(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return newInstance;
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private final Constructor<? extends c> b(Class<?> cls) {
        try {
            Package r02 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r02 != null ? r02.getName() : "";
            kotlin.jvm.internal.k.d(fullPackage, "fullPackage");
            if (!(fullPackage.length() == 0)) {
                kotlin.jvm.internal.k.d(name, "name");
                name = name.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.k.d(name, "this as java.lang.String).substring(startIndex)");
            }
            kotlin.jvm.internal.k.d(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String c3 = c(name);
            if (!(fullPackage.length() == 0)) {
                c3 = fullPackage + FilenameUtils.EXTENSION_SEPARATOR + c3;
            }
            Class<?> cls2 = Class.forName(c3);
            kotlin.jvm.internal.k.c(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static final String c(String className) {
        String m3;
        kotlin.jvm.internal.k.e(className, "className");
        StringBuilder sb = new StringBuilder();
        m3 = v2.m.m(className, ".", "_", false, 4, null);
        sb.append(m3);
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }

    private final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f1311b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g3 = g(cls);
        map.put(cls, Integer.valueOf(g3));
        return g3;
    }

    private final boolean e(Class<?> cls) {
        return cls != null && h.class.isAssignableFrom(cls);
    }

    public static final g f(Object object) {
        kotlin.jvm.internal.k.e(object, "object");
        boolean z3 = object instanceof g;
        boolean z4 = object instanceof DefaultLifecycleObserver;
        if (z3 && z4) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (g) object);
        }
        if (z4) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, null);
        }
        if (z3) {
            return (g) object;
        }
        Class<?> cls = object.getClass();
        l lVar = f1310a;
        if (lVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        List<Constructor<? extends c>> list = f1312c.get(cls);
        kotlin.jvm.internal.k.b(list);
        List<Constructor<? extends c>> list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(lVar.a(list2.get(0), object));
        }
        int size = list2.size();
        c[] cVarArr = new c[size];
        for (int i3 = 0; i3 < size; i3++) {
            cVarArr[i3] = f1310a.a(list2.get(i3), object);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    private final int g(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends c> b4 = b(cls);
        if (b4 != null) {
            f1312c.put(cls, h2.m.b(b4));
            return 2;
        }
        if (b.f1282c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (e(superclass)) {
            kotlin.jvm.internal.k.d(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            List<Constructor<? extends c>> list = f1312c.get(superclass);
            kotlin.jvm.internal.k.b(list);
            arrayList = new ArrayList(list);
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.k.d(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                kotlin.jvm.internal.k.d(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List<Constructor<? extends c>> list2 = f1312c.get(intrface);
                kotlin.jvm.internal.k.b(list2);
                arrayList.addAll(list2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f1312c.put(cls, arrayList);
        return 2;
    }
}
