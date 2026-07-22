package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: /root/release/classes2.dex */
public class p<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3816a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public p(boolean z3) {
        this._cur = new q(8, z3);
    }

    public final boolean a(E e3) {
        while (true) {
            q qVar = (q) this._cur;
            int a4 = qVar.a(e3);
            if (a4 == 0) {
                return true;
            }
            if (a4 == 1) {
                androidx.concurrent.futures.b.a(f3816a, this, qVar, qVar.i());
            } else if (a4 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            q qVar = (q) this._cur;
            if (qVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.b.a(f3816a, this, qVar, qVar.i());
            }
        }
    }

    public final int c() {
        return ((q) this._cur).f();
    }

    public final E d() {
        while (true) {
            q qVar = (q) this._cur;
            E e3 = (E) qVar.j();
            if (e3 != q.f3820h) {
                return e3;
            }
            androidx.concurrent.futures.b.a(f3816a, this, qVar, qVar.i());
        }
    }
}
