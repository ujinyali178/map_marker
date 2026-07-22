package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: /root/release/classes.dex */
final class zzt implements Executor {
    zzt() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
