package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.proto.HpkePublicKey;
import com.google.crypto.tink.subtle.Bytes;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: /root/release/classes.dex */
final class HpkeContext {
    private static final byte[] EMPTY_IKM = new byte[0];
    private final HpkeAead aead;
    private final byte[] baseNonce;
    private final byte[] encapsulatedKey;
    private final byte[] key;
    private final BigInteger maxSequenceNumber;
    private BigInteger sequenceNumber = BigInteger.ZERO;

    private HpkeContext(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, HpkeAead hpkeAead) {
        this.encapsulatedKey = bArr;
        this.key = bArr2;
        this.baseNonce = bArr3;
        this.maxSequenceNumber = bigInteger;
        this.aead = hpkeAead;
    }

    private byte[] computeNonce() {
        return Bytes.xor(this.baseNonce, BigIntegerEncoding.toBigEndianBytesOfFixedLength(this.sequenceNumber, this.aead.getNonceLength()));
    }

    private synchronized byte[] computeNonceAndIncrementSequenceNumber() {
        byte[] computeNonce;
        computeNonce = computeNonce();
        incrementSequenceNumber();
        return computeNonce;
    }

    static HpkeContext createContext(byte[] bArr, byte[] bArr2, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr3) {
        byte[] hpkeSuiteId = HpkeUtil.hpkeSuiteId(hpkeKem.getKemId(), hpkeKdf.getKdfId(), hpkeAead.getAeadId());
        byte[] bArr4 = HpkeUtil.EMPTY_SALT;
        byte[] bArr5 = EMPTY_IKM;
        byte[] concat = Bytes.concat(HpkeUtil.BASE_MODE, hpkeKdf.labeledExtract(bArr4, bArr5, "psk_id_hash", hpkeSuiteId), hpkeKdf.labeledExtract(bArr4, bArr3, "info_hash", hpkeSuiteId));
        byte[] labeledExtract = hpkeKdf.labeledExtract(bArr2, bArr5, "secret", hpkeSuiteId);
        return new HpkeContext(bArr, hpkeKdf.labeledExpand(labeledExtract, concat, "key", hpkeSuiteId, hpkeAead.getKeyLength()), hpkeKdf.labeledExpand(labeledExtract, concat, "base_nonce", hpkeSuiteId, hpkeAead.getNonceLength()), maxSequenceNumber(hpkeAead.getNonceLength()), hpkeAead);
    }

    static HpkeContext createRecipientContext(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr2) {
        return createContext(bArr, hpkeKem.decapsulate(bArr, hpkeKemPrivateKey), hpkeKem, hpkeKdf, hpkeAead, bArr2);
    }

    static HpkeContext createSenderContext(HpkePublicKey hpkePublicKey, HpkeKem hpkeKem, HpkeKdf hpkeKdf, HpkeAead hpkeAead, byte[] bArr) {
        HpkeKemEncapOutput encapsulate = hpkeKem.encapsulate(hpkePublicKey.getPublicKey().toByteArray());
        return createContext(encapsulate.getEncapsulatedKey(), encapsulate.getSharedSecret(), hpkeKem, hpkeKdf, hpkeAead, bArr);
    }

    private void incrementSequenceNumber() {
        if (this.sequenceNumber.compareTo(this.maxSequenceNumber) >= 0) {
            throw new GeneralSecurityException("message limit reached");
        }
        this.sequenceNumber = this.sequenceNumber.add(BigInteger.ONE);
    }

    private static BigInteger maxSequenceNumber(int i3) {
        BigInteger bigInteger = BigInteger.ONE;
        return bigInteger.shiftLeft(i3 * 8).subtract(bigInteger);
    }

    byte[] getBaseNonce() {
        return this.baseNonce;
    }

    byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    byte[] getKey() {
        return this.key;
    }

    byte[] open(byte[] bArr, byte[] bArr2) {
        return this.aead.open(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }

    byte[] seal(byte[] bArr, byte[] bArr2) {
        return this.aead.seal(this.key, computeNonceAndIncrementSequenceNumber(), bArr, bArr2);
    }
}
