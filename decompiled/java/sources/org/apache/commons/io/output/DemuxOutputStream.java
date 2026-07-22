package org.apache.commons.io.output;

import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public class DemuxOutputStream extends OutputStream {
    private final InheritableThreadLocal<OutputStream> outputStreamThreadLocal = new InheritableThreadLocal<>();

    public OutputStream bindStream(OutputStream outputStream) {
        OutputStream outputStream2 = this.outputStreamThreadLocal.get();
        this.outputStreamThreadLocal.set(outputStream);
        return outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream = this.outputStreamThreadLocal.get();
        if (outputStream != null) {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        OutputStream outputStream = this.outputStreamThreadLocal.get();
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        OutputStream outputStream = this.outputStreamThreadLocal.get();
        if (outputStream != null) {
            outputStream.write(i3);
        }
    }
}
