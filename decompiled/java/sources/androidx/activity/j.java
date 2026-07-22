package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f286a;

    /* renamed from: b, reason: collision with root package name */
    private final p2.a<g2.q> f287b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f288c;

    /* renamed from: d, reason: collision with root package name */
    private int f289d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f290e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f291f;

    /* renamed from: g, reason: collision with root package name */
    private final List<p2.a<g2.q>> f292g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f293h;

    public j(Executor executor, p2.a<g2.q> reportFullyDrawn) {
        kotlin.jvm.internal.k.e(executor, "executor");
        kotlin.jvm.internal.k.e(reportFullyDrawn, "reportFullyDrawn");
        this.f286a = executor;
        this.f287b = reportFullyDrawn;
        this.f288c = new Object();
        this.f292g = new ArrayList();
        this.f293h = new Runnable() { // from class: androidx.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                j.d(j.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(j this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        synchronized (this$0.f288c) {
            this$0.f290e = false;
            if (this$0.f289d == 0 && !this$0.f291f) {
                this$0.f287b.invoke();
                this$0.b();
            }
            g2.q qVar = g2.q.f2555a;
        }
    }

    public final void b() {
        synchronized (this.f288c) {
            this.f291f = true;
            Iterator<T> it = this.f292g.iterator();
            while (it.hasNext()) {
                ((p2.a) it.next()).invoke();
            }
            this.f292g.clear();
            g2.q qVar = g2.q.f2555a;
        }
    }

    public final boolean c() {
        boolean z3;
        synchronized (this.f288c) {
            z3 = this.f291f;
        }
        return z3;
    }
}
