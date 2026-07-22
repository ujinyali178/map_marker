package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public class AtomicDouble extends Number {
    private static final long serialVersionUID = 0;
    private transient AtomicLong value;

    public AtomicDouble() {
        this(0.0d);
    }

    public AtomicDouble(double d3) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(d3));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.value = new AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    public final double addAndGet(double d3) {
        long j3;
        double longBitsToDouble;
        do {
            j3 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j3) + d3;
        } while (!this.value.compareAndSet(j3, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d3, double d4) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(d3), Double.doubleToRawLongBits(d4));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    public final double getAndAdd(double d3) {
        long j3;
        double longBitsToDouble;
        do {
            j3 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j3);
        } while (!this.value.compareAndSet(j3, Double.doubleToRawLongBits(longBitsToDouble + d3)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d3) {
        return Double.longBitsToDouble(this.value.getAndSet(Double.doubleToRawLongBits(d3)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d3) {
        this.value.lazySet(Double.doubleToRawLongBits(d3));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d3) {
        this.value.set(Double.doubleToRawLongBits(d3));
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d3, double d4) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(d3), Double.doubleToRawLongBits(d4));
    }
}
