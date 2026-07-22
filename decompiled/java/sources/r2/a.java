package r2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.k;

/* loaded from: /root/release/classes.dex */
public final class a extends q2.a {
    @Override // q2.a
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        k.d(current, "current()");
        return current;
    }
}
