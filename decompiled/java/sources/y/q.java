package y;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.location.m;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
class q implements p, androidx.core.location.b {

    /* renamed from: a, reason: collision with root package name */
    private final LocationManager f4641a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f4642b;

    /* renamed from: c, reason: collision with root package name */
    private final z f4643c;

    /* renamed from: d, reason: collision with root package name */
    public Context f4644d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4645e = false;

    /* renamed from: f, reason: collision with root package name */
    private Location f4646f;

    /* renamed from: g, reason: collision with root package name */
    private String f4647g;

    /* renamed from: h, reason: collision with root package name */
    private h0 f4648h;

    /* renamed from: i, reason: collision with root package name */
    private x.a f4649i;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4650a;

        static {
            int[] iArr = new int[l.values().length];
            f4650a = iArr;
            try {
                iArr[l.lowest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4650a[l.low.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4650a[l.high.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4650a[l.best.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4650a[l.bestForNavigation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4650a[l.medium.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public q(Context context, z zVar) {
        this.f4641a = (LocationManager) context.getSystemService("location");
        this.f4643c = zVar;
        this.f4644d = context;
        this.f4642b = new g0(context, zVar);
    }

    private static int f(l lVar) {
        int i3 = a.f4650a[lVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return 104;
        }
        return (i3 == 3 || i3 == 4 || i3 == 5) ? 100 : 102;
    }

    private static String h(LocationManager locationManager, l lVar) {
        List<String> providers = locationManager.getProviders(true);
        if (lVar == l.lowest) {
            return "passive";
        }
        if (providers.contains("fused") && Build.VERSION.SDK_INT >= 31) {
            return "fused";
        }
        if (providers.contains("gps")) {
            return "gps";
        }
        if (providers.contains("network")) {
            return "network";
        }
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    static boolean i(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z3 = time > 120000;
        boolean z4 = time < -120000;
        boolean z5 = time > 0;
        if (z3) {
            return true;
        }
        if (z4) {
            return false;
        }
        float accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z6 = accuracy > BitmapDescriptorFactory.HUE_RED;
        boolean z7 = accuracy < BitmapDescriptorFactory.HUE_RED;
        boolean z8 = accuracy > 200.0f;
        boolean equals = location.getProvider() != null ? location.getProvider().equals(location2.getProvider()) : false;
        if (z7) {
            return true;
        }
        if (!z5 || z6) {
            return z5 && !z8 && equals;
        }
        return true;
    }

    @Override // y.p
    public void a(a0 a0Var) {
        a0Var.a(this.f4641a == null ? false : g(this.f4644d));
    }

    @Override // y.p
    public void b(Activity activity, h0 h0Var, x.a aVar) {
        if (!g(this.f4644d)) {
            aVar.a(x.b.locationServicesDisabled);
            return;
        }
        this.f4648h = h0Var;
        this.f4649i = aVar;
        l lVar = l.best;
        long j3 = 0;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        int i3 = 102;
        z zVar = this.f4643c;
        if (zVar != null) {
            f3 = zVar.b();
            lVar = this.f4643c.a();
            j3 = lVar == l.lowest ? Long.MAX_VALUE : this.f4643c.c();
            i3 = f(lVar);
        }
        String h3 = h(this.f4641a, lVar);
        this.f4647g = h3;
        if (h3 == null) {
            aVar.a(x.b.locationServicesDisabled);
            return;
        }
        androidx.core.location.m a4 = new m.c(j3).c(f3).d(j3).e(i3).a();
        this.f4645e = true;
        this.f4642b.h();
        androidx.core.location.c.b(this.f4641a, this.f4647g, a4, this, Looper.getMainLooper());
    }

    @Override // y.p
    public void c(h0 h0Var, x.a aVar) {
        Iterator<String> it = this.f4641a.getProviders(true).iterator();
        Location location = null;
        while (it.hasNext()) {
            Location lastKnownLocation = this.f4641a.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && i(lastKnownLocation, location)) {
                location = lastKnownLocation;
            }
        }
        h0Var.a(location);
    }

    @Override // y.p
    public boolean d(int i3, int i4) {
        return false;
    }

    @Override // y.p
    public void e() {
        this.f4645e = false;
        this.f4642b.i();
        this.f4641a.removeUpdates(this);
    }

    public /* synthetic */ boolean g(Context context) {
        return o.a(this, context);
    }

    @Override // androidx.core.location.b, android.location.LocationListener
    public /* synthetic */ void onFlushComplete(int i3) {
        androidx.core.location.a.a(this, i3);
    }

    @Override // android.location.LocationListener
    public synchronized void onLocationChanged(Location location) {
        if (i(location, this.f4646f)) {
            this.f4646f = location;
            if (this.f4648h != null) {
                this.f4642b.f(location);
                this.f4648h.a(this.f4646f);
            }
        }
    }

    @Override // androidx.core.location.b, android.location.LocationListener
    public /* synthetic */ void onLocationChanged(List list) {
        androidx.core.location.a.b(this, list);
    }

    @Override // androidx.core.location.b, android.location.LocationListener
    public void onProviderDisabled(String str) {
        if (str.equals(this.f4647g)) {
            if (this.f4645e) {
                this.f4641a.removeUpdates(this);
            }
            x.a aVar = this.f4649i;
            if (aVar != null) {
                aVar.a(x.b.locationServicesDisabled);
            }
            this.f4647g = null;
        }
    }

    @Override // androidx.core.location.b, android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // androidx.core.location.b, android.location.LocationListener
    public void onStatusChanged(String str, int i3, Bundle bundle) {
        if (i3 == 2) {
            onProviderEnabled(str);
        } else if (i3 == 0) {
            onProviderDisabled(str);
        }
    }
}
