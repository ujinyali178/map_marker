package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.e;
import com.google.common.primitives.Ints;
import io.flutter.embedding.android.f;
import java.util.List;
import p002.p003.bi;
import p004i.p005i.pk;

/* loaded from: /root/release/classes.dex */
public class FlutterActivity extends Activity implements f.d, androidx.lifecycle.i {

    /* renamed from: h, reason: collision with root package name */
    public static final int f2710h = View.generateViewId();

    /* renamed from: c, reason: collision with root package name */
    private boolean f2711c = false;

    /* renamed from: d, reason: collision with root package name */
    protected f f2712d;

    /* renamed from: f, reason: collision with root package name */
    private androidx.lifecycle.j f2713f;

    /* renamed from: g, reason: collision with root package name */
    private final OnBackInvokedCallback f2714g;

    class a implements OnBackAnimationCallback {
        a() {
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackCancelled() {
            FlutterActivity.this.z();
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            FlutterActivity.this.E();
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackProgressed(BackEvent backEvent) {
            FlutterActivity.this.T(backEvent);
        }

        @Override // android.window.OnBackAnimationCallback
        public void onBackStarted(BackEvent backEvent) {
            FlutterActivity.this.P(backEvent);
        }
    }

    public FlutterActivity() {
        this.f2714g = Build.VERSION.SDK_INT < 33 ? null : I();
        this.f2713f = new androidx.lifecycle.j(this);
    }

    private void F() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Ints.MAX_POWER_OF_TWO);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private void G() {
        if (J() == g.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View H() {
        return this.f2712d.u(null, null, null, f2710h, B() == g0.surface);
    }

    private OnBackInvokedCallback I() {
        return Build.VERSION.SDK_INT >= 34 ? new a() : new OnBackInvokedCallback() { // from class: io.flutter.embedding.android.e
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                FlutterActivity.this.onBackPressed();
            }
        };
    }

    private boolean M() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private boolean Q(String str) {
        StringBuilder sb;
        String str2;
        f fVar = this.f2712d;
        if (fVar == null) {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after release.";
        } else {
            if (fVar.o()) {
                return true;
            }
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after detach.";
        }
        sb.append(str2);
        g1.b.g("FlutterActivity", sb.toString());
        return false;
    }

    private void R() {
        try {
            Bundle L = L();
            if (L != null) {
                int i3 = L.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i3 != -1) {
                    setTheme(i3);
                }
            } else {
                g1.b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            g1.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public io.flutter.embedding.engine.g A() {
        return io.flutter.embedding.engine.g.a(getIntent());
    }

    @Override // io.flutter.embedding.android.f.d
    public g0 B() {
        return J() == g.opaque ? g0.surface : g0.texture;
    }

    @Override // io.flutter.embedding.android.f.d
    public h0 D() {
        return J() == g.opaque ? h0.opaque : h0.transparent;
    }

    public void E() {
        if (Q("commitBackGesture")) {
            this.f2712d.i();
        }
    }

    protected g J() {
        return getIntent().hasExtra("background_mode") ? g.valueOf(getIntent().getStringExtra("background_mode")) : g.opaque;
    }

    protected io.flutter.embedding.engine.a K() {
        return this.f2712d.n();
    }

    protected Bundle L() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public void N() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f2714g);
            this.f2711c = true;
        }
    }

    public void O() {
        S();
        f fVar = this.f2712d;
        if (fVar != null) {
            fVar.J();
            this.f2712d = null;
        }
    }

    public void P(BackEvent backEvent) {
        if (Q("startBackGesture")) {
            this.f2712d.L(backEvent);
        }
    }

    public void S() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f2714g);
            this.f2711c = false;
        }
    }

    public void T(BackEvent backEvent) {
        if (Q("updateBackGestureProgress")) {
            this.f2712d.M(backEvent);
        }
    }

    @Override // io.flutter.plugin.platform.g.d
    public boolean a() {
        return false;
    }

    @Override // io.flutter.embedding.android.f.d
    public void b() {
    }

    @Override // io.flutter.embedding.android.f.d
    public void c() {
        g1.b.g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + K() + " evicted by another attaching activity");
        f fVar = this.f2712d;
        if (fVar != null) {
            fVar.v();
            this.f2712d.w();
        }
    }

    @Override // io.flutter.embedding.android.f.d, io.flutter.embedding.android.i
    public io.flutter.embedding.engine.a d(Context context) {
        return null;
    }

    @Override // io.flutter.embedding.android.f.d
    public void e() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.plugin.platform.g.d
    public void f(boolean z3) {
        if (z3 && !this.f2711c) {
            N();
        } else {
            if (z3 || !this.f2711c) {
                return;
            }
            S();
        }
    }

    public void g(io.flutter.embedding.engine.a aVar) {
        if (this.f2712d.p()) {
            return;
        }
        s1.a.a(aVar);
    }

    @Override // io.flutter.embedding.android.f.d
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.f.d, androidx.lifecycle.i
    public androidx.lifecycle.e getLifecycle() {
        return this.f2713f;
    }

    @Override // io.flutter.embedding.android.f.d, io.flutter.embedding.android.h
    public void h(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.f.d
    public Activity i() {
        return this;
    }

    @Override // io.flutter.embedding.android.f.d
    public List<String> j() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // io.flutter.embedding.android.f.d
    public String k() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean l() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : k() == null;
    }

    @Override // io.flutter.embedding.android.f.d
    public String m() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle L = L();
            String string = L != null ? L.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public io.flutter.plugin.platform.g n(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new io.flutter.plugin.platform.g(i(), aVar.p(), this);
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean o() {
        try {
            Bundle L = L();
            if (L != null) {
                return L.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (Q("onActivityResult")) {
            this.f2712d.r(i3, i4, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (Q("onBackPressed")) {
            this.f2712d.t();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        pk.process(this);
        bi.b(this);
        R();
        super.onCreate(bundle);
        f fVar = new f(this);
        this.f2712d = fVar;
        fVar.s(this);
        this.f2712d.B(bundle);
        this.f2713f.h(e.a.ON_CREATE);
        G();
        setContentView(H());
        F();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (Q("onDestroy")) {
            this.f2712d.v();
            this.f2712d.w();
        }
        O();
        this.f2713f.h(e.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Q("onNewIntent")) {
            this.f2712d.x(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (Q("onPause")) {
            this.f2712d.y();
        }
        this.f2713f.h(e.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (Q("onPostResume")) {
            this.f2712d.z();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (Q("onRequestPermissionsResult")) {
            this.f2712d.A(i3, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2713f.h(e.a.ON_RESUME);
        if (Q("onResume")) {
            this.f2712d.C();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (Q("onSaveInstanceState")) {
            this.f2712d.D(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f2713f.h(e.a.ON_START);
        if (Q("onStart")) {
            this.f2712d.E();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (Q("onStop")) {
            this.f2712d.F();
        }
        this.f2713f.h(e.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        if (Q("onTrimMemory")) {
            this.f2712d.G(i3);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (Q("onUserLeaveHint")) {
            this.f2712d.H();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        if (Q("onWindowFocusChanged")) {
            this.f2712d.I(z3);
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean p() {
        return true;
    }

    @Override // io.flutter.embedding.android.f.d
    public void q(p pVar) {
    }

    @Override // io.flutter.embedding.android.f.d
    public String r() {
        return getIntent().getStringExtra("cached_engine_group_id");
    }

    @Override // io.flutter.embedding.android.f.d
    public String s() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle L = L();
            if (L != null) {
                return L.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean t() {
        return true;
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean u() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (k() != null || this.f2712d.p()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.f.d
    public boolean v() {
        return true;
    }

    @Override // io.flutter.embedding.android.f.d
    public String w() {
        try {
            Bundle L = L();
            if (L != null) {
                return L.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.f.d
    public void x(o oVar) {
    }

    @Override // io.flutter.embedding.android.f.d
    public String y() {
        String dataString;
        if (M() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    public void z() {
        if (Q("cancelBackGesture")) {
            this.f2712d.h();
        }
    }
}
