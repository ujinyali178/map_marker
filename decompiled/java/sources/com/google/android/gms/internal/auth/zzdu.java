package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: /root/release/classes.dex */
final class zzdu {
    static int zza(byte[] bArr, int i3, zzdt zzdtVar) {
        int zzh = zzh(bArr, i3, zzdtVar);
        int i4 = zzdtVar.zza;
        if (i4 < 0) {
            throw zzfb.zzc();
        }
        if (i4 > bArr.length - zzh) {
            throw zzfb.zzf();
        }
        if (i4 == 0) {
            zzdtVar.zzc = zzef.zzb;
            return zzh;
        }
        zzdtVar.zzc = zzef.zzk(bArr, zzh, i4);
        return zzh + i4;
    }

    static int zzb(byte[] bArr, int i3) {
        int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
        int i5 = bArr[i3 + 1] & UnsignedBytes.MAX_VALUE;
        int i6 = bArr[i3 + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int zzc(zzgi zzgiVar, byte[] bArr, int i3, int i4, int i5, zzdt zzdtVar) {
        Object zzd = zzgiVar.zzd();
        int zzl = zzl(zzd, zzgiVar, bArr, i3, i4, i5, zzdtVar);
        zzgiVar.zze(zzd);
        zzdtVar.zzc = zzd;
        return zzl;
    }

    static int zzd(zzgi zzgiVar, byte[] bArr, int i3, int i4, zzdt zzdtVar) {
        Object zzd = zzgiVar.zzd();
        int zzm = zzm(zzd, zzgiVar, bArr, i3, i4, zzdtVar);
        zzgiVar.zze(zzd);
        zzdtVar.zzc = zzd;
        return zzm;
    }

    static int zze(zzgi zzgiVar, int i3, byte[] bArr, int i4, int i5, zzez zzezVar, zzdt zzdtVar) {
        int zzd = zzd(zzgiVar, bArr, i4, i5, zzdtVar);
        while (true) {
            zzezVar.add(zzdtVar.zzc);
            if (zzd >= i5) {
                break;
            }
            int zzh = zzh(bArr, zzd, zzdtVar);
            if (i3 != zzdtVar.zza) {
                break;
            }
            zzd = zzd(zzgiVar, bArr, zzh, i5, zzdtVar);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i3, zzez zzezVar, zzdt zzdtVar) {
        zzew zzewVar = (zzew) zzezVar;
        int zzh = zzh(bArr, i3, zzdtVar);
        int i4 = zzdtVar.zza + zzh;
        while (zzh < i4) {
            zzh = zzh(bArr, zzh, zzdtVar);
            zzewVar.zze(zzdtVar.zza);
        }
        if (zzh == i4) {
            return zzh;
        }
        throw zzfb.zzf();
    }

    static int zzg(int i3, byte[] bArr, int i4, int i5, zzha zzhaVar, zzdt zzdtVar) {
        if ((i3 >>> 3) == 0) {
            throw zzfb.zza();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int zzk = zzk(bArr, i4, zzdtVar);
            zzhaVar.zzh(i3, Long.valueOf(zzdtVar.zzb));
            return zzk;
        }
        if (i6 == 1) {
            zzhaVar.zzh(i3, Long.valueOf(zzn(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int zzh = zzh(bArr, i4, zzdtVar);
            int i7 = zzdtVar.zza;
            if (i7 < 0) {
                throw zzfb.zzc();
            }
            if (i7 > bArr.length - zzh) {
                throw zzfb.zzf();
            }
            zzhaVar.zzh(i3, i7 == 0 ? zzef.zzb : zzef.zzk(bArr, zzh, i7));
            return zzh + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw zzfb.zza();
            }
            zzhaVar.zzh(i3, Integer.valueOf(zzb(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzha zzd = zzha.zzd();
        int i9 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int zzh2 = zzh(bArr, i4, zzdtVar);
            int i10 = zzdtVar.zza;
            i9 = i10;
            if (i10 == i8) {
                i4 = zzh2;
                break;
            }
            int zzg = zzg(i9, bArr, zzh2, i5, zzd, zzdtVar);
            i9 = i10;
            i4 = zzg;
        }
        if (i4 > i5 || i9 != i8) {
            throw zzfb.zzd();
        }
        zzhaVar.zzh(i3, zzd);
        return i4;
    }

    static int zzh(byte[] bArr, int i3, zzdt zzdtVar) {
        int i4 = i3 + 1;
        byte b4 = bArr[i3];
        if (b4 < 0) {
            return zzi(b4, bArr, i4, zzdtVar);
        }
        zzdtVar.zza = b4;
        return i4;
    }

    static int zzi(int i3, byte[] bArr, int i4, zzdt zzdtVar) {
        int i5;
        int i6;
        byte b4 = bArr[i4];
        int i7 = i4 + 1;
        int i8 = i3 & 127;
        if (b4 < 0) {
            int i9 = i8 | ((b4 & Ascii.DEL) << 7);
            int i10 = i7 + 1;
            byte b5 = bArr[i7];
            if (b5 >= 0) {
                i5 = b5 << Ascii.SO;
            } else {
                i8 = i9 | ((b5 & Ascii.DEL) << 14);
                i7 = i10 + 1;
                byte b6 = bArr[i10];
                if (b6 >= 0) {
                    i6 = b6 << Ascii.NAK;
                } else {
                    i9 = i8 | ((b6 & Ascii.DEL) << 21);
                    i10 = i7 + 1;
                    byte b7 = bArr[i7];
                    if (b7 >= 0) {
                        i5 = b7 << Ascii.FS;
                    } else {
                        int i11 = i9 | ((b7 & Ascii.DEL) << 28);
                        while (true) {
                            int i12 = i10 + 1;
                            if (bArr[i10] >= 0) {
                                zzdtVar.zza = i11;
                                return i12;
                            }
                            i10 = i12;
                        }
                    }
                }
            }
            zzdtVar.zza = i9 | i5;
            return i10;
        }
        i6 = b4 << 7;
        zzdtVar.zza = i8 | i6;
        return i7;
    }

    static int zzj(int i3, byte[] bArr, int i4, int i5, zzez zzezVar, zzdt zzdtVar) {
        zzew zzewVar = (zzew) zzezVar;
        int zzh = zzh(bArr, i4, zzdtVar);
        while (true) {
            zzewVar.zze(zzdtVar.zza);
            if (zzh >= i5) {
                break;
            }
            int zzh2 = zzh(bArr, zzh, zzdtVar);
            if (i3 != zzdtVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzdtVar);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i3, zzdt zzdtVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzdtVar.zzb = j3;
            return i4;
        }
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        long j4 = (j3 & 127) | ((b4 & Ascii.DEL) << 7);
        int i6 = 7;
        while (b4 < 0) {
            int i7 = i5 + 1;
            byte b5 = bArr[i5];
            i6 += 7;
            j4 |= (b5 & Ascii.DEL) << i6;
            i5 = i7;
            b4 = b5;
        }
        zzdtVar.zzb = j4;
        return i5;
    }

    static int zzl(Object obj, zzgi zzgiVar, byte[] bArr, int i3, int i4, int i5, zzdt zzdtVar) {
        int zzb = ((zzga) zzgiVar).zzb(obj, bArr, i3, i4, i5, zzdtVar);
        zzdtVar.zzc = obj;
        return zzb;
    }

    static int zzm(Object obj, zzgi zzgiVar, byte[] bArr, int i3, int i4, zzdt zzdtVar) {
        int i5 = i3 + 1;
        int i6 = bArr[i3];
        if (i6 < 0) {
            i5 = zzi(i6, bArr, i5, zzdtVar);
            i6 = zzdtVar.zza;
        }
        int i7 = i5;
        if (i6 < 0 || i6 > i4 - i7) {
            throw zzfb.zzf();
        }
        int i8 = i6 + i7;
        zzgiVar.zzg(obj, bArr, i7, i8, zzdtVar);
        zzdtVar.zzc = obj;
        return i8;
    }

    static long zzn(byte[] bArr, int i3) {
        return (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48) | ((bArr[i3 + 7] & 255) << 56);
    }
}
