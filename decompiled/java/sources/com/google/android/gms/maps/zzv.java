package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: /root/release/classes.dex */
final class zzv extends com.google.android.gms.maps.internal.zzu {
    final /* synthetic */ GoogleMap.OnCameraMoveStartedListener zza;

    zzv(GoogleMap googleMap, GoogleMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.zza = onCameraMoveStartedListener;
    }

    @Override // com.google.android.gms.maps.internal.zzv
    public final void zzb(int i3) {
        this.zza.onCameraMoveStarted(i3);
    }
}
