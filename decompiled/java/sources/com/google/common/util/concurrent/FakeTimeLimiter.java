package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class FakeTimeLimiter implements TimeLimiter {
    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit) {
        return (T) callWithTimeout(callable, j3, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (Error e3) {
            throw new ExecutionError(e3);
        } catch (RuntimeException e4) {
            throw new UncheckedExecutionException(e4);
        } catch (Exception e5) {
            Platform.restoreInterruptIfIsInterruptedException(e5);
            throw new ExecutionException(e5);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t3, Class<T> cls, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t3);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        return t3;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j3, TimeUnit timeUnit) {
        runWithTimeout(runnable, j3, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j3, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (Error e3) {
            throw new ExecutionError(e3);
        } catch (RuntimeException e4) {
            throw new UncheckedExecutionException(e4);
        }
    }
}
