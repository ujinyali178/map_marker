package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@DoNotMock("Use CacheBuilder.newBuilder().build()")
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Cache<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k3, Callable<? extends V> callable);

    ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable);

    @CheckForNull
    V getIfPresent(Object obj);

    void invalidate(Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> iterable);

    void put(K k3, V v3);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    CacheStats stats();
}
