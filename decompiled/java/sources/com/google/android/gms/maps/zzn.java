package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;

/* loaded from: /root/release/classes.dex */
final class zzn extends com.google.android.gms.maps.internal.zzw {
    final /* synthetic */ GoogleMap.OnCircleClickListener zza;

    zzn(GoogleMap googleMap, GoogleMap.OnCircleClickListener onCircleClickListener) {
        this.zza = onCircleClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzx
    public final void zzb(com.google.android.gms.internal.maps.zzl zzlVar) {
        this.zza.onCircleClick(new Circle(zzlVar));
    }
}
