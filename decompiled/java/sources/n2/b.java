package n2;

import java.io.Closeable;

/* loaded from: /root/release/classes.dex */
public final class b {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                g2.b.a(th, th2);
            }
        }
    }
}
