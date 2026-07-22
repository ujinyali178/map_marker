package com.google.common.collect;

import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @ParametricNullness
    final K key;

    @ParametricNullness
    final V value;

    ImmutableEntry(@ParametricNullness K k3, @ParametricNullness V v3) {
        this.key = k3;
        this.value = v3;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @ParametricNullness
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @ParametricNullness
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @ParametricNullness
    public final V setValue(@ParametricNullness V v3) {
        throw new UnsupportedOperationException();
    }
}
