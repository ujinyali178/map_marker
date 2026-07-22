package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        BytesHashCode(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            byte[] bArr = this.bytes;
            Preconditions.checkState(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr2[0] & UnsignedBytes.MAX_VALUE) | ((bArr2[1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr2[2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            byte[] bArr = this.bytes;
            Preconditions.checkState(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode hashCode) {
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            int i3 = 0;
            boolean z3 = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i3 >= bArr.length) {
                    return z3;
                }
                z3 &= bArr[i3] == hashCode.getBytesInternal()[i3];
                i3++;
            }
        }

        @Override // com.google.common.hash.HashCode
        byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long j3 = this.bytes[0] & UnsignedBytes.MAX_VALUE;
            for (int i3 = 1; i3 < Math.min(this.bytes.length, 8); i3++) {
                j3 |= (this.bytes[i3] & 255) << (i3 * 8);
            }
            return j3;
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] bArr, int i3, int i4) {
            System.arraycopy(this.bytes, 0, bArr, i3, i4);
        }
    }

    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        IntHashCode(int i3) {
            this.hash = i3;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int i3 = this.hash;
            return new byte[]{(byte) i3, (byte) (i3 >> 8), (byte) (i3 >> 16), (byte) (i3 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asInt();
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] bArr, int i3, int i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) (this.hash >> (i5 * 8));
            }
        }
    }

    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        LongHashCode(long j3) {
            this.hash = j3;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return new byte[]{(byte) this.hash, (byte) (r2 >> 8), (byte) (r2 >> 16), (byte) (r2 >> 24), (byte) (r2 >> 32), (byte) (r2 >> 40), (byte) (r2 >> 48), (byte) (r2 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asLong();
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        void writeBytesToImpl(byte[] bArr, int i3, int i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) (this.hash >> (i5 * 8));
            }
        }
    }

    HashCode() {
    }

    private static int decode(char c3) {
        if (c3 >= '0' && c3 <= '9') {
            return c3 - '0';
        }
        if (c3 >= 'a' && c3 <= 'f') {
            return (c3 - 'a') + 10;
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + c3);
    }

    public static HashCode fromBytes(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 1, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bArr.clone());
    }

    static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromInt(int i3) {
        return new IntHashCode(i3);
    }

    public static HashCode fromLong(long j3) {
        return new LongHashCode(j3);
    }

    public static HashCode fromString(String str) {
        Preconditions.checkArgument(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
        Preconditions.checkArgument(str.length() % 2 == 0, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            bArr[i3 / 2] = (byte) ((decode(str.charAt(i3)) << 4) + decode(str.charAt(i3 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof HashCode)) {
            return false;
        }
        HashCode hashCode = (HashCode) obj;
        return bits() == hashCode.bits() && equalsSameBits(hashCode);
    }

    abstract boolean equalsSameBits(HashCode hashCode);

    byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        int i3 = bytesInternal[0] & UnsignedBytes.MAX_VALUE;
        for (int i4 = 1; i4 < bytesInternal.length; i4++) {
            i3 |= (bytesInternal[i4] & UnsignedBytes.MAX_VALUE) << (i4 * 8);
        }
        return i3;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb = new StringBuilder(bytesInternal.length * 2);
        for (byte b4 : bytesInternal) {
            char[] cArr = hexDigits;
            sb.append(cArr[(b4 >> 4) & 15]);
            sb.append(cArr[b4 & Ascii.SI]);
        }
        return sb.toString();
    }

    public int writeBytesTo(byte[] bArr, int i3, int i4) {
        int min = Ints.min(i4, bits() / 8);
        Preconditions.checkPositionIndexes(i3, i3 + min, bArr.length);
        writeBytesToImpl(bArr, i3, min);
        return min;
    }

    abstract void writeBytesToImpl(byte[] bArr, int i3, int i4);
}
