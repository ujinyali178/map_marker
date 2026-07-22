package z1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public final class d {

    static final class a implements Executor {

        /* renamed from: c, reason: collision with root package name */
        private static final Handler f4832c = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f4832c.post(runnable);
        }
    }

    public static Executor a() {
        return new a();
    }
}
