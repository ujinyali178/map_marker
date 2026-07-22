package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* loaded from: /root/release/classes2.dex */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
    }

    protected void afterRead(int i3) {
    }

    protected void beforeRead(int i3) {
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            ((FilterReader) this).in.close();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void mark(int i3) {
        try {
            ((FilterReader) this).in.mark(i3);
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return ((FilterReader) this).in.markSupported();
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() {
        int i3 = 1;
        try {
            beforeRead(1);
            int read = ((FilterReader) this).in.read();
            if (read == -1) {
                i3 = -1;
            }
            afterRead(i3);
            return read;
        } catch (IOException e3) {
            handleIOException(e3);
            return -1;
        }
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) {
        int length;
        if (charBuffer != null) {
            try {
                length = charBuffer.length();
            } catch (IOException e3) {
                handleIOException(e3);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = ((FilterReader) this).in.read(charBuffer);
        afterRead(read);
        return read;
    }

    @Override // java.io.Reader
    public int read(char[] cArr) {
        int length;
        if (cArr != null) {
            try {
                length = cArr.length;
            } catch (IOException e3) {
                handleIOException(e3);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = ((FilterReader) this).in.read(cArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i3, int i4) {
        try {
            beforeRead(i4);
            int read = ((FilterReader) this).in.read(cArr, i3, i4);
            afterRead(read);
            return read;
        } catch (IOException e3) {
            handleIOException(e3);
            return -1;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() {
        try {
            return ((FilterReader) this).in.ready();
        } catch (IOException e3) {
            handleIOException(e3);
            return false;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void reset() {
        try {
            ((FilterReader) this).in.reset();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j3) {
        try {
            return ((FilterReader) this).in.skip(j3);
        } catch (IOException e3) {
            handleIOException(e3);
            return 0L;
        }
    }
}
