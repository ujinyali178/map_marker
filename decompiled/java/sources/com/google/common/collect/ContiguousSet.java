package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i3, int i4) {
        return create(Range.closed(Integer.valueOf(i3), Integer.valueOf(i4)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closed(long j3, long j4) {
        return create(Range.closed(Long.valueOf(j3), Long.valueOf(j4)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Integer> closedOpen(int i3, int i4) {
        return create(Range.closedOpen(Integer.valueOf(i3), Integer.valueOf(i4)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Long> closedOpen(long j3, long j4) {
        return create(Range.closedOpen(Long.valueOf(j3), Long.valueOf(j4)), DiscreteDomain.longs());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            boolean z3 = true;
            if (!intersection.isEmpty()) {
                C leastValueAbove = range.lowerBound.leastValueAbove(discreteDomain);
                Objects.requireNonNull(leastValueAbove);
                C greatestValueBelow = range.upperBound.greatestValueBelow(discreteDomain);
                Objects.requireNonNull(greatestValueBelow);
                if (Range.compareOrThrow(leastValueAbove, greatestValueBelow) <= 0) {
                    z3 = false;
                }
            }
            return z3 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
        } catch (NoSuchElementException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> headSet(C c3) {
        return headSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c3), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ContiguousSet<C> headSet(C c3, boolean z3) {
        return headSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c3), z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> headSetImpl(C c3, boolean z3);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c3, C c4) {
        Preconditions.checkNotNull(c3);
        Preconditions.checkNotNull(c4);
        Preconditions.checkArgument(comparator().compare(c3, c4) <= 0);
        return subSetImpl((boolean) c3, true, (boolean) c4, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ContiguousSet<C> subSet(C c3, boolean z3, C c4, boolean z4) {
        Preconditions.checkNotNull(c3);
        Preconditions.checkNotNull(c4);
        Preconditions.checkArgument(comparator().compare(c3, c4) <= 0);
        return subSetImpl((boolean) c3, z3, (boolean) c4, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> subSetImpl(C c3, boolean z3, C c4, boolean z4);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> tailSet(C c3) {
        return tailSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c3), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ContiguousSet<C> tailSet(C c3, boolean z3) {
        return tailSetImpl((ContiguousSet<C>) Preconditions.checkNotNull(c3), z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public abstract ContiguousSet<C> tailSetImpl(C c3, boolean z3);

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }
}
