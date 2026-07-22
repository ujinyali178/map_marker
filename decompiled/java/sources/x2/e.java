package x2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import g2.k;
import g2.l;

/* loaded from: /root/release/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4581a;
    private static volatile Choreographer choreographer;

    static {
        Object a4;
        try {
            k.a aVar = k.f2549c;
            a4 = k.a(new c(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            k.a aVar2 = k.f2549c;
            a4 = k.a(l.a(th));
        }
        f4581a = (d) (k.c(a4) ? null : a4);
    }

    public static final Handler a(Looper looper, boolean z3) {
        if (!z3) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (invoke != null) {
            return (Handler) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
