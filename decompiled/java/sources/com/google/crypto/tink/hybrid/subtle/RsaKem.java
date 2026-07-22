package com.google.crypto.tink.hybrid.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* loaded from: /root/release/classes.dex */
class RsaKem {
    static final byte[] EMPTY_AAD = new byte[0];
    static final int MIN_RSA_KEY_LENGTH_BITS = 2048;

    private RsaKem() {
    }

    static int bigIntSizeInBytes(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) / 8;
    }

    static byte[] bigIntToByteArray(BigInteger bigInteger, int i3) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i3) {
            return byteArray;
        }
        byte[] bArr = new byte[i3];
        if (byteArray.length == i3 + 1) {
            if (byteArray[0] != 0) {
                throw new IllegalArgumentException("Value is one-byte longer than the expected size, but its first byte is not 0");
            }
            System.arraycopy(byteArray, 1, bArr, 0, i3);
        } else {
            if (byteArray.length >= i3) {
                throw new IllegalArgumentException(String.format("Value has invalid length, must be of length at most (%d + 1), but got %d", Integer.valueOf(i3), Integer.valueOf(byteArray.length)));
            }
            System.arraycopy(byteArray, 0, bArr, i3 - byteArray.length, byteArray.length);
        }
        return bArr;
    }

    static KeyPair generateRsaKeyPair(int i3) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(i3);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException("No support for RSA algorithm.", e3);
        }
    }

    static byte[] generateSecret(BigInteger bigInteger) {
        int bigIntSizeInBytes = bigIntSizeInBytes(bigInteger);
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            BigInteger bigInteger2 = new BigInteger(bigInteger.bitLength(), secureRandom);
            if (bigInteger2.signum() > 0 && bigInteger2.compareTo(bigInteger) < 0) {
                return bigIntToByteArray(bigInteger2, bigIntSizeInBytes);
            }
        }
    }

    static void validateRsaModulus(BigInteger bigInteger) {
        if (bigInteger.bitLength() < MIN_RSA_KEY_LENGTH_BITS) {
            throw new GeneralSecurityException(String.format("RSA key must be of at least size %d bits, but got %d", Integer.valueOf(MIN_RSA_KEY_LENGTH_BITS), Integer.valueOf(bigInteger.bitLength())));
        }
    }
}
