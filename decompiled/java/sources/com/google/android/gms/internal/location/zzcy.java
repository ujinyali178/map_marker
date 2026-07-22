package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* loaded from: /root/release/classes.dex */
final class zzcy implements ListenerHolder.Notifier {
    final /* synthetic */ zzcz zza;

    zzcy(zzcz zzczVar) {
        this.zza = zzczVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzcs zzcsVar;
        zzcsVar = this.zza.zza;
        zzcsVar.zzb();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
