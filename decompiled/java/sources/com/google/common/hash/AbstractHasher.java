package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class AbstractHasher implements Hasher {
    AbstractHasher() {
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBoolean(boolean z3) {
        return putByte(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b4) {
        PrimitiveSink putByte;
        putByte = putByte(b4);
        return putByte;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                putByte(byteBuffer.get());
            }
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr, int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
        for (int i5 = 0; i5 < i4; i5++) {
            putByte(bArr[i3 + i5]);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putChar(char c3) {
        putByte((byte) c3);
        putByte((byte) (c3 >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putDouble(double d3) {
        return putLong(Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putFloat(float f3) {
        return putInt(Float.floatToRawIntBits(f3));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putInt(int i3) {
        putByte((byte) i3);
        putByte((byte) (i3 >>> 8));
        putByte((byte) (i3 >>> 16));
        putByte((byte) (i3 >>> 24));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putLong(long j3) {
        for (int i3 = 0; i3 < 64; i3 += 8) {
            putByte((byte) (j3 >>> i3));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(@ParametricNullness T t3, Funnel<? super T> funnel) {
        funnel.funnel(t3, this);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putShort(short s3) {
        putByte((byte) s3);
        putByte((byte) (s3 >>> 8));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            putChar(charSequence.charAt(i3));
        }
        return this;
    }
}
