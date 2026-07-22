package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /root/release/classes.dex */
public class TestClock implements Clock {
    private final AtomicLong timestamp;

    public TestClock(long j3) {
        this.timestamp = new AtomicLong(j3);
    }

    public void advance(long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("cannot advance time backwards.");
        }
        this.timestamp.addAndGet(j3);
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        advance(1L);
    }
}
