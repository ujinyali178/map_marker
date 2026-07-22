package com.baseflow.geolocator;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import u1.l;
import y.h0;
import y.n;
import y.p;
import y.y;
import y.z;

/* loaded from: /root/release/classes.dex */
class j implements l.c {

    /* renamed from: c, reason: collision with root package name */
    private final z.b f2131c;

    /* renamed from: d, reason: collision with root package name */
    private final y.k f2132d;

    /* renamed from: f, reason: collision with root package name */
    private final y.m f2133f;

    /* renamed from: g, reason: collision with root package name */
    final Map<String, p> f2134g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private Context f2135h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f2136i;

    /* renamed from: j, reason: collision with root package name */
    private u1.l f2137j;

    j(z.b bVar, y.k kVar, y.m mVar) {
        this.f2131c = bVar;
        this.f2132d = kVar;
        this.f2133f = mVar;
    }

    private void h(final l.d dVar, Context context) {
        n a4 = this.f2133f.a(context, new x.a() { // from class: com.baseflow.geolocator.e
            @Override // x.a
            public final void a(x.b bVar) {
                j.i(l.d.this, bVar);
            }
        });
        if (a4 != null) {
            dVar.a(Integer.valueOf(a4.ordinal()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(l.d dVar, x.b bVar) {
        dVar.b(bVar.toString(), bVar.b(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(boolean[] zArr, p pVar, String str, l.d dVar, Location location) {
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        this.f2132d.g(pVar);
        this.f2134g.remove(str);
        dVar.a(y.b(location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(boolean[] zArr, p pVar, String str, l.d dVar, x.b bVar) {
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        this.f2132d.g(pVar);
        this.f2134g.remove(str);
        dVar.b(bVar.toString(), bVar.b(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(l.d dVar, Location location) {
        dVar.a(y.b(location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(l.d dVar, x.b bVar) {
        dVar.b(bVar.toString(), bVar.b(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(l.d dVar, z.a aVar) {
        dVar.a(Integer.valueOf(aVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(l.d dVar, x.b bVar) {
        dVar.b(bVar.toString(), bVar.b(), null);
    }

    private void q(u1.k kVar, l.d dVar) {
        String str = (String) ((Map) kVar.f4373b).get("requestId");
        p pVar = this.f2134g.get(str);
        if (pVar != null) {
            pVar.e();
        }
        this.f2134g.remove(str);
        dVar.a(null);
    }

    private void r(l.d dVar) {
        try {
            dVar.a(Integer.valueOf(this.f2131c.a(this.f2135h).b()));
        } catch (x.c unused) {
            x.b bVar = x.b.permissionDefinitionsNotFound;
            dVar.b(bVar.toString(), bVar.b(), null);
        }
    }

    private void s(u1.k kVar, final l.d dVar) {
        try {
            if (!this.f2131c.d(this.f2135h)) {
                x.b bVar = x.b.permissionDenied;
                dVar.b(bVar.toString(), bVar.b(), null);
                return;
            }
            Map map = (Map) kVar.f4373b;
            boolean booleanValue = map.get("forceLocationManager") != null ? ((Boolean) map.get("forceLocationManager")).booleanValue() : false;
            z e3 = z.e(map);
            final String str = (String) map.get("requestId");
            final boolean[] zArr = {false};
            final p b4 = this.f2132d.b(this.f2135h, booleanValue, e3);
            this.f2134g.put(str, b4);
            this.f2132d.f(b4, this.f2136i, new h0() { // from class: com.baseflow.geolocator.h
                @Override // y.h0
                public final void a(Location location) {
                    j.this.j(zArr, b4, str, dVar, location);
                }
            }, new x.a() { // from class: com.baseflow.geolocator.i
                @Override // x.a
                public final void a(x.b bVar2) {
                    j.this.k(zArr, b4, str, dVar, bVar2);
                }
            });
        } catch (x.c unused) {
            x.b bVar2 = x.b.permissionDefinitionsNotFound;
            dVar.b(bVar2.toString(), bVar2.b(), null);
        }
    }

    private void t(u1.k kVar, final l.d dVar) {
        try {
            if (this.f2131c.d(this.f2135h)) {
                Boolean bool = (Boolean) kVar.a("forceLocationManager");
                this.f2132d.c(this.f2135h, bool != null && bool.booleanValue(), new h0() { // from class: com.baseflow.geolocator.c
                    @Override // y.h0
                    public final void a(Location location) {
                        j.l(l.d.this, location);
                    }
                }, new x.a() { // from class: com.baseflow.geolocator.d
                    @Override // x.a
                    public final void a(x.b bVar) {
                        j.m(l.d.this, bVar);
                    }
                });
            } else {
                x.b bVar = x.b.permissionDenied;
                dVar.b(bVar.toString(), bVar.b(), null);
            }
        } catch (x.c unused) {
            x.b bVar2 = x.b.permissionDefinitionsNotFound;
            dVar.b(bVar2.toString(), bVar2.b(), null);
        }
    }

    private void u(l.d dVar) {
        this.f2132d.e(this.f2135h, new y.c(dVar));
    }

    private void v(final l.d dVar) {
        try {
            this.f2131c.f(this.f2136i, new z.c() { // from class: com.baseflow.geolocator.f
                @Override // z.c
                public final void a(z.a aVar) {
                    j.o(l.d.this, aVar);
                }
            }, new x.a() { // from class: com.baseflow.geolocator.g
                @Override // x.a
                public final void a(x.b bVar) {
                    j.p(l.d.this, bVar);
                }
            });
        } catch (x.c unused) {
            x.b bVar = x.b.permissionDefinitionsNotFound;
            dVar.b(bVar.toString(), bVar.b(), null);
        }
    }

    @Override // u1.l.c
    public void n(u1.k kVar, l.d dVar) {
        boolean b4;
        String str = kVar.f4372a;
        str.hashCode();
        switch (str) {
            case "getCurrentPosition":
                s(kVar, dVar);
                return;
            case "getLastKnownPosition":
                t(kVar, dVar);
                return;
            case "openLocationSettings":
                b4 = a0.a.b(this.f2135h);
                break;
            case "openAppSettings":
                b4 = a0.a.a(this.f2135h);
                break;
            case "isLocationServiceEnabled":
                u(dVar);
                return;
            case "checkPermission":
                r(dVar);
                return;
            case "requestPermission":
                v(dVar);
                return;
            case "getLocationAccuracy":
                h(dVar, this.f2135h);
                return;
            case "cancelGetCurrentPosition":
                q(kVar, dVar);
                return;
            default:
                dVar.c();
                return;
        }
        dVar.a(Boolean.valueOf(b4));
    }

    void w(Activity activity) {
        this.f2136i = activity;
    }

    void x(Context context, u1.d dVar) {
        if (this.f2137j != null) {
            Log.w("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            y();
        }
        u1.l lVar = new u1.l(dVar, "flutter.baseflow.com/geolocator_android");
        this.f2137j = lVar;
        lVar.e(this);
        this.f2135h = context;
    }

    void y() {
        u1.l lVar = this.f2137j;
        if (lVar == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no MethodChannel had been initialized.");
        } else {
            lVar.e(null);
            this.f2137j = null;
        }
    }
}
