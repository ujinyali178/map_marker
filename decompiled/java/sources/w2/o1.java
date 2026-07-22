package w2;

/* loaded from: /root/release/classes2.dex */
public class o1 extends s1 implements t {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f4492d;

    public o1(l1 l1Var) {
        super(true);
        X(l1Var);
        this.f4492d = y0();
    }

    private final boolean y0() {
        s1 y3;
        q T = T();
        r rVar = T instanceof r ? (r) T : null;
        if (rVar != null && (y3 = rVar.y()) != null) {
            while (!y3.Q()) {
                q T2 = y3.T();
                r rVar2 = T2 instanceof r ? (r) T2 : null;
                if (rVar2 != null && (y3 = rVar2.y()) != null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // w2.s1
    public boolean Q() {
        return this.f4492d;
    }

    @Override // w2.s1
    public boolean R() {
        return true;
    }
}
