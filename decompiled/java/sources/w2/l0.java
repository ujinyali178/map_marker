package w2;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import w2.x0;

/* loaded from: /root/release/classes2.dex */
public final class l0 extends x0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: k, reason: collision with root package name */
    public static final l0 f4482k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f4483l;

    static {
        Long l3;
        l0 l0Var = new l0();
        f4482k = l0Var;
        w0.B(l0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f4483l = timeUnit.toNanos(l3.longValue());
    }

    private l0() {
    }

    private final synchronized void W() {
        if (Z()) {
            debugStatus = 3;
            R();
            notifyAll();
        }
    }

    private final synchronized Thread X() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean Y() {
        return debugStatus == 4;
    }

    private final boolean Z() {
        int i3 = debugStatus;
        return i3 == 2 || i3 == 3;
    }

    private final synchronized boolean a0() {
        if (Z()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void b0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // w2.y0
    protected Thread F() {
        Thread thread = _thread;
        return thread == null ? X() : thread;
    }

    @Override // w2.y0
    protected void G(long j3, x0.a aVar) {
        b0();
    }

    @Override // w2.x0
    public void L(Runnable runnable) {
        if (Y()) {
            b0();
        }
        super.L(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean O;
        c2.f4452a.c(this);
        c.a();
        try {
            if (!a0()) {
                if (O) {
                    return;
                } else {
                    return;
                }
            }
            long j3 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long P = P();
                if (P == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j3 == Long.MAX_VALUE) {
                        j3 = f4483l + nanoTime;
                    }
                    long j4 = j3 - nanoTime;
                    if (j4 <= 0) {
                        _thread = null;
                        W();
                        c.a();
                        if (O()) {
                            return;
                        }
                        F();
                        return;
                    }
                    P = s2.f.d(P, j4);
                } else {
                    j3 = Long.MAX_VALUE;
                }
                if (P > 0) {
                    if (Z()) {
                        _thread = null;
                        W();
                        c.a();
                        if (O()) {
                            return;
                        }
                        F();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, P);
                }
            }
        } finally {
            _thread = null;
            W();
            c.a();
            if (!O()) {
                F();
            }
        }
    }

    @Override // w2.x0, w2.w0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
