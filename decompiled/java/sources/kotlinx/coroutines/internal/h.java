package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: /root/release/classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f3798a = new h();

    private h() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> w3;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            w3 = h2.v.w(ServiceLoader.load(cls, classLoader));
            return w3;
        }
    }

    private final List<String> e(URL url) {
        boolean o3;
        BufferedReader bufferedReader;
        String T;
        String Y;
        String T2;
        String url2 = url.toString();
        o3 = v2.m.o(url2, "jar", false, 2, null);
        if (!o3) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> f3 = f3798a.f(bufferedReader);
                n2.b.a(bufferedReader, null);
                return f3;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        T = v2.n.T(url2, "jar:file:", null, 2, null);
        Y = v2.n.Y(T, '!', null, 2, null);
        T2 = v2.n.T(url2, "!/", null, 2, null);
        JarFile jarFile = new JarFile(Y, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(T2)), "UTF-8"));
            try {
                List<String> f4 = f3798a.f(bufferedReader);
                n2.b.a(bufferedReader, null);
                jarFile.close();
                return f4;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    g2.b.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> w3;
        String Z;
        CharSequence a02;
        boolean z3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                w3 = h2.v.w(linkedHashSet);
                return w3;
            }
            Z = v2.n.Z(readLine, "#", null, 2, null);
            a02 = v2.n.a0(Z);
            String obj = a02.toString();
            int i3 = 0;
            while (true) {
                if (i3 >= obj.length()) {
                    z3 = true;
                    break;
                }
                char charAt = obj.charAt(i3);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z3 = false;
                    break;
                }
                i3++;
            }
            if (!z3) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    public final List<r> c() {
        r rVar;
        if (!i.a()) {
            return b(r.class, r.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            r rVar2 = null;
            try {
                rVar = (r) r.class.cast(Class.forName("x2.a", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                rVar = null;
            }
            if (rVar != null) {
                arrayList.add(rVar);
            }
            try {
                rVar2 = (r) r.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, r.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (rVar2 == null) {
                return arrayList;
            }
            arrayList.add(rVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(r.class, r.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        Set z3;
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.k.d(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h2.s.j(arrayList, f3798a.e((URL) it.next()));
        }
        z3 = h2.v.z(arrayList);
        if (!(!z3.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(h2.o.i(z3, 10));
        Iterator it2 = z3.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f3798a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }
}
