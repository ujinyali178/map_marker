package w2;

/* loaded from: /root/release/classes2.dex */
final class i1 extends i {

    /* renamed from: c, reason: collision with root package name */
    private final p2.l<Throwable, g2.q> f4473c;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(p2.l<? super Throwable, g2.q> lVar) {
        this.f4473c = lVar;
    }

    @Override // w2.j
    public void a(Throwable th) {
        this.f4473c.invoke(th);
    }

    @Override // p2.l
    public /* bridge */ /* synthetic */ g2.q invoke(Throwable th) {
        a(th);
        return g2.q.f2555a;
    }

    public String toString() {
        return "InvokeOnCancel[" + k0.a(this.f4473c) + '@' + k0.b(this) + ']';
    }
}
