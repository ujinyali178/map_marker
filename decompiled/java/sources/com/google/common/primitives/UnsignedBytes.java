package com.google.common.primitives;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    static class LexicographicalComparatorHolder {
        static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
        static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();

        enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i3 = 0; i3 < min; i3++) {
                    int compare = UnsignedBytes.compare(bArr[i3], bArr2[i3]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            static {
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int arrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe getUnsafe() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e3) {
                        throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
                        @Override // java.security.PrivilegedExceptionAction
                        public Unsafe run() {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i3 = min & (-8);
                int i4 = 0;
                while (i4 < i3) {
                    Unsafe unsafe = theUnsafe;
                    int i5 = BYTE_ARRAY_BASE_OFFSET;
                    long j3 = i4;
                    long j4 = unsafe.getLong(bArr, i5 + j3);
                    long j5 = unsafe.getLong(bArr2, i5 + j3);
                    if (j4 != j5) {
                        if (BIG_ENDIAN) {
                            return UnsignedLongs.compare(j4, j5);
                        }
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4 ^ j5) & (-8);
                        return ((int) ((j4 >>> numberOfTrailingZeros) & 255)) - ((int) ((j5 >>> numberOfTrailingZeros) & 255));
                    }
                    i4 += 8;
                }
                while (i4 < min) {
                    int compare = UnsignedBytes.compare(bArr[i4], bArr2[i4]);
                    if (compare != 0) {
                        return compare;
                    }
                    i4++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        LexicographicalComparatorHolder() {
        }

        static Comparator<byte[]> getBestComparator() {
            try {
                Object[] enumConstants = Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    private UnsignedBytes() {
    }

    public static byte checkedCast(long j3) {
        Preconditions.checkArgument((j3 >> 8) == 0, "out of range: %s", j3);
        return (byte) j3;
    }

    public static int compare(byte b4, byte b5) {
        return toInt(b4) - toInt(b5);
    }

    private static byte flip(byte b4) {
        return (byte) (b4 ^ MAX_POWER_OF_TWO);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(toInt(bArr[0]));
        for (int i3 = 1; i3 < bArr.length; i3++) {
            sb.append(str);
            sb.append(toString(bArr[i3]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i3 = toInt(bArr[0]);
        for (int i4 = 1; i4 < bArr.length; i4++) {
            int i5 = toInt(bArr[i4]);
            if (i5 > i3) {
                i3 = i5;
            }
        }
        return (byte) i3;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i3 = toInt(bArr[0]);
        for (int i4 = 1; i4 < bArr.length; i4++) {
            int i5 = toInt(bArr[i4]);
            if (i5 < i3) {
                i3 = i5;
            }
        }
        return (byte) i3;
    }

    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte parseUnsignedByte(String str, int i3) {
        int parseInt = Integer.parseInt((String) Preconditions.checkNotNull(str), i3);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException("out of range: " + parseInt);
    }

    public static byte saturatedCast(long j3) {
        if (j3 > toInt((byte) -1)) {
            return (byte) -1;
        }
        if (j3 < 0) {
            return (byte) 0;
        }
        return (byte) j3;
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sort(byte[] bArr, int i3, int i4) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i3, i4, bArr.length);
        for (int i5 = i3; i5 < i4; i5++) {
            bArr[i5] = flip(bArr[i5]);
        }
        Arrays.sort(bArr, i3, i4);
        while (i3 < i4) {
            bArr[i3] = flip(bArr[i3]);
            i3++;
        }
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i3, int i4) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i3, i4, bArr.length);
        for (int i5 = i3; i5 < i4; i5++) {
            bArr[i5] = (byte) (bArr[i5] ^ Ascii.DEL);
        }
        Arrays.sort(bArr, i3, i4);
        while (i3 < i4) {
            bArr[i3] = (byte) (bArr[i3] ^ Ascii.DEL);
            i3++;
        }
    }

    public static int toInt(byte b4) {
        return b4 & MAX_VALUE;
    }

    public static String toString(byte b4) {
        return toString(b4, 10);
    }

    public static String toString(byte b4, int i3) {
        Preconditions.checkArgument(i3 >= 2 && i3 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i3);
        return Integer.toString(toInt(b4), i3);
    }
}
