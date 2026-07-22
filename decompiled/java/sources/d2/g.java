package d2;

import d2.a;
import java.util.ArrayList;
import java.util.Map;
import u1.b;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class g {
    public static u1.j<Object> a() {
        return a.d.f2452d;
    }

    public static /* synthetic */ void b(a.c cVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, cVar.a((String) ((ArrayList) obj).get(0)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void c(a.c cVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, cVar.e((String) arrayList2.get(0), (Map) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void d(a.c cVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, cVar.b((String) arrayList2.get(0), (Boolean) arrayList2.get(1), (a.e) arrayList2.get(2), (a.C0071a) arrayList2.get(3)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void e(a.c cVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, cVar.c());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void f(a.c cVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            cVar.d();
            arrayList.add(0, null);
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static void g(u1.d dVar, final a.c cVar) {
        u1.b bVar = new u1.b(dVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl", a());
        if (cVar != null) {
            bVar.e(new b.d() { // from class: d2.b
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    g.b(a.c.this, obj, eVar);
                }
            });
        } else {
            bVar.e(null);
        }
        u1.b bVar2 = new u1.b(dVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl", a());
        if (cVar != null) {
            bVar2.e(new b.d() { // from class: d2.c
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    g.c(a.c.this, obj, eVar);
                }
            });
        } else {
            bVar2.e(null);
        }
        u1.b bVar3 = new u1.b(dVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp", a());
        if (cVar != null) {
            bVar3.e(new b.d() { // from class: d2.d
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    g.d(a.c.this, obj, eVar);
                }
            });
        } else {
            bVar3.e(null);
        }
        u1.b bVar4 = new u1.b(dVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs", a());
        if (cVar != null) {
            bVar4.e(new b.d() { // from class: d2.e
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    g.e(a.c.this, obj, eVar);
                }
            });
        } else {
            bVar4.e(null);
        }
        u1.b bVar5 = new u1.b(dVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView", a());
        if (cVar != null) {
            bVar5.e(new b.d() { // from class: d2.f
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    g.f(a.c.this, obj, eVar);
                }
            });
        } else {
            bVar5.e(null);
        }
    }
}
