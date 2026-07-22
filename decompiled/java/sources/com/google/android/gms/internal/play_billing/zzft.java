package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzft implements zzga {
    private final zzga[] zza;

    zzft(zzga... zzgaVarArr) {
        this.zza = zzgaVarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzga
    public final zzfz zzb(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            zzga zzgaVar = this.zza[i3];
            if (zzgaVar.zzc(cls)) {
                return zzgaVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.zzga
    public final boolean zzc(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.zza[i3].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
