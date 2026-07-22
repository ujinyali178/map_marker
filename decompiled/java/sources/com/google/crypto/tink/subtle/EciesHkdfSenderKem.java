package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* loaded from: /root/release/classes.dex */
public final class EciesHkdfSenderKem {
    private final ECPublicKey recipientPublicKey;

    public static final class KemKey {
        private final com.google.crypto.tink.util.Bytes kemBytes;
        private final com.google.crypto.tink.util.Bytes symmetricKey;

        public KemKey(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                throw new NullPointerException("KemBytes must be non-null");
            }
            if (bArr2 == null) {
                throw new NullPointerException("symmetricKey must be non-null");
            }
            this.kemBytes = com.google.crypto.tink.util.Bytes.copyFrom(bArr);
            this.symmetricKey = com.google.crypto.tink.util.Bytes.copyFrom(bArr2);
        }

        public byte[] getKemBytes() {
            return this.kemBytes.toByteArray();
        }

        public byte[] getSymmetricKey() {
            return this.symmetricKey.toByteArray();
        }
    }

    public EciesHkdfSenderKem(ECPublicKey eCPublicKey) {
        this.recipientPublicKey = eCPublicKey;
    }

    public KemKey generateKey(String str, byte[] bArr, byte[] bArr2, int i3, EllipticCurves.PointFormatType pointFormatType) {
        KeyPair generateKeyPair = EllipticCurves.generateKeyPair(this.recipientPublicKey.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
        byte[] computeSharedSecret = EllipticCurves.computeSharedSecret((ECPrivateKey) generateKeyPair.getPrivate(), this.recipientPublicKey);
        byte[] pointEncode = EllipticCurves.pointEncode(eCPublicKey.getParams().getCurve(), pointFormatType, eCPublicKey.getW());
        return new KemKey(pointEncode, Hkdf.computeEciesHkdfSymmetricKey(pointEncode, computeSharedSecret, str, bArr, bArr2, i3));
    }
}
