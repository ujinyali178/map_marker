package com.google.common.hash;

import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;

    Fingerprint2011() {
    }

    static long fingerprint(byte[] bArr, int i3, int i4) {
        long murmurHash64WithSeed = i4 <= 32 ? murmurHash64WithSeed(bArr, i3, i4, -1397348546323613475L) : i4 <= 64 ? hashLength33To64(bArr, i3, i4) : fullFingerprint(bArr, i3, i4);
        long j3 = K0;
        long load64 = i4 >= 8 ? LittleEndianByteArray.load64(bArr, i3) : -6505348102511208375L;
        if (i4 >= 9) {
            j3 = LittleEndianByteArray.load64(bArr, (i3 + i4) - 8);
        }
        long hash128to64 = hash128to64(murmurHash64WithSeed + j3, load64);
        return (hash128to64 == 0 || hash128to64 == 1) ? hash128to64 - 2 : hash128to64;
    }

    private static long fullFingerprint(byte[] bArr, int i3, int i4) {
        long load64 = LittleEndianByteArray.load64(bArr, i3);
        int i5 = i3 + i4;
        long load642 = LittleEndianByteArray.load64(bArr, i5 - 16) ^ K1;
        long load643 = LittleEndianByteArray.load64(bArr, i5 - 56) ^ K0;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j3 = i4;
        weakHashLength32WithSeeds(bArr, i5 - 64, j3, load642, jArr);
        weakHashLength32WithSeeds(bArr, i5 - 32, j3 * K1, K0, jArr2);
        long shiftMix = load643 + (shiftMix(jArr[1]) * K1);
        long rotateRight = Long.rotateRight(shiftMix + load64, 39) * K1;
        long rotateRight2 = Long.rotateRight(load642, 33) * K1;
        int i6 = i3;
        int i7 = (i4 - 1) & (-64);
        while (true) {
            long rotateRight3 = Long.rotateRight(rotateRight + rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr, i6 + 16), 37) * K1;
            long rotateRight4 = Long.rotateRight(rotateRight2 + jArr[1] + LittleEndianByteArray.load64(bArr, i6 + 48), 42) * K1;
            long j4 = rotateRight3 ^ jArr2[1];
            long j5 = rotateRight4 ^ jArr[0];
            long rotateRight5 = Long.rotateRight(shiftMix ^ jArr2[0], 33);
            weakHashLength32WithSeeds(bArr, i6, jArr[1] * K1, j4 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i6 + 32, jArr2[1] + rotateRight5, j5, jArr2);
            i6 += 64;
            i7 -= 64;
            if (i7 == 0) {
                return hash128to64(hash128to64(jArr[0], jArr2[0]) + (shiftMix(j5) * K1) + j4, hash128to64(jArr[1], jArr2[1]) + rotateRight5);
            }
            rotateRight = rotateRight5;
            shiftMix = j4;
            rotateRight2 = j5;
        }
    }

    static long hash128to64(long j3, long j4) {
        long j5 = (j4 ^ j3) * K3;
        long j6 = (j3 ^ (j5 ^ (j5 >>> 47))) * K3;
        return (j6 ^ (j6 >>> 47)) * K3;
    }

    private static long hashLength33To64(byte[] bArr, int i3, int i4) {
        long load64 = LittleEndianByteArray.load64(bArr, i3 + 24);
        int i5 = i3 + i4;
        int i6 = i5 - 16;
        long load642 = LittleEndianByteArray.load64(bArr, i3) + ((i4 + LittleEndianByteArray.load64(bArr, i6)) * K0);
        long rotateRight = Long.rotateRight(load642 + load64, 52);
        long rotateRight2 = Long.rotateRight(load642, 37);
        long load643 = load642 + LittleEndianByteArray.load64(bArr, i3 + 8);
        long rotateRight3 = rotateRight2 + Long.rotateRight(load643, 7);
        int i7 = i3 + 16;
        long load644 = load643 + LittleEndianByteArray.load64(bArr, i7);
        long j3 = load64 + load644;
        long rotateRight4 = rotateRight + Long.rotateRight(load644, 31) + rotateRight3;
        long load645 = LittleEndianByteArray.load64(bArr, i7) + LittleEndianByteArray.load64(bArr, i5 - 32);
        long load646 = LittleEndianByteArray.load64(bArr, i5 - 8);
        long rotateRight5 = Long.rotateRight(load645 + load646, 52);
        long rotateRight6 = Long.rotateRight(load645, 37);
        long load647 = load645 + LittleEndianByteArray.load64(bArr, i5 - 24);
        long rotateRight7 = rotateRight6 + Long.rotateRight(load647, 7);
        long load648 = load647 + LittleEndianByteArray.load64(bArr, i6);
        return shiftMix((shiftMix(((j3 + rotateRight5 + Long.rotateRight(load648, 31) + rotateRight7) * K2) + ((load646 + load648 + rotateRight4) * K0)) * K0) + rotateRight4) * K2;
    }

    static long murmurHash64WithSeed(byte[] bArr, int i3, int i4, long j3) {
        int i5 = i4 & (-8);
        int i6 = i4 & 7;
        long j4 = j3 ^ (i4 * K3);
        for (int i7 = 0; i7 < i5; i7 += 8) {
            j4 = (j4 ^ (shiftMix(LittleEndianByteArray.load64(bArr, i3 + i7) * K3) * K3)) * K3;
        }
        if (i6 != 0) {
            j4 = (LittleEndianByteArray.load64Safely(bArr, i3 + i5, i6) ^ j4) * K3;
        }
        return shiftMix(shiftMix(j4) * K3);
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
        long rotateRight = Long.rotateRight(j4 + j5 + load644, 51) + Long.rotateRight(j6, 23);
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
        return "Hashing.fingerprint2011()";
    }
}
