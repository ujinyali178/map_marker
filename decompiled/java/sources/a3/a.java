package a3;

import i2.g;
import p2.p;

/* loaded from: /root/release/classes2.dex */
public final class a implements g {

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f226c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ g f227d;

    public a(Throwable th, g gVar) {
        this.f226c = th;
        this.f227d = gVar;
    }

    @Override // i2.g
    public <E extends g.b> E a(g.c<E> cVar) {
        return (E) this.f227d.a(cVar);
    }

    @Override // i2.g
    public g f(g gVar) {
        return this.f227d.f(gVar);
    }

    @Override // i2.g
    public g k(g.c<?> cVar) {
        return this.f227d.k(cVar);
    }

    @Override // i2.g
    public <R> R x(R r3, p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) this.f227d.x(r3, pVar);
    }
}
