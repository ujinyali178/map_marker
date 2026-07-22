package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    protected ForwardingQueue() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    @ParametricNullness
    public E element() {
        return delegate().element();
    }

    public boolean offer(@ParametricNullness E e3) {
        return delegate().offer(e3);
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CheckForNull
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @ParametricNullness
    public E remove() {
        return delegate().remove();
    }

    protected boolean standardOffer(@ParametricNullness E e3) {
        try {
            return add(e3);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @CheckForNull
    protected E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @CheckForNull
    protected E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
