package com.google.crypto.tink.subtle;

import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.KeyWrap;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
public class Kwp implements KeyWrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_WRAP_KEY_SIZE = 4096;
    static final int MIN_WRAP_KEY_SIZE = 16;
    static final byte[] PREFIX = {-90, 89, 89, -90};
    static final int ROUNDS = 6;
    private final SecretKey aesKey;

    public Kwp(byte[] bArr) {
        if (bArr.length != 16 && bArr.length != 32) {
            throw new GeneralSecurityException("Unsupported key length");
        }
        this.aesKey = new SecretKeySpec(bArr, "AES");
    }

    private byte[] computeW(byte[] bArr, byte[] bArr2) {
        if (bArr2.length <= 8 || bArr2.length > 2147483631 || bArr.length != 8) {
            throw new GeneralSecurityException("computeW called with invalid parameters");
        }
        int wrappingSize = wrappingSize(bArr2.length);
        byte[] bArr3 = new byte[wrappingSize];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, 8, bArr2.length);
        int i3 = 1;
        int i4 = (wrappingSize / 8) - 1;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(1, this.aesKey);
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr3, 0, bArr4, 0, 8);
        int i5 = 0;
        while (i5 < 6) {
            int i6 = 0;
            while (i6 < i4) {
                int i7 = i6 + 1;
                int i8 = i7 * 8;
                System.arraycopy(bArr3, i8, bArr4, 8, 8);
                engineFactory.doFinal(bArr4, 0, 16, bArr4);
                int i9 = (i5 * i4) + i6 + i3;
                for (int i10 = 0; i10 < 4; i10++) {
                    int i11 = 7 - i10;
                    bArr4[i11] = (byte) (((byte) (i9 & 255)) ^ bArr4[i11]);
                    i9 >>>= 8;
                }
                System.arraycopy(bArr4, 8, bArr3, i8, 8);
                i6 = i7;
                i3 = 1;
            }
            i5++;
            i3 = 1;
        }
        System.arraycopy(bArr4, 0, bArr3, 0, 8);
        return bArr3;
    }

    private byte[] invertW(byte[] bArr) {
        if (bArr.length < 24 || bArr.length % 8 != 0) {
            throw new GeneralSecurityException("Incorrect data size");
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        int length = (copyOf.length / 8) - 1;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(2, this.aesKey);
        byte[] bArr2 = new byte[16];
        System.arraycopy(copyOf, 0, bArr2, 0, 8);
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = length - 1; i4 >= 0; i4--) {
                int i5 = (i4 + 1) * 8;
                System.arraycopy(copyOf, i5, bArr2, 8, 8);
                int i6 = (i3 * length) + i4 + 1;
                for (int i7 = 0; i7 < 4; i7++) {
                    int i8 = 7 - i7;
                    bArr2[i8] = (byte) (bArr2[i8] ^ ((byte) (i6 & 255)));
                    i6 >>>= 8;
                }
                engineFactory.doFinal(bArr2, 0, 16, bArr2);
                System.arraycopy(bArr2, 8, copyOf, i5, 8);
            }
        }
        System.arraycopy(bArr2, 0, copyOf, 0, 8);
        return copyOf;
    }

    private int wrappingSize(int i3) {
        return i3 + (7 - ((i3 + 7) % 8)) + 8;
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] unwrap(byte[] bArr) {
        int i3;
        if (bArr.length < wrappingSize(16)) {
            throw new GeneralSecurityException("Wrapped key size is too small");
        }
        if (bArr.length > wrappingSize(4096)) {
            throw new GeneralSecurityException("Wrapped key size is too large");
        }
        if (bArr.length % 8 != 0) {
            throw new GeneralSecurityException("Wrapped key size must be a multiple of 8 bytes");
        }
        byte[] invertW = invertW(bArr);
        boolean z3 = true;
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= 4) {
                break;
            }
            if (PREFIX[i4] != invertW[i4]) {
                z3 = false;
            }
            i4++;
        }
        int i5 = 0;
        for (i3 = 4; i3 < 8; i3++) {
            i5 = (i5 << 8) + (invertW[i3] & UnsignedBytes.MAX_VALUE);
        }
        if (wrappingSize(i5) == invertW.length) {
            for (int i6 = i5 + 8; i6 < invertW.length; i6++) {
                if (invertW[i6] != 0) {
                    z3 = false;
                }
            }
            z4 = z3;
        }
        if (z4) {
            return Arrays.copyOfRange(invertW, 8, i5 + 8);
        }
        throw new BadPaddingException("Invalid padding");
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] wrap(byte[] bArr) {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Key size of key to wrap too small");
        }
        if (bArr.length > 4096) {
            throw new GeneralSecurityException("Key size of key to wrap too large");
        }
        byte[] bArr2 = new byte[8];
        byte[] bArr3 = PREFIX;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        for (int i3 = 0; i3 < 4; i3++) {
            bArr2[i3 + 4] = (byte) ((bArr.length >> ((3 - i3) * 8)) & 255);
        }
        return computeW(bArr2, bArr);
    }
}
