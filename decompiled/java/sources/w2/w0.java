package w2;

/* loaded from: /root/release/classes2.dex */
public abstract class w0 extends c0 {

    /* renamed from: f, reason: collision with root package name */
    private long f4529f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4530g;

    /* renamed from: h, reason: collision with root package name */
    private kotlinx.coroutines.internal.a<q0<?>> f4531h;

    public static /* synthetic */ void B(w0 w0Var, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i3 & 1) != 0) {
            z3 = false;
        }
        w0Var.A(z3);
    }

    private final long w(boolean z3) {
        return z3 ? 4294967296L : 1L;
    }

    public final void A(boolean z3) {
        this.f4529f += w(z3);
        if (z3) {
            return;
        }
        this.f4530g = true;
    }

    public final boolean C() {
        return this.f4529f >= w(true);
    }

    public final boolean D() {
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f4531h;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean E() {
        q0<?> d3;
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f4531h;
        if (aVar == null || (d3 = aVar.d()) == null) {
            return false;
        }
        d3.run();
        return true;
    }

    public final void p(boolean z3) {
        long w3 = this.f4529f - w(z3);
        this.f4529f = w3;
        if (w3 <= 0 && this.f4530g) {
            shutdown();
        }
    }

    public void shutdown() {
    }

    public final void y(q0<?> q0Var) {
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f4531h;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f4531h = aVar;
        }
        aVar.a(q0Var);
    }

    protected long z() {
        kotlinx.coroutines.internal.a<q0<?>> aVar = this.f4531h;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }
}
