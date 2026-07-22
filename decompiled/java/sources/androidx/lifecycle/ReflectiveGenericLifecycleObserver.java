package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.e;

@Deprecated
/* loaded from: /root/release/classes.dex */
class ReflectiveGenericLifecycleObserver implements g {

    /* renamed from: c, reason: collision with root package name */
    private final Object f1263c;

    /* renamed from: d, reason: collision with root package name */
    private final b.a f1264d;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1263c = obj;
        this.f1264d = b.f1282c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.g
    public void e(i iVar, e.a aVar) {
        this.f1264d.a(iVar, aVar, this.f1263c);
    }
}
