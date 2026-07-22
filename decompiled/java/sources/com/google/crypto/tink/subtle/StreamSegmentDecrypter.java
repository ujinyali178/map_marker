package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public interface StreamSegmentDecrypter {
    void decryptSegment(ByteBuffer byteBuffer, int i3, boolean z3, ByteBuffer byteBuffer2);

    void init(ByteBuffer byteBuffer, byte[] bArr);
}
