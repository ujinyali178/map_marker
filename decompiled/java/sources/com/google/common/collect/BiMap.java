package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface BiMap<K, V> extends Map<K, V> {
    @CheckForNull
    V forcePut(@ParametricNullness K k3, @ParametricNullness V v3);

    BiMap<V, K> inverse();

    @CheckForNull
    V put(@ParametricNullness K k3, @ParametricNullness V v3);

    void putAll(Map<? extends K, ? extends V> map);

    /* bridge */ /* synthetic */ Collection values();

    @Override // java.util.Map
    Set<V> values();
}
