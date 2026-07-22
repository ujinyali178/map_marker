package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: /root/release/classes.dex */
public final class SavedStateHandleController implements g {

    /* renamed from: c, reason: collision with root package name */
    private final String f1266c;

    /* renamed from: d, reason: collision with root package name */
    private final t f1267d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1268f;

    public SavedStateHandleController(String key, t handle) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(handle, "handle");
        this.f1266c = key;
        this.f1267d = handle;
    }

    public final void a(androidx.savedstate.a registry, e lifecycle) {
        kotlin.jvm.internal.k.e(registry, "registry");
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        if (!(!this.f1268f)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.f1268f = true;
        lifecycle.a(this);
        registry.h(this.f1266c, this.f1267d.c());
    }

    public final t b() {
        return this.f1267d;
    }

    @Override // androidx.lifecycle.g
    public void e(i source, e.a event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        if (event == e.a.ON_DESTROY) {
            this.f1268f = false;
            source.getLifecycle().c(this);
        }
    }

    public final boolean g() {
        return this.f1268f;
    }
}
