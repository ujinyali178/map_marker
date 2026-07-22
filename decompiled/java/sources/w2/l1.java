package w2;

import i2.g;
import java.util.concurrent.CancellationException;

/* loaded from: /root/release/classes2.dex */
public interface l1 extends g.b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f4484e = b.f4485c;

    public static final class a {
        public static /* synthetic */ void a(l1 l1Var, CancellationException cancellationException, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i3 & 1) != 0) {
                cancellationException = null;
            }
            l1Var.t(cancellationException);
        }

        public static <R> R b(l1 l1Var, R r3, p2.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(l1Var, r3, pVar);
        }

        public static <E extends g.b> E c(l1 l1Var, g.c<E> cVar) {
            return (E) g.b.a.b(l1Var, cVar);
        }

        public static /* synthetic */ u0 d(l1 l1Var, boolean z3, boolean z4, p2.l lVar, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i3 & 1) != 0) {
                z3 = false;
            }
            if ((i3 & 2) != 0) {
                z4 = true;
            }
            return l1Var.j(z3, z4, lVar);
        }

        public static i2.g e(l1 l1Var, g.c<?> cVar) {
            return g.b.a.c(l1Var, cVar);
        }

        public static i2.g f(l1 l1Var, i2.g gVar) {
            return g.b.a.d(l1Var, gVar);
        }
    }

    public static final class b implements g.c<l1> {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ b f4485c = new b();

        private b() {
        }
    }

    CancellationException h();

    boolean isActive();

    u0 j(boolean z3, boolean z4, p2.l<? super Throwable, g2.q> lVar);

    q l(s sVar);

    boolean start();

    void t(CancellationException cancellationException);
}
