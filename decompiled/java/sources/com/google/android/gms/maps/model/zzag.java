package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzao;

/* loaded from: /root/release/classes.dex */
final class zzag extends zzao {
    final /* synthetic */ TileProvider zza;

    zzag(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzap
    public final Tile zzb(int i3, int i4, int i5) {
        return this.zza.getTile(i3, i4, i5);
    }
}
