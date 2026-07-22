package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public abstract class ByteOutput {
    public abstract void write(byte b4);

    public abstract void write(ByteBuffer byteBuffer);

    public abstract void write(byte[] bArr, int i3, int i4);

    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i3, int i4);
}
