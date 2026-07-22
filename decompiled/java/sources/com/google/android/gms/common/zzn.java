package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class zzn {
    private static volatile zzag zze;
    private static Context zzg;
    static final zzl zza = new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzl zzb = new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzl zzc = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzl zzd = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzf = new Object();

    static zzx zza(String str, zzj zzjVar, boolean z3, boolean z4) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzh(str, zzjVar, z3, z4);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static zzx zzb(String str, boolean z3, boolean z4, boolean z5) {
        return zzi(str, z3, false, false, true);
    }

    static zzx zzc(String str, boolean z3, boolean z4, boolean z5) {
        return zzi(str, z3, false, false, false);
    }

    static /* synthetic */ String zzd(boolean z3, String str, zzj zzjVar) {
        String str2 = true != (!z3 && zzh(str, zzjVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zzjVar.zzf())), Boolean.valueOf(z3), "12451000.false");
    }

    static synchronized void zze(Context context) {
        synchronized (zzn.class) {
            if (zzg != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    static boolean zzf() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzj();
                return zze.zzg();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        }
    }

    static boolean zzg() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzj();
                return zze.zzi();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        }
    }

    private static zzx zzh(final String str, final zzj zzjVar, final boolean z3, boolean z4) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                return zze.zzh(new zzs(str, zzjVar, z3, z4), ObjectWrapper.wrap(zzg.getPackageManager())) ? zzx.zzb() : new zzv(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzn.zzd(z3, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                return zzx.zzd("module call", e3);
            }
        } catch (DynamiteModule.LoadingException e4) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
            return zzx.zzd("module init: ".concat(String.valueOf(e4.getMessage())), e4);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    private static zzx zzi(String str, boolean z3, boolean z4, boolean z5, boolean z6) {
        String concat;
        zzx zzd2;
        zzo zzoVar;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzj();
                zzoVar = new zzo(str, z3, false, ObjectWrapper.wrap(zzg), false, true);
            } catch (DynamiteModule.LoadingException e3) {
                e = e3;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                concat = "module init: ".concat(String.valueOf(e.getMessage()));
            }
            try {
                zzq zze2 = z6 ? zze.zze(zzoVar) : zze.zzf(zzoVar);
                if (zze2.zzb()) {
                    zzd2 = zzx.zzf(zze2.zzc());
                } else {
                    String zza2 = zze2.zza();
                    PackageManager.NameNotFoundException nameNotFoundException = zze2.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                    if (zza2 == null) {
                        zza2 = "error checking package certificate";
                    }
                    zzd2 = zzx.zzg(zze2.zzc(), zze2.zzd(), zza2, nameNotFoundException);
                }
            } catch (RemoteException e4) {
                e = e4;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                concat = "module call";
                zzd2 = zzx.zzd(concat, e);
                return zzd2;
            }
            return zzd2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static void zzj() {
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull(zzg);
        synchronized (zzf) {
            if (zze == null) {
                zze = zzaf.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
