package kotlinx.coroutines.scheduling;

import w2.k0;

/* loaded from: /root/release/classes2.dex */
public final class k extends h {

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f3876f;

    public k(Runnable runnable, long j3, i iVar) {
        super(j3, iVar);
        this.f3876f = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3876f.run();
        } finally {
            this.f3874d.a();
        }
    }

    public String toString() {
        return "Task[" + k0.a(this.f3876f) + '@' + k0.b(this.f3876f) + ", " + this.f3873c + ", " + this.f3874d + ']';
    }
}
