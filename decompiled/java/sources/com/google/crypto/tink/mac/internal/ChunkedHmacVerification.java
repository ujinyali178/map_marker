package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.util.Bytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: /root/release/classes.dex */
final class ChunkedHmacVerification implements ChunkedMacVerification {
    private final ChunkedHmacComputation hmacComputation;
    private final Bytes tag;

    ChunkedHmacVerification(HmacKey hmacKey, byte[] bArr) {
        this.hmacComputation = new ChunkedHmacComputation(hmacKey);
        this.tag = Bytes.copyFrom(bArr);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void update(ByteBuffer byteBuffer) {
        this.hmacComputation.update(byteBuffer);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMacVerification
    public void verifyMac() {
        if (!this.tag.equals(Bytes.copyFrom(this.hmacComputation.computeMac()))) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
