package e1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.k;
import m1.a;
import u1.d;
import u1.l;

/* loaded from: /root/release/classes.dex */
public final class a implements m1.a {

    /* renamed from: c, reason: collision with root package name */
    private l f2482c;

    private final void a(d dVar, Context context) {
        this.f2482c = new l(dVar, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = context.getPackageManager();
        k.d(packageManager, "context.packageManager");
        Object systemService = context.getSystemService("activity");
        k.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        c cVar = new c(packageManager, (ActivityManager) systemService);
        l lVar = this.f2482c;
        if (lVar == null) {
            k.o("methodChannel");
            lVar = null;
        }
        lVar.e(cVar);
    }

    @Override // m1.a
    public void b(a.b binding) {
        k.e(binding, "binding");
        d b4 = binding.b();
        k.d(b4, "binding.binaryMessenger");
        Context a4 = binding.a();
        k.d(a4, "binding.applicationContext");
        a(b4, a4);
    }

    @Override // m1.a
    public void e(a.b binding) {
        k.e(binding, "binding");
        l lVar = this.f2482c;
        if (lVar == null) {
            k.o("methodChannel");
            lVar = null;
        }
        lVar.e(null);
    }
}
