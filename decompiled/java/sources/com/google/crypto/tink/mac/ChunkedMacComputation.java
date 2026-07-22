package com.google.crypto.tink.mac;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public interface ChunkedMacComputation {
    byte[] computeMac();

    void update(ByteBuffer byteBuffer);
}
