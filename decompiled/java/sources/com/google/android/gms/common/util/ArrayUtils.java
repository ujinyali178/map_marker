package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> T[] concat(T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int i3 = 0;
        for (T[] tArr2 : tArr) {
            i3 += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i3);
        int length = tArr[0].length;
        for (int i4 = 1; i4 < tArr.length; i4++) {
            T[] tArr4 = tArr[i4];
            int length2 = tArr4.length;
            System.arraycopy(tArr4, 0, tArr3, length, length2);
            length += length2;
        }
        return tArr3;
    }

    public static byte[] concatByteArrays(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i3 = 0;
        for (byte[] bArr2 : bArr) {
            i3 += bArr2.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i3);
        int length = bArr[0].length;
        for (int i4 = 1; i4 < bArr.length; i4++) {
            byte[] bArr3 = bArr[i4];
            int length2 = bArr3.length;
            System.arraycopy(bArr3, 0, copyOf, length, length2);
            length += length2;
        }
        return copyOf;
    }

    public static boolean contains(int[] iArr, int i3) {
        if (iArr != null) {
            for (int i4 : iArr) {
                if (i4 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <T> boolean contains(T[] tArr, T t3) {
        int length = tArr != null ? tArr.length : 0;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (!Objects.equal(tArr[i3], t3)) {
                i3++;
            } else if (i3 >= 0) {
                return true;
            }
        }
        return false;
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> T[] removeAll(T[] tArr, T... tArr2) {
        int length;
        int i3;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || (length = tArr2.length) == 0) {
            return (T[]) Arrays.copyOf(tArr, tArr.length);
        }
        Class<?> cls = tArr2.getClass();
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), tArr.length));
        if (length == 1) {
            i3 = 0;
            for (T t3 : tArr) {
                if (!Objects.equal(tArr2[0], t3)) {
                    tArr3[i3] = t3;
                    i3++;
                }
            }
        } else {
            int i4 = 0;
            for (T t4 : tArr) {
                if (!contains(tArr2, t4)) {
                    tArr3[i4] = t4;
                    i4++;
                }
            }
            i3 = i4;
        }
        if (tArr3 == null) {
            return null;
        }
        return i3 == tArr3.length ? tArr3 : (T[]) Arrays.copyOf(tArr3, i3);
    }

    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t3 : tArr) {
            arrayList.add(t3);
        }
        return arrayList;
    }

    public static int[] toPrimitiveArray(Collection<Integer> collection) {
        int i3 = 0;
        if (collection == null || collection.isEmpty()) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        return iArr;
    }

    public static Integer[] toWrapperArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i3 = 0; i3 < length; i3++) {
            numArr[i3] = Integer.valueOf(iArr[i3]);
        }
        return numArr;
    }

    public static void writeArray(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i3]));
        }
    }

    public static void writeArray(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i3]));
        }
    }

    public static void writeArray(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i3]));
        }
    }

    public static void writeArray(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i3]));
        }
    }

    public static <T> void writeArray(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i3]);
        }
    }

    public static void writeArray(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i3]));
        }
    }

    public static void writeStringArray(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i3]);
            sb.append("\"");
        }
    }
}
