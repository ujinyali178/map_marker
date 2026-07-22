package u;

import android.util.Log;
import m1.a;

/* loaded from: /root/release/classes.dex */
public final class b implements m1.a {

    /* renamed from: c, reason: collision with root package name */
    private c f4338c;

    /* renamed from: d, reason: collision with root package name */
    private a f4339d;

    @Override // m1.a
    public void b(a.b bVar) {
        a aVar = new a(bVar.a());
        this.f4339d = aVar;
        c cVar = new c(aVar);
        this.f4338c = cVar;
        cVar.f(bVar.b());
    }

    @Override // m1.a
    public void e(a.b bVar) {
        c cVar = this.f4338c;
        if (cVar == null) {
            Log.wtf("GeocodingPlugin", "Already detached from the engine.");
            return;
        }
        cVar.g();
        this.f4338c = null;
        this.f4339d = null;
    }
}
