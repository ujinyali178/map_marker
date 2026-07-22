package b0;

import android.app.Activity;
import android.content.Context;
import m1.a;
import u1.n;

/* loaded from: /root/release/classes.dex */
public final class m implements m1.a, n1.a {

    /* renamed from: c, reason: collision with root package name */
    private u f1541c;

    /* renamed from: d, reason: collision with root package name */
    private u1.l f1542d;

    /* renamed from: f, reason: collision with root package name */
    private n.c f1543f;

    /* renamed from: g, reason: collision with root package name */
    private n1.c f1544g;

    /* renamed from: h, reason: collision with root package name */
    private l f1545h;

    private void a() {
        n1.c cVar = this.f1544g;
        if (cVar != null) {
            cVar.d(this.f1541c);
            this.f1544g.c(this.f1541c);
        }
    }

    private void c() {
        n.c cVar = this.f1543f;
        if (cVar != null) {
            cVar.a(this.f1541c);
            this.f1543f.b(this.f1541c);
            return;
        }
        n1.c cVar2 = this.f1544g;
        if (cVar2 != null) {
            cVar2.a(this.f1541c);
            this.f1544g.b(this.f1541c);
        }
    }

    private void f(Context context, u1.d dVar) {
        this.f1542d = new u1.l(dVar, "flutter.baseflow.com/permissions/methods");
        l lVar = new l(context, new a(), this.f1541c, new y());
        this.f1545h = lVar;
        this.f1542d.e(lVar);
    }

    private void g(Activity activity) {
        u uVar = this.f1541c;
        if (uVar != null) {
            uVar.i(activity);
        }
    }

    private void k() {
        this.f1542d.e(null);
        this.f1542d = null;
        this.f1545h = null;
    }

    private void l() {
        u uVar = this.f1541c;
        if (uVar != null) {
            uVar.i(null);
        }
    }

    @Override // m1.a
    public void b(a.b bVar) {
        this.f1541c = new u(bVar.a());
        f(bVar.a(), bVar.b());
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        k();
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        l();
        a();
        this.f1544g = null;
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        g(cVar.i());
        this.f1544g = cVar;
        c();
    }
}
