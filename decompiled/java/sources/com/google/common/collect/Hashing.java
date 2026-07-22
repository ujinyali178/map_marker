package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    static int closedTableSize(int i3, double d3) {
        int max = Math.max(i3, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d3 * highestOneBit))) {
            return highestOneBit;
        }
        int i4 = highestOneBit << 1;
        if (i4 > 0) {
            return i4;
        }
        return 1073741824;
    }

    static boolean needsResizing(int i3, int i4, double d3) {
        return ((double) i3) > d3 * ((double) i4) && i4 < 1073741824;
    }

    static int smear(int i3) {
        return (int) (Integer.rotateLeft((int) (i3 * C1), 15) * C2);
    }

    static int smearedHash(@CheckForNull Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
