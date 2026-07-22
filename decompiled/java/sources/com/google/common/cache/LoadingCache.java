package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @Override // com.google.common.base.Function
    @Deprecated
    V apply(K k3);

    @Override // com.google.common.cache.Cache
    ConcurrentMap<K, V> asMap();

    V get(K k3);

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable);

    V getUnchecked(K k3);

    void refresh(K k3);
}
