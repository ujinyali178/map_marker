package w2;

import i2.g;

/* loaded from: /root/release/classes2.dex */
public final class b0 {

    static final class a extends kotlin.jvm.internal.l implements p2.p<i2.g, g.b, i2.g> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f4444c = new a();

        a() {
            super(2);
        }

        @Override // p2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i2.g invoke(i2.g gVar, g.b bVar) {
            return bVar instanceof a0 ? gVar.f(((a0) bVar).q()) : gVar.f(bVar);
        }
    }

    static final class b extends kotlin.jvm.internal.l implements p2.p<i2.g, g.b, i2.g> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.q<i2.g> f4445c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f4446d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.q<i2.g> qVar, boolean z3) {
            super(2);
            this.f4445c = qVar;
            this.f4446d = z3;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, i2.g] */
        @Override // p2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i2.g invoke(i2.g gVar, g.b bVar) {
            if (!(bVar instanceof a0)) {
                return gVar.f(bVar);
            }
            g.b a4 = this.f4445c.f3768c.a(bVar.getKey());
            if (a4 != null) {
                kotlin.jvm.internal.q<i2.g> qVar = this.f4445c;
                qVar.f3768c = qVar.f3768c.k(bVar.getKey());
                return gVar.f(((a0) bVar).r(a4));
            }
            a0 a0Var = (a0) bVar;
            if (this.f4446d) {
                a0Var = a0Var.q();
            }
            return gVar.f(a0Var);
        }
    }

    static final class c extends kotlin.jvm.internal.l implements p2.p<Boolean, g.b, Boolean> {

        /* renamed from: c, reason: collision with root package name */
        public static final c f4447c = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z3, g.b bVar) {
            return Boolean.valueOf(z3 || (bVar instanceof a0));
        }

        @Override // p2.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, g.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final i2.g a(i2.g gVar, i2.g gVar2, boolean z3) {
        boolean c3 = c(gVar);
        boolean c4 = c(gVar2);
        if (!c3 && !c4) {
            return gVar.f(gVar2);
        }
        kotlin.jvm.internal.q qVar = new kotlin.jvm.internal.q();
        qVar.f3768c = gVar2;
        i2.h hVar = i2.h.f2693c;
        i2.g gVar3 = (i2.g) gVar.x(hVar, new b(qVar, z3));
        if (c4) {
            qVar.f3768c = ((i2.g) qVar.f3768c).x(hVar, a.f4444c);
        }
        return gVar3.f((i2.g) qVar.f3768c);
    }

    public static final String b(i2.g gVar) {
        return null;
    }

    private static final boolean c(i2.g gVar) {
        return ((Boolean) gVar.x(Boolean.FALSE, c.f4447c)).booleanValue();
    }

    public static final i2.g d(i2.g gVar, i2.g gVar2) {
        return !c(gVar2) ? gVar.f(gVar2) : a(gVar, gVar2, false);
    }

    public static final i2.g e(g0 g0Var, i2.g gVar) {
        i2.g a4 = a(g0Var.p(), gVar, true);
        return (a4 == t0.a() || a4.a(i2.e.f2690a) != null) ? a4 : a4.f(t0.a());
    }

    public static final e2<?> f(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof p0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof e2) {
                return (e2) eVar;
            }
        }
        return null;
    }

    public static final e2<?> g(i2.d<?> dVar, i2.g gVar, Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (!(gVar.a(f2.f4463c) != null)) {
            return null;
        }
        e2<?> f3 = f((kotlin.coroutines.jvm.internal.e) dVar);
        if (f3 != null) {
            f3.E0(gVar, obj);
        }
        return f3;
    }
}
