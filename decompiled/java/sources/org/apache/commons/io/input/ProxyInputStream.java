package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /root/release/classes2.dex */
public abstract class ProxyInputStream extends FilterInputStream {
    public ProxyInputStream(InputStream inputStream) {
        super(inputStream);
    }

    protected void afterRead(int i3) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        try {
            return super.available();
        } catch (IOException e3) {
            handleIOException(e3);
            return 0;
        }
    }

    protected void beforeRead(int i3) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            ((FilterInputStream) this).in.close();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        ((FilterInputStream) this).in.mark(i3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i3 = 1;
        try {
            beforeRead(1);
            int read = ((FilterInputStream) this).in.read();
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

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int length;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (IOException e3) {
                handleIOException(e3);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = ((FilterInputStream) this).in.read(bArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        try {
            beforeRead(i4);
            int read = ((FilterInputStream) this).in.read(bArr, i3, i4);
            afterRead(read);
            return read;
        } catch (IOException e3) {
            handleIOException(e3);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) {
        try {
            return ((FilterInputStream) this).in.skip(j3);
        } catch (IOException e3) {
            handleIOException(e3);
            return 0L;
        }
    }
}
