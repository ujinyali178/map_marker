package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0, false);
    static final HashFunction MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED, true);

    private static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;

        /* renamed from: h1, reason: collision with root package name */
        private int f2288h1;
        private int shift;
        private int length = 0;
        private boolean isDone = false;

        Murmur3_32Hasher(int i3) {
            this.f2288h1 = i3;
        }

        private void update(int i3, long j3) {
            long j4 = this.buffer;
            int i4 = this.shift;
            long j5 = ((j3 & 4294967295L) << i4) | j4;
            this.buffer = j5;
            int i5 = i4 + (i3 * 8);
            this.shift = i5;
            this.length += i3;
            if (i5 >= 32) {
                this.f2288h1 = Murmur3_32HashFunction.mixH1(this.f2288h1, Murmur3_32HashFunction.mixK1((int) j5));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int mixK1 = this.f2288h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.f2288h1 = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.length);
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b4) {
            update(1, b4 & UnsignedBytes.MAX_VALUE);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bArr, int i3, int i4) {
            Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
            int i5 = 0;
            while (true) {
                int i6 = i5 + 4;
                if (i6 > i4) {
                    break;
                }
                update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i5 + i3));
                i5 = i6;
            }
            while (i5 < i4) {
                putByte(bArr[i3 + i5]);
                i5++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c3) {
            update(2, c3);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i3) {
            update(4, i3);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long j3) {
            update(4, (int) j3);
            update(4, j3 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            long charToThreeUtf8Bytes;
            int i3;
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length = charSequence.length();
            int i4 = 0;
            while (true) {
                int i5 = i4 + 4;
                if (i5 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i4);
                char charAt2 = charSequence.charAt(i4 + 1);
                char charAt3 = charSequence.charAt(i4 + 2);
                char charAt4 = charSequence.charAt(i4 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                i4 = i5;
            }
            while (i4 < length) {
                char charAt5 = charSequence.charAt(i4);
                if (charAt5 < 128) {
                    update(1, charAt5);
                } else {
                    if (charAt5 < 2048) {
                        charToThreeUtf8Bytes = Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5);
                        i3 = 2;
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        charToThreeUtf8Bytes = Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5);
                        i3 = 3;
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i4);
                        if (codePointAt == charAt5) {
                            putBytes(charSequence.subSequence(i4, length).toString().getBytes(charset));
                            return this;
                        }
                        i4++;
                        update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                    }
                    update(i3, charToThreeUtf8Bytes);
                }
                i4++;
            }
            return this;
        }
    }

    Murmur3_32HashFunction(int i3, boolean z3) {
        this.seed = i3;
        this.supplementaryPlaneFix = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c3) {
        return (c3 >>> '\f') | 224 | ((((c3 >>> 6) & 63) | 128) << 8) | (((c3 & '?') | 128) << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c3) {
        return (c3 >>> 6) | 192 | (((c3 & '?') | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i3) {
        return (i3 >>> 18) | 240 | ((((i3 >>> 12) & 63) | 128) << 8) | ((((i3 >>> 6) & 63) | 128) << 16) | (((i3 & 63) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i3, int i4) {
        int i5 = i3 ^ i4;
        int i6 = (i5 ^ (i5 >>> 16)) * (-2048144789);
        int i7 = (i6 ^ (i6 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i7 ^ (i7 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i3) {
        return Ints.fromBytes(bArr[i3 + 3], bArr[i3 + 2], bArr[i3 + 1], bArr[i3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i3, int i4) {
        return (Integer.rotateLeft(i3 ^ i4, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i3) {
        return Integer.rotateLeft(i3 * C1, 15) * C2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
        return this.seed == murmur3_32HashFunction.seed && this.supplementaryPlaneFix == murmur3_32HashFunction.supplementaryPlaneFix;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i3, int i4) {
        Preconditions.checkPositionIndexes(i3, i3 + i4, bArr.length);
        int i5 = this.seed;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = i7 + 4;
            if (i8 > i4) {
                break;
            }
            i5 = mixH1(i5, mixK1(getIntLittleEndian(bArr, i7 + i3)));
            i7 = i8;
        }
        int i9 = i7;
        int i10 = 0;
        while (i9 < i4) {
            i6 ^= UnsignedBytes.toInt(bArr[i3 + i9]) << i10;
            i9++;
            i10 += 8;
        }
        return fmix(mixK1(i6) ^ i5, i4);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int i3) {
        return fmix(mixH1(this.seed, mixK1(i3)), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long j3) {
        int i3 = (int) (j3 >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j3)), mixK1(i3)), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i3 = this.seed;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 4;
            if (i7 > length) {
                break;
            }
            char charAt = charSequence.charAt(i5);
            char charAt2 = charSequence.charAt(i5 + 1);
            char charAt3 = charSequence.charAt(i5 + 2);
            char charAt4 = charSequence.charAt(i5 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i3 = mixH1(i3, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i6 += 4;
            i5 = i7;
        }
        long j3 = 0;
        while (i5 < length) {
            char charAt5 = charSequence.charAt(i5);
            if (charAt5 < 128) {
                j3 |= charAt5 << i4;
                i4 += 8;
                i6++;
            } else if (charAt5 < 2048) {
                j3 |= charToTwoUtf8Bytes(charAt5) << i4;
                i4 += 16;
                i6 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j3 |= charToThreeUtf8Bytes(charAt5) << i4;
                i4 += 24;
                i6 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i5);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i5++;
                j3 |= codePointToFourUtf8Bytes(codePointAt) << i4;
                if (this.supplementaryPlaneFix) {
                    i4 += 32;
                }
                i6 += 4;
            }
            if (i4 >= 32) {
                i3 = mixH1(i3, mixK1((int) j3));
                j3 >>>= 32;
                i4 -= 32;
            }
            i5++;
        }
        return fmix(mixK1((int) j3) ^ i3, i6);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i3 = this.seed;
        for (int i4 = 1; i4 < charSequence.length(); i4 += 2) {
            i3 = mixH1(i3, mixK1(charSequence.charAt(i4 - 1) | (charSequence.charAt(i4) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i3 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i3, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }
}
