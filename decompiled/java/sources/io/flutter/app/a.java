package io.flutter.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.primitives.Ints;
import e2.c;
import io.flutter.view.s;
import io.flutter.view.t;
import io.flutter.view.u;
import io.flutter.view.v;
import u1.n;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class a implements h1.a, v.e, n {

    /* renamed from: h, reason: collision with root package name */
    private static final WindowManager.LayoutParams f2703h = new WindowManager.LayoutParams(-1, -1);

    /* renamed from: c, reason: collision with root package name */
    private final Activity f2704c;

    /* renamed from: d, reason: collision with root package name */
    private final b f2705d;

    /* renamed from: f, reason: collision with root package name */
    private v f2706f;

    /* renamed from: g, reason: collision with root package name */
    private View f2707g;

    /* renamed from: io.flutter.app.a$a, reason: collision with other inner class name */
    class C0084a implements v.d {

        /* renamed from: io.flutter.app.a$a$a, reason: collision with other inner class name */
        class C0085a extends AnimatorListenerAdapter {
            C0085a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((ViewGroup) a.this.f2707g.getParent()).removeView(a.this.f2707g);
                a.this.f2707g = null;
            }
        }

        C0084a() {
        }

        @Override // io.flutter.view.v.d
        public void a() {
            a.this.f2707g.animate().alpha(BitmapDescriptorFactory.HUE_RED).setListener(new C0085a());
            a.this.f2706f.H(this);
        }
    }

    public interface b {
        v a(Context context);

        boolean f();

        t z();
    }

    public a(Activity activity, b bVar) {
        this.f2704c = (Activity) c.a(activity);
        this.f2705d = (b) c.a(bVar);
    }

    private void e() {
        View view = this.f2707g;
        if (view == null) {
            return;
        }
        this.f2704c.addContentView(view, f2703h);
        this.f2706f.p(new C0084a());
        this.f2704c.setTheme(R.style.Theme.Black.NoTitleBar);
    }

    private View f() {
        Drawable h3;
        if (!l().booleanValue() || (h3 = h()) == null) {
            return null;
        }
        View view = new View(this.f2704c);
        view.setLayoutParams(f2703h);
        view.setBackground(h3);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String[] g(android.content.Intent r5) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.app.a.g(android.content.Intent):java.lang.String[]");
    }

    private Drawable h() {
        TypedValue typedValue = new TypedValue();
        if (!this.f2704c.getTheme().resolveAttribute(R.attr.windowBackground, typedValue, true) || typedValue.resourceId == 0) {
            return null;
        }
        try {
            return this.f2704c.getResources().getDrawable(typedValue.resourceId);
        } catch (Resources.NotFoundException unused) {
            g1.b.b("FlutterActivityDelegate", "Referenced launch screen windowBackground resource does not exist");
            return null;
        }
    }

    private boolean i() {
        return (this.f2704c.getApplicationInfo().flags & 2) != 0;
    }

    private boolean j(Intent intent) {
        if (!"android.intent.action.RUN".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("route");
        String dataString = intent.getDataString();
        if (dataString == null) {
            dataString = s.b();
        }
        if (stringExtra != null) {
            this.f2706f.setInitialRoute(stringExtra);
        }
        k(dataString);
        return true;
    }

    private void k(String str) {
        if (this.f2706f.getFlutterNativeView().q()) {
            return;
        }
        u uVar = new u();
        uVar.f3616a = str;
        uVar.f3617b = "main";
        this.f2706f.K(uVar);
    }

    private Boolean l() {
        try {
            Bundle bundle = this.f2704c.getPackageManager().getActivityInfo(this.f2704c.getComponentName(), 128).metaData;
            return Boolean.valueOf(bundle != null && bundle.getBoolean("io.flutter.app.android.SplashScreenUntilFirstFrame"));
        } catch (PackageManager.NameNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    @Override // h1.a
    public boolean C() {
        v vVar = this.f2706f;
        if (vVar == null) {
            return false;
        }
        vVar.C();
        return true;
    }

    @Override // u1.n.a
    public boolean a(int i3, int i4, Intent intent) {
        return this.f2706f.getPluginRegistry().a(i3, i4, intent);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // h1.a
    public void onCreate(Bundle bundle) {
        String b4;
        Window window = this.f2704c.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Ints.MAX_POWER_OF_TWO);
        window.getDecorView().setSystemUiVisibility(1280);
        s.a(this.f2704c.getApplicationContext(), g(this.f2704c.getIntent()));
        v a4 = this.f2705d.a(this.f2704c);
        this.f2706f = a4;
        if (a4 == null) {
            v vVar = new v(this.f2704c, null, this.f2705d.z());
            this.f2706f = vVar;
            vVar.setLayoutParams(f2703h);
            this.f2704c.setContentView(this.f2706f);
            View f3 = f();
            this.f2707g = f3;
            if (f3 != null) {
                e();
            }
        }
        if (j(this.f2704c.getIntent()) || (b4 = s.b()) == null) {
            return;
        }
        k(b4);
    }

    @Override // h1.a
    public void onDestroy() {
        Application application = (Application) this.f2704c.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.f2704c.equals(flutterApplication.a())) {
                flutterApplication.b(null);
            }
        }
        v vVar = this.f2706f;
        if (vVar != null) {
            if (vVar.getPluginRegistry().b(this.f2706f.getFlutterNativeView()) || this.f2705d.f()) {
                this.f2706f.t();
            } else {
                this.f2706f.s();
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f2706f.x();
    }

    @Override // h1.a
    public void onNewIntent(Intent intent) {
        if (i() && j(intent)) {
            return;
        }
        this.f2706f.getPluginRegistry().onNewIntent(intent);
    }

    @Override // h1.a
    public void onPause() {
        Application application = (Application) this.f2704c.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.f2704c.equals(flutterApplication.a())) {
                flutterApplication.b(null);
            }
        }
        v vVar = this.f2706f;
        if (vVar != null) {
            vVar.y();
        }
    }

    @Override // h1.a
    public void onPostResume() {
        v vVar = this.f2706f;
        if (vVar != null) {
            vVar.z();
        }
    }

    @Override // u1.n.d
    public boolean onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        return this.f2706f.getPluginRegistry().onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // h1.a
    public void onResume() {
        Application application = (Application) this.f2704c.getApplicationContext();
        if (application instanceof FlutterApplication) {
            ((FlutterApplication) application).b(this.f2704c);
        }
    }

    @Override // h1.a
    public void onStart() {
        v vVar = this.f2706f;
        if (vVar != null) {
            vVar.A();
        }
    }

    @Override // h1.a
    public void onStop() {
        this.f2706f.B();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        if (i3 == 10) {
            this.f2706f.x();
        }
    }

    @Override // h1.a
    public void onUserLeaveHint() {
        this.f2706f.getPluginRegistry().onUserLeaveHint();
    }

    @Override // h1.a
    public void onWindowFocusChanged(boolean z3) {
        this.f2706f.getPluginRegistry().onWindowFocusChanged(z3);
    }
}
