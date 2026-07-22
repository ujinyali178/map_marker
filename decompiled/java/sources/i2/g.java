package i2;

import i2.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import p2.p;

/* loaded from: /root/release/classes.dex */
public interface g {

    public static final class a {

        /* renamed from: i2.g$a$a, reason: collision with other inner class name */
        static final class C0083a extends l implements p<g, b, g> {

            /* renamed from: c, reason: collision with root package name */
            public static final C0083a f2692c = new C0083a();

            C0083a() {
                super(2);
            }

            @Override // p2.p
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke(g acc, b element) {
                i2.c cVar;
                k.e(acc, "acc");
                k.e(element, "element");
                g k3 = acc.k(element.getKey());
                h hVar = h.f2693c;
                if (k3 == hVar) {
                    return element;
                }
                e.b bVar = e.f2690a;
                e eVar = (e) k3.a(bVar);
                if (eVar == null) {
                    cVar = new i2.c(k3, element);
                } else {
                    g k4 = k3.k(bVar);
                    if (k4 == hVar) {
                        return new i2.c(element, eVar);
                    }
                    cVar = new i2.c(new i2.c(k4, element), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g context) {
            k.e(context, "context");
            return context == h.f2693c ? gVar : (g) context.x(gVar, C0083a.f2692c);
        }
    }

    public interface b extends g {

        public static final class a {
            public static <R> R a(b bVar, R r3, p<? super R, ? super b, ? extends R> operation) {
                k.e(operation, "operation");
                return operation.invoke(r3, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                k.e(key, "key");
                if (!k.a(bVar.getKey(), key)) {
                    return null;
                }
                k.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c<?> key) {
                k.e(key, "key");
                return k.a(bVar.getKey(), key) ? h.f2693c : bVar;
            }

            public static g d(b bVar, g context) {
                k.e(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // i2.g
        <E extends b> E a(c<E> cVar);

        c<?> getKey();
    }

    public interface c<E extends b> {
    }

    <E extends b> E a(c<E> cVar);

    g f(g gVar);

    g k(c<?> cVar);

    <R> R x(R r3, p<? super R, ? super b, ? extends R> pVar);
}
