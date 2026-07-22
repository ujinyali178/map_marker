package com.google.crypto.tink.subtle;

import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
public final class AesEaxJce implements Aead {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BLOCK_SIZE_IN_BYTES = 16;
    static final int TAG_SIZE_IN_BYTES = 16;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2354b;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;

    /* renamed from: p, reason: collision with root package name */
    private final byte[] f2355p;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
    };
    private static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesEaxJce.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
    };

    public AesEaxJce(byte[] bArr, int i3) {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i3 != 12 && i3 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.ivSizeInBytes = i3;
        Validators.validateAesKeySize(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.keySpec = secretKeySpec;
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, secretKeySpec);
        byte[] multiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
        this.f2354b = multiplyByX;
        this.f2355p = multiplyByX(multiplyByX);
    }

    private static byte[] multiplyByX(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i3 = 0;
        while (i3 < 15) {
            int i4 = i3 + 1;
            bArr2[i3] = (byte) (((bArr[i3] << 1) ^ ((bArr[i4] & UnsignedBytes.MAX_VALUE) >>> 7)) & 255);
            i3 = i4;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private byte[] omac(Cipher cipher, int i3, byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i3;
        if (i5 == 0) {
            return cipher.doFinal(xor(bArr2, this.f2354b));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i6 = 0;
        while (i5 - i6 > 16) {
            for (int i7 = 0; i7 < 16; i7++) {
                doFinal[i7] = (byte) (doFinal[i7] ^ bArr[(i4 + i6) + i7]);
            }
            doFinal = cipher.doFinal(doFinal);
            i6 += 16;
        }
        return cipher.doFinal(xor(doFinal, pad(Arrays.copyOfRange(bArr, i6 + i4, i4 + i5))));
    }

    private byte[] pad(byte[] bArr) {
        if (bArr.length == 16) {
            return xor(bArr, this.f2354b);
        }
        byte[] copyOf = Arrays.copyOf(this.f2355p, 16);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            copyOf[i3] = (byte) (copyOf[i3] ^ bArr[i3]);
        }
        copyOf[bArr.length] = (byte) (copyOf[bArr.length] ^ UnsignedBytes.MAX_POWER_OF_TWO);
        return copyOf;
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
        }
        return bArr3;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        int length = (bArr.length - this.ivSizeInBytes) - 16;
        if (length < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, this.keySpec);
        byte[] omac = omac(cipher, 0, bArr, 0, this.ivSizeInBytes);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] omac2 = omac(cipher, 1, bArr3, 0, bArr3.length);
        byte[] omac3 = omac(cipher, 2, bArr, this.ivSizeInBytes, length);
        int length2 = bArr.length - 16;
        byte b4 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            b4 = (byte) (b4 | (((bArr[length2 + i3] ^ omac2[i3]) ^ omac[i3]) ^ omac3[i3]));
        }
        if (b4 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = localCtrCipher.get();
        cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
        return cipher2.doFinal(bArr, this.ivSizeInBytes, length);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i3 = this.ivSizeInBytes;
        if (length > (Integer.MAX_VALUE - i3) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i3 + 16];
        byte[] randBytes = Random.randBytes(i3);
        System.arraycopy(randBytes, 0, bArr3, 0, this.ivSizeInBytes);
        Cipher cipher = localEcbCipher.get();
        cipher.init(1, this.keySpec);
        byte[] omac = omac(cipher, 0, randBytes, 0, randBytes.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] omac2 = omac(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = localCtrCipher.get();
        cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.ivSizeInBytes);
        byte[] omac3 = omac(cipher, 2, bArr3, this.ivSizeInBytes, bArr.length);
        int length2 = bArr.length + this.ivSizeInBytes;
        for (int i4 = 0; i4 < 16; i4++) {
            bArr3[length2 + i4] = (byte) ((omac2[i4] ^ omac[i4]) ^ omac3[i4]);
        }
        return bArr3;
    }
}
