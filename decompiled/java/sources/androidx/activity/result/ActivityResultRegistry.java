package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: /root/release/classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    private Random f300a = new Random();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f301b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<String, Integer> f302c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, d> f303d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    ArrayList<String> f304e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    final transient Map<String, c<?>> f305f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    final Map<String, Object> f306g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    final Bundle f307h = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    class a<I> extends androidx.activity.result.c<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f312a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f313b;

        a(String str, b.a aVar) {
            this.f312a = str;
            this.f313b = aVar;
        }

        @Override // androidx.activity.result.c
        public void b(I i3, androidx.core.app.e eVar) {
            Integer num = ActivityResultRegistry.this.f302c.get(this.f312a);
            if (num != null) {
                ActivityResultRegistry.this.f304e.add(this.f312a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f313b, i3, eVar);
                    return;
                } catch (Exception e3) {
                    ActivityResultRegistry.this.f304e.remove(this.f312a);
                    throw e3;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f313b + " and input " + i3 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void c() {
            ActivityResultRegistry.this.l(this.f312a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    class b<I> extends androidx.activity.result.c<I> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f315a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f316b;

        b(String str, b.a aVar) {
            this.f315a = str;
            this.f316b = aVar;
        }

        @Override // androidx.activity.result.c
        public void b(I i3, androidx.core.app.e eVar) {
            Integer num = ActivityResultRegistry.this.f302c.get(this.f315a);
            if (num != null) {
                ActivityResultRegistry.this.f304e.add(this.f315a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f316b, i3, eVar);
                    return;
                } catch (Exception e3) {
                    ActivityResultRegistry.this.f304e.remove(this.f315a);
                    throw e3;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f316b + " and input " + i3 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.c
        public void c() {
            ActivityResultRegistry.this.l(this.f315a);
        }
    }

    private static class c<O> {

        /* renamed from: a, reason: collision with root package name */
        final androidx.activity.result.b<O> f318a;

        /* renamed from: b, reason: collision with root package name */
        final b.a<?, O> f319b;

        c(androidx.activity.result.b<O> bVar, b.a<?, O> aVar) {
            this.f318a = bVar;
            this.f319b = aVar;
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final androidx.lifecycle.e f320a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<g> f321b = new ArrayList<>();

        d(androidx.lifecycle.e eVar) {
            this.f320a = eVar;
        }

        void a(g gVar) {
            this.f320a.a(gVar);
            this.f321b.add(gVar);
        }

        void b() {
            Iterator<g> it = this.f321b.iterator();
            while (it.hasNext()) {
                this.f320a.c(it.next());
            }
            this.f321b.clear();
        }
    }

    private void a(int i3, String str) {
        this.f301b.put(Integer.valueOf(i3), str);
        this.f302c.put(str, Integer.valueOf(i3));
    }

    private <O> void d(String str, int i3, Intent intent, c<O> cVar) {
        if (cVar == null || cVar.f318a == null || !this.f304e.contains(str)) {
            this.f306g.remove(str);
            this.f307h.putParcelable(str, new androidx.activity.result.a(i3, intent));
        } else {
            cVar.f318a.onActivityResult(cVar.f319b.c(i3, intent));
            this.f304e.remove(str);
        }
    }

    private int e() {
        int nextInt = this.f300a.nextInt(2147418112);
        while (true) {
            int i3 = nextInt + 65536;
            if (!this.f301b.containsKey(Integer.valueOf(i3))) {
                return i3;
            }
            nextInt = this.f300a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f302c.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i3, int i4, Intent intent) {
        String str = this.f301b.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        d(str, i4, intent, this.f305f.get(str));
        return true;
    }

    public final <O> boolean c(int i3, O o3) {
        androidx.activity.result.b<?> bVar;
        String str = this.f301b.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f305f.get(str);
        if (cVar == null || (bVar = cVar.f318a) == null) {
            this.f307h.remove(str);
            this.f306g.put(str, o3);
            return true;
        }
        if (!this.f304e.remove(str)) {
            return true;
        }
        bVar.onActivityResult(o3);
        return true;
    }

    public abstract <I, O> void f(int i3, b.a<I, O> aVar, I i4, androidx.core.app.e eVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f304e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f300a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f307h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
            String str = stringArrayList.get(i3);
            if (this.f302c.containsKey(str)) {
                Integer remove = this.f302c.remove(str);
                if (!this.f307h.containsKey(str)) {
                    this.f301b.remove(remove);
                }
            }
            a(integerArrayList.get(i3).intValue(), stringArrayList.get(i3));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f302c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f302c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f304e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f307h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f300a);
    }

    public final <I, O> androidx.activity.result.c<I> i(final String str, i iVar, final b.a<I, O> aVar, final androidx.activity.result.b<O> bVar) {
        androidx.lifecycle.e lifecycle = iVar.getLifecycle();
        if (lifecycle.b().b(e.b.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + iVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = this.f303d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new g() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.g
            public void e(i iVar2, e.a aVar2) {
                if (!e.a.ON_START.equals(aVar2)) {
                    if (e.a.ON_STOP.equals(aVar2)) {
                        ActivityResultRegistry.this.f305f.remove(str);
                        return;
                    } else {
                        if (e.a.ON_DESTROY.equals(aVar2)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f305f.put(str, new c<>(bVar, aVar));
                if (ActivityResultRegistry.this.f306g.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f306g.get(str);
                    ActivityResultRegistry.this.f306g.remove(str);
                    bVar.onActivityResult(obj);
                }
                androidx.activity.result.a aVar3 = (androidx.activity.result.a) ActivityResultRegistry.this.f307h.getParcelable(str);
                if (aVar3 != null) {
                    ActivityResultRegistry.this.f307h.remove(str);
                    bVar.onActivityResult(aVar.c(aVar3.b(), aVar3.a()));
                }
            }
        });
        this.f303d.put(str, dVar);
        return new a(str, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.c<I> j(String str, b.a<I, O> aVar, androidx.activity.result.b<O> bVar) {
        k(str);
        this.f305f.put(str, new c<>(bVar, aVar));
        if (this.f306g.containsKey(str)) {
            Object obj = this.f306g.get(str);
            this.f306g.remove(str);
            bVar.onActivityResult(obj);
        }
        androidx.activity.result.a aVar2 = (androidx.activity.result.a) this.f307h.getParcelable(str);
        if (aVar2 != null) {
            this.f307h.remove(str);
            bVar.onActivityResult(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new b(str, aVar);
    }

    final void l(String str) {
        Integer remove;
        if (!this.f304e.contains(str) && (remove = this.f302c.remove(str)) != null) {
            this.f301b.remove(remove);
        }
        this.f305f.remove(str);
        if (this.f306g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f306g.get(str));
            this.f306g.remove(str);
        }
        if (this.f307h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f307h.getParcelable(str));
            this.f307h.remove(str);
        }
        d dVar = this.f303d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f303d.remove(str);
        }
    }
}
