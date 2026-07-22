package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@CheckForNull Object obj);

    /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    List<V> get(@ParametricNullness K k3);

    /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object obj);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    List<V> removeAll(@CheckForNull Object obj);

    /* bridge */ /* synthetic */ Collection replaceValues(@ParametricNullness Object obj, Iterable iterable);

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    List<V> replaceValues(@ParametricNullness K k3, Iterable<? extends V> iterable);
}
