package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: /root/release/classes.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> contributingMap;

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        Builder(int i3) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        Builder<K, V, V2> put(K k3, Provider<V> provider) {
            this.map.put(Preconditions.checkNotNull(k3, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) provider).contributingMap);
            return this;
        }
    }

    AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }
}
