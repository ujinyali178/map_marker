package com.baseflow.geolocator;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.baseflow.geolocator.location.LocationServiceStatusReceiver;
import u1.e;

/* loaded from: /root/release/classes.dex */
public class b implements e.d {

    /* renamed from: c, reason: collision with root package name */
    private u1.e f2113c;

    /* renamed from: d, reason: collision with root package name */
    private Context f2114d;

    /* renamed from: f, reason: collision with root package name */
    private LocationServiceStatusReceiver f2115f;

    private void b() {
        LocationServiceStatusReceiver locationServiceStatusReceiver;
        Context context = this.f2114d;
        if (context == null || (locationServiceStatusReceiver = this.f2115f) == null) {
            return;
        }
        context.unregisterReceiver(locationServiceStatusReceiver);
    }

    @Override // u1.e.d
    public void a(Object obj) {
        b();
    }

    @Override // u1.e.d
    public void c(Object obj, e.b bVar) {
        if (this.f2114d == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.location.PROVIDERS_CHANGED");
        intentFilter.addAction("android.intent.action.PROVIDER_CHANGED");
        LocationServiceStatusReceiver locationServiceStatusReceiver = new LocationServiceStatusReceiver(bVar);
        this.f2115f = locationServiceStatusReceiver;
        androidx.core.content.a.registerReceiver(this.f2114d, locationServiceStatusReceiver, intentFilter, 2);
    }

    void d(Context context) {
        this.f2114d = context;
    }

    void e(Context context, u1.d dVar) {
        if (this.f2113c != null) {
            Log.w("LocationServiceHandler", "Setting a event call handler before the last was disposed.");
            f();
        }
        u1.e eVar = new u1.e(dVar, "flutter.baseflow.com/geolocator_service_updates_android");
        this.f2113c = eVar;
        eVar.d(this);
        this.f2114d = context;
    }

    void f() {
        if (this.f2113c == null) {
            return;
        }
        b();
        this.f2113c.d(null);
        this.f2113c = null;
    }
}
