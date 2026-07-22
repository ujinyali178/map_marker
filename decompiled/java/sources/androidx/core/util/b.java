package androidx.core.util;

import java.util.Objects;

/* loaded from: /root/release/classes.dex */
public class b {

    static class a {
        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return a.a(obj, obj2);
    }

    public static int b(Object... objArr) {
        return a.b(objArr);
    }

    public static <T> T c(T t3) {
        t3.getClass();
        return t3;
    }

    public static <T> T d(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }
}
