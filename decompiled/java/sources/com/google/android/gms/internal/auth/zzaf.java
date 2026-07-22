package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* loaded from: /root/release/classes.dex */
final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z3) {
        this.zza.setResult((zzag) new zzak(z3 ? Status.RESULT_SUCCESS : zzal.zza));
    }
}
