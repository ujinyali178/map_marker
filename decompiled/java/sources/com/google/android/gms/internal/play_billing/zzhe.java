package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public final class zzhe {
    private static final zzhe zza = new zzhe(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhe(int i3, int[] iArr, Object[] objArr, boolean z3) {
        this.zze = -1;
        this.zzb = i3;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z3;
    }

    public static zzhe zzc() {
        return zza;
    }

    static zzhe zze(zzhe zzheVar, zzhe zzheVar2) {
        int i3 = zzheVar.zzb + zzheVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzheVar.zzc, i3);
        System.arraycopy(zzheVar2.zzc, 0, copyOf, zzheVar.zzb, zzheVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzheVar.zzd, i3);
        System.arraycopy(zzheVar2.zzd, 0, copyOf2, zzheVar.zzb, zzheVar2.zzb);
        return new zzhe(i3, copyOf, copyOf2, true);
    }

    static zzhe zzf() {
        return new zzhe(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i3) {
        int[] iArr = this.zzc;
        if (i3 > iArr.length) {
            int i4 = this.zzb;
            int i5 = i4 + (i4 / 2);
            if (i5 >= i3) {
                i3 = i5;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhe)) {
            return false;
        }
        zzhe zzheVar = (zzhe) obj;
        int i3 = this.zzb;
        if (i3 == zzheVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzheVar.zzc;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzheVar.zzd;
                    int i5 = this.zzb;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (objArr[i6].equals(objArr2[i6])) {
                        }
                    }
                    return true;
                }
                if (iArr[i4] != iArr2[i4]) {
                    break;
                }
                i4++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzb;
        int i4 = i3 + 527;
        int[] iArr = this.zzc;
        int i5 = 17;
        int i6 = 17;
        for (int i7 = 0; i7 < i3; i7++) {
            i6 = (i6 * 31) + iArr[i7];
        }
        int i8 = ((i4 * 31) + i6) * 31;
        Object[] objArr = this.zzd;
        int i9 = this.zzb;
        for (int i10 = 0; i10 < i9; i10++) {
            i5 = (i5 * 31) + objArr[i10].hashCode();
        }
        return i8 + i5;
    }

    public final int zza() {
        int zzy;
        int zzx;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i3 = zzee.zzx(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = i8 << 3;
                    zzdw zzdwVar = (zzdw) this.zzd[i6];
                    int i11 = zzee.zzb;
                    int zzd = zzdwVar.zzd();
                    i3 = zzee.zzx(i10) + zzee.zzx(zzd) + zzd;
                } else if (i9 == 3) {
                    int i12 = i8 << 3;
                    int i13 = zzee.zzb;
                    zzy = ((zzhe) this.zzd[i6]).zza();
                    int zzx2 = zzee.zzx(i12);
                    zzx = zzx2 + zzx2;
                } else {
                    if (i9 != 5) {
                        throw new IllegalStateException(zzff.zza());
                    }
                    ((Integer) this.zzd[i6]).intValue();
                    i3 = zzee.zzx(i8 << 3) + 4;
                }
                i5 += i3;
            } else {
                int i14 = i8 << 3;
                zzy = zzee.zzy(((Long) this.zzd[i6]).longValue());
                zzx = zzee.zzx(i14);
            }
            i3 = zzx + zzy;
            i5 += i3;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i3 = this.zze;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzb; i5++) {
            int i6 = this.zzc[i5] >>> 3;
            zzdw zzdwVar = (zzdw) this.zzd[i5];
            int i7 = zzee.zzb;
            int zzd = zzdwVar.zzd();
            int zzx = zzee.zzx(zzd) + zzd;
            int zzx2 = zzee.zzx(16);
            int zzx3 = zzee.zzx(i6);
            int zzx4 = zzee.zzx(8);
            i4 += zzx4 + zzx4 + zzx2 + zzx3 + zzee.zzx(24) + zzx;
        }
        this.zze = i4;
        return i4;
    }

    final zzhe zzd(zzhe zzheVar) {
        if (zzheVar.equals(zza)) {
            return this;
        }
        zzg();
        int i3 = this.zzb + zzheVar.zzb;
        zzl(i3);
        System.arraycopy(zzheVar.zzc, 0, this.zzc, this.zzb, zzheVar.zzb);
        System.arraycopy(zzheVar.zzd, 0, this.zzd, this.zzb, zzheVar.zzb);
        this.zzb = i3;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.zzb; i4++) {
            zzge.zzb(sb, i3, String.valueOf(this.zzc[i4] >>> 3), this.zzd[i4]);
        }
    }

    final void zzj(int i3, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i4 = this.zzb;
        iArr[i4] = i3;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    public final void zzk(zzhv zzhvVar) {
        if (this.zzb != 0) {
            for (int i3 = 0; i3 < this.zzb; i3++) {
                int i4 = this.zzc[i3];
                Object obj = this.zzd[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    zzhvVar.zzt(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzhvVar.zzm(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzhvVar.zzd(i6, (zzdw) obj);
                } else if (i5 == 3) {
                    zzhvVar.zzE(i6);
                    ((zzhe) obj).zzk(zzhvVar);
                    zzhvVar.zzh(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(zzff.zza());
                    }
                    zzhvVar.zzk(i6, ((Integer) obj).intValue());
                }
            }
        }
    }
}
