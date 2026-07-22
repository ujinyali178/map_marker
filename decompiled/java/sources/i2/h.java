package i2;

import i2.g;
import java.io.Serializable;
import kotlin.jvm.internal.k;
import p2.p;

/* loaded from: /root/release/classes.dex */
public final class h implements g, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final h f2693c = new h();

    private h() {
    }

    @Override // i2.g
    public <E extends g.b> E a(g.c<E> key) {
        k.e(key, "key");
        return null;
    }

    @Override // i2.g
    public g f(g context) {
        k.e(context, "context");
        return context;
    }

    public int hashCode() {
        return 0;
    }

    @Override // i2.g
    public g k(g.c<?> key) {
        k.e(key, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // i2.g
    public <R> R x(R r3, p<? super R, ? super g.b, ? extends R> operation) {
        k.e(operation, "operation");
        return r3;
    }
}
