package kotlinx.coroutines.scheduling;

import com.google.common.util.concurrent.g0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: /root/release/classes2.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3885b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3886c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3887d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f3888e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<h> f3889a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(n nVar, h hVar, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return nVar.a(hVar, z3);
    }

    private final h c(h hVar) {
        if (hVar.f3874d.b() == 1) {
            f3888e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i3 = this.producerIndex & 127;
        while (this.f3889a.get(i3) != null) {
            Thread.yield();
        }
        this.f3889a.lazySet(i3, hVar);
        f3886c.incrementAndGet(this);
        return null;
    }

    private final void d(h hVar) {
        if (hVar != null) {
            if (hVar.f3874d.b() == 1) {
                f3888e.decrementAndGet(this);
            }
        }
    }

    private final h i() {
        h andSet;
        while (true) {
            int i3 = this.consumerIndex;
            if (i3 - this.producerIndex == 0) {
                return null;
            }
            int i4 = i3 & 127;
            if (f3887d.compareAndSet(this, i3, i3 + 1) && (andSet = this.f3889a.getAndSet(i4, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        h i3 = i();
        if (i3 == null) {
            return false;
        }
        dVar.a(i3);
        return true;
    }

    private final long m(n nVar, boolean z3) {
        h hVar;
        do {
            hVar = (h) nVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z3) {
                if (!(hVar.f3874d.b() == 1)) {
                    return -2L;
                }
            }
            long a4 = l.f3881e.a() - hVar.f3873c;
            long j3 = l.f3877a;
            if (a4 < j3) {
                return j3 - a4;
            }
        } while (!androidx.concurrent.futures.b.a(f3885b, nVar, hVar, null));
        b(this, hVar, false, 2, null);
        return -1L;
    }

    public final h a(h hVar, boolean z3) {
        if (z3) {
            return c(hVar);
        }
        h hVar2 = (h) f3885b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        h hVar = (h) f3885b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h h() {
        h hVar = (h) f3885b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final long k(n nVar) {
        int i3 = nVar.consumerIndex;
        int i4 = nVar.producerIndex;
        AtomicReferenceArray<h> atomicReferenceArray = nVar.f3889a;
        while (true) {
            if (i3 == i4) {
                break;
            }
            int i5 = i3 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = atomicReferenceArray.get(i5);
            if (hVar != null) {
                if ((hVar.f3874d.b() == 1) && g0.a(atomicReferenceArray, i5, hVar, null)) {
                    f3888e.decrementAndGet(nVar);
                    b(this, hVar, false, 2, null);
                    return -1L;
                }
            }
            i3++;
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        h i3 = nVar.i();
        if (i3 == null) {
            return m(nVar, false);
        }
        b(this, i3, false, 2, null);
        return -1L;
    }
}
