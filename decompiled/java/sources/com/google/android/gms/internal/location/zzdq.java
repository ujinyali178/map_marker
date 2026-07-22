package com.google.android.gms.internal.location;

/* loaded from: /root/release/classes.dex */
final class zzdq extends zzdo {
    private final zzds zza;

    zzdq(zzds zzdsVar, int i3) {
        super(zzdsVar.size(), i3);
        this.zza = zzdsVar;
    }

    @Override // com.google.android.gms.internal.location.zzdo
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
