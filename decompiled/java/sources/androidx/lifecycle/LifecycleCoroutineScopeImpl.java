package androidx.lifecycle;

import androidx.lifecycle.e;
import w2.q1;

/* loaded from: /root/release/classes.dex */
public final class LifecycleCoroutineScopeImpl extends f implements g {

    /* renamed from: c, reason: collision with root package name */
    private final e f1242c;

    /* renamed from: d, reason: collision with root package name */
    private final i2.g f1243d;

    public e a() {
        return this.f1242c;
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        if (a().b().compareTo(e.b.DESTROYED) <= 0) {
            a().c(this);
            q1.d(p(), null, 1, null);
        }
    }

    @Override // w2.g0
    public i2.g p() {
        return this.f1243d;
    }
}
