package com.google.common.math;

import java.math.BigInteger;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class MathPreconditions {
    private MathPreconditions() {
    }

    static void checkInRangeForRoundingInputs(boolean z3, double d3, RoundingMode roundingMode) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d3 + " and rounding mode " + roundingMode);
    }

    static void checkNoOverflow(boolean z3, String str, int i3, int i4) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i3 + ", " + i4 + ")");
    }

    static void checkNoOverflow(boolean z3, String str, long j3, long j4) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j3 + ", " + j4 + ")");
    }

    static double checkNonNegative(String str, double d3) {
        if (d3 >= 0.0d) {
            return d3;
        }
        throw new IllegalArgumentException(str + " (" + d3 + ") must be >= 0");
    }

    static int checkNonNegative(String str, int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " (" + i3 + ") must be >= 0");
    }

    static long checkNonNegative(String str, long j3) {
        if (j3 >= 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " (" + j3 + ") must be >= 0");
    }

    static BigInteger checkNonNegative(String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    static int checkPositive(String str, int i3) {
        if (i3 > 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " (" + i3 + ") must be > 0");
    }

    static long checkPositive(String str, long j3) {
        if (j3 > 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " (" + j3 + ") must be > 0");
    }

    static BigInteger checkPositive(String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    static void checkRoundingUnnecessary(boolean z3) {
        if (!z3) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
