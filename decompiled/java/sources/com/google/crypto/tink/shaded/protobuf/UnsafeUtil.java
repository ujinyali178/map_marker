package com.google.crypto.tink.shaded.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /root/release/classes.dex */
final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET;
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j3) {
            return (int) (j3 & (-1));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j3, byte[] bArr, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j3, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j3) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, j3) : UnsafeUtil.getBooleanLittleEndian(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j3) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(obj, j3) : UnsafeUtil.getByteLittleEndian(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j3) {
            return Double.longBitsToDouble(getLong(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j3) {
            return Float.intBitsToFloat(getInt(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j3, boolean z3) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j3, z3);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j3, z3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j3, byte b4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j3, byte b4) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j3, b4);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j3, b4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j3, double d3) {
            putLong(obj, j3, Double.doubleToLongBits(d3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j3, float f3) {
            putInt(obj, j3, Float.floatToIntBits(f3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j3, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j3, byte[] bArr, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j3, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j3) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, j3) : UnsafeUtil.getBooleanLittleEndian(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j3) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(obj, j3) : UnsafeUtil.getByteLittleEndian(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j3) {
            return Double.longBitsToDouble(getLong(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j3) {
            return Float.intBitsToFloat(getInt(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j3, boolean z3) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j3, z3);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j3, z3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j3, byte b4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j3, byte b4) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j3, b4);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j3, b4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j3, double d3) {
            putLong(obj, j3, Double.doubleToLongBits(d3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j3, float f3) {
            putInt(obj, j3, Float.floatToIntBits(f3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j3, int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long j3, byte[] bArr, long j4, long j5) {
            this.unsafe.copyMemory((Object) null, j3, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j4, j5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] bArr, long j3, long j4, long j5) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j3, (Object) null, j4, j5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j3) {
            return this.unsafe.getBoolean(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long j3) {
            return this.unsafe.getByte(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object obj, long j3) {
            return this.unsafe.getByte(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j3) {
            return this.unsafe.getDouble(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j3) {
            return this.unsafe.getFloat(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long j3) {
            return this.unsafe.getInt(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long j3) {
            return this.unsafe.getLong(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j3, boolean z3) {
            this.unsafe.putBoolean(obj, j3, z3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long j3, byte b4) {
            this.unsafe.putByte(j3, b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j3, byte b4) {
            this.unsafe.putByte(obj, j3, b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j3, double d3) {
            this.unsafe.putDouble(obj, j3, d3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j3, float f3) {
            this.unsafe.putFloat(obj, j3, f3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long j3, int i3) {
            this.unsafe.putInt(j3, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long j3, long j4) {
            this.unsafe.putLong(j3, j4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j3, byte[] bArr, long j4, long j5);

        public abstract void copyMemory(byte[] bArr, long j3, long j4, long j5);

        public abstract boolean getBoolean(Object obj, long j3);

        public abstract byte getByte(long j3);

        public abstract byte getByte(Object obj, long j3);

        public abstract double getDouble(Object obj, long j3);

        public abstract float getFloat(Object obj, long j3);

        public abstract int getInt(long j3);

        public final int getInt(Object obj, long j3) {
            return this.unsafe.getInt(obj, j3);
        }

        public abstract long getLong(long j3);

        public final long getLong(Object obj, long j3) {
            return this.unsafe.getLong(obj, j3);
        }

        public final Object getObject(Object obj, long j3) {
            return this.unsafe.getObject(obj, j3);
        }

        public abstract Object getStaticObject(java.lang.reflect.Field field);

        public final long objectFieldOffset(java.lang.reflect.Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j3, boolean z3);

        public abstract void putByte(long j3, byte b4);

        public abstract void putByte(Object obj, long j3, byte b4);

        public abstract void putDouble(Object obj, long j3, double d3);

        public abstract void putFloat(Object obj, long j3, float f3);

        public abstract void putInt(long j3, int i3);

        public final void putInt(Object obj, long j3, int i3) {
            this.unsafe.putInt(obj, j3, i3);
        }

        public abstract void putLong(long j3, long j4);

        public final void putLong(Object obj, long j3, long j4) {
            this.unsafe.putLong(obj, j3, j4);
        }

        public final void putObject(Object obj, long j3, Object obj2) {
            this.unsafe.putObject(obj, j3, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe unsafe = this.unsafe;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe = this.unsafe;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return UnsafeUtil.bufferAddressField() != null;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    static {
        long arrayBaseOffset = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (7 & arrayBaseOffset);
        IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private UnsafeUtil() {
    }

    static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Field bufferAddressField() {
        java.lang.reflect.Field field;
        if (Android.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        java.lang.reflect.Field field2 = field(Buffer.class, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    static void copyMemory(long j3, byte[] bArr, long j4, long j5) {
        MEMORY_ACCESSOR.copyMemory(j3, bArr, j4, j5);
    }

    static void copyMemory(byte[] bArr, long j3, long j4, long j5) {
        MEMORY_ACCESSOR.copyMemory(bArr, j3, j4, j5);
    }

    static void copyMemory(byte[] bArr, long j3, byte[] bArr2, long j4, long j5) {
        System.arraycopy(bArr, (int) j3, bArr2, (int) j4, (int) j5);
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls2 = MEMORY_CLASS;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static java.lang.reflect.Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(java.lang.reflect.Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1L;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j3, long j4) {
        long j5 = j3 ^ j4;
        return (IS_BIG_ENDIAN ? Long.numberOfLeadingZeros(j5) : Long.numberOfTrailingZeros(j5)) >> 3;
    }

    static boolean getBoolean(Object obj, long j3) {
        return MEMORY_ACCESSOR.getBoolean(obj, j3);
    }

    static boolean getBoolean(boolean[] zArr, long j3) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j3 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j3) {
        return getByteBigEndian(obj, j3) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j3) {
        return getByteLittleEndian(obj, j3) != 0;
    }

    static byte getByte(long j3) {
        return MEMORY_ACCESSOR.getByte(j3);
    }

    static byte getByte(Object obj, long j3) {
        return MEMORY_ACCESSOR.getByte(obj, j3);
    }

    static byte getByte(byte[] bArr, long j3) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j3) {
        return (byte) ((getInt(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j3) {
        return (byte) ((getInt(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255);
    }

    static double getDouble(Object obj, long j3) {
        return MEMORY_ACCESSOR.getDouble(obj, j3);
    }

    static double getDouble(double[] dArr, long j3) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j3 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static float getFloat(Object obj, long j3) {
        return MEMORY_ACCESSOR.getFloat(obj, j3);
    }

    static float getFloat(float[] fArr, long j3) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j3 * FLOAT_ARRAY_INDEX_SCALE));
    }

    static int getInt(long j3) {
        return MEMORY_ACCESSOR.getInt(j3);
    }

    static int getInt(Object obj, long j3) {
        return MEMORY_ACCESSOR.getInt(obj, j3);
    }

    static int getInt(int[] iArr, long j3) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j3 * INT_ARRAY_INDEX_SCALE));
    }

    static long getLong(long j3) {
        return MEMORY_ACCESSOR.getLong(j3);
    }

    static long getLong(Object obj, long j3) {
        return MEMORY_ACCESSOR.getLong(obj, j3);
    }

    static long getLong(long[] jArr, long j3) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j3 * LONG_ARRAY_INDEX_SCALE));
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    static Object getObject(Object obj, long j3) {
        return MEMORY_ACCESSOR.getObject(obj, j3);
    }

    static Object getObject(Object[] objArr, long j3) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j3 * OBJECT_ARRAY_INDEX_SCALE));
    }

    static Object getStaticObject(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.crypto.tink.shaded.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() {
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logMissingMethod(Throwable th) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static int mismatch(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        if (i3 < 0 || i4 < 0 || i5 < 0 || i3 + i5 > bArr.length || i4 + i5 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i6 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            for (int i7 = (BYTE_ARRAY_ALIGNMENT + i3) & 7; i6 < i5 && (i7 & 7) != 0; i7++) {
                if (bArr[i3 + i6] != bArr2[i4 + i6]) {
                    return i6;
                }
                i6++;
            }
            int i8 = ((i5 - i6) & (-8)) + i6;
            while (i6 < i8) {
                long j3 = BYTE_ARRAY_BASE_OFFSET;
                long j4 = i6;
                long j5 = getLong((Object) bArr, i3 + j3 + j4);
                long j6 = getLong((Object) bArr2, j3 + i4 + j4);
                if (j5 != j6) {
                    return i6 + firstDifferingByteIndexNativeEndian(j5, j6);
                }
                i6 += 8;
            }
        }
        while (i6 < i5) {
            if (bArr[i3 + i6] != bArr2[i4 + i6]) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    static long objectFieldOffset(java.lang.reflect.Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    static void putBoolean(Object obj, long j3, boolean z3) {
        MEMORY_ACCESSOR.putBoolean(obj, j3, z3);
    }

    static void putBoolean(boolean[] zArr, long j3, boolean z3) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j3 * BOOLEAN_ARRAY_INDEX_SCALE), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j3, boolean z3) {
        putByteBigEndian(obj, j3, z3 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j3, boolean z3) {
        putByteLittleEndian(obj, j3, z3 ? (byte) 1 : (byte) 0);
    }

    static void putByte(long j3, byte b4) {
        MEMORY_ACCESSOR.putByte(j3, b4);
    }

    static void putByte(Object obj, long j3, byte b4) {
        MEMORY_ACCESSOR.putByte(obj, j3, b4);
    }

    static void putByte(byte[] bArr, long j3, byte b4) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j3, b4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j3, byte b4) {
        long j4 = (-4) & j3;
        int i3 = getInt(obj, j4);
        int i4 = ((~((int) j3)) & 3) << 3;
        putInt(obj, j4, ((255 & b4) << i4) | (i3 & (~(255 << i4))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j3, byte b4) {
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        putInt(obj, j4, ((255 & b4) << i3) | (getInt(obj, j4) & (~(255 << i3))));
    }

    static void putDouble(Object obj, long j3, double d3) {
        MEMORY_ACCESSOR.putDouble(obj, j3, d3);
    }

    static void putDouble(double[] dArr, long j3, double d3) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j3 * DOUBLE_ARRAY_INDEX_SCALE), d3);
    }

    static void putFloat(Object obj, long j3, float f3) {
        MEMORY_ACCESSOR.putFloat(obj, j3, f3);
    }

    static void putFloat(float[] fArr, long j3, float f3) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j3 * FLOAT_ARRAY_INDEX_SCALE), f3);
    }

    static void putInt(long j3, int i3) {
        MEMORY_ACCESSOR.putInt(j3, i3);
    }

    static void putInt(Object obj, long j3, int i3) {
        MEMORY_ACCESSOR.putInt(obj, j3, i3);
    }

    static void putInt(int[] iArr, long j3, int i3) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j3 * INT_ARRAY_INDEX_SCALE), i3);
    }

    static void putLong(long j3, long j4) {
        MEMORY_ACCESSOR.putLong(j3, j4);
    }

    static void putLong(Object obj, long j3, long j4) {
        MEMORY_ACCESSOR.putLong(obj, j3, j4);
    }

    static void putLong(long[] jArr, long j3, long j4) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (j3 * LONG_ARRAY_INDEX_SCALE), j4);
    }

    static void putObject(Object obj, long j3, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j3, obj2);
    }

    static void putObject(Object[] objArr, long j3, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j3 * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }
}
