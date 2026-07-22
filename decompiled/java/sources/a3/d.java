package a3;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.t;
import p2.q;

/* loaded from: /root/release/classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final q<z2.c<Object>, Object, i2.d<? super g2.q>, Object> f236a = (q) t.a(a.f237c, 3);

    /* synthetic */ class a extends j implements q<z2.c<? super Object>, Object, i2.d<? super g2.q>, Object> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f237c = new a();

        a() {
            super(3, z2.c.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // p2.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object c(z2.c<Object> cVar, Object obj, i2.d<? super g2.q> dVar) {
            return cVar.emit(obj, dVar);
        }
    }
}
