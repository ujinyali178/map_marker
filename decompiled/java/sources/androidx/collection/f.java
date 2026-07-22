package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
abstract class f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    f<K, V>.b f403a;

    /* renamed from: b, reason: collision with root package name */
    f<K, V>.c f404b;

    /* renamed from: c, reason: collision with root package name */
    f<K, V>.e f405c;

    final class a<T> implements Iterator<T> {

        /* renamed from: c, reason: collision with root package name */
        final int f406c;

        /* renamed from: d, reason: collision with root package name */
        int f407d;

        /* renamed from: f, reason: collision with root package name */
        int f408f;

        /* renamed from: g, reason: collision with root package name */
        boolean f409g = false;

        a(int i3) {
            this.f406c = i3;
            this.f407d = f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f408f < this.f407d;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t3 = (T) f.this.b(this.f408f, this.f406c);
            this.f408f++;
            this.f409g = true;
            return t3;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f409g) {
                throw new IllegalStateException();
            }
            int i3 = this.f408f - 1;
            this.f408f = i3;
            this.f407d--;
            this.f409g = false;
            f.this.h(i3);
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d3 = f.this.d();
            for (Map.Entry<K, V> entry : collection) {
                f.this.g(entry.getKey(), entry.getValue());
            }
            return d3 != f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e3 = f.this.e(entry.getKey());
            if (e3 < 0) {
                return false;
            }
            return androidx.collection.c.c(f.this.b(e3, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i3 = 0;
            for (int d3 = f.this.d() - 1; d3 >= 0; d3--) {
                Object b4 = f.this.b(d3, 0);
                Object b5 = f.this.b(d3, 1);
                i3 += (b4 == null ? 0 : b4.hashCode()) ^ (b5 == null ? 0 : b5.hashCode());
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return f.j(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i3 = 0;
            for (int d3 = f.this.d() - 1; d3 >= 0; d3--) {
                Object b4 = f.this.b(d3, 0);
                i3 += b4 == null ? 0 : b4.hashCode();
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e3 = f.this.e(obj);
            if (e3 < 0) {
                return false;
            }
            f.this.h(e3);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return f.o(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return f.p(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 0);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: c, reason: collision with root package name */
        int f413c;

        /* renamed from: f, reason: collision with root package name */
        boolean f415f = false;

        /* renamed from: d, reason: collision with root package name */
        int f414d = -1;

        d() {
            this.f413c = f.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f414d++;
            this.f415f = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f415f) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return androidx.collection.c.c(entry.getKey(), f.this.b(this.f414d, 0)) && androidx.collection.c.c(entry.getValue(), f.this.b(this.f414d, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f415f) {
                return (K) f.this.b(this.f414d, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f415f) {
                return (V) f.this.b(this.f414d, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f414d < this.f413c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f415f) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b4 = f.this.b(this.f414d, 0);
            Object b5 = f.this.b(this.f414d, 1);
            return (b4 == null ? 0 : b4.hashCode()) ^ (b5 != null ? b5.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f415f) {
                throw new IllegalStateException();
            }
            f.this.h(this.f414d);
            this.f414d--;
            this.f413c--;
            this.f415f = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            if (this.f415f) {
                return (V) f.this.i(this.f414d, v3);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f3 = f.this.f(obj);
            if (f3 < 0) {
                return false;
            }
            f.this.h(f3);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d3 = f.this.d();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < d3) {
                if (collection.contains(f.this.b(i3, 1))) {
                    f.this.h(i3);
                    i3--;
                    d3--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d3 = f.this.d();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < d3) {
                if (!collection.contains(f.this.b(i3, 1))) {
                    f.this.h(i3);
                    i3--;
                    d3--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f.this.r(tArr, 1);
        }
    }

    f() {
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i3, int i4);

    protected abstract Map<K, V> c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(K k3, V v3);

    protected abstract void h(int i3);

    protected abstract V i(int i3, V v3);

    public Set<Map.Entry<K, V>> l() {
        if (this.f403a == null) {
            this.f403a = new b();
        }
        return this.f403a;
    }

    public Set<K> m() {
        if (this.f404b == null) {
            this.f404b = new c();
        }
        return this.f404b;
    }

    public Collection<V> n() {
        if (this.f405c == null) {
            this.f405c = new e();
        }
        return this.f405c;
    }

    public Object[] q(int i3) {
        int d3 = d();
        Object[] objArr = new Object[d3];
        for (int i4 = 0; i4 < d3; i4++) {
            objArr[i4] = b(i4, i3);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i3) {
        int d3 = d();
        if (tArr.length < d3) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d3));
        }
        for (int i4 = 0; i4 < d3; i4++) {
            tArr[i4] = b(i4, i3);
        }
        if (tArr.length > d3) {
            tArr[d3] = null;
        }
        return tArr;
    }
}
