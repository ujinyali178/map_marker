package z0;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: /root/release/classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f4780a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4781b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f4782c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f4783d;

    /* renamed from: e, reason: collision with root package name */
    protected Runnable f4784e;

    /* renamed from: f, reason: collision with root package name */
    private k f4785f;

    m(String str, int i3) {
        this.f4780a = str;
        this.f4781b = i3;
    }

    boolean b() {
        k kVar = this.f4785f;
        return kVar != null && kVar.b();
    }

    Integer d() {
        k kVar = this.f4785f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    void e(final k kVar) {
        this.f4783d.post(new Runnable() { // from class: z0.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(kVar);
            }
        });
    }

    synchronized void f() {
        HandlerThread handlerThread = this.f4782c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f4782c = null;
            this.f4783d = null;
        }
    }

    synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f4780a, this.f4781b);
        this.f4782c = handlerThread;
        handlerThread.start();
        this.f4783d = new Handler(this.f4782c.getLooper());
        this.f4784e = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(k kVar) {
        kVar.f4777b.run();
        this.f4785f = kVar;
        this.f4784e.run();
    }
}
