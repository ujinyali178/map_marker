package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.a;
import java.nio.ByteBuffer;
import u1.d;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class t implements u1.d {

    /* renamed from: c, reason: collision with root package name */
    private final h1.b f3607c;

    /* renamed from: d, reason: collision with root package name */
    private final i1.a f3608d;

    /* renamed from: f, reason: collision with root package name */
    private v f3609f;

    /* renamed from: g, reason: collision with root package name */
    private final FlutterJNI f3610g;

    /* renamed from: h, reason: collision with root package name */
    private final Context f3611h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3612i;

    /* renamed from: j, reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f3613j;

    class a implements io.flutter.embedding.engine.renderer.d {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void b() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            if (t.this.f3609f == null) {
                return;
            }
            t.this.f3609f.w();
        }
    }

    private final class b implements a.b {
        private b() {
        }

        /* synthetic */ b(t tVar, a aVar) {
            this();
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
            if (t.this.f3609f != null) {
                t.this.f3609f.I();
            }
            if (t.this.f3607c == null) {
                return;
            }
            t.this.f3607c.g();
        }
    }

    public t(Context context) {
        this(context, false);
    }

    public t(Context context, boolean z3) {
        a aVar = new a();
        this.f3613j = aVar;
        if (z3) {
            g1.b.g("FlutterNativeView", "'isBackgroundView' is no longer supported and will be ignored");
        }
        this.f3611h = context;
        this.f3607c = new h1.b(this, context);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.f3610g = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
        this.f3608d = new i1.a(flutterJNI, context.getAssets());
        flutterJNI.addEngineLifecycleListener(new b(this, null));
        j(this);
        h();
    }

    private void j(t tVar) {
        this.f3610g.attachToNative();
        this.f3608d.n();
    }

    @Override // u1.d
    public d.c a(d.C0107d c0107d) {
        return this.f3608d.k().a(c0107d);
    }

    @Override // u1.d
    public /* synthetic */ d.c b() {
        return u1.c.a(this);
    }

    @Override // u1.d
    public void d(String str, d.a aVar) {
        this.f3608d.k().d(str, aVar);
    }

    @Override // u1.d
    public void e(String str, d.a aVar, d.c cVar) {
        this.f3608d.k().e(str, aVar, cVar);
    }

    @Override // u1.d
    public void f(String str, ByteBuffer byteBuffer) {
        this.f3608d.k().f(str, byteBuffer);
    }

    public void h() {
        if (!r()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    @Override // u1.d
    public void i(String str, ByteBuffer byteBuffer, d.b bVar) {
        if (r()) {
            this.f3608d.k().i(str, byteBuffer, bVar);
            return;
        }
        g1.b.a("FlutterNativeView", "FlutterView.send called on a detached view, channel=" + str);
    }

    public void k(v vVar, Activity activity) {
        this.f3609f = vVar;
        this.f3607c.c(vVar, activity);
    }

    public void l() {
        this.f3607c.d();
        this.f3608d.o();
        this.f3609f = null;
        this.f3610g.removeIsDisplayingFlutterUiListener(this.f3613j);
        this.f3610g.detachFromNativeAndReleaseResources();
        this.f3612i = false;
    }

    public void m() {
        this.f3607c.e();
        this.f3609f = null;
    }

    public i1.a n() {
        return this.f3608d;
    }

    FlutterJNI o() {
        return this.f3610g;
    }

    public h1.b p() {
        return this.f3607c;
    }

    public boolean q() {
        return this.f3612i;
    }

    public boolean r() {
        return this.f3610g.isAttached();
    }

    public void s(u uVar) {
        if (uVar.f3617b == null) {
            throw new AssertionError("An entrypoint must be specified");
        }
        h();
        if (this.f3612i) {
            throw new AssertionError("This Flutter engine instance is already running an application");
        }
        this.f3610g.runBundleAndSnapshotFromLibrary(uVar.f3616a, uVar.f3617b, uVar.f3618c, this.f3611h.getResources().getAssets(), null);
        this.f3612i = true;
    }
}
