package a3;

import g2.q;
import i2.g;
import i2.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import p2.p;
import v2.f;
import w2.p1;

/* loaded from: /root/release/classes2.dex */
public final class c<T> extends kotlin.coroutines.jvm.internal.d implements z2.c<T> {

    /* renamed from: c, reason: collision with root package name */
    public final z2.c<T> f230c;

    /* renamed from: d, reason: collision with root package name */
    public final g f231d;

    /* renamed from: f, reason: collision with root package name */
    public final int f232f;

    /* renamed from: g, reason: collision with root package name */
    private g f233g;

    /* renamed from: h, reason: collision with root package name */
    private i2.d<? super q> f234h;

    static final class a extends l implements p<Integer, g.b, Integer> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f235c = new a();

        a() {
            super(2);
        }

        public final Integer a(int i3, g.b bVar) {
            return Integer.valueOf(i3 + 1);
        }

        @Override // p2.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(z2.c<? super T> cVar, g gVar) {
        super(b.f228c, h.f2693c);
        this.f230c = cVar;
        this.f231d = gVar;
        this.f232f = ((Number) gVar.x(0, a.f235c)).intValue();
    }

    private final void a(g gVar, g gVar2, T t3) {
        if (gVar2 instanceof a3.a) {
            f((a3.a) gVar2, t3);
        }
        e.a(this, gVar);
    }

    private final Object d(i2.d<? super q> dVar, T t3) {
        p2.q qVar;
        Object c3;
        g context = dVar.getContext();
        p1.e(context);
        g gVar = this.f233g;
        if (gVar != context) {
            a(context, gVar, t3);
            this.f233g = context;
        }
        this.f234h = dVar;
        qVar = d.f236a;
        Object c4 = qVar.c(this.f230c, t3, this);
        c3 = j2.d.c();
        if (!k.a(c4, c3)) {
            this.f234h = null;
        }
        return c4;
    }

    private final void f(a3.a aVar, Object obj) {
        String e3;
        e3 = f.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + aVar.f226c + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(e3.toString());
    }

    @Override // z2.c
    public Object emit(T t3, i2.d<? super q> dVar) {
        Object c3;
        Object c4;
        try {
            Object d3 = d(dVar, t3);
            c3 = j2.d.c();
            if (d3 == c3) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            c4 = j2.d.c();
            return d3 == c4 ? d3 : q.f2555a;
        } catch (Throwable th) {
            this.f233g = new a3.a(th, dVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        i2.d<? super q> dVar = this.f234h;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, i2.d
    public g getContext() {
        g gVar = this.f233g;
        return gVar == null ? h.f2693c : gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public Object invokeSuspend(Object obj) {
        Object c3;
        Throwable b4 = g2.k.b(obj);
        if (b4 != null) {
            this.f233g = new a3.a(b4, getContext());
        }
        i2.d<? super q> dVar = this.f234h;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        c3 = j2.d.c();
        return c3;
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
