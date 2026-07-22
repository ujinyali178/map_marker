package com.google.android.gms.internal.play_billing;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class zzbl {
    private static final zzbp zza = new zzbi();
    private static final zzbo zzb = new zzbj();
    private final zzbp zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzbo zzf = null;

    public final zzbl zza(zzbo zzboVar) {
        this.zzf = zzboVar;
        return this;
    }

    public final zzbq zzd() {
        return new zzbn(this, null);
    }

    final void zzg(zzba zzbaVar) {
        Object obj;
        Map map;
        zzda.zza(zzbaVar, "key");
        if (zzbaVar.zzb()) {
            obj = zzb;
            zzda.zza(zzbaVar, "key");
            if (!zzbaVar.zzb()) {
                throw new IllegalArgumentException("key must be repeating");
            }
            this.zzc.remove(zzbaVar);
            map = this.zzd;
        } else {
            obj = zza;
            zzda.zza(zzbaVar, "key");
            this.zzd.remove(zzbaVar);
            map = this.zzc;
        }
        map.put(zzbaVar, obj);
    }
}
