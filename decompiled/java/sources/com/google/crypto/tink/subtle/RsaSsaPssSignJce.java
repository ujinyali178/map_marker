package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

@Immutable
/* loaded from: /root/release/classes.dex */
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType, Enums.HashType hashType2, int i3) {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(hashType);
        Validators.validateRsaModulusSize(rSAPrivateCrtKey.getModulus().bitLength());
        Validators.validateRsaPublicExponent(rSAPrivateCrtKey.getPublicExponent());
        this.privateKey = rSAPrivateCrtKey;
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
        this.sigHash = hashType;
        this.mgf1Hash = hashType2;
        this.saltLength = i3;
    }

    private byte[] emsaPssEncode(byte[] bArr, int i3) {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = engineFactory.digest(bArr);
        int digestLength = engineFactory.getDigestLength();
        int i4 = ((i3 - 1) / 8) + 1;
        int i5 = this.saltLength;
        if (i4 < digestLength + i5 + 2) {
            throw new GeneralSecurityException("encoding error");
        }
        byte[] randBytes = Random.randBytes(i5);
        int i6 = digestLength + 8;
        byte[] bArr2 = new byte[this.saltLength + i6];
        System.arraycopy(digest, 0, bArr2, 8, digestLength);
        System.arraycopy(randBytes, 0, bArr2, i6, randBytes.length);
        byte[] digest2 = engineFactory.digest(bArr2);
        int i7 = (i4 - digestLength) - 1;
        byte[] bArr3 = new byte[i7];
        int i8 = this.saltLength;
        bArr3[((i4 - i8) - digestLength) - 2] = 1;
        System.arraycopy(randBytes, 0, bArr3, ((i4 - i8) - digestLength) - 1, randBytes.length);
        byte[] mgf1 = SubtleUtil.mgf1(digest2, i7, this.mgf1Hash);
        byte[] bArr4 = new byte[i7];
        for (int i9 = 0; i9 < i7; i9++) {
            bArr4[i9] = (byte) (bArr3[i9] ^ mgf1[i9]);
        }
        for (int i10 = 0; i10 < (i4 * 8) - i3; i10++) {
            int i11 = i10 / 8;
            bArr4[i11] = (byte) ((~(1 << (7 - (i10 % 8)))) & bArr4[i11]);
        }
        int i12 = digestLength + i7;
        byte[] bArr5 = new byte[i12 + 1];
        System.arraycopy(bArr4, 0, bArr5, 0, i7);
        System.arraycopy(digest2, 0, bArr5, i7, digest2.length);
        bArr5[i12] = -68;
        return bArr5;
    }

    private byte[] rsasp1(byte[] bArr) {
        EngineFactory<EngineWrapper.TCipher, Cipher> engineFactory = EngineFactory.CIPHER;
        Cipher engineFactory2 = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        engineFactory2.init(2, this.privateKey);
        byte[] doFinal = engineFactory2.doFinal(bArr);
        Cipher engineFactory3 = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        engineFactory3.init(1, this.publicKey);
        if (new BigInteger(1, bArr).equals(new BigInteger(1, engineFactory3.doFinal(doFinal)))) {
            return doFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(byte[] bArr) {
        return rsasp1(emsaPssEncode(bArr, this.publicKey.getModulus().bitLength() - 1));
    }
}
