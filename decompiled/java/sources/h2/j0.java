package h2;

import java.util.Set;

/* loaded from: /root/release/classes.dex */
class j0 extends i0 {
    public static <T> Set<T> b() {
        return z.f2633c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        Set<T> b4;
        kotlin.jvm.internal.k.e(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : i0.a(set.iterator().next());
        }
        b4 = b();
        return b4;
    }
}
