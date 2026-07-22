package com.google.android.gms.internal.play_billing;

import java.util.List;

/* loaded from: /root/release/classes.dex */
final class zzgo {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhd zzc;
    private static final zzhd zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhd zzhdVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhdVar = (zzhd) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhdVar;
        zzd = new zzhf();
    }

    public static void zzA(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzz(i3, list, z3);
    }

    public static void zzB(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzB(i3, list, z3);
    }

    public static void zzC(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzD(i3, list, z3);
    }

    public static void zzD(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzI(i3, list, z3);
    }

    public static void zzE(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzK(i3, list, z3);
    }

    static boolean zzF(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int zza(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzu(zzeyVar.zze(i4));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzu(((Integer) list.get(i4)).intValue());
                i4++;
            }
        }
        return i3;
    }

    static int zzb(int i3, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i3 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i3, List list, boolean z3) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzee.zzx(i3 << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzu(zzeyVar.zze(i4));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzu(((Integer) list.get(i4)).intValue());
                i4++;
            }
        }
        return i3;
    }

    static int zzg(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzy(zzfrVar.zze(i4));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzy(((Long) list.get(i4)).longValue());
                i4++;
            }
        }
        return i3;
    }

    static int zzh(int i3, Object obj, zzgm zzgmVar) {
        int i4 = i3 << 3;
        if (!(obj instanceof zzfi)) {
            return zzee.zzx(i4) + zzee.zzv((zzgc) obj, zzgmVar);
        }
        int i5 = zzee.zzb;
        int zza2 = ((zzfi) obj).zza();
        return zzee.zzx(i4) + zzee.zzx(zza2) + zza2;
    }

    static int zzi(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i3 = 0;
            while (i4 < size) {
                int zze = zzeyVar.zze(i4);
                i3 += zzee.zzx((zze >> 31) ^ (zze + zze));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                int intValue = ((Integer) list.get(i4)).intValue();
                i3 += zzee.zzx((intValue >> 31) ^ (intValue + intValue));
                i4++;
            }
        }
        return i3;
    }

    static int zzj(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i3 = 0;
            while (i4 < size) {
                long zze = zzfrVar.zze(i4);
                i3 += zzee.zzy((zze >> 63) ^ (zze + zze));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                long longValue = ((Long) list.get(i4)).longValue();
                i3 += zzee.zzy((longValue >> 63) ^ (longValue + longValue));
                i4++;
            }
        }
        return i3;
    }

    static int zzk(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzey) {
            zzey zzeyVar = (zzey) list;
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzx(zzeyVar.zze(i4));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzx(((Integer) list.get(i4)).intValue());
                i4++;
            }
        }
        return i3;
    }

    static int zzl(List list) {
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfr) {
            zzfr zzfrVar = (zzfr) list;
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzy(zzfrVar.zze(i4));
                i4++;
            }
        } else {
            i3 = 0;
            while (i4 < size) {
                i3 += zzee.zzy(((Long) list.get(i4)).longValue());
                i4++;
            }
        }
        return i3;
    }

    public static zzhd zzm() {
        return zzc;
    }

    public static zzhd zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i3, int i4, Object obj2, zzhd zzhdVar) {
        if (obj2 == null) {
            obj2 = zzhdVar.zzc(obj);
        }
        zzhdVar.zzf(obj2, i3, i4);
        return obj2;
    }

    static void zzp(zzhd zzhdVar, Object obj, Object obj2) {
        zzhdVar.zzh(obj, zzhdVar.zze(zzhdVar.zzd(obj), zzhdVar.zzd(obj2)));
    }

    public static void zzq(Class cls) {
        Class cls2;
        if (!zzex.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzr(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzc(i3, list, z3);
    }

    public static void zzs(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzg(i3, list, z3);
    }

    public static void zzt(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzj(i3, list, z3);
    }

    public static void zzu(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzl(i3, list, z3);
    }

    public static void zzv(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzn(i3, list, z3);
    }

    public static void zzw(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzp(i3, list, z3);
    }

    public static void zzx(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzs(i3, list, z3);
    }

    public static void zzy(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzu(i3, list, z3);
    }

    public static void zzz(int i3, List list, zzhv zzhvVar, boolean z3) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhvVar.zzx(i3, list, z3);
    }
}
