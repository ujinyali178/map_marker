package w2;

/* loaded from: /root/release/classes2.dex */
final class o0 extends RuntimeException {

    /* renamed from: c, reason: collision with root package name */
    private final i2.g f4491c;

    public o0(i2.g gVar) {
        this.f4491c = gVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f4491c.toString();
    }
}
