package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzgl implements zzfz {
    private final zzgc zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzgl(zzgc zzgcVar, String str, Object[] objArr) {
        this.zza = zzgcVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i3 = charAt & 8191;
        int i4 = 1;
        int i5 = 13;
        while (true) {
            int i6 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 < 55296) {
                this.zzd = i3 | (charAt2 << i5);
                return;
            } else {
                i3 |= (charAt2 & 8191) << i5;
                i5 += 13;
                i4 = i6;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final zzgc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final int zzc() {
        int i3 = this.zzd;
        if ((i3 & 1) != 0) {
            return 1;
        }
        return (i3 & 4) == 4 ? 3 : 2;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
