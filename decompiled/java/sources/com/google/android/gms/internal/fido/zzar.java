package com.google.android.gms.internal.fido;

/* loaded from: /root/release/classes.dex */
final class zzar extends zzao {
    private final zzat zza;

    zzar(zzat zzatVar, int i3) {
        super(zzatVar.size(), i3);
        this.zza = zzatVar;
    }

    @Override // com.google.android.gms.internal.fido.zzao
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
