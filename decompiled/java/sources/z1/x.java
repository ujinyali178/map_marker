package z1;

import java.util.ArrayList;
import java.util.List;
import u1.b;
import z1.n;
import z1.x;

/* loaded from: /root/release/classes.dex */
public final /* synthetic */ class x {

    class a implements n.e<n.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4897a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4898b;

        a(ArrayList arrayList, b.e eVar) {
            this.f4897a = arrayList;
            this.f4898b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4898b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(n.g gVar) {
            this.f4897a.add(0, gVar);
            this.f4898b.a(this.f4897a);
        }
    }

    class b implements n.e<n.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4899a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4900b;

        b(ArrayList arrayList, b.e eVar) {
            this.f4899a = arrayList;
            this.f4900b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4900b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(n.g gVar) {
            this.f4899a.add(0, gVar);
            this.f4900b.a(this.f4899a);
        }
    }

    class c implements n.e<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4901a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4902b;

        c(ArrayList arrayList, b.e eVar) {
            this.f4901a = arrayList;
            this.f4902b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4902b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            this.f4901a.add(0, str);
            this.f4902b.a(this.f4901a);
        }
    }

    class d implements n.e<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4903a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4904b;

        d(ArrayList arrayList, b.e eVar) {
            this.f4903a = arrayList;
            this.f4904b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4904b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r3) {
            this.f4903a.add(0, null);
            this.f4904b.a(this.f4903a);
        }
    }

    class e implements n.e<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4905a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4906b;

        e(ArrayList arrayList, b.e eVar) {
            this.f4905a = arrayList;
            this.f4906b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4906b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r3) {
            this.f4905a.add(0, null);
            this.f4906b.a(this.f4905a);
        }
    }

    class f implements n.e<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4907a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4908b;

        f(ArrayList arrayList, b.e eVar) {
            this.f4907a = arrayList;
            this.f4908b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4908b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Void r3) {
            this.f4907a.add(0, null);
            this.f4908b.a(this.f4907a);
        }
    }

    class g implements n.e<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4909a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.e f4910b;

        g(ArrayList arrayList, b.e eVar) {
            this.f4909a = arrayList;
            this.f4910b = eVar;
        }

        @Override // z1.n.e
        public void b(Throwable th) {
            this.f4910b.a(n.a(th));
        }

        @Override // z1.n.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            this.f4909a.add(0, bool);
            this.f4910b.a(this.f4909a);
        }
    }

    public static u1.j<Object> a() {
        return n.c.f4865d;
    }

    public static /* synthetic */ void b(n.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            bVar.j((n.d) ((ArrayList) obj).get(0));
            arrayList.add(0, null);
        } catch (Throwable th) {
            arrayList = n.a(th);
        }
        eVar.a(arrayList);
    }

    public static /* synthetic */ void e(n.b bVar, Object obj, b.e eVar) {
        ArrayList arrayList = (ArrayList) obj;
        bVar.g((String) arrayList.get(0), (Boolean) arrayList.get(1), new c(new ArrayList(), eVar));
    }

    public static /* synthetic */ void h(n.b bVar, Object obj, b.e eVar) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, bVar.e());
        } catch (Throwable th) {
            arrayList = n.a(th);
        }
        eVar.a(arrayList);
    }

    public static void k(u1.d dVar, final n.b bVar) {
        u1.b bVar2 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.init", a());
        if (bVar != null) {
            bVar2.e(new b.d() { // from class: z1.o
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    x.b(n.b.this, obj, eVar);
                }
            });
        } else {
            bVar2.e(null);
        }
        u1.b bVar3 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.signInSilently", a());
        if (bVar != null) {
            bVar3.e(new b.d() { // from class: z1.p
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    n.b.this.f(new x.a(new ArrayList(), eVar));
                }
            });
        } else {
            bVar3.e(null);
        }
        u1.b bVar4 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.signIn", a());
        if (bVar != null) {
            bVar4.e(new b.d() { // from class: z1.q
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    n.b.this.i(new x.b(new ArrayList(), eVar));
                }
            });
        } else {
            bVar4.e(null);
        }
        u1.b bVar5 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.getAccessToken", a());
        if (bVar != null) {
            bVar5.e(new b.d() { // from class: z1.r
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    x.e(n.b.this, obj, eVar);
                }
            });
        } else {
            bVar5.e(null);
        }
        u1.b bVar6 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.signOut", a());
        if (bVar != null) {
            bVar6.e(new b.d() { // from class: z1.s
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    n.b.this.h(new x.d(new ArrayList(), eVar));
                }
            });
        } else {
            bVar6.e(null);
        }
        u1.b bVar7 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.disconnect", a());
        if (bVar != null) {
            bVar7.e(new b.d() { // from class: z1.t
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    n.b.this.d(new x.e(new ArrayList(), eVar));
                }
            });
        } else {
            bVar7.e(null);
        }
        u1.b bVar8 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.isSignedIn", a());
        if (bVar != null) {
            bVar8.e(new b.d() { // from class: z1.u
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    x.h(n.b.this, obj, eVar);
                }
            });
        } else {
            bVar8.e(null);
        }
        u1.b bVar9 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.clearAuthCache", a());
        if (bVar != null) {
            bVar9.e(new b.d() { // from class: z1.v
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    n.b.this.c((String) ((ArrayList) obj).get(0), new x.f(new ArrayList(), eVar));
                }
            });
        } else {
            bVar9.e(null);
        }
        u1.b bVar10 = new u1.b(dVar, "dev.flutter.pigeon.GoogleSignInApi.requestScopes", a());
        if (bVar != null) {
            bVar10.e(new b.d() { // from class: z1.w
                @Override // u1.b.d
                public final void a(Object obj, b.e eVar) {
                    n.b.this.b((List) ((ArrayList) obj).get(0), new x.g(new ArrayList(), eVar));
                }
            });
        } else {
            bVar10.e(null);
        }
    }
}
