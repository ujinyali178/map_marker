package kotlinx.coroutines.internal;

import w2.k0;

/* loaded from: /root/release/classes2.dex */
public abstract class w {
    public abstract c<?> a();

    public final boolean b(w wVar) {
        c<?> a4;
        c<?> a5 = a();
        return (a5 == null || (a4 = wVar.a()) == null || a5.f() >= a4.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }
}
