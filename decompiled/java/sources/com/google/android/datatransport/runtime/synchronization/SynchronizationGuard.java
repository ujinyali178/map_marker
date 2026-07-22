package com.google.android.datatransport.runtime.synchronization;

/* loaded from: /root/release/classes.dex */
public interface SynchronizationGuard {

    public interface CriticalSection<T> {
        T execute();
    }

    <T> T runCriticalSection(CriticalSection<T> criticalSection);
}
