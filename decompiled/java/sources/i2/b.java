package i2;

import i2.g;
import i2.g.b;
import kotlin.jvm.internal.k;
import p2.l;

/* loaded from: /root/release/classes.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* renamed from: c, reason: collision with root package name */
    private final l<g.b, E> f2685c;

    /* renamed from: d, reason: collision with root package name */
    private final g.c<?> f2686d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [i2.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, p2.l<? super i2.g$b, ? extends E extends B>, p2.l<i2.g$b, E extends B>] */
    public b(g.c<B> baseKey, l<? super g.b, ? extends E> safeCast) {
        k.e(baseKey, "baseKey");
        k.e(safeCast, "safeCast");
        this.f2685c = safeCast;
        this.f2686d = baseKey instanceof b ? (g.c<B>) ((b) baseKey).f2686d : baseKey;
    }

    public final boolean a(g.c<?> key) {
        k.e(key, "key");
        return key == this || this.f2686d == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Li2/g$b;)TE; */
    public final g.b b(g.b element) {
        k.e(element, "element");
        return (g.b) this.f2685c.invoke(element);
    }
}
