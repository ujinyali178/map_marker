package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    static final int DEFAULT_SIZE = 3;
    static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    static final int MAX_SIZE = 1073741823;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    static final byte UNSET = 0;

    private CompactHashing() {
    }

    static Object createTable(int i3) {
        if (i3 >= 2 && i3 <= 1073741824 && Integer.highestOneBit(i3) == i3) {
            return i3 <= 256 ? new byte[i3] : i3 <= SHORT_MAX_SIZE ? new short[i3] : new int[i3];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i3);
    }

    static int getHashPrefix(int i3, int i4) {
        return i3 & (~i4);
    }

    static int getNext(int i3, int i4) {
        return i3 & i4;
    }

    static int maskCombine(int i3, int i4, int i5) {
        return (i3 & (~i5)) | (i4 & i5);
    }

    static int newCapacity(int i3) {
        return (i3 < 32 ? 4 : 2) * (i3 + 1);
    }

    static int remove(@CheckForNull Object obj, @CheckForNull Object obj2, int i3, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i4;
        int i5;
        int smearedHash = Hashing.smearedHash(obj);
        int i6 = smearedHash & i3;
        int tableGet = tableGet(obj3, i6);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = getHashPrefix(smearedHash, i3);
        int i7 = -1;
        while (true) {
            i4 = tableGet - 1;
            i5 = iArr[i4];
            if (getHashPrefix(i5, i3) != hashPrefix || !Objects.equal(obj, objArr[i4]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i4]))) {
                int next = getNext(i5, i3);
                if (next == 0) {
                    return -1;
                }
                i7 = i4;
                tableGet = next;
            }
        }
        int next2 = getNext(i5, i3);
        if (i7 == -1) {
            tableSet(obj3, i6, next2);
        } else {
            iArr[i7] = maskCombine(iArr[i7], next2, i3);
        }
        return i4;
    }

    static void tableClear(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    static int tableGet(Object obj, int i3) {
        return obj instanceof byte[] ? ((byte[]) obj)[i3] & UnsignedBytes.MAX_VALUE : obj instanceof short[] ? ((short[]) obj)[i3] & SHORT_MASK : ((int[]) obj)[i3];
    }

    static void tableSet(Object obj, int i3, int i4) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i3] = (byte) i4;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i3] = (short) i4;
        } else {
            ((int[]) obj)[i3] = i4;
        }
    }

    static int tableSize(int i3) {
        return Math.max(4, Hashing.closedTableSize(i3 + 1, 1.0d));
    }
}
