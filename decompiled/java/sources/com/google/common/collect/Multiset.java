package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(@CheckForNull Object obj);

        int getCount();

        @ParametricNullness
        E getElement();

        int hashCode();

        String toString();
    }

    int add(@ParametricNullness E e3, int i3);

    boolean add(@ParametricNullness E e3);

    boolean contains(@CheckForNull Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@CheckForNull Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@CheckForNull Object obj);

    int hashCode();

    Iterator<E> iterator();

    int remove(@CheckForNull Object obj, int i3);

    boolean remove(@CheckForNull Object obj);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int setCount(@ParametricNullness E e3, int i3);

    boolean setCount(@ParametricNullness E e3, int i3, int i4);

    int size();

    String toString();
}
