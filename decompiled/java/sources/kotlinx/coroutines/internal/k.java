package kotlinx.coroutines.internal;

import w2.m0;
import w2.n0;

/* loaded from: /root/release/classes2.dex */
public final class k extends w2.c0 implements Runnable, n0 {

    /* renamed from: f, reason: collision with root package name */
    private final w2.c0 f3804f;

    /* renamed from: g, reason: collision with root package name */
    private final int f3805g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ n0 f3806h;

    /* renamed from: i, reason: collision with root package name */
    private final p<Runnable> f3807i;

    /* renamed from: j, reason: collision with root package name */
    private final Object f3808j;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public k(w2.c0 c0Var, int i3) {
        this.f3804f = c0Var;
        this.f3805g = i3;
        n0 n0Var = c0Var instanceof n0 ? (n0) c0Var : null;
        this.f3806h = n0Var == null ? m0.a() : n0Var;
        this.f3807i = new p<>(false);
        this.f3808j = new Object();
    }

    private final boolean p(Runnable runnable) {
        this.f3807i.a(runnable);
        return this.runningWorkers >= this.f3805g;
    }

    private final boolean w() {
        synchronized (this.f3808j) {
            if (this.runningWorkers >= this.f3805g) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // w2.c0
    public void g(i2.g gVar, Runnable runnable) {
        if (p(runnable) || !w()) {
            return;
        }
        this.f3804f.g(this, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r1 = r4.f3808j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r4.f3807i.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = g2.q.f2555a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f3807i
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            i2.h r3 = i2.h.f2693c
            w2.f0.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            w2.c0 r2 = r4.f3804f
            boolean r2 = r2.m(r4)
            if (r2 == 0) goto L2
            w2.c0 r0 = r4.f3804f
            r0.g(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f3808j
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.p<java.lang.Runnable> r2 = r4.f3807i     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            g2.q r2 = g2.q.f2555a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.run():void");
    }
}
