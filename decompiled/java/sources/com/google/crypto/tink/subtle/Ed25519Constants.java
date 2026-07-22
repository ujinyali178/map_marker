package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* loaded from: /root/release/classes.dex */
final class Ed25519Constants {
    static final Ed25519.CachedXYT[] B2;
    static final Ed25519.CachedXYT[][] B_TABLE;
    static final long[] D;
    static final long[] D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    private static class Point {

        /* renamed from: x, reason: collision with root package name */
        private BigInteger f2362x;

        /* renamed from: y, reason: collision with root package name */
        private BigInteger f2363y;

        private Point() {
        }
    }

    static {
        BigInteger subtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        P_BI = subtract;
        BigInteger mod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(subtract)).mod(subtract);
        D_BI = mod;
        BigInteger mod2 = BigInteger.valueOf(2L).multiply(mod).mod(subtract);
        D2_BI = mod2;
        BigInteger modPow = BigInteger.valueOf(2L).modPow(subtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), subtract);
        SQRTM1_BI = modPow;
        Point point = new Point();
        point.f2363y = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(subtract)).mod(subtract);
        point.f2362x = recoverX(point.f2363y);
        D = Field25519.expand(toLittleEndian(mod));
        D2 = Field25519.expand(toLittleEndian(mod2));
        SQRTM1 = Field25519.expand(toLittleEndian(modPow));
        B_TABLE = (Ed25519.CachedXYT[][]) Array.newInstance((Class<?>) Ed25519.CachedXYT.class, 32, 8);
        Point point2 = point;
        for (int i3 = 0; i3 < 32; i3++) {
            Point point3 = point2;
            for (int i4 = 0; i4 < 8; i4++) {
                B_TABLE[i3][i4] = getCachedXYT(point3);
                point3 = edwards(point3, point2);
            }
            for (int i5 = 0; i5 < 8; i5++) {
                point2 = edwards(point2, point2);
            }
        }
        Point edwards = edwards(point, point);
        B2 = new Ed25519.CachedXYT[8];
        for (int i6 = 0; i6 < 8; i6++) {
            B2[i6] = getCachedXYT(point);
            point = edwards(point, edwards);
        }
    }

    private Ed25519Constants() {
    }

    private static Point edwards(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger multiply = D_BI.multiply(point.f2362x.multiply(point2.f2362x).multiply(point.f2363y).multiply(point2.f2363y));
        BigInteger bigInteger = P_BI;
        BigInteger mod = multiply.mod(bigInteger);
        BigInteger add = point.f2362x.multiply(point2.f2363y).add(point2.f2362x.multiply(point.f2363y));
        BigInteger bigInteger2 = BigInteger.ONE;
        point3.f2362x = add.multiply(bigInteger2.add(mod).modInverse(bigInteger)).mod(bigInteger);
        point3.f2363y = point.f2363y.multiply(point2.f2363y).add(point.f2362x.multiply(point2.f2362x)).multiply(bigInteger2.subtract(mod).modInverse(bigInteger)).mod(bigInteger);
        return point3;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point point) {
        BigInteger add = point.f2363y.add(point.f2362x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(add.mod(bigInteger))), Field25519.expand(toLittleEndian(point.f2363y.subtract(point.f2362x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(point.f2362x).multiply(point.f2363y).mod(bigInteger))));
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger pow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger subtract = pow.subtract(bigInteger2);
        BigInteger add = D_BI.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = P_BI;
        BigInteger multiply = subtract.multiply(add.modInverse(bigInteger3));
        BigInteger modPow = multiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!modPow.pow(2).subtract(multiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(SQRTM1_BI).mod(bigInteger3);
        }
        return modPow.testBit(0) ? bigInteger3.subtract(modPow) : modPow;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i3 = 0; i3 < 16; i3++) {
            byte b4 = bArr[i3];
            int i4 = (32 - i3) - 1;
            bArr[i3] = bArr[i4];
            bArr[i4] = b4;
        }
        return bArr;
    }
}
