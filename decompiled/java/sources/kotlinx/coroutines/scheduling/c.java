package kotlinx.coroutines.scheduling;

/* loaded from: /root/release/classes2.dex */
public final class c extends f {

    /* renamed from: l, reason: collision with root package name */
    public static final c f3866l = new c();

    private c() {
        super(l.f3878b, l.f3879c, l.f3880d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // w2.c0
    public String toString() {
        return "Dispatchers.Default";
    }
}
