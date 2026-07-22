package androidx.core.content.res;

import java.lang.reflect.Array;

/* loaded from: /root/release/classes.dex */
final class d {
    public static int[] a(int[] iArr, int i3, int i4) {
        if (i3 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i3)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr = iArr2;
        }
        iArr[i3] = i4;
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public static <T> T[] b(T[] tArr, int i3, T t3) {
        if (i3 + 1 > tArr.length) {
            ?? r02 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), c(i3));
            System.arraycopy(tArr, 0, r02, 0, i3);
            tArr = r02;
        }
        tArr[i3] = t3;
        return tArr;
    }

    public static int c(int i3) {
        if (i3 <= 4) {
            return 8;
        }
        return i3 * 2;
    }
}
