package w2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: /root/release/classes2.dex */
public final class p0<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f4494g = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public p0(i2.g gVar, i2.d<? super T> dVar) {
        super(gVar, dVar);
        this._decision = 0;
    }

    private final boolean E0() {
        do {
            int i3 = this._decision;
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f4494g.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean F0() {
        do {
            int i3 = this._decision;
            if (i3 != 0) {
                if (i3 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f4494g.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.z, w2.s1
    protected void C(Object obj) {
        y0(obj);
    }

    public final Object D0() {
        Object c3;
        if (F0()) {
            c3 = j2.d.c();
            return c3;
        }
        Object h3 = t1.h(U());
        if (h3 instanceof v) {
            throw ((v) h3).f4525a;
        }
        return h3;
    }

    @Override // kotlinx.coroutines.internal.z, w2.a
    protected void y0(Object obj) {
        i2.d b4;
        if (E0()) {
            return;
        }
        b4 = j2.c.b(this.f3836f);
        kotlinx.coroutines.internal.g.c(b4, z.a(obj, this.f3836f), null, 2, null);
    }
}
