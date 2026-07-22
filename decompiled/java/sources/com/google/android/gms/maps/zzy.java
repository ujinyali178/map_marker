package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: /root/release/classes.dex */
final class zzy extends com.google.android.gms.maps.internal.zzo {
    final /* synthetic */ GoogleMap.OnCameraIdleListener zza;

    zzy(GoogleMap googleMap, GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.zza = onCameraIdleListener;
    }

    @Override // com.google.android.gms.maps.internal.zzp
    public final void zzb() {
        this.zza.onCameraIdle();
    }
}
