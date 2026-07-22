package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class SortedLists {

    enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            int resultIndex(int i3) {
                return i3 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i3) {
                return i3;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i3) {
                return ~i3;
            }
        };

        abstract int resultIndex(int i3);
    }

    enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e3, List<? extends E> list, int i3) {
                return i3;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e3, List<? extends E> list, int i3) {
                int size = list.size() - 1;
                while (i3 < size) {
                    int i4 = ((i3 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i4), e3) > 0) {
                        size = i4 - 1;
                    } else {
                        i3 = i4;
                    }
                }
                return i3;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e3, List<? extends E> list, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = (i4 + i3) >>> 1;
                    if (comparator.compare(list.get(i5), e3) < 0) {
                        i4 = i5 + 1;
                    } else {
                        i3 = i5;
                    }
                }
                return i4;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e3, List<? extends E> list, int i3) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e3, list, i3) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e3, List<? extends E> list, int i3) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e3, list, i3) - 1;
            }
        };

        abstract <E> int resultIndex(Comparator<? super E> comparator, @ParametricNullness E e3, List<? extends E> list, int i3);
    }

    private SortedLists() {
    }

    public static <E, K extends Comparable> int binarySearch(List<E> list, Function<? super E, K> function, K k3, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(k3);
        return binarySearch(list, function, k3, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int binarySearch(List<E> list, Function<? super E, K> function, @ParametricNullness K k3, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch((List<? extends K>) Lists.transform(list, function), k3, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> list, E e3, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(e3);
        return binarySearch(list, e3, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int binarySearch(List<? extends E> list, @ParametricNullness E e3, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int i3 = 0;
        int size = list.size() - 1;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            int compare = comparator.compare(e3, list.get(i4));
            if (compare < 0) {
                size = i4 - 1;
            } else {
                if (compare <= 0) {
                    return i3 + keyPresentBehavior.resultIndex(comparator, e3, list.subList(i3, size + 1), i4 - i3);
                }
                i3 = i4 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i3);
    }
}
