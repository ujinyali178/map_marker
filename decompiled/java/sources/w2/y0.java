package w2;

import java.util.concurrent.locks.LockSupport;
import w2.x0;

/* loaded from: /root/release/classes2.dex */
public abstract class y0 extends w0 {
    protected abstract Thread F();

    protected void G(long j3, x0.a aVar) {
        l0.f4482k.S(j3, aVar);
    }

    protected final void H() {
        Thread F = F();
        if (Thread.currentThread() != F) {
            c.a();
            LockSupport.unpark(F);
        }
    }
}
