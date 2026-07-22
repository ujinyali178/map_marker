package com.google.common.base;

import java.lang.ref.PhantomReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    protected FinalizablePhantomReference(@CheckForNull T t3, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t3, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
