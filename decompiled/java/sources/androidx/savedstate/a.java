package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.i;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import q.d;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final b f1442g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private boolean f1444b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f1445c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1446d;

    /* renamed from: e, reason: collision with root package name */
    private Recreator.b f1447e;

    /* renamed from: a, reason: collision with root package name */
    private final d.b<String, c> f1443a = new d.b<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f1448f = true;

    /* renamed from: androidx.savedstate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0034a {
        void a(d dVar);
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    public interface c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a this$0, i iVar, e.a event) {
        boolean z3;
        k.e(this$0, "this$0");
        k.e(iVar, "<anonymous parameter 0>");
        k.e(event, "event");
        if (event == e.a.ON_START) {
            z3 = true;
        } else if (event != e.a.ON_STOP) {
            return;
        } else {
            z3 = false;
        }
        this$0.f1448f = z3;
    }

    public final Bundle b(String key) {
        k.e(key, "key");
        if (!this.f1446d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f1445c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1445c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1445c;
        boolean z3 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z3 = true;
        }
        if (!z3) {
            this.f1445c = null;
        }
        return bundle2;
    }

    public final c c(String key) {
        k.e(key, "key");
        Iterator<Map.Entry<String, c>> it = this.f1443a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> components = it.next();
            k.d(components, "components");
            String key2 = components.getKey();
            c value = components.getValue();
            if (k.a(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final void e(e lifecycle) {
        k.e(lifecycle, "lifecycle");
        if (!(!this.f1444b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new androidx.lifecycle.g() { // from class: q.b
            @Override // androidx.lifecycle.g
            public final void e(i iVar, e.a aVar) {
                androidx.savedstate.a.d(androidx.savedstate.a.this, iVar, aVar);
            }
        });
        this.f1444b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f1444b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f1446d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f1445c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f1446d = true;
    }

    public final void g(Bundle outBundle) {
        k.e(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1445c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        d.b<String, c>.d c3 = this.f1443a.c();
        k.d(c3, "this.components.iteratorWithAdditions()");
        while (c3.hasNext()) {
            Map.Entry next = c3.next();
            bundle.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, c provider) {
        k.e(key, "key");
        k.e(provider, "provider");
        if (!(this.f1443a.f(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends InterfaceC0034a> clazz) {
        k.e(clazz, "clazz");
        if (!this.f1448f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.f1447e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f1447e = bVar;
        try {
            clazz.getDeclaredConstructor(new Class[0]);
            Recreator.b bVar2 = this.f1447e;
            if (bVar2 != null) {
                String name = clazz.getName();
                k.d(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
        }
    }
}
