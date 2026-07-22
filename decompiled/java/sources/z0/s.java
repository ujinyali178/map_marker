package z0;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /root/release/classes.dex */
class s implements o {

    /* renamed from: a, reason: collision with root package name */
    final String f4797a;

    /* renamed from: b, reason: collision with root package name */
    final int f4798b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f4799c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f4800d;

    s(String str, int i3) {
        this.f4797a = str;
        this.f4798b = i3;
    }

    @Override // z0.o
    public void a() {
        HandlerThread handlerThread = this.f4799c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f4799c = null;
            this.f4800d = null;
        }
    }

    @Override // z0.o
    public /* synthetic */ void b(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    @Override // z0.o
    public void c(k kVar) {
        this.f4800d.post(kVar.f4777b);
    }

    @Override // z0.o
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f4797a, this.f4798b);
        this.f4799c = handlerThread;
        handlerThread.start();
        this.f4800d = new Handler(this.f4799c.getLooper());
    }
}
