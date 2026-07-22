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
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class Floats extends FloatsMethodsForWeb {
    public static final int BYTES = 4;

    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        FloatArrayAsList(float[] fArr, int i3, int i4) {
            this.array = fArr;
            this.start = i3;
            this.end = i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Float) && Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.array[this.start + i3] != floatArrayAsList.array[floatArrayAsList.start + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Float.valueOf(this.array[this.start + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.start; i4 < this.end; i4++) {
                i3 = (i3 * 31) + Floats.hashCode(this.array[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            if (!(obj instanceof Float) || (indexOf = Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Float) || (lastIndexOf = Floats.lastIndexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float set(int i3, Float f3) {
            Preconditions.checkElementIndex(i3, size());
            float[] fArr = this.array;
            int i4 = this.start;
            float f4 = fArr[i4 + i3];
            fArr[i4 + i3] = ((Float) Preconditions.checkNotNull(f3)).floatValue();
            return Float.valueOf(f4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.emptyList();
            }
            float[] fArr = this.array;
            int i5 = this.start;
            return new FloatArrayAsList(fArr, i3 + i5, i5 + i4);
        }

        float[] toFloatArray() {
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

    private static final class FloatConverter extends Converter<String, Float> implements Serializable {
        static final FloatConverter INSTANCE = new FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Float f3) {
            return f3.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            return Float.valueOf(str);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }
    }

    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = Float.compare(fArr[i3], fArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    private Floats() {
    }

    public static List<Float> asList(float... fArr) {
        return fArr.length == 0 ? Collections.emptyList() : new FloatArrayAsList(fArr);
    }

    public static int compare(float f3, float f4) {
        return Float.compare(f3, f4);
    }

    public static float[] concat(float[]... fArr) {
        int i3 = 0;
        for (float[] fArr2 : fArr) {
            i3 += fArr2.length;
        }
        float[] fArr3 = new float[i3];
        int i4 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, i4, fArr4.length);
            i4 += fArr4.length;
        }
        return fArr3;
    }

    public static float constrainToRange(float f3, float f4, float f5) {
        if (f4 <= f5) {
            return Math.min(Math.max(f3, f4), f5);
        }
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", Float.valueOf(f4), Float.valueOf(f5)));
    }

    public static boolean contains(float[] fArr, float f3) {
        for (float f4 : fArr) {
            if (f4 == f3) {
                return true;
            }
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArr, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0, "Invalid minLength: %s", i3);
        Preconditions.checkArgument(i4 >= 0, "Invalid padding: %s", i4);
        return fArr.length < i3 ? Arrays.copyOf(fArr, i3 + i4) : fArr;
    }

    public static int hashCode(float f3) {
        return Float.valueOf(f3).hashCode();
    }

    public static int indexOf(float[] fArr, float f3) {
        return indexOf(fArr, f3, 0, fArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(float[] fArr, float f3, int i3, int i4) {
        while (i3 < i4) {
            if (fArr[i3] == f3) {
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
    public static int indexOf(float[] r5, float[] r6) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Floats.indexOf(float[], float[]):int");
    }

    public static boolean isFinite(float f3) {
        return Float.NEGATIVE_INFINITY < f3 && f3 < Float.POSITIVE_INFINITY;
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i3 = 1; i3 < fArr.length; i3++) {
            sb.append(str);
            sb.append(fArr[i3]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(float[] fArr, float f3) {
        return lastIndexOf(fArr, f3, 0, fArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(float[] fArr, float f3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (fArr[i5] == f3) {
                return i5;
            }
        }
        return -1;
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static float max(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f3 = fArr[0];
        for (int i3 = 1; i3 < fArr.length; i3++) {
            f3 = Math.max(f3, fArr[i3]);
        }
        return f3;
    }

    public static float min(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float f3 = fArr[0];
        for (int i3 = 1; i3 < fArr.length; i3++) {
            f3 = Math.min(f3, fArr[i3]);
        }
        return f3;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void reverse(float[] fArr, int i3, int i4) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i3, i4, fArr.length);
        for (int i5 = i4 - 1; i3 < i5; i5--) {
            float f3 = fArr[i3];
            fArr[i3] = fArr[i5];
            fArr[i5] = f3;
            i3++;
        }
    }

    public static void rotate(float[] fArr, int i3) {
        rotate(fArr, i3, 0, fArr.length);
    }

    public static void rotate(float[] fArr, int i3, int i4, int i5) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i4, i5, fArr.length);
        if (fArr.length <= 1) {
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
        reverse(fArr, i4, i8);
        reverse(fArr, i8, i5);
        reverse(fArr, i4, i5);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr, int i3, int i4) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i3, i4, fArr.length);
        Arrays.sort(fArr, i3, i4);
        reverse(fArr, i3, i4);
    }

    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).toFloatArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i3 = 0; i3 < length; i3++) {
            fArr[i3] = ((Number) Preconditions.checkNotNull(array[i3])).floatValue();
        }
        return fArr;
    }

    @CheckForNull
    public static Float tryParse(String str) {
        if (!Doubles.FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
