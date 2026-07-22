package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.e0;
import w2.c0;
import w2.c1;

/* loaded from: /root/release/classes2.dex */
public final class b extends c1 implements Executor {

    /* renamed from: g, reason: collision with root package name */
    public static final b f3864g = new b();

    /* renamed from: h, reason: collision with root package name */
    private static final c0 f3865h;

    static {
        int a4;
        int d3;
        m mVar = m.f3884f;
        a4 = s2.f.a(64, kotlinx.coroutines.internal.c0.a());
        d3 = e0.d("kotlinx.coroutines.io.parallelism", a4, 0, 0, 12, null);
        f3865h = mVar.n(d3);
    }

    private b() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        g(i2.h.f2693c, runnable);
    }

    @Override // w2.c0
    public void g(i2.g gVar, Runnable runnable) {
        f3865h.g(gVar, runnable);
    }

    @Override // w2.c0
    public String toString() {
        return "Dispatchers.IO";
    }
}
