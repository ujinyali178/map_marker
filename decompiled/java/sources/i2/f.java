package i2;

import g2.k;
import g2.q;
import kotlin.jvm.internal.k;
import p2.p;

/* loaded from: /root/release/classes.dex */
public final class f {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r3, d<? super T> completion) {
        d a4;
        d b4;
        k.e(pVar, "<this>");
        k.e(completion, "completion");
        a4 = j2.c.a(pVar, r3, completion);
        b4 = j2.c.b(a4);
        k.a aVar = g2.k.f2549c;
        b4.resumeWith(g2.k.a(q.f2555a));
    }
}
