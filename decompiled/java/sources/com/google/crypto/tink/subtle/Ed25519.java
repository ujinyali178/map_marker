package com.google.crypto.tink.subtle;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;

/* loaded from: /root/release/classes.dex */
final class Ed25519 {
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        CachedXYT(CachedXYT cachedXYT) {
            this.yPlusX = Arrays.copyOf(cachedXYT.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(cachedXYT.yMinusX, 10);
            this.t2d = Arrays.copyOf(cachedXYT.t2d, 10);
        }

        CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        void copyConditional(CachedXYT cachedXYT, int i3) {
            Curve25519.copyConditional(this.yPlusX, cachedXYT.yPlusX, i3);
            Curve25519.copyConditional(this.yMinusX, cachedXYT.yMinusX, i3);
            Curve25519.copyConditional(this.t2d, cachedXYT.t2d, i3);
        }

        void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    private static class CachedXYZT extends CachedXYT {

        /* renamed from: z, reason: collision with root package name */
        private final long[] f2356z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.yPlusX;
            XYZ xyz = xyzt.xyz;
            Field25519.sum(jArr, xyz.f2359y, xyz.f2358x);
            long[] jArr2 = this.yMinusX;
            XYZ xyz2 = xyzt.xyz;
            Field25519.sub(jArr2, xyz2.f2359y, xyz2.f2358x);
            System.arraycopy(xyzt.xyz.f2360z, 0, this.f2356z, 0, 10);
            Field25519.mult(this.t2d, xyzt.f2361t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f2356z = jArr3;
        }

        @Override // com.google.crypto.tink.subtle.Ed25519.CachedXYT
        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.f2356z);
        }
    }

    private static class PartialXYZT {

        /* renamed from: t, reason: collision with root package name */
        final long[] f2357t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.f2357t = Arrays.copyOf(partialXYZT.f2357t, 10);
        }

        PartialXYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.f2357t = jArr;
        }
    }

    private static class XYZ {

        /* renamed from: x, reason: collision with root package name */
        final long[] f2358x;

        /* renamed from: y, reason: collision with root package name */
        final long[] f2359y;

        /* renamed from: z, reason: collision with root package name */
        final long[] f2360z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        XYZ(XYZ xyz) {
            this.f2358x = Arrays.copyOf(xyz.f2358x, 10);
            this.f2359y = Arrays.copyOf(xyz.f2359y, 10);
            this.f2360z = Arrays.copyOf(xyz.f2360z, 10);
        }

        XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f2358x = jArr;
            this.f2359y = jArr2;
            this.f2360z = jArr3;
        }

        static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.f2358x, partialXYZT.xyz.f2358x, partialXYZT.f2357t);
            long[] jArr = xyz.f2359y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.f2359y, xyz2.f2360z);
            Field25519.mult(xyz.f2360z, partialXYZT.xyz.f2360z, partialXYZT.f2357t);
            return xyz;
        }

        boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.f2358x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.f2359y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.f2360z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }

        byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.f2360z);
            Field25519.mult(jArr2, this.f2358x, jArr);
            Field25519.mult(jArr3, this.f2359y, jArr);
            byte[] contract = Field25519.contract(jArr3);
            contract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ contract[31]);
            return contract;
        }
    }

    private static class XYZT {

        /* renamed from: t, reason: collision with root package name */
        final long[] f2361t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        XYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.f2361t = jArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) {
            long[] jArr = new long[10];
            long[] expand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, expand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (!Ed25519.isNonZeroVarTime(jArr) && ((bArr[31] & UnsignedBytes.MAX_VALUE) >> 7) != 0) {
                throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
            }
            if (Ed25519.getLsb(jArr) == ((bArr[31] & UnsignedBytes.MAX_VALUE) >> 7)) {
                Ed25519.neg(jArr, jArr);
            }
            Field25519.mult(jArr3, jArr, expand);
            return new XYZT(new XYZ(jArr, expand, jArr2), jArr3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.f2358x, partialXYZT.xyz.f2358x, partialXYZT.f2357t);
            long[] jArr = xyzt.xyz.f2359y;
            XYZ xyz = partialXYZT.xyz;
            Field25519.mult(jArr, xyz.f2359y, xyz.f2360z);
            Field25519.mult(xyzt.xyz.f2360z, partialXYZT.xyz.f2360z, partialXYZT.f2357t);
            long[] jArr2 = xyzt.f2361t;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr2, xyz2.f2358x, xyz2.f2359y);
            return xyzt;
        }
    }

    private Ed25519() {
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.f2358x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.f2359y, xyz.f2358x);
        long[] jArr3 = partialXYZT.xyz.f2359y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.f2359y, xyz2.f2358x);
        long[] jArr4 = partialXYZT.xyz.f2359y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yMinusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.f2360z, xyz3.f2358x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.f2357t, xyzt.f2361t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.f2358x, xyzt.xyz.f2360z);
        long[] jArr5 = partialXYZT.xyz.f2358x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f2358x, xyz4.f2360z, xyz4.f2359y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.f2359y;
        Field25519.sum(jArr6, xyz5.f2360z, jArr6);
        Field25519.sum(partialXYZT.xyz.f2360z, jArr, partialXYZT.f2357t);
        long[] jArr7 = partialXYZT.f2357t;
        Field25519.sub(jArr7, jArr, jArr7);
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i3 = 1; i3 < 8; i3++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i3 - 1]);
            cachedXYZTArr[i3] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] slide = slide(bArr);
        byte[] slide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i4 = 255;
        while (i4 >= 0 && slide[i4] == 0 && slide2[i4] == 0) {
            i4--;
        }
        while (i4 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b4 = slide[i4];
            if (b4 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[slide[i4] / 2]);
            } else if (b4 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-slide[i4]) / 2]);
            }
            byte b5 = slide2[i4];
            if (b5 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[slide2[i4] / 2]);
            } else if (b5 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-slide2[i4]) / 2]);
            }
            i4--;
        }
        return new XYZ(partialXYZT2);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.f2358x, xyz.f2358x);
        Field25519.square(partialXYZT.xyz.f2360z, xyz.f2359y);
        Field25519.square(partialXYZT.f2357t, xyz.f2360z);
        long[] jArr2 = partialXYZT.f2357t;
        Field25519.sum(jArr2, jArr2, jArr2);
        Field25519.sum(partialXYZT.xyz.f2359y, xyz.f2358x, xyz.f2359y);
        Field25519.square(jArr, partialXYZT.xyz.f2359y);
        XYZ xyz2 = partialXYZT.xyz;
        Field25519.sum(xyz2.f2359y, xyz2.f2360z, xyz2.f2358x);
        XYZ xyz3 = partialXYZT.xyz;
        long[] jArr3 = xyz3.f2360z;
        Field25519.sub(jArr3, jArr3, xyz3.f2358x);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f2358x, jArr, xyz4.f2359y);
        long[] jArr4 = partialXYZT.f2357t;
        Field25519.sub(jArr4, jArr4, partialXYZT.xyz.f2360z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static int eq(int i3, int i4) {
        int i5 = (~(i3 ^ i4)) & 255;
        int i6 = i5 & (i5 << 4);
        int i7 = i6 & (i6 << 2);
        return ((i7 & (i7 << 1)) >> 7) & 1;
    }

    static byte[] getHashedScalar(byte[] bArr) {
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr, 0, 32);
        byte[] digest = engineFactory.digest();
        digest[0] = (byte) (digest[0] & 248);
        byte b4 = (byte) (digest[31] & Ascii.DEL);
        digest[31] = b4;
        digest[31] = (byte) (b4 | SignedBytes.MAX_POWER_OF_TWO);
        return digest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b4 : Field25519.contract(jArr2)) {
            if (b4 != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        for (int i3 = 31; i3 >= 0; i3--) {
            int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
            int i5 = GROUP_ORDER[i3] & UnsignedBytes.MAX_VALUE;
            if (i4 != i5) {
                return i4 < i5;
            }
        }
        return false;
    }

    private static long load3(byte[] bArr, int i3) {
        return ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16) | (bArr[i3] & 255) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8);
    }

    private static long load4(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | load3(bArr, i3);
    }

    private static void mulAdd(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        long load3 = load3(bArr2, 0) & 2097151;
        long load4 = (load4(bArr2, 2) >> 5) & 2097151;
        long load32 = (load3(bArr2, 5) >> 2) & 2097151;
        long load42 = (load4(bArr2, 7) >> 7) & 2097151;
        long load43 = (load4(bArr2, 10) >> 4) & 2097151;
        long load33 = (load3(bArr2, 13) >> 1) & 2097151;
        long load44 = (load4(bArr2, 15) >> 6) & 2097151;
        long load34 = (load3(bArr2, 18) >> 3) & 2097151;
        long load35 = load3(bArr2, 21) & 2097151;
        long load45 = (load4(bArr2, 23) >> 5) & 2097151;
        long load36 = (load3(bArr2, 26) >> 2) & 2097151;
        long load46 = load4(bArr2, 28) >> 7;
        long load37 = load3(bArr3, 0) & 2097151;
        long load47 = (load4(bArr3, 2) >> 5) & 2097151;
        long load38 = (load3(bArr3, 5) >> 2) & 2097151;
        long load48 = (load4(bArr3, 7) >> 7) & 2097151;
        long load49 = (load4(bArr3, 10) >> 4) & 2097151;
        long load39 = (load3(bArr3, 13) >> 1) & 2097151;
        long load410 = (load4(bArr3, 15) >> 6) & 2097151;
        long load310 = (load3(bArr3, 18) >> 3) & 2097151;
        long load311 = load3(bArr3, 21) & 2097151;
        long load411 = (load4(bArr3, 23) >> 5) & 2097151;
        long load312 = (load3(bArr3, 26) >> 2) & 2097151;
        long load412 = load4(bArr3, 28) >> 7;
        long load313 = load3(bArr4, 0) & 2097151;
        long load413 = (load4(bArr4, 2) >> 5) & 2097151;
        long load314 = (load3(bArr4, 5) >> 2) & 2097151;
        long load414 = (load4(bArr4, 7) >> 7) & 2097151;
        long load415 = (load4(bArr4, 10) >> 4) & 2097151;
        long load315 = (load3(bArr4, 13) >> 1) & 2097151;
        long load416 = (load4(bArr4, 15) >> 6) & 2097151;
        long load316 = (load3(bArr4, 18) >> 3) & 2097151;
        long load317 = load3(bArr4, 21) & 2097151;
        long j3 = load313 + (load3 * load37);
        long j4 = load413 + (load3 * load47) + (load4 * load37);
        long j5 = load314 + (load3 * load38) + (load4 * load47) + (load32 * load37);
        long j6 = load414 + (load3 * load48) + (load4 * load38) + (load32 * load47) + (load42 * load37);
        long j7 = load415 + (load3 * load49) + (load4 * load48) + (load32 * load38) + (load42 * load47) + (load43 * load37);
        long j8 = load315 + (load3 * load39) + (load4 * load49) + (load32 * load48) + (load42 * load38) + (load43 * load47) + (load33 * load37);
        long j9 = load416 + (load3 * load410) + (load4 * load39) + (load32 * load49) + (load42 * load48) + (load43 * load38) + (load33 * load47) + (load44 * load37);
        long j10 = load316 + (load3 * load310) + (load4 * load410) + (load32 * load39) + (load42 * load49) + (load43 * load48) + (load33 * load38) + (load44 * load47) + (load34 * load37);
        long j11 = load317 + (load3 * load311) + (load4 * load310) + (load32 * load410) + (load42 * load39) + (load43 * load49) + (load33 * load48) + (load44 * load38) + (load34 * load47) + (load35 * load37);
        long load417 = ((load4(bArr4, 23) >> 5) & 2097151) + (load3 * load411) + (load4 * load311) + (load32 * load310) + (load42 * load410) + (load43 * load39) + (load33 * load49) + (load44 * load48) + (load34 * load38) + (load35 * load47) + (load45 * load37);
        long load318 = ((load3(bArr4, 26) >> 2) & 2097151) + (load3 * load312) + (load4 * load411) + (load32 * load311) + (load42 * load310) + (load43 * load410) + (load33 * load39) + (load44 * load49) + (load34 * load48) + (load35 * load38) + (load45 * load47) + (load36 * load37);
        long load418 = (load4(bArr4, 28) >> 7) + (load3 * load412) + (load4 * load312) + (load32 * load411) + (load42 * load311) + (load43 * load310) + (load33 * load410) + (load44 * load39) + (load34 * load49) + (load35 * load48) + (load45 * load38) + (load36 * load47) + (load37 * load46);
        long j12 = (load4 * load412) + (load32 * load312) + (load42 * load411) + (load43 * load311) + (load33 * load310) + (load44 * load410) + (load34 * load39) + (load35 * load49) + (load45 * load48) + (load36 * load38) + (load47 * load46);
        long j13 = (load32 * load412) + (load42 * load312) + (load43 * load411) + (load33 * load311) + (load44 * load310) + (load34 * load410) + (load35 * load39) + (load45 * load49) + (load36 * load48) + (load38 * load46);
        long j14 = (load42 * load412) + (load43 * load312) + (load33 * load411) + (load44 * load311) + (load34 * load310) + (load35 * load410) + (load45 * load39) + (load36 * load49) + (load48 * load46);
        long j15 = (load43 * load412) + (load33 * load312) + (load44 * load411) + (load34 * load311) + (load35 * load310) + (load45 * load410) + (load36 * load39) + (load49 * load46);
        long j16 = (load33 * load412) + (load44 * load312) + (load34 * load411) + (load35 * load311) + (load45 * load310) + (load36 * load410) + (load39 * load46);
        long j17 = (load44 * load412) + (load34 * load312) + (load35 * load411) + (load45 * load311) + (load36 * load310) + (load410 * load46);
        long j18 = (load34 * load412) + (load35 * load312) + (load45 * load411) + (load36 * load311) + (load310 * load46);
        long j19 = (load35 * load412) + (load45 * load312) + (load36 * load411) + (load311 * load46);
        long j20 = (load45 * load412) + (load36 * load312) + (load411 * load46);
        long j21 = (load36 * load412) + (load312 * load46);
        long j22 = load46 * load412;
        long j23 = (j3 + FileUtils.ONE_MB) >> 21;
        long j24 = j4 + j23;
        long j25 = j3 - (j23 << 21);
        long j26 = (j5 + FileUtils.ONE_MB) >> 21;
        long j27 = j6 + j26;
        long j28 = j5 - (j26 << 21);
        long j29 = (j7 + FileUtils.ONE_MB) >> 21;
        long j30 = j8 + j29;
        long j31 = j7 - (j29 << 21);
        long j32 = (j9 + FileUtils.ONE_MB) >> 21;
        long j33 = j10 + j32;
        long j34 = j9 - (j32 << 21);
        long j35 = (j11 + FileUtils.ONE_MB) >> 21;
        long j36 = load417 + j35;
        long j37 = j11 - (j35 << 21);
        long j38 = (load318 + FileUtils.ONE_MB) >> 21;
        long j39 = load418 + j38;
        long j40 = load318 - (j38 << 21);
        long j41 = (j12 + FileUtils.ONE_MB) >> 21;
        long j42 = j13 + j41;
        long j43 = j12 - (j41 << 21);
        long j44 = (j14 + FileUtils.ONE_MB) >> 21;
        long j45 = j15 + j44;
        long j46 = j14 - (j44 << 21);
        long j47 = (j16 + FileUtils.ONE_MB) >> 21;
        long j48 = j17 + j47;
        long j49 = j16 - (j47 << 21);
        long j50 = (j18 + FileUtils.ONE_MB) >> 21;
        long j51 = j19 + j50;
        long j52 = j18 - (j50 << 21);
        long j53 = (j20 + FileUtils.ONE_MB) >> 21;
        long j54 = j21 + j53;
        long j55 = j20 - (j53 << 21);
        long j56 = (j22 + FileUtils.ONE_MB) >> 21;
        long j57 = j56 + 0;
        long j58 = j22 - (j56 << 21);
        long j59 = (j24 + FileUtils.ONE_MB) >> 21;
        long j60 = j28 + j59;
        long j61 = j24 - (j59 << 21);
        long j62 = (j27 + FileUtils.ONE_MB) >> 21;
        long j63 = j31 + j62;
        long j64 = j27 - (j62 << 21);
        long j65 = (j30 + FileUtils.ONE_MB) >> 21;
        long j66 = j34 + j65;
        long j67 = j30 - (j65 << 21);
        long j68 = (j33 + FileUtils.ONE_MB) >> 21;
        long j69 = j37 + j68;
        long j70 = j33 - (j68 << 21);
        long j71 = (j36 + FileUtils.ONE_MB) >> 21;
        long j72 = j40 + j71;
        long j73 = j36 - (j71 << 21);
        long j74 = (j39 + FileUtils.ONE_MB) >> 21;
        long j75 = j43 + j74;
        long j76 = j39 - (j74 << 21);
        long j77 = (j42 + FileUtils.ONE_MB) >> 21;
        long j78 = j46 + j77;
        long j79 = j42 - (j77 << 21);
        long j80 = (j45 + FileUtils.ONE_MB) >> 21;
        long j81 = j49 + j80;
        long j82 = j45 - (j80 << 21);
        long j83 = (j48 + FileUtils.ONE_MB) >> 21;
        long j84 = j52 + j83;
        long j85 = j48 - (j83 << 21);
        long j86 = (j51 + FileUtils.ONE_MB) >> 21;
        long j87 = j55 + j86;
        long j88 = j51 - (j86 << 21);
        long j89 = (j54 + FileUtils.ONE_MB) >> 21;
        long j90 = j58 + j89;
        long j91 = j54 - (j89 << 21);
        long j92 = j81 - (j57 * 683901);
        long j93 = ((j78 - (j57 * 997805)) + (j90 * 136657)) - (j91 * 683901);
        long j94 = ((((j75 + (j57 * 470296)) + (j90 * 654183)) - (j91 * 997805)) + (j87 * 136657)) - (j88 * 683901);
        long j95 = j66 + (j84 * 666643);
        long j96 = j70 + (j88 * 666643) + (j84 * 470296);
        long j97 = j69 + (j87 * 666643) + (j88 * 470296) + (j84 * 654183);
        long j98 = (((j73 + (j91 * 666643)) + (j87 * 470296)) + (j88 * 654183)) - (j84 * 997805);
        long j99 = ((((j72 + (j90 * 666643)) + (j91 * 470296)) + (j87 * 654183)) - (j88 * 997805)) + (j84 * 136657);
        long j100 = (((((j76 + (j57 * 666643)) + (j90 * 470296)) + (j91 * 654183)) - (j87 * 997805)) + (j88 * 136657)) - (j84 * 683901);
        long j101 = (j95 + FileUtils.ONE_MB) >> 21;
        long j102 = j96 + j101;
        long j103 = j95 - (j101 << 21);
        long j104 = (j97 + FileUtils.ONE_MB) >> 21;
        long j105 = j98 + j104;
        long j106 = j97 - (j104 << 21);
        long j107 = (j99 + FileUtils.ONE_MB) >> 21;
        long j108 = j100 + j107;
        long j109 = j99 - (j107 << 21);
        long j110 = (j94 + FileUtils.ONE_MB) >> 21;
        long j111 = ((((j79 + (j57 * 654183)) - (j90 * 997805)) + (j91 * 136657)) - (j87 * 683901)) + j110;
        long j112 = j94 - (j110 << 21);
        long j113 = (j93 + FileUtils.ONE_MB) >> 21;
        long j114 = ((j82 + (j57 * 136657)) - (j90 * 683901)) + j113;
        long j115 = j93 - (j113 << 21);
        long j116 = (j92 + FileUtils.ONE_MB) >> 21;
        long j117 = j85 + j116;
        long j118 = j92 - (j116 << 21);
        long j119 = (j102 + FileUtils.ONE_MB) >> 21;
        long j120 = j106 + j119;
        long j121 = j102 - (j119 << 21);
        long j122 = (j105 + FileUtils.ONE_MB) >> 21;
        long j123 = j109 + j122;
        long j124 = j105 - (j122 << 21);
        long j125 = (j108 + FileUtils.ONE_MB) >> 21;
        long j126 = j112 + j125;
        long j127 = j108 - (j125 << 21);
        long j128 = (j111 + FileUtils.ONE_MB) >> 21;
        long j129 = j115 + j128;
        long j130 = j111 - (j128 << 21);
        long j131 = (j114 + FileUtils.ONE_MB) >> 21;
        long j132 = j118 + j131;
        long j133 = j114 - (j131 << 21);
        long j134 = j123 - (j117 * 683901);
        long j135 = ((j120 - (j117 * 997805)) + (j132 * 136657)) - (j133 * 683901);
        long j136 = ((((j103 + (j117 * 470296)) + (j132 * 654183)) - (j133 * 997805)) + (j129 * 136657)) - (j130 * 683901);
        long j137 = j25 + (j126 * 666643);
        long j138 = j61 + (j130 * 666643) + (j126 * 470296);
        long j139 = j60 + (j129 * 666643) + (j130 * 470296) + (j126 * 654183);
        long j140 = (((j64 + (j133 * 666643)) + (j129 * 470296)) + (j130 * 654183)) - (j126 * 997805);
        long j141 = ((((j63 + (j132 * 666643)) + (j133 * 470296)) + (j129 * 654183)) - (j130 * 997805)) + (j126 * 136657);
        long j142 = (((((j67 + (j117 * 666643)) + (j132 * 470296)) + (j133 * 654183)) - (j129 * 997805)) + (j130 * 136657)) - (j126 * 683901);
        long j143 = (j137 + FileUtils.ONE_MB) >> 21;
        long j144 = j138 + j143;
        long j145 = j137 - (j143 << 21);
        long j146 = (j139 + FileUtils.ONE_MB) >> 21;
        long j147 = j140 + j146;
        long j148 = j139 - (j146 << 21);
        long j149 = (j141 + FileUtils.ONE_MB) >> 21;
        long j150 = j142 + j149;
        long j151 = j141 - (j149 << 21);
        long j152 = (j136 + FileUtils.ONE_MB) >> 21;
        long j153 = ((((j121 + (j117 * 654183)) - (j132 * 997805)) + (j133 * 136657)) - (j129 * 683901)) + j152;
        long j154 = j136 - (j152 << 21);
        long j155 = (j135 + FileUtils.ONE_MB) >> 21;
        long j156 = ((j124 + (j117 * 136657)) - (j132 * 683901)) + j155;
        long j157 = j135 - (j155 << 21);
        long j158 = (j134 + FileUtils.ONE_MB) >> 21;
        long j159 = j127 + j158;
        long j160 = j134 - (j158 << 21);
        long j161 = (j144 + FileUtils.ONE_MB) >> 21;
        long j162 = j148 + j161;
        long j163 = j144 - (j161 << 21);
        long j164 = (j147 + FileUtils.ONE_MB) >> 21;
        long j165 = j151 + j164;
        long j166 = j147 - (j164 << 21);
        long j167 = (j150 + FileUtils.ONE_MB) >> 21;
        long j168 = j154 + j167;
        long j169 = j150 - (j167 << 21);
        long j170 = (j153 + FileUtils.ONE_MB) >> 21;
        long j171 = j157 + j170;
        long j172 = j153 - (j170 << 21);
        long j173 = (j156 + FileUtils.ONE_MB) >> 21;
        long j174 = j160 + j173;
        long j175 = j156 - (j173 << 21);
        long j176 = (FileUtils.ONE_MB + j159) >> 21;
        long j177 = 0 + j176;
        long j178 = j145 + (j177 * 666643);
        long j179 = j163 + (j177 * 470296);
        long j180 = j162 + (j177 * 654183);
        long j181 = j166 - (j177 * 997805);
        long j182 = j165 + (j177 * 136657);
        long j183 = j169 - (j177 * 683901);
        long j184 = j178 >> 21;
        long j185 = j179 + j184;
        long j186 = j178 - (j184 << 21);
        long j187 = j185 >> 21;
        long j188 = j180 + j187;
        long j189 = j185 - (j187 << 21);
        long j190 = j188 >> 21;
        long j191 = j181 + j190;
        long j192 = j188 - (j190 << 21);
        long j193 = j191 >> 21;
        long j194 = j182 + j193;
        long j195 = j191 - (j193 << 21);
        long j196 = j194 >> 21;
        long j197 = j183 + j196;
        long j198 = j194 - (j196 << 21);
        long j199 = j197 >> 21;
        long j200 = j168 + j199;
        long j201 = j197 - (j199 << 21);
        long j202 = j200 >> 21;
        long j203 = j172 + j202;
        long j204 = j200 - (j202 << 21);
        long j205 = j203 >> 21;
        long j206 = j171 + j205;
        long j207 = j203 - (j205 << 21);
        long j208 = j206 >> 21;
        long j209 = j175 + j208;
        long j210 = j206 - (j208 << 21);
        long j211 = j209 >> 21;
        long j212 = j174 + j211;
        long j213 = j209 - (j211 << 21);
        long j214 = j212 >> 21;
        long j215 = (j159 - (j176 << 21)) + j214;
        long j216 = j212 - (j214 << 21);
        long j217 = j215 >> 21;
        long j218 = 0 + j217;
        long j219 = j215 - (j217 << 21);
        long j220 = j186 + (666643 * j218);
        long j221 = j220 >> 21;
        long j222 = j189 + (470296 * j218) + j221;
        long j223 = j222 >> 21;
        long j224 = j192 + (654183 * j218) + j223;
        long j225 = j222 - (j223 << 21);
        long j226 = j224 >> 21;
        long j227 = (j195 - (997805 * j218)) + j226;
        long j228 = j224 - (j226 << 21);
        long j229 = j227 >> 21;
        long j230 = j198 + (136657 * j218) + j229;
        long j231 = j227 - (j229 << 21);
        long j232 = j230 >> 21;
        long j233 = (j201 - (j218 * 683901)) + j232;
        long j234 = j230 - (j232 << 21);
        long j235 = j233 >> 21;
        long j236 = j204 + j235;
        long j237 = j233 - (j235 << 21);
        long j238 = j236 >> 21;
        long j239 = j207 + j238;
        long j240 = j236 - (j238 << 21);
        long j241 = j239 >> 21;
        long j242 = j210 + j241;
        long j243 = j239 - (j241 << 21);
        long j244 = j242 >> 21;
        long j245 = j213 + j244;
        long j246 = j245 >> 21;
        long j247 = j216 + j246;
        long j248 = j245 - (j246 << 21);
        long j249 = j247 >> 21;
        long j250 = j219 + j249;
        long j251 = j247 - (j249 << 21);
        bArr[0] = (byte) (j220 - (j221 << 21));
        bArr[1] = (byte) (r4 >> 8);
        bArr[2] = (byte) ((r4 >> 16) | (j225 << 5));
        bArr[3] = (byte) (j225 >> 3);
        bArr[4] = (byte) (j225 >> 11);
        bArr[5] = (byte) ((j225 >> 19) | (j228 << 2));
        bArr[6] = (byte) (j228 >> 6);
        bArr[7] = (byte) ((j228 >> 14) | (j231 << 7));
        bArr[8] = (byte) (j231 >> 1);
        bArr[9] = (byte) (j231 >> 9);
        bArr[10] = (byte) ((j231 >> 17) | (j234 << 4));
        bArr[11] = (byte) (j234 >> 4);
        bArr[12] = (byte) (j234 >> 12);
        bArr[13] = (byte) ((j234 >> 20) | (j237 << 1));
        bArr[14] = (byte) (j237 >> 7);
        bArr[15] = (byte) ((j237 >> 15) | (j240 << 6));
        bArr[16] = (byte) (j240 >> 2);
        bArr[17] = (byte) (j240 >> 10);
        bArr[18] = (byte) ((j240 >> 18) | (j243 << 3));
        bArr[19] = (byte) (j243 >> 5);
        bArr[20] = (byte) (j243 >> 13);
        bArr[21] = (byte) (j242 - (j244 << 21));
        bArr[22] = (byte) (r9 >> 8);
        bArr[23] = (byte) ((r9 >> 16) | (j248 << 5));
        bArr[24] = (byte) (j248 >> 3);
        bArr[25] = (byte) (j248 >> 11);
        bArr[26] = (byte) ((j248 >> 19) | (j251 << 2));
        bArr[27] = (byte) (j251 >> 6);
        bArr[28] = (byte) ((j251 >> 14) | (j250 << 7));
        bArr[29] = (byte) (j250 >> 1);
        bArr[30] = (byte) (j250 >> 9);
        bArr[31] = (byte) (j250 >> 17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i3 = 0; i3 < jArr2.length; i3++) {
            jArr[i3] = -jArr2[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        for (int i3 = 1; i3 < 2; i3++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i4 = 1; i4 < 5; i4++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i5 = 1; i5 < 10; i5++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i6 = 1; i6 < 20; i6++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i7 = 1; i7 < 10; i7++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i8 = 1; i8 < 50; i8++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i9 = 1; i9 < 100; i9++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i10 = 1; i10 < 50; i10++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        for (int i11 = 1; i11 < 2; i11++) {
            Field25519.square(jArr3, jArr3);
        }
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static void reduce(byte[] bArr) {
        long load3 = load3(bArr, 0) & 2097151;
        long load4 = (load4(bArr, 2) >> 5) & 2097151;
        long load32 = (load3(bArr, 5) >> 2) & 2097151;
        long load42 = (load4(bArr, 7) >> 7) & 2097151;
        long load43 = (load4(bArr, 10) >> 4) & 2097151;
        long load33 = (load3(bArr, 13) >> 1) & 2097151;
        long load44 = (load4(bArr, 15) >> 6) & 2097151;
        long load34 = (load3(bArr, 18) >> 3) & 2097151;
        long load35 = load3(bArr, 21) & 2097151;
        long load45 = (load4(bArr, 23) >> 5) & 2097151;
        long load36 = (load3(bArr, 26) >> 2) & 2097151;
        long load46 = (load4(bArr, 28) >> 7) & 2097151;
        long load47 = (load4(bArr, 31) >> 4) & 2097151;
        long load37 = (load3(bArr, 34) >> 1) & 2097151;
        long load48 = (load4(bArr, 36) >> 6) & 2097151;
        long load38 = (load3(bArr, 39) >> 3) & 2097151;
        long load39 = load3(bArr, 42) & 2097151;
        long load49 = (load4(bArr, 44) >> 5) & 2097151;
        long load310 = (load3(bArr, 47) >> 2) & 2097151;
        long load410 = (load4(bArr, 49) >> 7) & 2097151;
        long load411 = (load4(bArr, 52) >> 4) & 2097151;
        long load311 = (load3(bArr, 55) >> 1) & 2097151;
        long load412 = (load4(bArr, 57) >> 6) & 2097151;
        long load413 = load4(bArr, 60) >> 3;
        long j3 = load39 - (load413 * 683901);
        long j4 = ((load48 - (load413 * 997805)) + (load412 * 136657)) - (load311 * 683901);
        long j5 = ((((load47 + (load413 * 470296)) + (load412 * 654183)) - (load311 * 997805)) + (load411 * 136657)) - (load410 * 683901);
        long j6 = load44 + (load310 * 666643);
        long j7 = load34 + (load410 * 666643) + (load310 * 470296);
        long j8 = load35 + (load411 * 666643) + (load410 * 470296) + (load310 * 654183);
        long j9 = (((load45 + (load311 * 666643)) + (load411 * 470296)) + (load410 * 654183)) - (load310 * 997805);
        long j10 = ((((load36 + (load412 * 666643)) + (load311 * 470296)) + (load411 * 654183)) - (load410 * 997805)) + (load310 * 136657);
        long j11 = (((((load46 + (load413 * 666643)) + (load412 * 470296)) + (load311 * 654183)) - (load411 * 997805)) + (load410 * 136657)) - (load310 * 683901);
        long j12 = (j6 + FileUtils.ONE_MB) >> 21;
        long j13 = j7 + j12;
        long j14 = j6 - (j12 << 21);
        long j15 = (j8 + FileUtils.ONE_MB) >> 21;
        long j16 = j9 + j15;
        long j17 = j8 - (j15 << 21);
        long j18 = (j10 + FileUtils.ONE_MB) >> 21;
        long j19 = j11 + j18;
        long j20 = j10 - (j18 << 21);
        long j21 = (j5 + FileUtils.ONE_MB) >> 21;
        long j22 = ((((load37 + (load413 * 654183)) - (load412 * 997805)) + (load311 * 136657)) - (load411 * 683901)) + j21;
        long j23 = j5 - (j21 << 21);
        long j24 = (j4 + FileUtils.ONE_MB) >> 21;
        long j25 = ((load38 + (load413 * 136657)) - (load412 * 683901)) + j24;
        long j26 = j4 - (j24 << 21);
        long j27 = (j3 + FileUtils.ONE_MB) >> 21;
        long j28 = load49 + j27;
        long j29 = j3 - (j27 << 21);
        long j30 = (j13 + FileUtils.ONE_MB) >> 21;
        long j31 = j17 + j30;
        long j32 = j13 - (j30 << 21);
        long j33 = (j16 + FileUtils.ONE_MB) >> 21;
        long j34 = j20 + j33;
        long j35 = j16 - (j33 << 21);
        long j36 = (j19 + FileUtils.ONE_MB) >> 21;
        long j37 = j23 + j36;
        long j38 = j19 - (j36 << 21);
        long j39 = (j22 + FileUtils.ONE_MB) >> 21;
        long j40 = j26 + j39;
        long j41 = j22 - (j39 << 21);
        long j42 = (j25 + FileUtils.ONE_MB) >> 21;
        long j43 = j29 + j42;
        long j44 = j25 - (j42 << 21);
        long j45 = j34 - (j28 * 683901);
        long j46 = ((j31 - (j28 * 997805)) + (j43 * 136657)) - (j44 * 683901);
        long j47 = ((((j14 + (j28 * 470296)) + (j43 * 654183)) - (j44 * 997805)) + (j40 * 136657)) - (j41 * 683901);
        long j48 = load3 + (j37 * 666643);
        long j49 = load4 + (j41 * 666643) + (j37 * 470296);
        long j50 = load32 + (j40 * 666643) + (j41 * 470296) + (j37 * 654183);
        long j51 = (((load42 + (j44 * 666643)) + (j40 * 470296)) + (j41 * 654183)) - (j37 * 997805);
        long j52 = ((((load43 + (j43 * 666643)) + (j44 * 470296)) + (j40 * 654183)) - (j41 * 997805)) + (j37 * 136657);
        long j53 = (((((load33 + (j28 * 666643)) + (j43 * 470296)) + (j44 * 654183)) - (j40 * 997805)) + (j41 * 136657)) - (j37 * 683901);
        long j54 = (j48 + FileUtils.ONE_MB) >> 21;
        long j55 = j49 + j54;
        long j56 = j48 - (j54 << 21);
        long j57 = (j50 + FileUtils.ONE_MB) >> 21;
        long j58 = j51 + j57;
        long j59 = j50 - (j57 << 21);
        long j60 = (j52 + FileUtils.ONE_MB) >> 21;
        long j61 = j53 + j60;
        long j62 = j52 - (j60 << 21);
        long j63 = (j47 + FileUtils.ONE_MB) >> 21;
        long j64 = ((((j32 + (j28 * 654183)) - (j43 * 997805)) + (j44 * 136657)) - (j40 * 683901)) + j63;
        long j65 = j47 - (j63 << 21);
        long j66 = (j46 + FileUtils.ONE_MB) >> 21;
        long j67 = ((j35 + (j28 * 136657)) - (j43 * 683901)) + j66;
        long j68 = j46 - (j66 << 21);
        long j69 = (j45 + FileUtils.ONE_MB) >> 21;
        long j70 = j38 + j69;
        long j71 = j45 - (j69 << 21);
        long j72 = (j55 + FileUtils.ONE_MB) >> 21;
        long j73 = j59 + j72;
        long j74 = j55 - (j72 << 21);
        long j75 = (j58 + FileUtils.ONE_MB) >> 21;
        long j76 = j62 + j75;
        long j77 = j58 - (j75 << 21);
        long j78 = (j61 + FileUtils.ONE_MB) >> 21;
        long j79 = j65 + j78;
        long j80 = j61 - (j78 << 21);
        long j81 = (j64 + FileUtils.ONE_MB) >> 21;
        long j82 = j68 + j81;
        long j83 = j64 - (j81 << 21);
        long j84 = (j67 + FileUtils.ONE_MB) >> 21;
        long j85 = j71 + j84;
        long j86 = j67 - (j84 << 21);
        long j87 = (j70 + FileUtils.ONE_MB) >> 21;
        long j88 = j87 + 0;
        long j89 = j56 + (j88 * 666643);
        long j90 = j74 + (j88 * 470296);
        long j91 = j73 + (j88 * 654183);
        long j92 = j77 - (j88 * 997805);
        long j93 = j76 + (j88 * 136657);
        long j94 = j80 - (j88 * 683901);
        long j95 = j89 >> 21;
        long j96 = j90 + j95;
        long j97 = j89 - (j95 << 21);
        long j98 = j96 >> 21;
        long j99 = j91 + j98;
        long j100 = j96 - (j98 << 21);
        long j101 = j99 >> 21;
        long j102 = j92 + j101;
        long j103 = j99 - (j101 << 21);
        long j104 = j102 >> 21;
        long j105 = j93 + j104;
        long j106 = j102 - (j104 << 21);
        long j107 = j105 >> 21;
        long j108 = j94 + j107;
        long j109 = j105 - (j107 << 21);
        long j110 = j108 >> 21;
        long j111 = j79 + j110;
        long j112 = j108 - (j110 << 21);
        long j113 = j111 >> 21;
        long j114 = j83 + j113;
        long j115 = j111 - (j113 << 21);
        long j116 = j114 >> 21;
        long j117 = j82 + j116;
        long j118 = j114 - (j116 << 21);
        long j119 = j117 >> 21;
        long j120 = j86 + j119;
        long j121 = j117 - (j119 << 21);
        long j122 = j120 >> 21;
        long j123 = j85 + j122;
        long j124 = j120 - (j122 << 21);
        long j125 = j123 >> 21;
        long j126 = (j70 - (j87 << 21)) + j125;
        long j127 = j123 - (j125 << 21);
        long j128 = j126 >> 21;
        long j129 = j128 + 0;
        long j130 = j126 - (j128 << 21);
        long j131 = j97 + (666643 * j129);
        long j132 = j131 >> 21;
        long j133 = j100 + (470296 * j129) + j132;
        long j134 = j131 - (j132 << 21);
        long j135 = j133 >> 21;
        long j136 = j103 + (654183 * j129) + j135;
        long j137 = j133 - (j135 << 21);
        long j138 = j136 >> 21;
        long j139 = (j106 - (997805 * j129)) + j138;
        long j140 = j136 - (j138 << 21);
        long j141 = j139 >> 21;
        long j142 = j109 + (136657 * j129) + j141;
        long j143 = j139 - (j141 << 21);
        long j144 = j142 >> 21;
        long j145 = (j112 - (j129 * 683901)) + j144;
        long j146 = j142 - (j144 << 21);
        long j147 = j145 >> 21;
        long j148 = j115 + j147;
        long j149 = j145 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j118 + j150;
        long j152 = j148 - (j150 << 21);
        long j153 = j151 >> 21;
        long j154 = j121 + j153;
        long j155 = j151 - (j153 << 21);
        long j156 = j154 >> 21;
        long j157 = j124 + j156;
        long j158 = j157 >> 21;
        long j159 = j127 + j158;
        long j160 = j157 - (j158 << 21);
        long j161 = j159 >> 21;
        long j162 = j130 + j161;
        long j163 = j159 - (j161 << 21);
        bArr[0] = (byte) j134;
        bArr[1] = (byte) (j134 >> 8);
        bArr[2] = (byte) ((j134 >> 16) | (j137 << 5));
        bArr[3] = (byte) (j137 >> 3);
        bArr[4] = (byte) (j137 >> 11);
        bArr[5] = (byte) ((j137 >> 19) | (j140 << 2));
        bArr[6] = (byte) (j140 >> 6);
        bArr[7] = (byte) ((j140 >> 14) | (j143 << 7));
        bArr[8] = (byte) (j143 >> 1);
        bArr[9] = (byte) (j143 >> 9);
        bArr[10] = (byte) ((j143 >> 17) | (j146 << 4));
        bArr[11] = (byte) (j146 >> 4);
        bArr[12] = (byte) (j146 >> 12);
        bArr[13] = (byte) ((j146 >> 20) | (j149 << 1));
        bArr[14] = (byte) (j149 >> 7);
        bArr[15] = (byte) ((j149 >> 15) | (j152 << 6));
        bArr[16] = (byte) (j152 >> 2);
        bArr[17] = (byte) (j152 >> 10);
        bArr[18] = (byte) ((j152 >> 18) | (j155 << 3));
        bArr[19] = (byte) (j155 >> 5);
        bArr[20] = (byte) (j155 >> 13);
        bArr[21] = (byte) (j154 - (j156 << 21));
        bArr[22] = (byte) (r11 >> 8);
        bArr[23] = (byte) ((r11 >> 16) | (j160 << 5));
        bArr[24] = (byte) (j160 >> 3);
        bArr[25] = (byte) (j160 >> 11);
        bArr[26] = (byte) ((j160 >> 19) | (j163 << 2));
        bArr[27] = (byte) (j163 >> 6);
        bArr[28] = (byte) ((j163 >> 14) | (j162 << 7));
        bArr[29] = (byte) (j162 >> 1);
        bArr[30] = (byte) (j162 >> 9);
        bArr[31] = (byte) (j162 >> 17);
    }

    private static XYZ scalarMultWithBase(byte[] bArr) {
        int i3;
        byte[] bArr2 = new byte[64];
        int i4 = 0;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            int i5 = i4 * 2;
            bArr2[i5 + 0] = (byte) (((bArr[i4] & UnsignedBytes.MAX_VALUE) >> 0) & 15);
            bArr2[i5 + 1] = (byte) (((bArr[i4] & UnsignedBytes.MAX_VALUE) >> 4) & 15);
            i4++;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < 63) {
            byte b4 = (byte) (bArr2[i6] + i7);
            bArr2[i6] = b4;
            int i8 = (b4 + 8) >> 4;
            bArr2[i6] = (byte) (b4 - (i8 << 4));
            i6++;
            i7 = i8;
        }
        bArr2[63] = (byte) (bArr2[63] + i7);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i3 = 1; i3 < 64; i3 += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i3 / 2, bArr2[i3]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i9 = 0; i9 < 64; i9 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i9 / 2, bArr2[i9]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    static byte[] scalarMultWithBaseToBytes(byte[] bArr) {
        return scalarMultWithBase(bArr).toBytes();
    }

    private static void select(CachedXYT cachedXYT, int i3, byte b4) {
        int i4 = (b4 & UnsignedBytes.MAX_VALUE) >> 7;
        int i5 = b4 - (((-i4) & b4) << 1);
        CachedXYT[][] cachedXYTArr = Ed25519Constants.B_TABLE;
        cachedXYT.copyConditional(cachedXYTArr[i3][0], eq(i5, 1));
        cachedXYT.copyConditional(cachedXYTArr[i3][1], eq(i5, 2));
        cachedXYT.copyConditional(cachedXYTArr[i3][2], eq(i5, 3));
        cachedXYT.copyConditional(cachedXYTArr[i3][3], eq(i5, 4));
        cachedXYT.copyConditional(cachedXYTArr[i3][4], eq(i5, 5));
        cachedXYT.copyConditional(cachedXYTArr[i3][5], eq(i5, 6));
        cachedXYT.copyConditional(cachedXYTArr[i3][6], eq(i5, 7));
        cachedXYT.copyConditional(cachedXYTArr[i3][7], eq(i5, 8));
        long[] copyOf = Arrays.copyOf(cachedXYT.yMinusX, 10);
        long[] copyOf2 = Arrays.copyOf(cachedXYT.yPlusX, 10);
        long[] copyOf3 = Arrays.copyOf(cachedXYT.t2d, 10);
        neg(copyOf3, copyOf3);
        cachedXYT.copyConditional(new CachedXYT(copyOf, copyOf2, copyOf3), i4);
    }

    static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr3, 32, 32);
        engineFactory.update(copyOfRange);
        byte[] digest = engineFactory.digest();
        reduce(digest);
        byte[] copyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(digest).toBytes(), 0, 32);
        engineFactory.reset();
        engineFactory.update(copyOfRange2);
        engineFactory.update(bArr2);
        engineFactory.update(copyOfRange);
        byte[] digest2 = engineFactory.digest();
        reduce(digest2);
        byte[] bArr4 = new byte[32];
        mulAdd(bArr4, digest2, bArr3, digest);
        return Bytes.concat(copyOfRange2, bArr4);
    }

    private static byte[] slide(byte[] bArr) {
        int i3;
        byte[] bArr2 = new byte[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr2[i4] = (byte) (1 & ((bArr[i4 >> 3] & UnsignedBytes.MAX_VALUE) >> (i4 & 7)));
        }
        for (int i5 = 0; i5 < 256; i5++) {
            if (bArr2[i5] != 0) {
                for (int i6 = 1; i6 <= 6 && (i3 = i5 + i6) < 256; i6++) {
                    byte b4 = bArr2[i3];
                    if (b4 != 0) {
                        byte b5 = bArr2[i5];
                        if ((b4 << i6) + b5 <= 15) {
                            bArr2[i5] = (byte) (b5 + (b4 << i6));
                            bArr2[i3] = 0;
                        } else if (b5 - (b4 << i6) >= -15) {
                            bArr2[i5] = (byte) (b5 - (b4 << i6));
                            while (true) {
                                if (i3 >= 256) {
                                    break;
                                }
                                if (bArr2[i3] == 0) {
                                    bArr2[i3] = 1;
                                    break;
                                }
                                bArr2[i3] = 0;
                                i3++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.f2358x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.f2359y, xyz.f2358x);
        long[] jArr3 = partialXYZT.xyz.f2359y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.f2359y, xyz2.f2358x);
        long[] jArr4 = partialXYZT.xyz.f2359y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yPlusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.f2360z, xyz3.f2358x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.f2357t, xyzt.f2361t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.f2358x, xyzt.xyz.f2360z);
        long[] jArr5 = partialXYZT.xyz.f2358x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f2358x, xyz4.f2360z, xyz4.f2359y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.f2359y;
        Field25519.sum(jArr6, xyz5.f2360z, jArr6);
        Field25519.sub(partialXYZT.xyz.f2360z, jArr, partialXYZT.f2357t);
        long[] jArr7 = partialXYZT.f2357t;
        Field25519.sum(jArr7, jArr, jArr7);
    }

    static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(copyOfRange)) {
            return false;
        }
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        engineFactory.update(bArr2, 0, 32);
        engineFactory.update(bArr3);
        engineFactory.update(bArr);
        byte[] digest = engineFactory.digest();
        reduce(digest);
        byte[] bytes = doubleScalarMultVarTime(digest, XYZT.fromBytesNegateVarTime(bArr3), copyOfRange).toBytes();
        for (int i3 = 0; i3 < 32; i3++) {
            if (bytes[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
