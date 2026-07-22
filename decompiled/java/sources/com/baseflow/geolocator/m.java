package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import java.util.Map;
import u1.e;
import y.h0;
import y.p;
import y.y;
import y.z;

/* loaded from: /root/release/classes.dex */
class m implements e.d {

    /* renamed from: c, reason: collision with root package name */
    private final z.b f2142c;

    /* renamed from: d, reason: collision with root package name */
    private final String f2143d;

    /* renamed from: f, reason: collision with root package name */
    private u1.e f2144f;

    /* renamed from: g, reason: collision with root package name */
    private Context f2145g;

    /* renamed from: h, reason: collision with root package name */
    private Activity f2146h;

    /* renamed from: i, reason: collision with root package name */
    private GeolocatorLocationService f2147i;

    /* renamed from: j, reason: collision with root package name */
    private y.k f2148j;

    /* renamed from: k, reason: collision with root package name */
    private p f2149k;

    public m(z.b bVar, y.k kVar, String str) {
        this.f2142c = bVar;
        this.f2148j = kVar;
        this.f2143d = str;
    }

    private void e(boolean z3) {
        y.k kVar;
        Log.e("FlutterGeolocator", "Geolocator position updates stopped");
        GeolocatorLocationService geolocatorLocationService = this.f2147i;
        if (geolocatorLocationService == null || !geolocatorLocationService.c(z3)) {
            Log.e("FlutterGeolocator", "There is still another flutter engine connected, not stopping location service");
        } else {
            this.f2147i.q();
            this.f2147i.e();
        }
        p pVar = this.f2149k;
        if (pVar == null || (kVar = this.f2148j) == null) {
            return;
        }
        kVar.g(pVar);
        this.f2149k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(e.b bVar, Location location) {
        bVar.a(y.b(location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(e.b bVar, x.b bVar2) {
        bVar.b(bVar2.toString(), bVar2.b(), null);
    }

    @Override // u1.e.d
    public void a(Object obj) {
        e(true);
    }

    @Override // u1.e.d
    public void c(Object obj, final e.b bVar) {
        try {
            if (!this.f2142c.d(this.f2145g)) {
                x.b bVar2 = x.b.permissionDenied;
                bVar.b(bVar2.toString(), bVar2.b(), null);
                return;
            }
            Map map = (Map) obj;
            boolean z3 = false;
            if (map != null && map.get("forceLocationManager") != null) {
                z3 = ((Boolean) map.get("forceLocationManager")).booleanValue();
            }
            z e3 = z.e(map);
            y.d i3 = map != null ? y.d.i((Map) map.get("foregroundNotificationConfig")) : null;
            if (i3 == null) {
                Log.e("FlutterGeolocator", "Geolocator position updates started");
                p b4 = this.f2148j.b(this.f2145g, Boolean.TRUE.equals(Boolean.valueOf(z3)), e3);
                this.f2149k = b4;
                this.f2148j.f(b4, this.f2146h, new h0() { // from class: com.baseflow.geolocator.k
                    @Override // y.h0
                    public final void a(Location location) {
                        m.f(e.b.this, location);
                    }
                }, new x.a() { // from class: com.baseflow.geolocator.l
                    @Override // x.a
                    public final void a(x.b bVar3) {
                        m.g(e.b.this, bVar3);
                    }
                });
                return;
            }
            if (this.f2147i == null) {
                Log.e("FlutterGeolocator", "Location background service has not started correctly");
                return;
            }
            Log.e("FlutterGeolocator", "Geolocator position updates started using Android foreground service");
            this.f2147i.p(z3, e3, bVar);
            this.f2147i.f(i3);
        } catch (x.c unused) {
            x.b bVar3 = x.b.permissionDefinitionsNotFound;
            bVar.b(bVar3.toString(), bVar3.b(), null);
        }
    }

    public void h(Activity activity) {
        if (activity == null && this.f2149k != null && this.f2144f != null) {
            k();
        }
        this.f2146h = activity;
    }

    public void i(GeolocatorLocationService geolocatorLocationService) {
        this.f2147i = geolocatorLocationService;
    }

    void j(Context context, u1.d dVar) {
        if (this.f2144f != null) {
            Log.w("FlutterGeolocator", "Setting a event call handler before the last was disposed.");
            k();
        }
        u1.e eVar = new u1.e(dVar, this.f2143d);
        this.f2144f = eVar;
        eVar.d(this);
        this.f2145g = context;
    }

    void k() {
        if (this.f2144f == null) {
            Log.d("FlutterGeolocator", "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        e(false);
        this.f2144f.d(null);
        this.f2144f = null;
    }
}
