package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.apache.commons.io.FileUtils;

/* loaded from: /root/release/classes2.dex */
public final class q<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a, reason: collision with root package name */
    private final int f3821a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3822b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3823c;

    /* renamed from: d, reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f3824d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f3817e = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f3820h = new b0("REMOVE_FROZEN");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3818f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f3819g = AtomicLongFieldUpdater.newUpdater(q.class, "_state");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a(long j3) {
            return (j3 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j3, int i3) {
            return d(j3, 1073741823L) | (i3 << 0);
        }

        public final long c(long j3, int i3) {
            return d(j3, 1152921503533105152L) | (i3 << 30);
        }

        public final long d(long j3, long j4) {
            return j3 & (~j4);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3825a;

        public b(int i3) {
            this.f3825a = i3;
        }
    }

    public q(int i3, boolean z3) {
        this.f3821a = i3;
        this.f3822b = z3;
        int i4 = i3 - 1;
        this.f3823c = i4;
        this.f3824d = new AtomicReferenceArray(i3);
        if (!(i4 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i3 & i4) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final q<E> b(long j3) {
        q<E> qVar = new q<>(this.f3821a * 2, this.f3822b);
        int i3 = (int) ((1073741823 & j3) >> 0);
        int i4 = (int) ((1152921503533105152L & j3) >> 30);
        while (true) {
            int i5 = this.f3823c;
            if ((i3 & i5) == (i4 & i5)) {
                qVar._state = f3817e.d(j3, FileUtils.ONE_EB);
                return qVar;
            }
            Object obj = this.f3824d.get(i5 & i3);
            if (obj == null) {
                obj = new b(i3);
            }
            qVar.f3824d.set(qVar.f3823c & i3, obj);
            i3++;
        }
    }

    private final q<E> c(long j3) {
        while (true) {
            q<E> qVar = (q) this._next;
            if (qVar != null) {
                return qVar;
            }
            androidx.concurrent.futures.b.a(f3818f, this, null, b(j3));
        }
    }

    private final q<E> e(int i3, E e3) {
        Object obj = this.f3824d.get(this.f3823c & i3);
        if (!(obj instanceof b) || ((b) obj).f3825a != i3) {
            return null;
        }
        this.f3824d.set(i3 & this.f3823c, e3);
        return this;
    }

    private final long h() {
        long j3;
        long j4;
        do {
            j3 = this._state;
            if ((j3 & FileUtils.ONE_EB) != 0) {
                return j3;
            }
            j4 = j3 | FileUtils.ONE_EB;
        } while (!f3819g.compareAndSet(this, j3, j4));
        return j4;
    }

    private final q<E> k(int i3, int i4) {
        long j3;
        int i5;
        do {
            j3 = this._state;
            i5 = (int) ((1073741823 & j3) >> 0);
            if ((FileUtils.ONE_EB & j3) != 0) {
                return i();
            }
        } while (!f3819g.compareAndSet(this, j3, f3817e.b(j3, i4)));
        this.f3824d.set(i5 & this.f3823c, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.q$a r13 = kotlinx.coroutines.internal.q.f3817e
            int r13 = r13.a(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.f3823c
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            r5 = 1
            if (r0 != r4) goto L2f
            return r5
        L2f:
            boolean r0 = r12.f3822b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4e
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f3824d
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L4e
            int r0 = r12.f3821a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4d
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4d:
            return r5
        L4e:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.q.f3819g
            kotlinx.coroutines.internal.q$a r4 = kotlinx.coroutines.internal.q.f3817e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f3824d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L7c
            kotlinx.coroutines.internal.q r0 = r0.i()
            kotlinx.coroutines.internal.q r0 = r0.e(r9, r13)
            if (r0 != 0) goto L69
        L7c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.q.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j3;
        do {
            j3 = this._state;
            if ((j3 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((FileUtils.ONE_EB & j3) != 0) {
                return false;
            }
        } while (!f3819g.compareAndSet(this, j3, j3 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j3 = this._state;
        return 1073741823 & (((int) ((j3 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j3) >> 0)));
    }

    public final boolean g() {
        long j3 = this._state;
        return ((int) ((1073741823 & j3) >> 0)) == ((int) ((j3 & 1152921503533105152L) >> 30));
    }

    public final q<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j3 = this._state;
            if ((FileUtils.ONE_EB & j3) != 0) {
                return f3820h;
            }
            int i3 = (int) ((1073741823 & j3) >> 0);
            int i4 = (int) ((1152921503533105152L & j3) >> 30);
            int i5 = this.f3823c;
            if ((i4 & i5) == (i3 & i5)) {
                return null;
            }
            Object obj = this.f3824d.get(i5 & i3);
            if (obj == null) {
                if (this.f3822b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i6 = (i3 + 1) & 1073741823;
                if (f3819g.compareAndSet(this, j3, f3817e.b(j3, i6))) {
                    this.f3824d.set(this.f3823c & i3, null);
                    return obj;
                }
                if (this.f3822b) {
                    q<E> qVar = this;
                    do {
                        qVar = qVar.k(i3, i6);
                    } while (qVar != null);
                    return obj;
                }
            }
        }
    }
}
