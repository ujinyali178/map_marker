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
public final class ImmutableLongArray implements Serializable {
    private static final ImmutableLongArray EMPTY = new ImmutableLongArray(new long[0]);
    private final long[] array;
    private final int end;
    private final transient int start;

    static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

        private AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
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
                if (obj2 instanceof Long) {
                    int i4 = i3 + 1;
                    if (this.parent.array[i3] == ((Long) obj2).longValue()) {
                        i3 = i4;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i3) {
            return Long.valueOf(this.parent.get(i3));
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i3, int i4) {
            return this.parent.subArray(i3, i4).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class Builder {
        private long[] array;
        private int count = 0;

        Builder(int i3) {
            this.array = new long[i3];
        }

        private void ensureRoomFor(int i3) {
            int i4 = this.count + i3;
            long[] jArr = this.array;
            if (i4 > jArr.length) {
                this.array = Arrays.copyOf(jArr, expandedCapacity(jArr.length, i4));
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

        public Builder add(long j3) {
            ensureRoomFor(1);
            long[] jArr = this.array;
            int i3 = this.count;
            jArr[i3] = j3;
            this.count = i3 + 1;
            return this;
        }

        public Builder addAll(ImmutableLongArray immutableLongArray) {
            ensureRoomFor(immutableLongArray.length());
            System.arraycopy(immutableLongArray.array, immutableLongArray.start, this.array, this.count, immutableLongArray.length());
            this.count += immutableLongArray.length();
            return this;
        }

        public Builder addAll(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Long>) iterable);
            }
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().longValue());
            }
            return this;
        }

        public Builder addAll(Collection<Long> collection) {
            ensureRoomFor(collection.size());
            for (Long l3 : collection) {
                long[] jArr = this.array;
                int i3 = this.count;
                this.count = i3 + 1;
                jArr[i3] = l3.longValue();
            }
            return this;
        }

        public Builder addAll(long[] jArr) {
            ensureRoomFor(jArr.length);
            System.arraycopy(jArr, 0, this.array, this.count, jArr.length);
            this.count += jArr.length;
            return this;
        }

        public ImmutableLongArray build() {
            return this.count == 0 ? ImmutableLongArray.EMPTY : new ImmutableLongArray(this.array, 0, this.count);
        }
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private ImmutableLongArray(long[] jArr, int i3, int i4) {
        this.array = jArr;
        this.start = i3;
        this.end = i4;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static Builder builder(int i3) {
        Preconditions.checkArgument(i3 >= 0, "Invalid initialCapacity: %s", i3);
        return new Builder(i3);
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        return iterable instanceof Collection ? copyOf((Collection<Long>) iterable) : builder().addAll(iterable).build();
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableLongArray(Longs.toArray(collection));
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        return jArr.length == 0 ? EMPTY : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public static ImmutableLongArray of(long j3) {
        return new ImmutableLongArray(new long[]{j3});
    }

    public static ImmutableLongArray of(long j3, long j4) {
        return new ImmutableLongArray(new long[]{j3, j4});
    }

    public static ImmutableLongArray of(long j3, long j4, long j5) {
        return new ImmutableLongArray(new long[]{j3, j4, j5});
    }

    public static ImmutableLongArray of(long j3, long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j3, j4, j5, j6});
    }

    public static ImmutableLongArray of(long j3, long j4, long j5, long j6, long j7) {
        return new ImmutableLongArray(new long[]{j3, j4, j5, j6, j7});
    }

    public static ImmutableLongArray of(long j3, long j4, long j5, long j6, long j7, long j8) {
        return new ImmutableLongArray(new long[]{j3, j4, j5, j6, j7, j8});
    }

    public static ImmutableLongArray of(long j3, long... jArr) {
        Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j3;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }

    public List<Long> asList() {
        return new AsList();
    }

    public boolean contains(long j3) {
        return indexOf(j3) >= 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i3 = 0; i3 < length(); i3++) {
            if (get(i3) != immutableLongArray.get(i3)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i3) {
        Preconditions.checkElementIndex(i3, length());
        return this.array[this.start + i3];
    }

    public int hashCode() {
        int i3 = 1;
        for (int i4 = this.start; i4 < this.end; i4++) {
            i3 = (i3 * 31) + Longs.hashCode(this.array[i4]);
        }
        return i3;
    }

    public int indexOf(long j3) {
        for (int i3 = this.start; i3 < this.end; i3++) {
            if (this.array[i3] == j3) {
                return i3 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(long j3) {
        int i3;
        int i4 = this.end;
        do {
            i4--;
            i3 = this.start;
            if (i4 < i3) {
                return -1;
            }
        } while (this.array[i4] != j3);
        return i4 - i3;
    }

    public int length() {
        return this.end - this.start;
    }

    Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableLongArray subArray(int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i4, length());
        if (i3 == i4) {
            return EMPTY;
        }
        long[] jArr = this.array;
        int i5 = this.start;
        return new ImmutableLongArray(jArr, i3 + i5, i5 + i4);
    }

    public long[] toArray() {
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

    public ImmutableLongArray trimmed() {
        return isPartialView() ? new ImmutableLongArray(toArray()) : this;
    }

    Object writeReplace() {
        return trimmed();
    }
}
