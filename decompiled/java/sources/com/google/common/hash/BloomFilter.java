package com.google.common.hash;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(((BloomFilter) bloomFilter).bits.data);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    interface Strategy extends Serializable {
        <T> boolean mightContain(@ParametricNullness T t3, Funnel<? super T> funnel, int i3, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(@ParametricNullness T t3, Funnel<? super T> funnel, int i3, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i3, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(i3 > 0, "numHashFunctions (%s) must be > 0", i3);
        Preconditions.checkArgument(i3 <= 255, "numHashFunctions (%s) must be <= 255", i3);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i3;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i3) {
        return create(funnel, i3);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i3, double d3) {
        return create(funnel, i3, d3);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j3) {
        return create(funnel, j3, 0.03d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j3, double d3) {
        return create(funnel, j3, d3, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j3, double d3, Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(j3 >= 0, "Expected insertions (%s) must be >= 0", j3);
        Preconditions.checkArgument(d3 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d3));
        Preconditions.checkArgument(d3 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d3));
        Preconditions.checkNotNull(strategy);
        if (j3 == 0) {
            j3 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j3, d3);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j3, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e3);
        }
    }

    static long optimalNumOfBits(long j3, double d3) {
        if (d3 == 0.0d) {
            d3 = Double.MIN_VALUE;
        }
        return (long) (((-j3) * Math.log(d3)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    static int optimalNumOfHashFunctions(long j3, long j4) {
        return Math.max(1, (int) Math.round((j4 / j3) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) {
        int i3;
        int i4;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        byte b4 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i4 = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    int readInt = dataInputStream.readInt();
                    try {
                        BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                        BloomFilterStrategies.LockFreeBitArray lockFreeBitArray = new BloomFilterStrategies.LockFreeBitArray(LongMath.checkedMultiply(readInt, 64L));
                        for (int i5 = 0; i5 < readInt; i5++) {
                            lockFreeBitArray.putData(i5, dataInputStream.readLong());
                        }
                        return new BloomFilter<>(lockFreeBitArray, i4, funnel, bloomFilterStrategies);
                    } catch (RuntimeException e3) {
                        e = e3;
                        b4 = readByte;
                        i3 = readInt;
                        throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b4) + " numHashFunctions: " + i4 + " dataLength: " + i3, e);
                    }
                } catch (RuntimeException e4) {
                    e = e4;
                    b4 = readByte;
                    i3 = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b4) + " numHashFunctions: " + i4 + " dataLength: " + i3, e);
                }
            } catch (RuntimeException e5) {
                e = e5;
                i4 = -1;
            }
        } catch (RuntimeException e6) {
            e = e6;
            i3 = -1;
            i4 = -1;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(@ParametricNullness T t3) {
        return mightContain(t3);
    }

    public long approximateElementCount() {
        double bitSize = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.bitCount() / bitSize))) * bitSize) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(@ParametricNullness T t3) {
        return this.strategy.mightContain(t3, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(@ParametricNullness T t3) {
        return this.strategy.put(t3, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i3 = this.numHashFunctions;
        int i4 = bloomFilter.numHashFunctions;
        Preconditions.checkArgument(i3 == i4, "BloomFilters must have the same number of hash functions (%s != %s)", i3, i4);
        Preconditions.checkArgument(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i3 = 0; i3 < this.bits.data.length(); i3++) {
            dataOutputStream.writeLong(this.bits.data.get(i3));
        }
    }
}
