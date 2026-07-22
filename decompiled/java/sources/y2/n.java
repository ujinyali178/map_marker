package y2;

import kotlinx.coroutines.internal.b0;

/* loaded from: /root/release/classes2.dex */
public class n<E> extends a<E> {
    public n(p2.l<? super E, g2.q> lVar) {
        super(lVar);
    }

    @Override // y2.c
    protected Object i(E e3) {
        q<?> k3;
        do {
            Object i3 = super.i(e3);
            b0 b0Var = b.f4684b;
            if (i3 == b0Var) {
                return b0Var;
            }
            if (i3 != b.f4685c) {
                if (i3 instanceof j) {
                    return i3;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + i3).toString());
            }
            k3 = k(e3);
            if (k3 == null) {
                return b0Var;
            }
        } while (!(k3 instanceof j));
        return k3;
    }

    @Override // y2.a
    protected final boolean r() {
        return true;
    }

    @Override // y2.a
    protected final boolean s() {
        return true;
    }
}
