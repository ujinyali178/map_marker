package s;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /root/release/classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f4098a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f4099b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f4100c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f4101d;

    public static void a(String str, int i3) {
        try {
            if (f4100c == null) {
                f.a(str, i3);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i3);
    }

    private static void b(String str, int i3) {
        try {
            if (f4100c == null) {
                f4100c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f4100c.invoke(null, Long.valueOf(f4098a), str, Integer.valueOf(i3));
        } catch (Exception e3) {
            g("asyncTraceBegin", e3);
        }
    }

    public static void c(String str) {
        c.a(str);
    }

    public static void d(String str, int i3) {
        try {
            if (f4101d == null) {
                f.b(str, i3);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i3);
    }

    private static void e(String str, int i3) {
        try {
            if (f4101d == null) {
                f4101d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f4101d.invoke(null, Long.valueOf(f4098a), str, Integer.valueOf(i3));
        } catch (Exception e3) {
            g("asyncTraceEnd", e3);
        }
    }

    public static void f() {
        c.b();
    }

    private static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean h() {
        boolean isEnabled;
        try {
            if (f4099b == null) {
                isEnabled = Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    private static boolean i() {
        try {
            if (f4099b == null) {
                f4098a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f4099b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f4099b.invoke(null, Long.valueOf(f4098a))).booleanValue();
        } catch (Exception e3) {
            g("isTagEnabled", e3);
            return false;
        }
    }
}
