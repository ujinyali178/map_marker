package kotlin.coroutines.jvm.internal;

/* loaded from: /root/release/classes.dex */
public abstract class j extends a {
    public j(i2.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == i2.h.f2693c)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // i2.d
    public i2.g getContext() {
        return i2.h.f2693c;
    }
}
