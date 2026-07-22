package c1;

import m1.a;

/* loaded from: /root/release/classes.dex */
public final class a implements m1.a, n1.a {

    /* renamed from: c, reason: collision with root package name */
    private final b f2070c;

    /* renamed from: d, reason: collision with root package name */
    private final c f2071d;

    public a() {
        b bVar = new b(null, null);
        this.f2070c = bVar;
        this.f2071d = new c(bVar);
    }

    @Override // m1.a
    public void b(a.b bVar) {
        this.f2070c.g(bVar.a());
        this.f2070c.f(null);
        this.f2071d.f(bVar.b());
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        this.f2070c.g(null);
        this.f2070c.f(null);
        this.f2071d.g();
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        this.f2070c.f(null);
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        this.f2070c.f(cVar.i());
    }
}
