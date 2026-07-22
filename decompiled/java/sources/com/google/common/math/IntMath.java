package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import org.kxml2.wap.Wbxml;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class IntMath {
    static final int FLOOR_SQRT_MAX_INT = 46340;
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    static final int[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, Wbxml.EXT_1, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
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

    private IntMath() {
    }

    public static int binomial(int i3, int i4) {
        MathPreconditions.checkNonNegative("n", i3);
        MathPreconditions.checkNonNegative("k", i4);
        int i5 = 0;
        Preconditions.checkArgument(i4 <= i3, "k (%s) > n (%s)", i4, i3);
        if (i4 > (i3 >> 1)) {
            i4 = i3 - i4;
        }
        int[] iArr = biggestBinomials;
        if (i4 >= iArr.length || i3 > iArr[i4]) {
            return Integer.MAX_VALUE;
        }
        if (i4 == 0) {
            return 1;
        }
        if (i4 == 1) {
            return i3;
        }
        long j3 = 1;
        while (i5 < i4) {
            long j4 = j3 * (i3 - i5);
            i5++;
            j3 = j4 / i5;
        }
        return (int) j3;
    }

    public static int ceilingPowerOfTwo(int i3) {
        MathPreconditions.checkPositive("x", i3);
        if (i3 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i3 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i3 + ") not representable as an int");
    }

    public static int checkedAdd(int i3, int i4) {
        long j3 = i3 + i4;
        int i5 = (int) j3;
        MathPreconditions.checkNoOverflow(j3 == ((long) i5), "checkedAdd", i3, i4);
        return i5;
    }

    public static int checkedMultiply(int i3, int i4) {
        long j3 = i3 * i4;
        int i5 = (int) j3;
        MathPreconditions.checkNoOverflow(j3 == ((long) i5), "checkedMultiply", i3, i4);
        return i5;
    }

    public static int checkedPow(int i3, int i4) {
        MathPreconditions.checkNonNegative("exponent", i4);
        if (i3 == -2) {
            MathPreconditions.checkNoOverflow(i4 < 32, "checkedPow", i3, i4);
            return (i4 & 1) == 0 ? 1 << i4 : (-1) << i4;
        }
        if (i3 == -1) {
            return (i4 & 1) == 0 ? 1 : -1;
        }
        if (i3 == 0) {
            return i4 == 0 ? 1 : 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            MathPreconditions.checkNoOverflow(i4 < 31, "checkedPow", i3, i4);
            return 1 << i4;
        }
        int i5 = 1;
        while (i4 != 0) {
            if (i4 == 1) {
                return checkedMultiply(i5, i3);
            }
            if ((i4 & 1) != 0) {
                i5 = checkedMultiply(i5, i3);
            }
            i4 >>= 1;
            if (i4 > 0) {
                MathPreconditions.checkNoOverflow((-46340 <= i3) & (i3 <= FLOOR_SQRT_MAX_INT), "checkedPow", i3, i4);
                i3 *= i3;
            }
        }
        return i5;
    }

    public static int checkedSubtract(int i3, int i4) {
        long j3 = i3 - i4;
        int i5 = (int) j3;
        MathPreconditions.checkNoOverflow(j3 == ((long) i5), "checkedSubtract", i3, i4);
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r1 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        if (r5 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if (r5 < 0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L5c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Le
            return r0
        Le:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L25;
                case 7: goto L25;
                case 8: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L25:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L47
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L58
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            r7 = r0 & 1
            if (r7 == 0) goto L42
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            r6 = r6 & r7
            if (r6 == 0) goto L57
            goto L58
        L47:
            if (r1 <= 0) goto L57
            goto L58
        L4a:
            if (r5 <= 0) goto L57
            goto L58
        L4d:
            if (r5 >= 0) goto L57
            goto L58
        L50:
            if (r1 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L57:
            r2 = 0
        L58:
            if (r2 == 0) goto L5b
            int r0 = r0 + r5
        L5b:
            return r0
        L5c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int factorial(int i3) {
        MathPreconditions.checkNonNegative("n", i3);
        int[] iArr = factorials;
        if (i3 < iArr.length) {
            return iArr[i3];
        }
        return Integer.MAX_VALUE;
    }

    public static int floorPowerOfTwo(int i3) {
        MathPreconditions.checkPositive("x", i3);
        return Integer.highestOneBit(i3);
    }

    public static int gcd(int i3, int i4) {
        MathPreconditions.checkNonNegative("a", i3);
        MathPreconditions.checkNonNegative("b", i4);
        if (i3 == 0) {
            return i4;
        }
        if (i4 == 0) {
            return i3;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i3);
        int i5 = i3 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i4);
        int i6 = i4 >> numberOfTrailingZeros2;
        while (i5 != i6) {
            int i7 = i5 - i6;
            int i8 = (i7 >> 31) & i7;
            int i9 = (i7 - i8) - i8;
            i6 += i8;
            i5 = i9 >> Integer.numberOfTrailingZeros(i9);
        }
        return i5 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(int i3) {
        return (i3 > 0) & ((i3 & (i3 + (-1))) == 0);
    }

    public static boolean isPrime(int i3) {
        return LongMath.isPrime(i3);
    }

    static int lessThanBranchFree(int i3, int i4) {
        return (~(~(i3 - i4))) >>> 31;
    }

    public static int log10(int i3, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", i3);
        int log10Floor = log10Floor(i3);
        int i4 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i3 == i4);
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(i4, i3);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], i3);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int log10Floor(int i3) {
        byte b4 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i3)];
        return b4 - lessThanBranchFree(i3, powersOf10[b4]);
    }

    public static int log2(int i3, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i3);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i3));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i3 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i3);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, i3);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i3);
    }

    public static int mean(int i3, int i4) {
        return (i3 & i4) + ((i3 ^ i4) >> 1);
    }

    public static int mod(int i3, int i4) {
        if (i4 > 0) {
            int i5 = i3 % i4;
            return i5 >= 0 ? i5 : i5 + i4;
        }
        throw new ArithmeticException("Modulus " + i4 + " must be > 0");
    }

    public static int pow(int i3, int i4) {
        MathPreconditions.checkNonNegative("exponent", i4);
        if (i3 == -2) {
            if (i4 < 32) {
                return (i4 & 1) == 0 ? 1 << i4 : -(1 << i4);
            }
            return 0;
        }
        if (i3 == -1) {
            return (i4 & 1) == 0 ? 1 : -1;
        }
        if (i3 == 0) {
            return i4 == 0 ? 1 : 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            if (i4 < 32) {
                return 1 << i4;
            }
            return 0;
        }
        int i5 = 1;
        while (i4 != 0) {
            if (i4 == 1) {
                return i3 * i5;
            }
            i5 *= (i4 & 1) == 0 ? 1 : i3;
            i3 *= i3;
            i4 >>= 1;
        }
        return i5;
    }

    public static int saturatedAdd(int i3, int i4) {
        return Ints.saturatedCast(i3 + i4);
    }

    public static int saturatedMultiply(int i3, int i4) {
        return Ints.saturatedCast(i3 * i4);
    }

    public static int saturatedPow(int i3, int i4) {
        MathPreconditions.checkNonNegative("exponent", i4);
        if (i3 == -2) {
            return i4 >= 32 ? (i4 & 1) + Integer.MAX_VALUE : (i4 & 1) == 0 ? 1 << i4 : (-1) << i4;
        }
        if (i3 == -1) {
            return (i4 & 1) == 0 ? 1 : -1;
        }
        if (i3 == 0) {
            return i4 == 0 ? 1 : 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            if (i4 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i4;
        }
        int i5 = ((i3 >>> 31) & i4 & 1) + Integer.MAX_VALUE;
        int i6 = 1;
        while (i4 != 0) {
            if (i4 == 1) {
                return saturatedMultiply(i6, i3);
            }
            if ((i4 & 1) != 0) {
                i6 = saturatedMultiply(i6, i3);
            }
            i4 >>= 1;
            if (i4 > 0) {
                if ((-46340 > i3) || (i3 > FLOOR_SQRT_MAX_INT)) {
                    return i5;
                }
                i3 *= i3;
            }
        }
        return i6;
    }

    public static int saturatedSubtract(int i3, int i4) {
        return Ints.saturatedCast(i3 - i4);
    }

    public static int sqrt(int i3, RoundingMode roundingMode) {
        int i4;
        MathPreconditions.checkNonNegative("x", i3);
        int sqrtFloor = sqrtFloor(i3);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor * sqrtFloor == i3);
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                i4 = sqrtFloor * sqrtFloor;
                return sqrtFloor + lessThanBranchFree(i4, i3);
            case 6:
            case 7:
            case 8:
                i4 = (sqrtFloor * sqrtFloor) + sqrtFloor;
                return sqrtFloor + lessThanBranchFree(i4, i3);
            default:
                throw new AssertionError();
        }
    }

    private static int sqrtFloor(int i3) {
        return (int) Math.sqrt(i3);
    }
}
