package com.google.firebase.encoders;

/* loaded from: /root/release/classes.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d3);

    ValueEncoderContext add(float f3);

    ValueEncoderContext add(int i3);

    ValueEncoderContext add(long j3);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z3);

    ValueEncoderContext add(byte[] bArr);
}
