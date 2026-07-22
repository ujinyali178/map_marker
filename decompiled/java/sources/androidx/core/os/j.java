package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: /root/release/classes.dex */
public final class j {

    private static class a implements Executor {

        /* renamed from: c, reason: collision with root package name */
        private final Handler f747c;

        a(Handler handler) {
            this.f747c = (Handler) androidx.core.util.d.e(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f747c.post((Runnable) androidx.core.util.d.e(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f747c + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
