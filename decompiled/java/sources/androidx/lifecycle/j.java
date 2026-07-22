package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class j extends e {

    /* renamed from: j, reason: collision with root package name */
    public static final a f1299j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final boolean f1300b;

    /* renamed from: c, reason: collision with root package name */
    private d.a<h, b> f1301c;

    /* renamed from: d, reason: collision with root package name */
    private e.b f1302d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<i> f1303e;

    /* renamed from: f, reason: collision with root package name */
    private int f1304f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1305g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1306h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<e.b> f1307i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final e.b a(e.b state1, e.b bVar) {
            kotlin.jvm.internal.k.e(state1, "state1");
            return (bVar == null || bVar.compareTo(state1) >= 0) ? state1 : bVar;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private e.b f1308a;

        /* renamed from: b, reason: collision with root package name */
        private g f1309b;

        public b(h hVar, e.b initialState) {
            kotlin.jvm.internal.k.e(initialState, "initialState");
            kotlin.jvm.internal.k.b(hVar);
            this.f1309b = l.f(hVar);
            this.f1308a = initialState;
        }

        public final void a(i iVar, e.a event) {
            kotlin.jvm.internal.k.e(event, "event");
            e.b c3 = event.c();
            this.f1308a = j.f1299j.a(this.f1308a, c3);
            g gVar = this.f1309b;
            kotlin.jvm.internal.k.b(iVar);
            gVar.e(iVar, event);
            this.f1308a = c3;
        }

        public final e.b b() {
            return this.f1308a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(i provider) {
        this(provider, true);
        kotlin.jvm.internal.k.e(provider, "provider");
    }

    private j(i iVar, boolean z3) {
        this.f1300b = z3;
        this.f1301c = new d.a<>();
        this.f1302d = e.b.INITIALIZED;
        this.f1307i = new ArrayList<>();
        this.f1303e = new WeakReference<>(iVar);
    }

    private final void d(i iVar) {
        Iterator<Map.Entry<h, b>> descendingIterator = this.f1301c.descendingIterator();
        kotlin.jvm.internal.k.d(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f1306h) {
            Map.Entry<h, b> next = descendingIterator.next();
            kotlin.jvm.internal.k.d(next, "next()");
            h key = next.getKey();
            b value = next.getValue();
            while (value.b().compareTo(this.f1302d) > 0 && !this.f1306h && this.f1301c.contains(key)) {
                e.a a4 = e.a.Companion.a(value.b());
                if (a4 == null) {
                    throw new IllegalStateException("no event down from " + value.b());
                }
                m(a4.c());
                value.a(iVar, a4);
                l();
            }
        }
    }

    private final e.b e(h hVar) {
        b value;
        Map.Entry<h, b> h3 = this.f1301c.h(hVar);
        e.b bVar = null;
        e.b b4 = (h3 == null || (value = h3.getValue()) == null) ? null : value.b();
        if (!this.f1307i.isEmpty()) {
            bVar = this.f1307i.get(r0.size() - 1);
        }
        a aVar = f1299j;
        return aVar.a(aVar.a(this.f1302d, b4), bVar);
    }

    private final void f(String str) {
        if (!this.f1300b || c.c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void g(i iVar) {
        d.b<h, b>.d c3 = this.f1301c.c();
        kotlin.jvm.internal.k.d(c3, "observerMap.iteratorWithAdditions()");
        while (c3.hasNext() && !this.f1306h) {
            Map.Entry next = c3.next();
            h hVar = (h) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f1302d) < 0 && !this.f1306h && this.f1301c.contains(hVar)) {
                m(bVar.b());
                e.a b4 = e.a.Companion.b(bVar.b());
                if (b4 == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(iVar, b4);
                l();
            }
        }
    }

    private final boolean i() {
        if (this.f1301c.size() == 0) {
            return true;
        }
        Map.Entry<h, b> a4 = this.f1301c.a();
        kotlin.jvm.internal.k.b(a4);
        e.b b4 = a4.getValue().b();
        Map.Entry<h, b> d3 = this.f1301c.d();
        kotlin.jvm.internal.k.b(d3);
        e.b b5 = d3.getValue().b();
        return b4 == b5 && this.f1302d == b5;
    }

    private final void k(e.b bVar) {
        e.b bVar2 = this.f1302d;
        if (bVar2 == bVar) {
            return;
        }
        if (!((bVar2 == e.b.INITIALIZED && bVar == e.b.DESTROYED) ? false : true)) {
            throw new IllegalStateException(("no event down from " + this.f1302d + " in component " + this.f1303e.get()).toString());
        }
        this.f1302d = bVar;
        if (this.f1305g || this.f1304f != 0) {
            this.f1306h = true;
            return;
        }
        this.f1305g = true;
        o();
        this.f1305g = false;
        if (this.f1302d == e.b.DESTROYED) {
            this.f1301c = new d.a<>();
        }
    }

    private final void l() {
        this.f1307i.remove(r0.size() - 1);
    }

    private final void m(e.b bVar) {
        this.f1307i.add(bVar);
    }

    private final void o() {
        i iVar = this.f1303e.get();
        if (iVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean i3 = i();
            this.f1306h = false;
            if (i3) {
                return;
            }
            e.b bVar = this.f1302d;
            Map.Entry<h, b> a4 = this.f1301c.a();
            kotlin.jvm.internal.k.b(a4);
            if (bVar.compareTo(a4.getValue().b()) < 0) {
                d(iVar);
            }
            Map.Entry<h, b> d3 = this.f1301c.d();
            if (!this.f1306h && d3 != null && this.f1302d.compareTo(d3.getValue().b()) > 0) {
                g(iVar);
            }
        }
    }

    @Override // androidx.lifecycle.e
    public void a(h observer) {
        i iVar;
        kotlin.jvm.internal.k.e(observer, "observer");
        f("addObserver");
        e.b bVar = this.f1302d;
        e.b bVar2 = e.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = e.b.INITIALIZED;
        }
        b bVar3 = new b(observer, bVar2);
        if (this.f1301c.f(observer, bVar3) == null && (iVar = this.f1303e.get()) != null) {
            boolean z3 = this.f1304f != 0 || this.f1305g;
            e.b e3 = e(observer);
            this.f1304f++;
            while (bVar3.b().compareTo(e3) < 0 && this.f1301c.contains(observer)) {
                m(bVar3.b());
                e.a b4 = e.a.Companion.b(bVar3.b());
                if (b4 == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(iVar, b4);
                l();
                e3 = e(observer);
            }
            if (!z3) {
                o();
            }
            this.f1304f--;
        }
    }

    @Override // androidx.lifecycle.e
    public e.b b() {
        return this.f1302d;
    }

    @Override // androidx.lifecycle.e
    public void c(h observer) {
        kotlin.jvm.internal.k.e(observer, "observer");
        f("removeObserver");
        this.f1301c.g(observer);
    }

    public void h(e.a event) {
        kotlin.jvm.internal.k.e(event, "event");
        f("handleLifecycleEvent");
        k(event.c());
    }

    public void j(e.b state) {
        kotlin.jvm.internal.k.e(state, "state");
        f("markState");
        n(state);
    }

    public void n(e.b state) {
        kotlin.jvm.internal.k.e(state, "state");
        f("setCurrentState");
        k(state);
    }
}
