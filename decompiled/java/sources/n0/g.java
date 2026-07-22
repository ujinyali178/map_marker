package n0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public abstract class g {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4063c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Handler f4064d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private static final ExecutorService f4065e;

    /* renamed from: a, reason: collision with root package name */
    private l.d f4066a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4067b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final ExecutorService a() {
            return g.f4065e;
        }
    }

    static {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(8);
        k.d(newFixedThreadPool, "newFixedThreadPool(8)");
        f4065e = newFixedThreadPool;
    }

    public g(l.d dVar) {
        this.f4066a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(l.d dVar, Object obj) {
        if (dVar != null) {
            dVar.a(obj);
        }
    }

    public final void c(final Object obj) {
        if (this.f4067b) {
            return;
        }
        this.f4067b = true;
        final l.d dVar = this.f4066a;
        this.f4066a = null;
        f4064d.post(new Runnable() { // from class: n0.f
            @Override // java.lang.Runnable
            public final void run() {
                g.d(l.d.this, obj);
            }
        });
    }
}
