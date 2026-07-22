package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: /root/release/classes.dex */
final class zzaq extends zzat {
    final /* synthetic */ boolean zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaq(zzau zzauVar, GoogleApiClient googleApiClient, boolean z3) {
        super(googleApiClient);
        this.zza = z3;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzda) anyClient).zzA(this.zza, zzau.zza(this));
    }
}
