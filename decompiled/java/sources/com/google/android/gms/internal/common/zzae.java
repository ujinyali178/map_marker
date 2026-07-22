package com.google.android.gms.internal.common;

/* loaded from: /root/release/classes.dex */
final class zzae extends zzz {
    private final zzag zza;

    zzae(zzag zzagVar, int i3) {
        super(zzagVar.size(), i3);
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
