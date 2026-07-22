package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private final int blockSize;
    private final int ivSize;
    private final SecretKeySpec keySpec;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesCtrJceCipher.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance(AesCtrJceCipher.CIPHER_ALGORITHM);
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
    };

    public AesCtrJceCipher(byte[] bArr, int i3) {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, KEY_ALGORITHM);
        int blockSize = localCipher.get().getBlockSize();
        this.blockSize = blockSize;
        if (i3 < 12 || i3 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.ivSize = i3;
    }

    private void doCtr(byte[] bArr, int i3, int i4, byte[] bArr2, int i5, byte[] bArr3, boolean z3) {
        Cipher cipher = localCipher.get();
        byte[] bArr4 = new byte[this.blockSize];
        System.arraycopy(bArr3, 0, bArr4, 0, this.ivSize);
        cipher.init(z3 ? 1 : 2, this.keySpec, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i3, i4, bArr2, i5) != i4) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(byte[] bArr) {
        int length = bArr.length;
        int i3 = this.ivSize;
        if (length < i3) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        int length2 = bArr.length;
        int i4 = this.ivSize;
        byte[] bArr3 = new byte[length2 - i4];
        doCtr(bArr, i4, bArr.length - i4, bArr3, 0, bArr2, false);
        return bArr3;
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(byte[] bArr) {
        int length = bArr.length;
        int i3 = this.ivSize;
        if (length > Integer.MAX_VALUE - i3) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.ivSize));
        }
        byte[] bArr2 = new byte[bArr.length + i3];
        byte[] randBytes = Random.randBytes(i3);
        System.arraycopy(randBytes, 0, bArr2, 0, this.ivSize);
        doCtr(bArr, 0, bArr.length, bArr2, this.ivSize, randBytes, true);
        return bArr2;
    }
}
