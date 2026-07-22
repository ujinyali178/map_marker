package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.common.primitives.Ints;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public class FlutterFragmentActivity extends FragmentActivity implements i, h {

    /* renamed from: d, reason: collision with root package name */
    public static final int f2716d = View.generateViewId();

    /* renamed from: c, reason: collision with root package name */
    private j f2717c;

    private void L() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Ints.MAX_POWER_OF_TWO);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private void M() {
        if (Q() == g.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View O() {
        FrameLayout T = T(this);
        T.setId(f2716d);
        T.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return T;
    }

    private void P() {
        if (this.f2717c == null) {
            this.f2717c = U();
        }
        if (this.f2717c == null) {
            this.f2717c = N();
            getSupportFragmentManager().p().b(f2716d, this.f2717c, "flutter_fragment").f();
        }
    }

    private boolean S() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private void V() {
        try {
            Bundle R = R();
            if (R != null) {
                int i3 = R.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i3 != -1) {
                    setTheme(i3);
                }
            } else {
                g1.b.f("FlutterFragmentActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            g1.b.b("FlutterFragmentActivity", "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
        }
    }

    protected g0 B() {
        return Q() == g.opaque ? g0.surface : g0.texture;
    }

    protected j N() {
        g Q = Q();
        g0 B = B();
        h0 h0Var = Q == g.opaque ? h0.opaque : h0.transparent;
        boolean z3 = B == g0.surface;
        if (k() != null) {
            g1.b.f("FlutterFragmentActivity", "Creating FlutterFragment with cached engine:\nCached engine ID: " + k() + "\nWill destroy engine when Activity is destroyed: " + u() + "\nBackground transparency mode: " + Q + "\nWill attach FlutterEngine to Activity: " + t());
            return j.K(k()).e(B).h(h0Var).d(Boolean.valueOf(o())).f(t()).c(u()).g(z3).a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Creating FlutterFragment with new engine:\nCached engine group ID: ");
        sb.append(r());
        sb.append("\nBackground transparency mode: ");
        sb.append(Q);
        sb.append("\nDart entrypoint: ");
        sb.append(m());
        sb.append("\nDart entrypoint library uri: ");
        sb.append(w() != null ? w() : "\"\"");
        sb.append("\nInitial route: ");
        sb.append(s());
        sb.append("\nApp bundle path: ");
        sb.append(y());
        sb.append("\nWill attach FlutterEngine to Activity: ");
        sb.append(t());
        g1.b.f("FlutterFragmentActivity", sb.toString());
        return r() != null ? j.M(r()).c(m()).e(s()).d(o()).f(B).i(h0Var).g(t()).h(z3).a() : j.L().d(m()).f(w()).e(j()).i(s()).a(y()).g(io.flutter.embedding.engine.g.a(getIntent())).h(Boolean.valueOf(o())).j(B).m(h0Var).k(t()).l(z3).b();
    }

    protected g Q() {
        return getIntent().hasExtra("background_mode") ? g.valueOf(getIntent().getStringExtra("background_mode")) : g.opaque;
    }

    protected Bundle R() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    protected FrameLayout T(Context context) {
        return new FrameLayout(context);
    }

    j U() {
        return (j) getSupportFragmentManager().j0("flutter_fragment");
    }

    @Override // io.flutter.embedding.android.i
    public io.flutter.embedding.engine.a d(Context context) {
        return null;
    }

    @Override // io.flutter.embedding.android.h
    public void g(io.flutter.embedding.engine.a aVar) {
        j jVar = this.f2717c;
        if (jVar == null || !jVar.G()) {
            s1.a.a(aVar);
        }
    }

    @Override // io.flutter.embedding.android.h
    public void h(io.flutter.embedding.engine.a aVar) {
    }

    public List<String> j() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    protected String k() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public String m() {
        try {
            Bundle R = R();
            String string = R != null ? R.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    protected boolean o() {
        try {
            Bundle R = R();
            if (R != null) {
                return R.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        this.f2717c.onActivityResult(i3, i4, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f2717c.H();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        V();
        this.f2717c = U();
        super.onCreate(bundle);
        M();
        setContentView(O());
        L();
        P();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.f2717c.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f2717c.onPostResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        this.f2717c.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        this.f2717c.onTrimMemory(i3);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.f2717c.onUserLeaveHint();
    }

    protected String r() {
        return getIntent().getStringExtra("cached_engine_group_id");
    }

    protected String s() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle R = R();
            if (R != null) {
                return R.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    protected boolean t() {
        return true;
    }

    public boolean u() {
        return getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    }

    public String w() {
        try {
            Bundle R = R();
            if (R != null) {
                return R.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    protected String y() {
        String dataString;
        if (S() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }
}
