package d;

import d.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<K, b.c<K, V>> f2430h = new HashMap<>();

    @Override // d.b
    protected b.c<K, V> b(K k3) {
        return this.f2430h.get(k3);
    }

    public boolean contains(K k3) {
        return this.f2430h.containsKey(k3);
    }

    @Override // d.b
    public V f(K k3, V v3) {
        b.c<K, V> b4 = b(k3);
        if (b4 != null) {
            return b4.f2436d;
        }
        this.f2430h.put(k3, e(k3, v3));
        return null;
    }

    @Override // d.b
    public V g(K k3) {
        V v3 = (V) super.g(k3);
        this.f2430h.remove(k3);
        return v3;
    }

    public Map.Entry<K, V> h(K k3) {
        if (contains(k3)) {
            return this.f2430h.get(k3).f2438g;
        }
        return null;
    }
}
