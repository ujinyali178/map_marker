package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzbs;

/* loaded from: /root/release/classes.dex */
final class zzax extends zzbs {
    final /* synthetic */ OnStreetViewPanoramaReadyCallback zza;

    zzax(zzay zzayVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.zza = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzbt
    public final void zzb(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.zza.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
