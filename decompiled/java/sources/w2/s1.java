package w2;

import i2.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.o;
import w2.l1;

/* loaded from: /root/release/classes2.dex */
public class s1 implements l1, s, z1 {

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4499c = AtomicReferenceFieldUpdater.newUpdater(s1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    private static final class a extends r1 {

        /* renamed from: h, reason: collision with root package name */
        private final s1 f4500h;

        /* renamed from: i, reason: collision with root package name */
        private final b f4501i;

        /* renamed from: j, reason: collision with root package name */
        private final r f4502j;

        /* renamed from: k, reason: collision with root package name */
        private final Object f4503k;

        public a(s1 s1Var, b bVar, r rVar, Object obj) {
            this.f4500h = s1Var;
            this.f4501i = bVar;
            this.f4502j = rVar;
            this.f4503k = obj;
        }

        @Override // p2.l
        public /* bridge */ /* synthetic */ g2.q invoke(Throwable th) {
            x(th);
            return g2.q.f2555a;
        }

        @Override // w2.x
        public void x(Throwable th) {
            this.f4500h.K(this.f4501i, this.f4502j, this.f4503k);
        }
    }

    private static final class b implements g1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: c, reason: collision with root package name */
        private final w1 f4504c;

        public b(w1 w1Var, boolean z3, Throwable th) {
            this.f4504c = w1Var;
            this._isCompleting = z3 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void a(Throwable th) {
            Throwable d3 = d();
            if (d3 == null) {
                l(th);
                return;
            }
            if (th == d3) {
                return;
            }
            Object c3 = c();
            if (c3 == null) {
                k(th);
                return;
            }
            if (c3 instanceof Throwable) {
                if (th == c3) {
                    return;
                }
                ArrayList<Throwable> b4 = b();
                b4.add(c3);
                b4.add(th);
                k(b4);
                return;
            }
            if (c3 instanceof ArrayList) {
                ((ArrayList) c3).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + c3).toString());
        }

        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        @Override // w2.g1
        public w1 e() {
            return this.f4504c;
        }

        public final boolean f() {
            return d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            kotlinx.coroutines.internal.b0 b0Var;
            Object c3 = c();
            b0Var = t1.f4515e;
            return c3 == b0Var;
        }

        public final List<Throwable> i(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.b0 b0Var;
            Object c3 = c();
            if (c3 == null) {
                arrayList = b();
            } else if (c3 instanceof Throwable) {
                ArrayList<Throwable> b4 = b();
                b4.add(c3);
                arrayList = b4;
            } else {
                if (!(c3 instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + c3).toString());
                }
                arrayList = (ArrayList) c3;
            }
            Throwable d3 = d();
            if (d3 != null) {
                arrayList.add(0, d3);
            }
            if (th != null && !kotlin.jvm.internal.k.a(th, d3)) {
                arrayList.add(th);
            }
            b0Var = t1.f4515e;
            k(b0Var);
            return arrayList;
        }

        @Override // w2.g1
        public boolean isActive() {
            return d() == null;
        }

        public final void j(boolean z3) {
            this._isCompleting = z3 ? 1 : 0;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + d() + ", exceptions=" + c() + ", list=" + e() + ']';
        }
    }

    public static final class c extends o.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s1 f4505d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f4506e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.o oVar, s1 s1Var, Object obj) {
            super(oVar);
            this.f4505d = s1Var;
            this.f4506e = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.o oVar) {
            if (this.f4505d.U() == this.f4506e) {
                return null;
            }
            return kotlinx.coroutines.internal.n.a();
        }
    }

    public s1(boolean z3) {
        this._state = z3 ? t1.f4517g : t1.f4516f;
        this._parentHandle = null;
    }

    private final boolean A(Object obj, w1 w1Var, r1 r1Var) {
        int w3;
        c cVar = new c(r1Var, this, obj);
        do {
            w3 = w1Var.p().w(r1Var, w1Var, cVar);
            if (w3 == 1) {
                return true;
            }
        } while (w3 != 2);
        return false;
    }

    private final void B(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                g2.b.a(th, th2);
            }
        }
    }

    private final Object F(Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        Object v02;
        kotlinx.coroutines.internal.b0 b0Var2;
        do {
            Object U = U();
            if (!(U instanceof g1) || ((U instanceof b) && ((b) U).g())) {
                b0Var = t1.f4511a;
                return b0Var;
            }
            v02 = v0(U, new v(L(obj), false, 2, null));
            b0Var2 = t1.f4513c;
        } while (v02 == b0Var2);
        return v02;
    }

    private final boolean G(Throwable th) {
        if (Z()) {
            return true;
        }
        boolean z3 = th instanceof CancellationException;
        q T = T();
        return (T == null || T == x1.f4537c) ? z3 : T.d(th) || z3;
    }

    private final void J(g1 g1Var, Object obj) {
        q T = T();
        if (T != null) {
            T.a();
            n0(x1.f4537c);
        }
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f4525a : null;
        if (!(g1Var instanceof r1)) {
            w1 e3 = g1Var.e();
            if (e3 != null) {
                g0(e3, th);
                return;
            }
            return;
        }
        try {
            ((r1) g1Var).x(th);
        } catch (Throwable th2) {
            W(new y("Exception in completion handler " + g1Var + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(b bVar, r rVar, Object obj) {
        r e02 = e0(rVar);
        if (e02 == null || !x0(bVar, e02, obj)) {
            C(M(bVar, obj));
        }
    }

    private final Throwable L(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new m1(H(), null, this) : th;
        }
        if (obj != null) {
            return ((z1) obj).s();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object M(b bVar, Object obj) {
        boolean f3;
        Throwable P;
        v vVar = obj instanceof v ? (v) obj : null;
        Throwable th = vVar != null ? vVar.f4525a : null;
        synchronized (bVar) {
            f3 = bVar.f();
            List<Throwable> i3 = bVar.i(th);
            P = P(bVar, i3);
            if (P != null) {
                B(P, i3);
            }
        }
        if (P != null && P != th) {
            obj = new v(P, false, 2, null);
        }
        if (P != null) {
            if (G(P) || V(P)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((v) obj).b();
            }
        }
        if (!f3) {
            h0(P);
        }
        i0(obj);
        androidx.concurrent.futures.b.a(f4499c, this, bVar, t1.g(obj));
        J(bVar, obj);
        return obj;
    }

    private final r N(g1 g1Var) {
        r rVar = g1Var instanceof r ? (r) g1Var : null;
        if (rVar != null) {
            return rVar;
        }
        w1 e3 = g1Var.e();
        if (e3 != null) {
            return e0(e3);
        }
        return null;
    }

    private final Throwable O(Object obj) {
        v vVar = obj instanceof v ? (v) obj : null;
        if (vVar != null) {
            return vVar.f4525a;
        }
        return null;
    }

    private final Throwable P(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.f()) {
                return new m1(H(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    private final w1 S(g1 g1Var) {
        w1 e3 = g1Var.e();
        if (e3 != null) {
            return e3;
        }
        if (g1Var instanceof v0) {
            return new w1();
        }
        if (g1Var instanceof r1) {
            l0((r1) g1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + g1Var).toString());
    }

    private final Object a0(Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        kotlinx.coroutines.internal.b0 b0Var4;
        kotlinx.coroutines.internal.b0 b0Var5;
        kotlinx.coroutines.internal.b0 b0Var6;
        Throwable th = null;
        while (true) {
            Object U = U();
            if (U instanceof b) {
                synchronized (U) {
                    if (((b) U).h()) {
                        b0Var2 = t1.f4514d;
                        return b0Var2;
                    }
                    boolean f3 = ((b) U).f();
                    if (obj != null || !f3) {
                        if (th == null) {
                            th = L(obj);
                        }
                        ((b) U).a(th);
                    }
                    Throwable d3 = f3 ^ true ? ((b) U).d() : null;
                    if (d3 != null) {
                        f0(((b) U).e(), d3);
                    }
                    b0Var = t1.f4511a;
                    return b0Var;
                }
            }
            if (!(U instanceof g1)) {
                b0Var3 = t1.f4514d;
                return b0Var3;
            }
            if (th == null) {
                th = L(obj);
            }
            g1 g1Var = (g1) U;
            if (!g1Var.isActive()) {
                Object v02 = v0(U, new v(th, false, 2, null));
                b0Var5 = t1.f4511a;
                if (v02 == b0Var5) {
                    throw new IllegalStateException(("Cannot happen in " + U).toString());
                }
                b0Var6 = t1.f4513c;
                if (v02 != b0Var6) {
                    return v02;
                }
            } else if (u0(g1Var, th)) {
                b0Var4 = t1.f4511a;
                return b0Var4;
            }
        }
    }

    private final r1 c0(p2.l<? super Throwable, g2.q> lVar, boolean z3) {
        r1 r1Var;
        if (z3) {
            r1Var = lVar instanceof n1 ? (n1) lVar : null;
            if (r1Var == null) {
                r1Var = new j1(lVar);
            }
        } else {
            r1Var = lVar instanceof r1 ? (r1) lVar : null;
            if (r1Var == null) {
                r1Var = new k1(lVar);
            }
        }
        r1Var.z(this);
        return r1Var;
    }

    private final r e0(kotlinx.coroutines.internal.o oVar) {
        while (oVar.s()) {
            oVar = oVar.p();
        }
        while (true) {
            oVar = oVar.o();
            if (!oVar.s()) {
                if (oVar instanceof r) {
                    return (r) oVar;
                }
                if (oVar instanceof w1) {
                    return null;
                }
            }
        }
    }

    private final void f0(w1 w1Var, Throwable th) {
        h0(th);
        y yVar = null;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) w1Var.n(); !kotlin.jvm.internal.k.a(oVar, w1Var); oVar = oVar.o()) {
            if (oVar instanceof n1) {
                r1 r1Var = (r1) oVar;
                try {
                    r1Var.x(th);
                } catch (Throwable th2) {
                    if (yVar != null) {
                        g2.b.a(yVar, th2);
                    } else {
                        yVar = new y("Exception in completion handler " + r1Var + " for " + this, th2);
                        g2.q qVar = g2.q.f2555a;
                    }
                }
            }
        }
        if (yVar != null) {
            W(yVar);
        }
        G(th);
    }

    private final void g0(w1 w1Var, Throwable th) {
        y yVar = null;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) w1Var.n(); !kotlin.jvm.internal.k.a(oVar, w1Var); oVar = oVar.o()) {
            if (oVar instanceof r1) {
                r1 r1Var = (r1) oVar;
                try {
                    r1Var.x(th);
                } catch (Throwable th2) {
                    if (yVar != null) {
                        g2.b.a(yVar, th2);
                    } else {
                        yVar = new y("Exception in completion handler " + r1Var + " for " + this, th2);
                        g2.q qVar = g2.q.f2555a;
                    }
                }
            }
        }
        if (yVar != null) {
            W(yVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [w2.f1] */
    private final void k0(v0 v0Var) {
        w1 w1Var = new w1();
        if (!v0Var.isActive()) {
            w1Var = new f1(w1Var);
        }
        androidx.concurrent.futures.b.a(f4499c, this, v0Var, w1Var);
    }

    private final void l0(r1 r1Var) {
        r1Var.j(new w1());
        androidx.concurrent.futures.b.a(f4499c, this, r1Var, r1Var.o());
    }

    private final int o0(Object obj) {
        v0 v0Var;
        if (!(obj instanceof v0)) {
            if (!(obj instanceof f1)) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(f4499c, this, obj, ((f1) obj).e())) {
                return -1;
            }
            j0();
            return 1;
        }
        if (((v0) obj).isActive()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4499c;
        v0Var = t1.f4517g;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj, v0Var)) {
            return -1;
        }
        j0();
        return 1;
    }

    private final String p0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof g1 ? ((g1) obj).isActive() ? "Active" : "New" : obj instanceof v ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.f() ? "Cancelling" : bVar.g() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException r0(s1 s1Var, Throwable th, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i3 & 1) != 0) {
            str = null;
        }
        return s1Var.q0(th, str);
    }

    private final boolean t0(g1 g1Var, Object obj) {
        if (!androidx.concurrent.futures.b.a(f4499c, this, g1Var, t1.g(obj))) {
            return false;
        }
        h0(null);
        i0(obj);
        J(g1Var, obj);
        return true;
    }

    private final boolean u0(g1 g1Var, Throwable th) {
        w1 S = S(g1Var);
        if (S == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(f4499c, this, g1Var, new b(S, false, th))) {
            return false;
        }
        f0(S, th);
        return true;
    }

    private final Object v0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        if (!(obj instanceof g1)) {
            b0Var2 = t1.f4511a;
            return b0Var2;
        }
        if ((!(obj instanceof v0) && !(obj instanceof r1)) || (obj instanceof r) || (obj2 instanceof v)) {
            return w0((g1) obj, obj2);
        }
        if (t0((g1) obj, obj2)) {
            return obj2;
        }
        b0Var = t1.f4513c;
        return b0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object w0(g1 g1Var, Object obj) {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        w1 S = S(g1Var);
        if (S == null) {
            b0Var3 = t1.f4513c;
            return b0Var3;
        }
        b bVar = g1Var instanceof b ? (b) g1Var : null;
        if (bVar == null) {
            bVar = new b(S, false, null);
        }
        kotlin.jvm.internal.q qVar = new kotlin.jvm.internal.q();
        synchronized (bVar) {
            if (bVar.g()) {
                b0Var2 = t1.f4511a;
                return b0Var2;
            }
            bVar.j(true);
            if (bVar != g1Var && !androidx.concurrent.futures.b.a(f4499c, this, g1Var, bVar)) {
                b0Var = t1.f4513c;
                return b0Var;
            }
            boolean f3 = bVar.f();
            v vVar = obj instanceof v ? (v) obj : null;
            if (vVar != null) {
                bVar.a(vVar.f4525a);
            }
            ?? d3 = Boolean.valueOf(f3 ? false : true).booleanValue() ? bVar.d() : 0;
            qVar.f3768c = d3;
            g2.q qVar2 = g2.q.f2555a;
            if (d3 != 0) {
                f0(S, d3);
            }
            r N = N(g1Var);
            return (N == null || !x0(bVar, N, obj)) ? M(bVar, obj) : t1.f4512b;
        }
    }

    private final boolean x0(b bVar, r rVar, Object obj) {
        while (l1.a.d(rVar.f4496h, false, false, new a(this, bVar, rVar, obj), 1, null) == x1.f4537c) {
            rVar = e0(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    protected void C(Object obj) {
    }

    public final boolean D(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        kotlinx.coroutines.internal.b0 b0Var3;
        obj2 = t1.f4511a;
        if (R() && (obj2 = F(obj)) == t1.f4512b) {
            return true;
        }
        b0Var = t1.f4511a;
        if (obj2 == b0Var) {
            obj2 = a0(obj);
        }
        b0Var2 = t1.f4511a;
        if (obj2 == b0Var2 || obj2 == t1.f4512b) {
            return true;
        }
        b0Var3 = t1.f4514d;
        if (obj2 == b0Var3) {
            return false;
        }
        C(obj2);
        return true;
    }

    public void E(Throwable th) {
        D(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String H() {
        return "Job was cancelled";
    }

    public boolean I(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return D(th) && Q();
    }

    public boolean Q() {
        return true;
    }

    public boolean R() {
        return false;
    }

    public final q T() {
        return (q) this._parentHandle;
    }

    public final Object U() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.w)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.w) obj).c(this);
        }
    }

    protected boolean V(Throwable th) {
        return false;
    }

    public void W(Throwable th) {
        throw th;
    }

    protected final void X(l1 l1Var) {
        if (l1Var == null) {
            n0(x1.f4537c);
            return;
        }
        l1Var.start();
        q l3 = l1Var.l(this);
        n0(l3);
        if (Y()) {
            l3.a();
            n0(x1.f4537c);
        }
    }

    public final boolean Y() {
        return !(U() instanceof g1);
    }

    protected boolean Z() {
        return false;
    }

    @Override // i2.g.b, i2.g
    public <E extends g.b> E a(g.c<E> cVar) {
        return (E) l1.a.c(this, cVar);
    }

    public final Object b0(Object obj) {
        Object v02;
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        do {
            v02 = v0(U(), obj);
            b0Var = t1.f4511a;
            if (v02 == b0Var) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, O(obj));
            }
            b0Var2 = t1.f4513c;
        } while (v02 == b0Var2);
        return v02;
    }

    public String d0() {
        return k0.a(this);
    }

    @Override // i2.g
    public i2.g f(i2.g gVar) {
        return l1.a.f(this, gVar);
    }

    @Override // i2.g.b
    public final g.c<?> getKey() {
        return l1.f4484e;
    }

    @Override // w2.l1
    public final CancellationException h() {
        Object U = U();
        if (!(U instanceof b)) {
            if (U instanceof g1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (U instanceof v) {
                return r0(this, ((v) U).f4525a, null, 1, null);
            }
            return new m1(k0.a(this) + " has completed normally", null, this);
        }
        Throwable d3 = ((b) U).d();
        if (d3 != null) {
            CancellationException q02 = q0(d3, k0.a(this) + " is cancelling");
            if (q02 != null) {
                return q02;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    protected void h0(Throwable th) {
    }

    protected void i0(Object obj) {
    }

    @Override // w2.l1
    public boolean isActive() {
        Object U = U();
        return (U instanceof g1) && ((g1) U).isActive();
    }

    @Override // w2.l1
    public final u0 j(boolean z3, boolean z4, p2.l<? super Throwable, g2.q> lVar) {
        r1 c02 = c0(lVar, z3);
        while (true) {
            Object U = U();
            if (U instanceof v0) {
                v0 v0Var = (v0) U;
                if (!v0Var.isActive()) {
                    k0(v0Var);
                } else if (androidx.concurrent.futures.b.a(f4499c, this, U, c02)) {
                    return c02;
                }
            } else {
                if (!(U instanceof g1)) {
                    if (z4) {
                        v vVar = U instanceof v ? (v) U : null;
                        lVar.invoke(vVar != null ? vVar.f4525a : null);
                    }
                    return x1.f4537c;
                }
                w1 e3 = ((g1) U).e();
                if (e3 != null) {
                    u0 u0Var = x1.f4537c;
                    if (z3 && (U instanceof b)) {
                        synchronized (U) {
                            r3 = ((b) U).d();
                            if (r3 == null || ((lVar instanceof r) && !((b) U).g())) {
                                if (A(U, e3, c02)) {
                                    if (r3 == null) {
                                        return c02;
                                    }
                                    u0Var = c02;
                                }
                            }
                            g2.q qVar = g2.q.f2555a;
                        }
                    }
                    if (r3 != null) {
                        if (z4) {
                            lVar.invoke(r3);
                        }
                        return u0Var;
                    }
                    if (A(U, e3, c02)) {
                        return c02;
                    }
                } else {
                    if (U == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    l0((r1) U);
                }
            }
        }
    }

    protected void j0() {
    }

    @Override // i2.g
    public i2.g k(g.c<?> cVar) {
        return l1.a.e(this, cVar);
    }

    @Override // w2.l1
    public final q l(s sVar) {
        return (q) l1.a.d(this, true, false, new r(sVar), 2, null);
    }

    public final void m0(r1 r1Var) {
        Object U;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        v0 v0Var;
        do {
            U = U();
            if (!(U instanceof r1)) {
                if (!(U instanceof g1) || ((g1) U).e() == null) {
                    return;
                }
                r1Var.t();
                return;
            }
            if (U != r1Var) {
                return;
            }
            atomicReferenceFieldUpdater = f4499c;
            v0Var = t1.f4517g;
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, U, v0Var));
    }

    public final void n0(q qVar) {
        this._parentHandle = qVar;
    }

    protected final CancellationException q0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = H();
            }
            cancellationException = new m1(str, th, this);
        }
        return cancellationException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // w2.z1
    public CancellationException s() {
        CancellationException cancellationException;
        Object U = U();
        if (U instanceof b) {
            cancellationException = ((b) U).d();
        } else if (U instanceof v) {
            cancellationException = ((v) U).f4525a;
        } else {
            if (U instanceof g1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + U).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new m1("Parent job is " + p0(U), cancellationException, this);
    }

    public final String s0() {
        return d0() + '{' + p0(U()) + '}';
    }

    @Override // w2.l1
    public final boolean start() {
        int o02;
        do {
            o02 = o0(U());
            if (o02 == 0) {
                return false;
            }
        } while (o02 != 1);
        return true;
    }

    @Override // w2.l1
    public void t(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new m1(H(), null, this);
        }
        E(cancellationException);
    }

    public String toString() {
        return s0() + '@' + k0.b(this);
    }

    @Override // w2.s
    public final void v(z1 z1Var) {
        D(z1Var);
    }

    @Override // i2.g
    public <R> R x(R r3, p2.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) l1.a.b(this, r3, pVar);
    }
}
