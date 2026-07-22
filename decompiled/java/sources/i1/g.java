package i1;

import android.os.Handler;
import android.os.Looper;
import i1.c;

/* loaded from: /root/release/classes.dex */
public class g implements c.d {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2683a = e2.a.a(Looper.getMainLooper());

    @Override // i1.c.d
    public void a(Runnable runnable) {
        this.f2683a.post(runnable);
    }
}
