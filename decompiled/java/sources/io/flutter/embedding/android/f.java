package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.BackEvent;
import i1.a;
import io.flutter.embedding.engine.d;
import io.flutter.plugin.platform.g;
import java.util.Arrays;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class f implements io.flutter.embedding.android.d<Activity> {

    /* renamed from: a, reason: collision with root package name */
    private d f2758a;

    /* renamed from: b, reason: collision with root package name */
    private io.flutter.embedding.engine.a f2759b;

    /* renamed from: c, reason: collision with root package name */
    v f2760c;

    /* renamed from: d, reason: collision with root package name */
    private io.flutter.plugin.platform.g f2761d;

    /* renamed from: e, reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f2762e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2763f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2764g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2765h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2766i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f2767j;

    /* renamed from: k, reason: collision with root package name */
    private io.flutter.embedding.engine.d f2768k;

    /* renamed from: l, reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f2769l;

    class a implements io.flutter.embedding.engine.renderer.d {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void b() {
            f.this.f2758a.b();
            f.this.f2764g = false;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            f.this.f2758a.e();
            f.this.f2764g = true;
            f.this.f2765h = true;
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ v f2771c;

        b(v vVar) {
            this.f2771c = vVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (f.this.f2764g && f.this.f2762e != null) {
                this.f2771c.getViewTreeObserver().removeOnPreDrawListener(this);
                f.this.f2762e = null;
            }
            return f.this.f2764g;
        }
    }

    public interface c {
        f z(d dVar);
    }

    interface d extends i, h, g.d {
        io.flutter.embedding.engine.g A();

        g0 B();

        h0 D();

        void b();

        void c();

        @Override // io.flutter.embedding.android.i
        io.flutter.embedding.engine.a d(Context context);

        void e();

        void g(io.flutter.embedding.engine.a aVar);

        Context getContext();

        androidx.lifecycle.e getLifecycle();

        void h(io.flutter.embedding.engine.a aVar);

        Activity i();

        List<String> j();

        String k();

        boolean l();

        String m();

        io.flutter.plugin.platform.g n(Activity activity, io.flutter.embedding.engine.a aVar);

        boolean o();

        boolean p();

        void q(p pVar);

        String r();

        String s();

        boolean t();

        boolean u();

        boolean v();

        String w();

        void x(o oVar);

        String y();
    }

    f(d dVar) {
        this(dVar, null);
    }

    f(d dVar, io.flutter.embedding.engine.d dVar2) {
        this.f2769l = new a();
        this.f2758a = dVar;
        this.f2765h = false;
        this.f2768k = dVar2;
    }

    private d.b g(d.b bVar) {
        String y3 = this.f2758a.y();
        if (y3 == null || y3.isEmpty()) {
            y3 = g1.a.e().c().g();
        }
        a.b bVar2 = new a.b(y3, this.f2758a.m());
        String s3 = this.f2758a.s();
        if (s3 == null && (s3 = q(this.f2758a.i().getIntent())) == null) {
            s3 = "/";
        }
        return bVar.i(bVar2).k(s3).j(this.f2758a.j());
    }

    private void j(v vVar) {
        if (this.f2758a.B() != g0.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.f2762e != null) {
            vVar.getViewTreeObserver().removeOnPreDrawListener(this.f2762e);
        }
        this.f2762e = new b(vVar);
        vVar.getViewTreeObserver().addOnPreDrawListener(this.f2762e);
    }

    private void k() {
        String str;
        if (this.f2758a.k() == null && !this.f2759b.k().l()) {
            String s3 = this.f2758a.s();
            if (s3 == null && (s3 = q(this.f2758a.i().getIntent())) == null) {
                s3 = "/";
            }
            String w3 = this.f2758a.w();
            if (("Executing Dart entrypoint: " + this.f2758a.m() + ", library uri: " + w3) == null) {
                str = "\"\"";
            } else {
                str = w3 + ", and sending initial route: " + s3;
            }
            g1.b.f("FlutterActivityAndFragmentDelegate", str);
            this.f2759b.o().c(s3);
            String y3 = this.f2758a.y();
            if (y3 == null || y3.isEmpty()) {
                y3 = g1.a.e().c().g();
            }
            this.f2759b.k().j(w3 == null ? new a.b(y3, this.f2758a.m()) : new a.b(y3, w3, this.f2758a.m()), this.f2758a.j());
        }
    }

    private void l() {
        if (this.f2758a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String q(Intent intent) {
        Uri data;
        if (!this.f2758a.o() || (data = intent.getData()) == null) {
            return null;
        }
        return data.toString();
    }

    void A(int i3, String[] strArr, int[] iArr) {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i3 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f2759b.i().onRequestPermissionsResult(i3, strArr, iArr);
    }

    void B(Bundle bundle) {
        Bundle bundle2;
        g1.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        l();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f2758a.l()) {
            this.f2759b.u().j(bArr);
        }
        if (this.f2758a.t()) {
            this.f2759b.i().b(bundle2);
        }
    }

    void C() {
        io.flutter.embedding.engine.a aVar;
        g1.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
        l();
        if (!this.f2758a.v() || (aVar = this.f2759b) == null) {
            return;
        }
        aVar.l().e();
    }

    void D(Bundle bundle) {
        g1.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        l();
        if (this.f2758a.l()) {
            bundle.putByteArray("framework", this.f2759b.u().h());
        }
        if (this.f2758a.t()) {
            Bundle bundle2 = new Bundle();
            this.f2759b.i().onSaveInstanceState(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    void E() {
        g1.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
        l();
        k();
        Integer num = this.f2767j;
        if (num != null) {
            this.f2760c.setVisibility(num.intValue());
        }
    }

    void F() {
        io.flutter.embedding.engine.a aVar;
        g1.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
        l();
        if (this.f2758a.v() && (aVar = this.f2759b) != null) {
            aVar.l().d();
        }
        this.f2767j = Integer.valueOf(this.f2760c.getVisibility());
        this.f2760c.setVisibility(8);
    }

    void G(int i3) {
        l();
        io.flutter.embedding.engine.a aVar = this.f2759b;
        if (aVar != null) {
            if (this.f2765h && i3 >= 10) {
                aVar.k().m();
                this.f2759b.x().a();
            }
            this.f2759b.t().o(i3);
            this.f2759b.q().o0(i3);
        }
    }

    void H() {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f2759b.i().onUserLeaveHint();
        }
    }

    void I(boolean z3) {
        io.flutter.embedding.engine.a aVar;
        l();
        StringBuilder sb = new StringBuilder();
        sb.append("Received onWindowFocusChanged: ");
        sb.append(z3 ? "true" : "false");
        g1.b.f("FlutterActivityAndFragmentDelegate", sb.toString());
        if (!this.f2758a.v() || (aVar = this.f2759b) == null) {
            return;
        }
        if (z3) {
            aVar.l().a();
        } else {
            aVar.l().f();
        }
    }

    void J() {
        this.f2758a = null;
        this.f2759b = null;
        this.f2760c = null;
        this.f2761d = null;
    }

    void K() {
        io.flutter.embedding.engine.d dVar;
        d.b l3;
        g1.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String k3 = this.f2758a.k();
        if (k3 != null) {
            io.flutter.embedding.engine.a a4 = io.flutter.embedding.engine.b.b().a(k3);
            this.f2759b = a4;
            this.f2763f = true;
            if (a4 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + k3 + "'");
        }
        d dVar2 = this.f2758a;
        io.flutter.embedding.engine.a d3 = dVar2.d(dVar2.getContext());
        this.f2759b = d3;
        if (d3 != null) {
            this.f2763f = true;
            return;
        }
        String r3 = this.f2758a.r();
        if (r3 != null) {
            dVar = io.flutter.embedding.engine.e.b().a(r3);
            if (dVar == null) {
                throw new IllegalStateException("The requested cached FlutterEngineGroup did not exist in the FlutterEngineGroupCache: '" + r3 + "'");
            }
            l3 = new d.b(this.f2758a.getContext());
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
            dVar = this.f2768k;
            if (dVar == null) {
                dVar = new io.flutter.embedding.engine.d(this.f2758a.getContext(), this.f2758a.A().b());
            }
            l3 = new d.b(this.f2758a.getContext()).h(false).l(this.f2758a.l());
        }
        this.f2759b = dVar.a(g(l3));
        this.f2763f = false;
    }

    void L(BackEvent backEvent) {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding startBackGesture() to FlutterEngine.");
            this.f2759b.j().d(backEvent);
        }
    }

    void M(BackEvent backEvent) {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding updateBackGestureProgress() to FlutterEngine.");
            this.f2759b.j().e(backEvent);
        }
    }

    void N() {
        io.flutter.plugin.platform.g gVar = this.f2761d;
        if (gVar != null) {
            gVar.E();
        }
    }

    @Override // io.flutter.embedding.android.d
    public void c() {
        if (!this.f2758a.u()) {
            this.f2758a.c();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f2758a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    void h() {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding cancelBackGesture() to FlutterEngine.");
            this.f2759b.j().b();
        }
    }

    void i() {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding commitBackGesture() to FlutterEngine.");
            this.f2759b.j().c();
        }
    }

    @Override // io.flutter.embedding.android.d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Activity d() {
        Activity i3 = this.f2758a.i();
        if (i3 != null) {
            return i3;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    io.flutter.embedding.engine.a n() {
        return this.f2759b;
    }

    boolean o() {
        return this.f2766i;
    }

    boolean p() {
        return this.f2763f;
    }

    void r(int i3, int i4, Intent intent) {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i3 + "\nresultCode: " + i4 + "\ndata: " + intent);
        this.f2759b.i().a(i3, i4, intent);
    }

    void s(Context context) {
        l();
        if (this.f2759b == null) {
            K();
        }
        if (this.f2758a.t()) {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f2759b.i().c(this, this.f2758a.getLifecycle());
        }
        d dVar = this.f2758a;
        this.f2761d = dVar.n(dVar.i(), this.f2759b);
        this.f2758a.g(this.f2759b);
        this.f2766i = true;
    }

    void t() {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        } else {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
            this.f2759b.o().a();
        }
    }

    View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i3, boolean z3) {
        v vVar;
        g1.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        l();
        if (this.f2758a.B() == g0.surface) {
            o oVar = new o(this.f2758a.getContext(), this.f2758a.D() == h0.transparent);
            this.f2758a.x(oVar);
            vVar = new v(this.f2758a.getContext(), oVar);
        } else {
            p pVar = new p(this.f2758a.getContext());
            pVar.setOpaque(this.f2758a.D() == h0.opaque);
            this.f2758a.q(pVar);
            vVar = new v(this.f2758a.getContext(), pVar);
        }
        this.f2760c = vVar;
        this.f2760c.k(this.f2769l);
        if (this.f2758a.p()) {
            g1.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
            this.f2760c.n(this.f2759b);
        }
        this.f2760c.setId(i3);
        if (z3) {
            j(this.f2760c);
        }
        return this.f2760c;
    }

    void v() {
        g1.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        l();
        if (this.f2762e != null) {
            this.f2760c.getViewTreeObserver().removeOnPreDrawListener(this.f2762e);
            this.f2762e = null;
        }
        v vVar = this.f2760c;
        if (vVar != null) {
            vVar.s();
            this.f2760c.y(this.f2769l);
        }
    }

    void w() {
        io.flutter.embedding.engine.a aVar;
        if (this.f2766i) {
            g1.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
            l();
            this.f2758a.h(this.f2759b);
            if (this.f2758a.t()) {
                g1.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
                if (this.f2758a.i().isChangingConfigurations()) {
                    this.f2759b.i().f();
                } else {
                    this.f2759b.i().e();
                }
            }
            io.flutter.plugin.platform.g gVar = this.f2761d;
            if (gVar != null) {
                gVar.q();
                this.f2761d = null;
            }
            if (this.f2758a.v() && (aVar = this.f2759b) != null) {
                aVar.l().b();
            }
            if (this.f2758a.u()) {
                this.f2759b.g();
                if (this.f2758a.k() != null) {
                    io.flutter.embedding.engine.b.b().d(this.f2758a.k());
                }
                this.f2759b = null;
            }
            this.f2766i = false;
        }
    }

    void x(Intent intent) {
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        g1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRouteInformation message.");
        this.f2759b.i().onNewIntent(intent);
        String q3 = q(intent);
        if (q3 == null || q3.isEmpty()) {
            return;
        }
        this.f2759b.o().b(q3);
    }

    void y() {
        io.flutter.embedding.engine.a aVar;
        g1.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
        l();
        if (!this.f2758a.v() || (aVar = this.f2759b) == null) {
            return;
        }
        aVar.l().c();
    }

    void z() {
        g1.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        l();
        if (this.f2759b == null) {
            g1.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        } else {
            N();
            this.f2759b.q().n0();
        }
    }
}
