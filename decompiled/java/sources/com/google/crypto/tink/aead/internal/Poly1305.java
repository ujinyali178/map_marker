package com.google.crypto.tink.aead.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    public static byte[] computeMac(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        int i3 = 0;
        long load26 = load26(bArr, 0, 0) & 67108863;
        int i4 = 3;
        long load262 = load26(bArr, 3, 2) & 67108611;
        long load263 = load26(bArr, 6, 4) & 67092735;
        long load264 = load26(bArr, 9, 6) & 66076671;
        long load265 = load26(bArr, 12, 8) & 1048575;
        long j3 = load262 * 5;
        long j4 = load263 * 5;
        long j5 = load264 * 5;
        long j6 = load265 * 5;
        byte[] bArr3 = new byte[17];
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        int i5 = 0;
        while (i5 < bArr2.length) {
            copyBlockSize(bArr3, bArr2, i5);
            long load266 = j11 + load26(bArr3, i3, i3);
            long load267 = j7 + load26(bArr3, i4, 2);
            long load268 = j8 + load26(bArr3, 6, 4);
            long load269 = j9 + load26(bArr3, 9, 6);
            long load2610 = j10 + (load26(bArr3, 12, 8) | (bArr3[16] << Ascii.CAN));
            long j12 = (load266 * load26) + (load267 * j6) + (load268 * j5) + (load269 * j4) + (load2610 * j3);
            long j13 = (load266 * load262) + (load267 * load26) + (load268 * j6) + (load269 * j5) + (load2610 * j4);
            long j14 = (load266 * load263) + (load267 * load262) + (load268 * load26) + (load269 * j6) + (load2610 * j5);
            long j15 = (load266 * load264) + (load267 * load263) + (load268 * load262) + (load269 * load26) + (load2610 * j6);
            long j16 = j13 + (j12 >> 26);
            long j17 = j14 + (j16 >> 26);
            long j18 = j15 + (j17 >> 26);
            long j19 = (load266 * load265) + (load267 * load264) + (load268 * load263) + (load269 * load262) + (load2610 * load26) + (j18 >> 26);
            long j20 = (j12 & 67108863) + ((j19 >> 26) * 5);
            j7 = (j16 & 67108863) + (j20 >> 26);
            i5 += 16;
            j8 = j17 & 67108863;
            j9 = j18 & 67108863;
            j10 = j19 & 67108863;
            i4 = 3;
            j11 = j20 & 67108863;
            i3 = 0;
        }
        long j21 = j8 + (j7 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j9 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j10 + (j23 >> 26);
        long j26 = j25 & 67108863;
        long j27 = j11 + ((j25 >> 26) * 5);
        long j28 = j27 & 67108863;
        long j29 = (j7 & 67108863) + (j27 >> 26);
        long j30 = j28 + 5;
        long j31 = j30 & 67108863;
        long j32 = (j30 >> 26) + j29;
        long j33 = j22 + (j32 >> 26);
        long j34 = j24 + (j33 >> 26);
        long j35 = (j26 + (j34 >> 26)) - 67108864;
        long j36 = j35 >> 63;
        long j37 = j28 & j36;
        long j38 = j29 & j36;
        long j39 = j22 & j36;
        long j40 = j24 & j36;
        long j41 = j26 & j36;
        long j42 = ~j36;
        long j43 = (j32 & 67108863 & j42) | j38;
        long j44 = (j33 & 67108863 & j42) | j39;
        long j45 = (j34 & 67108863 & j42) | j40;
        long j46 = (j35 & j42) | j41;
        long j47 = (j37 | (j31 & j42) | (j43 << 26)) & 4294967295L;
        long j48 = ((j43 >> 6) | (j44 << 20)) & 4294967295L;
        long j49 = ((j44 >> 12) | (j45 << 14)) & 4294967295L;
        long j50 = ((j45 >> 18) | (j46 << 8)) & 4294967295L;
        long load32 = j47 + load32(bArr, 16);
        long j51 = load32 & 4294967295L;
        long load322 = j48 + load32(bArr, 20) + (load32 >> 32);
        long j52 = load322 & 4294967295L;
        long load323 = j49 + load32(bArr, 24) + (load322 >> 32);
        long j53 = load323 & 4294967295L;
        long load324 = (j50 + load32(bArr, 28) + (load323 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        toByteArray(bArr4, j51, 0);
        toByteArray(bArr4, j52, 4);
        toByteArray(bArr4, j53, 8);
        toByteArray(bArr4, load324, 12);
        return bArr4;
    }

    private static void copyBlockSize(byte[] bArr, byte[] bArr2, int i3) {
        int min = Math.min(16, bArr2.length - i3);
        System.arraycopy(bArr2, i3, bArr, 0, min);
        bArr[min] = 1;
        if (min != 16) {
            Arrays.fill(bArr, min + 1, bArr.length, (byte) 0);
        }
    }

    private static long load26(byte[] bArr, int i3, int i4) {
        return (load32(bArr, i3) >> i4) & 67108863;
    }

    private static long load32(byte[] bArr, int i3) {
        return (((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16)) & 4294967295L;
    }

    private static void toByteArray(byte[] bArr, long j3, int i3) {
        int i4 = 0;
        while (i4 < 4) {
            bArr[i3 + i4] = (byte) (255 & j3);
            i4++;
            j3 >>= 8;
        }
    }

    public static void verifyMac(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!Bytes.equal(computeMac(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
