package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void afterRead(int i3) {
        if (i3 == -1) {
            close();
        }
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in.close();
        ((FilterInputStream) this).in = new ClosedInputStream();
    }

    protected void finalize() {
        close();
        super.finalize();
    }
}
