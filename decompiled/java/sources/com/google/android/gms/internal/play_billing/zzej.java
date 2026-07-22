package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class zzej {
    static final zzej zza = new zzej(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzej zzd;
    private final Map zze;

    zzej() {
        this.zze = new HashMap();
    }

    zzej(boolean z3) {
        this.zze = Collections.emptyMap();
    }

    public static zzej zza() {
        zzej zzejVar = zzd;
        if (zzejVar != null) {
            return zzejVar;
        }
        synchronized (zzej.class) {
            zzej zzejVar2 = zzd;
            if (zzejVar2 != null) {
                return zzejVar2;
            }
            zzej zzb2 = zzer.zzb(zzej.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzev zzb(zzgc zzgcVar, int i3) {
        return (zzev) this.zze.get(new zzei(zzgcVar, i3));
    }
}
