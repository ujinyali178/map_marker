package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    protected ForwardingList() {
    }

    public void add(int i3, @ParametricNullness E e3) {
        delegate().add(i3, e3);
    }

    public boolean addAll(int i3, Collection<? extends E> collection) {
        return delegate().addAll(i3, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.List
    @ParametricNullness
    public E get(int i3) {
        return delegate().get(i3);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        return delegate().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        return delegate().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i3) {
        return delegate().listIterator(i3);
    }

    @Override // java.util.List
    @ParametricNullness
    public E remove(int i3) {
        return delegate().remove(i3);
    }

    @Override // java.util.List
    @ParametricNullness
    public E set(int i3, @ParametricNullness E e3) {
        return delegate().set(i3, e3);
    }

    protected boolean standardAdd(@ParametricNullness E e3) {
        add(size(), e3);
        return true;
    }

    protected boolean standardAddAll(int i3, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i3, iterable);
    }

    protected boolean standardEquals(@CheckForNull Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    protected int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    protected int standardIndexOf(@CheckForNull Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    protected Iterator<E> standardIterator() {
        return listIterator();
    }

    protected int standardLastIndexOf(@CheckForNull Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    protected ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    protected ListIterator<E> standardListIterator(int i3) {
        return Lists.listIteratorImpl(this, i3);
    }

    protected List<E> standardSubList(int i3, int i4) {
        return Lists.subListImpl(this, i3, i4);
    }

    @Override // java.util.List
    public List<E> subList(int i3, int i4) {
        return delegate().subList(i3, i4);
    }
}
