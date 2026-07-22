package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    protected ForwardingNavigableSet() {
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E ceiling(@ParametricNullness E e3) {
        return delegate().ceiling(e3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E floor(@ParametricNullness E e3) {
        return delegate().floor(e3);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(@ParametricNullness E e3, boolean z3) {
        return delegate().headSet(e3, z3);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E higher(@ParametricNullness E e3) {
        return delegate().higher(e3);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E lower(@ParametricNullness E e3) {
        return delegate().lower(e3);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @CheckForNull
    protected E standardCeiling(@ParametricNullness E e3) {
        return (E) Iterators.getNext(tailSet(e3, true).iterator(), null);
    }

    @ParametricNullness
    protected E standardFirst() {
        return iterator().next();
    }

    @CheckForNull
    protected E standardFloor(@ParametricNullness E e3) {
        return (E) Iterators.getNext(headSet(e3, true).descendingIterator(), null);
    }

    protected SortedSet<E> standardHeadSet(@ParametricNullness E e3) {
        return headSet(e3, false);
    }

    @CheckForNull
    protected E standardHigher(@ParametricNullness E e3) {
        return (E) Iterators.getNext(tailSet(e3, false).iterator(), null);
    }

    @ParametricNullness
    protected E standardLast() {
        return descendingIterator().next();
    }

    @CheckForNull
    protected E standardLower(@ParametricNullness E e3) {
        return (E) Iterators.getNext(headSet(e3, false).descendingIterator(), null);
    }

    @CheckForNull
    protected E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    @CheckForNull
    protected E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    protected NavigableSet<E> standardSubSet(@ParametricNullness E e3, boolean z3, @ParametricNullness E e4, boolean z4) {
        return tailSet(e3, z3).headSet(e4, z4);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    protected SortedSet<E> standardSubSet(@ParametricNullness E e3, @ParametricNullness E e4) {
        return subSet(e3, true, e4, false);
    }

    protected SortedSet<E> standardTailSet(@ParametricNullness E e3) {
        return tailSet(e3, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(@ParametricNullness E e3, boolean z3, @ParametricNullness E e4, boolean z4) {
        return delegate().subSet(e3, z3, e4, z4);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(@ParametricNullness E e3, boolean z3) {
        return delegate().tailSet(e3, z3);
    }
}
