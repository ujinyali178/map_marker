package kotlinx.coroutines.internal;

import w2.l1;

/* loaded from: /root/release/classes2.dex */
public class z<T> extends w2.a<T> implements kotlin.coroutines.jvm.internal.e {

    /* renamed from: f, reason: collision with root package name */
    public final i2.d<T> f3836f;

    /* JADX WARN: Multi-variable type inference failed */
    public z(i2.g gVar, i2.d<? super T> dVar) {
        super(gVar, true, true);
        this.f3836f = dVar;
    }

    @Override // w2.s1
    protected void C(Object obj) {
        i2.d b4;
        b4 = j2.c.b(this.f3836f);
        g.c(b4, w2.z.a(obj, this.f3836f), null, 2, null);
    }

    public final l1 C0() {
        w2.q T = T();
        if (T != null) {
            return T.getParent();
        }
        return null;
    }

    @Override // w2.s1
    protected final boolean Z() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public final kotlin.coroutines.jvm.internal.e getCallerFrame() {
        i2.d<T> dVar = this.f3836f;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // w2.a
    protected void y0(Object obj) {
        i2.d<T> dVar = this.f3836f;
        dVar.resumeWith(w2.z.a(obj, dVar));
    }
}
