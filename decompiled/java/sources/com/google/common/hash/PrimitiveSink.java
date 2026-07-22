package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface PrimitiveSink {
    PrimitiveSink putBoolean(boolean z3);

    PrimitiveSink putByte(byte b4);

    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    PrimitiveSink putBytes(byte[] bArr);

    PrimitiveSink putBytes(byte[] bArr, int i3, int i4);

    PrimitiveSink putChar(char c3);

    PrimitiveSink putDouble(double d3);

    PrimitiveSink putFloat(float f3);

    PrimitiveSink putInt(int i3);

    PrimitiveSink putLong(long j3);

    PrimitiveSink putShort(short s3);

    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
