package com.google.common.primitives;

import com.google.common.base.Preconditions;
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
public final class Booleans {

    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        BooleanArrayAsList(boolean[] zArr, int i3, int i4) {
            this.array = zArr;
            this.start = i3;
            this.end = i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Boolean) && Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.array[this.start + i3] != booleanArrayAsList.array[booleanArrayAsList.start + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int i3) {
            Preconditions.checkElementIndex(i3, size());
            return Boolean.valueOf(this.array[this.start + i3]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i3 = 1;
            for (int i4 = this.start; i4 < this.end; i4++) {
                i3 = (i3 * 31) + Booleans.hashCode(this.array[i4]);
            }
            return i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            if (!(obj instanceof Boolean) || (indexOf = Booleans.indexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Boolean) || (lastIndexOf = Booleans.lastIndexOf(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean set(int i3, Boolean bool) {
            Preconditions.checkElementIndex(i3, size());
            boolean[] zArr = this.array;
            int i4 = this.start;
            boolean z3 = zArr[i4 + i3];
            zArr[i4 + i3] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i4, size());
            if (i3 == i4) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i5 = this.start;
            return new BooleanArrayAsList(zArr, i3 + i5, i5 + i4);
        }

        boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.array[this.start] ? "[true" : "[false");
            int i3 = this.start;
            while (true) {
                i3++;
                if (i3 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(this.array[i3] ? ", true" : ", false");
            }
        }
    }

    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");

        private final String toString;
        private final int trueValue;

        BooleanComparator(int i3, String str) {
            this.trueValue = i3;
            this.toString = str;
        }

        @Override // java.util.Comparator
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.trueValue : 0) - (bool.booleanValue() ? this.trueValue : 0);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }
    }

    private enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i3 = 0; i3 < min; i3++) {
                int compare = Booleans.compare(zArr[i3], zArr2[i3]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    private Booleans() {
    }

    public static List<Boolean> asList(boolean... zArr) {
        return zArr.length == 0 ? Collections.emptyList() : new BooleanArrayAsList(zArr);
    }

    public static int compare(boolean z3, boolean z4) {
        if (z3 == z4) {
            return 0;
        }
        return z3 ? 1 : -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i3 = 0;
        for (boolean[] zArr2 : zArr) {
            i3 += zArr2.length;
        }
        boolean[] zArr3 = new boolean[i3];
        int i4 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, i4, zArr4.length);
            i4 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z3) {
        for (boolean z4 : zArr) {
            if (z4 == z3) {
                return true;
            }
        }
        return false;
    }

    public static int countTrue(boolean... zArr) {
        int i3 = 0;
        for (boolean z3 : zArr) {
            if (z3) {
                i3++;
            }
        }
        return i3;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i3, int i4) {
        Preconditions.checkArgument(i3 >= 0, "Invalid minLength: %s", i3);
        Preconditions.checkArgument(i4 >= 0, "Invalid padding: %s", i4);
        return zArr.length < i3 ? Arrays.copyOf(zArr, i3 + i4) : zArr;
    }

    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z3) {
        return z3 ? 1231 : 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z3) {
        return indexOf(zArr, z3, 0, zArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(boolean[] zArr, boolean z3, int i3, int i4) {
        while (i3 < i4) {
            if (zArr[i3] == z3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOf(boolean[] r5, boolean[] r6) {
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
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            boolean r3 = r5[r3]
            boolean r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Booleans.indexOf(boolean[], boolean[]):int");
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i3 = 1; i3 < zArr.length; i3++) {
            sb.append(str);
            sb.append(zArr[i3]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z3) {
        return lastIndexOf(zArr, z3, 0, zArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(boolean[] zArr, boolean z3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (zArr[i5] == z3) {
                return i5;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static void reverse(boolean[] zArr, int i3, int i4) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i3, i4, zArr.length);
        for (int i5 = i4 - 1; i3 < i5; i5--) {
            boolean z3 = zArr[i3];
            zArr[i3] = zArr[i5];
            zArr[i5] = z3;
            i3++;
        }
    }

    public static void rotate(boolean[] zArr, int i3) {
        rotate(zArr, i3, 0, zArr.length);
    }

    public static void rotate(boolean[] zArr, int i3, int i4, int i5) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i4, i5, zArr.length);
        if (zArr.length <= 1) {
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
        reverse(zArr, i4, i8);
        reverse(zArr, i8, i5);
        reverse(zArr, i4, i5);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = ((Boolean) Preconditions.checkNotNull(array[i3])).booleanValue();
        }
        return zArr;
    }

    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }
}
