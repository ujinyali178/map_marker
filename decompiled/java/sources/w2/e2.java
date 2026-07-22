package w2;

/* loaded from: /root/release/classes2.dex */
public final class e2<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: g, reason: collision with root package name */
    private ThreadLocal<g2.j<i2.g, Object>> f4460g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e2(i2.g r3, i2.d<? super T> r4) {
        /*
            r2 = this;
            w2.f2 r0 = w2.f2.f4463c
            i2.g$b r1 = r3.a(r0)
            if (r1 != 0) goto Ld
            i2.g r0 = r3.f(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f4460g = r0
            i2.g r4 = r4.getContext()
            i2.e$b r0 = i2.e.f2690a
            i2.g$b r4 = r4.a(r0)
            boolean r4 = r4 instanceof w2.c0
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.f0.c(r3, r4)
            kotlinx.coroutines.internal.f0.a(r3, r4)
            r2.E0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.e2.<init>(i2.g, i2.d):void");
    }

    public final boolean D0() {
        if (this.f4460g.get() == null) {
            return false;
        }
        this.f4460g.set(null);
        return true;
    }

    public final void E0(i2.g gVar, Object obj) {
        this.f4460g.set(g2.n.a(gVar, obj));
    }

    @Override // kotlinx.coroutines.internal.z, w2.a
    protected void y0(Object obj) {
        g2.j<i2.g, Object> jVar = this.f4460g.get();
        if (jVar != null) {
            kotlinx.coroutines.internal.f0.a(jVar.a(), jVar.b());
            this.f4460g.set(null);
        }
        Object a4 = z.a(obj, this.f3836f);
        i2.d<T> dVar = this.f3836f;
        i2.g context = dVar.getContext();
        Object c3 = kotlinx.coroutines.internal.f0.c(context, null);
        e2<?> g3 = c3 != kotlinx.coroutines.internal.f0.f3788a ? b0.g(dVar, context, c3) : null;
        try {
            this.f3836f.resumeWith(a4);
            g2.q qVar = g2.q.f2555a;
        } finally {
            if (g3 == null || g3.D0()) {
                kotlinx.coroutines.internal.f0.a(context, c3);
            }
        }
    }
}
