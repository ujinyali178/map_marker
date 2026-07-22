package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f1341a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set<Closeable> f1342b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f1343c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    final void a() {
        this.f1343c = true;
        Map<String, Object> map = this.f1341a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f1341a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        Set<Closeable> set = this.f1342b;
        if (set != null) {
            synchronized (set) {
                Iterator<Closeable> it2 = this.f1342b.iterator();
                while (it2.hasNext()) {
                    b(it2.next());
                }
            }
        }
        d();
    }

    <T> T c(String str) {
        T t3;
        Map<String, Object> map = this.f1341a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t3 = (T) this.f1341a.get(str);
        }
        return t3;
    }

    protected void d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T e(String str, T t3) {
        Object obj;
        synchronized (this.f1341a) {
            obj = this.f1341a.get(str);
            if (obj == 0) {
                this.f1341a.put(str, t3);
            }
        }
        if (obj != 0) {
            t3 = obj;
        }
        if (this.f1343c) {
            b(t3);
        }
        return t3;
    }
}
