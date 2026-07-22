package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class UnsignedInts {
    static final long INT_MASK = 4294967295L;

    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int i4 = iArr[i3];
                int i5 = iArr2[i3];
                if (i4 != i5) {
                    return UnsignedInts.compare(i4, i5);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    private UnsignedInts() {
    }

    public static int checkedCast(long j3) {
        Preconditions.checkArgument((j3 >> 32) == 0, "out of range: %s", j3);
        return (int) j3;
    }

    public static int compare(int i3, int i4) {
        return Ints.compare(flip(i3), flip(i4));
    }

    public static int decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e3) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e3);
            throw numberFormatException;
        }
    }

    public static int divide(int i3, int i4) {
        return (int) (toLong(i3) / toLong(i4));
    }

    static int flip(int i3) {
        return i3 ^ Integer.MIN_VALUE;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        for (int i3 = 1; i3 < iArr.length; i3++) {
            sb.append(str);
            sb.append(toString(iArr[i3]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int flip2 = flip(iArr[i3]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int flip2 = flip(iArr[i3]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int parseUnsignedInt(String str, int i3) {
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong(str, i3);
        if ((INT_MASK & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i3 + " is not in the range of an unsigned integer");
    }

    public static int remainder(int i3, int i4) {
        return (int) (toLong(i3) % toLong(i4));
    }

    public static int saturatedCast(long j3) {
        if (j3 <= 0) {
            return 0;
        }
        if (j3 >= 4294967296L) {
            return -1;
        }
        return (int) j3;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sort(int[] iArr, int i3, int i4) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i3, i4, iArr.length);
        for (int i5 = i3; i5 < i4; i5++) {
            iArr[i5] = flip(iArr[i5]);
        }
        Arrays.sort(iArr, i3, i4);
        while (i3 < i4) {
            iArr[i3] = flip(iArr[i3]);
            i3++;
        }
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr, int i3, int i4) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i3, i4, iArr.length);
        for (int i5 = i3; i5 < i4; i5++) {
            iArr[i5] = Integer.MAX_VALUE ^ iArr[i5];
        }
        Arrays.sort(iArr, i3, i4);
        while (i3 < i4) {
            iArr[i3] = iArr[i3] ^ Integer.MAX_VALUE;
            i3++;
        }
    }

    public static long toLong(int i3) {
        return i3 & INT_MASK;
    }

    public static String toString(int i3) {
        return toString(i3, 10);
    }

    public static String toString(int i3, int i4) {
        return Long.toString(i3 & INT_MASK, i4);
    }
}
