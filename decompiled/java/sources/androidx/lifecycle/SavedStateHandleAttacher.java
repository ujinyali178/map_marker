package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public final class SavedStateHandleAttacher implements g {

    /* renamed from: c, reason: collision with root package name */
    private final v f1265c;

    public SavedStateHandleAttacher(v provider) {
        kotlin.jvm.internal.k.e(provider, "provider");
        this.f1265c = provider;
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        if (event == e.a.ON_CREATE) {
            source.getLifecycle().c(this);
            this.f1265c.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
