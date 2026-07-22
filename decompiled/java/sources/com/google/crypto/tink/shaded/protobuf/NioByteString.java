package com.google.crypto.tink.shaded.protobuf;

import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* loaded from: /root/release/classes.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i3, int i4) {
        if (i3 < this.buffer.position() || i4 > this.buffer.limit() || i3 > i4) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i3 - this.buffer.position());
        slice.limit(i4 - this.buffer.position());
        return slice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte byteAt(int i3) {
        try {
            return this.buffer.get(i3);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw e3;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i3, int i4, int i5) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i3);
        slice.get(bArr, i4, i5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof NioByteString ? this.buffer.equals(((NioByteString) obj).buffer) : obj instanceof RopeByteString ? obj.equals(this) : this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
    boolean equalsRange(ByteString byteString, int i3, int i4) {
        return substring(0, i4).equals(byteString.substring(i3, i4 + i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte internalByteAt(int i3) {
        return byteAt(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public InputStream newInput() {
        return new InputStream() { // from class: com.google.crypto.tink.shaded.protobuf.NioByteString.1
            private final ByteBuffer buf;

            {
                this.buf = NioByteString.this.buffer.slice();
            }

            @Override // java.io.InputStream
            public int available() {
                return this.buf.remaining();
            }

            @Override // java.io.InputStream
            public void mark(int i3) {
                this.buf.mark();
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.buf.hasRemaining()) {
                    return this.buf.get() & UnsignedBytes.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i3, int i4) {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i4, this.buf.remaining());
                this.buf.get(bArr, i3, min);
                return min;
            }

            @Override // java.io.InputStream
            public void reset() {
                try {
                    this.buf.reset();
                } catch (InvalidMarkException e3) {
                    throw new IOException(e3);
                }
            }
        };
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int partialHash(int i3, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + this.buffer.get(i6);
        }
        return i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int partialIsValidUtf8(int i3, int i4, int i5) {
        return Utf8.partialIsValidUtf8(i3, this.buffer, i4, i5 + i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString substring(int i3, int i4) {
        try {
            return new NioByteString(slice(i3, i4));
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw e3;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        byte[] byteArray;
        int i3;
        int length;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            i3 = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            i3 = 0;
            length = byteArray.length;
        }
        return new String(byteArray, i3, length, charset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeTo(ByteOutput byteOutput) {
        byteOutput.writeLazy(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(OutputStream outputStream) {
        outputStream.write(toByteArray());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i3, int i4) {
        if (!this.buffer.hasArray()) {
            ByteBufferWriter.write(slice(i3, i4 + i3), outputStream);
        } else {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i3, i4);
        }
    }
}
