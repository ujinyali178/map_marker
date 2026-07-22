package y2;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.b0;

/* loaded from: /root/release/classes2.dex */
public class d<E> extends y2.a<E> {

    /* renamed from: e, reason: collision with root package name */
    private final int f4693e;

    /* renamed from: f, reason: collision with root package name */
    private final e f4694f;

    /* renamed from: g, reason: collision with root package name */
    private final ReentrantLock f4695g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f4696h;

    /* renamed from: i, reason: collision with root package name */
    private int f4697i;
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4698a;

        static {
            int[] iArr = new int[e.values().length];
            iArr[e.SUSPEND.ordinal()] = 1;
            iArr[e.DROP_LATEST.ordinal()] = 2;
            iArr[e.DROP_OLDEST.ordinal()] = 3;
            f4698a = iArr;
        }
    }

    public d(int i3, e eVar, p2.l<? super E, g2.q> lVar) {
        super(lVar);
        this.f4693e = i3;
        this.f4694f = eVar;
        if (!(i3 >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i3 + " was specified").toString());
        }
        this.f4695g = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i3, 8)];
        h2.i.g(objArr, b.f4683a, 0, 0, 6, null);
        this.f4696h = objArr;
        this.size = 0;
    }

    private final void x(int i3, E e3) {
        if (i3 < this.f4693e) {
            y(i3);
            Object[] objArr = this.f4696h;
            objArr[(this.f4697i + i3) % objArr.length] = e3;
        } else {
            Object[] objArr2 = this.f4696h;
            int i4 = this.f4697i;
            objArr2[i4 % objArr2.length] = null;
            objArr2[(i3 + i4) % objArr2.length] = e3;
            this.f4697i = (i4 + 1) % objArr2.length;
        }
    }

    private final void y(int i3) {
        Object[] objArr = this.f4696h;
        if (i3 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f4693e);
            Object[] objArr2 = new Object[min];
            for (int i4 = 0; i4 < i3; i4++) {
                Object[] objArr3 = this.f4696h;
                objArr2[i4] = objArr3[(this.f4697i + i4) % objArr3.length];
            }
            h2.i.f(objArr2, b.f4683a, i3, min);
            this.f4696h = objArr2;
            this.f4697i = 0;
        }
    }

    private final b0 z(int i3) {
        if (i3 < this.f4693e) {
            this.size = i3 + 1;
            return null;
        }
        int i4 = a.f4698a[this.f4694f.ordinal()];
        if (i4 == 1) {
            return b.f4685c;
        }
        if (i4 == 2) {
            return b.f4684b;
        }
        if (i4 == 3) {
            return null;
        }
        throw new g2.i();
    }

    @Override // y2.c
    protected String c() {
        return "(buffer:capacity=" + this.f4693e + ",size=" + this.size + ')';
    }

    @Override // y2.c
    protected Object i(E e3) {
        q<E> l3;
        ReentrantLock reentrantLock = this.f4695g;
        reentrantLock.lock();
        try {
            int i3 = this.size;
            j<?> d3 = d();
            if (d3 != null) {
                return d3;
            }
            b0 z3 = z(i3);
            if (z3 != null) {
                return z3;
            }
            if (i3 == 0) {
                do {
                    l3 = l();
                    if (l3 != null) {
                        if (l3 instanceof j) {
                            this.size = i3;
                            return l3;
                        }
                        kotlin.jvm.internal.k.b(l3);
                    }
                } while (l3.g(e3, null) == null);
                this.size = i3;
                g2.q qVar = g2.q.f2555a;
                reentrantLock.unlock();
                l3.f(e3);
                return l3.b();
            }
            x(i3, e3);
            return b.f4684b;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y2.a
    protected boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f4695g;
        reentrantLock.lock();
        try {
            return super.q(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y2.a
    protected final boolean r() {
        return false;
    }

    @Override // y2.a
    protected final boolean s() {
        return this.size == 0;
    }

    @Override // y2.a
    protected Object v() {
        ReentrantLock reentrantLock = this.f4695g;
        reentrantLock.lock();
        try {
            int i3 = this.size;
            if (i3 == 0) {
                Object d3 = d();
                if (d3 == null) {
                    d3 = b.f4686d;
                }
                return d3;
            }
            Object[] objArr = this.f4696h;
            int i4 = this.f4697i;
            Object obj = objArr[i4];
            s sVar = null;
            objArr[i4] = null;
            this.size = i3 - 1;
            Object obj2 = b.f4686d;
            boolean z3 = false;
            if (i3 == this.f4693e) {
                s sVar2 = null;
                while (true) {
                    s m3 = m();
                    if (m3 == null) {
                        sVar = sVar2;
                        break;
                    }
                    kotlin.jvm.internal.k.b(m3);
                    if (m3.z(null) != null) {
                        obj2 = m3.y();
                        sVar = m3;
                        z3 = true;
                        break;
                    }
                    m3.A();
                    sVar2 = m3;
                }
            }
            if (obj2 != b.f4686d && !(obj2 instanceof j)) {
                this.size = i3;
                Object[] objArr2 = this.f4696h;
                objArr2[(this.f4697i + i3) % objArr2.length] = obj2;
            }
            this.f4697i = (this.f4697i + 1) % this.f4696h.length;
            g2.q qVar = g2.q.f2555a;
            if (z3) {
                kotlin.jvm.internal.k.b(sVar);
                sVar.x();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
