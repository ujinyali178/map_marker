package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class NullInputStream extends InputStream {
    private boolean eof;
    private long mark;
    private final boolean markSupported;
    private long position;
    private long readlimit;
    private final long size;
    private final boolean throwEofException;

    public NullInputStream(long j3) {
        this(j3, true, false);
    }

    public NullInputStream(long j3, boolean z3, boolean z4) {
        this.mark = -1L;
        this.size = j3;
        this.markSupported = z3;
        this.throwEofException = z4;
    }

    private int doEndOfFile() {
        this.eof = true;
        if (this.throwEofException) {
            throw new EOFException();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int available() {
        long j3 = this.size - this.position;
        if (j3 <= 0) {
            return 0;
        }
        if (j3 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j3;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = false;
        this.position = 0L;
        this.mark = -1L;
    }

    public long getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        if (!this.markSupported) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        this.mark = this.position;
        this.readlimit = i3;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.markSupported;
    }

    protected int processByte() {
        return 0;
    }

    protected void processBytes(byte[] bArr, int i3, int i4) {
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.eof) {
            throw new IOException("Read after end of file");
        }
        long j3 = this.position;
        if (j3 == this.size) {
            return doEndOfFile();
        }
        this.position = j3 + 1;
        return processByte();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (this.eof) {
            throw new IOException("Read after end of file");
        }
        long j3 = this.position;
        long j4 = this.size;
        if (j3 == j4) {
            return doEndOfFile();
        }
        long j5 = j3 + i4;
        this.position = j5;
        if (j5 > j4) {
            i4 -= (int) (j5 - j4);
            this.position = j4;
        }
        processBytes(bArr, i3, i4);
        return i4;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        if (!this.markSupported) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        long j3 = this.mark;
        if (j3 < 0) {
            throw new IOException("No position has been marked");
        }
        if (this.position > this.readlimit + j3) {
            throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
        }
        this.position = j3;
        this.eof = false;
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        if (this.eof) {
            throw new IOException("Skip after end of file");
        }
        long j4 = this.position;
        long j5 = this.size;
        if (j4 == j5) {
            return doEndOfFile();
        }
        long j6 = j4 + j3;
        this.position = j6;
        if (j6 <= j5) {
            return j3;
        }
        long j7 = j3 - (j6 - j5);
        this.position = j5;
        return j7;
    }
}
