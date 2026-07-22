package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class LongAdder extends Striped64 implements LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long j3) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr == null) {
            long j4 = this.base;
            if (casBase(j4, j4 + j3)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z3 = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j5 = cell.value;
            z3 = cell.cas(j5, j5 + j3);
            if (z3) {
                return;
            }
        }
        retryUpdate(j3, iArr, z3);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // com.google.common.hash.Striped64
    final long fn(long j3, long j4) {
        return j3 + j4;
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long j3 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j3 += cell.value;
                }
            }
        }
        return j3;
    }

    public long sumThenReset() {
        long j3 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        this.base = 0L;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j3 += cell.value;
                    cell.value = 0L;
                }
            }
        }
        return j3;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
