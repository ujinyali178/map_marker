package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /root/release/classes.dex */
final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST;
    private float[] array;
    private int size;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        EMPTY_LIST = floatArrayList;
        floatArrayList.makeImmutable();
    }

    FloatArrayList() {
        this(new float[10], 0);
    }

    private FloatArrayList(float[] fArr, int i3) {
        this.array = fArr;
        this.size = i3;
    }

    private void addFloat(int i3, float f3) {
        int i4;
        ensureIsMutable();
        if (i3 < 0 || i3 > (i4 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i3));
        }
        float[] fArr = this.array;
        if (i4 < fArr.length) {
            System.arraycopy(fArr, i3, fArr, i3 + 1, i4 - i3);
        } else {
            float[] fArr2 = new float[((i4 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            System.arraycopy(this.array, i3, fArr2, i3 + 1, this.size - i3);
            this.array = fArr2;
        }
        this.array[i3] = f3;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    public static FloatArrayList emptyList() {
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
    public void add(int i3, Float f3) {
        addFloat(i3, f3.floatValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Float f3) {
        addFloat(f3.floatValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i3 = floatArrayList.size;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.size;
        if (Integer.MAX_VALUE - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        float[] fArr = this.array;
        if (i5 > fArr.length) {
            this.array = Arrays.copyOf(fArr, i5);
        }
        System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
        this.size = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.FloatList
    public void addFloat(float f3) {
        ensureIsMutable();
        int i3 = this.size;
        float[] fArr = this.array;
        if (i3 == fArr.length) {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i4 = this.size;
        this.size = i4 + 1;
        fArr3[i4] = f3;
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (Float.floatToIntBits(this.array[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i3) {
        return Float.valueOf(getFloat(i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.FloatList
    public float getFloat(int i3) {
        ensureIndexInRange(i3);
        return this.array[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.size; i4++) {
            i3 = (i3 * 31) + Float.floatToIntBits(this.array[i4]);
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.array[i3] == floatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int i3) {
        if (i3 >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i3), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int i3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        float[] fArr = this.array;
        float f3 = fArr[i3];
        if (i3 < this.size - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        ensureIsMutable();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.array;
        System.arraycopy(fArr, i4, fArr, i3, this.size - i4);
        this.size -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float set(int i3, Float f3) {
        return Float.valueOf(setFloat(i3, f3.floatValue()));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.FloatList
    public float setFloat(int i3, float f3) {
        ensureIsMutable();
        ensureIndexInRange(i3);
        float[] fArr = this.array;
        float f4 = fArr[i3];
        fArr[i3] = f3;
        return f4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}
