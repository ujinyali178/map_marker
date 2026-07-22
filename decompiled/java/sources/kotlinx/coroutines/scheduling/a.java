package kotlinx.coroutines.scheduling;

import g2.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import w2.k0;

/* loaded from: /root/release/classes2.dex */
public final class a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: c, reason: collision with root package name */
    public final int f3842c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final int f3843d;

    /* renamed from: f, reason: collision with root package name */
    public final long f3844f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3845g;

    /* renamed from: h, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f3846h;

    /* renamed from: i, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f3847i;

    /* renamed from: j, reason: collision with root package name */
    public final y<c> f3848j;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: k, reason: collision with root package name */
    public static final C0093a f3837k = new C0093a(null);

    /* renamed from: o, reason: collision with root package name */
    public static final b0 f3841o = new b0("NOT_IN_STACK");

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f3838l = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f3839m = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3840n = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: kotlinx.coroutines.scheduling.a$a, reason: collision with other inner class name */
    public static final class C0093a {
        private C0093a() {
        }

        public /* synthetic */ C0093a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3849a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f3849a = iArr;
        }
    }

    public final class c extends Thread {

        /* renamed from: k, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f3850k = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: c, reason: collision with root package name */
        public final n f3851c;

        /* renamed from: d, reason: collision with root package name */
        public d f3852d;

        /* renamed from: f, reason: collision with root package name */
        private long f3853f;

        /* renamed from: g, reason: collision with root package name */
        private long f3854g;

        /* renamed from: h, reason: collision with root package name */
        private int f3855h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3856i;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f3851c = new n();
            this.f3852d = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f3841o;
            this.f3855h = q2.c.f4095c.b();
        }

        public c(a aVar, int i3) {
            this();
            o(i3);
        }

        private final void b(int i3) {
            if (i3 == 0) {
                return;
            }
            a.f3839m.addAndGet(a.this, -2097152L);
            if (this.f3852d != d.TERMINATED) {
                this.f3852d = d.DORMANT;
            }
        }

        private final void c(int i3) {
            if (i3 != 0 && s(d.BLOCKING)) {
                a.this.p();
            }
        }

        private final void d(h hVar) {
            int b4 = hVar.f3874d.b();
            i(b4);
            c(b4);
            a.this.m(hVar);
            b(b4);
        }

        private final h e(boolean z3) {
            h m3;
            h m4;
            if (z3) {
                boolean z4 = k(a.this.f3842c * 2) == 0;
                if (z4 && (m4 = m()) != null) {
                    return m4;
                }
                h h3 = this.f3851c.h();
                if (h3 != null) {
                    return h3;
                }
                if (!z4 && (m3 = m()) != null) {
                    return m3;
                }
            } else {
                h m5 = m();
                if (m5 != null) {
                    return m5;
                }
            }
            return t(false);
        }

        private final void i(int i3) {
            this.f3853f = 0L;
            if (this.f3852d == d.PARKING) {
                this.f3852d = d.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != a.f3841o;
        }

        private final void l() {
            if (this.f3853f == 0) {
                this.f3853f = System.nanoTime() + a.this.f3844f;
            }
            LockSupport.parkNanos(a.this.f3844f);
            if (System.nanoTime() - this.f3853f >= 0) {
                this.f3853f = 0L;
                u();
            }
        }

        private final h m() {
            kotlinx.coroutines.scheduling.d dVar;
            if (k(2) == 0) {
                h d3 = a.this.f3846h.d();
                if (d3 != null) {
                    return d3;
                }
                dVar = a.this.f3847i;
            } else {
                h d4 = a.this.f3847i.d();
                if (d4 != null) {
                    return d4;
                }
                dVar = a.this.f3846h;
            }
            return dVar.d();
        }

        private final void n() {
            loop0: while (true) {
                boolean z3 = false;
                while (!a.this.isTerminated() && this.f3852d != d.TERMINATED) {
                    h f3 = f(this.f3856i);
                    if (f3 != null) {
                        this.f3854g = 0L;
                        d(f3);
                    } else {
                        this.f3856i = false;
                        if (this.f3854g == 0) {
                            r();
                        } else if (z3) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f3854g);
                            this.f3854g = 0L;
                        } else {
                            z3 = true;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        private final boolean q() {
            boolean z3;
            if (this.f3852d != d.CPU_ACQUIRED) {
                a aVar = a.this;
                while (true) {
                    long j3 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j3) >> 42)) == 0) {
                        z3 = false;
                        break;
                    }
                    if (a.f3839m.compareAndSet(aVar, j3, j3 - 4398046511104L)) {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    return false;
                }
                this.f3852d = d.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                a.this.k(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.f3852d != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final h t(boolean z3) {
            int i3 = (int) (a.this.controlState & 2097151);
            if (i3 < 2) {
                return null;
            }
            int k3 = k(i3);
            a aVar = a.this;
            long j3 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < i3; i4++) {
                k3++;
                if (k3 > i3) {
                    k3 = 1;
                }
                c b4 = aVar.f3848j.b(k3);
                if (b4 != null && b4 != this) {
                    n nVar = this.f3851c;
                    n nVar2 = b4.f3851c;
                    long k4 = z3 ? nVar.k(nVar2) : nVar.l(nVar2);
                    if (k4 == -1) {
                        return this.f3851c.h();
                    }
                    if (k4 > 0) {
                        j3 = Math.min(j3, k4);
                    }
                }
            }
            if (j3 == Long.MAX_VALUE) {
                j3 = 0;
            }
            this.f3854g = j3;
            return null;
        }

        private final void u() {
            a aVar = a.this;
            synchronized (aVar.f3848j) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (aVar.controlState & 2097151)) <= aVar.f3842c) {
                    return;
                }
                if (f3850k.compareAndSet(this, -1, 1)) {
                    int i3 = this.indexInArray;
                    o(0);
                    aVar.l(this, i3, 0);
                    int andDecrement = (int) (a.f3839m.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != i3) {
                        c b4 = aVar.f3848j.b(andDecrement);
                        kotlin.jvm.internal.k.b(b4);
                        c cVar = b4;
                        aVar.f3848j.c(i3, cVar);
                        cVar.o(i3);
                        aVar.l(cVar, andDecrement, i3);
                    }
                    aVar.f3848j.c(andDecrement, null);
                    q qVar = q.f2555a;
                    this.f3852d = d.TERMINATED;
                }
            }
        }

        public final h f(boolean z3) {
            h d3;
            if (q()) {
                return e(z3);
            }
            if (!z3 || (d3 = this.f3851c.h()) == null) {
                d3 = a.this.f3847i.d();
            }
            return d3 == null ? t(true) : d3;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final int k(int i3) {
            int i4 = this.f3855h;
            int i5 = i4 ^ (i4 << 13);
            int i6 = i5 ^ (i5 >> 17);
            int i7 = i6 ^ (i6 << 5);
            this.f3855h = i7;
            int i8 = i3 - 1;
            return (i8 & i3) == 0 ? i7 & i8 : (i7 & Integer.MAX_VALUE) % i3;
        }

        public final void o(int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f3845g);
            sb.append("-worker-");
            sb.append(i3 == 0 ? "TERMINATED" : String.valueOf(i3));
            setName(sb.toString());
            this.indexInArray = i3;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.f3852d;
            boolean z3 = dVar2 == d.CPU_ACQUIRED;
            if (z3) {
                a.f3839m.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f3852d = dVar;
            }
            return z3;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i3, int i4, long j3, String str) {
        this.f3842c = i3;
        this.f3843d = i4;
        this.f3844f = j3;
        this.f3845g = str;
        if (!(i3 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i3 + " should be at least 1").toString());
        }
        if (!(i4 >= i3)) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should be greater than or equals to core pool size " + i3).toString());
        }
        if (!(i4 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j3 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j3 + " must be positive").toString());
        }
        this.f3846h = new kotlinx.coroutines.scheduling.d();
        this.f3847i = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.f3848j = new y<>(i3 + 1);
        this.controlState = i3 << 42;
        this._isTerminated = 0;
    }

    private final boolean a(h hVar) {
        return (hVar.f3874d.b() == 1 ? this.f3847i : this.f3846h).a(hVar);
    }

    private final int c() {
        int a4;
        int i3;
        synchronized (this.f3848j) {
            if (isTerminated()) {
                i3 = -1;
            } else {
                long j3 = this.controlState;
                int i4 = (int) (j3 & 2097151);
                a4 = s2.f.a(i4 - ((int) ((j3 & 4398044413952L) >> 21)), 0);
                if (a4 >= this.f3842c) {
                    return 0;
                }
                if (i4 >= this.f3843d) {
                    return 0;
                }
                int i5 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i5 > 0 && this.f3848j.b(i5) == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(this, i5);
                this.f3848j.c(i5, cVar);
                if (!(i5 == ((int) (2097151 & f3839m.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                cVar.start();
                i3 = a4 + 1;
            }
            return i3;
        }
    }

    private final c f() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !kotlin.jvm.internal.k.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void h(a aVar, Runnable runnable, i iVar, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iVar = l.f3882f;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        aVar.g(runnable, iVar, z3);
    }

    private final int i(c cVar) {
        int g3;
        do {
            Object h3 = cVar.h();
            if (h3 == f3841o) {
                return -1;
            }
            if (h3 == null) {
                return 0;
            }
            cVar = (c) h3;
            g3 = cVar.g();
        } while (g3 == 0);
        return g3;
    }

    private final c j() {
        while (true) {
            long j3 = this.parkedWorkersStack;
            c b4 = this.f3848j.b((int) (2097151 & j3));
            if (b4 == null) {
                return null;
            }
            long j4 = (2097152 + j3) & (-2097152);
            int i3 = i(b4);
            if (i3 >= 0 && f3838l.compareAndSet(this, j3, i3 | j4)) {
                b4.p(f3841o);
                return b4;
            }
        }
    }

    private final void o(boolean z3) {
        long addAndGet = f3839m.addAndGet(this, 2097152L);
        if (z3 || t() || r(addAndGet)) {
            return;
        }
        t();
    }

    private final h q(c cVar, h hVar, boolean z3) {
        if (cVar == null || cVar.f3852d == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f3874d.b() == 0 && cVar.f3852d == d.BLOCKING) {
            return hVar;
        }
        cVar.f3856i = true;
        return cVar.f3851c.a(hVar, z3);
    }

    private final boolean r(long j3) {
        int a4;
        a4 = s2.f.a(((int) (2097151 & j3)) - ((int) ((j3 & 4398044413952L) >> 21)), 0);
        if (a4 < this.f3842c) {
            int c3 = c();
            if (c3 == 1 && this.f3842c > 1) {
                c();
            }
            if (c3 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean s(a aVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = aVar.controlState;
        }
        return aVar.r(j3);
    }

    private final boolean t() {
        c j3;
        do {
            j3 = j();
            if (j3 == null) {
                return false;
            }
        } while (!c.f3850k.compareAndSet(j3, -1, 0));
        LockSupport.unpark(j3);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n(10000L);
    }

    public final h d(Runnable runnable, i iVar) {
        long a4 = l.f3881e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a4, iVar);
        }
        h hVar = (h) runnable;
        hVar.f3873c = a4;
        hVar.f3874d = iVar;
        return hVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        h(this, runnable, null, false, 6, null);
    }

    public final void g(Runnable runnable, i iVar, boolean z3) {
        w2.c.a();
        h d3 = d(runnable, iVar);
        c f3 = f();
        h q3 = q(f3, d3, z3);
        if (q3 != null && !a(q3)) {
            throw new RejectedExecutionException(this.f3845g + " was terminated");
        }
        boolean z4 = z3 && f3 != null;
        if (d3.f3874d.b() != 0) {
            o(z4);
        } else {
            if (z4) {
                return;
            }
            p();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean k(c cVar) {
        long j3;
        int g3;
        if (cVar.h() != f3841o) {
            return false;
        }
        do {
            j3 = this.parkedWorkersStack;
            g3 = cVar.g();
            cVar.p(this.f3848j.b((int) (2097151 & j3)));
        } while (!f3838l.compareAndSet(this, j3, ((2097152 + j3) & (-2097152)) | g3));
        return true;
    }

    public final void l(c cVar, int i3, int i4) {
        while (true) {
            long j3 = this.parkedWorkersStack;
            int i5 = (int) (2097151 & j3);
            long j4 = (2097152 + j3) & (-2097152);
            if (i5 == i3) {
                i5 = i4 == 0 ? i(cVar) : i4;
            }
            if (i5 >= 0 && f3838l.compareAndSet(this, j3, j4 | i5)) {
                return;
            }
        }
    }

    public final void m(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void n(long j3) {
        int i3;
        h d3;
        if (f3840n.compareAndSet(this, 0, 1)) {
            c f3 = f();
            synchronized (this.f3848j) {
                i3 = (int) (this.controlState & 2097151);
            }
            if (1 <= i3) {
                int i4 = 1;
                while (true) {
                    c b4 = this.f3848j.b(i4);
                    kotlin.jvm.internal.k.b(b4);
                    c cVar = b4;
                    if (cVar != f3) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j3);
                        }
                        cVar.f3851c.g(this.f3847i);
                    }
                    if (i4 == i3) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            this.f3847i.b();
            this.f3846h.b();
            while (true) {
                if (f3 != null) {
                    d3 = f3.f(true);
                    if (d3 != null) {
                        continue;
                        m(d3);
                    }
                }
                d3 = this.f3846h.d();
                if (d3 == null && (d3 = this.f3847i.d()) == null) {
                    break;
                }
                m(d3);
            }
            if (f3 != null) {
                f3.s(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void p() {
        if (t() || s(this, 0L, 1, null)) {
            return;
        }
        t();
    }

    public String toString() {
        StringBuilder sb;
        char c3;
        ArrayList arrayList = new ArrayList();
        int a4 = this.f3848j.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a4; i8++) {
            c b4 = this.f3848j.b(i8);
            if (b4 != null) {
                int f3 = b4.f3851c.f();
                int i9 = b.f3849a[b4.f3852d.ordinal()];
                if (i9 != 1) {
                    if (i9 == 2) {
                        i4++;
                        sb = new StringBuilder();
                        sb.append(f3);
                        c3 = 'b';
                    } else if (i9 == 3) {
                        i3++;
                        sb = new StringBuilder();
                        sb.append(f3);
                        c3 = 'c';
                    } else if (i9 == 4) {
                        i6++;
                        if (f3 > 0) {
                            sb = new StringBuilder();
                            sb.append(f3);
                            c3 = 'd';
                        }
                    } else if (i9 == 5) {
                        i7++;
                    }
                    sb.append(c3);
                    arrayList.add(sb.toString());
                } else {
                    i5++;
                }
            }
        }
        long j3 = this.controlState;
        return this.f3845g + '@' + k0.b(this) + "[Pool Size {core = " + this.f3842c + ", max = " + this.f3843d + "}, Worker States {CPU = " + i3 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i6 + ", terminated = " + i7 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f3846h.c() + ", global blocking queue size = " + this.f3847i.c() + ", Control State {created workers= " + ((int) (2097151 & j3)) + ", blocking tasks = " + ((int) ((4398044413952L & j3) >> 21)) + ", CPUs acquired = " + (this.f3842c - ((int) ((9223367638808264704L & j3) >> 42))) + "}]";
    }
}
