package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /root/release/classes.dex */
final class zzbs extends zzbj {
    zzbs(zzbt zzbtVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.internal.auth.zzbj
    protected final void zza(Context context, zzbh zzbhVar) {
        zzbhVar.zzd(new zzbr(this));
    }
}
