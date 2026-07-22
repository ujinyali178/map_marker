package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class ObjectArrays {
    private ObjectArrays() {
    }

    static Object checkElementNotNull(@CheckForNull Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i3);
    }

    static Object[] checkElementsNotNull(Object... objArr) {
        checkElementsNotNull(objArr, objArr.length);
        return objArr;
    }

    static Object[] checkElementsNotNull(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            checkElementNotNull(objArr[i4], i4);
        }
        return objArr;
    }

    public static <T> T[] concat(@ParametricNullness T t3, T[] tArr) {
        T[] tArr2 = (T[]) newArray(tArr, tArr.length + 1);
        tArr2[0] = t3;
        System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] concat(T[] tArr, @ParametricNullness T t3) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t3;
        return tArr2;
    }

    public static <T> T[] concat(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] tArr3 = (T[]) newArray(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static Object[] copyAsObjectArray(Object[] objArr, int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, objArr.length);
        if (i4 == 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[i4];
        System.arraycopy(objArr, i3, objArr2, 0, i4);
        return objArr2;
    }

    private static Object[] fillArray(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return objArr;
    }

    public static <T> T[] newArray(Class<T> cls, int i3) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i3));
    }

    public static <T> T[] newArray(T[] tArr, int i3) {
        return (T[]) Platform.newArray(tArr, i3);
    }

    static void swap(Object[] objArr, int i3, int i4) {
        Object obj = objArr[i3];
        objArr[i3] = objArr[i4];
        objArr[i4] = obj;
    }

    static Object[] toArrayImpl(Collection<?> collection) {
        return fillArray(collection, new Object[collection.size()]);
    }

    static <T> T[] toArrayImpl(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) newArray(tArr, size);
        }
        fillArray(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    static <T> T[] toArrayImpl(Object[] objArr, int i3, int i4, T[] tArr) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, objArr.length);
        if (tArr.length < i4) {
            tArr = (T[]) newArray(tArr, i4);
        } else if (tArr.length > i4) {
            tArr[i4] = null;
        }
        System.arraycopy(objArr, i3, tArr, 0, i4);
        return tArr;
    }
}
