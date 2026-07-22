package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: /root/release/classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private boolean f743a;

    /* renamed from: b, reason: collision with root package name */
    private b f744b;

    /* renamed from: c, reason: collision with root package name */
    private Object f745c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f746d;

    static class a {
        static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface b {
        void onCancel();
    }

    private void c() {
        while (this.f746d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f743a) {
                return;
            }
            this.f743a = true;
            this.f746d = true;
            b bVar = this.f744b;
            Object obj = this.f745c;
            if (bVar != null) {
                try {
                    bVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f746d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                a.a(obj);
            }
            synchronized (this) {
                this.f746d = false;
                notifyAll();
            }
        }
    }

    public void b(b bVar) {
        synchronized (this) {
            c();
            if (this.f744b == bVar) {
                return;
            }
            this.f744b = bVar;
            if (this.f743a && bVar != null) {
                bVar.onCancel();
            }
        }
    }
}
