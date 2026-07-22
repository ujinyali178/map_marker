package kotlinx.coroutines.internal;

import java.util.List;
import w2.v1;

/* loaded from: /root/release/classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3829a = true;

    private static final u a(Throwable th, String str) {
        if (f3829a) {
            return new u(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new g2.d();
    }

    static /* synthetic */ u b(Throwable th, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            th = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(v1 v1Var) {
        return v1Var.p() instanceof u;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final v1 e(r rVar, List<? extends r> list) {
        try {
            return rVar.b(list);
        } catch (Throwable th) {
            return a(th, rVar.a());
        }
    }
}
