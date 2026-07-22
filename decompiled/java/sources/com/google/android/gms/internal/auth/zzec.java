package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* loaded from: /root/release/classes.dex */
class zzec extends zzeb {
    protected final byte[] zza;

    zzec(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzef) || zzd() != ((zzef) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzec)) {
            return obj.equals(this);
        }
        zzec zzecVar = (zzec) obj;
        int zzj = zzj();
        int zzj2 = zzecVar.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzecVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        if (zzd > zzecVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzecVar.zzd());
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzecVar.zza;
        zzecVar.zzc();
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

    @Override // com.google.android.gms.internal.auth.zzef
    public byte zza(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.auth.zzef
    byte zzb(int i3) {
        return this.zza[i3];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.auth.zzef
    protected final int zze(int i3, int i4, int i5) {
        return zzfa.zzb(i3, this.zza, 0, i5);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final zzef zzf(int i3, int i4) {
        int zzi = zzef.zzi(0, i4, zzd());
        return zzi == 0 ? zzef.zzb : new zzdz(this.zza, 0, zzi);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzef
    public final boolean zzh() {
        return zzhn.zzc(this.zza, 0, zzd());
    }
}
