package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: /root/release/classes.dex */
abstract class zaav implements Runnable {
    final /* synthetic */ zaaw zab;

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        zabi zabiVar;
        lock = this.zab.zab;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    zaa();
                }
            } catch (RuntimeException e3) {
                zabiVar = this.zab.zaa;
                zabiVar.zam(e3);
            }
        } finally {
            lock2 = this.zab.zab;
            lock2.unlock();
        }
    }

    protected abstract void zaa();
}
