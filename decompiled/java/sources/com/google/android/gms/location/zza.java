package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: /root/release/classes.dex */
public final class zza {
    private long zza = Long.MIN_VALUE;

    public final zza zza(long j3) {
        Preconditions.checkArgument(j3 >= 0, "intervalMillis can't be negative.");
        this.zza = j3;
        return this;
    }

    public final zzb zzb() {
        Preconditions.checkState(this.zza != Long.MIN_VALUE, "Must set intervalMillis.");
        return new zzb(this.zza, true, null, null, null, false, null, 0L, null);
    }
}
