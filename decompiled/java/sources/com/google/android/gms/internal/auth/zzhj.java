package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
final class zzhj {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zzhi zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARN: Removed duplicated region for block: B:15:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    static {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhj.<clinit>():void");
    }

    private zzhj() {
    }

    static double zza(Object obj, long j3) {
        return zze.zza(obj, j3);
    }

    static float zzb(Object obj, long j3) {
        return zze.zzb(obj, j3);
    }

    static int zzc(Object obj, long j3) {
        return zze.zza.getInt(obj, j3);
    }

    static long zzd(Object obj, long j3) {
        return zze.zza.getLong(obj, j3);
    }

    static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    static Object zzf(Object obj, long j3) {
        return zze.zza.getObject(obj, j3);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhf());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzhj.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    static /* synthetic */ void zzi(Object obj, long j3, boolean z3) {
        zzhi zzhiVar = zze;
        long j4 = (-4) & j3;
        int i3 = zzhiVar.zza.getInt(obj, j4);
        int i4 = ((~((int) j3)) & 3) << 3;
        zzhiVar.zza.putInt(obj, j4, ((z3 ? 1 : 0) << i4) | ((~(255 << i4)) & i3));
    }

    static /* synthetic */ void zzj(Object obj, long j3, boolean z3) {
        zzhi zzhiVar = zze;
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        zzhiVar.zza.putInt(obj, j4, ((z3 ? 1 : 0) << i3) | ((~(255 << i3)) & zzhiVar.zza.getInt(obj, j4)));
    }

    static void zzk(Object obj, long j3, boolean z3) {
        zze.zzc(obj, j3, z3);
    }

    static void zzl(Object obj, long j3, double d3) {
        zze.zzd(obj, j3, d3);
    }

    static void zzm(Object obj, long j3, float f3) {
        zze.zze(obj, j3, f3);
    }

    static void zzn(Object obj, long j3, int i3) {
        zze.zza.putInt(obj, j3, i3);
    }

    static void zzo(Object obj, long j3, long j4) {
        zze.zza.putLong(obj, j3, j4);
    }

    static void zzp(Object obj, long j3, Object obj2) {
        zze.zza.putObject(obj, j3, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j3) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j3) {
        return ((byte) ((zze.zza.getInt(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255)) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean zzs(Class cls) {
        int i3 = zzds.zza;
        try {
            Class cls2 = zzc;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzt(Object obj, long j3) {
        return zze.zzf(obj, j3);
    }

    static boolean zzu() {
        return zzg;
    }

    static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i3 = zzds.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(Buffer.class, "address");
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
