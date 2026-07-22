package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /root/release/classes.dex */
final class ChunkedAesCmacVerification implements ChunkedMacVerification {
    private final ChunkedAesCmacComputation aesCmacComputation;
    private final Bytes tag;

    ChunkedAesCmacVerification(AesCmacKey aesCmacKey, byte[] bArr) {
        this.aesCmacComputation = new ChunkedAesCmacComputation(aesCmacKey);
        this.tag = Bytes.copyFrom(bArr);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void update(ByteBuffer byteBuffer) {
        this.aesCmacComputation.update(byteBuffer);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void verifyMac() {
        if (!this.tag.equals(Bytes.copyFrom(this.aesCmacComputation.computeMac()))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
