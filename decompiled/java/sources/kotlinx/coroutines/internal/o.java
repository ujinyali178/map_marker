package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w2.k0;

/* loaded from: /root/release/classes2.dex */
public class o {

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3811c = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next");

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f3812d = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_prev");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f3813f = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends kotlinx.coroutines.internal.c<o> {

        /* renamed from: b, reason: collision with root package name */
        public final o f3814b;

        /* renamed from: c, reason: collision with root package name */
        public o f3815c;

        public a(o oVar) {
            this.f3814b = oVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(o oVar, Object obj) {
            boolean z3 = obj == null;
            o oVar2 = z3 ? this.f3814b : this.f3815c;
            if (oVar2 != null && androidx.concurrent.futures.b.a(o.f3811c, oVar, this, oVar2) && z3) {
                o oVar3 = this.f3814b;
                o oVar4 = this.f3815c;
                kotlin.jvm.internal.k.b(oVar4);
                oVar3.m(oVar4);
            }
        }
    }

    public static final class b extends w {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (androidx.concurrent.futures.b.a(kotlinx.coroutines.internal.o.f3811c, r3, r2, ((kotlinx.coroutines.internal.x) r4).f3835a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.o k(kotlinx.coroutines.internal.w r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.o) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.o.f3812d
            boolean r0 = androidx.concurrent.futures.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.s()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.w
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.w) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.x
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.o.f3811c
            kotlinx.coroutines.internal.x r4 = (kotlinx.coroutines.internal.x) r4
            kotlinx.coroutines.internal.o r4 = r4.f3835a
            boolean r2 = androidx.concurrent.futures.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.o r2 = (kotlinx.coroutines.internal.o) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.o r3 = (kotlinx.coroutines.internal.o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.o.k(kotlinx.coroutines.internal.w):kotlinx.coroutines.internal.o");
    }

    private final o l(o oVar) {
        while (oVar.s()) {
            oVar = (o) oVar._prev;
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(o oVar) {
        o oVar2;
        do {
            oVar2 = (o) oVar._prev;
            if (n() != oVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f3812d, oVar, oVar2, this));
        if (s()) {
            oVar.k(null);
        }
    }

    private final x v() {
        x xVar = (x) this._removedRef;
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f3813f.lazySet(this, xVar2);
        return xVar2;
    }

    public final boolean i(o oVar, o oVar2) {
        f3812d.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3811c;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, oVar2, oVar)) {
            return false;
        }
        oVar.m(oVar2);
        return true;
    }

    public final boolean j(o oVar) {
        f3812d.lazySet(oVar, this);
        f3811c.lazySet(oVar, this);
        while (n() == this) {
            if (androidx.concurrent.futures.b.a(f3811c, this, this, oVar)) {
                oVar.m(this);
                return true;
            }
        }
        return false;
    }

    public final Object n() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    public final o o() {
        return n.b(n());
    }

    public final o p() {
        o k3 = k(null);
        return k3 == null ? l((o) this._prev) : k3;
    }

    public final void q() {
        ((x) n()).f3835a.r();
    }

    public final void r() {
        o oVar = this;
        while (true) {
            Object n3 = oVar.n();
            if (!(n3 instanceof x)) {
                oVar.k(null);
                return;
            }
            oVar = ((x) n3).f3835a;
        }
    }

    public boolean s() {
        return n() instanceof x;
    }

    public boolean t() {
        return u() == null;
    }

    public String toString() {
        return new kotlin.jvm.internal.o(this) { // from class: kotlinx.coroutines.internal.o.c
            @Override // t2.f
            public Object get() {
                return k0.a(this.receiver);
            }
        } + '@' + k0.b(this);
    }

    public final o u() {
        Object n3;
        o oVar;
        do {
            n3 = n();
            if (n3 instanceof x) {
                return ((x) n3).f3835a;
            }
            if (n3 == this) {
                return (o) n3;
            }
            oVar = (o) n3;
        } while (!androidx.concurrent.futures.b.a(f3811c, this, n3, oVar.v()));
        oVar.k(null);
        return null;
    }

    public final int w(o oVar, o oVar2, a aVar) {
        f3812d.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3811c;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        aVar.f3815c = oVar2;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, oVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
