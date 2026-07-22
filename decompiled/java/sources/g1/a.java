package g1;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import k1.d;

/* loaded from: /root/release/classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static a f2535e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f2536f;

    /* renamed from: a, reason: collision with root package name */
    private d f2537a;

    /* renamed from: b, reason: collision with root package name */
    private j1.a f2538b;

    /* renamed from: c, reason: collision with root package name */
    private FlutterJNI.c f2539c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f2540d;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private d f2541a;

        /* renamed from: b, reason: collision with root package name */
        private j1.a f2542b;

        /* renamed from: c, reason: collision with root package name */
        private FlutterJNI.c f2543c;

        /* renamed from: d, reason: collision with root package name */
        private ExecutorService f2544d;

        /* renamed from: g1.a$b$a, reason: collision with other inner class name */
        private class ThreadFactoryC0076a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            private int f2545a;

            private ThreadFactoryC0076a() {
                this.f2545a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i3 = this.f2545a;
                this.f2545a = i3 + 1;
                sb.append(i3);
                thread.setName(sb.toString());
                return thread;
            }
        }

        private void b() {
            if (this.f2543c == null) {
                this.f2543c = new FlutterJNI.c();
            }
            if (this.f2544d == null) {
                this.f2544d = Executors.newCachedThreadPool(new ThreadFactoryC0076a());
            }
            if (this.f2541a == null) {
                this.f2541a = new d(this.f2543c.a(), this.f2544d);
            }
        }

        public a a() {
            b();
            return new a(this.f2541a, this.f2542b, this.f2543c, this.f2544d);
        }
    }

    private a(d dVar, j1.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f2537a = dVar;
        this.f2538b = aVar;
        this.f2539c = cVar;
        this.f2540d = executorService;
    }

    public static a e() {
        f2536f = true;
        if (f2535e == null) {
            f2535e = new b().a();
        }
        return f2535e;
    }

    public j1.a a() {
        return this.f2538b;
    }

    public ExecutorService b() {
        return this.f2540d;
    }

    public d c() {
        return this.f2537a;
    }

    public FlutterJNI.c d() {
        return this.f2539c;
    }
}
