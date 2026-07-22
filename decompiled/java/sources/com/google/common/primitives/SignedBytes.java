package com.google.common.primitives;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = SignedBytes.compare(bArr[i3], bArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long j3) {
        byte b4 = (byte) j3;
        Preconditions.checkArgument(((long) b4) == j3, "Out of range: %s", j3);
        return b4;
    }

    public static int compare(byte b4, byte b5) {
        return b4 - b5;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i3 = 1; i3 < bArr.length; i3++) {
            sb.append(str);
            sb.append((int) bArr[i3]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b4 = bArr[0];
        for (int i3 = 1; i3 < bArr.length; i3++) {
            byte b5 = bArr[i3];
            if (b5 > b4) {
                b4 = b5;
            }
        }
        return b4;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b4 = bArr[0];
        for (int i3 = 1; i3 < bArr.length; i3++) {
            byte b5 = bArr[i3];
            if (b5 < b4) {
                b4 = b5;
            }
        }
        return b4;
    }

    public static byte saturatedCast(long j3) {
        return j3 > 127 ? Ascii.DEL : j3 < -128 ? UnsignedBytes.MAX_POWER_OF_TWO : (byte) j3;
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i3, int i4) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i3, i4, bArr.length);
        Arrays.sort(bArr, i3, i4);
        Bytes.reverse(bArr, i3, i4);
    }
}
