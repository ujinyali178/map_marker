package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    private MapBuilder(int i3) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i3);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i3) {
        return new MapBuilder<>(i3);
    }

    public Map<K, V> build() {
        return this.contributions.size() != 0 ? Collections.unmodifiableMap(this.contributions) : Collections.emptyMap();
    }

    public MapBuilder<K, V> put(K k3, V v3) {
        this.contributions.put(k3, v3);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }
}
