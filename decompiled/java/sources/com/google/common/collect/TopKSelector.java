package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* renamed from: k, reason: collision with root package name */
    private final int f2258k;

    @CheckForNull
    private T threshold;

    private TopKSelector(Comparator<? super T> comparator, int i3) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.f2258k = i3;
        Preconditions.checkArgument(i3 >= 0, "k (%s) must be >= 0", i3);
        Preconditions.checkArgument(i3 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i3);
        this.buffer = (T[]) new Object[IntMath.checkedMultiply(i3, 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i3) {
        return greatest(i3, Ordering.natural());
    }

    public static <T> TopKSelector<T> greatest(int i3, Comparator<? super T> comparator) {
        return new TopKSelector<>(Ordering.from(comparator).reverse(), i3);
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i3) {
        return least(i3, Ordering.natural());
    }

    public static <T> TopKSelector<T> least(int i3, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i3);
    }

    private int partition(int i3, int i4, int i5) {
        Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i5]);
        T[] tArr = this.buffer;
        tArr[i5] = tArr[i4];
        int i6 = i3;
        while (i3 < i4) {
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i3]), uncheckedCastNullableTToT) < 0) {
                swap(i6, i3);
                i6++;
            }
            i3++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i4] = tArr2[i6];
        tArr2[i6] = uncheckedCastNullableTToT;
        return i6;
    }

    private void swap(int i3, int i4) {
        T[] tArr = this.buffer;
        T t3 = tArr[i3];
        tArr[i3] = tArr[i4];
        tArr[i4] = t3;
    }

    private void trim() {
        int i3 = (this.f2258k * 2) - 1;
        int log2 = IntMath.log2(i3 + 0, RoundingMode.CEILING) * 3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int partition = partition(i4, i3, ((i4 + i3) + 1) >>> 1);
            int i7 = this.f2258k;
            if (partition <= i7) {
                if (partition >= i7) {
                    break;
                }
                i4 = Math.max(partition, i4 + 1);
                i6 = partition;
            } else {
                i3 = partition - 1;
            }
            i5++;
            if (i5 >= log2) {
                Arrays.sort(this.buffer, i4, i3 + 1, this.comparator);
                break;
            }
        }
        this.bufferSize = this.f2258k;
        this.threshold = (T) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i6]);
        while (true) {
            i6++;
            if (i6 >= this.f2258k) {
                return;
            }
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i6]), (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = this.buffer[i6];
            }
        }
    }

    public void offer(@ParametricNullness T t3) {
        int i3 = this.f2258k;
        if (i3 == 0) {
            return;
        }
        int i4 = this.bufferSize;
        if (i4 == 0) {
            this.buffer[0] = t3;
            this.threshold = t3;
            this.bufferSize = 1;
            return;
        }
        if (i4 < i3) {
            T[] tArr = this.buffer;
            this.bufferSize = i4 + 1;
            tArr[i4] = t3;
            if (this.comparator.compare(t3, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = t3;
                return;
            }
            return;
        }
        if (this.comparator.compare(t3, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) < 0) {
            T[] tArr2 = this.buffer;
            int i5 = this.bufferSize;
            int i6 = i5 + 1;
            this.bufferSize = i6;
            tArr2[i5] = t3;
            if (i6 == this.f2258k * 2) {
                trim();
            }
        }
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }

    public List<T> topK() {
        T[] tArr = this.buffer;
        Arrays.sort(tArr, 0, this.bufferSize, this.comparator);
        int i3 = this.bufferSize;
        int i4 = this.f2258k;
        if (i3 > i4) {
            T[] tArr2 = this.buffer;
            Arrays.fill(tArr2, i4, tArr2.length, (Object) null);
            int i5 = this.f2258k;
            this.bufferSize = i5;
            this.threshold = this.buffer[i5 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.bufferSize)));
    }
}
