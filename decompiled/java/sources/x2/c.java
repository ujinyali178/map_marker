package x2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import w2.p1;
import w2.t0;

/* loaded from: /root/release/classes2.dex */
public final class c extends d {
    private volatile c _immediate;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f4577f;

    /* renamed from: g, reason: collision with root package name */
    private final String f4578g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f4579h;

    /* renamed from: i, reason: collision with root package name */
    private final c f4580i;

    public c(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ c(Handler handler, String str, int i3, g gVar) {
        this(handler, (i3 & 2) != 0 ? null : str);
    }

    private c(Handler handler, String str, boolean z3) {
        super(null);
        this.f4577f = handler;
        this.f4578g = str;
        this.f4579h = z3;
        this._immediate = z3 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.f4580i = cVar;
    }

    private final void y(i2.g gVar, Runnable runnable) {
        p1.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        t0.b().g(gVar, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f4577f == this.f4577f;
    }

    @Override // w2.c0
    public void g(i2.g gVar, Runnable runnable) {
        if (this.f4577f.post(runnable)) {
            return;
        }
        y(gVar, runnable);
    }

    public int hashCode() {
        return System.identityHashCode(this.f4577f);
    }

    @Override // w2.c0
    public boolean m(i2.g gVar) {
        return (this.f4579h && k.a(Looper.myLooper(), this.f4577f.getLooper())) ? false : true;
    }

    @Override // w2.v1, w2.c0
    public String toString() {
        String w3 = w();
        if (w3 != null) {
            return w3;
        }
        String str = this.f4578g;
        if (str == null) {
            str = this.f4577f.toString();
        }
        if (!this.f4579h) {
            return str;
        }
        return str + ".immediate";
    }

    @Override // w2.v1
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public c p() {
        return this.f4580i;
    }
}
