package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.Utf8;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.BinaryWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator bufferAllocator, int i3) {
            super(bufferAllocator, i3, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int i3) {
            nextBuffer(newDirectBuffer(i3));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasNioBuffer()) {
                throw new RuntimeException("Allocated buffer does not have NIO buffer");
            }
            ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
            if (!nioBuffer.isDirect()) {
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = nioBuffer;
            nioBuffer.limit(nioBuffer.capacity());
            this.buffer.position(0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            int limit = this.buffer.limit() - 1;
            this.limitMinusOne = limit;
            this.pos = limit;
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int i3) {
            ByteBuffer byteBuffer = this.buffer;
            int i4 = this.pos;
            this.pos = i4 - 1;
            byteBuffer.put(i4, (byte) (i3 >>> 28));
            int i5 = this.pos - 4;
            this.pos = i5;
            this.buffer.putInt(i5 + 1, (i3 & 127) | 128 | ((((i3 >>> 21) & 127) | 128) << 24) | ((((i3 >>> 14) & 127) | 128) << 16) | ((((i3 >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i3) {
            int i4 = this.pos - 4;
            this.pos = i4;
            this.buffer.putInt(i4 + 1, (i3 & 127) | 128 | ((266338304 & i3) << 3) | (((2080768 & i3) | 2097152) << 2) | (((i3 & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i3) {
            ByteBuffer byteBuffer = this.buffer;
            int i4 = this.pos;
            this.pos = i4 - 1;
            byteBuffer.put(i4, (byte) i3);
        }

        private void writeVarint32ThreeBytes(int i3) {
            int i4 = this.pos - 3;
            this.pos = i4;
            this.buffer.putInt(i4, (((i3 & 127) | 128) << 8) | ((2080768 & i3) << 10) | (((i3 & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i3) {
            int i4 = this.pos - 2;
            this.pos = i4;
            this.buffer.putShort(i4 + 1, (short) ((i3 & 127) | 128 | ((i3 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j3) {
            int i3 = this.pos - 8;
            this.pos = i3;
            this.buffer.putLong(i3 + 1, (j3 & 127) | 128 | ((71494644084506624L & j3) << 7) | (((558551906910208L & j3) | 562949953421312L) << 6) | (((4363686772736L & j3) | 4398046511104L) << 5) | (((34091302912L & j3) | 34359738368L) << 4) | (((266338304 & j3) | 268435456) << 3) | (((2080768 & j3) | 2097152) << 2) | (((16256 & j3) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j3) {
            int i3 = this.pos - 8;
            this.pos = i3;
            this.buffer.putLong(i3 + 1, (j3 & 127) | 128 | (((71494644084506624L & j3) | 72057594037927936L) << 7) | (((558551906910208L & j3) | 562949953421312L) << 6) | (((4363686772736L & j3) | 4398046511104L) << 5) | (((34091302912L & j3) | 34359738368L) << 4) | (((266338304 & j3) | 268435456) << 3) | (((2080768 & j3) | 2097152) << 2) | (((16256 & j3) | 16384) << 1));
        }

        private void writeVarint64FiveBytes(long j3) {
            int i3 = this.pos - 5;
            this.pos = i3;
            this.buffer.putLong(i3 - 2, (((j3 & 127) | 128) << 24) | ((34091302912L & j3) << 28) | (((266338304 & j3) | 268435456) << 27) | (((2080768 & j3) | 2097152) << 26) | (((16256 & j3) | 16384) << 25));
        }

        private void writeVarint64FourBytes(long j3) {
            writeVarint32FourBytes((int) j3);
        }

        private void writeVarint64NineBytes(long j3) {
            ByteBuffer byteBuffer = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            byteBuffer.put(i3, (byte) (j3 >>> 56));
            writeVarint64EightBytesWithSign(j3 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j3) {
            writeVarint32OneByte((int) j3);
        }

        private void writeVarint64SevenBytes(long j3) {
            int i3 = this.pos - 7;
            this.pos = i3;
            this.buffer.putLong(i3, (((j3 & 127) | 128) << 8) | ((558551906910208L & j3) << 14) | (((4363686772736L & j3) | 4398046511104L) << 13) | (((34091302912L & j3) | 34359738368L) << 12) | (((266338304 & j3) | 268435456) << 11) | (((2080768 & j3) | 2097152) << 10) | (((16256 & j3) | 16384) << 9));
        }

        private void writeVarint64SixBytes(long j3) {
            int i3 = this.pos - 6;
            this.pos = i3;
            this.buffer.putLong(i3 - 1, (((j3 & 127) | 128) << 16) | ((4363686772736L & j3) << 21) | (((34091302912L & j3) | 34359738368L) << 20) | (((266338304 & j3) | 268435456) << 19) | (((2080768 & j3) | 2097152) << 18) | (((16256 & j3) | 16384) << 17));
        }

        private void writeVarint64TenBytes(long j3) {
            ByteBuffer byteBuffer = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            byteBuffer.put(i3, (byte) (j3 >>> 63));
            ByteBuffer byteBuffer2 = this.buffer;
            int i4 = this.pos;
            this.pos = i4 - 1;
            byteBuffer2.put(i4, (byte) (((j3 >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(j3 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j3) {
            writeVarint32ThreeBytes((int) j3);
        }

        private void writeVarint64TwoBytes(long j3) {
            writeVarint32TwoBytes((int) j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            ByteBuffer byteBuffer = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            byteBuffer.put(i3, b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i3 = this.pos - remaining;
            this.pos = i3;
            this.buffer.position(i3 + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            if (spaceLeft() < i4) {
                nextBuffer(i4);
            }
            int i5 = this.pos - i4;
            this.pos = i5;
            this.buffer.position(i5 + 1);
            this.buffer.put(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int i3, boolean z3) {
            requireSpace(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int i3, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i3) {
            writeTag(i3, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int i3) {
            int i4 = this.pos - 4;
            this.pos = i4;
            this.buffer.putInt(i4 + 1, i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int i3, int i4) {
            requireSpace(9);
            writeFixed32(i4);
            writeTag(i3, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int i3, long j3) {
            requireSpace(13);
            writeFixed64(j3);
            writeTag(i3, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long j3) {
            int i3 = this.pos - 8;
            this.pos = i3;
            this.buffer.putLong(i3 + 1, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeGroup(int i3, Object obj) {
            writeTag(i3, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int i3, Object obj, Schema schema) {
            writeTag(i3, 4);
            schema.writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int i3) {
            if (i3 >= 0) {
                writeVarint32(i3);
            } else {
                writeVarint64(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int i3, int i4) {
            requireSpace(15);
            writeInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                int i3 = this.pos - remaining;
                this.pos = i3;
                this.buffer.position(i3 + 1);
                this.buffer.put(byteBuffer);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            if (spaceLeft() < i4) {
                this.totalDoneBytes += i4;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i3, i4));
                nextBuffer();
            } else {
                int i5 = this.pos - i4;
                this.pos = i5;
                this.buffer.position(i5 + 1);
                this.buffer.put(bArr, i3, i4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj, Schema schema) {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int i3) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int i3, int i4) {
            requireSpace(10);
            writeSInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int i3, long j3) {
            requireSpace(15);
            writeSInt64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long j3) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i3) {
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int i3, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String str) {
            int i3;
            ByteBuffer byteBuffer;
            int i4;
            int i5;
            int i6;
            int i7;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 >= 128 || (i7 = this.pos) < 0) {
                    if (charAt2 < 2048 && (i6 = this.pos) > 0) {
                        ByteBuffer byteBuffer2 = this.buffer;
                        this.pos = i6 - 1;
                        byteBuffer2.put(i6, (byte) ((charAt2 & '?') | 128));
                        byteBuffer = this.buffer;
                        i4 = this.pos;
                        this.pos = i4 - 1;
                        i5 = (charAt2 >>> 6) | 960;
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && (i3 = this.pos) > 1) {
                        ByteBuffer byteBuffer3 = this.buffer;
                        this.pos = i3 - 1;
                        byteBuffer3.put(i3, (byte) ((charAt2 & '?') | 128));
                        ByteBuffer byteBuffer4 = this.buffer;
                        int i8 = this.pos;
                        this.pos = i8 - 1;
                        byteBuffer4.put(i8, (byte) (((charAt2 >>> 6) & 63) | 128));
                        byteBuffer = this.buffer;
                        i4 = this.pos;
                        this.pos = i4 - 1;
                        i5 = (charAt2 >>> '\f') | 480;
                    } else {
                        if (this.pos > 2) {
                            if (length != 0) {
                                char charAt3 = str.charAt(length - 1);
                                if (Character.isSurrogatePair(charAt3, charAt2)) {
                                    length--;
                                    int codePoint = Character.toCodePoint(charAt3, charAt2);
                                    ByteBuffer byteBuffer5 = this.buffer;
                                    int i9 = this.pos;
                                    this.pos = i9 - 1;
                                    byteBuffer5.put(i9, (byte) ((codePoint & 63) | 128));
                                    ByteBuffer byteBuffer6 = this.buffer;
                                    int i10 = this.pos;
                                    this.pos = i10 - 1;
                                    byteBuffer6.put(i10, (byte) (((codePoint >>> 6) & 63) | 128));
                                    ByteBuffer byteBuffer7 = this.buffer;
                                    int i11 = this.pos;
                                    this.pos = i11 - 1;
                                    byteBuffer7.put(i11, (byte) (((codePoint >>> 12) & 63) | 128));
                                    byteBuffer = this.buffer;
                                    i4 = this.pos;
                                    this.pos = i4 - 1;
                                    i5 = (codePoint >>> 18) | 240;
                                }
                            }
                            throw new Utf8.UnpairedSurrogateException(length - 1, length);
                        }
                        requireSpace(length);
                        length++;
                    }
                    byteBuffer.put(i4, (byte) i5);
                } else {
                    ByteBuffer byteBuffer8 = this.buffer;
                    this.pos = i7 - 1;
                    byteBuffer8.put(i7, (byte) charAt2);
                }
                length--;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int i3, int i4) {
            writeVarint32(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int i3, int i4) {
            requireSpace(10);
            writeVarint32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int i3, long j3) {
            requireSpace(15);
            writeVarint64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int i3) {
            if ((i3 & (-128)) == 0) {
                writeVarint32OneByte(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                writeVarint32TwoBytes(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                writeVarint32ThreeBytes(i3);
            } else if (((-268435456) & i3) == 0) {
                writeVarint32FourBytes(i3);
            } else {
                writeVarint32FiveBytes(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long j3) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j3)) {
                case 1:
                    writeVarint64OneByte(j3);
                    break;
                case 2:
                    writeVarint64TwoBytes(j3);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j3);
                    break;
                case 4:
                    writeVarint64FourBytes(j3);
                    break;
                case 5:
                    writeVarint64FiveBytes(j3);
                    break;
                case 6:
                    writeVarint64SixBytes(j3);
                    break;
                case 7:
                    writeVarint64SevenBytes(j3);
                    break;
                case 8:
                    writeVarint64EightBytes(j3);
                    break;
                case 9:
                    writeVarint64NineBytes(j3);
                    break;
                case 10:
                    writeVarint64TenBytes(j3);
                    break;
            }
        }
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator bufferAllocator, int i3) {
            super(bufferAllocator, i3, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int i3) {
            nextBuffer(newHeapBuffer(i3));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasArray()) {
                throw new RuntimeException("Allocator returned non-heap buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            int arrayOffset = allocatedBuffer.arrayOffset();
            this.limit = allocatedBuffer.limit() + arrayOffset;
            int position = arrayOffset + allocatedBuffer.position();
            this.offset = position;
            this.offsetMinusOne = position - 1;
            int i3 = this.limit - 1;
            this.limitMinusOne = i3;
            this.pos = i3;
        }

        private void writeVarint32FiveBytes(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (i3 >>> 28);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((i3 >>> 21) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((i3 >>> 14) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((i3 >>> 7) & 127) | 128);
            this.pos = i8 - 1;
            bArr[i8] = (byte) ((i3 & 127) | 128);
        }

        private void writeVarint32FourBytes(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (i3 >>> 21);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((i3 >>> 14) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((i3 >>> 7) & 127) | 128);
            this.pos = i7 - 1;
            bArr[i7] = (byte) ((i3 & 127) | 128);
        }

        private void writeVarint32OneByte(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            this.pos = i4 - 1;
            bArr[i4] = (byte) i3;
        }

        private void writeVarint32ThreeBytes(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (i3 >>> 14);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((i3 >>> 7) & 127) | 128);
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((i3 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (i3 >>> 7);
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((i3 & 127) | 128);
        }

        private void writeVarint64EightBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 49);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 42) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 35) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j3 >>> 28) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j3 >>> 21) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j3 >>> 14) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i10 - 1;
            bArr[i10] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64FiveBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 28);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 21) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 14) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i7 - 1;
            bArr[i7] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64FourBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 21);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 14) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64NineBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 56);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 49) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 42) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j3 >>> 35) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j3 >>> 28) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j3 >>> 21) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j3 >>> 14) & 127) | 128);
            int i11 = i10 - 1;
            bArr[i10] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i11 - 1;
            bArr[i11] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64OneByte(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) j3;
        }

        private void writeVarint64SevenBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 42);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 35) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 28) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j3 >>> 21) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j3 >>> 14) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i9 - 1;
            bArr[i9] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64SixBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 35);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 28) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 21) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j3 >>> 14) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i8 - 1;
            bArr[i8] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64TenBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 63);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 56) & 127) | 128);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j3 >>> 49) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j3 >>> 42) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j3 >>> 35) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j3 >>> 28) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j3 >>> 21) & 127) | 128);
            int i11 = i10 - 1;
            bArr[i10] = (byte) (((j3 >>> 14) & 127) | 128);
            int i12 = i11 - 1;
            bArr[i11] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i12 - 1;
            bArr[i12] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (((int) j3) >>> 14);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((j3 >>> 7) & 127) | 128);
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((j3 & 127) | 128);
        }

        private void writeVarint64TwoBytes(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (j3 >>> 7);
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((((int) j3) & 127) | 128);
        }

        int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
                allocatedBuffer.position((this.pos - allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
        }

        int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = b4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i3 = this.pos - remaining;
            this.pos = i3;
            byteBuffer.get(this.buffer, i3 + 1, remaining);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            if (spaceLeft() < i4) {
                nextBuffer(i4);
            }
            int i5 = this.pos - i4;
            this.pos = i5;
            System.arraycopy(bArr, i3, this.buffer, i5 + 1, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int i3, boolean z3) {
            requireSpace(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int i3, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeEndGroup(int i3) {
            writeTag(i3, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int i3) {
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 - 1;
            bArr[i4] = (byte) ((i3 >> 24) & 255);
            int i6 = i5 - 1;
            bArr[i5] = (byte) ((i3 >> 16) & 255);
            int i7 = i6 - 1;
            bArr[i6] = (byte) ((i3 >> 8) & 255);
            this.pos = i7 - 1;
            bArr[i7] = (byte) (i3 & 255);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int i3, int i4) {
            requireSpace(9);
            writeFixed32(i4);
            writeTag(i3, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int i3, long j3) {
            requireSpace(13);
            writeFixed64(j3);
            writeTag(i3, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long j3) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            bArr[i3] = (byte) (((int) (j3 >> 56)) & 255);
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((int) (j3 >> 48)) & 255);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((int) (j3 >> 40)) & 255);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((int) (j3 >> 32)) & 255);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((int) (j3 >> 24)) & 255);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((int) (j3 >> 16)) & 255);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((int) (j3 >> 8)) & 255);
            this.pos = i10 - 1;
            bArr[i10] = (byte) (((int) j3) & 255);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeGroup(int i3, Object obj) {
            writeTag(i3, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int i3, Object obj, Schema schema) {
            writeTag(i3, 4);
            schema.writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int i3) {
            if (i3 >= 0) {
                writeVarint32(i3);
            } else {
                writeVarint64(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int i3, int i4) {
            requireSpace(15);
            writeInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i3 = this.pos - remaining;
            this.pos = i3;
            byteBuffer.get(this.buffer, i3 + 1, remaining);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            if (spaceLeft() < i4) {
                this.totalDoneBytes += i4;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i3, i4));
                nextBuffer();
            } else {
                int i5 = this.pos - i4;
                this.pos = i5;
                System.arraycopy(bArr, i3, this.buffer, i5 + 1, i4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj, Schema schema) {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int i3) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int i3, int i4) {
            requireSpace(10);
            writeSInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int i3, long j3) {
            requireSpace(15);
            writeSInt64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long j3) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeStartGroup(int i3) {
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int i3, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String str) {
            int i3;
            int i4;
            int i5;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i5 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i5 - 1;
                    bArr[i5] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i4 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i6 = i4 - 1;
                    bArr2[i4] = (byte) ((charAt2 & '?') | 128);
                    this.pos = i6 - 1;
                    bArr2[i6] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i3 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i7 = i3 - 1;
                    bArr3[i3] = (byte) ((charAt2 & '?') | 128);
                    int i8 = i7 - 1;
                    bArr3[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.pos = i8 - 1;
                    bArr3[i8] = (byte) ((charAt2 >>> '\f') | 480);
                } else {
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr4 = this.buffer;
                                int i9 = this.pos;
                                int i10 = i9 - 1;
                                bArr4[i9] = (byte) ((codePoint & 63) | 128);
                                int i11 = i10 - 1;
                                bArr4[i10] = (byte) (((codePoint >>> 6) & 63) | 128);
                                int i12 = i11 - 1;
                                bArr4[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                this.pos = i12 - 1;
                                bArr4[i12] = (byte) ((codePoint >>> 18) | 240);
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int i3, int i4) {
            writeVarint32(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int i3, int i4) {
            requireSpace(10);
            writeVarint32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int i3, long j3) {
            requireSpace(15);
            writeVarint64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int i3) {
            if ((i3 & (-128)) == 0) {
                writeVarint32OneByte(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                writeVarint32TwoBytes(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                writeVarint32ThreeBytes(i3);
            } else if (((-268435456) & i3) == 0) {
                writeVarint32FourBytes(i3);
            } else {
                writeVarint32FiveBytes(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long j3) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j3)) {
                case 1:
                    writeVarint64OneByte(j3);
                    break;
                case 2:
                    writeVarint64TwoBytes(j3);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j3);
                    break;
                case 4:
                    writeVarint64FourBytes(j3);
                    break;
                case 5:
                    writeVarint64FiveBytes(j3);
                    break;
                case 6:
                    writeVarint64SixBytes(j3);
                    break;
                case 7:
                    writeVarint64SevenBytes(j3);
                    break;
                case 8:
                    writeVarint64EightBytes(j3);
                    break;
                case 9:
                    writeVarint64NineBytes(j3);
                    break;
                case 10:
                    writeVarint64TenBytes(j3);
                    break;
            }
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        UnsafeDirectWriter(BufferAllocator bufferAllocator, int i3) {
            super(bufferAllocator, i3, null);
            nextBuffer();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int i3) {
            nextBuffer(newDirectBuffer(i3));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasNioBuffer()) {
                throw new RuntimeException("Allocated buffer does not have NIO buffer");
            }
            ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
            if (!nioBuffer.isDirect()) {
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = nioBuffer;
            nioBuffer.limit(nioBuffer.capacity());
            this.buffer.position(0);
            long addressOffset = UnsafeUtil.addressOffset(this.buffer);
            this.bufferOffset = addressOffset;
            long limit = addressOffset + (this.buffer.limit() - 1);
            this.limitMinusOne = limit;
            this.pos = limit;
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i3) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (i3 >>> 28));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((i3 >>> 21) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((i3 >>> 14) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((i3 >>> 7) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i3) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (i3 >>> 21));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((i3 >>> 14) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((i3 >>> 7) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint32OneByte(int i3) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) i3);
        }

        private void writeVarint32ThreeBytes(int i3) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (i3 >>> 14));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((i3 >>> 7) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i3) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (i3 >>> 7));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 49));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 42) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 35) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((j3 >>> 28) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j3 >>> 21) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j3 >>> 14) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j3 >>> 7) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 28));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 21) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 14) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((j3 >>> 7) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64FourBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 21));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 14) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 7) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64NineBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 56));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 49) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 42) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((j3 >>> 35) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j3 >>> 28) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j3 >>> 21) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j3 >>> 14) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j3 >>> 7) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64OneByte(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) j3);
        }

        private void writeVarint64SevenBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 42));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 35) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 28) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((j3 >>> 21) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j3 >>> 14) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j3 >>> 7) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64SixBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 35));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 28) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 21) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((j3 >>> 14) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j3 >>> 7) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64TenBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 63));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 56) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((j3 >>> 49) & 127) | 128));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((j3 >>> 42) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j3 >>> 35) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j3 >>> 28) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j3 >>> 21) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j3 >>> 14) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j3 >>> 7) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((int) j3) >>> 14));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((j3 >>> 7) & 127) | 128));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (j3 >>> 7));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((((int) j3) & 127) | 128));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(bufferPos() + 1);
                this.buffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            this.pos -= remaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            if (spaceLeft() < i4) {
                nextBuffer(i4);
            }
            this.pos -= i4;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int i3, boolean z3) {
            requireSpace(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int i3, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i3) {
            writeTag(i3, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int i3) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i3 >> 24) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((i3 >> 16) & 255));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((i3 >> 8) & 255));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (i3 & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int i3, int i4) {
            requireSpace(9);
            writeFixed32(i4);
            writeTag(i3, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int i3, long j3) {
            requireSpace(13);
            writeFixed64(j3);
            writeTag(i3, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long j3) {
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((int) (j3 >> 56)) & 255));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((int) (j3 >> 48)) & 255));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((int) (j3 >> 40)) & 255));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((int) (j3 >> 32)) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((int) (j3 >> 24)) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((int) (j3 >> 16)) & 255));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((int) (j3 >> 8)) & 255));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((int) j3) & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int i3, Object obj) {
            writeTag(i3, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int i3, Object obj, Schema schema) {
            writeTag(i3, 4);
            schema.writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int i3) {
            if (i3 >= 0) {
                writeVarint32(i3);
            } else {
                writeVarint64(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int i3, int i4) {
            requireSpace(15);
            writeInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                this.pos -= remaining;
                this.buffer.position(bufferPos() + 1);
                this.buffer.put(byteBuffer);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            if (spaceLeft() < i4) {
                this.totalDoneBytes += i4;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i3, i4));
                nextBuffer();
            } else {
                this.pos -= i4;
                this.buffer.position(bufferPos() + 1);
                this.buffer.put(bArr, i3, i4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj, Schema schema) {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int i3) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int i3, int i4) {
            requireSpace(10);
            writeSInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int i3, long j3) {
            requireSpace(15);
            writeSInt64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long j3) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i3) {
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int i3, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v7 */
        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String str) {
            long j3;
            char c3;
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (charAt = str.charAt(length)) >= 128) {
                    break;
                }
                long j4 = this.pos;
                this.pos = j4 - 1;
                UnsafeUtil.putByte(j4, (byte) charAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128) {
                    j3 = this.pos;
                    if (j3 >= this.bufferOffset) {
                        this.pos = j3 - 1;
                        c3 = charAt2;
                        UnsafeUtil.putByte(j3, (byte) c3);
                        length--;
                    }
                }
                if (charAt2 < 2048) {
                    long j5 = this.pos;
                    if (j5 > this.bufferOffset) {
                        this.pos = j5 - 1;
                        UnsafeUtil.putByte(j5, (byte) ((charAt2 & '?') | 128));
                        j3 = this.pos;
                        this.pos = j3 - 1;
                        c3 = (charAt2 >>> 6) | 960;
                        UnsafeUtil.putByte(j3, (byte) c3);
                        length--;
                    }
                }
                if (charAt2 < 55296 || 57343 < charAt2) {
                    long j6 = this.pos;
                    if (j6 > this.bufferOffset + 1) {
                        this.pos = j6 - 1;
                        UnsafeUtil.putByte(j6, (byte) ((charAt2 & '?') | 128));
                        long j7 = this.pos;
                        this.pos = j7 - 1;
                        UnsafeUtil.putByte(j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j3 = this.pos;
                        this.pos = j3 - 1;
                        c3 = (charAt2 >>> '\f') | 480;
                        UnsafeUtil.putByte(j3, (byte) c3);
                        length--;
                    }
                }
                if (this.pos > this.bufferOffset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            long j8 = this.pos;
                            this.pos = j8 - 1;
                            UnsafeUtil.putByte(j8, (byte) ((codePoint & 63) | 128));
                            long j9 = this.pos;
                            this.pos = j9 - 1;
                            UnsafeUtil.putByte(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                            long j10 = this.pos;
                            this.pos = j10 - 1;
                            UnsafeUtil.putByte(j10, (byte) (((codePoint >>> 12) & 63) | 128));
                            j3 = this.pos;
                            this.pos = j3 - 1;
                            c3 = (codePoint >>> 18) | 240;
                            UnsafeUtil.putByte(j3, (byte) c3);
                            length--;
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                }
                requireSpace(length);
                length++;
                length--;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int i3, int i4) {
            writeVarint32(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int i3, int i4) {
            requireSpace(10);
            writeVarint32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int i3, long j3) {
            requireSpace(15);
            writeVarint64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int i3) {
            if ((i3 & (-128)) == 0) {
                writeVarint32OneByte(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                writeVarint32TwoBytes(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                writeVarint32ThreeBytes(i3);
            } else if (((-268435456) & i3) == 0) {
                writeVarint32FourBytes(i3);
            } else {
                writeVarint32FiveBytes(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long j3) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j3)) {
                case 1:
                    writeVarint64OneByte(j3);
                    break;
                case 2:
                    writeVarint64TwoBytes(j3);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j3);
                    break;
                case 4:
                    writeVarint64FourBytes(j3);
                    break;
                case 5:
                    writeVarint64FiveBytes(j3);
                    break;
                case 6:
                    writeVarint64SixBytes(j3);
                    break;
                case 7:
                    writeVarint64SevenBytes(j3);
                    break;
                case 8:
                    writeVarint64EightBytes(j3);
                    break;
                case 9:
                    writeVarint64NineBytes(j3);
                    break;
                case 10:
                    writeVarint64TenBytes(j3);
                    break;
            }
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator bufferAllocator, int i3) {
            super(bufferAllocator, i3, null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int i3) {
            nextBuffer(newHeapBuffer(i3));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.hasArray()) {
                throw new RuntimeException("Allocator returned non-heap buffer");
            }
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            long arrayOffset = allocatedBuffer.arrayOffset();
            this.limit = allocatedBuffer.limit() + arrayOffset;
            long position = arrayOffset + allocatedBuffer.position();
            this.offset = position;
            this.offsetMinusOne = position - 1;
            long j3 = this.limit - 1;
            this.limitMinusOne = j3;
            this.pos = j3;
        }

        private void writeVarint32FiveBytes(int i3) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (i3 >>> 28));
            byte[] bArr2 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr2, j4, (byte) (((i3 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr3, j5, (byte) (((i3 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr4, j6, (byte) (((i3 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr5, j7, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i3) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (i3 >>> 21));
            byte[] bArr2 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr2, j4, (byte) (((i3 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr3, j5, (byte) (((i3 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr4, j6, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint32OneByte(int i3) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) i3);
        }

        private void writeVarint32ThreeBytes(int i3) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (i3 >>> 14));
            byte[] bArr2 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr2, j4, (byte) (((i3 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr3, j5, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i3) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (i3 >>> 7));
            byte[] bArr2 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr2, j4, (byte) ((i3 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 49));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 42) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr6, j9, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr7, j10, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr8, j11, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 28));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64FourBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 21));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64NineBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 56));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 49) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 42) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr6, j9, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr7, j10, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr8, j11, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr9, j12, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64OneByte(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) j3);
        }

        private void writeVarint64SevenBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 42));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr6, j9, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr7, j10, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64SixBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 35));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr6, j9, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64TenBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 63));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 56) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((j3 >>> 49) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((j3 >>> 42) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr6, j9, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr7, j10, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr8, j11, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr9, j12, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr10 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr10, j13, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (((int) j3) >>> 14));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) ((j3 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (j3 >>> 7));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) ((((int) j3) & 127) | 128));
        }

        int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
        }

        int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte b4) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, b4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            requireSpace(remaining);
            this.pos -= remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] bArr, int i3, int i4) {
            if (i3 < 0 || i3 + i4 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            requireSpace(i4);
            this.pos -= i4;
            System.arraycopy(bArr, i3, this.buffer, arrayPos() + 1, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int i3, boolean z3) {
            requireSpace(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int i3, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeEndGroup(int i3) {
            writeTag(i3, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int i3) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) ((i3 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr2, j4, (byte) ((i3 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr3, j5, (byte) ((i3 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr4, j6, (byte) (i3 & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int i3, int i4) {
            requireSpace(9);
            writeFixed32(i4);
            writeTag(i3, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int i3, long j3) {
            requireSpace(13);
            writeFixed64(j3);
            writeTag(i3, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long j3) {
            byte[] bArr = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr, j4, (byte) (((int) (j3 >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr2, j5, (byte) (((int) (j3 >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr3, j6, (byte) (((int) (j3 >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr4, j7, (byte) (((int) (j3 >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr5, j8, (byte) (((int) (j3 >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr6, j9, (byte) (((int) (j3 >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr7, j10, (byte) (((int) (j3 >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr8, j11, (byte) (((int) j3) & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int i3, Object obj) {
            writeTag(i3, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int i3, Object obj, Schema schema) {
            writeTag(i3, 4);
            schema.writeTo(obj, this);
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int i3) {
            if (i3 >= 0) {
                writeVarint32(i3);
            } else {
                writeVarint64(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int i3, int i4) {
            requireSpace(15);
            writeInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i3, int i4) {
            if (i3 < 0 || i3 + i4 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            if (spaceLeft() >= i4) {
                this.pos -= i4;
                System.arraycopy(bArr, i3, this.buffer, arrayPos() + 1, i4);
            } else {
                this.totalDoneBytes += i4;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i3, i4));
                nextBuffer();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int i3, Object obj, Schema schema) {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int i3) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int i3, int i4) {
            requireSpace(10);
            writeSInt32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int i3, long j3) {
            requireSpace(15);
            writeSInt64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long j3) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeStartGroup(int i3) {
            writeTag(i3, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int i3, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i3, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (charAt = str.charAt(length)) >= 128) {
                    break;
                }
                byte[] bArr = this.buffer;
                long j3 = this.pos;
                this.pos = j3 - 1;
                UnsafeUtil.putByte(bArr, j3, (byte) charAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128) {
                    long j4 = this.pos;
                    if (j4 > this.offsetMinusOne) {
                        byte[] bArr2 = this.buffer;
                        this.pos = j4 - 1;
                        UnsafeUtil.putByte(bArr2, j4, (byte) charAt2);
                        length--;
                    }
                }
                if (charAt2 < 2048) {
                    long j5 = this.pos;
                    if (j5 > this.offset) {
                        byte[] bArr3 = this.buffer;
                        this.pos = j5 - 1;
                        UnsafeUtil.putByte(bArr3, j5, (byte) ((charAt2 & '?') | 128));
                        byte[] bArr4 = this.buffer;
                        long j6 = this.pos;
                        this.pos = j6 - 1;
                        UnsafeUtil.putByte(bArr4, j6, (byte) ((charAt2 >>> 6) | 960));
                        length--;
                    }
                }
                if (charAt2 < 55296 || 57343 < charAt2) {
                    long j7 = this.pos;
                    if (j7 > this.offset + 1) {
                        byte[] bArr5 = this.buffer;
                        this.pos = j7 - 1;
                        UnsafeUtil.putByte(bArr5, j7, (byte) ((charAt2 & '?') | 128));
                        byte[] bArr6 = this.buffer;
                        long j8 = this.pos;
                        this.pos = j8 - 1;
                        UnsafeUtil.putByte(bArr6, j8, (byte) (((charAt2 >>> 6) & 63) | 128));
                        byte[] bArr7 = this.buffer;
                        long j9 = this.pos;
                        this.pos = j9 - 1;
                        UnsafeUtil.putByte(bArr7, j9, (byte) ((charAt2 >>> '\f') | 480));
                        length--;
                    }
                }
                if (this.pos > this.offset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr8 = this.buffer;
                            long j10 = this.pos;
                            this.pos = j10 - 1;
                            UnsafeUtil.putByte(bArr8, j10, (byte) ((codePoint & 63) | 128));
                            byte[] bArr9 = this.buffer;
                            long j11 = this.pos;
                            this.pos = j11 - 1;
                            UnsafeUtil.putByte(bArr9, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                            byte[] bArr10 = this.buffer;
                            long j12 = this.pos;
                            this.pos = j12 - 1;
                            UnsafeUtil.putByte(bArr10, j12, (byte) (((codePoint >>> 12) & 63) | 128));
                            byte[] bArr11 = this.buffer;
                            long j13 = this.pos;
                            this.pos = j13 - 1;
                            UnsafeUtil.putByte(bArr11, j13, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                }
                requireSpace(length);
                length++;
                length--;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int i3, int i4) {
            writeVarint32(WireFormat.makeTag(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int i3, int i4) {
            requireSpace(10);
            writeVarint32(i4);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int i3, long j3) {
            requireSpace(15);
            writeVarint64(j3);
            writeTag(i3, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int i3) {
            if ((i3 & (-128)) == 0) {
                writeVarint32OneByte(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                writeVarint32TwoBytes(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                writeVarint32ThreeBytes(i3);
            } else if (((-268435456) & i3) == 0) {
                writeVarint32FourBytes(i3);
            } else {
                writeVarint32FiveBytes(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long j3) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j3)) {
                case 1:
                    writeVarint64OneByte(j3);
                    break;
                case 2:
                    writeVarint64TwoBytes(j3);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j3);
                    break;
                case 4:
                    writeVarint64FourBytes(j3);
                    break;
                case 5:
                    writeVarint64FiveBytes(j3);
                    break;
                case 6:
                    writeVarint64SixBytes(j3);
                    break;
                case 7:
                    writeVarint64SevenBytes(j3);
                    break;
                case 8:
                    writeVarint64EightBytes(j3);
                    break;
                case 9:
                    writeVarint64NineBytes(j3);
                    break;
                case 10:
                    writeVarint64TenBytes(j3);
                    break;
            }
        }
    }

    private BinaryWriter(BufferAllocator bufferAllocator, int i3) {
        this.buffers = new ArrayDeque<>(4);
        if (i3 <= 0) {
            throw new IllegalArgumentException("chunkSize must be > 0");
        }
        this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
        this.chunkSize = i3;
    }

    /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i3, AnonymousClass1 anonymousClass1) {
        this(bufferAllocator, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j3) {
        byte b4;
        if (((-128) & j3) == 0) {
            return (byte) 1;
        }
        if (j3 < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j3) != 0) {
            b4 = (byte) 6;
            j3 >>>= 28;
        } else {
            b4 = 2;
        }
        if (((-2097152) & j3) != 0) {
            b4 = (byte) (b4 + 2);
            j3 >>>= 14;
        }
        return (j3 & (-16384)) != 0 ? (byte) (b4 + 1) : b4;
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i3) {
        return isUnsafeDirectSupported() ? newUnsafeDirectInstance(bufferAllocator, i3) : newSafeDirectInstance(bufferAllocator, i3);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i3) {
        return isUnsafeHeapSupported() ? newUnsafeHeapInstance(bufferAllocator, i3) : newSafeHeapInstance(bufferAllocator, i3);
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i3) {
        return new SafeDirectWriter(bufferAllocator, i3);
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i3) {
        return new SafeHeapWriter(bufferAllocator, i3);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i3) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i3);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i3) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i3);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private final void writeBoolList_Internal(int i3, BooleanArrayList booleanArrayList, boolean z3) {
        if (!z3) {
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(i3, booleanArrayList.getBoolean(size));
            }
            return;
        }
        requireSpace(booleanArrayList.size() + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(booleanArrayList.getBoolean(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeBoolList_Internal(int i3, List<Boolean> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(i3, list.get(size).booleanValue());
            }
            return;
        }
        requireSpace(list.size() + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(list.get(size2).booleanValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeDoubleList_Internal(int i3, DoubleArrayList doubleArrayList, boolean z3) {
        if (!z3) {
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeDouble(i3, doubleArrayList.getDouble(size));
            }
            return;
        }
        requireSpace((doubleArrayList.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size2)));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeDoubleList_Internal(int i3, List<Double> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeDouble(i3, list.get(size).doubleValue());
            }
            return;
        }
        requireSpace((list.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(Double.doubleToRawLongBits(list.get(size2).doubleValue()));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeFixed32List_Internal(int i3, IntArrayList intArrayList, boolean z3) {
        if (!z3) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(i3, intArrayList.getInt(size));
            }
            return;
        }
        requireSpace((intArrayList.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(intArrayList.getInt(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeFixed32List_Internal(int i3, List<Integer> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(i3, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeFixed64List_Internal(int i3, LongArrayList longArrayList, boolean z3) {
        if (!z3) {
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(i3, longArrayList.getLong(size));
            }
            return;
        }
        requireSpace((longArrayList.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(longArrayList.getLong(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeFixed64List_Internal(int i3, List<Long> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(i3, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeFloatList_Internal(int i3, FloatArrayList floatArrayList, boolean z3) {
        if (!z3) {
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFloat(i3, floatArrayList.getFloat(size));
            }
            return;
        }
        requireSpace((floatArrayList.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size2)));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeFloatList_Internal(int i3, List<Float> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFloat(i3, list.get(size).floatValue());
            }
            return;
        }
        requireSpace((list.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(Float.floatToRawIntBits(list.get(size2).floatValue()));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeInt32List_Internal(int i3, IntArrayList intArrayList, boolean z3) {
        if (!z3) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(i3, intArrayList.getInt(size));
            }
            return;
        }
        requireSpace((intArrayList.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(intArrayList.getInt(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeInt32List_Internal(int i3, List<Integer> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(i3, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private void writeLazyString(int i3, Object obj) {
        if (obj instanceof String) {
            writeString(i3, (String) obj);
        } else {
            writeBytes(i3, (ByteString) obj);
        }
    }

    static final void writeMapEntryField(Writer writer, int i3, WireFormat.FieldType fieldType, Object obj) {
        int intValue;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i3, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i3, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i3, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i3, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i3, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i3, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i3, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i3, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i3, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i3, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i3, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i3, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i3, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i3, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i3, obj);
                return;
            case 16:
                writer.writeBytes(i3, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    intValue = ((Internal.EnumLite) obj).getNumber();
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Unexpected type for enum in map.");
                    }
                    intValue = ((Integer) obj).intValue();
                }
                writer.writeEnum(i3, intValue);
                return;
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void writeSInt32List_Internal(int i3, IntArrayList intArrayList, boolean z3) {
        if (!z3) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(i3, intArrayList.getInt(size));
            }
            return;
        }
        requireSpace((intArrayList.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(intArrayList.getInt(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeSInt32List_Internal(int i3, List<Integer> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(i3, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeSInt64List_Internal(int i3, LongArrayList longArrayList, boolean z3) {
        if (!z3) {
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(i3, longArrayList.getLong(size));
            }
            return;
        }
        requireSpace((longArrayList.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(longArrayList.getLong(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeSInt64List_Internal(int i3, List<Long> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(i3, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeUInt32List_Internal(int i3, IntArrayList intArrayList, boolean z3) {
        if (!z3) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeUInt32(i3, intArrayList.getInt(size));
            }
            return;
        }
        requireSpace((intArrayList.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeVarint32(intArrayList.getInt(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeUInt32List_Internal(int i3, List<Integer> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeUInt32(i3, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeVarint32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeUInt64List_Internal(int i3, LongArrayList longArrayList, boolean z3) {
        if (!z3) {
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeUInt64(i3, longArrayList.getLong(size));
            }
            return;
        }
        requireSpace((longArrayList.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeVarint64(longArrayList.getLong(size2));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    private final void writeUInt64List_Internal(int i3, List<Long> list, boolean z3) {
        if (!z3) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeUInt64(i3, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeVarint64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i3, 2);
    }

    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    final AllocatedBuffer newDirectBuffer(int i3) {
        return this.alloc.allocateDirectBuffer(Math.max(i3, this.chunkSize));
    }

    final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    final AllocatedBuffer newHeapBuffer(int i3) {
        return this.alloc.allocateHeapBuffer(Math.max(i3, this.chunkSize));
    }

    abstract void requireSpace(int i3);

    abstract void writeBool(boolean z3);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeBoolList(int i3, List<Boolean> list, boolean z3) {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i3, (BooleanArrayList) list, z3);
        } else {
            writeBoolList_Internal(i3, list, z3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeBytesList(int i3, List<ByteString> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i3, list.get(size));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeDouble(int i3, double d3) {
        writeFixed64(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeDoubleList(int i3, List<Double> list, boolean z3) {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i3, (DoubleArrayList) list, z3);
        } else {
            writeDoubleList_Internal(i3, list, z3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeEnum(int i3, int i4) {
        writeInt32(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeEnumList(int i3, List<Integer> list, boolean z3) {
        writeInt32List(i3, list, z3);
    }

    abstract void writeFixed32(int i3);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFixed32List(int i3, List<Integer> list, boolean z3) {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i3, (IntArrayList) list, z3);
        } else {
            writeFixed32List_Internal(i3, list, z3);
        }
    }

    abstract void writeFixed64(long j3);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFixed64List(int i3, List<Long> list, boolean z3) {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i3, (LongArrayList) list, z3);
        } else {
            writeFixed64List_Internal(i3, list, z3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFloat(int i3, float f3) {
        writeFixed32(i3, Float.floatToRawIntBits(f3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFloatList(int i3, List<Float> list, boolean z3) {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i3, (FloatArrayList) list, z3);
        } else {
            writeFloatList_Internal(i3, list, z3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int i3, List<?> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i3, list.get(size));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int i3, List<?> list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i3, list.get(size), schema);
        }
    }

    abstract void writeInt32(int i3);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeInt32List(int i3, List<Integer> list, boolean z3) {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i3, (IntArrayList) list, z3);
        } else {
            writeInt32List_Internal(i3, list, z3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeInt64(int i3, long j3) {
        writeUInt64(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeInt64List(int i3, List<Long> list, boolean z3) {
        writeUInt64List(i3, list, z3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public <K, V> void writeMap(int i3, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, entry.getValue());
            writeMapEntryField(this, 1, metadata.keyType, entry.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i3, 2);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageList(int i3, List<?> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i3, list.get(size));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageList(int i3, List<?> list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i3, list.get(size), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageSetItem(int i3, Object obj) {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i3);
        writeTag(1, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed32(int i3, int i4) {
        writeFixed32(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed32List(int i3, List<Integer> list, boolean z3) {
        writeFixed32List(i3, list, z3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed64(int i3, long j3) {
        writeFixed64(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed64List(int i3, List<Long> list, boolean z3) {
        writeFixed64List(i3, list, z3);
    }

    abstract void writeSInt32(int i3);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSInt32List(int i3, List<Integer> list, boolean z3) {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i3, (IntArrayList) list, z3);
        } else {
            writeSInt32List_Internal(i3, list, z3);
        }
    }

    abstract void writeSInt64(long j3);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSInt64List(int i3, List<Long> list, boolean z3) {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i3, (LongArrayList) list, z3);
        } else {
            writeSInt64List_Internal(i3, list, z3);
        }
    }

    abstract void writeString(String str);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeStringList(int i3, List<String> list) {
        if (!(list instanceof LazyStringList)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeString(i3, list.get(size));
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeLazyString(i3, lazyStringList.getRaw(size2));
        }
    }

    abstract void writeTag(int i3, int i4);

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeUInt32List(int i3, List<Integer> list, boolean z3) {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i3, (IntArrayList) list, z3);
        } else {
            writeUInt32List_Internal(i3, list, z3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeUInt64List(int i3, List<Long> list, boolean z3) {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i3, (LongArrayList) list, z3);
        } else {
            writeUInt64List_Internal(i3, list, z3);
        }
    }

    abstract void writeVarint32(int i3);

    abstract void writeVarint64(long j3);
}
