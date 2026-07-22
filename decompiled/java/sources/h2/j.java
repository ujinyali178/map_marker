package h2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class j extends i {
    public static final <T> boolean h(T[] tArr, T t3) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return l(tArr, t3) >= 0;
    }

    public static <T> List<T> i(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return (List) j(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C j(T[] tArr, C destination) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        for (T t3 : tArr) {
            if (t3 != null) {
                destination.add(t3);
            }
        }
        return destination;
    }

    public static final <T> int k(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final <T> int l(T[] tArr, T t3) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int i3 = 0;
        if (t3 == null) {
            int length = tArr.length;
            while (i3 < length) {
                if (tArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i3 < length2) {
            if (kotlin.jvm.internal.k.a(t3, tArr[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static char m(char[] cArr) {
        kotlin.jvm.internal.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> T n(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> o(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? p(tArr) : m.b(tArr[0]) : n.d();
    }

    public static final <T> List<T> p(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new ArrayList(n.c(tArr));
    }
}
