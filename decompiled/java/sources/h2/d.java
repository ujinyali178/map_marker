package h2;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class d<T> implements Collection<T> {

    /* renamed from: c, reason: collision with root package name */
    private final T[] f2623c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2624d;

    public d(T[] values, boolean z3) {
        kotlin.jvm.internal.k.e(values, "values");
        this.f2623c = values;
        this.f2624d = z3;
    }

    public int a() {
        return this.f2623c.length;
    }

    @Override // java.util.Collection
    public boolean add(T t3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return j.h(this.f2623c, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.k.e(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f2623c.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.b.a(this.f2623c);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return m.a(this.f2623c, this.f2624d);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        return (T[]) kotlin.jvm.internal.f.b(this, array);
    }
}
