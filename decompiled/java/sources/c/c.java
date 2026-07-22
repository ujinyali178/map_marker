package c;

import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public class c extends f {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f1589c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f1590d = new Executor() { // from class: c.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.g(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f1591e = new Executor() { // from class: c.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private f f1592a;

    /* renamed from: b, reason: collision with root package name */
    private final f f1593b;

    private c() {
        d dVar = new d();
        this.f1593b = dVar;
        this.f1592a = dVar;
    }

    public static c f() {
        if (f1589c != null) {
            return f1589c;
        }
        synchronized (c.class) {
            if (f1589c == null) {
                f1589c = new c();
            }
        }
        return f1589c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // c.f
    public void a(Runnable runnable) {
        this.f1592a.a(runnable);
    }

    @Override // c.f
    public boolean b() {
        return this.f1592a.b();
    }

    @Override // c.f
    public void c(Runnable runnable) {
        this.f1592a.c(runnable);
    }
}
