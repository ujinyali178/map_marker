package w2;

/* loaded from: /root/release/classes2.dex */
public abstract class a<T> extends s1 implements i2.d<T>, g0 {

    /* renamed from: d, reason: collision with root package name */
    private final i2.g f4441d;

    public a(i2.g gVar, boolean z3, boolean z4) {
        super(z4);
        if (z3) {
            X((l1) gVar.a(l1.f4484e));
        }
        this.f4441d = gVar.f(this);
    }

    protected void A0(T t3) {
    }

    public final <R> void B0(i0 i0Var, R r3, p2.p<? super R, ? super i2.d<? super T>, ? extends Object> pVar) {
        i0Var.b(pVar, r3, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // w2.s1
    public String H() {
        return k0.a(this) + " was cancelled";
    }

    @Override // w2.s1
    public final void W(Throwable th) {
        f0.a(this.f4441d, th);
    }

    @Override // w2.s1
    public String d0() {
        String b4 = b0.b(this.f4441d);
        if (b4 == null) {
            return super.d0();
        }
        return '\"' + b4 + "\":" + super.d0();
    }

    @Override // i2.d
    public final i2.g getContext() {
        return this.f4441d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w2.s1
    protected final void i0(Object obj) {
        if (!(obj instanceof v)) {
            A0(obj);
        } else {
            v vVar = (v) obj;
            z0(vVar.f4525a, vVar.a());
        }
    }

    @Override // w2.s1, w2.l1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // w2.g0
    public i2.g p() {
        return this.f4441d;
    }

    @Override // i2.d
    public final void resumeWith(Object obj) {
        Object b02 = b0(z.d(obj, null, 1, null));
        if (b02 == t1.f4512b) {
            return;
        }
        y0(b02);
    }

    protected void y0(Object obj) {
        C(obj);
    }

    protected void z0(Throwable th, boolean z3) {
    }
}
