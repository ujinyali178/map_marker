package com.google.common.base;

import java.lang.ref.WeakReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    protected FinalizableWeakReference(@CheckForNull T t3, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t3, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
