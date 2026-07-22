package z2;

import g2.q;

/* loaded from: /root/release/classes2.dex */
public abstract class a<T> implements b<T> {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: z2.a$a, reason: collision with other inner class name */
    static final class C0115a extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: c, reason: collision with root package name */
        Object f4911c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f4912d;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<T> f4913f;

        /* renamed from: g, reason: collision with root package name */
        int f4914g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0115a(a<T> aVar, i2.d<? super C0115a> dVar) {
            super(dVar);
            this.f4913f = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.f4912d = obj;
            this.f4914g |= Integer.MIN_VALUE;
            return this.f4913f.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // z2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(z2.c<? super T> r6, i2.d<? super g2.q> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof z2.a.C0115a
            if (r0 == 0) goto L13
            r0 = r7
            z2.a$a r0 = (z2.a.C0115a) r0
            int r1 = r0.f4914g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4914g = r1
            goto L18
        L13:
            z2.a$a r0 = new z2.a$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f4912d
            java.lang.Object r1 = j2.b.c()
            int r2 = r0.f4914g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f4911c
            a3.c r6 = (a3.c) r6
            g2.l.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            g2.l.b(r7)
            a3.c r7 = new a3.c
            i2.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f4911c = r7     // Catch: java.lang.Throwable -> L55
            r0.f4914g = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.b(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            g2.q r6 = g2.q.f2555a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.a.a(z2.c, i2.d):java.lang.Object");
    }

    public abstract Object b(c<? super T> cVar, i2.d<? super q> dVar);
}
