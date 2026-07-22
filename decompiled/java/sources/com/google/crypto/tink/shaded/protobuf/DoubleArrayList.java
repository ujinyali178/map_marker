package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST;
    private double[] array;
    private int size;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        EMPTY_LIST = doubleArrayList;
        doubleArrayList.makeImmutable();
    }

    DoubleArrayList() {
        this(new double[10], 0);
    }

    private DoubleArrayList(double[] dArr, int i3) {
        this.array = dArr;
        this.size = i3;
    }

    private void addDouble(int i3, double d3) {
        int i4;
        ensureIsMutable();
        if (i3 < 0 || i3 > (i4 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i3));
        }
        double[] dArr = this.array;
        if (i4 < dArr.length) {
            System.arraycopy(dArr, i3, dArr, i3 + 1, i4 - i3);
        } else {
            double[] dArr2 = new double[((i4 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i3);
            System.arraycopy(this.array, i3, dArr2, i3 + 1, this.size - i3);
            this.array = dArr2;
        }
        this.array[i3] = d3;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static DoubleArrayList emptyList() {
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
    public void add(int i3, Double d3) {
        addDouble(i3, d3.doubleValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Double d3) {
        addDouble(d3.doubleValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i3 = doubleArrayList.size;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.size;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        double[] dArr = this.array;
        if (i5 > dArr.length) {
            this.array = Arrays.copyOf(dArr, i5);
        }
        System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
        this.size = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.DoubleList
    public void addDouble(double d3) {
        ensureIsMutable();
        int i3 = this.size;
        double[] dArr = this.array;
        if (i3 == dArr.length) {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i3);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i4 = this.size;
        this.size = i4 + 1;
        dArr3[i4] = d3;
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (Double.doubleToLongBits(this.array[i3]) != Double.doubleToLongBits(dArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i3) {
        return Double.valueOf(getDouble(i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.DoubleList
    public double getDouble(int i3) {
        ensureIndexInRange(i3);
        return this.array[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.size; i4++) {
            i3 = (i3 * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i4]));
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.array[i3] == doubleValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Double> mutableCopyWithCapacity2(int i3) {
        if (i3 >= this.size) {
            return new DoubleArrayList(Arrays.copyOf(this.array, i3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double remove(int i3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        double[] dArr = this.array;
        double d3 = dArr[i3];
        if (i3 < this.size - 1) {
            System.arraycopy(dArr, i3 + 1, dArr, i3, (r3 - i3) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        ensureIsMutable();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.array;
        System.arraycopy(dArr, i4, dArr, i3, this.size - i4);
        this.size -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double set(int i3, Double d3) {
        return Double.valueOf(setDouble(i3, d3.doubleValue()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.DoubleList
    public double setDouble(int i3, double d3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        double[] dArr = this.array;
        double d4 = dArr[i3];
        dArr[i3] = d3;
        return d4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
