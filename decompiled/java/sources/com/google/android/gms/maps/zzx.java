package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: /root/release/classes.dex */
final class zzx extends com.google.android.gms.maps.internal.zzq {
    final /* synthetic */ GoogleMap.OnCameraMoveCanceledListener zza;

    zzx(GoogleMap googleMap, GoogleMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.zza = onCameraMoveCanceledListener;
    }

    @Override // com.google.android.gms.maps.internal.zzr
    public final void zzb() {
        this.zza.onCameraMoveCanceled();
    }
}
