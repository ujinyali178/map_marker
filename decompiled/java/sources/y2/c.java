package y2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import w2.k0;
import y2.i;

/* loaded from: /root/release/classes2.dex */
public abstract class c<E> implements t<E> {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f4689d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* renamed from: b, reason: collision with root package name */
    protected final p2.l<E, g2.q> f4690b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.internal.m f4691c = new kotlinx.coroutines.internal.m();
    private volatile /* synthetic */ Object onCloseHandler = null;

    public static final class a<E> extends s {

        /* renamed from: g, reason: collision with root package name */
        public final E f4692g;

        public a(E e3) {
            this.f4692g = e3;
        }

        @Override // kotlinx.coroutines.internal.o
        public String toString() {
            return "SendBuffered@" + k0.b(this) + '(' + this.f4692g + ')';
        }

        @Override // y2.s
        public void x() {
        }

        @Override // y2.s
        public Object y() {
            return this.f4692g;
        }

        @Override // y2.s
        public b0 z(o.b bVar) {
            return w2.m.f4486a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(p2.l<? super E, g2.q> lVar) {
        this.f4690b = lVar;
    }

    private final int b() {
        kotlinx.coroutines.internal.m mVar = this.f4691c;
        int i3 = 0;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) mVar.n(); !kotlin.jvm.internal.k.a(oVar, mVar); oVar = oVar.o()) {
            if (oVar instanceof kotlinx.coroutines.internal.o) {
                i3++;
            }
        }
        return i3;
    }

    private final String f() {
        String str;
        kotlinx.coroutines.internal.o o3 = this.f4691c.o();
        if (o3 == this.f4691c) {
            return "EmptyQueue";
        }
        if (o3 instanceof j) {
            str = o3.toString();
        } else if (o3 instanceof o) {
            str = "ReceiveQueued";
        } else if (o3 instanceof s) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + o3;
        }
        kotlinx.coroutines.internal.o p3 = this.f4691c.p();
        if (p3 == o3) {
            return str;
        }
        String str2 = str + ",queueSize=" + b();
        if (!(p3 instanceof j)) {
            return str2;
        }
        return str2 + ",closedForSend=" + p3;
    }

    private final void g(j<?> jVar) {
        Object b4 = kotlinx.coroutines.internal.j.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.o p3 = jVar.p();
            o oVar = p3 instanceof o ? (o) p3 : null;
            if (oVar == null) {
                break;
            } else if (oVar.t()) {
                b4 = kotlinx.coroutines.internal.j.c(b4, oVar);
            } else {
                oVar.q();
            }
        }
        if (b4 != null) {
            if (b4 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) b4;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((o) arrayList.get(size)).y(jVar);
                }
            } else {
                ((o) b4).y(jVar);
            }
        }
        j(jVar);
    }

    private final Throwable h(j<?> jVar) {
        g(jVar);
        return jVar.E();
    }

    @Override // y2.t
    public final Object a(E e3) {
        i.b bVar;
        j<?> jVar;
        Object i3 = i(e3);
        if (i3 == b.f4684b) {
            return i.f4706a.c(g2.q.f2555a);
        }
        if (i3 == b.f4685c) {
            jVar = d();
            if (jVar == null) {
                return i.f4706a.b();
            }
            bVar = i.f4706a;
        } else {
            if (!(i3 instanceof j)) {
                throw new IllegalStateException(("trySend returned " + i3).toString());
            }
            bVar = i.f4706a;
            jVar = (j) i3;
        }
        return bVar.a(h(jVar));
    }

    protected String c() {
        return "";
    }

    protected final j<?> d() {
        kotlinx.coroutines.internal.o p3 = this.f4691c.p();
        j<?> jVar = p3 instanceof j ? (j) p3 : null;
        if (jVar == null) {
            return null;
        }
        g(jVar);
        return jVar;
    }

    protected final kotlinx.coroutines.internal.m e() {
        return this.f4691c;
    }

    protected Object i(E e3) {
        q<E> l3;
        do {
            l3 = l();
            if (l3 == null) {
                return b.f4685c;
            }
        } while (l3.g(e3, null) == null);
        l3.f(e3);
        return l3.b();
    }

    protected void j(kotlinx.coroutines.internal.o oVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final q<?> k(E e3) {
        kotlinx.coroutines.internal.o p3;
        kotlinx.coroutines.internal.m mVar = this.f4691c;
        a aVar = new a(e3);
        do {
            p3 = mVar.p();
            if (p3 instanceof q) {
                return (q) p3;
            }
        } while (!p3.i(aVar, mVar));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.o] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    protected q<E> l() {
        ?? r12;
        kotlinx.coroutines.internal.o u3;
        kotlinx.coroutines.internal.m mVar = this.f4691c;
        while (true) {
            r12 = (kotlinx.coroutines.internal.o) mVar.n();
            if (r12 != mVar && (r12 instanceof q)) {
                if (((((q) r12) instanceof j) && !r12.s()) || (u3 = r12.u()) == null) {
                    break;
                }
                u3.r();
            }
        }
        r12 = 0;
        return (q) r12;
    }

    protected final s m() {
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o u3;
        kotlinx.coroutines.internal.m mVar = this.f4691c;
        while (true) {
            oVar = (kotlinx.coroutines.internal.o) mVar.n();
            if (oVar != mVar && (oVar instanceof s)) {
                if (((((s) oVar) instanceof j) && !oVar.s()) || (u3 = oVar.u()) == null) {
                    break;
                }
                u3.r();
            }
        }
        oVar = null;
        return (s) oVar;
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + '{' + f() + '}' + c();
    }
}
