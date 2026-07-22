package com.google.common.math;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class LongMath {
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final byte[] maxLog10ForLeadingZeros = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long j3, long j4, long j5) {
                return (j3 * j4) % j5;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long j3, long j4) {
                return (j3 * j3) % j4;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j3, long j4, long j5) {
                long j6 = j3 + j4;
                return j3 >= j5 - j4 ? j6 - j5 : j6;
            }

            private long times2ToThe32Mod(long j3, long j4) {
                int i3 = 32;
                do {
                    int min = Math.min(i3, Long.numberOfLeadingZeros(j3));
                    j3 = UnsignedLongs.remainder(j3 << min, j4);
                    i3 -= min;
                } while (i3 > 0);
                return j3;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long j3, long j4, long j5) {
                long j6 = j3 >>> 32;
                long j7 = j4 >>> 32;
                long j8 = j3 & 4294967295L;
                long j9 = j4 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j6 * j7, j5) + (j6 * j9);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j5);
                }
                Long.signum(j8);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j7 * j8), j5), UnsignedLongs.remainder(j8 * j9, j5), j5);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long j3, long j4) {
                long j5 = j3 >>> 32;
                long j6 = j3 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j5 * j5, j4);
                long j7 = j5 * j6 * 2;
                if (j7 < 0) {
                    j7 = UnsignedLongs.remainder(j7, j4);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j7, j4), UnsignedLongs.remainder(j6 * j6, j4), j4);
            }
        };

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }

        private long powMod(long j3, long j4, long j5) {
            long j6 = 1;
            while (j4 != 0) {
                if ((j4 & 1) != 0) {
                    j6 = mulMod(j6, j3, j5);
                }
                j3 = squareMod(j3, j5);
                j4 >>= 1;
            }
            return j6;
        }

        static boolean test(long j3, long j4) {
            return (j4 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j3, j4);
        }

        private boolean testWitness(long j3, long j4) {
            long j5 = j4 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j5);
            long j6 = j5 >> numberOfTrailingZeros;
            long j7 = j3 % j4;
            if (j7 == 0) {
                return true;
            }
            long powMod = powMod(j7, j6, j4);
            if (powMod == 1) {
                return true;
            }
            int i3 = 0;
            while (powMod != j5) {
                i3++;
                if (i3 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j4);
            }
            return true;
        }

        abstract long mulMod(long j3, long j4, long j5);

        abstract long squareMod(long j3, long j4);
    }

    private LongMath() {
    }

    public static long binomial(int i3, int i4) {
        MathPreconditions.checkNonNegative("n", i3);
        MathPreconditions.checkNonNegative("k", i4);
        Preconditions.checkArgument(i4 <= i3, "k (%s) > n (%s)", i4, i3);
        if (i4 > (i3 >> 1)) {
            i4 = i3 - i4;
        }
        long j3 = 1;
        if (i4 == 0) {
            return 1L;
        }
        if (i4 == 1) {
            return i3;
        }
        long[] jArr = factorials;
        if (i3 < jArr.length) {
            return jArr[i3] / (jArr[i4] * jArr[i3 - i4]);
        }
        int[] iArr = biggestBinomials;
        if (i4 >= iArr.length || i3 > iArr[i4]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i4 < iArr2.length && i3 <= iArr2[i4]) {
            int i5 = i3 - 1;
            long j4 = i3;
            for (int i6 = 2; i6 <= i4; i6++) {
                j4 = (j4 * i5) / i6;
                i5--;
            }
            return j4;
        }
        long j5 = i3;
        int log2 = log2(j5, RoundingMode.CEILING);
        int i7 = i3 - 1;
        int i8 = log2;
        long j6 = j5;
        int i9 = 2;
        long j7 = 1;
        while (i9 <= i4) {
            i8 += log2;
            if (i8 < 63) {
                j6 *= i7;
                j7 *= i9;
            } else {
                j3 = multiplyFraction(j3, j6, j7);
                j6 = i7;
                j7 = i9;
                i8 = log2;
            }
            i9++;
            i7--;
        }
        return multiplyFraction(j3, j6, j7);
    }

    public static long ceilingPowerOfTwo(long j3) {
        MathPreconditions.checkPositive("x", j3);
        if (j3 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j3 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j3 + ") is not representable as a long");
    }

    public static long checkedAdd(long j3, long j4) {
        long j5 = j3 + j4;
        MathPreconditions.checkNoOverflow(((j3 ^ j4) < 0) | ((j3 ^ j5) >= 0), "checkedAdd", j3, j4);
        return j5;
    }

    public static long checkedMultiply(long j3, long j4) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4);
        if (numberOfLeadingZeros > 65) {
            return j3 * j4;
        }
        MathPreconditions.checkNoOverflow(numberOfLeadingZeros >= 64, "checkedMultiply", j3, j4);
        MathPreconditions.checkNoOverflow((j3 >= 0) | (j4 != Long.MIN_VALUE), "checkedMultiply", j3, j4);
        long j5 = j3 * j4;
        MathPreconditions.checkNoOverflow(j3 == 0 || j5 / j3 == j4, "checkedMultiply", j3, j4);
        return j5;
    }

    public static long checkedPow(long j3, int i3) {
        int i4 = i3;
        MathPreconditions.checkNonNegative("exponent", i4);
        if ((j3 >= -2) && (j3 <= 2)) {
            int i5 = (int) j3;
            if (i5 == -2) {
                MathPreconditions.checkNoOverflow(i4 < 64, "checkedPow", j3, i4);
                return (i4 & 1) == 0 ? 1 << i4 : (-1) << i4;
            }
            if (i5 == -1) {
                return (i4 & 1) == 0 ? 1L : -1L;
            }
            if (i5 == 0) {
                return i4 == 0 ? 1L : 0L;
            }
            if (i5 == 1) {
                return 1L;
            }
            if (i5 != 2) {
                throw new AssertionError();
            }
            MathPreconditions.checkNoOverflow(i4 < 63, "checkedPow", j3, i4);
            return 1 << i4;
        }
        long j4 = 1;
        long j5 = j3;
        while (i4 != 0) {
            if (i4 == 1) {
                return checkedMultiply(j4, j5);
            }
            if ((i4 & 1) != 0) {
                j4 = checkedMultiply(j4, j5);
            }
            long j6 = j4;
            int i6 = i4 >> 1;
            if (i6 > 0) {
                MathPreconditions.checkNoOverflow(-3037000499L <= j5 && j5 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j5, i6);
                j5 *= j5;
            }
            j4 = j6;
            i4 = i6;
        }
        return j4;
    }

    public static long checkedSubtract(long j3, long j4) {
        long j5 = j3 - j4;
        MathPreconditions.checkNoOverflow(((j3 ^ j4) >= 0) | ((j3 ^ j5) >= 0), "checkedSubtract", j3, j4);
        return j5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r10 > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        if (r10 < 0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            return r0
        L10:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r10 = (int) r9
            r9 = 1
            r10 = r10 | r9
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L47
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 == r11) goto L58
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r11) goto L57
            r11 = 1
            long r11 = r11 & r0
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L57
            goto L58
        L47:
            if (r11 <= 0) goto L57
            goto L58
        L4a:
            if (r10 <= 0) goto L57
            goto L58
        L4d:
            if (r10 >= 0) goto L57
            goto L58
        L50:
            if (r6 != 0) goto L53
            goto L54
        L53:
            r9 = 0
        L54:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r9)
        L57:
            r9 = 0
        L58:
            if (r9 == 0) goto L5c
            long r9 = (long) r10
            long r0 = r0 + r9
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    public static long factorial(int i3) {
        MathPreconditions.checkNonNegative("n", i3);
        long[] jArr = factorials;
        if (i3 < jArr.length) {
            return jArr[i3];
        }
        return Long.MAX_VALUE;
    }

    static boolean fitsInInt(long j3) {
        return ((long) ((int) j3)) == j3;
    }

    public static long floorPowerOfTwo(long j3) {
        MathPreconditions.checkPositive("x", j3);
        return 1 << (63 - Long.numberOfLeadingZeros(j3));
    }

    public static long gcd(long j3, long j4) {
        MathPreconditions.checkNonNegative("a", j3);
        MathPreconditions.checkNonNegative("b", j4);
        if (j3 == 0) {
            return j4;
        }
        if (j4 == 0) {
            return j3;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
        long j5 = j3 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j4);
        long j6 = j4 >> numberOfTrailingZeros2;
        while (j5 != j6) {
            long j7 = j5 - j6;
            long j8 = (j7 >> 63) & j7;
            long j9 = (j7 - j8) - j8;
            j6 += j8;
            j5 = j9 >> Long.numberOfTrailingZeros(j9);
        }
        return j5 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j3) {
        return (j3 > 0) & ((j3 & (j3 - 1)) == 0);
    }

    public static boolean isPrime(long j3) {
        if (j3 < 2) {
            MathPreconditions.checkNonNegative("n", j3);
            return false;
        }
        if (j3 < 66) {
            return ((722865708377213483 >> (((int) j3) + (-2))) & 1) != 0;
        }
        if ((SIEVE_30 & (1 << ((int) (j3 % 30)))) != 0 || j3 % 7 == 0 || j3 % 11 == 0 || j3 % 13 == 0) {
            return false;
        }
        if (j3 < 289) {
            return true;
        }
        for (long[] jArr : millerRabinBaseSets) {
            if (j3 <= jArr[0]) {
                for (int i3 = 1; i3 < jArr.length; i3++) {
                    if (!MillerRabinTester.test(jArr[i3], j3)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    static int lessThanBranchFree(long j3, long j4) {
        return (int) ((~(~(j3 - j4))) >>> 63);
    }

    public static int log10(long j3, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", j3);
        int log10Floor = log10Floor(j3);
        long j4 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j3 == j4);
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(j4, j3);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], j3);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    static int log10Floor(long j3) {
        byte b4 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j3)];
        return b4 - lessThanBranchFree(j3, powersOf10[b4]);
    }

    public static int log2(long j3, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j3);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j3));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j3 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j3);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j3);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j3);
    }

    public static long mean(long j3, long j4) {
        return (j3 & j4) + ((j3 ^ j4) >> 1);
    }

    public static int mod(long j3, int i3) {
        return (int) mod(j3, i3);
    }

    public static long mod(long j3, long j4) {
        if (j4 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j5 = j3 % j4;
        return j5 >= 0 ? j5 : j5 + j4;
    }

    static long multiplyFraction(long j3, long j4, long j5) {
        if (j3 == 1) {
            return j4 / j5;
        }
        long gcd = gcd(j3, j5);
        return (j3 / gcd) * (j4 / (j5 / gcd));
    }

    public static long pow(long j3, int i3) {
        MathPreconditions.checkNonNegative("exponent", i3);
        if (-2 > j3 || j3 > 2) {
            long j4 = 1;
            while (i3 != 0) {
                if (i3 == 1) {
                    return j4 * j3;
                }
                j4 *= (i3 & 1) == 0 ? 1L : j3;
                j3 *= j3;
                i3 >>= 1;
            }
            return j4;
        }
        int i4 = (int) j3;
        if (i4 == -2) {
            if (i3 < 64) {
                return (i3 & 1) == 0 ? 1 << i3 : -(1 << i3);
            }
            return 0L;
        }
        if (i4 == -1) {
            return (i3 & 1) == 0 ? 1L : -1L;
        }
        if (i4 == 0) {
            return i3 == 0 ? 1L : 0L;
        }
        if (i4 == 1) {
            return 1L;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        if (i3 < 64) {
            return 1 << i3;
        }
        return 0L;
    }

    public static double roundToDouble(long j3, RoundingMode roundingMode) {
        double d3;
        long j4;
        double d4 = j3;
        long j5 = (long) d4;
        int compare = j5 == Long.MAX_VALUE ? -1 : Longs.compare(j3, j5);
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(compare == 0);
                return d4;
            case 2:
                return j3 >= 0 ? compare >= 0 ? d4 : DoubleUtils.nextDown(d4) : compare <= 0 ? d4 : Math.nextUp(d4);
            case 3:
                return compare >= 0 ? d4 : DoubleUtils.nextDown(d4);
            case 4:
                return j3 >= 0 ? compare <= 0 ? d4 : Math.nextUp(d4) : compare >= 0 ? d4 : DoubleUtils.nextDown(d4);
            case 5:
                return compare <= 0 ? d4 : Math.nextUp(d4);
            case 6:
            case 7:
            case 8:
                if (compare >= 0) {
                    d3 = Math.nextUp(d4);
                    j4 = (long) Math.ceil(d3);
                } else {
                    double nextDown = DoubleUtils.nextDown(d4);
                    j5 = (long) Math.floor(nextDown);
                    d3 = d4;
                    d4 = nextDown;
                    j4 = j5;
                }
                long j6 = j3 - j5;
                long j7 = j4 - j3;
                if (j4 == Long.MAX_VALUE) {
                    j7++;
                }
                int compare2 = Longs.compare(j6, j7);
                if (compare2 < 0) {
                    return d4;
                }
                if (compare2 > 0) {
                    return d3;
                }
                int i3 = iArr[roundingMode.ordinal()];
                if (i3 == 6) {
                    return j3 >= 0 ? d4 : d3;
                }
                if (i3 == 7) {
                    return j3 >= 0 ? d3 : d4;
                }
                if (i3 == 8) {
                    return (DoubleUtils.getSignificand(d4) & 1) == 0 ? d4 : d3;
                }
                throw new AssertionError("impossible");
            default:
                throw new AssertionError("impossible");
        }
    }

    public static long saturatedAdd(long j3, long j4) {
        long j5 = j3 + j4;
        return (((j4 ^ j3) > 0L ? 1 : ((j4 ^ j3) == 0L ? 0 : -1)) < 0) | ((j3 ^ j5) >= 0) ? j5 : ((j5 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long saturatedMultiply(long j3, long j4) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4);
        if (numberOfLeadingZeros > 65) {
            return j3 * j4;
        }
        long j5 = ((j3 ^ j4) >>> 63) + Long.MAX_VALUE;
        if ((numberOfLeadingZeros < 64) || ((j4 == Long.MIN_VALUE) & (j3 < 0))) {
            return j5;
        }
        long j6 = j3 * j4;
        return (j3 == 0 || j6 / j3 == j4) ? j6 : j5;
    }

    public static long saturatedPow(long j3, int i3) {
        MathPreconditions.checkNonNegative("exponent", i3);
        long j4 = 1;
        if (!(j3 >= -2) || !(j3 <= 2)) {
            long j5 = ((j3 >>> 63) & i3 & 1) + Long.MAX_VALUE;
            while (i3 != 0) {
                if (i3 == 1) {
                    return saturatedMultiply(j4, j3);
                }
                if ((i3 & 1) != 0) {
                    j4 = saturatedMultiply(j4, j3);
                }
                i3 >>= 1;
                if (i3 > 0) {
                    if ((-3037000499L > j3) || (j3 > FLOOR_SQRT_MAX_LONG)) {
                        return j5;
                    }
                    j3 *= j3;
                }
            }
            return j4;
        }
        int i4 = (int) j3;
        if (i4 == -2) {
            return i3 >= 64 ? (i3 & 1) + Long.MAX_VALUE : (i3 & 1) == 0 ? 1 << i3 : (-1) << i3;
        }
        if (i4 == -1) {
            return (i3 & 1) == 0 ? 1L : -1L;
        }
        if (i4 == 0) {
            return i3 == 0 ? 1L : 0L;
        }
        if (i4 == 1) {
            return 1L;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        if (i3 >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i3;
    }

    public static long saturatedSubtract(long j3, long j4) {
        long j5 = j3 - j4;
        return (((j4 ^ j3) > 0L ? 1 : ((j4 ^ j3) == 0L ? 0 : -1)) >= 0) | ((j3 ^ j5) >= 0) ? j5 : ((j5 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long sqrt(long j3, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j3);
        if (fitsInInt(j3)) {
            return IntMath.sqrt((int) j3, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j3);
        long j4 = sqrt * sqrt;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j4 == j3);
                return sqrt;
            case 2:
            case 3:
                return j3 < j4 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j3 > j4 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                return (sqrt - (j3 >= j4 ? 0 : 1)) + lessThanBranchFree((r0 * r0) + r0, j3);
            default:
                throw new AssertionError();
        }
    }
}
