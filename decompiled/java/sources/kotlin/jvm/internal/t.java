package kotlin.jvm.internal;

import com.google.maps.android.BuildConfig;
import p2.u;
import p2.v;
import p2.w;

/* loaded from: /root/release/classes.dex */
public class t {
    public static Object a(Object obj, int i3) {
        if (obj != null && !c(obj, i3)) {
            f(obj, "kotlin.jvm.functions.Function" + i3);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof p2.a) {
            return 0;
        }
        if (obj instanceof p2.l) {
            return 1;
        }
        if (obj instanceof p2.p) {
            return 2;
        }
        if (obj instanceof p2.q) {
            return 3;
        }
        if (obj instanceof p2.r) {
            return 4;
        }
        if (obj instanceof p2.s) {
            return 5;
        }
        if (obj instanceof p2.t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof p2.b) {
            return 10;
        }
        if (obj instanceof p2.c) {
            return 11;
        }
        if (obj instanceof p2.d) {
            return 12;
        }
        if (obj instanceof p2.e) {
            return 13;
        }
        if (obj instanceof p2.f) {
            return 14;
        }
        if (obj instanceof p2.g) {
            return 15;
        }
        if (obj instanceof p2.h) {
            return 16;
        }
        if (obj instanceof p2.i) {
            return 17;
        }
        if (obj instanceof p2.j) {
            return 18;
        }
        if (obj instanceof p2.k) {
            return 19;
        }
        if (obj instanceof p2.m) {
            return 20;
        }
        if (obj instanceof p2.n) {
            return 21;
        }
        return obj instanceof p2.o ? 22 : -1;
    }

    public static boolean c(Object obj, int i3) {
        return (obj instanceof g2.c) && b(obj) == i3;
    }

    private static <T extends Throwable> T d(T t3) {
        return (T) k.i(t3, t.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw ((ClassCastException) d(classCastException));
    }

    public static void f(Object obj, String str) {
        g((obj == null ? BuildConfig.TRAVIS : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void g(String str) {
        throw e(new ClassCastException(str));
    }
}
