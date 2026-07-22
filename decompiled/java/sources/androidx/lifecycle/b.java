package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: /root/release/classes.dex */
final class b {

    /* renamed from: c, reason: collision with root package name */
    static b f1282c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, a> f1283a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f1284b = new HashMap();

    @Deprecated
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map<e.a, List<C0025b>> f1285a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<C0025b, e.a> f1286b;

        a(Map<C0025b, e.a> map) {
            this.f1286b = map;
            for (Map.Entry<C0025b, e.a> entry : map.entrySet()) {
                e.a value = entry.getValue();
                List<C0025b> list = this.f1285a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f1285a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<C0025b> list, i iVar, e.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(iVar, aVar, obj);
                }
            }
        }

        void a(i iVar, e.a aVar, Object obj) {
            b(this.f1285a.get(aVar), iVar, aVar, obj);
            b(this.f1285a.get(e.a.ON_ANY), iVar, aVar, obj);
        }
    }

    @Deprecated
    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0025b {

        /* renamed from: a, reason: collision with root package name */
        final int f1287a;

        /* renamed from: b, reason: collision with root package name */
        final Method f1288b;

        C0025b(int i3, Method method) {
            this.f1287a = i3;
            this.f1288b = method;
            method.setAccessible(true);
        }

        void a(i iVar, e.a aVar, Object obj) {
            try {
                int i3 = this.f1287a;
                if (i3 == 0) {
                    this.f1288b.invoke(obj, new Object[0]);
                } else if (i3 == 1) {
                    this.f1288b.invoke(obj, iVar);
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    this.f1288b.invoke(obj, iVar, aVar);
                }
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to call observer method", e4.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0025b)) {
                return false;
            }
            C0025b c0025b = (C0025b) obj;
            return this.f1287a == c0025b.f1287a && this.f1288b.getName().equals(c0025b.f1288b.getName());
        }

        public int hashCode() {
            return (this.f1287a * 31) + this.f1288b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i3;
        a c3;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c3 = c(superclass)) != null) {
            hashMap.putAll(c3.f1286b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0025b, e.a> entry : c(cls2).f1286b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z3 = false;
        for (Method method : methodArr) {
            p pVar = (p) method.getAnnotation(p.class);
            if (pVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i3 = 0;
                } else {
                    if (!i.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i3 = 1;
                }
                e.a value = pVar.value();
                if (parameterTypes.length > 1) {
                    if (!e.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != e.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i3 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new C0025b(i3, method), value, cls);
                z3 = true;
            }
        }
        a aVar = new a(hashMap);
        this.f1283a.put(cls, aVar);
        this.f1284b.put(cls, Boolean.valueOf(z3));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e3) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
        }
    }

    private void e(Map<C0025b, e.a> map, C0025b c0025b, e.a aVar, Class<?> cls) {
        e.a aVar2 = map.get(c0025b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0025b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0025b.f1288b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    a c(Class<?> cls) {
        a aVar = this.f1283a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f1284b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b4 = b(cls);
        for (Method method : b4) {
            if (((p) method.getAnnotation(p.class)) != null) {
                a(cls, b4);
                return true;
            }
        }
        this.f1284b.put(cls, Boolean.FALSE);
        return false;
    }
}
