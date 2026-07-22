package com.google.crypto.tink.subtle;

import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* loaded from: /root/release/classes.dex */
public final class EllipticCurves {

    /* renamed from: com.google.crypto.tink.subtle.EllipticCurves$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType;

        static {
            int[] iArr = new int[CurveType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = iArr;
            try {
                iArr[CurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[CurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[CurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PointFormatType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType = iArr2;
            try {
                iArr2[PointFormatType.UNCOMPRESSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[PointFormatType.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum CurveType {
        NIST_P256,
        NIST_P384,
        NIST_P521
    }

    public enum EcdsaEncoding {
        IEEE_P1363,
        DER
    }

    public enum PointFormatType {
        UNCOMPRESSED,
        COMPRESSED,
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED
    }

    private EllipticCurves() {
    }

    static void checkPublicKey(ECPublicKey eCPublicKey) {
        EllipticCurvesUtil.checkPointOnCurve(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        return computeSharedSecret(eCPrivateKey, eCPublicKey.getW());
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPoint eCPoint) {
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement engineFactory = EngineFactory.KEY_AGREEMENT.getInstance("ECDH");
        engineFactory.init(eCPrivateKey);
        try {
            engineFactory.doPhase(generatePublic, true);
            byte[] generateSecret = engineFactory.generateSecret();
            validateSharedSecret(generateSecret, eCPrivateKey);
            return generateSecret;
        } catch (IllegalStateException e3) {
            throw new GeneralSecurityException(e3);
        }
    }

    public static ECPoint ecPointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) {
        return pointDecode(ellipticCurve, pointFormatType, bArr);
    }

    public static byte[] ecdsaDer2Ieee(byte[] bArr, int i3) {
        if (!isValidDerEncoding(bArr)) {
            throw new GeneralSecurityException("Invalid DER encoding");
        }
        byte[] bArr2 = new byte[i3];
        int i4 = ((bArr[1] & UnsignedBytes.MAX_VALUE) >= 128 ? 3 : 2) + 1;
        int i5 = i4 + 1;
        int i6 = bArr[i4];
        int i7 = bArr[i5] == 0 ? 1 : 0;
        System.arraycopy(bArr, i5 + i7, bArr2, ((i3 / 2) - i6) + i7, i6 - i7);
        int i8 = i5 + i6 + 1;
        int i9 = i8 + 1;
        int i10 = bArr[i8];
        int i11 = bArr[i9] != 0 ? 0 : 1;
        System.arraycopy(bArr, i9 + i11, bArr2, (i3 - i10) + i11, i10 - i11);
        return bArr2;
    }

    public static byte[] ecdsaIeee2Der(byte[] bArr) {
        byte[] bArr2;
        int i3;
        if (bArr.length % 2 != 0 || bArr.length == 0 || bArr.length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        byte[] minimalSignedNumber = toMinimalSignedNumber(Arrays.copyOf(bArr, bArr.length / 2));
        byte[] minimalSignedNumber2 = toMinimalSignedNumber(Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length));
        int length = minimalSignedNumber.length + 2 + 1 + 1 + minimalSignedNumber2.length;
        if (length >= 128) {
            bArr2 = new byte[length + 3];
            bArr2[0] = 48;
            bArr2[1] = -127;
            bArr2[2] = (byte) length;
            i3 = 3;
        } else {
            bArr2 = new byte[length + 2];
            bArr2[0] = 48;
            bArr2[1] = (byte) length;
            i3 = 2;
        }
        int i4 = i3 + 1;
        bArr2[i3] = 2;
        int i5 = i4 + 1;
        bArr2[i4] = (byte) minimalSignedNumber.length;
        System.arraycopy(minimalSignedNumber, 0, bArr2, i5, minimalSignedNumber.length);
        int length2 = i5 + minimalSignedNumber.length;
        int i6 = length2 + 1;
        bArr2[length2] = 2;
        bArr2[i6] = (byte) minimalSignedNumber2.length;
        System.arraycopy(minimalSignedNumber2, 0, bArr2, i6 + 1, minimalSignedNumber2.length);
        return bArr2;
    }

    public static int encodingSizeInBytes(EllipticCurve ellipticCurve, PointFormatType pointFormatType) {
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        if (i3 == 1) {
            return (fieldSizeInBytes * 2) + 1;
        }
        if (i3 == 2) {
            return fieldSizeInBytes * 2;
        }
        if (i3 == 3) {
            return fieldSizeInBytes + 1;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static int fieldSizeInBits(EllipticCurve ellipticCurve) {
        return getModulus(ellipticCurve).subtract(BigInteger.ONE).bitLength();
    }

    public static int fieldSizeInBytes(EllipticCurve ellipticCurve) {
        return (fieldSizeInBits(ellipticCurve) + 7) / 8;
    }

    public static KeyPair generateKeyPair(CurveType curveType) {
        return generateKeyPair(getCurveSpec(curveType));
    }

    public static KeyPair generateKeyPair(ECParameterSpec eCParameterSpec) {
        KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("EC");
        engineFactory.initialize(eCParameterSpec);
        return engineFactory.generateKeyPair();
    }

    public static ECParameterSpec getCurveSpec(CurveType curveType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[curveType.ordinal()];
        if (i3 == 1) {
            return getNistP256Params();
        }
        if (i3 == 2) {
            return getNistP384Params();
        }
        if (i3 == 3) {
            return getNistP521Params();
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + curveType);
    }

    public static ECPrivateKey getEcPrivateKey(CurveType curveType, byte[] bArr) {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new ECPrivateKeySpec(BigIntegerEncoding.fromUnsignedBigEndianBytes(bArr), getCurveSpec(curveType)));
    }

    public static ECPrivateKey getEcPrivateKey(byte[] bArr) {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) {
        return getEcPublicKey(getCurveSpec(curveType), pointFormatType, bArr);
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, byte[] bArr, byte[] bArr2) {
        ECParameterSpec curveSpec = getCurveSpec(curveType);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, curveSpec.getCurve());
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, curveSpec));
    }

    public static ECPublicKey getEcPublicKey(ECParameterSpec eCParameterSpec, PointFormatType pointFormatType, byte[] bArr) {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(pointDecode(eCParameterSpec.getCurve(), pointFormatType, bArr), eCParameterSpec));
    }

    public static ECPublicKey getEcPublicKey(byte[] bArr) {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static BigInteger getModulus(EllipticCurve ellipticCurve) {
        return EllipticCurvesUtil.getModulus(ellipticCurve);
    }

    public static ECParameterSpec getNistP256Params() {
        return EllipticCurvesUtil.NIST_P256_PARAMS;
    }

    public static ECParameterSpec getNistP384Params() {
        return EllipticCurvesUtil.NIST_P384_PARAMS;
    }

    public static ECParameterSpec getNistP521Params() {
        return EllipticCurvesUtil.NIST_P521_PARAMS;
    }

    public static BigInteger getY(BigInteger bigInteger, boolean z3, EllipticCurve ellipticCurve) {
        BigInteger modulus = getModulus(ellipticCurve);
        BigInteger modSqrt = modSqrt(bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(modulus), modulus);
        return z3 != modSqrt.testBit(0) ? modulus.subtract(modSqrt).mod(modulus) : modSqrt;
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec eCParameterSpec) {
        return EllipticCurvesUtil.isNistEcParameterSpec(eCParameterSpec);
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec eCParameterSpec, ECParameterSpec eCParameterSpec2) {
        return EllipticCurvesUtil.isSameEcParameterSpec(eCParameterSpec, eCParameterSpec2);
    }

    public static boolean isValidDerEncoding(byte[] bArr) {
        int i3;
        if (bArr.length < 8 || bArr[0] != 48) {
            return false;
        }
        int i4 = bArr[1] & UnsignedBytes.MAX_VALUE;
        if (i4 == 129) {
            i4 = bArr[2] & UnsignedBytes.MAX_VALUE;
            if (i4 < 128) {
                return false;
            }
            i3 = 2;
        } else {
            if (i4 == 128 || i4 > 129) {
                return false;
            }
            i3 = 1;
        }
        if (i4 != (bArr.length - 1) - i3) {
            return false;
        }
        int i5 = i3 + 1;
        if (bArr[i5] != 2) {
            return false;
        }
        int i6 = i5 + 1;
        int i7 = bArr[i6] & UnsignedBytes.MAX_VALUE;
        int i8 = i6 + 1 + i7 + 1;
        if (i8 >= bArr.length || i7 == 0) {
            return false;
        }
        int i9 = i3 + 3;
        byte b4 = bArr[i9];
        if ((b4 & UnsignedBytes.MAX_VALUE) >= 128) {
            return false;
        }
        if ((i7 > 1 && b4 == 0 && (bArr[i3 + 4] & UnsignedBytes.MAX_VALUE) < 128) || bArr[i9 + i7] != 2) {
            return false;
        }
        int i10 = bArr[i8] & UnsignedBytes.MAX_VALUE;
        if (i8 + 1 + i10 != bArr.length || i10 == 0) {
            return false;
        }
        byte b5 = bArr[i3 + 5 + i7];
        if ((b5 & UnsignedBytes.MAX_VALUE) >= 128) {
            return false;
        }
        return i10 <= 1 || b5 != 0 || (bArr[(i3 + 6) + i7] & UnsignedBytes.MAX_VALUE) >= 128;
    }

    protected static BigInteger modSqrt(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger mod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = BigInteger.ZERO;
        if (mod.equals(bigInteger4)) {
            return bigInteger4;
        }
        int i3 = 0;
        if (bigInteger2.testBit(0) && bigInteger2.testBit(1)) {
            bigInteger3 = mod.modPow(bigInteger2.add(BigInteger.ONE).shiftRight(2), bigInteger2);
        } else if (bigInteger2.testBit(0) && !bigInteger2.testBit(1)) {
            BigInteger bigInteger5 = BigInteger.ONE;
            BigInteger shiftRight = bigInteger2.subtract(bigInteger5).shiftRight(1);
            while (true) {
                BigInteger mod2 = bigInteger5.multiply(bigInteger5).subtract(mod).mod(bigInteger2);
                if (mod2.equals(BigInteger.ZERO)) {
                    return bigInteger5;
                }
                BigInteger modPow = mod2.modPow(shiftRight, bigInteger2);
                BigInteger bigInteger6 = BigInteger.ONE;
                if (modPow.add(bigInteger6).equals(bigInteger2)) {
                    BigInteger shiftRight2 = bigInteger2.add(bigInteger6).shiftRight(1);
                    BigInteger bigInteger7 = bigInteger5;
                    for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                        BigInteger multiply = bigInteger7.multiply(bigInteger6);
                        bigInteger7 = bigInteger7.multiply(bigInteger7).add(bigInteger6.multiply(bigInteger6).mod(bigInteger2).multiply(mod2)).mod(bigInteger2);
                        BigInteger mod3 = multiply.add(multiply).mod(bigInteger2);
                        if (shiftRight2.testBit(bitLength)) {
                            BigInteger mod4 = bigInteger7.multiply(bigInteger5).add(mod3.multiply(mod2)).mod(bigInteger2);
                            bigInteger6 = bigInteger5.multiply(mod3).add(bigInteger7).mod(bigInteger2);
                            bigInteger7 = mod4;
                        } else {
                            bigInteger6 = mod3;
                        }
                    }
                    bigInteger3 = bigInteger7;
                } else {
                    if (!modPow.equals(bigInteger6)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                    bigInteger5 = bigInteger5.add(bigInteger6);
                    i3++;
                    if (i3 == 128 && !bigInteger2.isProbablePrime(80)) {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                }
            }
        }
        if (bigInteger3 == null || bigInteger3.multiply(bigInteger3).mod(bigInteger2).compareTo(mod) == 0) {
            return bigInteger3;
        }
        throw new GeneralSecurityException("Could not find a modular square root");
    }

    public static ECPoint pointDecode(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) {
        return pointDecode(getCurveSpec(curveType).getCurve(), pointFormatType, bArr);
    }

    public static ECPoint pointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) {
        ECPoint eCPoint;
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        boolean z3 = false;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new GeneralSecurityException("invalid format:" + pointFormatType);
                }
                BigInteger modulus = getModulus(ellipticCurve);
                if (bArr.length != fieldSizeInBytes + 1) {
                    throw new GeneralSecurityException("compressed point has wrong length");
                }
                byte b4 = bArr[0];
                if (b4 != 2) {
                    if (b4 != 3) {
                        throw new GeneralSecurityException("invalid format");
                    }
                    z3 = true;
                }
                BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
                if (bigInteger.signum() == -1 || bigInteger.compareTo(modulus) >= 0) {
                    throw new GeneralSecurityException("x is out of range");
                }
                return new ECPoint(bigInteger, getY(bigInteger, z3, ellipticCurve));
            }
            if (bArr.length != fieldSizeInBytes * 2) {
                throw new GeneralSecurityException("invalid point size");
            }
            eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, fieldSizeInBytes)), new BigInteger(1, Arrays.copyOfRange(bArr, fieldSizeInBytes, bArr.length)));
        } else {
            if (bArr.length != (fieldSizeInBytes * 2) + 1) {
                throw new GeneralSecurityException("invalid point size");
            }
            if (bArr[0] != 4) {
                throw new GeneralSecurityException("invalid point format");
            }
            int i4 = fieldSizeInBytes + 1;
            eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i4)), new BigInteger(1, Arrays.copyOfRange(bArr, i4, bArr.length)));
        }
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, ellipticCurve);
        return eCPoint;
    }

    public static byte[] pointEncode(CurveType curveType, PointFormatType pointFormatType, ECPoint eCPoint) {
        return pointEncode(getCurveSpec(curveType).getCurve(), pointFormatType, eCPoint);
    }

    public static byte[] pointEncode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, ECPoint eCPoint) {
        EllipticCurvesUtil.checkPointOnCurve(eCPoint, ellipticCurve);
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        if (i3 == 1) {
            int i4 = (fieldSizeInBytes * 2) + 1;
            byte[] bArr = new byte[i4];
            byte[] bigEndianBytes = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineX());
            byte[] bigEndianBytes2 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineY());
            System.arraycopy(bigEndianBytes2, 0, bArr, i4 - bigEndianBytes2.length, bigEndianBytes2.length);
            System.arraycopy(bigEndianBytes, 0, bArr, (fieldSizeInBytes + 1) - bigEndianBytes.length, bigEndianBytes.length);
            bArr[0] = 4;
            return bArr;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new GeneralSecurityException("invalid format:" + pointFormatType);
            }
            int i5 = fieldSizeInBytes + 1;
            byte[] bArr2 = new byte[i5];
            byte[] bigEndianBytes3 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineX());
            System.arraycopy(bigEndianBytes3, 0, bArr2, i5 - bigEndianBytes3.length, bigEndianBytes3.length);
            bArr2[0] = (byte) (eCPoint.getAffineY().testBit(0) ? 3 : 2);
            return bArr2;
        }
        int i6 = fieldSizeInBytes * 2;
        byte[] bArr3 = new byte[i6];
        byte[] bigEndianBytes4 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineX());
        if (bigEndianBytes4.length > fieldSizeInBytes) {
            bigEndianBytes4 = Arrays.copyOfRange(bigEndianBytes4, bigEndianBytes4.length - fieldSizeInBytes, bigEndianBytes4.length);
        }
        byte[] bigEndianBytes5 = BigIntegerEncoding.toBigEndianBytes(eCPoint.getAffineY());
        if (bigEndianBytes5.length > fieldSizeInBytes) {
            bigEndianBytes5 = Arrays.copyOfRange(bigEndianBytes5, bigEndianBytes5.length - fieldSizeInBytes, bigEndianBytes5.length);
        }
        System.arraycopy(bigEndianBytes5, 0, bArr3, i6 - bigEndianBytes5.length, bigEndianBytes5.length);
        System.arraycopy(bigEndianBytes4, 0, bArr3, fieldSizeInBytes - bigEndianBytes4.length, bigEndianBytes4.length);
        return bArr3;
    }

    private static byte[] toMinimalSignedNumber(byte[] bArr) {
        int i3 = 0;
        while (i3 < bArr.length && bArr[i3] == 0) {
            i3++;
        }
        if (i3 == bArr.length) {
            i3 = bArr.length - 1;
        }
        int i4 = (bArr[i3] & UnsignedBytes.MAX_POWER_OF_TWO) == 128 ? 1 : 0;
        byte[] bArr2 = new byte[(bArr.length - i3) + i4];
        System.arraycopy(bArr, i3, bArr2, i4, bArr.length - i3);
        return bArr2;
    }

    public static void validatePublicKey(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        EllipticCurvesUtil.checkPointOnCurve(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    static void validatePublicKeySpec(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        try {
            if (isSameEcParameterSpec(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
            } else {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e3) {
            throw new GeneralSecurityException(e3);
        }
    }

    private static void validateSharedSecret(byte[] bArr, ECPrivateKey eCPrivateKey) {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.signum() == -1 || bigInteger.compareTo(getModulus(curve)) >= 0) {
            throw new GeneralSecurityException("shared secret is out of range");
        }
        getY(bigInteger, true, curve);
    }
}
