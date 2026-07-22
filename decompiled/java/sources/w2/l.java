package w2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w2.l1;

/* loaded from: /root/release/classes2.dex */
public class l<T> extends q0<T> implements k<T>, kotlin.coroutines.jvm.internal.e {

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f4477j = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4478k = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: g, reason: collision with root package name */
    private final i2.d<T> f4479g;

    /* renamed from: h, reason: collision with root package name */
    private final i2.g f4480h;

    /* renamed from: i, reason: collision with root package name */
    private u0 f4481i;

    /* JADX WARN: Multi-variable type inference failed */
    public l(i2.d<? super T> dVar, int i3) {
        super(i3);
        this.f4479g = dVar;
        this.f4480h = dVar.getContext();
        this._decision = 0;
        this._state = d.f4454c;
    }

    private final boolean A() {
        return r0.c(this.f4495f) && ((kotlinx.coroutines.internal.f) this.f4479g).o();
    }

    private final i B(p2.l<? super Throwable, g2.q> lVar) {
        return lVar instanceof i ? (i) lVar : new i1(lVar);
    }

    private final void C(p2.l<? super Throwable, g2.q> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void F() {
        Throwable r3;
        i2.d<T> dVar = this.f4479g;
        kotlinx.coroutines.internal.f fVar = dVar instanceof kotlinx.coroutines.internal.f ? (kotlinx.coroutines.internal.f) dVar : null;
        if (fVar == null || (r3 = fVar.r(this)) == null) {
            return;
        }
        r();
        p(r3);
    }

    private final void H(Object obj, int i3, p2.l<? super Throwable, g2.q> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof y1)) {
                if (obj2 instanceof o) {
                    o oVar = (o) obj2;
                    if (oVar.c()) {
                        if (lVar != null) {
                            o(lVar, oVar.f4525a);
                            return;
                        }
                        return;
                    }
                }
                j(obj);
                throw new g2.d();
            }
        } while (!androidx.concurrent.futures.b.a(f4478k, this, obj2, J((y1) obj2, obj, i3, lVar, null)));
        s();
        t(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void I(l lVar, Object obj, int i3, p2.l lVar2, int i4, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i4 & 4) != 0) {
            lVar2 = null;
        }
        lVar.H(obj, i3, lVar2);
    }

    private final Object J(y1 y1Var, Object obj, int i3, p2.l<? super Throwable, g2.q> lVar, Object obj2) {
        if (obj instanceof v) {
            return obj;
        }
        if (!r0.b(i3) && obj2 == null) {
            return obj;
        }
        if (lVar != null || (((y1Var instanceof i) && !(y1Var instanceof e)) || obj2 != null)) {
            return new u(obj, y1Var instanceof i ? (i) y1Var : null, lVar, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean K() {
        do {
            int i3 = this._decision;
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f4477j.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.b0 L(Object obj, Object obj2, p2.l<? super Throwable, g2.q> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof y1)) {
                if ((obj3 instanceof u) && obj2 != null && ((u) obj3).f4521d == obj2) {
                    return m.f4486a;
                }
                return null;
            }
        } while (!androidx.concurrent.futures.b.a(f4478k, this, obj3, J((y1) obj3, obj, this.f4495f, lVar, obj2)));
        s();
        return m.f4486a;
    }

    private final boolean M() {
        do {
            int i3 = this._decision;
            if (i3 != 0) {
                if (i3 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f4477j.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void k(p2.l<? super Throwable, g2.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            f0.a(getContext(), new y("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean q(Throwable th) {
        if (A()) {
            return ((kotlinx.coroutines.internal.f) this.f4479g).p(th);
        }
        return false;
    }

    private final void s() {
        if (A()) {
            return;
        }
        r();
    }

    private final void t(int i3) {
        if (K()) {
            return;
        }
        r0.a(this, i3);
    }

    private final String y() {
        Object x3 = x();
        return x3 instanceof y1 ? "Active" : x3 instanceof o ? "Cancelled" : "Completed";
    }

    private final u0 z() {
        l1 l1Var = (l1) getContext().a(l1.f4484e);
        if (l1Var == null) {
            return null;
        }
        u0 d3 = l1.a.d(l1Var, true, false, new p(this), 2, null);
        this.f4481i = d3;
        return d3;
    }

    protected String D() {
        return "CancellableContinuation";
    }

    public final void E(Throwable th) {
        if (q(th)) {
            return;
        }
        p(th);
        s();
    }

    public final boolean G() {
        Object obj = this._state;
        if ((obj instanceof u) && ((u) obj).f4521d != null) {
            r();
            return false;
        }
        this._decision = 0;
        this._state = d.f4454c;
        return true;
    }

    @Override // w2.q0
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof y1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof v) {
                return;
            }
            if (obj2 instanceof u) {
                u uVar = (u) obj2;
                if (!(!uVar.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (androidx.concurrent.futures.b.a(f4478k, this, obj2, u.b(uVar, null, null, null, null, th, 15, null))) {
                    uVar.d(this, th);
                    return;
                }
            } else if (androidx.concurrent.futures.b.a(f4478k, this, obj2, new u(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // w2.k
    public Object b(T t3, Object obj) {
        return L(t3, obj, null);
    }

    @Override // w2.q0
    public final i2.d<T> c() {
        return this.f4479g;
    }

    @Override // w2.q0
    public Throwable d(Object obj) {
        Throwable d3 = super.d(obj);
        if (d3 != null) {
            return d3;
        }
        return null;
    }

    @Override // w2.k
    public Object e(T t3, Object obj, p2.l<? super Throwable, g2.q> lVar) {
        return L(t3, obj, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.q0
    public <T> T f(Object obj) {
        return obj instanceof u ? (T) ((u) obj).f4518a : obj;
    }

    @Override // w2.k
    public void g(T t3, p2.l<? super Throwable, g2.q> lVar) {
        H(t3, this.f4495f, lVar);
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        i2.d<T> dVar = this.f4479g;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // i2.d
    public i2.g getContext() {
        return this.f4480h;
    }

    @Override // w2.q0
    public Object i() {
        return x();
    }

    public final void l(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            f0.a(getContext(), new y("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // w2.k
    public Object m(Throwable th) {
        return L(new v(th, false, 2, null), null, null);
    }

    @Override // w2.k
    public void n(p2.l<? super Throwable, g2.q> lVar) {
        i B = B(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (androidx.concurrent.futures.b.a(f4478k, this, obj, B)) {
                    return;
                }
            } else if (obj instanceof i) {
                C(lVar, obj);
            } else {
                boolean z3 = obj instanceof v;
                if (z3) {
                    v vVar = (v) obj;
                    if (!vVar.b()) {
                        C(lVar, obj);
                    }
                    if (obj instanceof o) {
                        if (!z3) {
                            vVar = null;
                        }
                        k(lVar, vVar != null ? vVar.f4525a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof u) {
                    u uVar = (u) obj;
                    if (uVar.f4519b != null) {
                        C(lVar, obj);
                    }
                    if (B instanceof e) {
                        return;
                    }
                    if (uVar.c()) {
                        k(lVar, uVar.f4522e);
                        return;
                    } else {
                        if (androidx.concurrent.futures.b.a(f4478k, this, obj, u.b(uVar, null, B, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (B instanceof e) {
                        return;
                    }
                    if (androidx.concurrent.futures.b.a(f4478k, this, obj, new u(obj, B, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public final void o(p2.l<? super Throwable, g2.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            f0.a(getContext(), new y("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean p(Throwable th) {
        Object obj;
        boolean z3;
        do {
            obj = this._state;
            if (!(obj instanceof y1)) {
                return false;
            }
            z3 = obj instanceof i;
        } while (!androidx.concurrent.futures.b.a(f4478k, this, obj, new o(this, th, z3)));
        i iVar = z3 ? (i) obj : null;
        if (iVar != null) {
            l(iVar, th);
        }
        s();
        t(this.f4495f);
        return true;
    }

    public final void r() {
        u0 u0Var = this.f4481i;
        if (u0Var == null) {
            return;
        }
        u0Var.a();
        this.f4481i = x1.f4537c;
    }

    @Override // i2.d
    public void resumeWith(Object obj) {
        I(this, z.c(obj, this), this.f4495f, null, 4, null);
    }

    public String toString() {
        return D() + '(' + k0.c(this.f4479g) + "){" + y() + "}@" + k0.b(this);
    }

    public Throwable u(l1 l1Var) {
        return l1Var.h();
    }

    public final Object v() {
        l1 l1Var;
        Object c3;
        boolean A = A();
        if (M()) {
            if (this.f4481i == null) {
                z();
            }
            if (A) {
                F();
            }
            c3 = j2.d.c();
            return c3;
        }
        if (A) {
            F();
        }
        Object x3 = x();
        if (x3 instanceof v) {
            throw ((v) x3).f4525a;
        }
        if (!r0.b(this.f4495f) || (l1Var = (l1) getContext().a(l1.f4484e)) == null || l1Var.isActive()) {
            return f(x3);
        }
        CancellationException h3 = l1Var.h();
        a(x3, h3);
        throw h3;
    }

    @Override // w2.k
    public void w(Object obj) {
        t(this.f4495f);
    }

    public final Object x() {
        return this._state;
    }
}
