package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    static final long ONE_BITS = 4607182418800017408L;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    static double bigToDouble(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        boolean z3 = true;
        int bitLength = abs.bitLength() - 1;
        if (bitLength < 63) {
            return bigInteger.longValue();
        }
        if (bitLength > EXPONENT_BIAS) {
            return bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int i3 = (bitLength - 52) - 1;
        long longValue = abs.shiftRight(i3).longValue();
        long j3 = (longValue >> 1) & SIGNIFICAND_MASK;
        if ((longValue & 1) == 0 || ((j3 & 1) == 0 && abs.getLowestSetBit() >= i3)) {
            z3 = false;
        }
        if (z3) {
            j3++;
        }
        return Double.longBitsToDouble((((bitLength + EXPONENT_BIAS) << 52) + j3) | (bigInteger.signum() & SIGN_MASK));
    }

    static double ensureNonNegative(double d3) {
        Preconditions.checkArgument(!Double.isNaN(d3));
        return Math.max(d3, 0.0d);
    }

    static long getSignificand(double d3) {
        Preconditions.checkArgument(isFinite(d3), "not a normal value");
        int exponent = Math.getExponent(d3);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d3) & SIGNIFICAND_MASK;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | IMPLICIT_BIT;
    }

    static boolean isFinite(double d3) {
        return Math.getExponent(d3) <= EXPONENT_BIAS;
    }

    static boolean isNormal(double d3) {
        return Math.getExponent(d3) >= -1022;
    }

    static double nextDown(double d3) {
        return -Math.nextUp(-d3);
    }

    static double scaleNormalize(double d3) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d3) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
