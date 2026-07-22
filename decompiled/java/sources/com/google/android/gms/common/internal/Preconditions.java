package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: /root/release/classes.dex */
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    public static void checkArgument(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static double checkArgumentInRange(double d3, double d4, double d5, String str) {
        if (d3 < d4) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d4), Double.valueOf(d5)));
        }
        if (d3 <= d5) {
            return d3;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d4), Double.valueOf(d5)));
    }

    public static float checkArgumentInRange(float f3, float f4, float f5, String str) {
        if (f3 < f4) {
            throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f4), Float.valueOf(f5)));
        }
        if (f3 <= f5) {
            return f3;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f4), Float.valueOf(f5)));
    }

    public static int checkArgumentInRange(int i3, int i4, int i5, String str) {
        if (i3 < i4) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i4), Integer.valueOf(i5)));
        }
        if (i3 <= i5) {
            return i3;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    public static long checkArgumentInRange(long j3, long j4, long j5, String str) {
        if (j3 < j4) {
            throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j4), Long.valueOf(j5)));
        }
        if (j3 <= j5) {
            return j3;
        }
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j4), Long.valueOf(j5)));
    }

    public static void checkHandlerThread(Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + ".");
        }
    }

    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkMainThread() {
        checkMainThread("Must be called on the main application thread");
    }

    public static void checkMainThread(String str) {
        if (!com.google.android.gms.common.util.zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    public static void checkNotMainThread(String str) {
        if (com.google.android.gms.common.util.zzb.zza()) {
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T t3) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("null reference");
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T t3, Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int checkNotZero(int i3) {
        if (i3 != 0) {
            return i3;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static int checkNotZero(int i3, Object obj) {
        if (i3 != 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static long checkNotZero(long j3) {
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    public static long checkNotZero(long j3, Object obj) {
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void checkState(boolean z3) {
        if (!z3) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    static String zza(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + 48);
        int i3 = 0;
        int i4 = 0;
        while (i3 < 3 && (indexOf = str.indexOf("%s", i4)) != -1) {
            sb.append(str.substring(i4, indexOf));
            sb.append(objArr[i3]);
            i4 = indexOf + 2;
            i3++;
        }
        sb.append(str.substring(i4));
        if (i3 < 3) {
            sb.append(" [");
            sb.append(objArr[i3]);
            for (int i5 = i3 + 1; i5 < 3; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
