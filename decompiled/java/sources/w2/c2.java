package w2;

/* loaded from: /root/release/classes2.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public static final c2 f4452a = new c2();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<w0> f4453b = new ThreadLocal<>();

    private c2() {
    }

    public final w0 a() {
        ThreadLocal<w0> threadLocal = f4453b;
        w0 w0Var = threadLocal.get();
        if (w0Var != null) {
            return w0Var;
        }
        w0 a4 = z0.a();
        threadLocal.set(a4);
        return a4;
    }

    public final void b() {
        f4453b.set(null);
    }

    public final void c(w0 w0Var) {
        f4453b.set(w0Var);
    }
}
