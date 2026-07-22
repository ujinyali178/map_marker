package com.baseflow.geolocator;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import com.baseflow.geolocator.GeolocatorLocationService;
import u1.e;
import y.h0;
import y.p;
import y.y;
import y.z;

/* loaded from: /root/release/classes.dex */
public class GeolocatorLocationService extends Service {

    /* renamed from: l, reason: collision with root package name */
    private p f2096l;

    /* renamed from: c, reason: collision with root package name */
    private final String f2088c = "GeolocatorLocationService:Wakelock";

    /* renamed from: d, reason: collision with root package name */
    private final String f2089d = "GeolocatorLocationService:WifiLock";

    /* renamed from: f, reason: collision with root package name */
    private final a f2090f = new a(this);

    /* renamed from: g, reason: collision with root package name */
    private boolean f2091g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f2092h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f2093i = 0;

    /* renamed from: j, reason: collision with root package name */
    private Activity f2094j = null;

    /* renamed from: k, reason: collision with root package name */
    private y.k f2095k = null;

    /* renamed from: m, reason: collision with root package name */
    private PowerManager.WakeLock f2097m = null;

    /* renamed from: n, reason: collision with root package name */
    private WifiManager.WifiLock f2098n = null;

    /* renamed from: o, reason: collision with root package name */
    private y.b f2099o = null;

    class a extends Binder {

        /* renamed from: c, reason: collision with root package name */
        private final GeolocatorLocationService f2100c;

        a(GeolocatorLocationService geolocatorLocationService) {
            this.f2100c = geolocatorLocationService;
        }

        public GeolocatorLocationService a() {
            return this.f2100c;
        }
    }

    private int i() {
        return Build.VERSION.SDK_INT < 29 ? 3 : 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(e.b bVar, Location location) {
        bVar.a(y.b(location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(e.b bVar, x.b bVar2) {
        bVar.b(bVar2.toString(), bVar2.b(), null);
    }

    private void l(y.d dVar) {
        WifiManager wifiManager;
        PowerManager powerManager;
        m();
        if (dVar.f() && (powerManager = (PowerManager) getApplicationContext().getSystemService("power")) != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "GeolocatorLocationService:Wakelock");
            this.f2097m = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            this.f2097m.acquire();
        }
        if (!dVar.g() || (wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi")) == null) {
            return;
        }
        WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(i(), "GeolocatorLocationService:WifiLock");
        this.f2098n = createWifiLock;
        createWifiLock.setReferenceCounted(false);
        this.f2098n.acquire();
    }

    private void m() {
        PowerManager.WakeLock wakeLock = this.f2097m;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f2097m.release();
            this.f2097m = null;
        }
        WifiManager.WifiLock wifiLock = this.f2098n;
        if (wifiLock == null || !wifiLock.isHeld()) {
            return;
        }
        this.f2098n.release();
        this.f2098n = null;
    }

    public boolean c(boolean z3) {
        return z3 ? this.f2093i == 1 : this.f2092h == 0;
    }

    public void d(y.d dVar) {
        y.b bVar = this.f2099o;
        if (bVar != null) {
            bVar.f(dVar, this.f2091g);
            l(dVar);
        }
    }

    public void e() {
        if (this.f2091g) {
            Log.d("FlutterGeolocator", "Stop service in foreground.");
            if (Build.VERSION.SDK_INT >= 24) {
                stopForeground(1);
            } else {
                stopForeground(true);
            }
            m();
            this.f2091g = false;
            this.f2099o = null;
        }
    }

    public void f(y.d dVar) {
        if (this.f2099o != null) {
            Log.d("FlutterGeolocator", "Service already in foreground mode.");
            d(dVar);
        } else {
            Log.d("FlutterGeolocator", "Start service in foreground mode.");
            y.b bVar = new y.b(getApplicationContext(), "geolocator_channel_01", 75415, dVar);
            this.f2099o = bVar;
            bVar.d(dVar.b());
            startForeground(75415, this.f2099o.a());
            this.f2091g = true;
        }
        l(dVar);
    }

    public void g() {
        this.f2092h++;
        Log.d("FlutterGeolocator", "Flutter engine connected. Connected engine count " + this.f2092h);
    }

    public void h() {
        this.f2092h--;
        Log.d("FlutterGeolocator", "Flutter engine disconnected. Connected engine count " + this.f2092h);
    }

    public void n(Activity activity) {
        this.f2094j = activity;
    }

    public void o(y.k kVar) {
        this.f2095k = kVar;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("FlutterGeolocator", "Binding to location service.");
        return this.f2090f;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("FlutterGeolocator", "Creating service.");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("FlutterGeolocator", "Destroying location service.");
        q();
        e();
        this.f2095k = null;
        this.f2099o = null;
        Log.d("FlutterGeolocator", "Destroyed location service.");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("FlutterGeolocator", "Unbinding from location service.");
        return super.onUnbind(intent);
    }

    public void p(boolean z3, z zVar, final e.b bVar) {
        this.f2093i++;
        y.k kVar = this.f2095k;
        if (kVar != null) {
            p b4 = kVar.b(getApplicationContext(), Boolean.TRUE.equals(Boolean.valueOf(z3)), zVar);
            this.f2096l = b4;
            this.f2095k.f(b4, this.f2094j, new h0() { // from class: w.a
                @Override // y.h0
                public final void a(Location location) {
                    GeolocatorLocationService.j(e.b.this, location);
                }
            }, new x.a() { // from class: w.b
                @Override // x.a
                public final void a(x.b bVar2) {
                    GeolocatorLocationService.k(e.b.this, bVar2);
                }
            });
        }
    }

    public void q() {
        y.k kVar;
        this.f2093i--;
        Log.d("FlutterGeolocator", "Stopping location service.");
        p pVar = this.f2096l;
        if (pVar == null || (kVar = this.f2095k) == null) {
            return;
        }
        kVar.g(pVar);
    }
}
