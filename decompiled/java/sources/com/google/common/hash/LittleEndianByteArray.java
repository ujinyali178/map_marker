package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
final class LittleEndianByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray;

    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i3) {
                return Longs.fromBytes(bArr[i3 + 7], bArr[i3 + 6], bArr[i3 + 5], bArr[i3 + 4], bArr[i3 + 3], bArr[i3 + 2], bArr[i3 + 1], bArr[i3]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i3, long j3) {
                long j4 = 255;
                for (int i4 = 0; i4 < 8; i4++) {
                    bArr[i3 + i4] = (byte) ((j3 & j4) >> (i4 * 8));
                    j4 <<= 8;
                }
            }
        }
    }

    private interface LittleEndianBytes {
        long getLongLittleEndian(byte[] bArr, int i3);

        void putLongLittleEndian(byte[] bArr, int i3, long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i3) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, i3 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i3, long j3) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i3 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j3);
            }
        },
        UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i3) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, i3 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i3, long j3) {
                UnsafeByteArray.theUnsafe.putLong(bArr, i3 + UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j3));
            }
        };

        private static final int BYTE_ARRAY_BASE_OFFSET;
        private static final Unsafe theUnsafe;

        static {
            Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            if (unsafe.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        private static Unsafe getUnsafe() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e3) {
                    throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.common.hash.b
                    @Override // java.security.PrivilegedExceptionAction
                    public final Object run() {
                        Unsafe lambda$getUnsafe$0;
                        lambda$getUnsafe$0 = LittleEndianByteArray.UnsafeByteArray.lambda$getUnsafe$0();
                        return lambda$getUnsafe$0;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unsafe lambda$getUnsafe$0() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        byteArray = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }

    static int load32(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    static long load64(byte[] bArr, int i3) {
        return byteArray.getLongLittleEndian(bArr, i3);
    }

    static long load64Safely(byte[] bArr, int i3, int i4) {
        long j3 = 0;
        for (int i5 = 0; i5 < Math.min(i4, 8); i5++) {
            j3 |= (bArr[i3 + i5] & 255) << (i5 * 8);
        }
        return j3;
    }

    static void store64(byte[] bArr, int i3, long j3) {
        byteArray.putLongLittleEndian(bArr, i3, j3);
    }

    static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }
}
