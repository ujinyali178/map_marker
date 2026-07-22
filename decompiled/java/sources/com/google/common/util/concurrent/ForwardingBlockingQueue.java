package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    protected ForwardingBlockingQueue() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingQueue<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return delegate().drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i3) {
        return delegate().drainTo(collection, i3);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e3, long j3, TimeUnit timeUnit) {
        return delegate().offer(e3, j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    @CheckForNull
    public E poll(long j3, TimeUnit timeUnit) {
        return delegate().poll(j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e3) {
        delegate().put(e3);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() {
        return delegate().take();
    }
}
