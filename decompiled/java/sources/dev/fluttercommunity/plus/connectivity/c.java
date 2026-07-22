package dev.fluttercommunity.plus.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import m1.a;
import u1.d;
import u1.e;
import u1.l;

/* loaded from: /root/release/classes.dex */
public class c implements m1.a {

    /* renamed from: c, reason: collision with root package name */
    private l f2474c;

    /* renamed from: d, reason: collision with root package name */
    private e f2475d;

    /* renamed from: f, reason: collision with root package name */
    private ConnectivityBroadcastReceiver f2476f;

    private void a(d dVar, Context context) {
        this.f2474c = new l(dVar, "dev.fluttercommunity.plus/connectivity");
        this.f2475d = new e(dVar, "dev.fluttercommunity.plus/connectivity_status");
        a aVar = new a((ConnectivityManager) context.getSystemService("connectivity"));
        b bVar = new b(aVar);
        this.f2476f = new ConnectivityBroadcastReceiver(context, aVar);
        this.f2474c.e(bVar);
        this.f2475d.d(this.f2476f);
    }

    private void c() {
        this.f2474c.e(null);
        this.f2475d.d(null);
        this.f2476f.a(null);
        this.f2474c = null;
        this.f2475d = null;
        this.f2476f = null;
    }

    @Override // m1.a
    public void b(a.b bVar) {
        a(bVar.b(), bVar.a());
    }

    @Override // m1.a
    public void e(a.b bVar) {
        c();
    }
}
