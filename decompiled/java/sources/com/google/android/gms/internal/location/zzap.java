package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;

/* loaded from: /root/release/classes.dex */
final class zzap extends zzat {
    final /* synthetic */ LocationCallback zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzap(zzau zzauVar, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        super(googleApiClient);
        this.zza = locationCallback;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzda) anyClient).zzB(ListenerHolders.createListenerKey(this.zza, LocationCallback.class.getSimpleName()), true, zzau.zza(this));
    }
}
