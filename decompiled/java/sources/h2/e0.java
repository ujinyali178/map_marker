package h2;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class e0 extends d0 {
    public static <K, V> Map<K, V> d() {
        y yVar = y.f2632c;
        kotlin.jvm.internal.k.c(yVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return yVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        Map<K, V> d3;
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : d0.c(map);
        }
        d3 = d();
        return d3;
    }

    public static final <K, V> void f(Map<? super K, ? super V> map, Iterable<? extends g2.j<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.k.e(map, "<this>");
        kotlin.jvm.internal.k.e(pairs, "pairs");
        for (g2.j<? extends K, ? extends V> jVar : pairs) {
            map.put(jVar.a(), jVar.b());
        }
    }

    public static <K, V> Map<K, V> g(Iterable<? extends g2.j<? extends K, ? extends V>> iterable) {
        Map<K, V> d3;
        int a4;
        kotlin.jvm.internal.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            d3 = d();
            return d3;
        }
        if (size == 1) {
            return d0.b(iterable instanceof List ? (g2.j<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        a4 = d0.a(collection.size());
        return h(iterable, new LinkedHashMap(a4));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends g2.j<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        f(destination, iterable);
        return destination;
    }

    public static <K, V> Map<K, V> i(Map<? extends K, ? extends V> map) {
        Map<K, V> d3;
        kotlin.jvm.internal.k.e(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? j(map) : d0.c(map);
        }
        d3 = d();
        return d3;
    }

    public static final <K, V> Map<K, V> j(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
