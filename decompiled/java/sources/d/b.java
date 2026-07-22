package d;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /root/release/classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: c, reason: collision with root package name */
    c<K, V> f2431c;

    /* renamed from: d, reason: collision with root package name */
    private c<K, V> f2432d;

    /* renamed from: f, reason: collision with root package name */
    private final WeakHashMap<f<K, V>, Boolean> f2433f = new WeakHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private int f2434g = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f2438g;
        }

        @Override // d.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2437f;
        }
    }

    /* renamed from: d.b$b, reason: collision with other inner class name */
    private static class C0070b<K, V> extends e<K, V> {
        C0070b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // d.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f2437f;
        }

        @Override // d.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2438g;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: c, reason: collision with root package name */
        final K f2435c;

        /* renamed from: d, reason: collision with root package name */
        final V f2436d;

        /* renamed from: f, reason: collision with root package name */
        c<K, V> f2437f;

        /* renamed from: g, reason: collision with root package name */
        c<K, V> f2438g;

        c(K k3, V v3) {
            this.f2435c = k3;
            this.f2436d = v3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f2435c.equals(cVar.f2435c) && this.f2436d.equals(cVar.f2436d);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2435c;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2436d;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2435c.hashCode() ^ this.f2436d.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2435c + "=" + this.f2436d;
        }
    }

    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        private c<K, V> f2439c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2440d = true;

        d() {
        }

        @Override // d.b.f
        void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f2439c;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2438g;
                this.f2439c = cVar3;
                this.f2440d = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f2440d) {
                this.f2440d = false;
                cVar = b.this.f2431c;
            } else {
                c<K, V> cVar2 = this.f2439c;
                cVar = cVar2 != null ? cVar2.f2437f : null;
            }
            this.f2439c = cVar;
            return this.f2439c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2440d) {
                return b.this.f2431c != null;
            }
            c<K, V> cVar = this.f2439c;
            return (cVar == null || cVar.f2437f == null) ? false : true;
        }
    }

    private static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        c<K, V> f2442c;

        /* renamed from: d, reason: collision with root package name */
        c<K, V> f2443d;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2442c = cVar2;
            this.f2443d = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f2443d;
            c<K, V> cVar2 = this.f2442c;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // d.b.f
        public void a(c<K, V> cVar) {
            if (this.f2442c == cVar && cVar == this.f2443d) {
                this.f2443d = null;
                this.f2442c = null;
            }
            c<K, V> cVar2 = this.f2442c;
            if (cVar2 == cVar) {
                this.f2442c = b(cVar2);
            }
            if (this.f2443d == cVar) {
                this.f2443d = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2443d;
            this.f2443d = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2443d != null;
        }
    }

    public static abstract class f<K, V> {
        abstract void a(c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f2431c;
    }

    protected c<K, V> b(K k3) {
        c<K, V> cVar = this.f2431c;
        while (cVar != null && !cVar.f2435c.equals(k3)) {
            cVar = cVar.f2437f;
        }
        return cVar;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f2433f.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f2432d;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0070b c0070b = new C0070b(this.f2432d, this.f2431c);
        this.f2433f.put(c0070b, Boolean.FALSE);
        return c0070b;
    }

    c<K, V> e(K k3, V v3) {
        c<K, V> cVar = new c<>(k3, v3);
        this.f2434g++;
        c<K, V> cVar2 = this.f2432d;
        if (cVar2 == null) {
            this.f2431c = cVar;
        } else {
            cVar2.f2437f = cVar;
            cVar.f2438g = cVar2;
        }
        this.f2432d = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public V f(K k3, V v3) {
        c<K, V> b4 = b(k3);
        if (b4 != null) {
            return b4.f2436d;
        }
        e(k3, v3);
        return null;
    }

    public V g(K k3) {
        c<K, V> b4 = b(k3);
        if (b4 == null) {
            return null;
        }
        this.f2434g--;
        if (!this.f2433f.isEmpty()) {
            Iterator<f<K, V>> it = this.f2433f.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(b4);
            }
        }
        c<K, V> cVar = b4.f2438g;
        c<K, V> cVar2 = b4.f2437f;
        if (cVar != null) {
            cVar.f2437f = cVar2;
        } else {
            this.f2431c = cVar2;
        }
        c<K, V> cVar3 = b4.f2437f;
        if (cVar3 != null) {
            cVar3.f2438g = cVar;
        } else {
            this.f2432d = cVar;
        }
        b4.f2437f = null;
        b4.f2438g = null;
        return b4.f2436d;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().hashCode();
        }
        return i3;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f2431c, this.f2432d);
        this.f2433f.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f2434g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
