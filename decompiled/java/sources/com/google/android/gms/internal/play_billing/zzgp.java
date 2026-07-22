package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
final class zzgp extends zzgz {
    zzgp(int i3) {
        super(i3, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgz
    public final void zza() {
        if (!zzj()) {
            for (int i3 = 0; i3 < zzb(); i3++) {
                Map.Entry zzg = zzg(i3);
                if (((zzen) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzen) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
