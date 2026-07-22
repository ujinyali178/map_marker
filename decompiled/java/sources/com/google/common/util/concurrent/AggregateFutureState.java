package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        abstract int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState);
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> seenExceptionsUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            androidx.concurrent.futures.b.a(this.seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (((AggregateFutureState) aggregateFutureState).seenExceptions == set) {
                    ((AggregateFutureState) aggregateFutureState).seenExceptions = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            int access$306;
            synchronized (aggregateFutureState) {
                access$306 = AggregateFutureState.access$306(aggregateFutureState);
            }
            return access$306;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AtomicHelper atomicHelper;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Error | RuntimeException e3) {
            SynchronizedAtomicHelper synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            th = e3;
            atomicHelper = synchronizedAtomicHelper;
        }
        ATOMIC_HELPER = atomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    AggregateFutureState(int i3) {
        this.remaining = i3;
    }

    static /* synthetic */ int access$306(AggregateFutureState aggregateFutureState) {
        int i3 = aggregateFutureState.remaining - 1;
        aggregateFutureState.remaining = i3;
        return i3;
    }

    abstract void addInitialException(Set<Throwable> set);

    final void clearSeenExceptions() {
        this.seenExceptions = null;
    }

    final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> newConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(newConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, newConcurrentHashSet);
        Set<Throwable> set2 = this.seenExceptions;
        Objects.requireNonNull(set2);
        return set2;
    }
}
