package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.r;

/* loaded from: /root/release/classes.dex */
public abstract class k extends d implements kotlin.jvm.internal.h<Object> {
    private final int arity;

    public k(int i3) {
        this(i3, null);
    }

    public k(int i3, i2.d<Object> dVar) {
        super(dVar);
        this.arity = i3;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String e3 = r.e(this);
        kotlin.jvm.internal.k.d(e3, "renderLambdaToString(this)");
        return e3;
    }
}
