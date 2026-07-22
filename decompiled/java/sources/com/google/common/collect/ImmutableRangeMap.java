package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    @DoNotMock
    public static final class Builder<K extends Comparable<?>, V> {
        private final List<Map.Entry<Range<K>, V>> entries = Lists.newArrayList();

        public ImmutableRangeMap<K, V> build() {
            Collections.sort(this.entries, Range.rangeLexOrdering().onKeys());
            ImmutableList.Builder builder = new ImmutableList.Builder(this.entries.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(this.entries.size());
            for (int i3 = 0; i3 < this.entries.size(); i3++) {
                Range<K> key = this.entries.get(i3).getKey();
                if (i3 > 0) {
                    Range<K> key2 = this.entries.get(i3 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                builder.add((ImmutableList.Builder) key);
                builder2.add((ImmutableList.Builder) this.entries.get(i3).getValue());
            }
            return new ImmutableRangeMap<>(builder.build(), builder2.build());
        }

        Builder<K, V> combine(Builder<K, V> builder) {
            this.entries.addAll(builder.entries);
            return this;
        }

        public Builder<K, V> put(Range<K> range, V v3) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v3);
            Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.entries.add(Maps.immutableEntry(range, v3));
            return this;
        }

        public Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap) {
            for (Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        Object createRangeMap() {
            Builder builder = new Builder();
            UnmodifiableIterator<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Range<K>, V> next = it.next();
                builder.put(next.getKey(), next.getValue());
            }
            return builder.build();
        }

        Object readResolve() {
            return this.mapOfRanges.isEmpty() ? ImmutableRangeMap.of() : createRangeMap();
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = rangeMap.asMapOfRanges();
        ImmutableList.Builder builder = new ImmutableList.Builder(asMapOfRanges.size());
        ImmutableList.Builder builder2 = new ImmutableList.Builder(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            builder.add((ImmutableList.Builder) entry.getKey());
            builder2.add((ImmutableList.Builder) entry.getValue());
        }
        return new ImmutableRangeMap<>(builder.build(), builder2.build());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v3) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v3));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        return this.ranges.isEmpty() ? ImmutableMap.of() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K k3) {
        int binarySearch = SortedLists.binarySearch(this.ranges, (Function<? super E, Cut>) Range.lowerBoundFn(), Cut.belowValue(k3), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch != -1 && this.ranges.get(binarySearch).contains(k3)) {
            return this.values.get(binarySearch);
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k3) {
        int binarySearch = SortedLists.binarySearch(this.ranges, (Function<? super E, Cut>) Range.lowerBoundFn(), Cut.belowValue(k3), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(binarySearch);
        if (range.contains(k3)) {
            return Maps.immutableEntry(range, this.values.get(binarySearch));
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void put(Range<K> range, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void putAll(RangeMap<K, ? extends V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void putCoalescing(Range<K> range, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(r1.size() - 1).upperBound);
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
        if (((Range) Preconditions.checkNotNull(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        Function upperBoundFn = Range.upperBoundFn();
        Cut<K> cut = range.lowerBound;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int binarySearch = SortedLists.binarySearch(immutableList, (Function<? super E, Cut<K>>) upperBoundFn, cut, keyPresentBehavior, keyAbsentBehavior);
        int binarySearch2 = SortedLists.binarySearch(this.ranges, (Function<? super E, Cut<K>>) Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        if (binarySearch >= binarySearch2) {
            return of();
        }
        final int i3 = binarySearch2 - binarySearch;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i4) {
                Preconditions.checkElementIndex(i4, i3);
                return (i4 == 0 || i4 == i3 + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i4 + binarySearch)).intersection(range) : (Range) ImmutableRangeMap.this.ranges.get(i4 + binarySearch);
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i3;
            }
        }, this.values.subList(binarySearch, binarySearch2)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
            public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                return super.asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
            public ImmutableRangeMap<K, V> subRangeMap(Range<K> range2) {
                return range.isConnected(range2) ? this.subRangeMap((Range) range2.intersection(range)) : ImmutableRangeMap.of();
            }
        };
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
