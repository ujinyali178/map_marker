package c2;

import c2.a;
import java.util.ArrayList;
import java.util.List;
import u1.b;
import u1.o;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class j {
    public static u1.j<Object> a() {
        return new o();
    }

    public static /* synthetic */ void b(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.remove((String) ((ArrayList) obj).get(0)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void c(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.h((String) arrayList2.get(0), (Boolean) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void d(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.g((String) arrayList2.get(0), (String) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void e(a.b bVar, Object obj, b.e eVar) {
        Long valueOf;
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        String str = (String) arrayList2.get(0);
        Number number = (Number) arrayList2.get(1);
        if (number == null) {
            valueOf = null;
        } else {
            try {
                valueOf = Long.valueOf(number.longValue());
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
        }
        arrayList.add(0, bVar.f(str, valueOf));
        eVar.a(arrayList);
    }

    public static /* synthetic */ void f(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.i((String) arrayList2.get(0), (Double) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void g(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.d((String) arrayList2.get(0), (List) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void h(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.c((String) arrayList2.get(0), (List) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void i(a.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, bVar.a((String) arrayList2.get(0), (List) arrayList2.get(1)));
        } catch (Throwable th) {
            arrayList = a.a(th);
        }
        eVar.a(arrayList);
    }

    public static void j(u1.d dVar, final a.b bVar) {
        u1.b bVar2 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.remove", a(), dVar.b());
        if (bVar != null) {
            bVar2.e(new b.d() { // from class: c2.b
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.b(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar2.e(null);
        }
        u1.b bVar3 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.setBool", a(), dVar.b());
        if (bVar != null) {
            bVar3.e(new b.d() { // from class: c2.c
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.c(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar3.e(null);
        }
        u1.b bVar4 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.setString", a(), dVar.b());
        if (bVar != null) {
            bVar4.e(new b.d() { // from class: c2.d
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.d(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar4.e(null);
        }
        u1.b bVar5 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.setInt", a(), dVar.b());
        if (bVar != null) {
            bVar5.e(new b.d() { // from class: c2.e
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.e(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar5.e(null);
        }
        u1.b bVar6 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.setDouble", a(), dVar.b());
        if (bVar != null) {
            bVar6.e(new b.d() { // from class: c2.f
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.f(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar6.e(null);
        }
        u1.b bVar7 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.setStringList", a(), dVar.b());
        if (bVar != null) {
            bVar7.e(new b.d() { // from class: c2.g
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.g(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar7.e(null);
        }
        u1.b bVar8 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.clear", a(), dVar.b());
        if (bVar != null) {
            bVar8.e(new b.d() { // from class: c2.h
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.h(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar8.e(null);
        }
        u1.b bVar9 = new u1.b(dVar, "dev.flutter.pigeon.SharedPreferencesApi.getAll", a(), dVar.b());
        if (bVar != null) {
            bVar9.e(new b.d() { // from class: c2.i
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    j.i(a.b.this, obj, eVar);
                }
            });
        } else {
            bVar9.e(null);
        }
    }
}
