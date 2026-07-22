package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public interface StreamSegmentEncrypter {
    void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z3, ByteBuffer byteBuffer3);

    void encryptSegment(ByteBuffer byteBuffer, boolean z3, ByteBuffer byteBuffer2);

    ByteBuffer getHeader();
}
