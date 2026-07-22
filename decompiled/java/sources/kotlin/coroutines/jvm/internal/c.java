package kotlin.coroutines.jvm.internal;

/* loaded from: /root/release/classes.dex */
public final class c implements i2.d<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final c f3747c = new c();

    private c() {
    }

    @Override // i2.d
    public i2.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // i2.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
