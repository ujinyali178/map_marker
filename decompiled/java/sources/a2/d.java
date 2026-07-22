package a2;

import a2.e;
import android.content.Context;
import m1.a;

/* loaded from: /root/release/classes.dex */
public class d implements m1.a, n1.a {

    /* renamed from: c, reason: collision with root package name */
    private g0 f12c;

    private void a(u1.d dVar, Context context) {
        g0 g0Var = new g0(null, context, new e.d(dVar), new c());
        this.f12c = g0Var;
        t.p(dVar, g0Var);
    }

    private void c(u1.d dVar) {
        t.p(dVar, null);
        this.f12c = null;
    }

    @Override // m1.a
    public void b(a.b bVar) {
        a(bVar.b(), bVar.a());
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        c(bVar.b());
    }

    @Override // n1.a
    public void h() {
        this.f12c.I(null);
    }

    @Override // n1.a
    public void i() {
        this.f12c.I(null);
        this.f12c.H();
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        cVar.i().getIntent().putExtra("PROXY_PACKAGE", "io.flutter.plugins.inapppurchase");
        this.f12c.I(cVar.i());
    }
}
