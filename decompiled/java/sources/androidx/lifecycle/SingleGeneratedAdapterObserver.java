package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public final class SingleGeneratedAdapterObserver implements g {

    /* renamed from: c, reason: collision with root package name */
    private final c f1269c;

    public SingleGeneratedAdapterObserver(c generatedAdapter) {
        kotlin.jvm.internal.k.e(generatedAdapter, "generatedAdapter");
        this.f1269c = generatedAdapter;
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        this.f1269c.a(source, event, false, null);
        this.f1269c.a(source, event, true, null);
    }
}
