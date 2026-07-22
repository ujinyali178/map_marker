package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;

/* loaded from: /root/release/classes.dex */
class zzdt extends zzds {
    protected final byte[] zza;

    zzdt(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdw) || zzd() != ((zzdw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzdt)) {
            return obj.equals(this);
        }
        zzdt zzdtVar = (zzdt) obj;
        int zzk = zzk();
        int zzk2 = zzdtVar.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzdtVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzdtVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzdtVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzdtVar.zza;
        zzdtVar.zzc();
        int i3 = 0;
        int i4 = 0;
        while (i3 < zzd) {
            if (bArr[i3] != bArr2[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    byte zzb(int i3) {
        return this.zza[i3];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    protected final int zze(int i3, int i4, int i5) {
        return zzfd.zzb(i3, this.zza, 0, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final zzdw zzf(int i3, int i4) {
        int zzj = zzdw.zzj(0, i4, zzd());
        return zzj == 0 ? zzdw.zzb : new zzdq(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    final void zzh(zzdm zzdmVar) {
        ((zzeb) zzdmVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.play_billing.zzdw
    public final boolean zzi() {
        return zzhs.zze(this.zza, 0, zzd());
    }
}
