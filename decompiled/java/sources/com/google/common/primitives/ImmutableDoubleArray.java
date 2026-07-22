package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable
/* loaded from: /root/release/classes.dex */
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i3 = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i4 = i3 + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i3], ((Double) obj2).doubleValue())) {
                        i3 = i4;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int i3) {
            return Double.valueOf(this.parent.get(i3));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i3, int i4) {
            return this.parent.subArray(i3, i4).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class Builder {
        private double[] array;
        private int count = 0;

        Builder(int i3) {
            this.array = new double[i3];
        }

        private void ensureRoomFor(int i3) {
            int i4 = this.count + i3;
            double[] dArr = this.array;
            if (i4 > dArr.length) {
                this.array = Arrays.copyOf(dArr, expandedCapacity(dArr.length, i4));
            }
        }

        private static int expandedCapacity(int i3, int i4) {
            if (i4 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i5 = i3 + (i3 >> 1) + 1;
            if (i5 < i4) {
                i5 = Integer.highestOneBit(i4 - 1) << 1;
            }
            if (i5 < 0) {
                return Integer.MAX_VALUE;
            }
            return i5;
        }

        public Builder add(double d3) {
            ensureRoomFor(1);
            double[] dArr = this.array;
            int i3 = this.count;
            dArr[i3] = d3;
            this.count = i3 + 1;
            return this;
        }

        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            ensureRoomFor(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.array, this.count, immutableDoubleArray.length());
            this.count += immutableDoubleArray.length();
            return this;
        }

        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Double>) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().doubleValue());
            }
            return this;
        }

        public Builder addAll(Collection<Double> collection) {
            ensureRoomFor(collection.size());
            for (Double d3 : collection) {
                double[] dArr = this.array;
                int i3 = this.count;
                this.count = i3 + 1;
                dArr[i3] = d3.doubleValue();
            }
            return this;
        }

        public Builder addAll(double[] dArr) {
            ensureRoomFor(dArr.length);
            System.arraycopy(dArr, 0, this.array, this.count, dArr.length);
            this.count += dArr.length;
            return this;
        }

        public ImmutableDoubleArray build() {
            return this.count == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.array, 0, this.count);
        }
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    private ImmutableDoubleArray(double[] dArr, int i3, int i4) {
        this.array = dArr;
        this.start = i3;
        this.end = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areEqual(double d3, double d4) {
        return Double.doubleToLongBits(d3) == Double.doubleToLongBits(d4);
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static Builder builder(int i3) {
        Preconditions.checkArgument(i3 >= 0, "Invalid initialCapacity: %s", i3);
        return new Builder(i3);
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        return iterable instanceof Collection ? copyOf((Collection<Double>) iterable) : builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static ImmutableDoubleArray of(double d3) {
        return new ImmutableDoubleArray(new double[]{d3});
    }

    public static ImmutableDoubleArray of(double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d3, d4});
    }

    public static ImmutableDoubleArray of(double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d3, d4, d5});
    }

    public static ImmutableDoubleArray of(double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d3, d4, d5, d6});
    }

    public static ImmutableDoubleArray of(double d3, double d4, double d5, double d6, double d7) {
        return new ImmutableDoubleArray(new double[]{d3, d4, d5, d6, d7});
    }

    public static ImmutableDoubleArray of(double d3, double d4, double d5, double d6, double d7, double d8) {
        return new ImmutableDoubleArray(new double[]{d3, d4, d5, d6, d7, d8});
    }

    public static ImmutableDoubleArray of(double d3, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d3;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d3) {
        return indexOf(d3) >= 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i3 = 0; i3 < length(); i3++) {
            if (!areEqual(get(i3), immutableDoubleArray.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i3) {
        Preconditions.checkElementIndex(i3, length());
        return this.array[this.start + i3];
    }

    public int hashCode() {
        int i3 = 1;
        for (int i4 = this.start; i4 < this.end; i4++) {
            i3 = (i3 * 31) + Doubles.hashCode(this.array[i4]);
        }
        return i3;
    }

    public int indexOf(double d3) {
        for (int i3 = this.start; i3 < this.end; i3++) {
            if (areEqual(this.array[i3], d3)) {
                return i3 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d3) {
        int i3 = this.end;
        do {
            i3--;
            if (i3 < this.start) {
                return -1;
            }
        } while (!areEqual(this.array[i3], d3));
        return i3 - this.start;
    }

    public int length() {
        return this.end - this.start;
    }

    Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableDoubleArray subArray(int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i4, length());
        if (i3 == i4) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i5 = this.start;
        return new ImmutableDoubleArray(dArr, i3 + i5, i5 + i4);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i3 = this.start;
        while (true) {
            i3++;
            if (i3 >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.array[i3]);
        }
    }

    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    Object writeReplace() {
        return trimmed();
    }
}
