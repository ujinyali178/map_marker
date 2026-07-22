package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;
import q.d;

/* loaded from: /root/release/classes.dex */
public final class Recreator implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1439d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final d f1440c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        private final Set<String> f1441a;

        public b(androidx.savedstate.a registry) {
            k.e(registry, "registry");
            this.f1441a = new LinkedHashSet();
            registry.h("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.a.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f1441a));
            return bundle;
        }

        public final void b(String className) {
            k.e(className, "className");
            this.f1441a.add(className);
        }
    }

    public Recreator(d owner) {
        k.e(owner, "owner");
        this.f1440c = owner;
    }

    private final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0034a.class);
            k.d(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    k.d(newInstance, "{\n                constr…wInstance()\n            }");
                    ((a.InterfaceC0034a) newInstance).a(this.f1440c);
                } catch (Exception e3) {
                    throw new RuntimeException("Failed to instantiate " + str, e3);
                }
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Class " + str + " wasn't found", e5);
        }
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        k.e(source, "source");
        k.e(event, "event");
        if (event != e.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.getLifecycle().c(this);
        Bundle b4 = this.f1440c.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (b4 == null) {
            return;
        }
        ArrayList<String> stringArrayList = b4.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
