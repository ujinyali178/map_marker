package com.google.android.gms.internal.play_billing;

import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: /root/release/classes.dex */
final class zzci extends zzby {
    private final zzbd zza;
    private final Level zzb;
    private final Set zzc;
    private final zzbq zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzci(String str, @NullableDecl String str2, boolean z3, zzbd zzbdVar, boolean z4, boolean z5) {
        super(str2);
        Set set;
        zzbq zzbqVar;
        Level level = Level.ALL;
        set = zzck.zza;
        zzbqVar = zzck.zzb;
        this.zza = zzbdVar;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzbqVar;
    }
}
