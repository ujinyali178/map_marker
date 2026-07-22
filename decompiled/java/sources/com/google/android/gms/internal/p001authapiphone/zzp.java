package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /root/release/classes.dex */
final class zzp extends zzd {
    final /* synthetic */ TaskCompletionSource zza;

    zzp(zzr zzrVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zze
    public final void zzb(Status status, int i3) {
        TaskUtil.setResultOrApiException(status, Integer.valueOf(i3), this.zza);
    }
}
