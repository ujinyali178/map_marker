package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @CheckForNull
    private T nextOrNull;

    protected AbstractSequentialIterator(@CheckForNull T t3) {
        this.nextOrNull = t3;
    }

    @CheckForNull
    protected abstract T computeNext(T t3);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t3 = this.nextOrNull;
        if (t3 == null) {
            throw new NoSuchElementException();
        }
        this.nextOrNull = computeNext(t3);
        return t3;
    }
}
