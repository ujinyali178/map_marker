package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: /root/release/classes.dex */
final class LengthCountingOutputStream extends OutputStream {
    private long length = 0;

    LengthCountingOutputStream() {
    }

    long getLength() {
        return this.length;
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        this.length++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.length += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        int i5;
        if (i3 < 0 || i3 > bArr.length || i4 < 0 || (i5 = i3 + i4) > bArr.length || i5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.length += i4;
    }
}
