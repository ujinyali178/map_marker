package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.flutter.app.a;
import io.flutter.view.t;
import io.flutter.view.v;
import u1.n;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class FlutterActivity extends Activity implements v.e, n, a.b {

    /* renamed from: c, reason: collision with root package name */
    private final a f2694c;

    /* renamed from: d, reason: collision with root package name */
    private final h1.a f2695d;

    /* renamed from: f, reason: collision with root package name */
    private final v.e f2696f;

    /* renamed from: g, reason: collision with root package name */
    private final n f2697g;

    public FlutterActivity() {
        a aVar = new a(this, this);
        this.f2694c = aVar;
        this.f2695d = aVar;
        this.f2696f = aVar;
        this.f2697g = aVar;
    }

    @Override // io.flutter.app.a.b
    public v a(Context context) {
        return null;
    }

    @Override // io.flutter.app.a.b
    public boolean f() {
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (this.f2695d.a(i3, i4, intent)) {
            return;
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f2695d.C()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2695d.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2695d.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f2695d.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f2695d.onLowMemory();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.f2695d.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f2695d.onPause();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.f2695d.onPostResume();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.f2695d.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f2695d.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f2695d.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.f2695d.onStop();
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        this.f2695d.onTrimMemory(i3);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.f2695d.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        this.f2695d.onWindowFocusChanged(z3);
    }

    @Override // io.flutter.app.a.b
    public t z() {
        return null;
    }
}
