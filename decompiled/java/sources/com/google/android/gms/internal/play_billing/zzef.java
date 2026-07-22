package com.google.android.gms.internal.play_billing;

import java.util.List;

/* loaded from: /root/release/classes.dex */
final class zzef implements zzhv {
    private final zzee zza;

    private zzef(zzee zzeeVar) {
        byte[] bArr = zzfd.zzd;
        this.zza = zzeeVar;
        zzeeVar.zza = this;
    }

    public static zzef zza(zzee zzeeVar) {
        zzef zzefVar = zzeeVar.zza;
        return zzefVar != null ? zzefVar : new zzef(zzeeVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzA(int i3, int i4) {
        this.zza.zzp(i3, (i4 >> 31) ^ (i4 + i4));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzB(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                zzee zzeeVar = this.zza;
                int intValue = ((Integer) list.get(i4)).intValue();
                zzeeVar.zzp(i3, (intValue >> 31) ^ (intValue + intValue));
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int intValue2 = ((Integer) list.get(i6)).intValue();
            i5 += zzee.zzx((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            zzee zzeeVar2 = this.zza;
            int intValue3 = ((Integer) list.get(i4)).intValue();
            zzeeVar2.zzq((intValue3 >> 31) ^ (intValue3 + intValue3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzC(int i3, long j3) {
        this.zza.zzr(i3, (j3 >> 63) ^ (j3 + j3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzD(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                zzee zzeeVar = this.zza;
                long longValue = ((Long) list.get(i4)).longValue();
                zzeeVar.zzr(i3, (longValue >> 63) ^ (longValue + longValue));
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            long longValue2 = ((Long) list.get(i6)).longValue();
            i5 += zzee.zzy((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            zzee zzeeVar2 = this.zza;
            long longValue3 = ((Long) list.get(i4)).longValue();
            zzeeVar2.zzs((longValue3 >> 63) ^ (longValue3 + longValue3));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    @Deprecated
    public final void zzE(int i3) {
        this.zza.zzo(i3, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzF(int i3, String str) {
        this.zza.zzm(i3, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzG(int i3, List list) {
        int i4 = 0;
        if (!(list instanceof zzfk)) {
            while (i4 < list.size()) {
                this.zza.zzm(i3, (String) list.get(i4));
                i4++;
            }
            return;
        }
        zzfk zzfkVar = (zzfk) list;
        while (i4 < list.size()) {
            Object zzf = zzfkVar.zzf(i4);
            if (zzf instanceof String) {
                this.zza.zzm(i3, (String) zzf);
            } else {
                this.zza.zze(i3, (zzdw) zzf);
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzH(int i3, int i4) {
        this.zza.zzp(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzI(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzp(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            i5 += zzee.zzx(((Integer) list.get(i6)).intValue());
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzq(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzJ(int i3, long j3) {
        this.zza.zzr(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzK(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzr(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            i5 += zzee.zzy(((Long) list.get(i6)).longValue());
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzs(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzb(int i3, boolean z3) {
        this.zza.zzd(i3, z3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzc(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzd(i3, ((Boolean) list.get(i4)).booleanValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Boolean) list.get(i6)).booleanValue();
            i5++;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i4)).booleanValue() ? (byte) 1 : (byte) 0);
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzd(int i3, zzdw zzdwVar) {
        this.zza.zze(i3, zzdwVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zze(int i3, List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.zza.zze(i3, (zzdw) list.get(i4));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzf(int i3, double d3) {
        this.zza.zzh(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzg(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Double) list.get(i6)).doubleValue();
            i5 += 8;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i4)).doubleValue()));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    @Deprecated
    public final void zzh(int i3) {
        this.zza.zzo(i3, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzi(int i3, int i4) {
        this.zza.zzj(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzj(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzj(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            i5 += zzee.zzu(((Integer) list.get(i6)).intValue());
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzk(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzk(int i3, int i4) {
        this.zza.zzf(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzl(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzf(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Integer) list.get(i6)).intValue();
            i5 += 4;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzg(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzm(int i3, long j3) {
        this.zza.zzh(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzn(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Long) list.get(i6)).longValue();
            i5 += 8;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzi(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzo(int i3, float f3) {
        this.zza.zzf(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzp(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzf(i3, Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Float) list.get(i6)).floatValue();
            i5 += 4;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i4)).floatValue()));
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzq(int i3, Object obj, zzgm zzgmVar) {
        zzee zzeeVar = this.zza;
        zzeeVar.zzo(i3, 3);
        zzgmVar.zzi((zzgc) obj, zzeeVar.zza);
        zzeeVar.zzo(i3, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzr(int i3, int i4) {
        this.zza.zzj(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzs(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzj(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            i5 += zzee.zzu(((Integer) list.get(i6)).intValue());
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzk(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzt(int i3, long j3) {
        this.zza.zzr(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzu(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzr(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            i5 += zzee.zzy(((Long) list.get(i6)).longValue());
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzs(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzv(int i3, Object obj, zzgm zzgmVar) {
        zzgc zzgcVar = (zzgc) obj;
        zzeb zzebVar = (zzeb) this.zza;
        zzebVar.zzq((i3 << 3) | 2);
        zzebVar.zzq(((zzdg) zzgcVar).zza(zzgmVar));
        zzgmVar.zzi(zzgcVar, zzebVar.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzw(int i3, int i4) {
        this.zza.zzf(i3, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzx(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzf(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Integer) list.get(i6)).intValue();
            i5 += 4;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzg(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzy(int i3, long j3) {
        this.zza.zzh(i3, j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhv
    public final void zzz(int i3, List list, boolean z3) {
        int i4 = 0;
        if (!z3) {
            while (i4 < list.size()) {
                this.zza.zzh(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.zza.zzo(i3, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            ((Long) list.get(i6)).longValue();
            i5 += 8;
        }
        this.zza.zzq(i5);
        while (i4 < list.size()) {
            this.zza.zzi(((Long) list.get(i4)).longValue());
            i4++;
        }
    }
}
