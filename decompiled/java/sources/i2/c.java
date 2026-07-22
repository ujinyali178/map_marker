package i2;

import i2.g;
import java.io.Serializable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import p2.p;

/* loaded from: /root/release/classes.dex */
public final class c implements g, Serializable {

    /* renamed from: c, reason: collision with root package name */
    private final g f2687c;

    /* renamed from: d, reason: collision with root package name */
    private final g.b f2688d;

    static final class a extends l implements p<String, g.b, String> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f2689c = new a();

        a() {
            super(2);
        }

        @Override // p2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String acc, g.b element) {
            k.e(acc, "acc");
            k.e(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(g left, g.b element) {
        k.e(left, "left");
        k.e(element, "element");
        this.f2687c = left;
        this.f2688d = element;
    }

    private final boolean b(g.b bVar) {
        return k.a(a(bVar.getKey()), bVar);
    }

    private final boolean e(c cVar) {
        while (b(cVar.f2688d)) {
            g gVar = cVar.f2687c;
            if (!(gVar instanceof c)) {
                k.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int g() {
        int i3 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f2687c;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i3;
            }
            i3++;
        }
    }

    @Override // i2.g
    public <E extends g.b> E a(g.c<E> key) {
        k.e(key, "key");
        c cVar = this;
        while (true) {
            E e3 = (E) cVar.f2688d.a(key);
            if (e3 != null) {
                return e3;
            }
            g gVar = cVar.f2687c;
            if (!(gVar instanceof c)) {
                return (E) gVar.a(key);
            }
            cVar = (c) gVar;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.g() != g() || !cVar.e(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // i2.g
    public g f(g gVar) {
        return g.a.a(this, gVar);
    }

    public int hashCode() {
        return this.f2687c.hashCode() + this.f2688d.hashCode();
    }

    @Override // i2.g
    public g k(g.c<?> key) {
        k.e(key, "key");
        if (this.f2688d.a(key) != null) {
            return this.f2687c;
        }
        g k3 = this.f2687c.k(key);
        return k3 == this.f2687c ? this : k3 == h.f2693c ? this.f2688d : new c(k3, this.f2688d);
    }

    public String toString() {
        return '[' + ((String) x("", a.f2689c)) + ']';
    }

    @Override // i2.g
    public <R> R x(R r3, p<? super R, ? super g.b, ? extends R> operation) {
        k.e(operation, "operation");
        return operation.invoke((Object) this.f2687c.x(r3, operation), this.f2688d);
    }
}
