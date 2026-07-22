package b2;

import b2.a;
import java.util.ArrayList;
import u1.b;
import u1.o;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class i {
    public static u1.j<Object> a() {
        return new o();
    }

    public static /* synthetic */ void b(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.d());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void c(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.i());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void d(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.g());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void e(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.f());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void f(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.c());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void g(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.a());
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void h(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.h(arrayList2.get(0) == null ? null : a.c.values()[((Integer) arrayList2.get(0)).intValue()]));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static void i(u1.d dVar, final a.b bVar) {
        u1.b bVar2 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath", a(), dVar.b());
        if (bVar != null) {
            bVar2.e(new b.d() { // from class: b2.b
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.b(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar2.e(null);
        }
        u1.b bVar3 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath", a(), dVar.b());
        if (bVar != null) {
            bVar3.e(new b.d() { // from class: b2.c
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.c(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar3.e(null);
        }
        u1.b bVar4 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath", a(), dVar.b());
        if (bVar != null) {
            bVar4.e(new b.d() { // from class: b2.d
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.d(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar4.e(null);
        }
        u1.b bVar5 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getApplicationCachePath", a(), dVar.b());
        if (bVar != null) {
            bVar5.e(new b.d() { // from class: b2.e
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.e(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar5.e(null);
        }
        u1.b bVar6 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath", a(), dVar.b());
        if (bVar != null) {
            bVar6.e(new b.d() { // from class: b2.f
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.f(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar6.e(null);
        }
        u1.b bVar7 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths", a(), dVar.b());
        if (bVar != null) {
            bVar7.e(new b.d() { // from class: b2.g
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.g(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar7.e(null);
        }
        u1.b bVar8 = new u1.b(dVar, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths", a(), dVar.b());
        if (bVar != null) {
            bVar8.e(new b.d() { // from class: b2.h
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    i.h(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar8.e(null);
        }
    }
}
