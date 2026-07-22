package org.apache.commons.io.input;

import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class BoundedInputStream extends InputStream {
    private final InputStream in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1L);
    }

    public BoundedInputStream(InputStream inputStream, long j3) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = j3;
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        long j3 = this.max;
        if (j3 < 0 || this.pos < j3) {
            return this.in.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.propagateClose) {
            this.in.close();
        }
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        this.in.mark(i3);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        long j3 = this.max;
        if (j3 >= 0 && this.pos >= j3) {
            return -1;
        }
        int read = this.in.read();
        this.pos++;
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        long j3 = this.max;
        if (j3 >= 0 && this.pos >= j3) {
            return -1;
        }
        int read = this.in.read(bArr, i3, (int) (j3 >= 0 ? Math.min(i4, j3 - this.pos) : i4));
        if (read == -1) {
            return -1;
        }
        this.pos += read;
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.in.reset();
        this.pos = this.mark;
    }

    public void setPropagateClose(boolean z3) {
        this.propagateClose = z3;
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        long j4 = this.max;
        if (j4 >= 0) {
            j3 = Math.min(j3, j4 - this.pos);
        }
        long skip = this.in.skip(j3);
        this.pos += skip;
        return skip;
    }

    public String toString() {
        return this.in.toString();
    }
}
