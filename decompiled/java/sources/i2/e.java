package i2;

import i2.g;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public interface e extends g.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2690a = b.f2691c;

    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> key) {
            k.e(key, "key");
            if (!(key instanceof i2.b)) {
                if (e.f2690a != key) {
                    return null;
                }
                k.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            i2.b bVar = (i2.b) key;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e3 = (E) bVar.b(eVar);
            if (e3 instanceof g.b) {
                return e3;
            }
            return null;
        }

        public static g b(e eVar, g.c<?> key) {
            k.e(key, "key");
            if (!(key instanceof i2.b)) {
                return e.f2690a == key ? h.f2693c : eVar;
            }
            i2.b bVar = (i2.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f2693c;
        }
    }

    public static final class b implements g.c<e> {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ b f2691c = new b();

        private b() {
        }
    }

    void c(d<?> dVar);

    <T> d<T> i(d<? super T> dVar);
}
