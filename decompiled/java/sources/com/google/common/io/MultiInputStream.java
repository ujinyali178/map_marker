package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class MultiInputStream extends InputStream {

    @CheckForNull
    private InputStream in;
    private Iterator<? extends ByteSource> it;

    public MultiInputStream(Iterator<? extends ByteSource> it) {
        this.it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    private void advance() {
        close();
        if (this.it.hasNext()) {
            this.in = this.it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream inputStream = this.in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.in = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        while (true) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i3, i4);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        InputStream inputStream = this.in;
        if (inputStream == null || j3 <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j3);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.in.skip(j3 - 1) + 1;
    }
}
