package i2;

import i2.g;
import kotlin.jvm.internal.k;
import p2.p;

/* loaded from: /root/release/classes.dex */
public abstract class a implements g.b {

    /* renamed from: c, reason: collision with root package name */
    private final g.c<?> f2684c;

    public a(g.c<?> key) {
        k.e(key, "key");
        this.f2684c = key;
    }

    @Override // i2.g.b, i2.g
    public <E extends g.b> E a(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // i2.g
    public g f(g gVar) {
        return g.b.a.d(this, gVar);
    }

    @Override // i2.g.b
    public g.c<?> getKey() {
        return this.f2684c;
    }

    @Override // i2.g
    public g k(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // i2.g
    public <R> R x(R r3, p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r3, pVar);
    }
}
