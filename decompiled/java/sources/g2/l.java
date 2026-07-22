package g2;

import g2.k;

/* loaded from: /root/release/classes.dex */
public final class l {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.k.e(exception, "exception");
        return new k.b(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof k.b) {
            throw ((k.b) obj).f2550c;
        }
    }
}
