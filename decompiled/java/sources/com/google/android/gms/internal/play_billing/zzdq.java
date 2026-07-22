package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzdq extends zzdt {
    private final int zzc;

    zzdq(byte[] bArr, int i3, int i4) {
        super(bArr);
        zzdw.zzj(0, i4, bArr.length);
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt, com.google.android.gms.internal.play_billing.zzdw
    public final byte zza(int i3) {
        int i4 = this.zzc;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return this.zza[i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt, com.google.android.gms.internal.play_billing.zzdw
    final byte zzb(int i3) {
        return this.zza[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdt, com.google.android.gms.internal.play_billing.zzdw
    public final int zzd() {
        return this.zzc;
    }
}
