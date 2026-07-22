package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class RateLimiter {

    @CheckForNull
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    static abstract class SleepingStopwatch {
        protected SleepingStopwatch() {
        }

        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() { // from class: com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1
                final Stopwatch stopwatch = Stopwatch.createStarted();

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                protected long readMicros() {
                    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                protected void sleepMicrosUninterruptibly(long j3) {
                    if (j3 > 0) {
                        Uninterruptibles.sleepUninterruptibly(j3, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        protected abstract long readMicros();

        protected abstract void sleepMicrosUninterruptibly(long j3);
    }

    RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(sleepingStopwatch);
    }

    private boolean canAcquire(long j3, long j4) {
        return queryEarliestAvailable(j3) - j4 <= j3;
    }

    private static void checkPermits(int i3) {
        Preconditions.checkArgument(i3 > 0, "Requested permits (%s) must be positive", i3);
    }

    public static RateLimiter create(double d3) {
        return create(d3, SleepingStopwatch.createFromSystemTimer());
    }

    public static RateLimiter create(double d3, long j3, TimeUnit timeUnit) {
        Preconditions.checkArgument(j3 >= 0, "warmupPeriod must not be negative: %s", j3);
        return create(d3, j3, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
    }

    static RateLimiter create(double d3, long j3, TimeUnit timeUnit, double d4, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j3, timeUnit, d4);
        smoothWarmingUp.setRate(d3);
        return smoothWarmingUp;
    }

    static RateLimiter create(double d3, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d3);
        return smoothBursty;
    }

    private Object mutex() {
        Object obj = this.mutexDoNotUseDirectly;
        if (obj == null) {
            synchronized (this) {
                obj = this.mutexDoNotUseDirectly;
                if (obj == null) {
                    obj = new Object();
                    this.mutexDoNotUseDirectly = obj;
                }
            }
        }
        return obj;
    }

    public double acquire() {
        return acquire(1);
    }

    public double acquire(int i3) {
        long reserve = reserve(i3);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        return (reserve * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    abstract double doGetRate();

    abstract void doSetRate(double d3, long j3);

    public final double getRate() {
        double doGetRate;
        synchronized (mutex()) {
            doGetRate = doGetRate();
        }
        return doGetRate;
    }

    abstract long queryEarliestAvailable(long j3);

    final long reserve(int i3) {
        long reserveAndGetWaitLength;
        checkPermits(i3);
        synchronized (mutex()) {
            reserveAndGetWaitLength = reserveAndGetWaitLength(i3, this.stopwatch.readMicros());
        }
        return reserveAndGetWaitLength;
    }

    final long reserveAndGetWaitLength(int i3, long j3) {
        return Math.max(reserveEarliestAvailable(i3, j3) - j3, 0L);
    }

    abstract long reserveEarliestAvailable(int i3, long j3);

    public final void setRate(double d3) {
        Preconditions.checkArgument(d3 > 0.0d && !Double.isNaN(d3), "rate must be positive");
        synchronized (mutex()) {
            doSetRate(d3, this.stopwatch.readMicros());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(getRate()));
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i3) {
        return tryAcquire(i3, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i3, long j3, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j3), 0L);
        checkPermits(i3);
        synchronized (mutex()) {
            long readMicros = this.stopwatch.readMicros();
            if (!canAcquire(readMicros, max)) {
                return false;
            }
            this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength(i3, readMicros));
            return true;
        }
    }

    public boolean tryAcquire(long j3, TimeUnit timeUnit) {
        return tryAcquire(1, j3, timeUnit);
    }
}
