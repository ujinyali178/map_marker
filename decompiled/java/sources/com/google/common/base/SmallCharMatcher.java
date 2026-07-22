package com.google.common.base;

import com.google.common.base.CharMatcher;
import java.util.BitSet;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j3, boolean z3, String str) {
        super(str);
        this.table = cArr;
        this.filter = j3;
        this.containsZero = z3;
    }

    private boolean checkFilter(int i3) {
        return 1 == ((this.filter >> i3) & 1);
    }

    static int chooseTableSize(int i3) {
        if (i3 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i3 - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < i3) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    static CharMatcher from(BitSet bitSet, String str) {
        int i3;
        int cardinality = bitSet.cardinality();
        boolean z3 = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int i4 = chooseTableSize - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j3 = 0;
        while (nextSetBit != -1) {
            long j4 = (1 << nextSetBit) | j3;
            int smear = smear(nextSetBit);
            while (true) {
                i3 = smear & i4;
                if (cArr[i3] == 0) {
                    break;
                }
                smear = i3 + 1;
            }
            cArr[i3] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j3 = j4;
        }
        return new SmallCharMatcher(cArr, j3, z3, str);
    }

    static int smear(int i3) {
        return Integer.rotateLeft(i3 * C1, 15) * C2;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c3) {
        if (c3 == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c3)) {
            return false;
        }
        int length = this.table.length - 1;
        int smear = smear(c3) & length;
        int i3 = smear;
        do {
            char c4 = this.table[i3];
            if (c4 == 0) {
                return false;
            }
            if (c4 == c3) {
                return true;
            }
            i3 = (i3 + 1) & length;
        } while (i3 != smear);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c3 : this.table) {
            if (c3 != 0) {
                bitSet.set(c3);
            }
        }
    }
}
