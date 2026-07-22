package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@ParametricNullness I i3);
}
