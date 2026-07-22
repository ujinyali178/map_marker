package h2;

import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /root/release/classes.dex */
public class n extends m {
    public static final <T> Collection<T> c(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new d(tArr, false);
    }

    public static <T> List<T> d() {
        return x.f2631c;
    }

    public static <T> int e(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> f(T... elements) {
        List<T> b4;
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.length <= 0) {
            return d();
        }
        b4 = i.b(elements);
        return b4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> g(List<? extends T> list) {
        kotlin.jvm.internal.k.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : m.b(list.get(0)) : d();
    }

    public static void h() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
