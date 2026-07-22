package com.google.android.gms.internal.location;

/* loaded from: /root/release/classes.dex */
public final class zzdm {
    public static int zza(int i3, int i4, String str) {
        String zza;
        if (i3 >= 0 && i3 < i4) {
            return i3;
        }
        if (i3 < 0) {
            zza = zzdn.zza("%s (%s) must not be negative", "index", Integer.valueOf(i3));
        } else {
            if (i4 < 0) {
                throw new IllegalArgumentException("negative size: " + i4);
            }
            zza = zzdn.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(zzd(i3, i4, "index"));
        }
        return i3;
    }

    public static void zzc(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException((i3 < 0 || i3 > i5) ? zzd(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? zzd(i4, i5, "end index") : zzdn.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3)));
        }
    }

    private static String zzd(int i3, int i4, String str) {
        if (i3 < 0) {
            return zzdn.zza("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return zzdn.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }
}
