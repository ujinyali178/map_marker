package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher hasher;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) {
        this.hasher.putByte((byte) i3);
        ((FilterOutputStream) this).out.write(i3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        this.hasher.putBytes(bArr, i3, i4);
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
    }
}
