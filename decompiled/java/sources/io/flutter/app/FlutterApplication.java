package io.flutter.app;

import android.app.Activity;
import android.app.Application;

/* loaded from: /root/release/classes.dex */
public class FlutterApplication extends Application {

    /* renamed from: c, reason: collision with root package name */
    private Activity f2698c = null;

    public Activity a() {
        return this.f2698c;
    }

    public void b(Activity activity) {
        this.f2698c = activity;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        g1.a.e().c().n(this);
    }
}
