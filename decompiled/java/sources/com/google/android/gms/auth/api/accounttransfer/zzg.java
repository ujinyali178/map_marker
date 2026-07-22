package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzau;

/* loaded from: /root/release/classes.dex */
final class zzg extends zzl {
    final /* synthetic */ zzaq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzg(AccountTransferClient accountTransferClient, int i3, zzaq zzaqVar) {
        super(1608, null);
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) {
        zzauVar.zzd(new zzf(this, this), this.zza);
    }
}
