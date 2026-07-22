package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class ForwardingCondition implements Condition {
    ForwardingCondition() {
    }

    @Override // java.util.concurrent.locks.Condition
    public void await() {
        delegate().await();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean await(long j3, TimeUnit timeUnit) {
        return delegate().await(j3, timeUnit);
    }

    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long j3) {
        return delegate().awaitNanos(j3);
    }

    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(Date date) {
        return delegate().awaitUntil(date);
    }

    abstract Condition delegate();

    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        delegate().signal();
    }

    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        delegate().signalAll();
    }
}
