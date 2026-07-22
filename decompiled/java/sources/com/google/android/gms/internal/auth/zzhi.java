package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
abstract class zzhi {
    final Unsafe zza;

    zzhi(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j3);

    public abstract float zzb(Object obj, long j3);

    public abstract void zzc(Object obj, long j3, boolean z3);

    public abstract void zzd(Object obj, long j3, double d3);

    public abstract void zze(Object obj, long j3, float f3);

    public abstract boolean zzf(Object obj, long j3);
}
