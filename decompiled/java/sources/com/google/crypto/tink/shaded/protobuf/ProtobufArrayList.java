package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;
    private E[] array;
    private int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private ProtobufArrayList(E[] eArr, int i3) {
        this.array = eArr;
        this.size = i3;
    }

    private static <E> E[] createArray(int i3) {
        return (E[]) new Object[i3];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int i3) {
        if (i3 < 0 || i3 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i3));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i3) {
        return "Index:" + i3 + ", Size:" + this.size;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i3, E e3) {
        int i4;
        ensureIsMutable();
        if (i3 < 0 || i3 > (i4 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i3));
        }
        E[] eArr = this.array;
        if (i4 < eArr.length) {
            System.arraycopy(eArr, i3, eArr, i3 + 1, i4 - i3);
        } else {
            E[] eArr2 = (E[]) createArray(((i4 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, eArr2, 0, i3);
            System.arraycopy(this.array, i3, eArr2, i3 + 1, this.size - i3);
            this.array = eArr2;
        }
        this.array[i3] = e3;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e3) {
        ensureIsMutable();
        int i3 = this.size;
        E[] eArr = this.array;
        if (i3 == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((i3 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i4 = this.size;
        this.size = i4 + 1;
        eArr2[i4] = e3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        ensureIndexInRange(i3);
        return this.array[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int i3) {
        if (i3 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        E[] eArr = this.array;
        E e3 = eArr[i3];
        if (i3 < this.size - 1) {
            System.arraycopy(eArr, i3 + 1, eArr, i3, (r2 - i3) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i3, E e3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        E[] eArr = this.array;
        E e4 = eArr[i3];
        eArr[i3] = e3;
        ((AbstractList) this).modCount++;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
