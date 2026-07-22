package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i3, int i4) {
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z3) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z3);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i3) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i3);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String str) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i3) {
        writeShort(i3);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            writeChar(str.charAt(i3));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d3) {
        writeLong(Double.doubleToLongBits(d3));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f3) {
        writeInt(Float.floatToIntBits(f3));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i3) {
        ((FilterOutputStream) this).out.write(i3 & 255);
        ((FilterOutputStream) this).out.write((i3 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i3 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i3 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j3) {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j3));
        write(byteArray, 0, byteArray.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i3) {
        ((FilterOutputStream) this).out.write(i3 & 255);
        ((FilterOutputStream) this).out.write((i3 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
