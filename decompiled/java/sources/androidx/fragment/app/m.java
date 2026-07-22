package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* loaded from: /root/release/classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final o<?> f1159a;

    private m(o<?> oVar) {
        this.f1159a = oVar;
    }

    public static m b(o<?> oVar) {
        return new m((o) androidx.core.util.d.f(oVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        o<?> oVar = this.f1159a;
        oVar.f1165h.n(oVar, oVar, fragment);
    }

    public void c() {
        this.f1159a.f1165h.z();
    }

    public boolean d(MenuItem menuItem) {
        return this.f1159a.f1165h.C(menuItem);
    }

    public void e() {
        this.f1159a.f1165h.D();
    }

    public void f() {
        this.f1159a.f1165h.F();
    }

    public void g() {
        this.f1159a.f1165h.O();
    }

    public void h() {
        this.f1159a.f1165h.S();
    }

    public void i() {
        this.f1159a.f1165h.T();
    }

    public void j() {
        this.f1159a.f1165h.V();
    }

    public boolean k() {
        return this.f1159a.f1165h.c0(true);
    }

    public w l() {
        return this.f1159a.f1165h;
    }

    public void m() {
        this.f1159a.f1165h.Z0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1159a.f1165h.w0().onCreateView(view, str, context, attributeSet);
    }
}
