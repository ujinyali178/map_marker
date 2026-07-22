package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private static final long C1 = -8663945395140668459L;
        private static final long C2 = 5545529020109919103L;
        private static final int CHUNK_SIZE = 16;

        /* renamed from: h1, reason: collision with root package name */
        private long f2286h1;

        /* renamed from: h2, reason: collision with root package name */
        private long f2287h2;
        private int length;

        Murmur3_128Hasher(int i3) {
            super(16);
            long j3 = i3;
            this.f2286h1 = j3;
            this.f2287h2 = j3;
            this.length = 0;
        }

        private void bmix64(long j3, long j4) {
            long mixK1 = mixK1(j3) ^ this.f2286h1;
            this.f2286h1 = mixK1;
            long rotateLeft = Long.rotateLeft(mixK1, 27);
            long j5 = this.f2287h2;
            this.f2286h1 = ((rotateLeft + j5) * 5) + 1390208809;
            long mixK2 = mixK2(j4) ^ j5;
            this.f2287h2 = mixK2;
            this.f2287h2 = ((Long.rotateLeft(mixK2, 31) + this.f2286h1) * 5) + 944331445;
        }

        private static long fmix64(long j3) {
            long j4 = (j3 ^ (j3 >>> 33)) * (-49064778989728563L);
            long j5 = (j4 ^ (j4 >>> 33)) * (-4265267296055464877L);
            return j5 ^ (j5 >>> 33);
        }

        private static long mixK1(long j3) {
            return Long.rotateLeft(j3 * C1, 31) * C2;
        }

        private static long mixK2(long j3) {
            return Long.rotateLeft(j3 * C2, 33) * C1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long j3 = this.f2286h1;
            int i3 = this.length;
            long j4 = j3 ^ i3;
            long j5 = this.f2287h2 ^ i3;
            long j6 = j4 + j5;
            this.f2286h1 = j6;
            this.f2287h2 = j5 + j6;
            this.f2286h1 = fmix64(j6);
            long fmix64 = fmix64(this.f2287h2);
            long j7 = this.f2286h1 + fmix64;
            this.f2286h1 = j7;
            this.f2287h2 = fmix64 + j7;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f2286h1).putLong(this.f2287h2).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long j16;
            this.length += byteBuffer.remaining();
            long j17 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j3 = 0;
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 2:
                    j4 = 0;
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 3:
                    j5 = 0;
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 4:
                    j6 = 0;
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 5:
                    j7 = 0;
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 6:
                    j8 = 0;
                    j7 = j8 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 7:
                    j8 = (UnsignedBytes.toInt(byteBuffer.get(6)) << 48) ^ 0;
                    j7 = j8 ^ (UnsignedBytes.toInt(byteBuffer.get(5)) << 40);
                    j6 = j7 ^ (UnsignedBytes.toInt(byteBuffer.get(4)) << 32);
                    j5 = j6 ^ (UnsignedBytes.toInt(byteBuffer.get(3)) << 24);
                    j4 = j5 ^ (UnsignedBytes.toInt(byteBuffer.get(2)) << 16);
                    j3 = j4 ^ (UnsignedBytes.toInt(byteBuffer.get(1)) << 8);
                    j9 = UnsignedBytes.toInt(byteBuffer.get(0)) ^ j3;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 8:
                    j10 = 0;
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 9:
                    j11 = 0;
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 10:
                    j12 = 0;
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 11:
                    j13 = 0;
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 12:
                    j14 = 0;
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 13:
                    j15 = 0;
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 14:
                    j16 = 0;
                    j15 = j16 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                case 15:
                    j16 = (UnsignedBytes.toInt(byteBuffer.get(14)) << 48) ^ 0;
                    j15 = j16 ^ (UnsignedBytes.toInt(byteBuffer.get(13)) << 40);
                    j14 = j15 ^ (UnsignedBytes.toInt(byteBuffer.get(12)) << 32);
                    j13 = j14 ^ (UnsignedBytes.toInt(byteBuffer.get(11)) << 24);
                    j12 = j13 ^ (UnsignedBytes.toInt(byteBuffer.get(10)) << 16);
                    j11 = j12 ^ (UnsignedBytes.toInt(byteBuffer.get(9)) << 8);
                    j10 = j11 ^ UnsignedBytes.toInt(byteBuffer.get(8));
                    j9 = byteBuffer.getLong() ^ 0;
                    j17 = j10;
                    this.f2286h1 ^= mixK1(j9);
                    this.f2287h2 ^= mixK2(j17);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    Murmur3_128HashFunction(int i3) {
        this.seed = i3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 128;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }
}
