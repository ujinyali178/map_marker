package com.google.common.primitives;

import com.google.common.base.Ascii;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Ints extends IntsMethodsForWeb {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        IntArrayAsList(int[] iArr, int i3, int i4) {
            this.array = iArr;
            this.start = i3;
            this.end = i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Integer) && Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.array[this.start + i3] != intArrayAsList.array[intArrayAsList.start + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Integer.valueOf(this.array[this.start + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.start; i4 < this.end; i4++) {
                i3 = (i3 * 31) + Ints.hashCode(this.array[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            if (!(obj instanceof Integer) || (indexOf = Ints.indexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Integer) || (lastIndexOf = Ints.lastIndexOf(this.array, ((Integer) obj).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int i3, Integer num) {
            Preconditions.checkElementIndex(i3, size());
            int[] iArr = this.array;
            int i4 = this.start;
            int i5 = iArr[i4 + i3];
            iArr[i4 + i3] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i5 = this.start;
            return new IntArrayAsList(iArr, i3 + i5, i5 + i4);
        }

        int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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
    }

    private static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = new IntConverter();
        private static final long serialVersionUID = 1;

        private IntConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Integer num) {
            return num.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Integer doForward(String str) {
            return Integer.decode(str);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }
    }

    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = Ints.compare(iArr[i3], iArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    private Ints() {
    }

    public static List<Integer> asList(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new IntArrayAsList(iArr);
    }

    public static int checkedCast(long j3) {
        int i3 = (int) j3;
        Preconditions.checkArgument(((long) i3) == j3, "Out of range: %s", j3);
        return i3;
    }

    public static int compare(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }

    public static int[] concat(int[]... iArr) {
        int i3 = 0;
        for (int[] iArr2 : iArr) {
            i3 += iArr2.length;
        }
        int[] iArr3 = new int[i3];
        int i4 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, i4, iArr4.length);
            i4 += iArr4.length;
        }
        return iArr3;
    }

    public static int constrainToRange(int i3, int i4, int i5) {
        Preconditions.checkArgument(i4 <= i5, "min (%s) must be less than or equal to max (%s)", i4, i5);
        return Math.min(Math.max(i3, i4), i5);
    }

    public static boolean contains(int[] iArr, int i3) {
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    public static int[] ensureCapacity(int[] iArr, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0, "Invalid minLength: %s", i3);
        Preconditions.checkArgument(i4 >= 0, "Invalid padding: %s", i4);
        return iArr.length < i3 ? Arrays.copyOf(iArr, i3 + i4) : iArr;
    }

    public static int fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int fromBytes(byte b4, byte b5, byte b6, byte b7) {
        return (b4 << Ascii.CAN) | ((b5 & UnsignedBytes.MAX_VALUE) << 16) | ((b6 & UnsignedBytes.MAX_VALUE) << 8) | (b7 & UnsignedBytes.MAX_VALUE);
    }

    public static int hashCode(int i3) {
        return i3;
    }

    public static int indexOf(int[] iArr, int i3) {
        return indexOf(iArr, i3, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(int[] iArr, int i3, int i4, int i5) {
        while (i4 < i5) {
            if (iArr[i4] == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOf(int[] r5, int[] r6) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Ints.indexOf(int[], int[]):int");
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i3 = 1; i3 < iArr.length; i3++) {
            sb.append(str);
            sb.append(iArr[i3]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(int[] iArr, int i3) {
        return lastIndexOf(iArr, i3, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(int[] iArr, int i3, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (iArr[i6] == i3) {
                return i6;
            }
        }
        return -1;
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i3 = iArr[0];
        for (int i4 = 1; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i3) {
                i3 = i5;
            }
        }
        return i3;
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int i3 = iArr[0];
        for (int i4 = 1; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 < i3) {
                i3 = i5;
            }
        }
        return i3;
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static void reverse(int[] iArr, int i3, int i4) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i3, i4, iArr.length);
        for (int i5 = i4 - 1; i3 < i5; i5--) {
            int i6 = iArr[i3];
            iArr[i3] = iArr[i5];
            iArr[i5] = i6;
            i3++;
        }
    }

    public static void rotate(int[] iArr, int i3) {
        rotate(iArr, i3, 0, iArr.length);
    }

    public static void rotate(int[] iArr, int i3, int i4, int i5) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i4, i5, iArr.length);
        if (iArr.length <= 1) {
            return;
        }
        int i6 = i5 - i4;
        int i7 = (-i3) % i6;
        if (i7 < 0) {
            i7 += i6;
        }
        int i8 = i7 + i4;
        if (i8 == i4) {
            return;
        }
        reverse(iArr, i4, i8);
        reverse(iArr, i8, i5);
        reverse(iArr, i4, i5);
    }

    public static int saturatedCast(long j3) {
        if (j3 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j3 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j3;
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr, int i3, int i4) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i3, i4, iArr.length);
        Arrays.sort(iArr, i3, i4);
        reverse(iArr, i3, i4);
    }

    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = ((Number) Preconditions.checkNotNull(array[i3])).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(int i3) {
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3};
    }

    @CheckForNull
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    @CheckForNull
    public static Integer tryParse(String str, int i3) {
        Long tryParse = Longs.tryParse(str, i3);
        if (tryParse == null || tryParse.longValue() != tryParse.intValue()) {
            return null;
        }
        return Integer.valueOf(tryParse.intValue());
    }
}
