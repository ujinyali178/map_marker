package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
final class zzt extends zzv {
    final /* synthetic */ long zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzt(zzw zzwVar, GoogleApiClient googleApiClient, long j3, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = j3;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zzf zzfVar = (zzf) anyClient;
        long j3 = this.zza;
        PendingIntent pendingIntent = this.zzb;
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkArgument(j3 >= 0, "detectionIntervalMillis must be >= 0");
        ((zzo) zzfVar.getService()).zzr(j3, true, pendingIntent);
        setResult((zzt) Status.RESULT_SUCCESS);
    }
}
