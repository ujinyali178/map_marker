package com.google.android.gms.internal.play_billing;

/* loaded from: /root/release/classes.dex */
final class zzfo extends zzfq {
    private zzfo() {
        super(null);
    }

    /* synthetic */ zzfo(zzfn zzfnVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfq
    final void zza(Object obj, long j3) {
        ((zzfc) zzhn.zzf(obj, j3)).zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfq
    final void zzb(Object obj, Object obj2, long j3) {
        zzfc zzfcVar = (zzfc) zzhn.zzf(obj, j3);
        zzfc zzfcVar2 = (zzfc) zzhn.zzf(obj2, j3);
        int size = zzfcVar.size();
        int size2 = zzfcVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzfcVar.zzc()) {
                zzfcVar = zzfcVar.zzd(size2 + size);
            }
            zzfcVar.addAll(zzfcVar2);
        }
        if (size > 0) {
            zzfcVar2 = zzfcVar;
        }
        zzhn.zzs(obj, j3, zzfcVar2);
    }
}
