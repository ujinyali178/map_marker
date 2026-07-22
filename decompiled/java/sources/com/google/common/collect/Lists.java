package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Lists {

    private static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> backingList;

        AbstractListWrapper(List<E> list) {
            this.backingList = (List) Preconditions.checkNotNull(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i3, @ParametricNullness E e3) {
            this.backingList.add(i3, e3);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i3, Collection<? extends E> collection) {
            return this.backingList.addAll(i3, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return this.backingList.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i3) {
            return this.backingList.get(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E remove(int i3) {
            return this.backingList.remove(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E set(int i3, @ParametricNullness E e3) {
            return this.backingList.set(i3, e3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.backingList.size();
        }
    }

    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Character.valueOf(this.sequence.charAt(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }
    }

    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final E first;
        final E[] rest;

        OnePlusArrayList(@ParametricNullness E e3, E[] eArr) {
            this.first = e3;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return i3 == 0 ? this.first : this.rest[i3 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        final List<T> list;
        final int size;

        Partition(List<T> list, int i3) {
            this.list = list;
            this.size = i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            int i4 = this.size;
            int i5 = i3 * i4;
            return this.list.subList(i5, Math.min(i4 + i5, this.list.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }
    }

    private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        RandomAccessPartition(List<T> list, int i3) {
            super(list, i3);
        }
    }

    private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    private static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        ReverseList(List<T> list) {
            this.forwardList = (List) Preconditions.checkNotNull(list);
        }

        private int reverseIndex(int i3) {
            int size = size();
            Preconditions.checkElementIndex(i3, size);
            return (size - 1) - i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int reversePosition(int i3) {
            int size = size();
            Preconditions.checkPositionIndex(i3, size);
            return size - i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i3, @ParametricNullness T t3) {
            this.forwardList.add(reversePosition(i3), t3);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.forwardList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int i3) {
            return this.forwardList.get(reverseIndex(i3));
        }

        List<T> getForwardList() {
            return this.forwardList;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i3) {
            final ListIterator<T> listIterator = this.forwardList.listIterator(reversePosition(i3));
            return new ListIterator<T>() { // from class: com.google.common.collect.Lists.ReverseList.1
                boolean canRemoveOrSet;

                @Override // java.util.ListIterator
                public void add(@ParametricNullness T t3) {
                    listIterator.add(t3);
                    listIterator.previous();
                    this.canRemoveOrSet = false;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                @ParametricNullness
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.canRemoveOrSet = true;
                    return (T) listIterator.previous();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return ReverseList.this.reversePosition(listIterator.nextIndex());
                }

                @Override // java.util.ListIterator
                @ParametricNullness
                public T previous() {
                    if (!hasPrevious()) {
                        throw new NoSuchElementException();
                    }
                    this.canRemoveOrSet = true;
                    return (T) listIterator.next();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return nextIndex() - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    CollectPreconditions.checkRemove(this.canRemoveOrSet);
                    listIterator.remove();
                    this.canRemoveOrSet = false;
                }

                @Override // java.util.ListIterator
                public void set(@ParametricNullness T t3) {
                    Preconditions.checkState(this.canRemoveOrSet);
                    listIterator.set(t3);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T remove(int i3) {
            return this.forwardList.remove(reverseIndex(i3));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i3, int i4) {
            subList(i3, i4).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T set(int i3, @ParametricNullness T t3) {
            return this.forwardList.set(reverseIndex(i3), t3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(i4), reversePosition(i3)));
        }
    }

    private static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // java.util.List
        public Character get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Character.valueOf(this.string.charAt(i3));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            return Lists.charactersOf(this.string.substring(i3, i4));
        }
    }

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int i3) {
            return this.function.apply(this.fromList.get(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i3) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i3)) { // from class: com.google.common.collect.Lists.TransformingRandomAccessList.1
                @Override // com.google.common.collect.TransformedIterator
                T transform(F f3) {
                    return TransformingRandomAccessList.this.function.apply(f3);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i3) {
            return this.function.apply(this.fromList.remove(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i3) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i3)) { // from class: com.google.common.collect.Lists.TransformingSequentialList.1
                @Override // com.google.common.collect.TransformedIterator
                @ParametricNullness
                T transform(@ParametricNullness F f3) {
                    return TransformingSequentialList.this.function.apply(f3);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final E first;
        final E[] rest;

        @ParametricNullness
        final E second;

        TwoPlusArrayList(@ParametricNullness E e3, @ParametricNullness E e4, E[] eArr) {
            this.first = e3;
            this.second = e4;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i3) {
            if (i3 == 0) {
                return this.first;
            }
            if (i3 == 1) {
                return this.second;
            }
            Preconditions.checkElementIndex(i3, size());
            return this.rest[i3 - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    private Lists() {
    }

    static <E> boolean addAllImpl(List<E> list, int i3, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i3);
        Iterator<? extends E> it = iterable.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z3 = true;
        }
        return z3;
    }

    public static <E> List<E> asList(@ParametricNullness E e3, @ParametricNullness E e4, E[] eArr) {
        return new TwoPlusArrayList(e3, e4, eArr);
    }

    public static <E> List<E> asList(@ParametricNullness E e3, E[] eArr) {
        return new OnePlusArrayList(e3, eArr);
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.create(list);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    static <T> List<T> cast(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    static int computeArrayListCapacity(int i3) {
        CollectPreconditions.checkNonnegative(i3, "arraySize");
        return Ints.saturatedCast(i3 + 5 + (i3 / 10));
    }

    static boolean equalsImpl(List<?> list, @CheckForNull Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (!Objects.equal(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    static int hashCodeImpl(List<?> list) {
        Iterator<?> it = list.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i3 = ~(~((i3 * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i3;
    }

    static int indexOfImpl(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int indexOfRandomAccess(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i3 = 0;
        if (obj == null) {
            while (i3 < size) {
                if (list.get(i3) == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        while (i3 < size) {
            if (obj.equals(list.get(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    static int lastIndexOfImpl(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int lastIndexOfRandomAccess(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    static <E> ListIterator<E> listIteratorImpl(List<E> list, int i3) {
        return new AbstractListWrapper(list).listIterator(i3);
    }

    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : newArrayList(iterable.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }

    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <E> ArrayList<E> newArrayListWithCapacity(int i3) {
        CollectPreconditions.checkNonnegative(i3, "initialArraySize");
        return new ArrayList<>(i3);
    }

    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i3) {
        return new ArrayList<>(computeArrayListCapacity(i3));
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> iterable) {
        return new CopyOnWriteArrayList<>(iterable instanceof Collection ? (Collection) iterable : newArrayList(iterable));
    }

    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    public static <T> List<List<T>> partition(List<T> list, int i3) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i3 > 0);
        return list instanceof RandomAccess ? new RandomAccessPartition(list, i3) : new Partition(list, i3);
    }

    public static <T> List<T> reverse(List<T> list) {
        return list instanceof ImmutableList ? ((ImmutableList) list).reverse() : list instanceof ReverseList ? ((ReverseList) list).getForwardList() : list instanceof RandomAccess ? new RandomAccessReverseList(list) : new ReverseList(list);
    }

    static <E> List<E> subListImpl(List<E> list, int i3, int i4) {
        return (list instanceof RandomAccess ? new RandomAccessListWrapper<E>(list) { // from class: com.google.common.collect.Lists.1
            private static final long serialVersionUID = 0;

            @Override // java.util.AbstractList, java.util.List
            public ListIterator<E> listIterator(int i5) {
                return this.backingList.listIterator(i5);
            }
        } : new AbstractListWrapper<E>(list) { // from class: com.google.common.collect.Lists.2
            private static final long serialVersionUID = 0;

            @Override // java.util.AbstractList, java.util.List
            public ListIterator<E> listIterator(int i5) {
                return this.backingList.listIterator(i5);
            }
        }).subList(i3, i4);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }
}
