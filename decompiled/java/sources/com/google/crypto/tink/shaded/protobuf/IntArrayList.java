package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST;
    private int[] array;
    private int size;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        EMPTY_LIST = intArrayList;
        intArrayList.makeImmutable();
    }

    IntArrayList() {
        this(new int[10], 0);
    }

    private IntArrayList(int[] iArr, int i3) {
        this.array = iArr;
        this.size = i3;
    }

    private void addInt(int i3, int i4) {
        int i5;
        ensureIsMutable();
        if (i3 < 0 || i3 > (i5 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i3));
        }
        int[] iArr = this.array;
        if (i5 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i3 + 1, i5 - i3);
        } else {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.array, i3, iArr2, i3 + 1, this.size - i3);
            this.array = iArr2;
        }
        this.array[i3] = i4;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
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
    public void add(int i3, Integer num) {
        addInt(i3, num.intValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i3 = intArrayList.size;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.size;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.array;
        if (i5 > iArr.length) {
            this.array = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
        this.size = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.IntList
    public void addInt(int i3) {
        ensureIsMutable();
        int i4 = this.size;
        int[] iArr = this.array;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        iArr3[i5] = i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (this.array[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i3) {
        return Integer.valueOf(getInt(i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.IntList
    public int getInt(int i3) {
        ensureIndexInRange(i3);
        return this.array[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.size; i4++) {
            i3 = (i3 * 31) + this.array[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.array[i3] == intValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int i3) {
        if (i3 >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, i3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int i3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        int[] iArr = this.array;
        int i4 = iArr[i3];
        if (i3 < this.size - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        ensureIsMutable();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.array;
        System.arraycopy(iArr, i4, iArr, i3, this.size - i4);
        this.size -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer set(int i3, Integer num) {
        return Integer.valueOf(setInt(i3, num.intValue()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.IntList
    public int setInt(int i3, int i4) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        int[] iArr = this.array;
        int i5 = iArr[i3];
        iArr[i3] = i4;
        return i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
