package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /root/release/classes.dex */
final class a<T> implements Iterator<T> {

    /* renamed from: c, reason: collision with root package name */
    private final T[] f3754c;

    /* renamed from: d, reason: collision with root package name */
    private int f3755d;

    public a(T[] array) {
        k.e(array, "array");
        this.f3754c = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3755d < this.f3754c.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f3754c;
            int i3 = this.f3755d;
            this.f3755d = i3 + 1;
            return tArr[i3];
        } catch (ArrayIndexOutOfBoundsException e3) {
            this.f3755d--;
            throw new NoSuchElementException(e3.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
