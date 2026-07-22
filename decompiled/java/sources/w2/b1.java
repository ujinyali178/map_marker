package w2;

import java.util.concurrent.CancellationException;

/* loaded from: /root/release/classes2.dex */
public final class b1 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
