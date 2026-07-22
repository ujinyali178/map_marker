package kotlin.jvm.internal;

import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public class k {
    private k() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            k();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            l(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) h(new NullPointerException(str + " must not be null")));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            m(str);
        }
    }

    public static int f(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 == i4 ? 0 : 1;
    }

    private static String g(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = k.class.getName();
        int i3 = 0;
        while (!stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        while (stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        StackTraceElement stackTraceElement = stackTrace[i3];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    private static <T extends Throwable> T h(T t3) {
        return (T) i(t3, k.class.getName());
    }

    static <T extends Throwable> T i(T t3, String str) {
        StackTraceElement[] stackTrace = t3.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.equals(stackTrace[i4].getClassName())) {
                i3 = i4;
            }
        }
        t3.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3 + 1, length));
        return t3;
    }

    public static String j(String str, Object obj) {
        return str + obj;
    }

    public static void k() {
        throw ((NullPointerException) h(new NullPointerException()));
    }

    public static void l(String str) {
        throw ((NullPointerException) h(new NullPointerException(str)));
    }

    private static void m(String str) {
        throw ((NullPointerException) h(new NullPointerException(g(str))));
    }

    public static void n(String str) {
        throw ((g2.p) h(new g2.p(str)));
    }

    public static void o(String str) {
        n("lateinit property " + str + " has not been initialized");
    }
}
