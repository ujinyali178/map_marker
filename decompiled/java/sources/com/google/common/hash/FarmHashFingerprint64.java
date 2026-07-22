package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    FarmHashFingerprint64() {
    }

    static long fingerprint(byte[] bArr, int i3, int i4) {
        return i4 <= 32 ? i4 <= 16 ? hashLength0to16(bArr, i3, i4) : hashLength17to32(bArr, i3, i4) : i4 <= 64 ? hashLength33To64(bArr, i3, i4) : hashLength65Plus(bArr, i3, i4);
    }

    private static long hashLength0to16(byte[] bArr, int i3, int i4) {
        if (i4 >= 8) {
            long j3 = (i4 * 2) + K2;
            long load64 = LittleEndianByteArray.load64(bArr, i3) + K2;
            long load642 = LittleEndianByteArray.load64(bArr, (i3 + i4) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j3) + load64, (Long.rotateRight(load64, 25) + load642) * j3, j3);
        }
        if (i4 >= 4) {
            return hashLength16(i4 + ((LittleEndianByteArray.load32(bArr, i3) & 4294967295L) << 3), LittleEndianByteArray.load32(bArr, (i3 + i4) - 4) & 4294967295L, (i4 * 2) + K2);
        }
        if (i4 <= 0) {
            return K2;
        }
        return shiftMix((((bArr[i3] & UnsignedBytes.MAX_VALUE) + ((bArr[(i4 >> 1) + i3] & UnsignedBytes.MAX_VALUE) << 8)) * K2) ^ ((i4 + ((bArr[i3 + (i4 - 1)] & 255) << 2)) * K0)) * K2;
    }

    private static long hashLength16(long j3, long j4, long j5) {
        long j6 = (j3 ^ j4) * j5;
        long j7 = ((j6 ^ (j6 >>> 47)) ^ j4) * j5;
        return (j7 ^ (j7 >>> 47)) * j5;
    }

    private static long hashLength17to32(byte[] bArr, int i3, int i4) {
        long j3 = (i4 * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i3) * K1;
        long load642 = LittleEndianByteArray.load64(bArr, i3 + 8);
        int i5 = i3 + i4;
        long load643 = LittleEndianByteArray.load64(bArr, i5 - 8) * j3;
        return hashLength16((LittleEndianByteArray.load64(bArr, i5 - 16) * K2) + Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30), load643 + load64 + Long.rotateRight(load642 + K2, 18), j3);
    }

    private static long hashLength33To64(byte[] bArr, int i3, int i4) {
        long j3 = (i4 * 2) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i3) * K2;
        long load642 = LittleEndianByteArray.load64(bArr, i3 + 8);
        int i5 = i3 + i4;
        long load643 = LittleEndianByteArray.load64(bArr, i5 - 8) * j3;
        long rotateRight = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr, i5 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, load643 + Long.rotateRight(load642 + K2, 18) + load64, j3);
        long load644 = LittleEndianByteArray.load64(bArr, i3 + 16) * j3;
        long load645 = LittleEndianByteArray.load64(bArr, i3 + 24);
        long load646 = (rotateRight + LittleEndianByteArray.load64(bArr, i5 - 32)) * j3;
        return hashLength16(((hashLength16 + LittleEndianByteArray.load64(bArr, i5 - 24)) * j3) + Long.rotateRight(load644 + load645, 43) + Long.rotateRight(load646, 30), load644 + Long.rotateRight(load645 + load64, 18) + load646, j3);
    }

    private static long hashLength65Plus(byte[] bArr, int i3, int i4) {
        long j3 = 81;
        long j4 = (j3 * K1) + 113;
        long shiftMix = shiftMix((j4 * K2) + 113) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long load64 = (j3 * K2) + LittleEndianByteArray.load64(bArr, i3);
        int i5 = i4 - 1;
        int i6 = i3 + ((i5 / 64) * 64);
        int i7 = i5 & 63;
        int i8 = (i6 + i7) - 63;
        int i9 = i3;
        while (true) {
            long rotateRight = Long.rotateRight(load64 + j4 + jArr[0] + LittleEndianByteArray.load64(bArr, i9 + 8), 37) * K1;
            long rotateRight2 = Long.rotateRight(j4 + jArr[1] + LittleEndianByteArray.load64(bArr, i9 + 48), 42) * K1;
            long j5 = rotateRight ^ jArr2[1];
            long load642 = rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr, i9 + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i9, jArr[1] * K1, j5 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i9 + 32, rotateRight3 + jArr2[1], load642 + LittleEndianByteArray.load64(bArr, i9 + 16), jArr2);
            int i10 = i9 + 64;
            if (i10 == i6) {
                long j6 = K1 + ((j5 & 255) << 1);
                long j7 = jArr2[0] + i7;
                jArr2[0] = j7;
                long j8 = jArr[0] + j7;
                jArr[0] = j8;
                jArr2[0] = jArr2[0] + j8;
                long rotateRight4 = Long.rotateRight(rotateRight3 + load642 + jArr[0] + LittleEndianByteArray.load64(bArr, i8 + 8), 37) * j6;
                long rotateRight5 = Long.rotateRight(load642 + jArr[1] + LittleEndianByteArray.load64(bArr, i8 + 48), 42) * j6;
                long j9 = rotateRight4 ^ (jArr2[1] * 9);
                long load643 = rotateRight5 + (jArr[0] * 9) + LittleEndianByteArray.load64(bArr, i8 + 40);
                long rotateRight6 = Long.rotateRight(j5 + jArr2[0], 33) * j6;
                weakHashLength32WithSeeds(bArr, i8, jArr[1] * j6, j9 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr, i8 + 32, rotateRight6 + jArr2[1], load643 + LittleEndianByteArray.load64(bArr, i8 + 16), jArr2);
                return hashLength16(hashLength16(jArr[0], jArr2[0], j6) + (shiftMix(load643) * K0) + j9, hashLength16(jArr[1], jArr2[1], j6) + rotateRight6, j6);
            }
            i9 = i10;
            shiftMix = j5;
            j4 = load642;
            load64 = rotateRight3;
        }
    }

    private static long shiftMix(long j3) {
        return j3 ^ (j3 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i3, long j3, long j4, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i3);
        long load642 = LittleEndianByteArray.load64(bArr, i3 + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i3 + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i3 + 24);
        long j5 = j3 + load64;
        long j6 = load642 + j5 + load643;
        long rotateRight = Long.rotateRight(j4 + j5 + load644, 21) + Long.rotateRight(j6, 44);
        jArr[0] = j6 + load644;
        jArr[1] = rotateRight + j5;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i3, i4));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
