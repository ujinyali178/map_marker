package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public final class CompositeGeneratedAdaptersObserver implements g {

    /* renamed from: c, reason: collision with root package name */
    private final c[] f1235c;

    public CompositeGeneratedAdaptersObserver(c[] generatedAdapters) {
        kotlin.jvm.internal.k.e(generatedAdapters, "generatedAdapters");
        this.f1235c = generatedAdapters;
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        m mVar = new m();
        for (c cVar : this.f1235c) {
            cVar.a(source, event, false, mVar);
        }
        for (c cVar2 : this.f1235c) {
            cVar2.a(source, event, true, mVar);
        }
    }
}
