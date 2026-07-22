package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

/* loaded from: /root/release/classes.dex */
public final class zzx {
    public static int zza(int i3, int i4, String str) {
        String zza;
        if (i3 >= 0 && i3 < i4) {
            return i3;
        }
        if (i3 < 0) {
            zza = zzy.zza("%s (%s) must not be negative", "index", Integer.valueOf(i3));
        } else {
            if (i4 < 0) {
                throw new IllegalArgumentException("negative size: " + i4);
            }
            zza = zzy.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(zze(i3, i4, "index"));
        }
        return i3;
    }

    public static Object zzc(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void zzd(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException((i3 < 0 || i3 > i5) ? zze(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? zze(i4, i5, "end index") : zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3)));
        }
    }

    private static String zze(int i3, int i4, String str) {
        if (i3 < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }
}
