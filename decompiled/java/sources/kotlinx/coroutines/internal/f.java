package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w2.c2;
import w2.k0;
import w2.q0;
import w2.w0;

/* loaded from: /root/release/classes2.dex */
public final class f<T> extends q0<T> implements kotlin.coroutines.jvm.internal.e, i2.d<T> {

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3783k = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: g, reason: collision with root package name */
    public final w2.c0 f3784g;

    /* renamed from: h, reason: collision with root package name */
    public final i2.d<T> f3785h;

    /* renamed from: i, reason: collision with root package name */
    public Object f3786i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3787j;

    /* JADX WARN: Multi-variable type inference failed */
    public f(w2.c0 c0Var, i2.d<? super T> dVar) {
        super(-1);
        b0 b0Var;
        this.f3784g = c0Var;
        this.f3785h = dVar;
        b0Var = g.f3795a;
        this.f3786i = b0Var;
        this.f3787j = f0.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final w2.l<?> l() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof w2.l) {
            return (w2.l) obj;
        }
        return null;
    }

    @Override // w2.q0
    public void a(Object obj, Throwable th) {
        if (obj instanceof w2.w) {
            ((w2.w) obj).f4528b.invoke(th);
        }
    }

    @Override // w2.q0
    public i2.d<T> c() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        i2.d<T> dVar = this.f3785h;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // i2.d
    public i2.g getContext() {
        return this.f3785h.getContext();
    }

    @Override // w2.q0
    public Object i() {
        b0 b0Var;
        Object obj = this.f3786i;
        b0Var = g.f3795a;
        this.f3786i = b0Var;
        return obj;
    }

    public final void j() {
        while (this._reusableCancellableContinuation == g.f3796b) {
        }
    }

    public final w2.l<T> k() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = g.f3796b;
                return null;
            }
            if (obj instanceof w2.l) {
                if (androidx.concurrent.futures.b.a(f3783k, this, obj, g.f3796b)) {
                    return (w2.l) obj;
                }
            } else if (obj != g.f3796b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean o() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean p(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            b0 b0Var = g.f3796b;
            if (kotlin.jvm.internal.k.a(obj, b0Var)) {
                if (androidx.concurrent.futures.b.a(f3783k, this, b0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.b.a(f3783k, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void q() {
        j();
        w2.l<?> l3 = l();
        if (l3 != null) {
            l3.r();
        }
    }

    public final Throwable r(w2.k<?> kVar) {
        b0 b0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            b0Var = g.f3796b;
            if (obj != b0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.b.a(f3783k, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.b.a(f3783k, this, b0Var, kVar));
        return null;
    }

    @Override // i2.d
    public void resumeWith(Object obj) {
        i2.g context = this.f3785h.getContext();
        Object d3 = w2.z.d(obj, null, 1, null);
        if (this.f3784g.m(context)) {
            this.f3786i = d3;
            this.f4495f = 0;
            this.f3784g.g(context, this);
            return;
        }
        w0 a4 = c2.f4452a.a();
        if (a4.C()) {
            this.f3786i = d3;
            this.f4495f = 0;
            a4.y(this);
            return;
        }
        a4.A(true);
        try {
            i2.g context2 = getContext();
            Object c3 = f0.c(context2, this.f3787j);
            try {
                this.f3785h.resumeWith(obj);
                g2.q qVar = g2.q.f2555a;
                while (a4.E()) {
                }
            } finally {
                f0.a(context2, c3);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f3784g + ", " + k0.c(this.f3785h) + ']';
    }
}
