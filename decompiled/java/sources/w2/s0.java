package w2;

import java.util.concurrent.Executor;

/* loaded from: /root/release/classes2.dex */
final class s0 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public final c0 f4498c;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4498c.g(i2.h.f2693c, runnable);
    }

    public String toString() {
        return this.f4498c.toString();
    }
}
