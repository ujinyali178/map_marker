package com.google.crypto.tink.subtle;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Enums;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/* loaded from: /root/release/classes.dex */
public final class SubtleUtil {

    /* renamed from: com.google.crypto.tink.subtle.SubtleUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private SubtleUtil() {
    }

    @Deprecated
    public static int androidApiLevel() {
        Integer androidApiLevel = Util.getAndroidApiLevel();
        if (androidApiLevel != null) {
            return androidApiLevel.intValue();
        }
        return -1;
    }

    public static BigInteger bytes2Integer(byte[] bArr) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(bArr);
    }

    public static byte[] integer2Bytes(BigInteger bigInteger, int i3) {
        return BigIntegerEncoding.toBigEndianBytesOfFixedLength(bigInteger, i3);
    }

    public static boolean isAndroid() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    public static byte[] mgf1(byte[] bArr, int i3, Enums.HashType hashType) {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(toDigestAlgo(hashType));
        int digestLength = engineFactory.getDigestLength();
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        for (int i5 = 0; i5 <= (i3 - 1) / digestLength; i5++) {
            engineFactory.reset();
            engineFactory.update(bArr);
            engineFactory.update(integer2Bytes(BigInteger.valueOf(i5), 4));
            byte[] digest = engineFactory.digest();
            System.arraycopy(digest, 0, bArr2, i4, Math.min(digest.length, i3 - i4));
            i4 += digest.length;
        }
        return bArr2;
    }

    public static void putAsUnsigedInt(ByteBuffer byteBuffer, long j3) {
        if (0 > j3 || j3 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBuffer.putInt((int) j3);
    }

    public static String toDigestAlgo(Enums.HashType hashType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i3 == 1) {
            return "SHA-1";
        }
        if (i3 == 2) {
            return "SHA-224";
        }
        if (i3 == 3) {
            return "SHA-256";
        }
        if (i3 == 4) {
            return "SHA-384";
        }
        if (i3 == 5) {
            return "SHA-512";
        }
        throw new GeneralSecurityException("Unsupported hash " + hashType);
    }

    public static String toEcdsaAlgo(Enums.HashType hashType) {
        Validators.validateSignatureHash(hashType);
        return hashType + "withECDSA";
    }

    public static String toRsaSsaPkcs1Algo(Enums.HashType hashType) {
        Validators.validateSignatureHash(hashType);
        return hashType + "withRSA";
    }
}
