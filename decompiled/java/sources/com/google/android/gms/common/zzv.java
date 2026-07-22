package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: /root/release/classes.dex */
final class zzv extends zzx {
    private final Callable zze;

    /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super();
        this.zze = callable;
    }

    @Override // com.google.android.gms.common.zzx
    final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }
}
