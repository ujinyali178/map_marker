package p;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import p.a;

/* loaded from: /root/release/classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d(a initialExtras) {
        k.e(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ d(a aVar, int i3, g gVar) {
        this((i3 & 1) != 0 ? a.C0101a.f4080b : aVar);
    }

    @Override // p.a
    public <T> T a(a.b<T> key) {
        k.e(key, "key");
        return (T) b().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(a.b<T> key, T t3) {
        k.e(key, "key");
        b().put(key, t3);
    }
}
