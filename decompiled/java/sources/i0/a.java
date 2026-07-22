package i0;

import android.location.LocationManager;
import io.flutter.embedding.android.FlutterActivity;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterActivity f2637a;

    /* renamed from: i0.a$a, reason: collision with other inner class name */
    class C0080a implements l.c {
        C0080a() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            if (!kVar.f4372a.equals("getLocationServiceStatus")) {
                dVar.c();
                return;
            }
            LocationManager locationManager = (LocationManager) a.this.f2637a.getSystemService("location");
            int i3 = 0;
            if (locationManager != null) {
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                if (isProviderEnabled && isProviderEnabled2) {
                    i3 = 3;
                } else if (isProviderEnabled2) {
                    i3 = 1;
                } else if (isProviderEnabled) {
                    i3 = 2;
                }
            }
            dVar.a(Integer.valueOf(i3));
        }
    }

    public a(FlutterActivity flutterActivity) {
        this.f2637a = flutterActivity;
    }

    public void b(io.flutter.embedding.engine.a aVar) {
        new l(aVar.k(), "com.exlyo.mapmarker/location_api").e(new C0080a());
    }
}
