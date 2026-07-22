package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public final class X25519 {
    private X25519() {
    }

    public static byte[] computeSharedSecret(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] copyOf = Arrays.copyOf(bArr, 32);
        copyOf[0] = (byte) (copyOf[0] & 248);
        byte b4 = (byte) (copyOf[31] & Ascii.DEL);
        copyOf[31] = b4;
        copyOf[31] = (byte) (b4 | SignedBytes.MAX_POWER_OF_TWO);
        Curve25519.curveMult(jArr, copyOf, bArr2);
        return Field25519.contract(jArr);
    }

    public static byte[] generatePrivateKey() {
        byte[] randBytes = Random.randBytes(32);
        randBytes[0] = (byte) (randBytes[0] | 7);
        byte b4 = (byte) (randBytes[31] & 63);
        randBytes[31] = b4;
        randBytes[31] = (byte) (b4 | UnsignedBytes.MAX_POWER_OF_TWO);
        return randBytes;
    }

    public static byte[] publicFromPrivate(byte[] bArr) {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return computeSharedSecret(bArr, bArr2);
    }
}
