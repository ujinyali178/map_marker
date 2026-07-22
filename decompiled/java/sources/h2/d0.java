package h2;

import java.util.Collections;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
class d0 extends c0 {
    public static int a(int i3) {
        if (i3 < 0) {
            return i3;
        }
        if (i3 < 3) {
            return i3 + 1;
        }
        if (i3 < 1073741824) {
            return (int) ((i3 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> b(g2.j<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.k.e(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.k.d(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.k.d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
