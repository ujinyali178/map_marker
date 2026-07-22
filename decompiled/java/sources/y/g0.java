package y;

import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import java.util.Calendar;

/* loaded from: /root/release/classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4601a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f4602b;

    /* renamed from: c, reason: collision with root package name */
    private final z f4603c;

    /* renamed from: d, reason: collision with root package name */
    private OnNmeaMessageListener f4604d;

    /* renamed from: e, reason: collision with root package name */
    private GnssStatus.Callback f4605e;

    /* renamed from: f, reason: collision with root package name */
    private String f4606f;

    /* renamed from: g, reason: collision with root package name */
    private double f4607g;

    /* renamed from: h, reason: collision with root package name */
    private double f4608h;

    /* renamed from: i, reason: collision with root package name */
    private Calendar f4609i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4610j = false;

    class a extends GnssStatus.Callback {
        a() {
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            g0.this.f4607g = gnssStatus.getSatelliteCount();
            g0.this.f4608h = 0.0d;
            for (int i3 = 0; i3 < g0.this.f4607g; i3++) {
                if (gnssStatus.usedInFix(i3)) {
                    g0.e(g0.this);
                }
            }
        }
    }

    public g0(Context context, z zVar) {
        this.f4601a = context;
        this.f4603c = zVar;
        this.f4602b = (LocationManager) context.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 24) {
            this.f4604d = new OnNmeaMessageListener() { // from class: y.f0
                public final void onNmeaMessage(String str, long j3) {
                    g0.this.g(str, j3);
                }
            };
            this.f4605e = new a();
        }
    }

    static /* synthetic */ double e(g0 g0Var) {
        double d3 = g0Var.f4608h + 1.0d;
        g0Var.f4608h = d3;
        return d3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, long j3) {
        if (str.startsWith("$GPGGA")) {
            this.f4606f = str;
            this.f4609i = Calendar.getInstance();
        }
    }

    public void f(Location location) {
        if (location == null) {
            return;
        }
        if (location.getExtras() == null) {
            location.setExtras(Bundle.EMPTY);
        }
        location.getExtras().putDouble("geolocator_mslSatelliteCount", this.f4607g);
        location.getExtras().putDouble("geolocator_mslSatellitesUsedInFix", this.f4608h);
        if (this.f4606f == null || this.f4603c == null || !this.f4610j) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, -5);
        Calendar calendar2 = this.f4609i;
        if ((calendar2 == null || !calendar2.before(calendar)) && this.f4603c.d()) {
            String[] split = this.f4606f.split(",");
            if (!split[0].startsWith("$GPGGA") || split.length <= 9 || split[9].isEmpty()) {
                return;
            }
            double parseDouble = Double.parseDouble(split[9]);
            if (location.getExtras() == null) {
                location.setExtras(Bundle.EMPTY);
            }
            location.getExtras().putDouble("geolocator_mslAltitude", parseDouble);
        }
    }

    public void h() {
        z zVar;
        LocationManager locationManager;
        if (this.f4610j || (zVar = this.f4603c) == null || !zVar.d() || Build.VERSION.SDK_INT < 24 || (locationManager = this.f4602b) == null) {
            return;
        }
        locationManager.addNmeaListener(this.f4604d, (Handler) null);
        this.f4602b.registerGnssStatusCallback(this.f4605e, (Handler) null);
        this.f4610j = true;
    }

    public void i() {
        LocationManager locationManager;
        z zVar = this.f4603c;
        if (zVar == null || !zVar.d() || Build.VERSION.SDK_INT < 24 || (locationManager = this.f4602b) == null) {
            return;
        }
        locationManager.removeNmeaListener(this.f4604d);
        this.f4602b.unregisterGnssStatusCallback(this.f4605e);
        this.f4610j = false;
    }
}
