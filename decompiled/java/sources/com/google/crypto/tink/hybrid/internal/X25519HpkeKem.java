package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.X25519;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@Immutable
/* loaded from: /root/release/classes.dex */
final class X25519HpkeKem implements HpkeKem {
    private final HkdfHpkeKdf hkdf;

    X25519HpkeKem(HkdfHpkeKdf hkdfHpkeKdf) {
        this.hkdf = hkdfHpkeKdf;
    }

    private byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] concat = Bytes.concat(bArr2, bArr3);
        byte[] kemSuiteId = HpkeUtil.kemSuiteId(HpkeUtil.X25519_HKDF_SHA256_KEM_ID);
        HkdfHpkeKdf hkdfHpkeKdf = this.hkdf;
        return hkdfHpkeKdf.extractAndExpand(null, bArr, "eae_prk", concat, "shared_secret", kemSuiteId, hkdfHpkeKdf.getMacLength());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) {
        return deriveKemSharedSecret(X25519.computeSharedSecret(hpkeKemPrivateKey.getSerializedPrivate().toByteArray(), bArr), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] bArr) {
        return encapsulate(bArr, X25519.generatePrivateKey());
    }

    HpkeKemEncapOutput encapsulate(byte[] bArr, byte[] bArr2) {
        byte[] computeSharedSecret = X25519.computeSharedSecret(bArr2, bArr);
        byte[] publicFromPrivate = X25519.publicFromPrivate(bArr2);
        return new HpkeKemEncapOutput(deriveKemSharedSecret(computeSharedSecret, publicFromPrivate, bArr), publicFromPrivate);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKem
    public byte[] getKemId() {
        if (Arrays.equals(this.hkdf.getKdfId(), HpkeUtil.HKDF_SHA256_KDF_ID)) {
            return HpkeUtil.X25519_HKDF_SHA256_KEM_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
