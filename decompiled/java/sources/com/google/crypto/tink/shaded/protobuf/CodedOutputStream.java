package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /root/release/classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int i3) {
            super();
            if (i3 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i3, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        final void buffer(byte b4) {
            byte[] bArr = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = b4;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.position;
            int i5 = i4 + 1;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.position = i7 + 1;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.position;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (j3 & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((j3 >> 8) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j3 >> 16) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (255 & (j3 >> 24));
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.position = i10 + 1;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        final void bufferInt32NoTag(int i3) {
            if (i3 >= 0) {
                bufferUInt32NoTag(i3);
            } else {
                bufferUInt64NoTag(i3);
            }
        }

        final void bufferTag(int i3, int i4) {
            bufferUInt32NoTag(WireFormat.makeTag(i3, i4));
        }

        final void bufferUInt32NoTag(int i3) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((i3 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr[i4] = (byte) ((i3 & 127) | 128);
                    this.totalBytesWritten++;
                    i3 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr2[i5] = (byte) i3;
                this.totalBytesWritten++;
                return;
            }
            long j3 = this.position;
            while ((i3 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                UnsafeUtil.putByte(bArr3, i6, (byte) ((i3 & 127) | 128));
                i3 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i7 = this.position;
            this.position = i7 + 1;
            UnsafeUtil.putByte(bArr4, i7, (byte) i3);
            this.totalBytesWritten += (int) (this.position - j3);
        }

        final void bufferUInt64NoTag(long j3) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) & 127) | 128);
                    this.totalBytesWritten++;
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr2[i4] = (byte) j3;
                this.totalBytesWritten++;
                return;
            }
            long j4 = this.position;
            while ((j3 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                UnsafeUtil.putByte(bArr3, i5, (byte) ((((int) j3) & 127) | 128));
                j3 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i6 = this.position;
            this.position = i6 + 1;
            UnsafeUtil.putByte(bArr4, i6, (byte) j3);
            this.totalBytesWritten += (int) (this.position - j4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        ArrayEncoder(byte[] bArr, int i3, int i4) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i5 = i3 + i4;
            if ((i3 | i4 | (bArr.length - i5)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            this.buffer = bArr;
            this.offset = i3;
            this.position = i3;
            this.limit = i5;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(byte b4) {
            try {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr[i3] = b4;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(byte[] bArr, int i3, int i4) {
            try {
                System.arraycopy(bArr, i3, this.buffer, this.position, i4);
                this.position += i4;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i4)), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBool(int i3, boolean z3) {
            writeTag(i3, 0);
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArray(int i3, byte[] bArr) {
            writeByteArray(i3, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArray(int i3, byte[] bArr, int i4, int i5) {
            writeTag(i3, 2);
            writeByteArrayNoTag(bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i3, int i4) {
            writeUInt32NoTag(i4);
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i3, ByteBuffer byteBuffer) {
            writeTag(i3, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytes(int i3, ByteString byteString) {
            writeTag(i3, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32(int i3, int i4) {
            writeTag(i3, 5);
            writeFixed32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i3) {
            try {
                byte[] bArr = this.buffer;
                int i4 = this.position;
                int i5 = i4 + 1;
                bArr[i4] = (byte) (i3 & 255);
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((i3 >> 8) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((i3 >> 16) & 255);
                this.position = i7 + 1;
                bArr[i7] = (byte) ((i3 >> 24) & 255);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64(int i3, long j3) {
            writeTag(i3, 1);
            writeFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j3) {
            try {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                int i4 = i3 + 1;
                bArr[i3] = (byte) (((int) j3) & 255);
                int i5 = i4 + 1;
                bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
                this.position = i10 + 1;
                bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32(int i3, int i4) {
            writeTag(i3, 0);
            writeInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i3) {
            if (i3 >= 0) {
                writeUInt32NoTag(i3);
            } else {
                writeUInt64NoTag(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i3, int i4) {
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessage(int i3, MessageLite messageLite) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void writeMessage(int i3, MessageLite messageLite, Schema schema) {
            writeTag(i3, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i3, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i3, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeString(int i3, String str) {
            writeTag(i3, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) {
            int encode;
            int i3 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i4 = i3 + computeUInt32SizeNoTag2;
                    this.position = i4;
                    encode = Utf8.encode(str, this.buffer, i4, spaceLeft());
                    this.position = i3;
                    writeUInt32NoTag((encode - i3) - computeUInt32SizeNoTag2);
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                }
                this.position = encode;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.position = i3;
                inefficientWriteStringNoTag(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeTag(int i3, int i4) {
            writeUInt32NoTag(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32(int i3, int i4) {
            writeTag(i3, 0);
            writeUInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i3) {
            while ((i3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr[i4] = (byte) ((i3 & 127) | 128);
                    i3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e3);
                }
            }
            byte[] bArr2 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr2[i5] = (byte) i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64(int i3, long j3) {
            writeTag(i3, 0);
            writeUInt64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j3) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    UnsafeUtil.putByte(bArr, i3, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                UnsafeUtil.putByte(bArr2, i4, (byte) j3);
                return;
            }
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    bArr3[i5] = (byte) ((((int) j3) & 127) | 128);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e3);
                }
            }
            byte[] bArr4 = this.buffer;
            int i6 = this.position;
            this.position = i6 + 1;
            bArr4[i6] = (byte) j3;
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput byteOutput, int i3) {
            super(i3);
            if (byteOutput == null) {
                throw new NullPointerException("out");
            }
            this.out = byteOutput;
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i3) {
            if (this.limit - this.position < i3) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            flush();
            this.out.write(bArr, i3, i4);
            this.totalBytesWritten += i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i3, boolean z3) {
            flushIfNotAvailable(11);
            bufferTag(i3, 0);
            buffer(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr) {
            writeByteArray(i3, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr, int i4, int i5) {
            writeTag(i3, 2);
            writeByteArrayNoTag(bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i3, int i4) {
            writeUInt32NoTag(i4);
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i3, ByteBuffer byteBuffer) {
            writeTag(i3, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i3, ByteString byteString) {
            writeTag(i3, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i3, int i4) {
            flushIfNotAvailable(14);
            bufferTag(i3, 5);
            bufferFixed32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i3) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i3, long j3) {
            flushIfNotAvailable(18);
            bufferTag(i3, 1);
            bufferFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j3) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i3, int i4) {
            flushIfNotAvailable(20);
            bufferTag(i3, 0);
            bufferInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i3) {
            if (i3 >= 0) {
                writeUInt32NoTag(i3);
            } else {
                writeUInt64NoTag(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            flush();
            this.out.writeLazy(bArr, i3, i4);
            this.totalBytesWritten += i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i3, MessageLite messageLite) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(int i3, MessageLite messageLite, Schema schema) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i3, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i3, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i3, String str) {
            writeTag(i3, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i3 = computeUInt32SizeNoTag + length;
            int i4 = this.limit;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int encode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(encode);
                writeLazy(bArr, 0, encode);
                return;
            }
            if (i3 > i4 - this.position) {
                doFlush();
            }
            int i5 = this.position;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i6 = i5 + computeUInt32SizeNoTag2;
                    this.position = i6;
                    int encode2 = Utf8.encode(str, this.buffer, i6, this.limit - i6);
                    this.position = i5;
                    int i7 = (encode2 - i5) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i7);
                    this.position = encode2;
                    this.totalBytesWritten += i7;
                } else {
                    int encodedLength = Utf8.encodedLength(str);
                    bufferUInt32NoTag(encodedLength);
                    this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    this.totalBytesWritten += encodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.totalBytesWritten -= this.position - i5;
                this.position = i5;
                inefficientWriteStringNoTag(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i3, int i4) {
            writeUInt32NoTag(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i3, int i4) {
            flushIfNotAvailable(20);
            bufferTag(i3, 0);
            bufferUInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i3) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i3, long j3) {
            flushIfNotAvailable(20);
            bufferTag(i3, 0);
            bufferUInt64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j3) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j3);
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream.ArrayEncoder, com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream outputStream, int i3) {
            super(i3);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i3) {
            if (this.limit - this.position < i3) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i3 = this.limit;
            int i4 = this.position;
            if (i3 - i4 >= remaining) {
                byteBuffer.get(this.buffer, i4, remaining);
                this.position += remaining;
            } else {
                int i5 = i3 - i4;
                byteBuffer.get(this.buffer, i4, i5);
                remaining -= i5;
                this.position = this.limit;
                this.totalBytesWritten += i5;
                doFlush();
                while (true) {
                    int i6 = this.limit;
                    if (remaining <= i6) {
                        break;
                    }
                    byteBuffer.get(this.buffer, 0, i6);
                    this.out.write(this.buffer, 0, this.limit);
                    int i7 = this.limit;
                    remaining -= i7;
                    this.totalBytesWritten += i7;
                }
                byteBuffer.get(this.buffer, 0, remaining);
                this.position = remaining;
            }
            this.totalBytesWritten += remaining;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            int i5 = this.limit;
            int i6 = this.position;
            if (i5 - i6 >= i4) {
                System.arraycopy(bArr, i3, this.buffer, i6, i4);
                this.position += i4;
            } else {
                int i7 = i5 - i6;
                System.arraycopy(bArr, i3, this.buffer, i6, i7);
                int i8 = i3 + i7;
                i4 -= i7;
                this.position = this.limit;
                this.totalBytesWritten += i7;
                doFlush();
                if (i4 <= this.limit) {
                    System.arraycopy(bArr, i8, this.buffer, 0, i4);
                    this.position = i4;
                } else {
                    this.out.write(bArr, i8, i4);
                }
            }
            this.totalBytesWritten += i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i3, boolean z3) {
            flushIfNotAvailable(11);
            bufferTag(i3, 0);
            buffer(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr) {
            writeByteArray(i3, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr, int i4, int i5) {
            writeTag(i3, 2);
            writeByteArrayNoTag(bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i3, int i4) {
            writeUInt32NoTag(i4);
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i3, ByteBuffer byteBuffer) {
            writeTag(i3, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i3, ByteString byteString) {
            writeTag(i3, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i3, int i4) {
            flushIfNotAvailable(14);
            bufferTag(i3, 5);
            bufferFixed32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i3) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i3, long j3) {
            flushIfNotAvailable(18);
            bufferTag(i3, 1);
            bufferFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j3) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i3, int i4) {
            flushIfNotAvailable(20);
            bufferTag(i3, 0);
            bufferInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i3) {
            if (i3 >= 0) {
                writeUInt32NoTag(i3);
            } else {
                writeUInt64NoTag(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i3, MessageLite messageLite) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(int i3, MessageLite messageLite, Schema schema) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i3, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i3, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i3, String str) {
            writeTag(i3, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int encodedLength;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i3 = computeUInt32SizeNoTag + length;
                int i4 = this.limit;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i3 > i4 - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i5 = this.position;
                try {
                    if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                        int i6 = i5 + computeUInt32SizeNoTag2;
                        this.position = i6;
                        int encode2 = Utf8.encode(str, this.buffer, i6, this.limit - i6);
                        this.position = i5;
                        encodedLength = (encode2 - i5) - computeUInt32SizeNoTag2;
                        bufferUInt32NoTag(encodedLength);
                        this.position = encode2;
                    } else {
                        encodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(encodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    }
                    this.totalBytesWritten += encodedLength;
                } catch (Utf8.UnpairedSurrogateException e3) {
                    this.totalBytesWritten -= this.position - i5;
                    this.position = i5;
                    throw e3;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(e4);
                }
            } catch (Utf8.UnpairedSurrogateException e5) {
                inefficientWriteStringNoTag(str, e5);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i3, int i4) {
            writeUInt32NoTag(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i3, int i4) {
            flushIfNotAvailable(20);
            bufferTag(i3, 0);
            bufferUInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i3) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i3, long j3) {
            flushIfNotAvailable(20);
            bufferTag(i3, 0);
            bufferUInt64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j3) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j3);
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            try {
                this.buffer.put(b4);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            try {
                this.buffer.put(bArr, i3, i4);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i3, boolean z3) {
            writeTag(i3, 0);
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr) {
            writeByteArray(i3, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr, int i4, int i5) {
            writeTag(i3, 2);
            writeByteArrayNoTag(bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i3, int i4) {
            writeUInt32NoTag(i4);
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i3, ByteBuffer byteBuffer) {
            writeTag(i3, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i3, ByteString byteString) {
            writeTag(i3, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i3, int i4) {
            writeTag(i3, 5);
            writeFixed32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i3) {
            try {
                this.buffer.putInt(i3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i3, long j3) {
            writeTag(i3, 1);
            writeFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j3) {
            try {
                this.buffer.putLong(j3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i3, int i4) {
            writeTag(i3, 0);
            writeInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i3) {
            if (i3 >= 0) {
                writeUInt32NoTag(i3);
            } else {
                writeUInt64NoTag(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i3, MessageLite messageLite) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(int i3, MessageLite messageLite, Schema schema) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i3, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i3, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i3, String str) {
            writeTag(i3, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                    this.buffer.position(position2);
                    encode(str);
                    int position3 = this.buffer.position();
                    this.buffer.position(position);
                    writeUInt32NoTag(position3 - position2);
                    this.buffer.position(position3);
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    encode(str);
                }
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.buffer.position(position);
                inefficientWriteStringNoTag(str, e3);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i3, int i4) {
            writeUInt32NoTag(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i3, int i4) {
            writeTag(i3, 0);
            writeUInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i3) {
            while ((i3 & (-128)) != 0) {
                try {
                    this.buffer.put((byte) ((i3 & 127) | 128));
                    i3 >>>= 7;
                } catch (BufferOverflowException e3) {
                    throw new OutOfSpaceException(e3);
                }
            }
            this.buffer.put((byte) i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i3, long j3) {
            writeTag(i3, 0);
            writeUInt64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j3) {
            while (((-128) & j3) != 0) {
                try {
                    this.buffer.put((byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                } catch (BufferOverflowException e3) {
                    throw new OutOfSpaceException(e3);
                }
            }
            this.buffer.put((byte) j3);
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            long position = byteBuffer.position() + addressOffset;
            this.initialPosition = position;
            long limit = addressOffset + byteBuffer.limit();
            this.limit = limit;
            this.oneVarintLimit = limit - 10;
            this.position = position;
        }

        private int bufferPos(long j3) {
            return (int) (j3 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j3) {
            this.buffer.position(bufferPos(j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            long j3 = this.position;
            if (j3 >= this.limit) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
            }
            this.position = 1 + j3;
            UnsafeUtil.putByte(j3, b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += remaining;
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            if (bArr != null && i3 >= 0 && i4 >= 0 && bArr.length - i4 >= i3) {
                long j3 = i4;
                long j4 = this.limit - j3;
                long j5 = this.position;
                if (j4 >= j5) {
                    UnsafeUtil.copyMemory(bArr, i3, j5, j3);
                    this.position += j3;
                    return;
                }
            }
            if (bArr != null) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i4)));
            }
            throw new NullPointerException("value");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int i3, boolean z3) {
            writeTag(i3, 0);
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr) {
            writeByteArray(i3, bArr, 0, bArr.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i3, byte[] bArr, int i4, int i5) {
            writeTag(i3, 2);
            writeByteArrayNoTag(bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i3, int i4) {
            writeUInt32NoTag(i4);
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i3, ByteBuffer byteBuffer) {
            writeTag(i3, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int i3, ByteString byteString) {
            writeTag(i3, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i3, int i4) {
            writeTag(i3, 5);
            writeFixed32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i3) {
            this.buffer.putInt(bufferPos(this.position), i3);
            this.position += 4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i3, long j3) {
            writeTag(i3, 1);
            writeFixed64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j3) {
            this.buffer.putLong(bufferPos(this.position), j3);
            this.position += 8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int i3, int i4) {
            writeTag(i3, 0);
            writeInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i3) {
            if (i3 >= 0) {
                writeUInt32NoTag(i3);
            } else {
                writeUInt64NoTag(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            write(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            write(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int i3, MessageLite messageLite) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(int i3, MessageLite messageLite, Schema schema) {
            writeTag(i3, 2);
            writeMessageNoTag(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i3, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i3, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i3);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int i3, String str) {
            writeTag(i3, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            long j3 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                    this.buffer.position(bufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int position = this.buffer.position() - bufferPos;
                    writeUInt32NoTag(position);
                    this.position += position;
                } else {
                    int encodedLength = Utf8.encodedLength(str);
                    writeUInt32NoTag(encodedLength);
                    repositionBuffer(this.position);
                    Utf8.encodeUtf8(str, this.buffer);
                    this.position += encodedLength;
                }
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.position = j3;
                repositionBuffer(j3);
                inefficientWriteStringNoTag(str, e3);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int i3, int i4) {
            writeUInt32NoTag(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i3, int i4) {
            writeTag(i3, 0);
            writeUInt32NoTag(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i3) {
            long j3;
            if (this.position <= this.oneVarintLimit) {
                while ((i3 & (-128)) != 0) {
                    long j4 = this.position;
                    this.position = j4 + 1;
                    UnsafeUtil.putByte(j4, (byte) ((i3 & 127) | 128));
                    i3 >>>= 7;
                }
                j3 = this.position;
            } else {
                while (true) {
                    j3 = this.position;
                    if (j3 >= this.limit) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                    }
                    if ((i3 & (-128)) == 0) {
                        break;
                    }
                    this.position = j3 + 1;
                    UnsafeUtil.putByte(j3, (byte) ((i3 & 127) | 128));
                    i3 >>>= 7;
                }
            }
            this.position = 1 + j3;
            UnsafeUtil.putByte(j3, (byte) i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i3, long j3) {
            writeTag(i3, 0);
            writeUInt64NoTag(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j3) {
            long j4;
            if (this.position <= this.oneVarintLimit) {
                while (true) {
                    long j5 = j3 & (-128);
                    j4 = this.position;
                    if (j5 == 0) {
                        break;
                    }
                    this.position = j4 + 1;
                    UnsafeUtil.putByte(j4, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                }
            } else {
                while (true) {
                    j4 = this.position;
                    if (j4 >= this.limit) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                    }
                    if ((j3 & (-128)) == 0) {
                        break;
                    }
                    this.position = j4 + 1;
                    UnsafeUtil.putByte(j4, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                }
            }
            this.position = 1 + j4;
            UnsafeUtil.putByte(j4, (byte) j3);
        }
    }

    private CodedOutputStream() {
    }

    public static int computeBoolSize(int i3, boolean z3) {
        return computeTagSize(i3) + computeBoolSizeNoTag(z3);
    }

    public static int computeBoolSizeNoTag(boolean z3) {
        return 1;
    }

    public static int computeByteArraySize(int i3, byte[] bArr) {
        return computeTagSize(i3) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i3, ByteBuffer byteBuffer) {
        return computeTagSize(i3) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i3, ByteString byteString) {
        return computeTagSize(i3) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i3, double d3) {
        return computeTagSize(i3) + computeDoubleSizeNoTag(d3);
    }

    public static int computeDoubleSizeNoTag(double d3) {
        return 8;
    }

    public static int computeEnumSize(int i3, int i4) {
        return computeTagSize(i3) + computeEnumSizeNoTag(i4);
    }

    public static int computeEnumSizeNoTag(int i3) {
        return computeInt32SizeNoTag(i3);
    }

    public static int computeFixed32Size(int i3, int i4) {
        return computeTagSize(i3) + computeFixed32SizeNoTag(i4);
    }

    public static int computeFixed32SizeNoTag(int i3) {
        return 4;
    }

    public static int computeFixed64Size(int i3, long j3) {
        return computeTagSize(i3) + computeFixed64SizeNoTag(j3);
    }

    public static int computeFixed64SizeNoTag(long j3) {
        return 8;
    }

    public static int computeFloatSize(int i3, float f3) {
        return computeTagSize(i3) + computeFloatSizeNoTag(f3);
    }

    public static int computeFloatSizeNoTag(float f3) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i3, MessageLite messageLite) {
        return (computeTagSize(i3) * 2) + messageLite.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSize(int i3, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i3) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int computeInt32Size(int i3, int i4) {
        return computeTagSize(i3) + computeInt32SizeNoTag(i4);
    }

    public static int computeInt32SizeNoTag(int i3) {
        if (i3 >= 0) {
            return computeUInt32SizeNoTag(i3);
        }
        return 10;
    }

    public static int computeInt64Size(int i3, long j3) {
        return computeTagSize(i3) + computeInt64SizeNoTag(j3);
    }

    public static int computeInt64SizeNoTag(long j3) {
        return computeUInt64SizeNoTag(j3);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i3, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i3) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i3, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i3) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    static int computeLengthDelimitedFieldSize(int i3) {
        return computeUInt32SizeNoTag(i3) + i3;
    }

    public static int computeMessageSetExtensionSize(int i3, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i3) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i3, MessageLite messageLite) {
        return computeTagSize(i3) + computeMessageSizeNoTag(messageLite);
    }

    static int computeMessageSize(int i3, MessageLite messageLite, Schema schema) {
        return computeTagSize(i3) + computeMessageSizeNoTag(messageLite, schema);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    static int computePreferredBufferSize(int i3) {
        if (i3 > 4096) {
            return 4096;
        }
        return i3;
    }

    public static int computeRawMessageSetExtensionSize(int i3, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i3) + computeBytesSize(3, byteString);
    }

    @Deprecated
    public static int computeRawVarint32Size(int i3) {
        return computeUInt32SizeNoTag(i3);
    }

    @Deprecated
    public static int computeRawVarint64Size(long j3) {
        return computeUInt64SizeNoTag(j3);
    }

    public static int computeSFixed32Size(int i3, int i4) {
        return computeTagSize(i3) + computeSFixed32SizeNoTag(i4);
    }

    public static int computeSFixed32SizeNoTag(int i3) {
        return 4;
    }

    public static int computeSFixed64Size(int i3, long j3) {
        return computeTagSize(i3) + computeSFixed64SizeNoTag(j3);
    }

    public static int computeSFixed64SizeNoTag(long j3) {
        return 8;
    }

    public static int computeSInt32Size(int i3, int i4) {
        return computeTagSize(i3) + computeSInt32SizeNoTag(i4);
    }

    public static int computeSInt32SizeNoTag(int i3) {
        return computeUInt32SizeNoTag(encodeZigZag32(i3));
    }

    public static int computeSInt64Size(int i3, long j3) {
        return computeTagSize(i3) + computeSInt64SizeNoTag(j3);
    }

    public static int computeSInt64SizeNoTag(long j3) {
        return computeUInt64SizeNoTag(encodeZigZag64(j3));
    }

    public static int computeStringSize(int i3, String str) {
        return computeTagSize(i3) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i3) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i3, 0));
    }

    public static int computeUInt32Size(int i3, int i4) {
        return computeTagSize(i3) + computeUInt32SizeNoTag(i4);
    }

    public static int computeUInt32SizeNoTag(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        return (i3 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i3, long j3) {
        return computeTagSize(i3) + computeUInt64SizeNoTag(j3);
    }

    public static int computeUInt64SizeNoTag(long j3) {
        int i3;
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (j3 < 0) {
            return 10;
        }
        if (((-34359738368L) & j3) != 0) {
            i3 = 6;
            j3 >>>= 28;
        } else {
            i3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            i3 += 2;
            j3 >>>= 14;
        }
        return (j3 & (-16384)) != 0 ? i3 + 1 : i3;
    }

    public static int encodeZigZag32(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public static long encodeZigZag64(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    static CodedOutputStream newInstance(ByteOutput byteOutput, int i3) {
        if (i3 >= 0) {
            return new ByteOutputEncoder(byteOutput, i3);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i3) {
        return new OutputStreamEncoder(outputStream, i3);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return UnsafeDirectNioEncoder.isSupported() ? newUnsafeInstance(byteBuffer) : newSafeInstance(byteBuffer);
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i3) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i3, int i4) {
        return new ArrayEncoder(bArr, i3, i4);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush();

    public abstract int getTotalBytesWritten();

    final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e3) {
            throw new OutOfSpaceException(e3);
        }
    }

    boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(byte b4);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i3, int i4);

    public abstract void writeBool(int i3, boolean z3);

    public final void writeBoolNoTag(boolean z3) {
        write(z3 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i3, byte[] bArr);

    public abstract void writeByteArray(int i3, byte[] bArr, int i4, int i5);

    public final void writeByteArrayNoTag(byte[] bArr) {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    abstract void writeByteArrayNoTag(byte[] bArr, int i3, int i4);

    public abstract void writeByteBuffer(int i3, ByteBuffer byteBuffer);

    public abstract void writeBytes(int i3, ByteString byteString);

    public abstract void writeBytesNoTag(ByteString byteString);

    public final void writeDouble(int i3, double d3) {
        writeFixed64(i3, Double.doubleToRawLongBits(d3));
    }

    public final void writeDoubleNoTag(double d3) {
        writeFixed64NoTag(Double.doubleToRawLongBits(d3));
    }

    public final void writeEnum(int i3, int i4) {
        writeInt32(i3, i4);
    }

    public final void writeEnumNoTag(int i3) {
        writeInt32NoTag(i3);
    }

    public abstract void writeFixed32(int i3, int i4);

    public abstract void writeFixed32NoTag(int i3);

    public abstract void writeFixed64(int i3, long j3);

    public abstract void writeFixed64NoTag(long j3);

    public final void writeFloat(int i3, float f3) {
        writeFixed32(i3, Float.floatToRawIntBits(f3));
    }

    public final void writeFloatNoTag(float f3) {
        writeFixed32NoTag(Float.floatToRawIntBits(f3));
    }

    @Deprecated
    public final void writeGroup(int i3, MessageLite messageLite) {
        writeTag(i3, 3);
        writeGroupNoTag(messageLite);
        writeTag(i3, 4);
    }

    @Deprecated
    final void writeGroup(int i3, MessageLite messageLite, Schema schema) {
        writeTag(i3, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i3, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    @Deprecated
    final void writeGroupNoTag(MessageLite messageLite, Schema schema) {
        schema.writeTo(messageLite, this.wrapper);
    }

    public abstract void writeInt32(int i3, int i4);

    public abstract void writeInt32NoTag(int i3);

    public final void writeInt64(int i3, long j3) {
        writeUInt64(i3, j3);
    }

    public final void writeInt64NoTag(long j3) {
        writeUInt64NoTag(j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i3, int i4);

    public abstract void writeMessage(int i3, MessageLite messageLite);

    abstract void writeMessage(int i3, MessageLite messageLite, Schema schema);

    public abstract void writeMessageNoTag(MessageLite messageLite);

    abstract void writeMessageNoTag(MessageLite messageLite, Schema schema);

    public abstract void writeMessageSetExtension(int i3, MessageLite messageLite);

    public final void writeRawByte(byte b4) {
        write(b4);
    }

    public final void writeRawByte(int i3) {
        write((byte) i3);
    }

    public final void writeRawBytes(ByteString byteString) {
        byteString.writeTo(this);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer);

    public final void writeRawBytes(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(byte[] bArr, int i3, int i4) {
        write(bArr, i3, i4);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int i3) {
        writeFixed32NoTag(i3);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long j3) {
        writeFixed64NoTag(j3);
    }

    public abstract void writeRawMessageSetExtension(int i3, ByteString byteString);

    @Deprecated
    public final void writeRawVarint32(int i3) {
        writeUInt32NoTag(i3);
    }

    @Deprecated
    public final void writeRawVarint64(long j3) {
        writeUInt64NoTag(j3);
    }

    public final void writeSFixed32(int i3, int i4) {
        writeFixed32(i3, i4);
    }

    public final void writeSFixed32NoTag(int i3) {
        writeFixed32NoTag(i3);
    }

    public final void writeSFixed64(int i3, long j3) {
        writeFixed64(i3, j3);
    }

    public final void writeSFixed64NoTag(long j3) {
        writeFixed64NoTag(j3);
    }

    public final void writeSInt32(int i3, int i4) {
        writeUInt32(i3, encodeZigZag32(i4));
    }

    public final void writeSInt32NoTag(int i3) {
        writeUInt32NoTag(encodeZigZag32(i3));
    }

    public final void writeSInt64(int i3, long j3) {
        writeUInt64(i3, encodeZigZag64(j3));
    }

    public final void writeSInt64NoTag(long j3) {
        writeUInt64NoTag(encodeZigZag64(j3));
    }

    public abstract void writeString(int i3, String str);

    public abstract void writeStringNoTag(String str);

    public abstract void writeTag(int i3, int i4);

    public abstract void writeUInt32(int i3, int i4);

    public abstract void writeUInt32NoTag(int i3);

    public abstract void writeUInt64(int i3, long j3);

    public abstract void writeUInt64NoTag(long j3);
}
