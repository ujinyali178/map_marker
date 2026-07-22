package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong> {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    private UnsignedLong(long j3) {
        this.value = j3;
    }

    public static UnsignedLong fromLongBits(long j3) {
        return new UnsignedLong(j3);
    }

    public static UnsignedLong valueOf(long j3) {
        Preconditions.checkArgument(j3 >= 0, "value (%s) is outside the range for an unsigned long value", j3);
        return fromLongBits(j3);
    }

    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedLong valueOf(String str, int i3) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i3));
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & UNSIGNED_MASK);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j3 = this.value;
        if (j3 >= 0) {
            return j3;
        }
        return ((j3 & 1) | (j3 >>> 1)) * 2.0d;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j3 = this.value;
        if (j3 >= 0) {
            return j3;
        }
        return ((j3 & 1) | (j3 >>> 1)) * 2.0f;
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int i3) {
        return UnsignedLongs.toString(this.value, i3);
    }
}
