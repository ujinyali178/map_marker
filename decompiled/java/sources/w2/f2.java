package w2;

import i2.g;

/* loaded from: /root/release/classes2.dex */
final class f2 implements g.b, g.c<f2> {

    /* renamed from: c, reason: collision with root package name */
    public static final f2 f4463c = new f2();

    private f2() {
    }

    @Override // i2.g.b, i2.g
    public <E extends g.b> E a(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // i2.g
    public i2.g f(i2.g gVar) {
        return g.b.a.d(this, gVar);
    }

    @Override // i2.g.b
    public g.c<?> getKey() {
        return this;
    }

    @Override // i2.g
    public i2.g k(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // i2.g
    public <R> R x(R r3, p2.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r3, pVar);
    }
}
