package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    protected AbstractLoadingCache() {
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final V apply(K k3) {
        return getUnchecked(k3);
    }

    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (K k3 : iterable) {
            if (!newLinkedHashMap.containsKey(k3)) {
                newLinkedHashMap.put(k3, get(k3));
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k3) {
        try {
            return get(k3);
        } catch (ExecutionException e3) {
            throw new UncheckedExecutionException(e3.getCause());
        }
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k3) {
        throw new UnsupportedOperationException();
    }
}
