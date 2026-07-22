package com.google.android.gms.internal.play_billing;

import java.io.Closeable;

/* loaded from: /root/release/classes.dex */
public final class zzdc implements Closeable {
    private static final ThreadLocal zza = new zzdb();
    private int zzb = 0;

    public static int zza() {
        return ((zzdc) zza.get()).zzb;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i3 = this.zzb;
        if (i3 <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i3 - 1;
    }
}
