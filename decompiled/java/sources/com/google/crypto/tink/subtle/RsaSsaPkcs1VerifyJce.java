package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;

@Immutable
/* loaded from: /root/release/classes.dex */
public final class RsaSsaPkcs1VerifyJce implements PublicKeyVerify {
    private static final String ASN_PREFIX_SHA256 = "3031300d060960864801650304020105000420";
    private static final String ASN_PREFIX_SHA384 = "3041300d060960864801650304020205000430";
    private static final String ASN_PREFIX_SHA512 = "3051300d060960864801650304020305000440";
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final Enums.HashType hash;
    private final RSAPublicKey publicKey;

    /* renamed from: com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RsaSsaPkcs1VerifyJce(RSAPublicKey rSAPublicKey, Enums.HashType hashType) {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA-PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPublicKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPublicKey.getPublicExponent());
        this.publicKey = rSAPublicKey;
        this.hash = hashType;
    }

    private byte[] emsaPkcs1(byte[] bArr, int i3, Enums.HashType hashType) {
        Validators.validateSignatureHash(hashType);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.hash));
        engineFactory.update(bArr);
        byte[] digest = engineFactory.digest();
        byte[] asnPrefix = toAsnPrefix(hashType);
        if (i3 < asnPrefix.length + digest.length + 11) {
            throw new GeneralSecurityException("intended encoded message length too short");
        }
        byte[] bArr2 = new byte[i3];
        bArr2[0] = 0;
        int i4 = 2;
        bArr2[1] = 1;
        int i5 = 0;
        while (i5 < (i3 - r0) - 3) {
            bArr2[i4] = -1;
            i5++;
            i4++;
        }
        int i6 = i4 + 1;
        bArr2[i4] = 0;
        System.arraycopy(asnPrefix, 0, bArr2, i6, asnPrefix.length);
        System.arraycopy(digest, 0, bArr2, i6 + asnPrefix.length, digest.length);
        return bArr2;
    }

    private byte[] toAsnPrefix(Enums.HashType hashType) {
        String str;
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i3 == 1) {
            str = ASN_PREFIX_SHA256;
        } else if (i3 == 2) {
            str = ASN_PREFIX_SHA384;
        } else {
            if (i3 != 3) {
                throw new GeneralSecurityException("Unsupported hash " + hashType);
            }
            str = ASN_PREFIX_SHA512;
        }
        return Hex.decode(str);
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) {
        BigInteger publicExponent = this.publicKey.getPublicExponent();
        BigInteger modulus = this.publicKey.getModulus();
        int bitLength = (modulus.bitLength() + 7) / 8;
        if (bitLength != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bytes2Integer = SubtleUtil.bytes2Integer(bArr);
        if (bytes2Integer.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        if (!Bytes.equal(SubtleUtil.integer2Bytes(bytes2Integer.modPow(publicExponent, modulus), bitLength), emsaPkcs1(bArr2, bitLength, this.hash))) {
            throw new GeneralSecurityException("invalid signature");
        }
    }
}
