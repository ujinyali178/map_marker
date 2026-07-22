package w2;

/* loaded from: /root/release/classes2.dex */
public abstract class v1 extends c0 {
    public abstract v1 p();

    @Override // w2.c0
    public String toString() {
        String w3 = w();
        if (w3 != null) {
            return w3;
        }
        return k0.a(this) + '@' + k0.b(this);
    }

    protected final String w() {
        v1 v1Var;
        v1 c3 = t0.c();
        if (this == c3) {
            return "Dispatchers.Main";
        }
        try {
            v1Var = c3.p();
        } catch (UnsupportedOperationException unused) {
            v1Var = null;
        }
        if (this == v1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
