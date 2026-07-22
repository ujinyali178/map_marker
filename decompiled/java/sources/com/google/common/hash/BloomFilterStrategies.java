package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@ParametricNullness T t3, Funnel<? super T> funnel, int i3, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t3, funnel).asLong();
            int i4 = (int) asLong;
            int i5 = (int) (asLong >>> 32);
            for (int i6 = 1; i6 <= i3; i6++) {
                int i7 = (i6 * i5) + i4;
                if (i7 < 0) {
                    i7 = ~i7;
                }
                if (!lockFreeBitArray.get(i7 % bitSize)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@ParametricNullness T t3, Funnel<? super T> funnel, int i3, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t3, funnel).asLong();
            int i4 = (int) asLong;
            int i5 = (int) (asLong >>> 32);
            boolean z3 = false;
            for (int i6 = 1; i6 <= i3; i6++) {
                int i7 = (i6 * i5) + i4;
                if (i7 < 0) {
                    i7 = ~i7;
                }
                z3 |= lockFreeBitArray.set(i7 % bitSize);
            }
            return z3;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@ParametricNullness T t3, Funnel<? super T> funnel, int i3, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t3, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i4 = 0; i4 < i3; i4++) {
                if (!lockFreeBitArray.get((Long.MAX_VALUE & lowerEight) % bitSize)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@ParametricNullness T t3, Funnel<? super T> funnel, int i3, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t3, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z3 = false;
            for (int i4 = 0; i4 < i3; i4++) {
                z3 |= lockFreeBitArray.set((Long.MAX_VALUE & lowerEight) % bitSize);
                lowerEight += upperEight;
            }
            return z3;
        }
    };

    static final class LockFreeBitArray {
        private static final int LONG_ADDRESSABLE_BITS = 6;
        private final LongAddable bitCount;
        final AtomicLongArray data;

        LockFreeBitArray(long j3) {
            Preconditions.checkArgument(j3 > 0, "data length is zero!");
            this.data = new AtomicLongArray(Ints.checkedCast(LongMath.divide(j3, 64L, RoundingMode.CEILING)));
            this.bitCount = LongAddables.create();
        }

        LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long j3 = 0;
            for (long j4 : jArr) {
                j3 += Long.bitCount(j4);
            }
            this.bitCount.add(j3);
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i3 = 0; i3 < length; i3++) {
                jArr[i3] = atomicLongArray.get(i3);
            }
            return jArr;
        }

        long bitCount() {
            return this.bitCount.sum();
        }

        long bitSize() {
            return this.data.length() * 64;
        }

        LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        int dataLength() {
            return this.data.length();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) obj).data));
            }
            return false;
        }

        boolean get(long j3) {
            return ((1 << ((int) j3)) & this.data.get((int) (j3 >>> 6))) != 0;
        }

        public int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }

        void putAll(LockFreeBitArray lockFreeBitArray) {
            Preconditions.checkArgument(this.data.length() == lockFreeBitArray.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), lockFreeBitArray.data.length());
            for (int i3 = 0; i3 < this.data.length(); i3++) {
                putData(i3, lockFreeBitArray.data.get(i3));
            }
        }

        void putData(int i3, long j3) {
            long j4;
            long j5;
            boolean z3;
            while (true) {
                j4 = this.data.get(i3);
                j5 = j4 | j3;
                if (j4 == j5) {
                    z3 = false;
                    break;
                } else if (this.data.compareAndSet(i3, j4, j5)) {
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                this.bitCount.add(Long.bitCount(j5) - Long.bitCount(j4));
            }
        }

        boolean set(long j3) {
            long j4;
            long j5;
            if (get(j3)) {
                return false;
            }
            int i3 = (int) (j3 >>> 6);
            long j6 = 1 << ((int) j3);
            do {
                j4 = this.data.get(i3);
                j5 = j4 | j6;
                if (j4 == j5) {
                    return false;
                }
            } while (!this.data.compareAndSet(i3, j4, j5));
            this.bitCount.increment();
            return true;
        }
    }
}
