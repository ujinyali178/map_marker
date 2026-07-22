package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@DoNotMock("Use FakeTimeLimiter")
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface TimeLimiter {
    @ParametricNullness
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit);

    @ParametricNullness
    <T> T callWithTimeout(Callable<T> callable, long j3, TimeUnit timeUnit);

    <T> T newProxy(T t3, Class<T> cls, long j3, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j3, TimeUnit timeUnit);

    void runWithTimeout(Runnable runnable, long j3, TimeUnit timeUnit);
}
