package w2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /root/release/classes2.dex */
public final class d1 extends c1 implements n0 {

    /* renamed from: g, reason: collision with root package name */
    private final Executor f4457g;

    public d1(Executor executor) {
        this.f4457g = executor;
        kotlinx.coroutines.internal.d.a(w());
    }

    private final void p(i2.g gVar, RejectedExecutionException rejectedExecutionException) {
        p1.c(gVar, b1.a("The task was rejected", rejectedExecutionException));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor w3 = w();
        ExecutorService executorService = w3 instanceof ExecutorService ? (ExecutorService) w3 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof d1) && ((d1) obj).w() == w();
    }

    @Override // w2.c0
    public void g(i2.g gVar, Runnable runnable) {
        try {
            Executor w3 = w();
            c.a();
            w3.execute(runnable);
        } catch (RejectedExecutionException e3) {
            c.a();
            p(gVar, e3);
            t0.b().g(gVar, runnable);
        }
    }

    public int hashCode() {
        return System.identityHashCode(w());
    }

    @Override // w2.c0
    public String toString() {
        return w().toString();
    }

    public Executor w() {
        return this.f4457g;
    }
}
