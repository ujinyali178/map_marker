package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST;
    private long[] array;
    private int size;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        EMPTY_LIST = longArrayList;
        longArrayList.makeImmutable();
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    private LongArrayList(long[] jArr, int i3) {
        this.array = jArr;
        this.size = i3;
    }

    private void addLong(int i3, long j3) {
        int i4;
        ensureIsMutable();
        if (i3 < 0 || i3 > (i4 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i3));
        }
        long[] jArr = this.array;
        if (i4 < jArr.length) {
            System.arraycopy(jArr, i3, jArr, i3 + 1, i4 - i3);
        } else {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            System.arraycopy(this.array, i3, jArr2, i3 + 1, this.size - i3);
            this.array = jArr2;
        }
        this.array[i3] = j3;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static LongArrayList emptyList() {
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
    public void add(int i3, Long l3) {
        addLong(i3, l3.longValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Long l3) {
        addLong(l3.longValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i3 = longArrayList.size;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.size;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        long[] jArr = this.array;
        if (i5 > jArr.length) {
            this.array = Arrays.copyOf(jArr, i5);
        }
        System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
        this.size = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.LongList
    public void addLong(long j3) {
        ensureIsMutable();
        int i3 = this.size;
        long[] jArr = this.array;
        if (i3 == jArr.length) {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i4 = this.size;
        this.size = i4 + 1;
        jArr3[i4] = j3;
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (this.array[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i3) {
        return Long.valueOf(getLong(i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.LongList
    public long getLong(int i3) {
        ensureIndexInRange(i3);
        return this.array[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.size; i4++) {
            i3 = (i3 * 31) + Internal.hashLong(this.array[i4]);
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.array[i3] == longValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int i3) {
        if (i3 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, i3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int i3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        long[] jArr = this.array;
        long j3 = jArr[i3];
        if (i3 < this.size - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        ensureIsMutable();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.array;
        System.arraycopy(jArr, i4, jArr, i3, this.size - i4);
        this.size -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long set(int i3, Long l3) {
        return Long.valueOf(setLong(i3, l3.longValue()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.LongList
    public long setLong(int i3, long j3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        long[] jArr = this.array;
        long j4 = jArr[i3];
        jArr[i3] = j3;
        return j4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
