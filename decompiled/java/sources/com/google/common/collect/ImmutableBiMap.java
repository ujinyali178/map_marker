package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        Builder(int i3) {
            super(i3);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @Deprecated
        public ImmutableBiMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> buildOrThrow() {
            int i3 = this.size;
            if (i3 == 0) {
                return ImmutableBiMap.of();
            }
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, i3 * 2);
                }
                ImmutableMap.Builder.sortEntries(this.alternatingKeysAndValues, this.size, this.valueComparator);
            }
            this.entriesUsed = true;
            return new RegularImmutableBiMap(this.alternatingKeysAndValues, this.size);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> combine(ImmutableMap.Builder<K, V> builder) {
            super.combine((ImmutableMap.Builder) builder);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(K k3, V v3) {
            super.put((Builder<K, V>) k3, (K) v3);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }
    }

    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Builder<K, V> makeBuilder(int i3) {
            return new Builder<>(i3);
        }
    }

    ImmutableBiMap() {
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int i3) {
        CollectPreconditions.checkNonnegative(i3, "expectedSize");
        return new Builder<>(i3);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        return new RegularImmutableBiMap(new Object[]{k3, v3}, 1);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4}, 2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6, k7, v7}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        CollectPreconditions.checkEntryNotNull(k9, v9);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        CollectPreconditions.checkEntryNotNull(k9, v9);
        CollectPreconditions.checkEntryNotNull(k10, v10);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        CollectPreconditions.checkEntryNotNull(k9, v9);
        CollectPreconditions.checkEntryNotNull(k10, v10);
        CollectPreconditions.checkEntryNotNull(k11, v11);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11, K k12, V v12) {
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        CollectPreconditions.checkEntryNotNull(k9, v9);
        CollectPreconditions.checkEntryNotNull(k10, v10);
        CollectPreconditions.checkEntryNotNull(k11, v11);
        CollectPreconditions.checkEntryNotNull(k12, v12);
        return new RegularImmutableBiMap(new Object[]{k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10, k11, v11, k12, v12}, 10);
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    @Deprecated
    public final V forcePut(K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
