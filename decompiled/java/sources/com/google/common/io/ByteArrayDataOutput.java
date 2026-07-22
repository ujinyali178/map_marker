package com.google.common.io;

import java.io.DataOutput;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int i3);

    @Override // java.io.DataOutput
    void write(byte[] bArr);

    @Override // java.io.DataOutput
    void write(byte[] bArr, int i3, int i4);

    @Override // java.io.DataOutput
    void writeBoolean(boolean z3);

    @Override // java.io.DataOutput
    void writeByte(int i3);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String str);

    @Override // java.io.DataOutput
    void writeChar(int i3);

    @Override // java.io.DataOutput
    void writeChars(String str);

    @Override // java.io.DataOutput
    void writeDouble(double d3);

    @Override // java.io.DataOutput
    void writeFloat(float f3);

    @Override // java.io.DataOutput
    void writeInt(int i3);

    @Override // java.io.DataOutput
    void writeLong(long j3);

    @Override // java.io.DataOutput
    void writeShort(int i3);

    @Override // java.io.DataOutput
    void writeUTF(String str);
}
