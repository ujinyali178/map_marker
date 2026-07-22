package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class HashingInputStream extends FilterInputStream {
    private final Hasher hasher;

    public HashingInputStream(HashFunction hashFunction, InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.hasher.putByte((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        int read = ((FilterInputStream) this).in.read(bArr, i3, i4);
        if (read != -1) {
            this.hasher.putBytes(bArr, i3, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new IOException("reset not supported");
    }
}
