package u;

import android.location.Address;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import u1.d;
import u1.k;
import u1.l;

/* loaded from: /root/release/classes.dex */
final class c implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final u.a f4340c;

    /* renamed from: d, reason: collision with root package name */
    private l f4341d;

    class a implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f4342c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.d f4343d;

        a(k kVar, l.d dVar) {
            this.f4342c = kVar;
            this.f4343d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.c(this.f4342c, this.f4343d);
        }
    }

    class b implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f4345c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l.d f4346d;

        b(k kVar, l.d dVar) {
            this.f4345c = kVar;
            this.f4346d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(this.f4345c, this.f4346d);
        }
    }

    c(u.a aVar) {
        this.f4340c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(k kVar, l.d dVar) {
        String str = (String) kVar.a("address");
        String str2 = (String) kVar.a("localeIdentifier");
        String str3 = (String) kVar.a("targetRegionSLat");
        String str4 = (String) kVar.a("targetRegionNLat");
        String str5 = (String) kVar.a("targetRegionWLng");
        String str6 = (String) kVar.a("targetRegionELng");
        if (str == null || str.isEmpty()) {
            dVar.b("ARGUMENT_ERROR", "Supply a valid value for the 'address' parameter.", null);
        }
        try {
            List<Address> b4 = this.f4340c.b(str, v.c.a(str2), e(str3), e(str5), e(str4), e(str6));
            if (b4 != null && !b4.isEmpty()) {
                dVar.a(v.b.c(b4));
                return;
            }
            dVar.b("NOT_FOUND", String.format("No coordinates found for '%s'", str), null);
        } catch (IOException unused) {
            dVar.b("IO_ERROR", String.format("A network error occurred trying to lookup the address ''.", str), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, l.d dVar) {
        double doubleValue = ((Double) kVar.a("latitude")).doubleValue();
        double doubleValue2 = ((Double) kVar.a("longitude")).doubleValue();
        try {
            List<Address> c3 = this.f4340c.c(doubleValue, doubleValue2, v.c.a((String) kVar.a("localeIdentifier")));
            if (c3 != null && !c3.isEmpty()) {
                dVar.a(v.b.b(c3));
                return;
            }
            dVar.b("NOT_FOUND", String.format("No address information found for supplied coordinates (latitude: %f, longitude: %f).", Double.valueOf(doubleValue), Double.valueOf(doubleValue2)), null);
        } catch (IOException unused) {
            dVar.b("IO_ERROR", String.format("A network error occurred trying to lookup the supplied coordinates (latitude: %f, longitude: %f).", Double.valueOf(doubleValue), Double.valueOf(doubleValue2)), null);
        }
    }

    private static Double e(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    void f(d dVar) {
        if (this.f4341d != null) {
            Log.wtf("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            g();
        }
        l lVar = new l(dVar, "flutter.baseflow.com/geocoding");
        this.f4341d = lVar;
        lVar.e(this);
    }

    void g() {
        l lVar = this.f4341d;
        if (lVar == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no MethodChannel had been initialized.");
        } else {
            lVar.e(null);
            this.f4341d = null;
        }
    }

    @Override // u1.l.c
    public void n(k kVar, l.d dVar) {
        Runnable bVar;
        String str = kVar.f4372a;
        str.hashCode();
        if (str.equals("placemarkFromCoordinates")) {
            bVar = new b(kVar, dVar);
        } else {
            if (!str.equals("locationFromAddress")) {
                dVar.c();
                return;
            }
            bVar = new a(kVar, dVar);
        }
        AsyncTask.execute(bVar);
    }
}
