package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                long j3 = jArr[i3];
                long j4 = jArr2[i3];
                if (j3 != j4) {
                    return UnsignedLongs.compare(j3, j4);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    private static final class ParseOverflowDetection {
        static final long[] maxValueDivs = new long[37];
        static final int[] maxValueMods = new int[37];
        static final int[] maxSafeDigits = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i3 = 2; i3 <= 36; i3++) {
                long j3 = i3;
                maxValueDivs[i3] = UnsignedLongs.divide(-1L, j3);
                maxValueMods[i3] = (int) UnsignedLongs.remainder(-1L, j3);
                maxSafeDigits[i3] = bigInteger.toString(i3).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        static boolean overflowInParse(long j3, int i3, int i4) {
            if (j3 < 0) {
                return true;
            }
            long j4 = maxValueDivs[i4];
            if (j3 < j4) {
                return false;
            }
            return j3 > j4 || i3 > maxValueMods[i4];
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long j3, long j4) {
        return Longs.compare(flip(j3), flip(j4));
    }

    public static long decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e3) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e3);
            throw numberFormatException;
        }
    }

    public static long divide(long j3, long j4) {
        if (j4 < 0) {
            return compare(j3, j4) < 0 ? 0L : 1L;
        }
        if (j3 >= 0) {
            return j3 / j4;
        }
        long j5 = ((j3 >>> 1) / j4) << 1;
        return j5 + (compare(j3 - (j5 * j4), j4) < 0 ? 0 : 1);
    }

    private static long flip(long j3) {
        return j3 ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i3 = 1; i3 < jArr.length; i3++) {
            sb.append(str);
            sb.append(toString(jArr[i3]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long flip2 = flip(jArr[i3]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long flip2 = flip(jArr[i3]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long parseUnsignedLong(String str, int i3) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i3 < 2 || i3 > 36) {
            throw new NumberFormatException("illegal radix: " + i3);
        }
        int i4 = ParseOverflowDetection.maxSafeDigits[i3] - 1;
        long j3 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            int digit = Character.digit(str.charAt(i5), i3);
            if (digit == -1) {
                throw new NumberFormatException(str);
            }
            if (i5 > i4 && ParseOverflowDetection.overflowInParse(j3, digit, i3)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j3 = (j3 * i3) + digit;
        }
        return j3;
    }

    public static long remainder(long j3, long j4) {
        if (j4 < 0) {
            return compare(j3, j4) < 0 ? j3 : j3 - j4;
        }
        if (j3 >= 0) {
            return j3 % j4;
        }
        long j5 = j3 - ((((j3 >>> 1) / j4) << 1) * j4);
        if (compare(j5, j4) < 0) {
            j4 = 0;
        }
        return j5 - j4;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sort(long[] jArr, int i3, int i4) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i3, i4, jArr.length);
        for (int i5 = i3; i5 < i4; i5++) {
            jArr[i5] = flip(jArr[i5]);
        }
        Arrays.sort(jArr, i3, i4);
        while (i3 < i4) {
            jArr[i3] = flip(jArr[i3]);
            i3++;
        }
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr, int i3, int i4) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i3, i4, jArr.length);
        for (int i5 = i3; i5 < i4; i5++) {
            jArr[i5] = Long.MAX_VALUE ^ jArr[i5];
        }
        Arrays.sort(jArr, i3, i4);
        while (i3 < i4) {
            jArr[i3] = jArr[i3] ^ Long.MAX_VALUE;
            i3++;
        }
    }

    public static String toString(long j3) {
        return toString(j3, 10);
    }

    public static String toString(long j3, int i3) {
        Preconditions.checkArgument(i3 >= 2 && i3 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i3);
        if (j3 == 0) {
            return "0";
        }
        if (j3 > 0) {
            return Long.toString(j3, i3);
        }
        int i4 = 64;
        char[] cArr = new char[64];
        int i5 = i3 - 1;
        if ((i3 & i5) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i3);
            do {
                i4--;
                cArr[i4] = Character.forDigit(((int) j3) & i5, i3);
                j3 >>>= numberOfTrailingZeros;
            } while (j3 != 0);
        } else {
            long divide = (i3 & 1) == 0 ? (j3 >>> 1) / (i3 >>> 1) : divide(j3, i3);
            long j4 = i3;
            cArr[63] = Character.forDigit((int) (j3 - (divide * j4)), i3);
            i4 = 63;
            while (divide > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (divide % j4), i3);
                divide /= j4;
            }
        }
        return new String(cArr, i4, 64 - i4);
    }
}
