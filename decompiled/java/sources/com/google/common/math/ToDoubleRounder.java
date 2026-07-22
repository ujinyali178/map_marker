package com.google.common.math;

import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {

    /* renamed from: com.google.common.math.ToDoubleRounder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    ToDoubleRounder() {
    }

    abstract X minus(X x3, X x4);

    final double roundToDouble(X x3, RoundingMode roundingMode) {
        X x4;
        double d3;
        Preconditions.checkNotNull(x3, "x");
        Preconditions.checkNotNull(roundingMode, "mode");
        double roundToDoubleArbitrarily = roundToDoubleArbitrarily(x3);
        if (Double.isInfinite(roundToDoubleArbitrarily)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return sign(x3) * Double.MAX_VALUE;
                case 5:
                    return roundToDoubleArbitrarily == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return roundToDoubleArbitrarily == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    return roundToDoubleArbitrarily;
                case 8:
                    throw new ArithmeticException(x3 + " cannot be represented precisely as a double");
            }
        }
        X x5 = toX(roundToDoubleArbitrarily, RoundingMode.UNNECESSARY);
        int compareTo = ((Comparable) x3).compareTo(x5);
        int[] iArr = AnonymousClass1.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                return sign(x3) >= 0 ? compareTo >= 0 ? roundToDoubleArbitrarily : DoubleUtils.nextDown(roundToDoubleArbitrarily) : compareTo <= 0 ? roundToDoubleArbitrarily : Math.nextUp(roundToDoubleArbitrarily);
            case 2:
            case 3:
            case 4:
                if (compareTo >= 0) {
                    d3 = Math.nextUp(roundToDoubleArbitrarily);
                    if (d3 == Double.POSITIVE_INFINITY) {
                        return roundToDoubleArbitrarily;
                    }
                    x4 = toX(d3, RoundingMode.CEILING);
                } else {
                    double nextDown = DoubleUtils.nextDown(roundToDoubleArbitrarily);
                    if (nextDown == Double.NEGATIVE_INFINITY) {
                        return roundToDoubleArbitrarily;
                    }
                    X x6 = toX(nextDown, RoundingMode.FLOOR);
                    x4 = x5;
                    x5 = x6;
                    d3 = roundToDoubleArbitrarily;
                    roundToDoubleArbitrarily = nextDown;
                }
                int compareTo2 = ((Comparable) minus(x3, x5)).compareTo(minus(x4, x3));
                if (compareTo2 < 0) {
                    return roundToDoubleArbitrarily;
                }
                if (compareTo2 > 0) {
                    return d3;
                }
                int i3 = iArr[roundingMode.ordinal()];
                if (i3 == 2) {
                    return (Double.doubleToRawLongBits(roundToDoubleArbitrarily) & 1) == 0 ? roundToDoubleArbitrarily : d3;
                }
                if (i3 == 3) {
                    return sign(x3) >= 0 ? roundToDoubleArbitrarily : d3;
                }
                if (i3 == 4) {
                    return sign(x3) >= 0 ? d3 : roundToDoubleArbitrarily;
                }
                throw new AssertionError("impossible");
            case 5:
                return compareTo >= 0 ? roundToDoubleArbitrarily : DoubleUtils.nextDown(roundToDoubleArbitrarily);
            case 6:
                return compareTo <= 0 ? roundToDoubleArbitrarily : Math.nextUp(roundToDoubleArbitrarily);
            case 7:
                return sign(x3) >= 0 ? compareTo <= 0 ? roundToDoubleArbitrarily : Math.nextUp(roundToDoubleArbitrarily) : compareTo >= 0 ? roundToDoubleArbitrarily : DoubleUtils.nextDown(roundToDoubleArbitrarily);
            case 8:
                MathPreconditions.checkRoundingUnnecessary(compareTo == 0);
                return roundToDoubleArbitrarily;
            default:
                throw new AssertionError("impossible");
        }
    }

    abstract double roundToDoubleArbitrarily(X x3);

    abstract int sign(X x3);

    abstract X toX(double d3, RoundingMode roundingMode);
}
