package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Quantiles {

    public static final class Scale {
        private final int scale;

        private Scale(int i3) {
            Preconditions.checkArgument(i3 > 0, "Quantile scale must be positive");
            this.scale = i3;
        }

        public ScaleAndIndex index(int i3) {
            return new ScaleAndIndex(this.scale, i3);
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }
    }

    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        private ScaleAndIndex(int i3, int i4) {
            Quantiles.checkIndex(i4, i3);
            this.scale = i3;
            this.index = i4;
        }

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = this.index * (dArr.length - 1);
            int divide = (int) LongMath.divide(length, this.scale, RoundingMode.DOWN);
            int i3 = (int) (length - (divide * this.scale));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i3 == 0) {
                return dArr[divide];
            }
            int i4 = divide + 1;
            Quantiles.selectInPlace(i4, dArr, i4, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i4], i3, this.scale);
        }
    }

    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        private ScaleAndIndexes(int i3, int[] iArr) {
            for (int i4 : iArr) {
                Quantiles.checkIndex(i4, i3);
            }
            Preconditions.checkArgument(iArr.length > 0, "Indexes must be a non empty array");
            this.scale = i3;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            Integer valueOf;
            double interpolate;
            int i3 = 0;
            int i4 = 1;
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i3 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i3]), Double.valueOf(Double.NaN));
                    i3++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= this.indexes.length) {
                    break;
                }
                long length2 = r5[i5] * (dArr.length - i4);
                int divide = (int) LongMath.divide(length2, this.scale, RoundingMode.DOWN);
                int i7 = i5;
                int i8 = (int) (length2 - (divide * this.scale));
                iArr3[i7] = divide;
                iArr4[i7] = i8;
                iArr5[i6] = divide;
                i6++;
                if (i8 != 0) {
                    iArr5[i6] = divide + 1;
                    i6++;
                }
                i5 = i7 + 1;
                i4 = 1;
            }
            Arrays.sort(iArr5, 0, i6);
            Quantiles.selectAllInPlace(iArr5, 0, i6 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr6 = this.indexes;
                if (i3 >= iArr6.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i9 = iArr3[i3];
                int i10 = iArr4[i3];
                if (i10 == 0) {
                    valueOf = Integer.valueOf(iArr6[i3]);
                    interpolate = dArr[i9];
                } else {
                    valueOf = Integer.valueOf(iArr6[i3]);
                    interpolate = Quantiles.interpolate(dArr[i9], dArr[i9 + 1], i10, this.scale);
                }
                linkedHashMap2.put(valueOf, Double.valueOf(interpolate));
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIndex(int i3, int i4) {
        if (i3 < 0 || i3 > i4) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i4);
        }
    }

    private static int chooseNextSelection(int[] iArr, int i3, int i4, int i5, int i6) {
        if (i3 == i4) {
            return i3;
        }
        int i7 = i5 + i6;
        int i8 = i7 >>> 1;
        while (i4 > i3 + 1) {
            int i9 = (i3 + i4) >>> 1;
            int i10 = iArr[i9];
            if (i10 > i8) {
                i4 = i9;
            } else {
                if (i10 >= i8) {
                    return i9;
                }
                i3 = i9;
            }
        }
        return (i7 - iArr[i3]) - iArr[i4] > 0 ? i4 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        for (double d3 : dArr) {
            if (Double.isNaN(d3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double interpolate(double d3, double d4, double d5, double d6) {
        if (d3 == Double.NEGATIVE_INFINITY) {
            return d4 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d4 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d3 + (((d4 - d3) * d5) / d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr[i3] = iArr[i3];
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr[i3] = jArr[i3];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i3, int i4) {
        int i5 = (i3 + i4) >>> 1;
        double d3 = dArr[i4];
        double d4 = dArr[i5];
        boolean z3 = d3 < d4;
        double d5 = dArr[i3];
        boolean z4 = d4 < d5;
        boolean z5 = d3 < d5;
        if (z3 == z4) {
            swap(dArr, i5, i3);
        } else if (z3 != z5) {
            swap(dArr, i3, i4);
        }
    }

    private static int partition(double[] dArr, int i3, int i4) {
        movePivotToStartOfSlice(dArr, i3, i4);
        double d3 = dArr[i3];
        int i5 = i4;
        while (i4 > i3) {
            if (dArr[i4] > d3) {
                swap(dArr, i5, i4);
                i5--;
            }
            i4--;
        }
        swap(dArr, i3, i5);
        return i5;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i3) {
        return new Scale(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i3, int i4, double[] dArr, int i5, int i6) {
        int chooseNextSelection = chooseNextSelection(iArr, i3, i4, i5, i6);
        int i7 = iArr[chooseNextSelection];
        selectInPlace(i7, dArr, i5, i6);
        int i8 = chooseNextSelection - 1;
        while (i8 >= i3 && iArr[i8] == i7) {
            i8--;
        }
        if (i8 >= i3) {
            selectAllInPlace(iArr, i3, i8, dArr, i5, i7 - 1);
        }
        int i9 = chooseNextSelection + 1;
        while (i9 <= i4 && iArr[i9] == i7) {
            i9++;
        }
        if (i9 <= i4) {
            selectAllInPlace(iArr, i9, i4, dArr, i7 + 1, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectInPlace(int i3, double[] dArr, int i4, int i5) {
        if (i3 != i4) {
            while (i5 > i4) {
                int partition = partition(dArr, i4, i5);
                if (partition >= i3) {
                    i5 = partition - 1;
                }
                if (partition <= i3) {
                    i4 = partition + 1;
                }
            }
            return;
        }
        int i6 = i4;
        for (int i7 = i4 + 1; i7 <= i5; i7++) {
            if (dArr[i6] > dArr[i7]) {
                i6 = i7;
            }
        }
        if (i6 != i4) {
            swap(dArr, i6, i4);
        }
    }

    private static void swap(double[] dArr, int i3, int i4) {
        double d3 = dArr[i3];
        dArr[i3] = dArr[i4];
        dArr[i4] = d3;
    }
}
