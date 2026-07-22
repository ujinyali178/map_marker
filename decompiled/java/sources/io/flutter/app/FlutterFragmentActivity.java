package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import io.flutter.app.a;
import io.flutter.view.t;
import io.flutter.view.v;
import u1.n;

@Deprecated
/* loaded from: /root/release/classes.dex */
public class FlutterFragmentActivity extends FragmentActivity implements v.e, n, a.b {

    /* renamed from: c, reason: collision with root package name */
    private final a f2699c;

    /* renamed from: d, reason: collision with root package name */
    private final h1.a f2700d;

    /* renamed from: f, reason: collision with root package name */
    private final v.e f2701f;

    /* renamed from: g, reason: collision with root package name */
    private final n f2702g;

    public FlutterFragmentActivity() {
        a aVar = new a(this, this);
        this.f2699c = aVar;
        this.f2700d = aVar;
        this.f2701f = aVar;
        this.f2702g = aVar;
    }

    @Override // io.flutter.app.a.b
    public v a(Context context) {
        return null;
    }

    @Override // io.flutter.app.a.b
    public boolean f() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (this.f2700d.a(i3, i4, intent)) {
            return;
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f2700d.C()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2700d.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2700d.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f2700d.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f2700d.onLowMemory();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f2700d.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f2700d.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.f2700d.onPostResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        this.f2700d.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f2700d.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.f2700d.onStop();
        super.onStop();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        this.f2700d.onTrimMemory(i3);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        this.f2700d.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        this.f2700d.onWindowFocusChanged(z3);
    }

    @Override // io.flutter.app.a.b
    public t z() {
        return null;
    }
}
