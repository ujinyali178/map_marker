package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class DoubleMath {
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    private static final double LN_2 = Math.log(2.0d);
    static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
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
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private DoubleMath() {
    }

    private static double checkFinite(double d3) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d3));
        return d3;
    }

    public static double factorial(int i3) {
        MathPreconditions.checkNonNegative("n", i3);
        if (i3 > MAX_FACTORIAL) {
            return Double.POSITIVE_INFINITY;
        }
        double d3 = 1.0d;
        int i4 = i3 & (-16);
        while (true) {
            i4++;
            if (i4 > i3) {
                return d3 * everySixteenthFactorial[i3 >> 4];
            }
            d3 *= i4;
        }
    }

    public static int fuzzyCompare(double d3, double d4, double d5) {
        if (fuzzyEquals(d3, d4, d5)) {
            return 0;
        }
        if (d3 < d4) {
            return -1;
        }
        if (d3 > d4) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d3), Double.isNaN(d4));
    }

    public static boolean fuzzyEquals(double d3, double d4, double d5) {
        MathPreconditions.checkNonNegative("tolerance", d5);
        return Math.copySign(d3 - d4, 1.0d) <= d5 || d3 == d4 || (Double.isNaN(d3) && Double.isNaN(d4));
    }

    public static boolean isMathematicalInteger(double d3) {
        return DoubleUtils.isFinite(d3) && (d3 == LN_2 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d3)) <= Math.getExponent(d3));
    }

    public static boolean isPowerOfTwo(double d3) {
        if (d3 <= LN_2 || !DoubleUtils.isFinite(d3)) {
            return false;
        }
        long significand = DoubleUtils.getSignificand(d3);
        return (significand & (significand - 1)) == 0;
    }

    public static double log2(double d3) {
        return Math.log(d3) / LN_2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int log2(double r5, java.math.RoundingMode r7) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 <= 0) goto L10
            boolean r2 = com.google.common.math.DoubleUtils.isFinite(r5)
            if (r2 == 0) goto L10
            r2 = 1
            goto L11
        L10:
            r2 = 0
        L11:
            java.lang.String r3 = "x must be positive and finite"
            com.google.common.base.Preconditions.checkArgument(r2, r3)
            int r2 = java.lang.Math.getExponent(r5)
            boolean r3 = com.google.common.math.DoubleUtils.isNormal(r5)
            if (r3 != 0) goto L2b
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r5 = r5 * r0
            int r5 = log2(r5, r7)
            int r5 = r5 + (-52)
            return r5
        L2b:
            int[] r3 = com.google.common.math.DoubleMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r7 = r7.ordinal()
            r7 = r3[r7]
            switch(r7) {
                case 1: goto L5f;
                case 2: goto L66;
                case 3: goto L58;
                case 4: goto L4e;
                case 5: goto L4a;
                case 6: goto L3c;
                case 7: goto L3c;
                case 8: goto L3c;
                default: goto L36;
            }
        L36:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L3c:
            double r5 = com.google.common.math.DoubleUtils.scaleNormalize(r5)
            double r5 = r5 * r5
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L66
            r0 = 1
            goto L66
        L4a:
            if (r2 < 0) goto L51
            r0 = 1
            goto L51
        L4e:
            if (r2 >= 0) goto L51
            r0 = 1
        L51:
            boolean r5 = isPowerOfTwo(r5)
            r5 = r5 ^ r1
            r0 = r0 & r5
            goto L66
        L58:
            boolean r5 = isPowerOfTwo(r5)
            r0 = r5 ^ 1
            goto L66
        L5f:
            boolean r5 = isPowerOfTwo(r5)
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r5)
        L66:
            if (r0 == 0) goto L6a
            int r2 = r2 + 1
        L6a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.log2(double, java.math.RoundingMode):int");
    }

    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double checkFinite = checkFinite(it.next().doubleValue());
        long j3 = 1;
        while (it.hasNext()) {
            j3++;
            checkFinite += (checkFinite(it.next().doubleValue()) - checkFinite) / j3;
        }
        return checkFinite;
    }

    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double checkFinite = checkFinite(dArr[0]);
        long j3 = 1;
        for (int i3 = 1; i3 < dArr.length; i3++) {
            checkFinite(dArr[i3]);
            j3++;
            checkFinite += (dArr[i3] - checkFinite) / j3;
        }
        return checkFinite;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j3 = 0;
        for (int i3 : iArr) {
            j3 += i3;
        }
        return j3 / iArr.length;
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d3 = jArr[0];
        long j3 = 1;
        for (int i3 = 1; i3 < jArr.length; i3++) {
            j3++;
            d3 += (jArr[i3] - d3) / j3;
        }
        return d3;
    }

    static double roundIntermediate(double d3, RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(d3)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d3));
                return d3;
            case 2:
                return (d3 >= LN_2 || isMathematicalInteger(d3)) ? d3 : ((long) d3) - 1;
            case 3:
                return (d3 <= LN_2 || isMathematicalInteger(d3)) ? d3 : ((long) d3) + 1;
            case 4:
                return d3;
            case 5:
                if (isMathematicalInteger(d3)) {
                    return d3;
                }
                return ((long) d3) + (d3 > LN_2 ? 1 : -1);
            case 6:
                return Math.rint(d3);
            case 7:
                double rint = Math.rint(d3);
                return Math.abs(d3 - rint) == 0.5d ? d3 + Math.copySign(0.5d, d3) : rint;
            case 8:
                double rint2 = Math.rint(d3);
                return Math.abs(d3 - rint2) == 0.5d ? d3 : rint2;
            default:
                throw new AssertionError();
        }
    }

    public static BigInteger roundToBigInteger(double d3, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d3, roundingMode);
        if ((roundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE) && (MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d)) {
            return BigInteger.valueOf((long) roundIntermediate);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        return roundIntermediate < LN_2 ? shiftLeft.negate() : shiftLeft;
    }

    public static int roundToInt(double d3, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d3, roundingMode);
        MathPreconditions.checkInRangeForRoundingInputs((roundIntermediate < 2.147483648E9d) & (roundIntermediate > -2.147483649E9d), d3, roundingMode);
        return (int) roundIntermediate;
    }

    public static long roundToLong(double d3, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d3, roundingMode);
        MathPreconditions.checkInRangeForRoundingInputs((MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d) & (roundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE), d3, roundingMode);
        return (long) roundIntermediate;
    }
}
