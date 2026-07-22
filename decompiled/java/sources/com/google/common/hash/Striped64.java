package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* renamed from: p0, reason: collision with root package name */
        volatile long f2299p0;

        /* renamed from: p1, reason: collision with root package name */
        volatile long f2300p1;

        /* renamed from: p2, reason: collision with root package name */
        volatile long f2301p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;

        /* renamed from: q0, reason: collision with root package name */
        volatile long f2302q0;

        /* renamed from: q1, reason: collision with root package name */
        volatile long f2303q1;

        /* renamed from: q2, reason: collision with root package name */
        volatile long f2304q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e3) {
                throw new Error(e3);
            }
        }

        Cell(long j3) {
            this.value = j3;
        }

        final boolean cas(long j3, long j4) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j3, j4);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e3) {
            throw new Error(e3);
        }
    }

    Striped64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    final boolean casBase(long j3, long j4) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j3, j4);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long j3, long j4);

    final void internalReset(long j3) {
        Cell[] cellArr = this.cells;
        this.base = j3;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j3;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0024 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void retryUpdate(long r17, @javax.annotation.CheckForNull int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Striped64.retryUpdate(long, int[], boolean):void");
    }
}
