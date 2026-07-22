package z2;

import g2.q;
import p2.p;

/* loaded from: /root/release/classes2.dex */
final class g<T> extends a<T> {

    /* renamed from: c, reason: collision with root package name */
    private final p<c<? super T>, i2.d<? super q>, Object> f4915c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(p<? super c<? super T>, ? super i2.d<? super q>, ? extends Object> pVar) {
        this.f4915c = pVar;
    }

    @Override // z2.a
    public Object b(c<? super T> cVar, i2.d<? super q> dVar) {
        Object c3;
        Object invoke = this.f4915c.invoke(cVar, dVar);
        c3 = j2.d.c();
        return invoke == c3 ? invoke : q.f2555a;
    }
}
