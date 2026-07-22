package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /root/release/classes2.dex */
public class ProxyOutputStream extends FilterOutputStream {
    public ProxyOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    protected void afterWrite(int i3) {
    }

    protected void beforeWrite(int i3) {
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    protected void handleIOException(IOException iOException) {
        throw iOException;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) {
        try {
            beforeWrite(1);
            ((FilterOutputStream) this).out.write(i3);
            afterWrite(1);
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        int length;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (IOException e3) {
                handleIOException(e3);
                return;
            }
        } else {
            length = 0;
        }
        beforeWrite(length);
        ((FilterOutputStream) this).out.write(bArr);
        afterWrite(length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        try {
            beforeWrite(i4);
            ((FilterOutputStream) this).out.write(bArr, i3, i4);
            afterWrite(i4);
        } catch (IOException e3) {
            handleIOException(e3);
        }
    }
}
