package w2;

import java.util.concurrent.CancellationException;

/* loaded from: /root/release/classes2.dex */
public final class m1 extends CancellationException {

    /* renamed from: c, reason: collision with root package name */
    public final transient l1 f4489c;

    public m1(String str, Throwable th, l1 l1Var) {
        super(str);
        this.f4489c = l1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof m1) {
                m1 m1Var = (m1) obj;
                if (!kotlin.jvm.internal.k.a(m1Var.getMessage(), getMessage()) || !kotlin.jvm.internal.k.a(m1Var.f4489c, this.f4489c) || !kotlin.jvm.internal.k.a(m1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.k.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f4489c.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f4489c;
    }
}
