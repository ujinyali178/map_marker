package z1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import z1.c;

/* loaded from: /root/release/classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f4831a;

    public interface a<T> {
        void a(Future<T> future);
    }

    public c(int i3) {
        this.f4831a = new ThreadPoolExecutor(i3, i3, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(SettableFuture settableFuture, Callable callable) {
        if (settableFuture.isCancelled()) {
            return;
        }
        try {
            settableFuture.set(callable.call());
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    public <T> ListenableFuture<T> e(final Callable<T> callable) {
        final SettableFuture create = SettableFuture.create();
        this.f4831a.execute(new Runnable() { // from class: z1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(SettableFuture.this, callable);
            }
        });
        return create;
    }

    public <T> void f(Callable<T> callable, final a<T> aVar) {
        final ListenableFuture<T> e3 = e(callable);
        e3.addListener(new Runnable() { // from class: z1.a
            @Override // java.lang.Runnable
            public final void run() {
                c.a.this.a(e3);
            }
        }, d.a());
    }
}
