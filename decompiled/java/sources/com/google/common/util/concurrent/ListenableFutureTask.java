package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    ListenableFutureTask(Runnable runnable, @ParametricNullness V v3) {
        super(runnable, v3);
        this.executionList = new ExecutionList();
    }

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.executionList = new ExecutionList();
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable, @ParametricNullness V v3) {
        return new ListenableFutureTask<>(runnable, v3);
    }

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.add(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.execute();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @ParametricNullness
    public V get(long j3, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j3);
        return nanos <= 2147483647999999999L ? (V) super.get(j3, timeUnit) : (V) super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
