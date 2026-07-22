package com.google.common.base;

import java.lang.ref.SoftReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    protected FinalizableSoftReference(@CheckForNull T t3, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t3, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
