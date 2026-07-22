package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    private static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        private CompactStriped(int i3, Supplier<L> supplier) {
            super(i3);
            int i4 = 0;
            Preconditions.checkArgument(i3 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
            while (true) {
                Object[] objArr = this.array;
                if (i4 >= objArr.length) {
                    return;
                }
                objArr[i4] = supplier.get();
                i4++;
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i3) {
            return (L) this.array[i3];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }
    }

    static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        LargeLazyStriped(int i3, Supplier<L> supplier) {
            super(i3);
            int i4 = this.mask;
            this.size = i4 == -1 ? Integer.MAX_VALUE : i4 + 1;
            this.supplier = supplier;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i3) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i3, size());
            }
            L l3 = this.locks.get(Integer.valueOf(i3));
            if (l3 != null) {
                return l3;
            }
            L l4 = this.supplier.get();
            return (L) MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i3), l4), l4);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        PaddedLock() {
            super(false);
        }
    }

    private static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        PaddedSemaphore(int i3) {
            super(i3, false);
        }
    }

    private static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        PowerOfTwoStriped(int i3) {
            super();
            Preconditions.checkArgument(i3 > 0, "Stripes must be positive");
            this.mask = i3 > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i3) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final Supplier<L> supplier;

        private static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            ArrayReference(L l3, int i3, ReferenceQueue<L> referenceQueue) {
                super(l3, referenceQueue);
                this.index = i3;
            }
        }

        SmallLazyStriped(int i3, Supplier<L> supplier) {
            super(i3);
            this.queue = new ReferenceQueue<>();
            int i4 = this.mask;
            int i5 = i4 == -1 ? Integer.MAX_VALUE : i4 + 1;
            this.size = i5;
            this.locks = new AtomicReferenceArray<>(i5);
            this.supplier = supplier;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                ArrayReference arrayReference = (ArrayReference) poll;
                g0.a(this.locks, arrayReference.index, arrayReference, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i3) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i3, size());
            }
            ArrayReference<? extends L> arrayReference = this.locks.get(i3);
            L l3 = arrayReference == null ? null : arrayReference.get();
            if (l3 != null) {
                return l3;
            }
            L l4 = this.supplier.get();
            ArrayReference arrayReference2 = new ArrayReference(l4, i3, this.queue);
            while (!g0.a(this.locks, i3, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i3);
                L l5 = arrayReference == null ? null : arrayReference.get();
                if (l5 != null) {
                    return l5;
                }
            }
            drainQueue();
            return l4;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    private static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        Condition delegate() {
            return this.delegate;
        }
    }

    private static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        Lock delegate() {
            return this.delegate;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        WeakSafeReadWriteLock() {
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    private Striped() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i3) {
        return 1 << IntMath.log2(i3, RoundingMode.CEILING);
    }

    static <L> Striped<L> custom(int i3, Supplier<L> supplier) {
        return new CompactStriped(i3, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$lazyWeakSemaphore$2(int i3) {
        return new Semaphore(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$semaphore$1(int i3) {
        return new PaddedSemaphore(i3);
    }

    private static <L> Striped<L> lazy(int i3, Supplier<L> supplier) {
        return i3 < 1024 ? new SmallLazyStriped(i3, supplier) : new LargeLazyStriped(i3, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i3) {
        return lazy(i3, new Supplier() { // from class: com.google.common.util.concurrent.e0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Lock lambda$lazyWeakLock$0;
                lambda$lazyWeakLock$0 = Striped.lambda$lazyWeakLock$0();
                return lambda$lazyWeakLock$0;
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i3) {
        return lazy(i3, new Supplier() { // from class: com.google.common.util.concurrent.c0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Striped.WeakSafeReadWriteLock();
            }
        });
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i3, final int i4) {
        return lazy(i3, new Supplier() { // from class: com.google.common.util.concurrent.b0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Semaphore lambda$lazyWeakSemaphore$2;
                lambda$lazyWeakSemaphore$2 = Striped.lambda$lazyWeakSemaphore$2(i4);
                return lambda$lazyWeakSemaphore$2;
            }
        });
    }

    public static Striped<Lock> lock(int i3) {
        return custom(i3, new Supplier() { // from class: com.google.common.util.concurrent.f0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Striped.PaddedLock();
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int i3) {
        return custom(i3, new Supplier() { // from class: com.google.common.util.concurrent.d0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new ReentrantReadWriteLock();
            }
        });
    }

    public static Striped<Semaphore> semaphore(int i3, final int i4) {
        return custom(i3, new Supplier() { // from class: com.google.common.util.concurrent.a0
            @Override // com.google.common.base.Supplier
            public final Object get() {
                Semaphore lambda$semaphore$1;
                lambda$semaphore$1 = Striped.lambda$semaphore$1(i4);
                return lambda$semaphore$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int smear(int i3) {
        int i4 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
        return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList newArrayList = Lists.newArrayList(iterable);
        if (newArrayList.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[newArrayList.size()];
        for (int i3 = 0; i3 < newArrayList.size(); i3++) {
            iArr[i3] = indexFor(newArrayList.get(i3));
        }
        Arrays.sort(iArr);
        int i4 = iArr[0];
        newArrayList.set(0, getAt(i4));
        for (int i5 = 1; i5 < newArrayList.size(); i5++) {
            int i6 = iArr[i5];
            if (i6 == i4) {
                newArrayList.set(i5, newArrayList.get(i5 - 1));
            } else {
                newArrayList.set(i5, getAt(i6));
                i4 = i6;
            }
        }
        return Collections.unmodifiableList(newArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i3);

    abstract int indexFor(Object obj);

    public abstract int size();
}
