package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /root/release/classes.dex */
abstract class c<Result> {

    /* renamed from: h, reason: collision with root package name */
    private static Handler f1361h;

    /* renamed from: d, reason: collision with root package name */
    private volatile e f1363d = e.PENDING;

    /* renamed from: f, reason: collision with root package name */
    final AtomicBoolean f1364f = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    final AtomicBoolean f1365g = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    private final FutureTask<Result> f1362c = new b(new a());

    class a implements Callable<Result> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            c.this.f1365g.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) c.this.b();
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    class b extends FutureTask<Result> {
        b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                c.this.j(get());
            } catch (InterruptedException e3) {
                Log.w("AsyncTask", e3);
            } catch (CancellationException unused) {
                c.this.j(null);
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e4.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: androidx.loader.content.c$c, reason: collision with other inner class name */
    class RunnableC0032c implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f1368c;

        RunnableC0032c(Object obj) {
            this.f1368c = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f1368c);
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1370a;

        static {
            int[] iArr = new int[e.values().length];
            f1370a = iArr;
            try {
                iArr[e.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1370a[e.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum e {
        PENDING,
        RUNNING,
        FINISHED
    }

    c() {
    }

    private static Handler e() {
        Handler handler;
        synchronized (c.class) {
            if (f1361h == null) {
                f1361h = new Handler(Looper.getMainLooper());
            }
            handler = f1361h;
        }
        return handler;
    }

    public final boolean a(boolean z3) {
        this.f1364f.set(true);
        return this.f1362c.cancel(z3);
    }

    protected abstract Result b();

    public final void c(Executor executor) {
        if (this.f1363d == e.PENDING) {
            this.f1363d = e.RUNNING;
            executor.execute(this.f1362c);
            return;
        }
        int i3 = d.f1370a[this.f1363d.ordinal()];
        if (i3 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i3 == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("We should never reach this state");
    }

    void d(Result result) {
        if (f()) {
            g(result);
        } else {
            h(result);
        }
        this.f1363d = e.FINISHED;
    }

    public final boolean f() {
        return this.f1364f.get();
    }

    protected void g(Result result) {
    }

    protected void h(Result result) {
    }

    void i(Result result) {
        e().post(new RunnableC0032c(result));
    }

    void j(Result result) {
        if (this.f1365g.get()) {
            return;
        }
        i(result);
    }
}
