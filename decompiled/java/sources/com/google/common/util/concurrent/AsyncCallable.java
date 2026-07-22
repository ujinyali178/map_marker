package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call();
}
