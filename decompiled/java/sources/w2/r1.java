package w2;

/* loaded from: /root/release/classes2.dex */
public abstract class r1 extends x implements u0, g1 {

    /* renamed from: g, reason: collision with root package name */
    public s1 f4497g;

    @Override // w2.u0
    public void a() {
        y().m0(this);
    }

    @Override // w2.g1
    public w1 e() {
        return null;
    }

    @Override // w2.g1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.o
    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + "[job@" + k0.b(y()) + ']';
    }

    public final s1 y() {
        s1 s1Var = this.f4497g;
        if (s1Var != null) {
            return s1Var;
        }
        kotlin.jvm.internal.k.o("job");
        return null;
    }

    public final void z(s1 s1Var) {
        this.f4497g = s1Var;
    }
}
