package com.google.android.gms.internal.play_billing;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* loaded from: /root/release/classes.dex */
public abstract class zzbw {
    private static String zza = "com.google.android.gms.internal.play_billing.zzcb";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.play_billing.zzcb", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzdc.zza();
    }

    public static long zzb() {
        zzbw zzbwVar;
        zzbwVar = zzbu.zza;
        return zzbwVar.zzc();
    }

    public static zzbf zzd(String str) {
        zzbw zzbwVar;
        zzbwVar = zzbu.zza;
        return zzbwVar.zze(str);
    }

    public static zzbh zzf() {
        return zzi().zza();
    }

    public static zzbv zzg() {
        zzbw zzbwVar;
        zzbwVar = zzbu.zza;
        return zzbwVar.zzh();
    }

    public static zzcl zzi() {
        zzbw zzbwVar;
        zzbwVar = zzbu.zza;
        return zzbwVar.zzj();
    }

    public static zzcy zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        zzbw zzbwVar;
        zzbwVar = zzbu.zza;
        return zzbwVar.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z3) {
        zzi().zzd(str, level, z3);
        return false;
    }

    protected long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract zzbf zze(String str);

    protected abstract zzbv zzh();

    protected zzcl zzj() {
        return zzcl.zze();
    }

    protected abstract String zzm();
}
