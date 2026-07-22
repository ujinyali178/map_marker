package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r.c;
import s.b;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f1487d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f1488e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f1491c;

    /* renamed from: b, reason: collision with root package name */
    final Set<Class<? extends r.a<?>>> f1490b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map<Class<?>, Object> f1489a = new HashMap();

    a(Context context) {
        this.f1491c = context.getApplicationContext();
    }

    private <T> T c(Class<? extends r.a<?>> cls, Set<Class<?>> set) {
        T t3;
        if (b.h()) {
            try {
                b.c(cls.getSimpleName());
            } finally {
                b.f();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f1489a.containsKey(cls)) {
            t3 = (T) this.f1489a.get(cls);
        } else {
            set.add(cls);
            try {
                r.a<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends r.a<?>>> dependencies = newInstance.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class<? extends r.a<?>> cls2 : dependencies) {
                        if (!this.f1489a.containsKey(cls2)) {
                            c(cls2, set);
                        }
                    }
                }
                t3 = (T) newInstance.a(this.f1491c);
                set.remove(cls);
                this.f1489a.put(cls, t3);
            } catch (Throwable th) {
                throw new c(th);
            }
        }
        return t3;
    }

    public static a d(Context context) {
        if (f1487d == null) {
            synchronized (f1488e) {
                if (f1487d == null) {
                    f1487d = new a(context);
                }
            }
        }
        return f1487d;
    }

    void a() {
        try {
            try {
                b.c("Startup");
                b(this.f1491c.getPackageManager().getProviderInfo(new ComponentName(this.f1491c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e3) {
                throw new c(e3);
            }
        } finally {
            b.f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(Bundle bundle) {
        String string = this.f1491c.getString(r.b.f4097a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (r.a.class.isAssignableFrom(cls)) {
                            this.f1490b.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends r.a<?>>> it = this.f1490b.iterator();
                while (it.hasNext()) {
                    c(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e3) {
                throw new c(e3);
            }
        }
    }
}
