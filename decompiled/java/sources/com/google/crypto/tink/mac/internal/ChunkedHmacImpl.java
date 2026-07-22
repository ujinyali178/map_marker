package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.mac.HmacKey;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
/* loaded from: /root/release/classes.dex */
public final class ChunkedHmacImpl implements ChunkedMac {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final HmacKey key;

    public ChunkedHmacImpl(HmacKey hmacKey) {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.key = hmacKey;
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacComputation createComputation() {
        return new ChunkedHmacComputation(this.key);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacVerification createVerification(byte[] bArr) {
        if (bArr.length < this.key.getOutputPrefix().size()) {
            throw new GeneralSecurityException("Tag too short");
        }
        if (this.key.getOutputPrefix().equals(Bytes.copyFrom(bArr, 0, this.key.getOutputPrefix().size()))) {
            return new ChunkedHmacVerification(this.key, bArr);
        }
        throw new GeneralSecurityException("Wrong tag prefix");
    }
}
