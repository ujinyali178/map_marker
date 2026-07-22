package kotlin.jvm.internal;

/* loaded from: /root/release/classes.dex */
public abstract class n extends p implements t2.f {
    public n(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, i3);
    }

    @Override // kotlin.jvm.internal.c
    protected t2.b computeReflected() {
        return r.d(this);
    }

    @Override // p2.a
    public Object invoke() {
        return get();
    }
}
