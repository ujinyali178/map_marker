package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class CountingOutputStream extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) {
        ((FilterOutputStream) this).out.write(i3);
        this.count++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
        this.count += i4;
    }
}
