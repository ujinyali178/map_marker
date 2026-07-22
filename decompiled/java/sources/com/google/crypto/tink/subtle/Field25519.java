package com.google.crypto.tink.subtle;

import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
final class Field25519 {
    static final int FIELD_LEN = 32;
    static final int LIMB_CNT = 10;
    private static final long TWO_TO_25 = 33554432;
    private static final long TWO_TO_26 = 67108864;
    private static final int[] EXPAND_START = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] EXPAND_SHIFT = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] MASK = {67108863, 33554431};
    private static final int[] SHIFT = {26, 25};

    private Field25519() {
    }

    static byte[] contract(long[] jArr) {
        int i3;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                break;
            }
            int i5 = 0;
            while (i5 < 9) {
                long j3 = copyOf[i5];
                int i6 = -((int) (((j3 >> 31) & j3) >> SHIFT[i5 & 1]));
                copyOf[i5] = j3 + (i6 << r11);
                i5++;
                copyOf[i5] = copyOf[i5] - i6;
            }
            long j4 = copyOf[9];
            int i7 = -((int) (((j4 >> 31) & j4) >> 25));
            copyOf[9] = j4 + (i7 << 25);
            copyOf[0] = copyOf[0] - (i7 * 19);
            i4++;
        }
        long j5 = copyOf[0];
        copyOf[0] = j5 + (r2 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j5 >> 31) & j5) >> 26)));
        for (int i8 = 0; i8 < 2; i8++) {
            int i9 = 0;
            while (i9 < 9) {
                long j6 = copyOf[i9];
                int i10 = (int) (j6 >> SHIFT[i9 & 1]);
                copyOf[i9] = j6 & MASK[r11];
                i9++;
                copyOf[i9] = copyOf[i9] + i10;
            }
        }
        copyOf[9] = copyOf[9] & 33554431;
        long j7 = copyOf[0] + (((int) (r7 >> 25)) * 19);
        copyOf[0] = j7;
        int gte = gte((int) j7, 67108845);
        for (int i11 = 1; i11 < 10; i11++) {
            gte &= eq((int) copyOf[i11], MASK[i11 & 1]);
        }
        copyOf[0] = copyOf[0] - (67108845 & gte);
        long j8 = 33554431 & gte;
        copyOf[1] = copyOf[1] - j8;
        for (i3 = 2; i3 < 10; i3 += 2) {
            copyOf[i3] = copyOf[i3] - (67108863 & gte);
            int i12 = i3 + 1;
            copyOf[i12] = copyOf[i12] - j8;
        }
        for (int i13 = 0; i13 < 10; i13++) {
            copyOf[i13] = copyOf[i13] << EXPAND_SHIFT[i13];
        }
        byte[] bArr = new byte[32];
        for (int i14 = 0; i14 < 10; i14++) {
            int i15 = EXPAND_START[i14];
            long j9 = bArr[i15];
            long j10 = copyOf[i14];
            bArr[i15] = (byte) (j9 | (j10 & 255));
            bArr[i15 + 1] = (byte) (bArr[r4] | ((j10 >> 8) & 255));
            bArr[i15 + 2] = (byte) (bArr[r4] | ((j10 >> 16) & 255));
            bArr[i15 + 3] = (byte) (bArr[r3] | ((j10 >> 24) & 255));
        }
        return bArr;
    }

    private static int eq(int i3, int i4) {
        int i5 = ~(i3 ^ i4);
        int i6 = i5 & (i5 << 16);
        int i7 = i6 & (i6 << 8);
        int i8 = i7 & (i7 << 4);
        int i9 = i8 & (i8 << 2);
        return (i9 & (i9 << 1)) >> 31;
    }

    static long[] expand(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = EXPAND_START[i3];
            jArr[i3] = (((((bArr[i4] & UnsignedBytes.MAX_VALUE) | ((bArr[i4 + 1] & UnsignedBytes.MAX_VALUE) << 8)) | ((bArr[i4 + 2] & UnsignedBytes.MAX_VALUE) << 16)) | ((bArr[i4 + 3] & UnsignedBytes.MAX_VALUE) << 24)) >> EXPAND_SHIFT[i3]) & MASK[i3 & 1];
        }
        return jArr;
    }

    private static int gte(int i3, int i4) {
        return ~((i3 - i4) >> 31);
    }

    static void inverse(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        square(jArr3, jArr2);
        square(jArr12, jArr3);
        square(jArr11, jArr12);
        mult(jArr4, jArr11, jArr2);
        mult(jArr5, jArr4, jArr3);
        square(jArr11, jArr5);
        mult(jArr6, jArr11, jArr4);
        square(jArr11, jArr6);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        mult(jArr7, jArr11, jArr6);
        square(jArr11, jArr7);
        square(jArr12, jArr11);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr8, jArr12, jArr7);
        square(jArr11, jArr8);
        square(jArr12, jArr11);
        for (int i4 = 2; i4 < 20; i4 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr8);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        for (int i5 = 2; i5 < 10; i5 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr9, jArr11, jArr7);
        square(jArr11, jArr9);
        square(jArr12, jArr11);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr10, jArr12, jArr9);
        square(jArr12, jArr10);
        square(jArr11, jArr12);
        for (int i7 = 2; i7 < 100; i7 += 2) {
            square(jArr12, jArr11);
            square(jArr11, jArr12);
        }
        mult(jArr12, jArr11, jArr10);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        for (int i8 = 2; i8 < 50; i8 += 2) {
            square(jArr11, jArr12);
            square(jArr12, jArr11);
        }
        mult(jArr11, jArr12, jArr9);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        square(jArr11, jArr12);
        square(jArr12, jArr11);
        mult(jArr, jArr12, jArr5);
    }

    static void mult(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        product(jArr4, jArr2, jArr3);
        reduce(jArr4, jArr);
    }

    static void product(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j3 = jArr2[0];
        long j4 = jArr3[1] * j3;
        long j5 = jArr2[1];
        long j6 = jArr3[0];
        jArr[1] = j4 + (j5 * j6);
        long j7 = jArr2[1];
        long j8 = jArr3[1];
        jArr[2] = (j7 * 2 * j8) + (jArr3[2] * j3) + (jArr2[2] * j6);
        long j9 = jArr3[2];
        long j10 = jArr2[2];
        jArr[3] = (j7 * j9) + (j10 * j8) + (jArr3[3] * j3) + (jArr2[3] * j6);
        long j11 = jArr3[3];
        long j12 = jArr2[3];
        jArr[4] = (j10 * j9) + (((j7 * j11) + (j12 * j8)) * 2) + (jArr3[4] * j3) + (jArr2[4] * j6);
        long j13 = jArr3[4];
        long j14 = jArr2[4];
        jArr[5] = (j10 * j11) + (j12 * j9) + (j7 * j13) + (j14 * j8) + (jArr3[5] * j3) + (jArr2[5] * j6);
        long j15 = jArr3[5];
        long j16 = jArr2[5];
        jArr[6] = (((j12 * j11) + (j7 * j15) + (j16 * j8)) * 2) + (j10 * j13) + (j14 * j9) + (jArr3[6] * j3) + (jArr2[6] * j6);
        long j17 = jArr3[6];
        long j18 = jArr2[6];
        jArr[7] = (j12 * j13) + (j14 * j11) + (j10 * j15) + (j16 * j9) + (j7 * j17) + (j18 * j8) + (jArr3[7] * j3) + (jArr2[7] * j6);
        long j19 = jArr3[7];
        long j20 = jArr2[7];
        jArr[8] = (j14 * j13) + (((j12 * j15) + (j16 * j11) + (j7 * j19) + (j20 * j8)) * 2) + (j10 * j17) + (j18 * j9) + (jArr3[8] * j3) + (jArr2[8] * j6);
        long j21 = jArr3[8];
        long j22 = jArr2[8];
        jArr[9] = (j14 * j15) + (j16 * j13) + (j12 * j17) + (j18 * j11) + (j10 * j19) + (j20 * j9) + (j7 * j21) + (j22 * j8) + (j3 * jArr3[9]) + (jArr2[9] * j6);
        long j23 = jArr3[9];
        long j24 = jArr2[9];
        jArr[10] = (((j16 * j15) + (j12 * j19) + (j20 * j11) + (j7 * j23) + (j8 * j24)) * 2) + (j14 * j17) + (j18 * j13) + (j10 * j21) + (j22 * j9);
        jArr[11] = (j16 * j17) + (j18 * j15) + (j14 * j19) + (j20 * j13) + (j12 * j21) + (j22 * j11) + (j10 * j23) + (j9 * j24);
        jArr[12] = (j18 * j17) + (((j16 * j19) + (j20 * j15) + (j12 * j23) + (j11 * j24)) * 2) + (j14 * j21) + (j22 * j13);
        jArr[13] = (j18 * j19) + (j20 * j17) + (j16 * j21) + (j22 * j15) + (j14 * j23) + (j13 * j24);
        jArr[14] = (((j20 * j19) + (j16 * j23) + (j15 * j24)) * 2) + (j18 * j21) + (j22 * j17);
        jArr[15] = (j20 * j21) + (j22 * j19) + (j18 * j23) + (j17 * j24);
        jArr[16] = (j22 * j21) + (((j20 * j23) + (j19 * j24)) * 2);
        jArr[17] = (j22 * j23) + (j21 * j24);
        jArr[18] = j24 * 2 * j23;
    }

    static void reduce(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        reduceSizeByModularReduction(jArr);
        reduceCoefficients(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void reduceCoefficients(long[] jArr) {
        jArr[10] = 0;
        int i3 = 0;
        while (i3 < 10) {
            long j3 = jArr[i3];
            long j4 = j3 / TWO_TO_26;
            jArr[i3] = j3 - (j4 << 26);
            int i4 = i3 + 1;
            long j5 = jArr[i4] + j4;
            jArr[i4] = j5;
            long j6 = j5 / TWO_TO_25;
            jArr[i4] = j5 - (j6 << 25);
            i3 += 2;
            jArr[i3] = jArr[i3] + j6;
        }
        long j7 = jArr[0];
        long j8 = jArr[10];
        long j9 = j7 + (j8 << 4);
        jArr[0] = j9;
        long j10 = j9 + (j8 << 1);
        jArr[0] = j10;
        long j11 = j10 + j8;
        jArr[0] = j11;
        jArr[10] = 0;
        long j12 = j11 / TWO_TO_26;
        jArr[0] = j11 - (j12 << 26);
        jArr[1] = jArr[1] + j12;
    }

    static void reduceSizeByModularReduction(long[] jArr) {
        long j3 = jArr[8];
        long j4 = jArr[18];
        long j5 = j3 + (j4 << 4);
        jArr[8] = j5;
        long j6 = j5 + (j4 << 1);
        jArr[8] = j6;
        jArr[8] = j6 + j4;
        long j7 = jArr[7];
        long j8 = jArr[17];
        long j9 = j7 + (j8 << 4);
        jArr[7] = j9;
        long j10 = j9 + (j8 << 1);
        jArr[7] = j10;
        jArr[7] = j10 + j8;
        long j11 = jArr[6];
        long j12 = jArr[16];
        long j13 = j11 + (j12 << 4);
        jArr[6] = j13;
        long j14 = j13 + (j12 << 1);
        jArr[6] = j14;
        jArr[6] = j14 + j12;
        long j15 = jArr[5];
        long j16 = jArr[15];
        long j17 = j15 + (j16 << 4);
        jArr[5] = j17;
        long j18 = j17 + (j16 << 1);
        jArr[5] = j18;
        jArr[5] = j18 + j16;
        long j19 = jArr[4];
        long j20 = jArr[14];
        long j21 = j19 + (j20 << 4);
        jArr[4] = j21;
        long j22 = j21 + (j20 << 1);
        jArr[4] = j22;
        jArr[4] = j22 + j20;
        long j23 = jArr[3];
        long j24 = jArr[13];
        long j25 = j23 + (j24 << 4);
        jArr[3] = j25;
        long j26 = j25 + (j24 << 1);
        jArr[3] = j26;
        jArr[3] = j26 + j24;
        long j27 = jArr[2];
        long j28 = jArr[12];
        long j29 = j27 + (j28 << 4);
        jArr[2] = j29;
        long j30 = j29 + (j28 << 1);
        jArr[2] = j30;
        jArr[2] = j30 + j28;
        long j31 = jArr[1];
        long j32 = jArr[11];
        long j33 = j31 + (j32 << 4);
        jArr[1] = j33;
        long j34 = j33 + (j32 << 1);
        jArr[1] = j34;
        jArr[1] = j34 + j32;
        long j35 = jArr[0];
        long j36 = jArr[10];
        long j37 = j35 + (j36 << 4);
        jArr[0] = j37;
        long j38 = j37 + (j36 << 1);
        jArr[0] = j38;
        jArr[0] = j38 + j36;
    }

    static void scalarProduct(long[] jArr, long[] jArr2, long j3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] * j3;
        }
    }

    static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        squareInner(jArr3, jArr2);
        reduce(jArr3, jArr);
    }

    private static void squareInner(long[] jArr, long[] jArr2) {
        long j3 = jArr2[0];
        jArr[0] = j3 * j3;
        long j4 = jArr2[0];
        jArr[1] = j4 * 2 * jArr2[1];
        long j5 = jArr2[1];
        jArr[2] = ((j5 * j5) + (jArr2[2] * j4)) * 2;
        long j6 = jArr2[2];
        jArr[3] = ((j5 * j6) + (jArr2[3] * j4)) * 2;
        long j7 = jArr2[3];
        jArr[4] = (j6 * j6) + (j5 * 4 * j7) + (j4 * 2 * jArr2[4]);
        long j8 = jArr2[4];
        jArr[5] = ((j6 * j7) + (j5 * j8) + (jArr2[5] * j4)) * 2;
        long j9 = (j7 * j7) + (j6 * j8) + (jArr2[6] * j4);
        long j10 = jArr2[5];
        jArr[6] = (j9 + (j5 * 2 * j10)) * 2;
        long j11 = jArr2[6];
        jArr[7] = ((j7 * j8) + (j6 * j10) + (j5 * j11) + (jArr2[7] * j4)) * 2;
        long j12 = (j6 * j11) + (jArr2[8] * j4);
        long j13 = jArr2[7];
        jArr[8] = (j8 * j8) + ((j12 + (((j5 * j13) + (j7 * j10)) * 2)) * 2);
        long j14 = jArr2[8];
        jArr[9] = ((j8 * j10) + (j7 * j11) + (j6 * j13) + (j5 * j14) + (j4 * jArr2[9])) * 2;
        long j15 = jArr2[9];
        jArr[10] = ((j10 * j10) + (j8 * j11) + (j6 * j14) + (((j7 * j13) + (j5 * j15)) * 2)) * 2;
        jArr[11] = ((j10 * j11) + (j8 * j13) + (j7 * j14) + (j6 * j15)) * 2;
        jArr[12] = (j11 * j11) + (((j8 * j14) + (((j10 * j13) + (j7 * j15)) * 2)) * 2);
        jArr[13] = ((j11 * j13) + (j10 * j14) + (j8 * j15)) * 2;
        jArr[14] = ((j13 * j13) + (j11 * j14) + (j10 * 2 * j15)) * 2;
        jArr[15] = ((j13 * j14) + (j11 * j15)) * 2;
        jArr[16] = (j14 * j14) + (j13 * 4 * j15);
        jArr[17] = j14 * 2 * j15;
        jArr[18] = 2 * j15 * j15;
    }

    static void sub(long[] jArr, long[] jArr2) {
        sub(jArr, jArr2, jArr);
    }

    static void sub(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] - jArr3[i3];
        }
    }

    static void sum(long[] jArr, long[] jArr2) {
        sum(jArr, jArr, jArr2);
    }

    static void sum(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] + jArr3[i3];
        }
    }
}
