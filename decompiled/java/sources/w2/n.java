package w2;

/* loaded from: /root/release/classes2.dex */
public final class n {
    public static final <T> l<T> a(i2.d<? super T> dVar) {
        if (!(dVar instanceof kotlinx.coroutines.internal.f)) {
            return new l<>(dVar, 1);
        }
        l<T> k3 = ((kotlinx.coroutines.internal.f) dVar).k();
        if (k3 != null) {
            if (!k3.G()) {
                k3 = null;
            }
            if (k3 != null) {
                return k3;
            }
        }
        return new l<>(dVar, 2);
    }
}
