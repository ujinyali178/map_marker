package w2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: /root/release/classes2.dex */
final class j1 extends n1 {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f4474i = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: h, reason: collision with root package name */
    private final p2.l<Throwable, g2.q> f4475h;

    /* JADX WARN: Multi-variable type inference failed */
    public j1(p2.l<? super Throwable, g2.q> lVar) {
        this.f4475h = lVar;
    }

    @Override // p2.l
    public /* bridge */ /* synthetic */ g2.q invoke(Throwable th) {
        x(th);
        return g2.q.f2555a;
    }

    @Override // w2.x
    public void x(Throwable th) {
        if (f4474i.compareAndSet(this, 0, 1)) {
            this.f4475h.invoke(th);
        }
    }
}
