package f1;

import android.content.Context;
import android.content.Intent;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import u1.l;
import u1.n;

/* loaded from: /root/release/classes.dex */
public final class e implements n.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f2521g = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final Context f2522c;

    /* renamed from: d, reason: collision with root package name */
    private l.d f2523d;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f2524f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public e(Context context) {
        k.e(context, "context");
        this.f2522c = context;
        this.f2524f = new AtomicBoolean(true);
    }

    private final void c(String str) {
        l.d dVar;
        if (!this.f2524f.compareAndSet(false, true) || (dVar = this.f2523d) == null) {
            return;
        }
        k.b(dVar);
        dVar.a(str);
        this.f2523d = null;
    }

    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        if (i3 != 22643) {
            return false;
        }
        c(SharePlusPendingIntent.f2477a.a());
        return true;
    }

    public final void b() {
        this.f2524f.set(true);
        this.f2523d = null;
    }

    public final void d(l.d callback) {
        l.d dVar;
        k.e(callback, "callback");
        if (!this.f2524f.compareAndSet(true, false) && (dVar = this.f2523d) != null) {
            dVar.a("dev.fluttercommunity.plus/share/unavailable");
        }
        SharePlusPendingIntent.f2477a.b("");
        this.f2524f.set(false);
        this.f2523d = callback;
    }

    public final void e() {
        c("dev.fluttercommunity.plus/share/unavailable");
    }
}
