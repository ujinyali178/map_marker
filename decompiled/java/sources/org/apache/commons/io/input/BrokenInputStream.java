package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public class BrokenInputStream extends InputStream {
    private final IOException exception;

    public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }

    public BrokenInputStream(IOException iOException) {
        this.exception = iOException;
    }

    @Override // java.io.InputStream
    public int available() {
        throw this.exception;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public int read() {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        throw this.exception;
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        throw this.exception;
    }
}
