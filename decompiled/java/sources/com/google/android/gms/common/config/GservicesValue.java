package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: /root/release/classes.dex */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final Object zzb;
    private Object zzd = null;

    protected GservicesValue(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @ResultIgnorabilityUnspecified
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    public static GservicesValue<Float> value(String str, Float f3) {
        return new zzd(str, f3);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l3) {
        return new zzb(str, l3);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }

    public static GservicesValue<Boolean> value(String str, boolean z3) {
        return new zza(str, Boolean.valueOf(z3));
    }

    @ResultIgnorabilityUnspecified
    public final T get() {
        T t3 = (T) this.zzd;
        if (t3 != null) {
            return t3;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th;
            }
        }
        try {
            T t4 = (T) zza(this.zza);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t4;
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                T t5 = (T) zza(this.zza);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t5;
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public void override(T t3) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = t3;
        Object obj = zzc;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    public void resetOverride() {
        this.zzd = null;
    }

    protected abstract Object zza(String str);
}
