package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* loaded from: /root/release/classes.dex */
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzi == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z3 = true;
            }
            zzi = Boolean.valueOf(z3);
        }
        return zzi.booleanValue();
    }

    public static boolean isBstar(Context context) {
        if (zzl == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z3 = true;
            }
            zzl = Boolean.valueOf(z3);
        }
        return zzl.booleanValue();
    }

    public static boolean isLatchsky(Context context) {
        if (zzf == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z3 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z3 = true;
            }
            zzf = Boolean.valueOf(z3);
        }
        return zzf.booleanValue();
    }

    public static boolean isPhone(Context context) {
        if (zza == null) {
            boolean z3 = false;
            if (!isTablet(context) && !isWearable(context) && !zzb(context)) {
                if (zzh == null) {
                    zzh = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                }
                if (!zzh.booleanValue() && !isAuto(context) && !isTv(context)) {
                    if (zzk == null) {
                        zzk = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                    }
                    if (!zzk.booleanValue() && !isBstar(context)) {
                        z3 = true;
                    }
                }
            }
            zza = Boolean.valueOf(z3);
        }
        return zza.booleanValue();
    }

    public static boolean isSevenInchTablet(Context context) {
        return zzc(context.getResources());
    }

    public static boolean isSidewinder(Context context) {
        return zza(context);
    }

    public static boolean isTablet(Context context) {
        return isTablet(context.getResources());
    }

    public static boolean isTablet(Resources resources) {
        if (resources == null) {
            return false;
        }
        if (zzb == null) {
            zzb = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources));
        }
        return zzb.booleanValue();
    }

    public static boolean isTv(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzj == null) {
            boolean z3 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z3 = false;
            }
            zzj = Boolean.valueOf(z3);
        }
        return zzj.booleanValue();
    }

    public static boolean isUserBuild() {
        int i3 = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    public static boolean isWearable(Context context) {
        return zzd(context.getPackageManager());
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zza(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    public static boolean zza(Context context) {
        if (zze == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z3 = true;
            }
            zze = Boolean.valueOf(z3);
        }
        return zze.booleanValue();
    }

    public static boolean zzb(Context context) {
        if (zzg == null) {
            boolean z3 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z3 = false;
            }
            zzg = Boolean.valueOf(z3);
        }
        return zzg.booleanValue();
    }

    public static boolean zzc(Resources resources) {
        boolean z3 = false;
        if (resources == null) {
            return false;
        }
        if (zzc == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z3 = true;
            }
            zzc = Boolean.valueOf(z3);
        }
        return zzc.booleanValue();
    }

    public static boolean zzd(PackageManager packageManager) {
        if (zzd == null) {
            boolean z3 = false;
            if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z3 = true;
            }
            zzd = Boolean.valueOf(z3);
        }
        return zzd.booleanValue();
    }
}
