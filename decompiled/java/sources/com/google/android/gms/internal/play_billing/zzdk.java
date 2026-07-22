package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: /root/release/classes.dex */
final class zzdk {
    static int zza(byte[] bArr, int i3, zzdj zzdjVar) {
        int zzh = zzh(bArr, i3, zzdjVar);
        int i4 = zzdjVar.zza;
        if (i4 < 0) {
            throw zzff.zzd();
        }
        if (i4 > bArr.length - zzh) {
            throw zzff.zzg();
        }
        if (i4 == 0) {
            zzdjVar.zzc = zzdw.zzb;
            return zzh;
        }
        zzdjVar.zzc = zzdw.zzl(bArr, zzh, i4);
        return zzh + i4;
    }

    static int zzb(byte[] bArr, int i3) {
        int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
        int i5 = bArr[i3 + 1] & UnsignedBytes.MAX_VALUE;
        int i6 = bArr[i3 + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (i5 << 8) | i4 | (i6 << 16);
    }

    static int zzc(zzgm zzgmVar, byte[] bArr, int i3, int i4, int i5, zzdj zzdjVar) {
        Object zze = zzgmVar.zze();
        int zzl = zzl(zze, zzgmVar, bArr, i3, i4, i5, zzdjVar);
        zzgmVar.zzf(zze);
        zzdjVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzgm zzgmVar, byte[] bArr, int i3, int i4, zzdj zzdjVar) {
        Object zze = zzgmVar.zze();
        int zzm = zzm(zze, zzgmVar, bArr, i3, i4, zzdjVar);
        zzgmVar.zzf(zze);
        zzdjVar.zzc = zze;
        return zzm;
    }

    static int zze(zzgm zzgmVar, int i3, byte[] bArr, int i4, int i5, zzfc zzfcVar, zzdj zzdjVar) {
        int zzd = zzd(zzgmVar, bArr, i4, i5, zzdjVar);
        while (true) {
            zzfcVar.add(zzdjVar.zzc);
            if (zzd >= i5) {
                break;
            }
            int zzh = zzh(bArr, zzd, zzdjVar);
            if (i3 != zzdjVar.zza) {
                break;
            }
            zzd = zzd(zzgmVar, bArr, zzh, i5, zzdjVar);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i3, zzfc zzfcVar, zzdj zzdjVar) {
        zzey zzeyVar = (zzey) zzfcVar;
        int zzh = zzh(bArr, i3, zzdjVar);
        int i4 = zzdjVar.zza + zzh;
        while (zzh < i4) {
            zzh = zzh(bArr, zzh, zzdjVar);
            zzeyVar.zzf(zzdjVar.zza);
        }
        if (zzh == i4) {
            return zzh;
        }
        throw zzff.zzg();
    }

    static int zzg(int i3, byte[] bArr, int i4, int i5, zzhe zzheVar, zzdj zzdjVar) {
        if ((i3 >>> 3) == 0) {
            throw zzff.zzb();
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            int zzk = zzk(bArr, i4, zzdjVar);
            zzheVar.zzj(i3, Long.valueOf(zzdjVar.zzb));
            return zzk;
        }
        if (i6 == 1) {
            zzheVar.zzj(i3, Long.valueOf(zzn(bArr, i4)));
            return i4 + 8;
        }
        if (i6 == 2) {
            int zzh = zzh(bArr, i4, zzdjVar);
            int i7 = zzdjVar.zza;
            if (i7 < 0) {
                throw zzff.zzd();
            }
            if (i7 > bArr.length - zzh) {
                throw zzff.zzg();
            }
            zzheVar.zzj(i3, i7 == 0 ? zzdw.zzb : zzdw.zzl(bArr, zzh, i7));
            return zzh + i7;
        }
        if (i6 != 3) {
            if (i6 != 5) {
                throw zzff.zzb();
            }
            zzheVar.zzj(i3, Integer.valueOf(zzb(bArr, i4)));
            return i4 + 4;
        }
        int i8 = (i3 & (-8)) | 4;
        zzhe zzf = zzhe.zzf();
        int i9 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int zzh2 = zzh(bArr, i4, zzdjVar);
            int i10 = zzdjVar.zza;
            i9 = i10;
            if (i10 == i8) {
                i4 = zzh2;
                break;
            }
            int zzg = zzg(i9, bArr, zzh2, i5, zzf, zzdjVar);
            i9 = i10;
            i4 = zzg;
        }
        if (i4 > i5 || i9 != i8) {
            throw zzff.zze();
        }
        zzheVar.zzj(i3, zzf);
        return i4;
    }

    static int zzh(byte[] bArr, int i3, zzdj zzdjVar) {
        int i4 = i3 + 1;
        byte b4 = bArr[i3];
        if (b4 < 0) {
            return zzi(b4, bArr, i4, zzdjVar);
        }
        zzdjVar.zza = b4;
        return i4;
    }

    static int zzi(int i3, byte[] bArr, int i4, zzdj zzdjVar) {
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
                                zzdjVar.zza = i11;
                                return i12;
                            }
                            i10 = i12;
                        }
                    }
                }
            }
            zzdjVar.zza = i9 | i5;
            return i10;
        }
        i6 = b4 << 7;
        zzdjVar.zza = i8 | i6;
        return i7;
    }

    static int zzj(int i3, byte[] bArr, int i4, int i5, zzfc zzfcVar, zzdj zzdjVar) {
        zzey zzeyVar = (zzey) zzfcVar;
        int zzh = zzh(bArr, i4, zzdjVar);
        while (true) {
            zzeyVar.zzf(zzdjVar.zza);
            if (zzh >= i5) {
                break;
            }
            int zzh2 = zzh(bArr, zzh, zzdjVar);
            if (i3 != zzdjVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzdjVar);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i3, zzdj zzdjVar) {
        long j3 = bArr[i3];
        int i4 = i3 + 1;
        if (j3 >= 0) {
            zzdjVar.zzb = j3;
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
        zzdjVar.zzb = j4;
        return i5;
    }

    static int zzl(Object obj, zzgm zzgmVar, byte[] bArr, int i3, int i4, int i5, zzdj zzdjVar) {
        int zzc = ((zzgf) zzgmVar).zzc(obj, bArr, i3, i4, i5, zzdjVar);
        zzdjVar.zzc = obj;
        return zzc;
    }

    static int zzm(Object obj, zzgm zzgmVar, byte[] bArr, int i3, int i4, zzdj zzdjVar) {
        int i5 = i3 + 1;
        int i6 = bArr[i3];
        if (i6 < 0) {
            i5 = zzi(i6, bArr, i5, zzdjVar);
            i6 = zzdjVar.zza;
        }
        int i7 = i5;
        if (i6 < 0 || i6 > i4 - i7) {
            throw zzff.zzg();
        }
        int i8 = i6 + i7;
        zzgmVar.zzh(obj, bArr, i7, i8, zzdjVar);
        zzdjVar.zzc = obj;
        return i8;
    }

    static long zzn(byte[] bArr, int i3) {
        return (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48) | ((bArr[i3 + 7] & 255) << 56);
    }
}
