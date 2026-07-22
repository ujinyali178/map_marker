package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Objects;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;
    private final transient int size;

    RegularImmutableList(Object[] objArr, int i3) {
        this.array = objArr;
        this.size = i3;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i3) {
        System.arraycopy(this.array, 0, objArr, i3, this.size);
        return i3 + this.size;
    }

    @Override // java.util.List
    public E get(int i3) {
        Preconditions.checkElementIndex(i3, this.size);
        E e3 = (E) this.array[i3];
        Objects.requireNonNull(e3);
        return e3;
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
