package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: /root/release/classes.dex */
final class zzh extends com.google.android.gms.maps.internal.zzay {
    final /* synthetic */ GoogleMap.OnMyLocationButtonClickListener zza;

    zzh(GoogleMap googleMap, GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.zza = onMyLocationButtonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaz
    public final boolean zzb() {
        return this.zza.onMyLocationButtonClick();
    }
}
