package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;

/* loaded from: /root/release/classes.dex */
final class zzbr extends zzbd {
    final /* synthetic */ zzbs zza;

    zzbr(zzbs zzbsVar) {
        this.zza = zzbsVar;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzc(String str) {
        if (str != null) {
            this.zza.setResult((zzbs) new zzbv(str));
        } else {
            this.zza.setResult((zzbs) new zzbv(new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR)));
        }
    }
}
