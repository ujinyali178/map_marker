package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private int position;
    private final int size;

    protected AbstractIndexedListIterator(int i3) {
        this(i3, 0);
    }

    protected AbstractIndexedListIterator(int i3, int i4) {
        Preconditions.checkPositionIndex(i4, i3);
        this.size = i3;
        this.position = i4;
    }

    @ParametricNullness
    protected abstract E get(int i3);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.position < this.size;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.position > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    @ParametricNullness
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.position;
        this.position = i3 + 1;
        return get(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.position;
    }

    @Override // java.util.ListIterator
    @ParametricNullness
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.position - 1;
        this.position = i3;
        return get(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.position - 1;
    }
}
