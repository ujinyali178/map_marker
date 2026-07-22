package androidx.core.util;

import java.util.Locale;

/* loaded from: /root/release/classes.dex */
public final class d {
    public static void a(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static float b(float f3, String str) {
        if (Float.isNaN(f3)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (!Float.isInfinite(f3)) {
            return f3;
        }
        throw new IllegalArgumentException(str + " must not be infinite");
    }

    public static float c(float f3, float f4, float f5, String str) {
        if (f3 < f4) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f4), Float.valueOf(f5)));
        }
        if (f3 <= f5) {
            return f3;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f4), Float.valueOf(f5)));
    }

    public static long d(long j3, long j4, long j5, String str) {
        if (j3 < j4) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j4), Long.valueOf(j5)));
        }
        if (j3 <= j5) {
            return j3;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j4), Long.valueOf(j5)));
    }

    public static <T> T e(T t3) {
        t3.getClass();
        return t3;
    }

    public static <T> T f(T t3, Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void g(boolean z3, String str) {
        if (!z3) {
            throw new IllegalStateException(str);
        }
    }
}
