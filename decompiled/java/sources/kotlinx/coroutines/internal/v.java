package kotlinx.coroutines.internal;

/* loaded from: /root/release/classes2.dex */
public final class v {

    static final class a extends kotlin.jvm.internal.l implements p2.l<Throwable, g2.q> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p2.l<E, g2.q> f3832c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ E f3833d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i2.g f3834f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(p2.l<? super E, g2.q> lVar, E e3, i2.g gVar) {
            super(1);
            this.f3832c = lVar;
            this.f3833d = e3;
            this.f3834f = gVar;
        }

        public final void a(Throwable th) {
            v.b(this.f3832c, this.f3833d, this.f3834f);
        }

        @Override // p2.l
        public /* bridge */ /* synthetic */ g2.q invoke(Throwable th) {
            a(th);
            return g2.q.f2555a;
        }
    }

    public static final <E> p2.l<Throwable, g2.q> a(p2.l<? super E, g2.q> lVar, E e3, i2.g gVar) {
        return new a(lVar, e3, gVar);
    }

    public static final <E> void b(p2.l<? super E, g2.q> lVar, E e3, i2.g gVar) {
        j0 c3 = c(lVar, e3, null);
        if (c3 != null) {
            w2.f0.a(gVar, c3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> j0 c(p2.l<? super E, g2.q> lVar, E e3, j0 j0Var) {
        try {
            lVar.invoke(e3);
        } catch (Throwable th) {
            if (j0Var == null || j0Var.getCause() == th) {
                return new j0("Exception in undelivered element handler for " + e3, th);
            }
            g2.b.a(j0Var, th);
        }
        return j0Var;
    }

    public static /* synthetic */ j0 d(p2.l lVar, Object obj, j0 j0Var, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            j0Var = null;
        }
        return c(lVar, obj, j0Var);
    }
}
