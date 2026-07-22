package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledFuture;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface ListenableScheduledFuture<V> extends ScheduledFuture<V>, ListenableFuture<V> {
}
