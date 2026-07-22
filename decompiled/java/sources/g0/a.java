package g0;

import com.google.android.gms.common.GoogleApiAvailability;
import io.flutter.embedding.android.FlutterActivity;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterActivity f2533a;

    /* renamed from: g0.a$a, reason: collision with other inner class name */
    class C0074a implements l.c {
        C0074a() {
        }

        @Override // u1.l.c
        public void n(k kVar, l.d dVar) {
            if (kVar.f4372a.equals("areGooglePlayServicesAvailable")) {
                dVar.a(Boolean.valueOf(a.this.b()));
            } else {
                dVar.c();
            }
        }
    }

    public a(FlutterActivity flutterActivity) {
        this.f2533a = flutterActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.f2533a) == 0;
    }

    public void c(io.flutter.embedding.engine.a aVar) {
        new l(aVar.k(), "com.exlyo.mapmarker/google_play_services_api").e(new C0074a());
    }
}
