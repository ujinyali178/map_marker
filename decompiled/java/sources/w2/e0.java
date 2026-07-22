package w2;

import g2.k;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: /root/release/classes2.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final List<d0> f4459a;

    static {
        u2.b a4;
        List<d0> e3;
        a4 = u2.f.a(ServiceLoader.load(d0.class, d0.class.getClassLoader()).iterator());
        e3 = u2.h.e(a4);
        f4459a = e3;
    }

    public static final void a(i2.g gVar, Throwable th) {
        Iterator<d0> it = f4459a.iterator();
        while (it.hasNext()) {
            try {
                it.next().u(gVar, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, f0.b(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            k.a aVar = g2.k.f2549c;
            g2.b.a(th, new o0(gVar));
            g2.k.a(g2.q.f2555a);
        } catch (Throwable th3) {
            k.a aVar2 = g2.k.f2549c;
            g2.k.a(g2.l.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
