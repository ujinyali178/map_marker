package q;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.savedstate.Recreator;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4088d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final d f4089a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.savedstate.a f4090b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4091c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(d owner) {
            k.e(owner, "owner");
            return new c(owner, null);
        }
    }

    private c(d dVar) {
        this.f4089a = dVar;
        this.f4090b = new androidx.savedstate.a();
    }

    public /* synthetic */ c(d dVar, g gVar) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f4088d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f4090b;
    }

    public final void c() {
        androidx.lifecycle.e lifecycle = this.f4089a.getLifecycle();
        if (!(lifecycle.b() == e.b.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new Recreator(this.f4089a));
        this.f4090b.e(lifecycle);
        this.f4091c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f4091c) {
            c();
        }
        androidx.lifecycle.e lifecycle = this.f4089a.getLifecycle();
        if (!lifecycle.b().b(e.b.STARTED)) {
            this.f4090b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        k.e(outBundle, "outBundle");
        this.f4090b.g(outBundle);
    }
}
