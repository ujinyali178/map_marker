package y2;

import g2.k;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.v;
import w2.k;
import w2.k0;

/* loaded from: /root/release/classes2.dex */
public abstract class a<E> extends y2.c<E> implements f<E> {

    /* renamed from: y2.a$a, reason: collision with other inner class name */
    private static final class C0113a<E> implements g<E> {

        /* renamed from: a, reason: collision with root package name */
        public final a<E> f4676a;

        /* renamed from: b, reason: collision with root package name */
        private Object f4677b = y2.b.f4686d;

        public C0113a(a<E> aVar) {
            this.f4676a = aVar;
        }

        private final boolean b(Object obj) {
            if (!(obj instanceof j)) {
                return true;
            }
            j jVar = (j) obj;
            if (jVar.f4709g == null) {
                return false;
            }
            throw a0.a(jVar.D());
        }

        private final Object c(i2.d<? super Boolean> dVar) {
            i2.d b4;
            Object c3;
            Object a4;
            b4 = j2.c.b(dVar);
            w2.l a5 = w2.n.a(b4);
            b bVar = new b(this, a5);
            while (true) {
                if (this.f4676a.p(bVar)) {
                    this.f4676a.w(a5, bVar);
                    break;
                }
                Object v3 = this.f4676a.v();
                d(v3);
                if (v3 instanceof j) {
                    j jVar = (j) v3;
                    if (jVar.f4709g == null) {
                        k.a aVar = g2.k.f2549c;
                        a4 = kotlin.coroutines.jvm.internal.b.a(false);
                    } else {
                        k.a aVar2 = g2.k.f2549c;
                        a4 = g2.l.a(jVar.D());
                    }
                    a5.resumeWith(g2.k.a(a4));
                } else if (v3 != y2.b.f4686d) {
                    Boolean a6 = kotlin.coroutines.jvm.internal.b.a(true);
                    p2.l<E, g2.q> lVar = this.f4676a.f4690b;
                    a5.g(a6, lVar != null ? v.a(lVar, v3, a5.getContext()) : null);
                }
            }
            Object v4 = a5.v();
            c3 = j2.d.c();
            if (v4 == c3) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return v4;
        }

        @Override // y2.g
        public Object a(i2.d<? super Boolean> dVar) {
            Object obj = this.f4677b;
            b0 b0Var = y2.b.f4686d;
            if (obj == b0Var) {
                obj = this.f4676a.v();
                this.f4677b = obj;
                if (obj == b0Var) {
                    return c(dVar);
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(b(obj));
        }

        public final void d(Object obj) {
            this.f4677b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // y2.g
        public E next() {
            E e3 = (E) this.f4677b;
            if (e3 instanceof j) {
                throw a0.a(((j) e3).D());
            }
            b0 b0Var = y2.b.f4686d;
            if (e3 == b0Var) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.f4677b = b0Var;
            return e3;
        }
    }

    private static class b<E> extends o<E> {

        /* renamed from: g, reason: collision with root package name */
        public final C0113a<E> f4678g;

        /* renamed from: h, reason: collision with root package name */
        public final w2.k<Boolean> f4679h;

        /* JADX WARN: Multi-variable type inference failed */
        public b(C0113a<E> c0113a, w2.k<? super Boolean> kVar) {
            this.f4678g = c0113a;
            this.f4679h = kVar;
        }

        @Override // y2.q
        public void f(E e3) {
            this.f4678g.d(e3);
            this.f4679h.w(w2.m.f4486a);
        }

        @Override // y2.q
        public b0 g(E e3, o.b bVar) {
            if (this.f4679h.e(Boolean.TRUE, null, z(e3)) == null) {
                return null;
            }
            return w2.m.f4486a;
        }

        @Override // kotlinx.coroutines.internal.o
        public String toString() {
            return "ReceiveHasNext@" + k0.b(this);
        }

        @Override // y2.o
        public void y(j<?> jVar) {
            Object a4 = jVar.f4709g == null ? k.a.a(this.f4679h, Boolean.FALSE, null, 2, null) : this.f4679h.m(jVar.D());
            if (a4 != null) {
                this.f4678g.d(jVar);
                this.f4679h.w(a4);
            }
        }

        public p2.l<Throwable, g2.q> z(E e3) {
            p2.l<E, g2.q> lVar = this.f4678g.f4676a.f4690b;
            if (lVar != null) {
                return v.a(lVar, e3, this.f4679h.getContext());
            }
            return null;
        }
    }

    private final class c extends w2.e {

        /* renamed from: c, reason: collision with root package name */
        private final o<?> f4680c;

        public c(o<?> oVar) {
            this.f4680c = oVar;
        }

        @Override // w2.j
        public void a(Throwable th) {
            if (this.f4680c.t()) {
                a.this.t();
            }
        }

        @Override // p2.l
        public /* bridge */ /* synthetic */ g2.q invoke(Throwable th) {
            a(th);
            return g2.q.f2555a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f4680c + ']';
        }
    }

    public static final class d extends o.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f4682d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.o oVar, a aVar) {
            super(oVar);
            this.f4682d = aVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.o oVar) {
            if (this.f4682d.s()) {
                return null;
            }
            return kotlinx.coroutines.internal.n.a();
        }
    }

    public a(p2.l<? super E, g2.q> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(o<? super E> oVar) {
        boolean q3 = q(oVar);
        if (q3) {
            u();
        }
        return q3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(w2.k<?> kVar, o<?> oVar) {
        kVar.n(new c(oVar));
    }

    @Override // y2.p
    public final g<E> iterator() {
        return new C0113a(this);
    }

    @Override // y2.c
    protected q<E> l() {
        q<E> l3 = super.l();
        if (l3 != null && !(l3 instanceof j)) {
            t();
        }
        return l3;
    }

    protected boolean q(o<? super E> oVar) {
        int w3;
        kotlinx.coroutines.internal.o p3;
        if (!r()) {
            kotlinx.coroutines.internal.o e3 = e();
            d dVar = new d(oVar, this);
            do {
                kotlinx.coroutines.internal.o p4 = e3.p();
                if (!(!(p4 instanceof s))) {
                    return false;
                }
                w3 = p4.w(oVar, e3, dVar);
                if (w3 != 1) {
                }
            } while (w3 != 2);
            return false;
        }
        kotlinx.coroutines.internal.o e4 = e();
        do {
            p3 = e4.p();
            if (!(!(p3 instanceof s))) {
                return false;
            }
        } while (!p3.i(oVar, e4));
        return true;
    }

    protected abstract boolean r();

    protected abstract boolean s();

    protected void t() {
    }

    protected void u() {
    }

    protected Object v() {
        while (true) {
            s m3 = m();
            if (m3 == null) {
                return y2.b.f4686d;
            }
            if (m3.z(null) != null) {
                m3.x();
                return m3.y();
            }
            m3.A();
        }
    }
}
