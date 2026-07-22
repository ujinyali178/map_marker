package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /root/release/classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private boolean f294a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f295b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private p2.a<g2.q> f296c;

    public l(boolean z3) {
        this.f294a = z3;
    }

    public final void a(a cancellable) {
        kotlin.jvm.internal.k.e(cancellable, "cancellable");
        this.f295b.add(cancellable);
    }

    public abstract void b();

    public final boolean c() {
        return this.f294a;
    }

    public final void d() {
        Iterator<T> it = this.f295b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    public final void e(a cancellable) {
        kotlin.jvm.internal.k.e(cancellable, "cancellable");
        this.f295b.remove(cancellable);
    }

    public final void f(boolean z3) {
        this.f294a = z3;
        p2.a<g2.q> aVar = this.f296c;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void g(p2.a<g2.q> aVar) {
        this.f296c = aVar;
    }
}
