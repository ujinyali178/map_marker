package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.p;
import java.util.ArrayList;
import java.util.List;
import u1.b;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class u {

    class a implements p.j<List<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f3453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f3454b;

        a(ArrayList arrayList, b.e eVar) {
            this.f3453a = arrayList;
            this.f3454b = eVar;
        }

        @Override // io.flutter.plugins.imagepicker.p.j
        public void b(Throwable th) {
            this.f3454b.a(p.a(th));
        }

        @Override // io.flutter.plugins.imagepicker.p.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(List<String> list) {
            this.f3453a.add(0, list);
            this.f3454b.a(this.f3453a);
        }
    }

    class b implements p.j<List<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f3455a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f3456b;

        b(ArrayList arrayList, b.e eVar) {
            this.f3455a = arrayList;
            this.f3456b = eVar;
        }

        @Override // io.flutter.plugins.imagepicker.p.j
        public void b(Throwable th) {
            this.f3456b.a(p.a(th));
        }

        @Override // io.flutter.plugins.imagepicker.p.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(List<String> list) {
            this.f3455a.add(0, list);
            this.f3456b.a(this.f3455a);
        }
    }

    class c implements p.j<List<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f3457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f3458b;

        c(ArrayList arrayList, b.e eVar) {
            this.f3457a = arrayList;
            this.f3458b = eVar;
        }

        @Override // io.flutter.plugins.imagepicker.p.j
        public void b(Throwable th) {
            this.f3458b.a(p.a(th));
        }

        @Override // io.flutter.plugins.imagepicker.p.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(List<String> list) {
            this.f3457a.add(0, list);
            this.f3458b.a(this.f3457a);
        }
    }

    public static u1.j<Object> a() {
        return p.g.f3433d;
    }

    public static /* synthetic */ void b(p.f fVar, Object obj, b.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        fVar.c((p.l) arrayList.get(0), (p.h) arrayList.get(1), (p.e) arrayList.get(2), new a(new ArrayList(), eVar));
    }

    public static /* synthetic */ void c(p.f fVar, Object obj, b.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        fVar.f((p.l) arrayList.get(0), (p.n) arrayList.get(1), (p.e) arrayList.get(2), new b(new ArrayList(), eVar));
    }

    public static /* synthetic */ void d(p.f fVar, Object obj, b.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        fVar.a((p.i) arrayList.get(0), (p.e) arrayList.get(1), new c(new ArrayList(), eVar));
    }

    public static /* synthetic */ void e(p.f fVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, fVar.g());
        } catch (Throwable th) {
            arrayList = p.a(th);
        }
        eVar.a(arrayList);
    }

    public static void f(u1.d dVar, final p.f fVar) {
        u1.b bVar = new u1.b(dVar, "dev.flutter.pigeon.ImagePickerApi.pickImages", a(), dVar.b());
        if (fVar != null) {
            bVar.e(new b.d() { // from class: io.flutter.plugins.imagepicker.q
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    u.b(p.f.this, obj, eVar);
                }
            });
        } else {
            bVar.e(null);
        }
        u1.b bVar2 = new u1.b(dVar, "dev.flutter.pigeon.ImagePickerApi.pickVideos", a(), dVar.b());
        if (fVar != null) {
            bVar2.e(new b.d() { // from class: io.flutter.plugins.imagepicker.r
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    u.c(p.f.this, obj, eVar);
                }
            });
        } else {
            bVar2.e(null);
        }
        u1.b bVar3 = new u1.b(dVar, "dev.flutter.pigeon.ImagePickerApi.pickMedia", a());
        if (fVar != null) {
            bVar3.e(new b.d() { // from class: io.flutter.plugins.imagepicker.s
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    u.d(p.f.this, obj, eVar);
                }
            });
        } else {
            bVar3.e(null);
        }
        u1.b bVar4 = new u1.b(dVar, "dev.flutter.pigeon.ImagePickerApi.retrieveLostResults", a(), dVar.b());
        if (fVar != null) {
            bVar4.e(new b.d() { // from class: io.flutter.plugins.imagepicker.t
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    u.e(p.f.this, obj, eVar);
                }
            });
        } else {
            bVar4.e(null);
        }
    }
}
