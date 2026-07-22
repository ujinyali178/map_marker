package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public class ClosedOutputStream extends OutputStream {
    public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        throw new IOException("flush() failed: stream is closed");
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        throw new IOException("write(" + i3 + ") failed: stream is closed");
    }
}
