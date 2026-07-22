package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: k, reason: collision with root package name */
    f<K, V> f382k;

    /* renamed from: androidx.collection.a$a, reason: collision with other inner class name */
    class C0006a extends f<K, V> {
        C0006a() {
        }

        @Override // androidx.collection.f
        protected void a() {
            a.this.clear();
        }

        @Override // androidx.collection.f
        protected Object b(int i3, int i4) {
            return a.this.f423d[(i3 << 1) + i4];
        }

        @Override // androidx.collection.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // androidx.collection.f
        protected int d() {
            return a.this.f424f;
        }

        @Override // androidx.collection.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // androidx.collection.f
        protected int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // androidx.collection.f
        protected void g(K k3, V v3) {
            a.this.put(k3, v3);
        }

        @Override // androidx.collection.f
        protected void h(int i3) {
            a.this.j(i3);
        }

        @Override // androidx.collection.f
        protected V i(int i3, V v3) {
            return a.this.k(i3, v3);
        }
    }

    public a() {
    }

    public a(int i3) {
        super(i3);
    }

    private f<K, V> m() {
        if (this.f382k == null) {
            this.f382k = new C0006a();
        }
        return this.f382k;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    public boolean n(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.f424f + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
