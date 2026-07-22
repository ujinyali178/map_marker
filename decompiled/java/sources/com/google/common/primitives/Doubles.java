package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Doubles extends DoublesMethodsForWeb {
    public static final int BYTES = 8;
    static final Pattern FLOATING_POINT_PATTERN = fpPattern();

    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        DoubleArrayAsList(double[] dArr, int i3, int i4) {
            this.array = dArr;
            this.start = i3;
            this.end = i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Double) && Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.array[this.start + i3] != doubleArrayAsList.array[doubleArrayAsList.start + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Double.valueOf(this.array[this.start + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.start; i4 < this.end; i4++) {
                i3 = (i3 * 31) + Doubles.hashCode(this.array[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            if (!(obj instanceof Double) || (indexOf = Doubles.indexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Double) || (lastIndexOf = Doubles.lastIndexOf(this.array, ((Double) obj).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double set(int i3, Double d3) {
            Preconditions.checkElementIndex(i3, size());
            double[] dArr = this.array;
            int i4 = this.start;
            double d4 = dArr[i4 + i3];
            dArr[i4 + i3] = ((Double) Preconditions.checkNotNull(d3)).doubleValue();
            return Double.valueOf(d4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i5 = this.start;
            return new DoubleArrayAsList(dArr, i3 + i5, i5 + i4);
        }

        double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i3 = this.start;
            while (true) {
                i3++;
                if (i3 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i3]);
            }
        }
    }

    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private DoubleConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Double d3) {
            return d3.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Double doForward(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = Double.compare(dArr[i3], dArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    private Doubles() {
    }

    public static List<Double> asList(double... dArr) {
        return dArr.length == 0 ? Collections.emptyList() : new DoubleArrayAsList(dArr);
    }

    public static int compare(double d3, double d4) {
        return Double.compare(d3, d4);
    }

    public static double[] concat(double[]... dArr) {
        int i3 = 0;
        for (double[] dArr2 : dArr) {
            i3 += dArr2.length;
        }
        double[] dArr3 = new double[i3];
        int i4 = 0;
        for (double[] dArr4 : dArr) {
            System.arraycopy(dArr4, 0, dArr3, i4, dArr4.length);
            i4 += dArr4.length;
        }
        return dArr3;
    }

    public static double constrainToRange(double d3, double d4, double d5) {
        if (d4 <= d5) {
            return Math.min(Math.max(d3, d4), d5);
        }
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", Double.valueOf(d4), Double.valueOf(d5)));
    }

    public static boolean contains(double[] dArr, double d3) {
        for (double d4 : dArr) {
            if (d4 == d3) {
                return true;
            }
        }
        return false;
    }

    public static double[] ensureCapacity(double[] dArr, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0, "Invalid minLength: %s", i3);
        Preconditions.checkArgument(i4 >= 0, "Invalid padding: %s", i4);
        return dArr.length < i3 ? Arrays.copyOf(dArr, i3 + i4) : dArr;
    }

    private static Pattern fpPattern() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    public static int hashCode(double d3) {
        return Double.valueOf(d3).hashCode();
    }

    public static int indexOf(double[] dArr, double d3) {
        return indexOf(dArr, d3, 0, dArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(double[] dArr, double d3, int i3, int i4) {
        while (i3 < i4) {
            if (dArr[i3] == d3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOf(double[] r8, double[] r9) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r8, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r9, r0)
            int r0 = r9.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r8.length
            int r3 = r9.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r9.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r8[r3]
            r5 = r9[r2]
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Doubles.indexOf(double[], double[]):int");
    }

    public static boolean isFinite(double d3) {
        return Double.NEGATIVE_INFINITY < d3 && d3 < Double.POSITIVE_INFINITY;
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i3 = 1; i3 < dArr.length; i3++) {
            sb.append(str);
            sb.append(dArr[i3]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(double[] dArr, double d3) {
        return lastIndexOf(dArr, d3, 0, dArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(double[] dArr, double d3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (dArr[i5] == d3) {
                return i5;
            }
        }
        return -1;
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static double max(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d3 = dArr[0];
        for (int i3 = 1; i3 < dArr.length; i3++) {
            d3 = Math.max(d3, dArr[i3]);
        }
        return d3;
    }

    public static double min(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d3 = dArr[0];
        for (int i3 = 1; i3 < dArr.length; i3++) {
            d3 = Math.min(d3, dArr[i3]);
        }
        return d3;
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void reverse(double[] dArr, int i3, int i4) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i3, i4, dArr.length);
        for (int i5 = i4 - 1; i3 < i5; i5--) {
            double d3 = dArr[i3];
            dArr[i3] = dArr[i5];
            dArr[i5] = d3;
            i3++;
        }
    }

    public static void rotate(double[] dArr, int i3) {
        rotate(dArr, i3, 0, dArr.length);
    }

    public static void rotate(double[] dArr, int i3, int i4, int i5) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i4, i5, dArr.length);
        if (dArr.length <= 1) {
            return;
        }
        int i6 = i5 - i4;
        int i7 = (-i3) % i6;
        if (i7 < 0) {
            i7 += i6;
        }
        int i8 = i7 + i4;
        if (i8 == i4) {
            return;
        }
        reverse(dArr, i4, i8);
        reverse(dArr, i8, i5);
        reverse(dArr, i4, i5);
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr, int i3, int i4) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i3, i4, dArr.length);
        Arrays.sort(dArr, i3, i4);
        reverse(dArr, i3, i4);
    }

    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.INSTANCE;
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i3 = 0; i3 < length; i3++) {
            dArr[i3] = ((Number) Preconditions.checkNotNull(array[i3])).doubleValue();
        }
        return dArr;
    }

    @CheckForNull
    public static Double tryParse(String str) {
        if (!FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
