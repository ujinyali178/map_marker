package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class AllocatedBuffer {
    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: com.google.crypto.tink.shaded.protobuf.AllocatedBuffer.1
            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public byte[] array() {
                return byteBuffer.array();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int limit() {
                return byteBuffer.limit();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int position() {
                return byteBuffer.position();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i3) {
                byteBuffer.position(i3);
                return this;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int remaining() {
                return byteBuffer.remaining();
            }
        };
    }

    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer wrap(byte[] bArr, int i3, int i4) {
        if (i3 < 0 || i4 < 0 || i3 + i4 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        return wrapNoCheck(bArr, i3, i4);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i3, final int i4) {
        return new AllocatedBuffer() { // from class: com.google.crypto.tink.shaded.protobuf.AllocatedBuffer.2
            private int position;

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public byte[] array() {
                return bArr;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return i3;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int limit() {
                return i4;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int position() {
                return this.position;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i5) {
                if (i5 >= 0 && i5 <= i4) {
                    this.position = i5;
                    return this;
                }
                throw new IllegalArgumentException("Invalid position: " + i5);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AllocatedBuffer
            public int remaining() {
                return i4 - this.position;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int i3);

    public abstract int remaining();
}
