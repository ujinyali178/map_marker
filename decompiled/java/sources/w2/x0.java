package w2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: /root/release/classes2.dex */
public abstract class x0 extends y0 implements n0 {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4532i = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_queue");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4533j = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    public static abstract class a implements Runnable, Comparable<a>, u0, kotlinx.coroutines.internal.h0 {
        private volatile Object _heap;

        /* renamed from: c, reason: collision with root package name */
        public long f4534c;

        /* renamed from: d, reason: collision with root package name */
        private int f4535d;

        @Override // w2.u0
        public final synchronized void a() {
            kotlinx.coroutines.internal.b0 b0Var;
            kotlinx.coroutines.internal.b0 b0Var2;
            Object obj = this._heap;
            b0Var = a1.f4442a;
            if (obj == b0Var) {
                return;
            }
            b bVar = obj instanceof b ? (b) obj : null;
            if (bVar != null) {
                bVar.g(this);
            }
            b0Var2 = a1.f4442a;
            this._heap = b0Var2;
        }

        @Override // kotlinx.coroutines.internal.h0
        public void b(kotlinx.coroutines.internal.g0<?> g0Var) {
            kotlinx.coroutines.internal.b0 b0Var;
            Object obj = this._heap;
            b0Var = a1.f4442a;
            if (!(obj != b0Var)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = g0Var;
        }

        @Override // kotlinx.coroutines.internal.h0
        public kotlinx.coroutines.internal.g0<?> c() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.g0) {
                return (kotlinx.coroutines.internal.g0) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j3 = this.f4534c - aVar.f4534c;
            if (j3 > 0) {
                return 1;
            }
            return j3 < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x0048, TryCatch #0 {, blocks: (B:11:0x000d, B:19:0x0021, B:20:0x0037, B:22:0x0040, B:23:0x0042, B:27:0x0024, B:30:0x002e), top: B:10:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized int f(long r8, w2.x0.b r10, w2.x0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.b0 r1 = w2.a1.b()     // Catch: java.lang.Throwable -> L4b
                if (r0 != r1) goto Lc
                r8 = 2
            La:
                monitor-exit(r7)
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.h0 r0 = r10.b()     // Catch: java.lang.Throwable -> L48
                w2.x0$a r0 = (w2.x0.a) r0     // Catch: java.lang.Throwable -> L48
                boolean r11 = w2.x0.I(r11)     // Catch: java.lang.Throwable -> L48
                if (r11 == 0) goto L1d
                r8 = 1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r7)
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f4536b = r8     // Catch: java.lang.Throwable -> L48
                goto L37
            L24:
                long r3 = r0.f4534c     // Catch: java.lang.Throwable -> L48
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f4536b     // Catch: java.lang.Throwable -> L48
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.f4534c     // Catch: java.lang.Throwable -> L48
                long r3 = r10.f4536b     // Catch: java.lang.Throwable -> L48
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L42
                r7.f4534c = r3     // Catch: java.lang.Throwable -> L48
            L42:
                r10.a(r7)     // Catch: java.lang.Throwable -> L48
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                r8 = 0
                goto La
            L48:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                throw r8     // Catch: java.lang.Throwable -> L4b
            L4b:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: w2.x0.a.f(long, w2.x0$b, w2.x0):int");
        }

        public final boolean g(long j3) {
            return j3 - this.f4534c >= 0;
        }

        @Override // kotlinx.coroutines.internal.h0
        public int getIndex() {
            return this.f4535d;
        }

        @Override // kotlinx.coroutines.internal.h0
        public void setIndex(int i3) {
            this.f4535d = i3;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f4534c + ']';
        }
    }

    public static final class b extends kotlinx.coroutines.internal.g0<a> {

        /* renamed from: b, reason: collision with root package name */
        public long f4536b;

        public b(long j3) {
            this.f4536b = j3;
        }
    }

    private final void J() {
        kotlinx.coroutines.internal.b0 b0Var;
        kotlinx.coroutines.internal.b0 b0Var2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4532i;
                b0Var = a1.f4443b;
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, b0Var)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.q) {
                    ((kotlinx.coroutines.internal.q) obj).d();
                    return;
                }
                b0Var2 = a1.f4443b;
                if (obj == b0Var2) {
                    return;
                }
                kotlinx.coroutines.internal.q qVar = new kotlinx.coroutines.internal.q(8, true);
                qVar.a((Runnable) obj);
                if (androidx.concurrent.futures.b.a(f4532i, this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable K() {
        kotlinx.coroutines.internal.b0 b0Var;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.q) {
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                Object j3 = qVar.j();
                if (j3 != kotlinx.coroutines.internal.q.f3820h) {
                    return (Runnable) j3;
                }
                androidx.concurrent.futures.b.a(f4532i, this, obj, qVar.i());
            } else {
                b0Var = a1.f4443b;
                if (obj == b0Var) {
                    return null;
                }
                if (androidx.concurrent.futures.b.a(f4532i, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean M(Runnable runnable) {
        kotlinx.coroutines.internal.b0 b0Var;
        while (true) {
            Object obj = this._queue;
            if (N()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f4532i, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.q) {
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                int a4 = qVar.a(runnable);
                if (a4 == 0) {
                    return true;
                }
                if (a4 == 1) {
                    androidx.concurrent.futures.b.a(f4532i, this, obj, qVar.i());
                } else if (a4 == 2) {
                    return false;
                }
            } else {
                b0Var = a1.f4443b;
                if (obj == b0Var) {
                    return false;
                }
                kotlinx.coroutines.internal.q qVar2 = new kotlinx.coroutines.internal.q(8, true);
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (androidx.concurrent.futures.b.a(f4532i, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean N() {
        return this._isCompleted;
    }

    private final void Q() {
        a i3;
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar == null || (i3 = bVar.i()) == null) {
                return;
            } else {
                G(nanoTime, i3);
            }
        }
    }

    private final int T(long j3, a aVar) {
        if (N()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            androidx.concurrent.futures.b.a(f4533j, this, null, new b(j3));
            Object obj = this._delayed;
            kotlin.jvm.internal.k.b(obj);
            bVar = (b) obj;
        }
        return aVar.f(j3, bVar, this);
    }

    private final void U(boolean z3) {
        this._isCompleted = z3 ? 1 : 0;
    }

    private final boolean V(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.e() : null) == aVar;
    }

    public void L(Runnable runnable) {
        if (M(runnable)) {
            H();
        } else {
            l0.f4482k.L(runnable);
        }
    }

    protected boolean O() {
        kotlinx.coroutines.internal.b0 b0Var;
        if (!D()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.q) {
                return ((kotlinx.coroutines.internal.q) obj).g();
            }
            b0Var = a1.f4443b;
            if (obj != b0Var) {
                return false;
            }
        }
        return true;
    }

    public long P() {
        a aVar;
        if (E()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (bVar) {
                    a b4 = bVar.b();
                    aVar = null;
                    if (b4 != null) {
                        a aVar2 = b4;
                        if (aVar2.g(nanoTime) ? M(aVar2) : false) {
                            aVar = bVar.h(0);
                        }
                    }
                }
            } while (aVar != null);
        }
        Runnable K = K();
        if (K == null) {
            return z();
        }
        K.run();
        return 0L;
    }

    protected final void R() {
        this._queue = null;
        this._delayed = null;
    }

    public final void S(long j3, a aVar) {
        int T = T(j3, aVar);
        if (T == 0) {
            if (V(aVar)) {
                H();
            }
        } else if (T == 1) {
            G(j3, aVar);
        } else if (T != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // w2.c0
    public final void g(i2.g gVar, Runnable runnable) {
        L(runnable);
    }

    @Override // w2.w0
    public void shutdown() {
        c2.f4452a.b();
        U(true);
        J();
        while (P() <= 0) {
        }
        Q();
    }

    @Override // w2.w0
    protected long z() {
        a e3;
        long b4;
        kotlinx.coroutines.internal.b0 b0Var;
        if (super.z() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                b0Var = a1.f4443b;
                return obj == b0Var ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.q) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (e3 = bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j3 = e3.f4534c;
        c.a();
        b4 = s2.f.b(j3 - System.nanoTime(), 0L);
        return b4;
    }
}
