package com.baseflow.geolocator;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baseflow.geolocator.GeolocatorLocationService;
import m1.a;

/* loaded from: /root/release/classes.dex */
public class a implements m1.a, n1.a {

    /* renamed from: g, reason: collision with root package name */
    private GeolocatorLocationService f2105g;

    /* renamed from: h, reason: collision with root package name */
    private j f2106h;

    /* renamed from: i, reason: collision with root package name */
    private m f2107i;

    /* renamed from: j, reason: collision with root package name */
    private m f2108j;

    /* renamed from: l, reason: collision with root package name */
    private b f2110l;

    /* renamed from: m, reason: collision with root package name */
    private n1.c f2111m;

    /* renamed from: k, reason: collision with root package name */
    private final ServiceConnection f2109k = new ServiceConnectionC0047a();

    /* renamed from: c, reason: collision with root package name */
    private final z.b f2102c = new z.b();

    /* renamed from: d, reason: collision with root package name */
    private final y.k f2103d = new y.k();

    /* renamed from: f, reason: collision with root package name */
    private final y.m f2104f = new y.m();

    /* renamed from: com.baseflow.geolocator.a$a, reason: collision with other inner class name */
    class ServiceConnectionC0047a implements ServiceConnection {
        ServiceConnectionC0047a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g1.b.a("FlutterGeolocator", "Geolocator foreground service connected");
            if (iBinder instanceof GeolocatorLocationService.a) {
                a.this.m(((GeolocatorLocationService.a) iBinder).a());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g1.b.a("FlutterGeolocator", "Geolocator foreground service disconnected");
            if (a.this.f2105g != null) {
                a.this.f2105g.n(null);
                a.this.f2105g = null;
            }
        }
    }

    private void g(Context context) {
        context.bindService(new Intent(context, (Class<?>) GeolocatorLocationService.class), this.f2109k, 1);
    }

    private void k() {
        n1.c cVar = this.f2111m;
        if (cVar != null) {
            cVar.d(this.f2103d);
            this.f2111m.c(this.f2102c);
        }
    }

    private void l() {
        g1.b.a("FlutterGeolocator", "Disposing Geolocator services");
        j jVar = this.f2106h;
        if (jVar != null) {
            jVar.y();
            this.f2106h.w(null);
            this.f2106h = null;
        }
        m mVar = this.f2107i;
        if (mVar != null) {
            mVar.k();
            this.f2107i = null;
        }
        m mVar2 = this.f2108j;
        if (mVar2 != null) {
            mVar2.k();
            this.f2108j.i(null);
            this.f2108j = null;
        }
        b bVar = this.f2110l;
        if (bVar != null) {
            bVar.d(null);
            this.f2110l.f();
            this.f2110l = null;
        }
        GeolocatorLocationService geolocatorLocationService = this.f2105g;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.n(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(GeolocatorLocationService geolocatorLocationService) {
        g1.b.a("FlutterGeolocator", "Initializing Geolocator services");
        this.f2105g = geolocatorLocationService;
        geolocatorLocationService.o(this.f2103d);
        this.f2105g.g();
        m mVar = this.f2108j;
        if (mVar != null) {
            mVar.i(geolocatorLocationService);
        }
    }

    private void n() {
        n1.c cVar = this.f2111m;
        if (cVar != null) {
            cVar.a(this.f2103d);
            this.f2111m.b(this.f2102c);
        }
    }

    private void o(Context context) {
        GeolocatorLocationService geolocatorLocationService = this.f2105g;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.h();
        }
        context.unbindService(this.f2109k);
    }

    @Override // m1.a
    public void b(a.b bVar) {
        j jVar = new j(this.f2102c, this.f2103d, this.f2104f);
        this.f2106h = jVar;
        jVar.x(bVar.a(), bVar.b());
        m mVar = new m(this.f2102c, this.f2103d, "flutter.baseflow.com/geolocator_updates_android");
        this.f2107i = mVar;
        mVar.j(bVar.a(), bVar.b());
        m mVar2 = new m(this.f2102c, this.f2103d, "flutter.baseflow.com/geolocator_updates_android_fgn");
        this.f2108j = mVar2;
        mVar2.j(bVar.a(), bVar.b());
        b bVar2 = new b();
        this.f2110l = bVar2;
        bVar2.d(bVar.a());
        this.f2110l.e(bVar.a(), bVar.b());
        g(bVar.a());
    }

    @Override // n1.a
    public void d(n1.c cVar) {
        j(cVar);
    }

    @Override // m1.a
    public void e(a.b bVar) {
        o(bVar.a());
        l();
    }

    @Override // n1.a
    public void h() {
        i();
    }

    @Override // n1.a
    public void i() {
        g1.b.a("FlutterGeolocator", "Detaching Geolocator from activity");
        k();
        j jVar = this.f2106h;
        if (jVar != null) {
            jVar.w(null);
        }
        m mVar = this.f2107i;
        if (mVar != null) {
            mVar.h(null);
        }
        m mVar2 = this.f2108j;
        if (mVar2 != null) {
            mVar2.h(null);
        }
        GeolocatorLocationService geolocatorLocationService = this.f2105g;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.n(null);
        }
        if (this.f2111m != null) {
            this.f2111m = null;
        }
    }

    @Override // n1.a
    public void j(n1.c cVar) {
        g1.b.a("FlutterGeolocator", "Attaching Geolocator to activity");
        this.f2111m = cVar;
        n();
        j jVar = this.f2106h;
        if (jVar != null) {
            jVar.w(cVar.i());
        }
        m mVar = this.f2107i;
        if (mVar != null) {
            mVar.h(cVar.i());
        }
        m mVar2 = this.f2108j;
        if (mVar2 != null) {
            mVar2.h(cVar.i());
        }
        GeolocatorLocationService geolocatorLocationService = this.f2105g;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.n(this.f2111m.i());
        }
    }
}
