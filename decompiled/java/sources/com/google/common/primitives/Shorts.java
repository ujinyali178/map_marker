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
public final class Shorts extends ShortsMethodsForWeb {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    private enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = Shorts.compare(sArr[i3], sArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        ShortArrayAsList(short[] sArr, int i3, int i4) {
            this.array = sArr;
            this.start = i3;
            this.end = i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.array[this.start + i3] != shortArrayAsList.array[shortArrayAsList.start + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Short.valueOf(this.array[this.start + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.start; i4 < this.end; i4++) {
                i3 = (i3 * 31) + Shorts.hashCode(this.array[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            if (!(obj instanceof Short) || (indexOf = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Short) || (lastIndexOf = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int i3, Short sh) {
            Preconditions.checkElementIndex(i3, size());
            short[] sArr = this.array;
            int i4 = this.start;
            short s3 = sArr[i4 + i3];
            sArr[i4 + i3] = ((Short) Preconditions.checkNotNull(sh)).shortValue();
            return Short.valueOf(s3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i5 = this.start;
            return new ShortArrayAsList(sArr, i3 + i5, i5 + i4);
        }

        short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i3 = this.start;
            while (true) {
                i3++;
                if (i3 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.array[i3]);
            }
        }
    }

    private static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Short sh) {
            return sh.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Short doForward(String str) {
            return Short.decode(str);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }
    }

    private Shorts() {
    }

    public static List<Short> asList(short... sArr) {
        return sArr.length == 0 ? Collections.emptyList() : new ShortArrayAsList(sArr);
    }

    public static short checkedCast(long j3) {
        short s3 = (short) j3;
        Preconditions.checkArgument(((long) s3) == j3, "Out of range: %s", j3);
        return s3;
    }

    public static int compare(short s3, short s4) {
        return s3 - s4;
    }

    public static short[] concat(short[]... sArr) {
        int i3 = 0;
        for (short[] sArr2 : sArr) {
            i3 += sArr2.length;
        }
        short[] sArr3 = new short[i3];
        int i4 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, i4, sArr4.length);
            i4 += sArr4.length;
        }
        return sArr3;
    }

    public static short constrainToRange(short s3, short s4, short s5) {
        Preconditions.checkArgument(s4 <= s5, "min (%s) must be less than or equal to max (%s)", (int) s4, (int) s5);
        return s3 < s4 ? s4 : s3 < s5 ? s3 : s5;
    }

    public static boolean contains(short[] sArr, short s3) {
        for (short s4 : sArr) {
            if (s4 == s3) {
                return true;
            }
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArr, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0, "Invalid minLength: %s", i3);
        Preconditions.checkArgument(i4 >= 0, "Invalid padding: %s", i4);
        return sArr.length < i3 ? Arrays.copyOf(sArr, i3 + i4) : sArr;
    }

    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    public static short fromBytes(byte b4, byte b5) {
        return (short) ((b4 << 8) | (b5 & UnsignedBytes.MAX_VALUE));
    }

    public static int hashCode(short s3) {
        return s3;
    }

    public static int indexOf(short[] sArr, short s3) {
        return indexOf(sArr, s3, 0, sArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(short[] sArr, short s3, int i3, int i4) {
        while (i3 < i4) {
            if (sArr[i3] == s3) {
                return i3;
            }
            i3++;
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
    public static int indexOf(short[] r5, short[] r6) {
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
            short r3 = r5[r3]
            short r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Shorts.indexOf(short[], short[]):int");
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i3 = 1; i3 < sArr.length; i3++) {
            sb.append(str);
            sb.append((int) sArr[i3]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(short[] sArr, short s3) {
        return lastIndexOf(sArr, s3, 0, sArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(short[] sArr, short s3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (sArr[i5] == s3) {
                return i5;
            }
        }
        return -1;
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s3 = sArr[0];
        for (int i3 = 1; i3 < sArr.length; i3++) {
            short s4 = sArr[i3];
            if (s4 > s3) {
                s3 = s4;
            }
        }
        return s3;
    }

    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s3 = sArr[0];
        for (int i3 = 1; i3 < sArr.length; i3++) {
            short s4 = sArr[i3];
            if (s4 < s3) {
                s3 = s4;
            }
        }
        return s3;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static void reverse(short[] sArr, int i3, int i4) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i3, i4, sArr.length);
        for (int i5 = i4 - 1; i3 < i5; i5--) {
            short s3 = sArr[i3];
            sArr[i3] = sArr[i5];
            sArr[i5] = s3;
            i3++;
        }
    }

    public static void rotate(short[] sArr, int i3) {
        rotate(sArr, i3, 0, sArr.length);
    }

    public static void rotate(short[] sArr, int i3, int i4, int i5) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i4, i5, sArr.length);
        if (sArr.length <= 1) {
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
        reverse(sArr, i4, i8);
        reverse(sArr, i8, i5);
        reverse(sArr, i4, i5);
    }

    public static short saturatedCast(long j3) {
        if (j3 > 32767) {
            return Short.MAX_VALUE;
        }
        if (j3 < -32768) {
            return Short.MIN_VALUE;
        }
        return (short) j3;
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    public static void sortDescending(short[] sArr, int i3, int i4) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i3, i4, sArr.length);
        Arrays.sort(sArr, i3, i4);
        reverse(sArr, i3, i4);
    }

    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            sArr[i3] = ((Number) Preconditions.checkNotNull(array[i3])).shortValue();
        }
        return sArr;
    }

    public static byte[] toByteArray(short s3) {
        return new byte[]{(byte) (s3 >> 8), (byte) s3};
    }
}
