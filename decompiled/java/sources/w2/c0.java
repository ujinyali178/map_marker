package w2;

import i2.e;
import i2.g;

/* loaded from: /root/release/classes2.dex */
public abstract class c0 extends i2.a implements i2.e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4448d = new a(null);

    public static final class a extends i2.b<i2.e, c0> {

        /* renamed from: w2.c0$a$a, reason: collision with other inner class name */
        static final class C0111a extends kotlin.jvm.internal.l implements p2.l<g.b, c0> {

            /* renamed from: c, reason: collision with root package name */
            public static final C0111a f4449c = new C0111a();

            C0111a() {
                super(1);
            }

            @Override // p2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c0 invoke(g.b bVar) {
                if (bVar instanceof c0) {
                    return (c0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(i2.e.f2690a, C0111a.f4449c);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public c0() {
        super(i2.e.f2690a);
    }

    @Override // i2.a, i2.g.b, i2.g
    public <E extends g.b> E a(g.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // i2.e
    public final void c(i2.d<?> dVar) {
        ((kotlinx.coroutines.internal.f) dVar).q();
    }

    public abstract void g(i2.g gVar, Runnable runnable);

    @Override // i2.e
    public final <T> i2.d<T> i(i2.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.f(this, dVar);
    }

    @Override // i2.a, i2.g
    public i2.g k(g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    public boolean m(i2.g gVar) {
        return true;
    }

    public c0 n(int i3) {
        kotlinx.coroutines.internal.l.a(i3);
        return new kotlinx.coroutines.internal.k(this, i3);
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }
}
