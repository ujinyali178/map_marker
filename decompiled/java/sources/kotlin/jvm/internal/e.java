package kotlin.jvm.internal;

import h2.d0;
import h2.e0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;
import p2.u;
import p2.v;
import p2.w;

/* loaded from: /root/release/classes.dex */
public final class e implements t2.c<Object>, d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f3757d = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Map<Class<? extends g2.c<?>>, Integer> f3758f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, String> f3759g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<String, String> f3760h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<String, String> f3761i;

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, String> f3762j;

    /* renamed from: c, reason: collision with root package name */
    private final Class<?> f3763c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(Class<?> jClass) {
            String str;
            String S;
            String T;
            String T2;
            k.e(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        k.d(name, "name");
                        T2 = v2.n.T(name, enclosingMethod.getName() + '$', null, 2, null);
                        if (T2 != null) {
                            return T2;
                        }
                    }
                    Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                    k.d(name, "name");
                    if (enclosingConstructor == null) {
                        S = v2.n.S(name, '$', null, 2, null);
                        return S;
                    }
                    T = v2.n.T(name, enclosingConstructor.getName() + '$', null, 2, null);
                    return T;
                }
                if (!jClass.isArray()) {
                    String str3 = (String) e.f3762j.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) e.f3762j.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
            }
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List f3;
        Map<Class<? extends g2.c<?>>, Integer> g3;
        int a4;
        String V;
        String V2;
        int i3 = 0;
        f3 = h2.n.f(p2.a.class, p2.l.class, p2.p.class, p2.q.class, p2.r.class, p2.s.class, p2.t.class, u.class, v.class, w.class, p2.b.class, p2.c.class, p2.d.class, p2.e.class, p2.f.class, p2.g.class, p2.h.class, p2.i.class, p2.j.class, p2.k.class, p2.m.class, p2.n.class, p2.o.class);
        ArrayList arrayList = new ArrayList(h2.o.i(f3, 10));
        for (Object obj : f3) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                h2.n.h();
            }
            arrayList.add(g2.n.a((Class) obj, Integer.valueOf(i3)));
            i3 = i4;
        }
        g3 = e0.g(arrayList);
        f3758f = g3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f3759g = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f3760h = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k.d(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.d(kotlinName, "kotlinName");
            V2 = v2.n.V(kotlinName, FilenameUtils.EXTENSION_SEPARATOR, null, 2, null);
            sb.append(V2);
            sb.append("CompanionObject");
            g2.j a5 = g2.n.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a5.c(), a5.d());
        }
        for (Map.Entry<Class<? extends g2.c<?>>, Integer> entry : f3758f.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f3761i = hashMap3;
        a4 = d0.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a4);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            V = v2.n.V((String) entry2.getValue(), FilenameUtils.EXTENSION_SEPARATOR, null, 2, null);
            linkedHashMap.put(key, V);
        }
        f3762j = linkedHashMap;
    }

    public e(Class<?> jClass) {
        k.e(jClass, "jClass");
        this.f3763c = jClass;
    }

    @Override // t2.c
    public String a() {
        return f3757d.a(b());
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> b() {
        return this.f3763c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(o2.a.b(this), o2.a.b((t2.c) obj));
    }

    public int hashCode() {
        return o2.a.b(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
