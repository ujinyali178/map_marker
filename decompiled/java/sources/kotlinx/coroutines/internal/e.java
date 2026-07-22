package kotlinx.coroutines.internal;

/* loaded from: /root/release/classes2.dex */
public final class e implements w2.g0 {

    /* renamed from: c, reason: collision with root package name */
    private final i2.g f3782c;

    public e(i2.g gVar) {
        this.f3782c = gVar;
    }

    @Override // w2.g0
    public i2.g p() {
        return this.f3782c;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + p() + ')';
    }
}
