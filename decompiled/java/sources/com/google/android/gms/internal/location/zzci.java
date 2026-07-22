package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /root/release/classes.dex */
final class zzci extends zzl {
    final /* synthetic */ TaskCompletionSource zza;

    zzci(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzm
    public final void zzb(int i3, String[] strArr) {
        TaskUtil.setResultOrApiException(new Status(GeofenceStatusCodes.zza(i3)), this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzm
    public final void zzc(int i3, PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(new Status(GeofenceStatusCodes.zza(i3)), this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzm
    public final void zzd(int i3, String[] strArr) {
        TaskUtil.setResultOrApiException(new Status(GeofenceStatusCodes.zza(i3)), this.zza);
    }
}
