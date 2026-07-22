package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i3) {
        this.longs = new AtomicLongArray(i3);
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i3 = 0; i3 < length; i3++) {
            jArr[i3] = Double.doubleToRawLongBits(dArr[i3]);
        }
        this.longs = new AtomicLongArray(jArr);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i3 = 0; i3 < readInt; i3++) {
            builder.add(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i3 = 0; i3 < length; i3++) {
            objectOutputStream.writeDouble(get(i3));
        }
    }

    public double addAndGet(int i3, double d3) {
        long j3;
        double longBitsToDouble;
        do {
            j3 = this.longs.get(i3);
            longBitsToDouble = Double.longBitsToDouble(j3) + d3;
        } while (!this.longs.compareAndSet(i3, j3, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i3, double d3, double d4) {
        return this.longs.compareAndSet(i3, Double.doubleToRawLongBits(d3), Double.doubleToRawLongBits(d4));
    }

    public final double get(int i3) {
        return Double.longBitsToDouble(this.longs.get(i3));
    }

    public final double getAndAdd(int i3, double d3) {
        long j3;
        double longBitsToDouble;
        do {
            j3 = this.longs.get(i3);
            longBitsToDouble = Double.longBitsToDouble(j3);
        } while (!this.longs.compareAndSet(i3, j3, Double.doubleToRawLongBits(longBitsToDouble + d3)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i3, double d3) {
        return Double.longBitsToDouble(this.longs.getAndSet(i3, Double.doubleToRawLongBits(d3)));
    }

    public final void lazySet(int i3, double d3) {
        this.longs.lazySet(i3, Double.doubleToRawLongBits(d3));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i3, double d3) {
        this.longs.set(i3, Double.doubleToRawLongBits(d3));
    }

    public String toString() {
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder((length + 1) * 19);
        sb.append('[');
        int i3 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i3)));
            if (i3 == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i3++;
        }
    }

    public final boolean weakCompareAndSet(int i3, double d3, double d4) {
        return this.longs.weakCompareAndSet(i3, Double.doubleToRawLongBits(d3), Double.doubleToRawLongBits(d4));
    }
}
