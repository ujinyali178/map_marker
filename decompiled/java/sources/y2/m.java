package y2;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.v;

/* loaded from: /root/release/classes2.dex */
public class m<E> extends a<E> {

    /* renamed from: e, reason: collision with root package name */
    private final ReentrantLock f4710e;

    /* renamed from: f, reason: collision with root package name */
    private Object f4711f;

    public m(p2.l<? super E, g2.q> lVar) {
        super(lVar);
        this.f4710e = new ReentrantLock();
        this.f4711f = b.f4683a;
    }

    private final j0 x(Object obj) {
        p2.l<E, g2.q> lVar;
        Object obj2 = this.f4711f;
        j0 j0Var = null;
        if (obj2 != b.f4683a && (lVar = this.f4690b) != null) {
            j0Var = v.d(lVar, obj2, null, 2, null);
        }
        this.f4711f = obj;
        return j0Var;
    }

    @Override // y2.c
    protected String c() {
        ReentrantLock reentrantLock = this.f4710e;
        reentrantLock.lock();
        try {
            return "(value=" + this.f4711f + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y2.c
    protected Object i(E e3) {
        q<E> l3;
        ReentrantLock reentrantLock = this.f4710e;
        reentrantLock.lock();
        try {
            j<?> d3 = d();
            if (d3 != null) {
                return d3;
            }
            if (this.f4711f == b.f4683a) {
                do {
                    l3 = l();
                    if (l3 != null) {
                        if (l3 instanceof j) {
                            return l3;
                        }
                        kotlin.jvm.internal.k.b(l3);
                    }
                } while (l3.g(e3, null) == null);
                g2.q qVar = g2.q.f2555a;
                reentrantLock.unlock();
                l3.f(e3);
                return l3.b();
            }
            j0 x3 = x(e3);
            if (x3 == null) {
                return b.f4684b;
            }
            throw x3;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y2.a
    protected boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f4710e;
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
        ReentrantLock reentrantLock = this.f4710e;
        reentrantLock.lock();
        try {
            return this.f4711f == b.f4683a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // y2.a
    protected Object v() {
        ReentrantLock reentrantLock = this.f4710e;
        reentrantLock.lock();
        try {
            Object obj = this.f4711f;
            b0 b0Var = b.f4683a;
            if (obj != b0Var) {
                this.f4711f = b0Var;
                g2.q qVar = g2.q.f2555a;
                return obj;
            }
            Object d3 = d();
            if (d3 == null) {
                d3 = b.f4686d;
            }
            return d3;
        } finally {
            reentrantLock.unlock();
        }
    }
}
