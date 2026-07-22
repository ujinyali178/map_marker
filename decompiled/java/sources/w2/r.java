package w2;

/* loaded from: /root/release/classes2.dex */
public final class r extends n1 implements q {

    /* renamed from: h, reason: collision with root package name */
    public final s f4496h;

    public r(s sVar) {
        this.f4496h = sVar;
    }

    @Override // w2.q
    public boolean d(Throwable th) {
        return y().I(th);
    }

    @Override // w2.q
    public l1 getParent() {
        return y();
    }

    @Override // p2.l
    public /* bridge */ /* synthetic */ g2.q invoke(Throwable th) {
        x(th);
        return g2.q.f2555a;
    }

    @Override // w2.x
    public void x(Throwable th) {
        this.f4496h.v(y());
    }
}
