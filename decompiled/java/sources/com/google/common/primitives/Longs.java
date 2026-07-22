package com.google.common.primitives;

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
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    static final class AsciiDigits {
        private static final byte[] asciiDigits;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i3 = 0; i3 < 10; i3++) {
                bArr[i3 + 48] = (byte) i3;
            }
            for (int i4 = 0; i4 < 26; i4++) {
                byte b4 = (byte) (i4 + 10);
                bArr[i4 + 65] = b4;
                bArr[i4 + 97] = b4;
            }
            asciiDigits = bArr;
        }

        private AsciiDigits() {
        }

        static int digit(char c3) {
            if (c3 < 128) {
                return asciiDigits[c3];
            }
            return -1;
        }
    }

    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = Longs.compare(jArr[i3], jArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        LongArrayAsList(long[] jArr, int i3, int i4) {
            this.array = jArr;
            this.start = i3;
            this.end = i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.array[this.start + i3] != longArrayAsList.array[longArrayAsList.start + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Long.valueOf(this.array[this.start + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.start; i4 < this.end; i4++) {
                i3 = (i3 * 31) + Longs.hashCode(this.array[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            if (!(obj instanceof Long) || (indexOf = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Long) || (lastIndexOf = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long set(int i3, Long l3) {
            Preconditions.checkElementIndex(i3, size());
            long[] jArr = this.array;
            int i4 = this.start;
            long j3 = jArr[i4 + i3];
            jArr[i4 + i3] = ((Long) Preconditions.checkNotNull(l3)).longValue();
            return Long.valueOf(j3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i5 = this.start;
            return new LongArrayAsList(jArr, i3 + i5, i5 + i4);
        }

        long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
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

    private static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Long l3) {
            return l3.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Long doForward(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    private Longs() {
    }

    public static List<Long> asList(long... jArr) {
        return jArr.length == 0 ? Collections.emptyList() : new LongArrayAsList(jArr);
    }

    public static int compare(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 > j4 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int i3 = 0;
        for (long[] jArr2 : jArr) {
            i3 += jArr2.length;
        }
        long[] jArr3 = new long[i3];
        int i4 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, i4, jArr4.length);
            i4 += jArr4.length;
        }
        return jArr3;
    }

    public static long constrainToRange(long j3, long j4, long j5) {
        Preconditions.checkArgument(j4 <= j5, "min (%s) must be less than or equal to max (%s)", j4, j5);
        return Math.min(Math.max(j3, j4), j5);
    }

    public static boolean contains(long[] jArr, long j3) {
        for (long j4 : jArr) {
            if (j4 == j3) {
                return true;
            }
        }
        return false;
    }

    public static long[] ensureCapacity(long[] jArr, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0, "Invalid minLength: %s", i3);
        Preconditions.checkArgument(i4 >= 0, "Invalid padding: %s", i4);
        return jArr.length < i3 ? Arrays.copyOf(jArr, i3 + i4) : jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        return ((b5 & 255) << 48) | ((b4 & 255) << 56) | ((b6 & 255) << 40) | ((b7 & 255) << 32) | ((b8 & 255) << 24) | ((b9 & 255) << 16) | ((b10 & 255) << 8) | (b11 & 255);
    }

    public static int hashCode(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    public static int indexOf(long[] jArr, long j3) {
        return indexOf(jArr, j3, 0, jArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(long[] jArr, long j3, int i3, int i4) {
        while (i3 < i4) {
            if (jArr[i3] == j3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOf(long[] r8, long[] r9) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r8, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r9, r0)
            int r0 = r9.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r8.length
            int r3 = r9.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r9.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r8[r3]
            r5 = r9[r2]
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Longs.indexOf(long[], long[]):int");
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i3 = 1; i3 < jArr.length; i3++) {
            sb.append(str);
            sb.append(jArr[i3]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(long[] jArr, long j3) {
        return lastIndexOf(jArr, j3, 0, jArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(long[] jArr, long j3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (jArr[i5] == j3) {
                return i5;
            }
        }
        return -1;
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j3 = jArr[0];
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long j4 = jArr[i3];
            if (j4 > j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j3 = jArr[0];
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long j4 = jArr[i3];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void reverse(long[] jArr, int i3, int i4) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i3, i4, jArr.length);
        for (int i5 = i4 - 1; i3 < i5; i5--) {
            long j3 = jArr[i3];
            jArr[i3] = jArr[i5];
            jArr[i5] = j3;
            i3++;
        }
    }

    public static void rotate(long[] jArr, int i3) {
        rotate(jArr, i3, 0, jArr.length);
    }

    public static void rotate(long[] jArr, int i3, int i4, int i5) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i4, i5, jArr.length);
        if (jArr.length <= 1) {
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
        reverse(jArr, i4, i8);
        reverse(jArr, i8, i5);
        reverse(jArr, i4, i5);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr, int i3, int i4) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i3, i4, jArr.length);
        Arrays.sort(jArr, i3, i4);
        reverse(jArr, i3, i4);
    }

    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i3 = 0; i3 < length; i3++) {
            jArr[i3] = ((Number) Preconditions.checkNotNull(array[i3])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j3) {
        byte[] bArr = new byte[8];
        for (int i3 = 7; i3 >= 0; i3--) {
            bArr[i3] = (byte) (255 & j3);
            j3 >>= 8;
        }
        return bArr;
    }

    @CheckForNull
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    @CheckForNull
    public static Long tryParse(String str, int i3) {
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i3 < 2 || i3 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i3);
        }
        int i4 = str.charAt(0) == '-' ? 1 : 0;
        if (i4 == str.length()) {
            return null;
        }
        int i5 = i4 + 1;
        int digit = AsciiDigits.digit(str.charAt(i4));
        if (digit < 0 || digit >= i3) {
            return null;
        }
        long j3 = -digit;
        long j4 = i3;
        long j5 = Long.MIN_VALUE / j4;
        while (i5 < str.length()) {
            int i6 = i5 + 1;
            int digit2 = AsciiDigits.digit(str.charAt(i5));
            if (digit2 < 0 || digit2 >= i3 || j3 < j5) {
                return null;
            }
            long j6 = j3 * j4;
            long j7 = digit2;
            if (j6 < j7 - Long.MIN_VALUE) {
                return null;
            }
            j3 = j6 - j7;
            i5 = i6;
        }
        if (i4 != 0) {
            return Long.valueOf(j3);
        }
        if (j3 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j3);
    }
}
