package com.google.common.cache;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Weigher<K, V> {
    int weigh(K k3, V v3);
}
