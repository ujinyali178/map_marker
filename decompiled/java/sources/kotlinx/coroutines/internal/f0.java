package kotlinx.coroutines.internal;

import i2.g;
import w2.b2;

/* loaded from: /root/release/classes2.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f3788a = new b0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final p2.p<Object, g.b, Object> f3789b = a.f3792c;

    /* renamed from: c, reason: collision with root package name */
    private static final p2.p<b2<?>, g.b, b2<?>> f3790c = b.f3793c;

    /* renamed from: d, reason: collision with root package name */
    private static final p2.p<i0, g.b, i0> f3791d = c.f3794c;

    static final class a extends kotlin.jvm.internal.l implements p2.p<Object, g.b, Object> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f3792c = new a();

        a() {
            super(2);
        }

        @Override // p2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof b2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    static final class b extends kotlin.jvm.internal.l implements p2.p<b2<?>, g.b, b2<?>> {

        /* renamed from: c, reason: collision with root package name */
        public static final b f3793c = new b();

        b() {
            super(2);
        }

        @Override // p2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b2<?> invoke(b2<?> b2Var, g.b bVar) {
            if (b2Var != null) {
                return b2Var;
            }
            if (bVar instanceof b2) {
                return (b2) bVar;
            }
            return null;
        }
    }

    static final class c extends kotlin.jvm.internal.l implements p2.p<i0, g.b, i0> {

        /* renamed from: c, reason: collision with root package name */
        public static final c f3794c = new c();

        c() {
            super(2);
        }

        @Override // p2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 invoke(i0 i0Var, g.b bVar) {
            if (bVar instanceof b2) {
                b2<?> b2Var = (b2) bVar;
                i0Var.a(b2Var, b2Var.d(i0Var.f3800a));
            }
            return i0Var;
        }
    }

    public static final void a(i2.g gVar, Object obj) {
        if (obj == f3788a) {
            return;
        }
        if (obj instanceof i0) {
            ((i0) obj).b(gVar);
            return;
        }
        Object x3 = gVar.x(null, f3790c);
        if (x3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((b2) x3).o(gVar, obj);
    }

    public static final Object b(i2.g gVar) {
        Object x3 = gVar.x(0, f3789b);
        kotlin.jvm.internal.k.b(x3);
        return x3;
    }

    public static final Object c(i2.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        return obj == 0 ? f3788a : obj instanceof Integer ? gVar.x(new i0(gVar, ((Number) obj).intValue()), f3791d) : ((b2) obj).d(gVar);
    }
}
