package com.google.android.gms.internal.play_billing;

import java.util.Set;
import java.util.logging.Level;

/* loaded from: /root/release/classes.dex */
public final class zzch implements zzca {
    private final String zza;
    private final zzbd zzb;
    private final Level zzc;
    private final Set zzd;
    private final zzbq zze;

    private zzch() {
        zzbe zzbeVar = zzbe.DEFAULT;
        throw null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    /* synthetic */ zzch(com.google.android.gms.internal.play_billing.zzcg r9) {
        /*
            r8 = this;
            com.google.android.gms.internal.play_billing.zzbe r3 = com.google.android.gms.internal.play_billing.zzbe.NO_OP
            java.util.logging.Level r4 = java.util.logging.Level.ALL
            java.util.Set r6 = com.google.android.gms.internal.play_billing.zzck.zzd()
            com.google.android.gms.internal.play_billing.zzbq r7 = com.google.android.gms.internal.play_billing.zzck.zzb()
            java.lang.String r1 = ""
            r2 = 1
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzch.<init>(com.google.android.gms.internal.play_billing.zzcg):void");
    }

    private zzch(String str, boolean z3, zzbd zzbdVar, Level level, boolean z4, Set set, zzbq zzbqVar) {
        this.zza = "";
        this.zzb = zzbdVar;
        this.zzc = level;
        this.zzd = set;
        this.zze = zzbqVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    public final zzbf zza(String str) {
        return new zzck(this.zza, str, true, this.zzb, this.zzc, this.zzd, this.zze, null);
    }

    public final zzch zzb(boolean z3) {
        Set set = this.zzd;
        zzbq zzbqVar = this.zze;
        return new zzch(this.zza, true, this.zzb, Level.OFF, false, set, zzbqVar);
    }
}
