package w2;

/* loaded from: /root/release/classes2.dex */
public final class f0 {
    public static final void a(i2.g gVar, Throwable th) {
        try {
            d0 d0Var = (d0) gVar.a(d0.f4455b);
            if (d0Var != null) {
                d0Var.u(gVar, th);
            } else {
                e0.a(gVar, th);
            }
        } catch (Throwable th2) {
            e0.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        g2.b.a(runtimeException, th);
        return runtimeException;
    }
}
