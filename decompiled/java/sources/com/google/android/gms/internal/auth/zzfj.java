package com.google.android.gms.internal.auth;

/* loaded from: /root/release/classes.dex */
final class zzfj extends zzfl {
    private zzfj() {
        super(null);
    }

    /* synthetic */ zzfj(zzfi zzfiVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zza(Object obj, long j3) {
        ((zzez) zzhj.zzf(obj, j3)).zzb();
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zzb(Object obj, Object obj2, long j3) {
        zzez zzezVar = (zzez) zzhj.zzf(obj, j3);
        zzez zzezVar2 = (zzez) zzhj.zzf(obj2, j3);
        int size = zzezVar.size();
        int size2 = zzezVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzezVar.zzc()) {
                zzezVar = zzezVar.zzd(size2 + size);
            }
            zzezVar.addAll(zzezVar2);
        }
        if (size > 0) {
            zzezVar2 = zzezVar;
        }
        zzhj.zzp(obj, j3, zzezVar2);
    }
}
