package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class zzbk implements Executor {
    public static final /* synthetic */ zzbk zza = new zzbk();

    private /* synthetic */ zzbk() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
