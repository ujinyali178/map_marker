package com.google.crypto.tink.mac;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public interface ChunkedMacVerification {
    void update(ByteBuffer byteBuffer);

    void verifyMac();
}
