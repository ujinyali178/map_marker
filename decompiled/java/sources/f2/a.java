package f2;

import android.content.Context;
import kotlin.jvm.internal.k;
import m1.a;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class a implements m1.a {

    /* renamed from: c, reason: collision with root package name */
    private l f2525c;

    private final void a(u1.d dVar, Context context) {
        this.f2525c = new l(dVar, "PonnamKarthik/fluttertoast");
        d dVar2 = new d(context);
        l lVar = this.f2525c;
        if (lVar != null) {
            lVar.e(dVar2);
        }
    }

    private final void c() {
        l lVar = this.f2525c;
        if (lVar != null) {
            lVar.e(null);
        }
        this.f2525c = null;
    }

    @Override // m1.a
    public void b(a.b binding) {
        k.e(binding, "binding");
        u1.d b4 = binding.b();
        k.d(b4, "binding.binaryMessenger");
        Context a4 = binding.a();
        k.d(a4, "binding.applicationContext");
        a(b4, a4);
    }

    @Override // m1.a
    public void e(a.b p02) {
        k.e(p02, "p0");
        c();
    }
}
