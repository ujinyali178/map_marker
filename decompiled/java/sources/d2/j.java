package d2;

import android.util.Log;
import m1.a;

/* loaded from: /root/release/classes.dex */
public final class j implements m1.a, n1.a {

    /* renamed from: c, reason: collision with root package name */
    private i f2465c;

    @Override // m1.a
    public void b(a.b bVar) {
        this.f2465c = new i(bVar.a());
        g.g(bVar.b(), this.f2465c);
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        if (this.f2465c == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
        } else {
            g.g(bVar.b(), null);
            this.f2465c = null;
        }
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        i iVar = this.f2465c;
        if (iVar == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            iVar.l(null);
        }
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        i iVar = this.f2465c;
        if (iVar == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            iVar.l(cVar.i());
        }
    }
}
