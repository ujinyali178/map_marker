package d0;

import android.content.Context;
import m1.a;
import u1.d;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class a implements m1.a {

    /* renamed from: c, reason: collision with root package name */
    private l f2444c;

    private void a(d dVar, Context context) {
        this.f2444c = new l(dVar, "flutter_native_image");
        this.f2444c.e(new b(context));
    }

    private void c() {
        this.f2444c.e(null);
        this.f2444c = null;
    }

    @Override // m1.a
    public void b(a.b bVar) {
        a(bVar.c().k(), bVar.a());
    }

    @Override // m1.a
    public void e(a.b bVar) {
        c();
    }
}
