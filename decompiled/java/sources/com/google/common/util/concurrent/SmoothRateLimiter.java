package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class SmoothRateLimiter extends RateLimiter {
    double maxPermits;
    private long nextFreeTicketMicros;
    double stableIntervalMicros;
    double storedPermits;

    static final class SmoothBursty extends SmoothRateLimiter {
        final double maxBurstSeconds;

        SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d3) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d3;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double d3, double d4) {
            double d5 = this.maxPermits;
            double d6 = this.maxBurstSeconds * d3;
            this.maxPermits = d6;
            if (d5 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d6;
            } else {
                this.storedPermits = d5 != 0.0d ? (this.storedPermits * d6) / d5 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double d3, double d4) {
            return 0L;
        }
    }

    static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j3, TimeUnit timeUnit, double d3) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j3);
            this.coldFactor = d3;
        }

        private double permitsToTime(double d3) {
            return this.stableIntervalMicros + (d3 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        void doSetRate(double d3, double d4) {
            double d5 = this.maxPermits;
            double d6 = this.coldFactor * d4;
            long j3 = this.warmupPeriodMicros;
            double d7 = (j3 * 0.5d) / d4;
            this.thresholdPermits = d7;
            double d8 = ((j3 * 2.0d) / (d4 + d6)) + d7;
            this.maxPermits = d8;
            this.slope = (d6 - d4) / (d8 - d7);
            if (d5 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d5 != 0.0d) {
                d8 = (this.storedPermits * d8) / d5;
            }
            this.storedPermits = d8;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        long storedPermitsToWaitTime(double d3, double d4) {
            long j3;
            double d5 = d3 - this.thresholdPermits;
            if (d5 > 0.0d) {
                double min = Math.min(d5, d4);
                j3 = (long) (((permitsToTime(d5) + permitsToTime(d5 - min)) * min) / 2.0d);
                d4 -= min;
            } else {
                j3 = 0;
            }
            return j3 + ((long) (this.stableIntervalMicros * d4));
        }
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }

    abstract double coolDownIntervalMicros();

    @Override // com.google.common.util.concurrent.RateLimiter
    final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
    }

    abstract void doSetRate(double d3, double d4);

    @Override // com.google.common.util.concurrent.RateLimiter
    final void doSetRate(double d3, long j3) {
        resync(j3);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d3;
        this.stableIntervalMicros = micros;
        doSetRate(d3, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long queryEarliestAvailable(long j3) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    final long reserveEarliestAvailable(int i3, long j3) {
        resync(j3);
        long j4 = this.nextFreeTicketMicros;
        double d3 = i3;
        double min = Math.min(d3, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d3 - min) * this.stableIntervalMicros)));
        this.storedPermits -= min;
        return j4;
    }

    void resync(long j3) {
        if (j3 > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((j3 - r0) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = j3;
        }
    }

    abstract long storedPermitsToWaitTime(double d3, double d4);
}
