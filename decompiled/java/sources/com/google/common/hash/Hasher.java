package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean z3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte b4);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b4);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] bArr, int i3, int i4);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i3, int i4);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char c3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double d3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float f3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int i3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long j3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j3);

    <T> Hasher putObject(@ParametricNullness T t3, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short s3);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence charSequence);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
