package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: /root/release/classes.dex */
public abstract class l<R> implements h<R>, Serializable {
    private final int arity;

    public l(int i3) {
        this.arity = i3;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String f3 = r.f(this);
        k.d(f3, "renderLambdaToString(this)");
        return f3;
    }
}
