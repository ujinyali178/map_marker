package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class BigIntegerMath {
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;
    static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    private static final double LN_10 = Math.log(10.0d);
    private static final double LN_2 = Math.log(2.0d);

    /* renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
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

    private static class BigIntegerToDoubleRounder extends ToDoubleRounder<BigInteger> {
        static final BigIntegerToDoubleRounder INSTANCE = new BigIntegerToDoubleRounder();

        private BigIntegerToDoubleRounder() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        public BigInteger minus(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger.subtract(bigInteger2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        public double roundToDoubleArbitrarily(BigInteger bigInteger) {
            return DoubleUtils.bigToDouble(bigInteger);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        public int sign(BigInteger bigInteger) {
            return bigInteger.signum();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        public BigInteger toX(double d3, RoundingMode roundingMode) {
            return DoubleMath.roundToBigInteger(d3, roundingMode);
        }
    }

    private BigIntegerMath() {
    }

    public static BigInteger binomial(int i3, int i4) {
        int i5;
        MathPreconditions.checkNonNegative("n", i3);
        MathPreconditions.checkNonNegative("k", i4);
        int i6 = 1;
        Preconditions.checkArgument(i4 <= i3, "k (%s) > n (%s)", i4, i3);
        if (i4 > (i3 >> 1)) {
            i4 = i3 - i4;
        }
        int[] iArr = LongMath.biggestBinomials;
        if (i4 < iArr.length && i3 <= iArr[i4]) {
            return BigInteger.valueOf(LongMath.binomial(i3, i4));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j3 = i3;
        long j4 = 1;
        int log2 = LongMath.log2(j3, RoundingMode.CEILING);
        while (true) {
            int i7 = log2;
            while (i6 < i4) {
                i5 = i3 - i6;
                i6++;
                i7 += log2;
                if (i7 >= 63) {
                    break;
                }
                j3 *= i5;
                j4 *= i6;
            }
            return bigInteger.multiply(BigInteger.valueOf(j3)).divide(BigInteger.valueOf(j4));
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j3)).divide(BigInteger.valueOf(j4));
            j3 = i5;
            j4 = i6;
        }
    }

    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int i3) {
        MathPreconditions.checkNonNegative("n", i3);
        long[] jArr = LongMath.factorials;
        if (i3 < jArr.length) {
            return BigInteger.valueOf(jArr[i3]);
        }
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i3, RoundingMode.CEILING) * i3, 64, RoundingMode.CEILING));
        int length = jArr.length;
        long j3 = jArr[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
        long j4 = j3 >> numberOfTrailingZeros;
        int log2 = LongMath.log2(j4, RoundingMode.FLOOR) + 1;
        long j5 = length;
        int log22 = LongMath.log2(j5, RoundingMode.FLOOR) + 1;
        int i4 = 1 << (log22 - 1);
        while (j5 <= i3) {
            if ((i4 & j5) != 0) {
                i4 <<= 1;
                log22++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j5);
            long j6 = j5 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((log22 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(BigInteger.valueOf(j4));
                j4 = 1;
            }
            j4 *= j6;
            log2 = LongMath.log2(j4, RoundingMode.FLOOR) + 1;
            j5++;
        }
        if (j4 > 1) {
            arrayList.add(BigInteger.valueOf(j4));
        }
        return listProduct(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    static boolean fitsInLong(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    static BigInteger listProduct(List<BigInteger> list) {
        return listProduct(list, 0, list.size());
    }

    static BigInteger listProduct(List<BigInteger> list, int i3, int i4) {
        int i5 = i4 - i3;
        if (i5 == 0) {
            return BigInteger.ONE;
        }
        if (i5 == 1) {
            return list.get(i3);
        }
        if (i5 == 2) {
            return list.get(i3).multiply(list.get(i3 + 1));
        }
        if (i5 == 3) {
            return list.get(i3).multiply(list.get(i3 + 1)).multiply(list.get(i3 + 2));
        }
        int i6 = (i4 + i3) >>> 1;
        return listProduct(list, i3, i6).multiply(listProduct(list, i6, i4));
    }

    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        int i3;
        MathPreconditions.checkPositive("x", bigInteger);
        if (fitsInLong(bigInteger)) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int log2 = (int) ((log2(bigInteger, RoundingMode.FLOOR) * LN_2) / LN_10);
        BigInteger pow = BigInteger.TEN.pow(log2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                log2--;
                pow = pow.divide(BigInteger.TEN);
                i3 = pow.compareTo(bigInteger);
            } while (i3 > 0);
        } else {
            BigInteger multiply = BigInteger.TEN.multiply(pow);
            int i4 = compareTo;
            int compareTo2 = multiply.compareTo(bigInteger);
            while (compareTo2 <= 0) {
                log2++;
                BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                int compareTo3 = multiply2.compareTo(bigInteger);
                BigInteger bigInteger2 = multiply;
                multiply = multiply2;
                pow = bigInteger2;
                i4 = compareTo2;
                compareTo2 = compareTo3;
            }
            i3 = i4;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i3 == 0);
            case 2:
            case 3:
                return log2;
            case 4:
            case 5:
                return pow.equals(bigInteger) ? log2 : log2 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) <= 0 ? log2 : log2 + 1;
            default:
                throw new AssertionError();
        }
    }

    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", (BigInteger) Preconditions.checkNotNull(bigInteger));
        int bitLength = bigInteger.bitLength() - 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(bigInteger));
            case 2:
            case 3:
                return bitLength;
            case 4:
            case 5:
                return isPowerOfTwo(bigInteger) ? bitLength : bitLength + 1;
            case 6:
            case 7:
            case 8:
                return bitLength < 256 ? bigInteger.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - bitLength)) <= 0 ? bitLength : bitLength + 1 : bigInteger.pow(2).bitLength() + (-1) < (bitLength * 2) + 1 ? bitLength : bitLength + 1;
            default:
                throw new AssertionError();
        }
    }

    public static double roundToDouble(BigInteger bigInteger, RoundingMode roundingMode) {
        return BigIntegerToDoubleRounder.INSTANCE.roundToDouble(bigInteger, roundingMode);
    }

    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", bigInteger);
        if (fitsInLong(bigInteger)) {
            return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        BigInteger sqrtFloor = sqrtFloor(bigInteger);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                int intValue = sqrtFloor.intValue();
                return intValue * intValue == bigInteger.intValue() && sqrtFloor.pow(2).equals(bigInteger) ? sqrtFloor : sqrtFloor.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return sqrtFloor.pow(2).add(sqrtFloor).compareTo(bigInteger) >= 0 ? sqrtFloor : sqrtFloor.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    private static BigInteger sqrtApproxWithDoubles(BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(bigInteger)), RoundingMode.HALF_EVEN);
    }

    private static BigInteger sqrtFloor(BigInteger bigInteger) {
        BigInteger shiftLeft;
        int log2 = log2(bigInteger, RoundingMode.FLOOR);
        if (log2 < 1023) {
            shiftLeft = sqrtApproxWithDoubles(bigInteger);
        } else {
            int i3 = (log2 - 52) & (-2);
            shiftLeft = sqrtApproxWithDoubles(bigInteger.shiftRight(i3)).shiftLeft(i3 >> 1);
        }
        BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        if (shiftLeft.equals(shiftRight)) {
            return shiftLeft;
        }
        while (true) {
            BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }
}
