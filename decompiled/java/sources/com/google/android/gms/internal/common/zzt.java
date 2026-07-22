package com.google.android.gms.internal.common;

/* loaded from: /root/release/classes.dex */
final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzt(zzu zzuVar, zzx zzxVar, CharSequence charSequence) {
        super(zzxVar, charSequence);
        this.zza = zzuVar;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzc(int i3) {
        return i3 + 1;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzd(int i3) {
        zzo zzoVar = this.zza.zza;
        CharSequence charSequence = ((zzw) this).zzb;
        int length = charSequence.length();
        zzs.zzb(i3, length, "index");
        while (i3 < length) {
            if (zzoVar.zza(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }
}
