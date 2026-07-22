package h2;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class i extends h {
    public static <T> List<T> b(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        List<T> a4 = k.a(tArr);
        kotlin.jvm.internal.k.d(a4, "asList(this)");
        return a4;
    }

    public static byte[] c(byte[] bArr, byte[] destination, int i3, int i4, int i5) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(bArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static final <T> T[] d(T[] tArr, T[] destination, int i3, int i4, int i5) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(tArr, i4, destination, i3, i5 - i4);
        return destination;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        if ((i6 & 8) != 0) {
            i5 = objArr.length;
        }
        return d(objArr, objArr2, i3, i4, i5);
    }

    public static <T> void f(T[] tArr, T t3, int i3, int i4) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        Arrays.fill(tArr, i3, i4, t3);
    }

    public static /* synthetic */ void g(Object[] objArr, Object obj, int i3, int i4, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = objArr.length;
        }
        f(objArr, obj, i3, i4);
    }
}
