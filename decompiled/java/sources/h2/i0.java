package h2;

import java.util.Collections;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
class i0 {
    public static final <T> Set<T> a(T t3) {
        Set<T> singleton = Collections.singleton(t3);
        kotlin.jvm.internal.k.d(singleton, "singleton(element)");
        return singleton;
    }
}
