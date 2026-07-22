package y2;

import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import w2.k0;

/* loaded from: /root/release/classes2.dex */
public final class j<E> extends s implements q<E> {

    /* renamed from: g, reason: collision with root package name */
    public final Throwable f4709g;

    @Override // y2.q
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public j<E> b() {
        return this;
    }

    @Override // y2.s
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public j<E> y() {
        return this;
    }

    public final Throwable D() {
        Throwable th = this.f4709g;
        return th == null ? new k("Channel was closed") : th;
    }

    public final Throwable E() {
        Throwable th = this.f4709g;
        return th == null ? new l("Channel was closed") : th;
    }

    @Override // y2.q
    public void f(E e3) {
    }

    @Override // y2.q
    public b0 g(E e3, o.b bVar) {
        return w2.m.f4486a;
    }

    @Override // kotlinx.coroutines.internal.o
    public String toString() {
        return "Closed@" + k0.b(this) + '[' + this.f4709g + ']';
    }

    @Override // y2.s
    public void x() {
    }

    @Override // y2.s
    public b0 z(o.b bVar) {
        return w2.m.f4486a;
    }
}
