package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public abstract class ThresholdingOutputStream extends OutputStream {
    private final int threshold;
    private boolean thresholdExceeded;
    private long written;

    public ThresholdingOutputStream(int i3) {
        this.threshold = i3;
    }

    protected void checkThreshold(int i3) {
        if (this.thresholdExceeded || this.written + i3 <= this.threshold) {
            return;
        }
        this.thresholdExceeded = true;
        thresholdReached();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
        } catch (IOException unused) {
        }
        getStream().close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        getStream().flush();
    }

    public long getByteCount() {
        return this.written;
    }

    protected abstract OutputStream getStream();

    public int getThreshold() {
        return this.threshold;
    }

    public boolean isThresholdExceeded() {
        return this.written > ((long) this.threshold);
    }

    protected void resetByteCount() {
        this.thresholdExceeded = false;
        this.written = 0L;
    }

    protected void setByteCount(long j3) {
        this.written = j3;
    }

    protected abstract void thresholdReached();

    @Override // java.io.OutputStream
    public void write(int i3) {
        checkThreshold(1);
        getStream().write(i3);
        this.written++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        checkThreshold(bArr.length);
        getStream().write(bArr);
        this.written += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        checkThreshold(i4);
        getStream().write(bArr, i3, i4);
        this.written += i4;
    }
}
