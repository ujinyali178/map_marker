package com.google.crypto.tink.shaded.protobuf;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    private static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(byte[] bArr, int i3, int i4, boolean z3) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i4 + i3;
            this.pos = i3;
            this.startPos = i3;
            this.immutable = z3;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i3 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i3;
            int i4 = i3 - this.startPos;
            int i5 = this.currentLimit;
            if (i4 <= i5) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i6 = i4 - i5;
            this.bufferSizeAfterLimit = i6;
            this.limit = i3 - i6;
        }

        private void skipRawVarint() {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.buffer;
                int i4 = this.pos;
                this.pos = i4 + 1;
                if (bArr[i4] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i3) {
            if (this.lastTag != i3) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
            this.enableAliasing = z3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i3 = this.currentLimit;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - getTotalBytesRead();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(int i3) {
            this.currentLimit = i3;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int i3) {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i3 + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i4 = this.currentLimit;
            if (totalBytesRead > i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (readRawVarint32 <= i3 - i4) {
                    ByteBuffer wrap = (this.immutable || !this.enableAliasing) ? ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i4, i4 + readRawVarint32)) : ByteBuffer.wrap(this.buffer, i4, readRawVarint32).slice();
                    this.pos += readRawVarint32;
                    return wrap;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (readRawVarint32 <= i3 - i4) {
                    ByteString wrap = (this.immutable && this.enableAliasing) ? ByteString.wrap(this.buffer, i4, readRawVarint32) : ByteString.copyFrom(this.buffer, i4, readRawVarint32);
                    this.pos += readRawVarint32;
                    return wrap;
                }
            }
            return readRawVarint32 == 0 ? ByteString.EMPTY : ByteString.wrap(readRawBytes(readRawVarint32));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i3, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(int i3, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() {
            int i3 = this.pos;
            if (i3 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i3 + 1;
            return bArr[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i3) {
            if (i3 > 0) {
                int i4 = this.limit;
                int i5 = this.pos;
                if (i3 <= i4 - i5) {
                    int i6 = i3 + i5;
                    this.pos = i6;
                    return Arrays.copyOfRange(this.buffer, i5, i6);
                }
            }
            if (i3 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i3 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            int i3 = this.pos;
            if (this.limit - i3 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i3 + 4;
            return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            int i3 = this.pos;
            if (this.limit - i3 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i3 + 8;
            return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.limit
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.buffer
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.pos = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.readRawVarint64SlowPath()
                int r1 = (int) r0
                return r1
            L70:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long readRawVarint64() {
            /*
                Method dump skipped, instructions count: 192
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.ArrayDecoder.readRawVarint64():long");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Ascii.DEL) << i3;
                if ((readRawByte() & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (readRawVarint32 <= i3 - i4) {
                    String str = new String(this.buffer, i4, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i3 = this.limit;
                int i4 = this.pos;
                if (readRawVarint32 <= i3 - i4) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i4, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i3, MessageLite.Builder builder) {
            readGroup(i3, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i3);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i3);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i3) {
            if (i3 >= 0) {
                int i4 = this.limit;
                int i5 = this.pos;
                if (i3 <= i4 - i5) {
                    this.pos = i5 + i3;
                    return;
                }
            }
            if (i3 >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i3, boolean z3) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i3;
            this.input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z3;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i3 != 0) {
                tryGetNextByteBuffer();
                return;
            }
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0L;
            this.currentByteBufferStartPos = 0L;
            this.currentByteBufferLimit = 0L;
            this.currentAddress = 0L;
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void readRawBytesTo(byte[] bArr, int i3, int i4) {
            if (i4 < 0 || i4 > remaining()) {
                if (i4 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i4 != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i5 = i4;
            while (i5 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(i5, (int) currentRemaining());
                long j3 = min;
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (i4 - i5) + i3, j3);
                i5 -= min;
                this.currentByteBufferPos += j3;
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i3 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i3;
            int i4 = i3 - this.startOffset;
            int i5 = this.currentLimit;
            if (i4 <= i5) {
                this.bufferSizeAfterCurrentLimit = 0;
                return;
            }
            int i6 = i4 - i5;
            this.bufferSizeAfterCurrentLimit = i6;
            this.totalBufferSize = i3 - i6;
        }

        private int remaining() {
            return (int) (((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() {
            for (int i3 = 0; i3 < 10; i3++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(int i3, int i4) {
            int position = this.currentByteBuffer.position();
            int limit = this.currentByteBuffer.limit();
            ByteBuffer byteBuffer = this.currentByteBuffer;
            try {
                try {
                    byteBuffer.position(i3);
                    byteBuffer.limit(i4);
                    return this.currentByteBuffer.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long position = next.position();
            this.currentByteBufferPos = position;
            this.currentByteBufferStartPos = position;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long addressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = addressOffset;
            this.currentByteBufferPos += addressOffset;
            this.currentByteBufferStartPos += addressOffset;
            this.currentByteBufferLimit += addressOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i3) {
            if (this.lastTag != i3) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
            this.enableAliasing = z3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i3 = this.currentLimit;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - getTotalBytesRead();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(int i3) {
            this.currentLimit = i3;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int i3) {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i3 + getTotalBytesRead();
            int i4 = this.currentLimit;
            if (totalBytesRead > i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j3 = readRawVarint32;
                if (j3 <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j3);
                        this.currentByteBufferPos += j3;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j4 = this.currentByteBufferPos + j3;
                    this.currentByteBufferPos = j4;
                    long j5 = this.currentAddress;
                    return slice((int) ((j4 - j5) - j3), (int) (j4 - j5));
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j3 = readRawVarint32;
                long j4 = this.currentByteBufferLimit;
                long j5 = this.currentByteBufferPos;
                if (j3 <= j4 - j5) {
                    if (this.immutable && this.enableAliasing) {
                        int i3 = (int) (j5 - this.currentAddress);
                        ByteString wrap = ByteString.wrap(slice(i3, readRawVarint32 + i3));
                        this.currentByteBufferPos += j3;
                        return wrap;
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j5, bArr, 0L, j3);
                    this.currentByteBufferPos += j3;
                    return ByteString.wrap(bArr);
                }
            }
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.immutable || !this.enableAliasing) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteString.wrap(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (readRawVarint32 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(readRawVarint32, (int) currentRemaining());
                int i4 = (int) (this.currentByteBufferPos - this.currentAddress);
                arrayList.add(ByteString.wrap(slice(i4, i4 + min)));
                readRawVarint32 -= min;
                this.currentByteBufferPos += min;
            }
            return ByteString.copyFrom(arrayList);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i3, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(int i3, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j3 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j3;
            return UnsafeUtil.getByte(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i3) {
            if (i3 >= 0) {
                long j3 = i3;
                if (j3 <= currentRemaining()) {
                    byte[] bArr = new byte[i3];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j3);
                    this.currentByteBufferPos += j3;
                    return bArr;
                }
            }
            if (i3 >= 0 && i3 <= remaining()) {
                byte[] bArr2 = new byte[i3];
                readRawBytesTo(bArr2, 0, i3);
                return bArr2;
            }
            if (i3 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i3 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            if (currentRemaining() < 4) {
                return (readRawByte() & UnsignedBytes.MAX_VALUE) | ((readRawByte() & UnsignedBytes.MAX_VALUE) << 8) | ((readRawByte() & UnsignedBytes.MAX_VALUE) << 16) | ((readRawByte() & UnsignedBytes.MAX_VALUE) << 24);
            }
            long j3 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j3;
            return ((UnsafeUtil.getByte(j3 + 3) & UnsignedBytes.MAX_VALUE) << 24) | (UnsafeUtil.getByte(j3) & UnsignedBytes.MAX_VALUE) | ((UnsafeUtil.getByte(1 + j3) & UnsignedBytes.MAX_VALUE) << 8) | ((UnsafeUtil.getByte(2 + j3) & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            if (currentRemaining() < 8) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
            }
            this.currentByteBufferPos = 8 + this.currentByteBufferPos;
            return ((UnsafeUtil.getByte(r0 + 7) & 255) << 56) | (UnsafeUtil.getByte(r0) & 255) | ((UnsafeUtil.getByte(1 + r0) & 255) << 8) | ((UnsafeUtil.getByte(2 + r0) & 255) << 16) | ((UnsafeUtil.getByte(3 + r0) & 255) << 24) | ((UnsafeUtil.getByte(4 + r0) & 255) << 32) | ((UnsafeUtil.getByte(5 + r0) & 255) << 40) | ((UnsafeUtil.getByte(6 + r0) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4) < 0) goto L34;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() {
            /*
                r10 = this;
                long r0 = r10.currentByteBufferPos
                long r2 = r10.currentByteBufferLimit
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L8a
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r0)
                if (r0 < 0) goto L1a
                long r4 = r10.currentByteBufferPos
                long r4 = r4 + r2
                r10.currentByteBufferPos = r4
                return r0
            L1a:
                long r6 = r10.currentByteBufferLimit
                long r8 = r10.currentByteBufferPos
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L26
                goto L8a
            L26:
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L34
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L90
            L34:
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L43
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L41:
                r6 = r4
                goto L90
            L43:
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L53
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L90
            L53:
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L90
            L8a:
                long r0 = r10.readRawVarint64SlowPath()
                int r1 = (int) r0
                return r1
            L90:
                r10.currentByteBufferPos = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.readRawVarint32():int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j3;
            long j4;
            long j5;
            int i3;
            long j6 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j6) {
                long j7 = j6 + 1;
                byte b4 = UnsafeUtil.getByte(j6);
                if (b4 >= 0) {
                    this.currentByteBufferPos++;
                    return b4;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j8 = j7 + 1;
                    int i4 = b4 ^ (UnsafeUtil.getByte(j7) << 7);
                    if (i4 >= 0) {
                        long j9 = j8 + 1;
                        int i5 = i4 ^ (UnsafeUtil.getByte(j8) << Ascii.SO);
                        if (i5 >= 0) {
                            j3 = i5 ^ 16256;
                        } else {
                            j8 = j9 + 1;
                            int i6 = i5 ^ (UnsafeUtil.getByte(j9) << Ascii.NAK);
                            if (i6 < 0) {
                                i3 = i6 ^ (-2080896);
                            } else {
                                j9 = j8 + 1;
                                long j10 = i6 ^ (UnsafeUtil.getByte(j8) << 28);
                                if (j10 < 0) {
                                    long j11 = j9 + 1;
                                    long j12 = j10 ^ (UnsafeUtil.getByte(j9) << 35);
                                    if (j12 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j9 = j11 + 1;
                                        j10 = j12 ^ (UnsafeUtil.getByte(j11) << 42);
                                        if (j10 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j11 = j9 + 1;
                                            j12 = j10 ^ (UnsafeUtil.getByte(j9) << 49);
                                            if (j12 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j9 = j11 + 1;
                                                j3 = (j12 ^ (UnsafeUtil.getByte(j11) << 56)) ^ 71499008037633920L;
                                                if (j3 < 0) {
                                                    long j13 = 1 + j9;
                                                    if (UnsafeUtil.getByte(j9) >= 0) {
                                                        j8 = j13;
                                                        this.currentByteBufferPos = j8;
                                                        return j3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j3 = j12 ^ j4;
                                    j8 = j11;
                                    this.currentByteBufferPos = j8;
                                    return j3;
                                }
                                j5 = 266354560;
                                j3 = j10 ^ j5;
                            }
                        }
                        j8 = j9;
                        this.currentByteBufferPos = j8;
                        return j3;
                    }
                    i3 = i4 ^ (-128);
                    j3 = i3;
                    this.currentByteBufferPos = j8;
                    return j3;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Ascii.DEL) << i3;
                if ((readRawByte() & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j3 = readRawVarint32;
                long j4 = this.currentByteBufferLimit;
                long j5 = this.currentByteBufferPos;
                if (j3 <= j4 - j5) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j5, bArr, 0L, j3);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j3;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.UTF_8);
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j3 = readRawVarint32;
                long j4 = this.currentByteBufferLimit;
                long j5 = this.currentByteBufferPos;
                if (j3 <= j4 - j5) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j5 - this.currentByteBufferStartPos), readRawVarint32);
                    this.currentByteBufferPos += j3;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                readRawBytesTo(bArr, 0, readRawVarint32);
                return Utf8.decodeUtf8(bArr, 0, readRawVarint32);
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i3, MessageLite.Builder builder) {
            readGroup(i3, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((this.totalBytesRead + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i3);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i3);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i3) {
            if (i3 < 0 || i3 > ((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (i3 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i3 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(i3, (int) currentRemaining());
                i3 -= min;
                this.currentByteBufferPos += min;
            }
        }
    }

    private static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        private interface RefillCallback {
            void onRefill();
        }

        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }

            @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }
        }

        private StreamDecoder(InputStream inputStream, int i3) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i3];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int available(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e3) {
                e3.setThrownFromInputStream();
                throw e3;
            }
        }

        private static int read(InputStream inputStream, byte[] bArr, int i3, int i4) {
            try {
                return inputStream.read(bArr, i3, i4);
            } catch (InvalidProtocolBufferException e3) {
                e3.setThrownFromInputStream();
                throw e3;
            }
        }

        private ByteString readBytesSlowPath(int i3) {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i3);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i4 = this.pos;
            int i5 = this.bufferSize;
            int i6 = i5 - i4;
            this.totalBytesRetired += i5;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i3 - i6);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.buffer, i4, bArr, 0, i6);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                i6 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i3, boolean z3) {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i3);
            if (readRawBytesSlowPathOneChunk != null) {
                return z3 ? (byte[]) readRawBytesSlowPathOneChunk.clone() : readRawBytesSlowPathOneChunk;
            }
            int i4 = this.pos;
            int i5 = this.bufferSize;
            int i6 = i5 - i4;
            this.totalBytesRetired += i5;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i3 - i6);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.buffer, i4, bArr, 0, i6);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                i6 += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i3) {
            if (i3 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i4 = this.totalBytesRetired;
            int i5 = this.pos;
            int i6 = i4 + i5 + i3;
            if (i6 - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i7 = this.currentLimit;
            if (i6 > i7) {
                skipRawBytes((i7 - i4) - i5);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i8 = this.bufferSize - i5;
            int i9 = i3 - i8;
            if (i9 >= 4096 && i9 > available(this.input)) {
                return null;
            }
            byte[] bArr = new byte[i3];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i8);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i8 < i3) {
                int read = read(this.input, bArr, i8, i3 - i8);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read;
                i8 += read;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i3) {
            ArrayList arrayList = new ArrayList();
            while (i3 > 0) {
                int min = Math.min(i3, 4096);
                byte[] bArr = new byte[min];
                int i4 = 0;
                while (i4 < min) {
                    int read = this.input.read(bArr, i4, min - i4);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i4 += read;
                }
                i3 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i3 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i3;
            int i4 = this.totalBytesRetired + i3;
            int i5 = this.currentLimit;
            if (i4 <= i5) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i6 = i4 - i5;
            this.bufferSizeAfterLimit = i6;
            this.bufferSize = i3 - i6;
        }

        private void refillBuffer(int i3) {
            if (tryRefillBuffer(i3)) {
                return;
            }
            if (i3 <= (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        private static long skip(InputStream inputStream, long j3) {
            try {
                return inputStream.skip(j3);
            } catch (InvalidProtocolBufferException e3) {
                e3.setThrownFromInputStream();
                throw e3;
            }
        }

        private void skipRawBytesSlowPath(int i3) {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i4 = this.totalBytesRetired;
            int i5 = this.pos;
            int i6 = i4 + i5 + i3;
            int i7 = this.currentLimit;
            if (i6 > i7) {
                skipRawBytes((i7 - i4) - i5);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i8 = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i4 + i5;
                int i9 = this.bufferSize - i5;
                this.bufferSize = 0;
                this.pos = 0;
                i8 = i9;
                while (i8 < i3) {
                    try {
                        long j3 = i3 - i8;
                        long skip = skip(this.input, j3);
                        if (skip < 0 || skip > j3) {
                            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        }
                        if (skip == 0) {
                            break;
                        } else {
                            i8 += (int) skip;
                        }
                    } finally {
                        this.totalBytesRetired += i8;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (i8 >= i3) {
                return;
            }
            int i10 = this.bufferSize;
            int i11 = i10 - this.pos;
            this.pos = i10;
            while (true) {
                refillBuffer(1);
                int i12 = i3 - i11;
                int i13 = this.bufferSize;
                if (i12 <= i13) {
                    this.pos = i12;
                    return;
                } else {
                    i11 += i13;
                    this.pos = i13;
                }
            }
        }

        private void skipRawVarint() {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.buffer;
                int i4 = this.pos;
                this.pos = i4 + 1;
                if (bArr[i4] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i3) {
            int i4 = this.pos;
            if (i4 + i3 <= this.bufferSize) {
                throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
            }
            int i5 = this.sizeLimit;
            int i6 = this.totalBytesRetired;
            if (i3 > (i5 - i6) - i4 || i6 + i4 + i3 > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int i7 = this.pos;
            if (i7 > 0) {
                int i8 = this.bufferSize;
                if (i8 > i7) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i7, bArr, 0, i8 - i7);
                }
                this.totalBytesRetired += i7;
                this.bufferSize -= i7;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i9 = this.bufferSize;
            int read = read(inputStream, bArr2, i9, Math.min(bArr2.length - i9, (this.sizeLimit - this.totalBytesRetired) - i9));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            if (read <= 0) {
                return false;
            }
            this.bufferSize += read;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i3) {
                return true;
            }
            return tryRefillBuffer(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i3) {
            if (this.lastTag != i3) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i3 = this.currentLimit;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(int i3) {
            this.currentLimit = i3;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int i3) {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i4 = i3 + this.totalBytesRetired + this.pos;
            int i5 = this.currentLimit;
            if (i4 > i5) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i4;
            recomputeBufferSizeAfterLimit();
            return i5;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            int readRawVarint32 = readRawVarint32();
            int i3 = this.bufferSize;
            int i4 = this.pos;
            if (readRawVarint32 > i3 - i4 || readRawVarint32 <= 0) {
                return readRawBytesSlowPath(readRawVarint32, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i4, i4 + readRawVarint32);
            this.pos += readRawVarint32;
            return copyOfRange;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            int i3 = this.bufferSize;
            int i4 = this.pos;
            if (readRawVarint32 > i3 - i4 || readRawVarint32 <= 0) {
                return readRawVarint32 == 0 ? Internal.EMPTY_BYTE_BUFFER : ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32, true));
            }
            ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i4, i4 + readRawVarint32));
            this.pos += readRawVarint32;
            return wrap;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            int i3 = this.bufferSize;
            int i4 = this.pos;
            if (readRawVarint32 > i3 - i4 || readRawVarint32 <= 0) {
                return readRawVarint32 == 0 ? ByteString.EMPTY : readBytesSlowPath(readRawVarint32);
            }
            ByteString copyFrom = ByteString.copyFrom(this.buffer, i4, readRawVarint32);
            this.pos += readRawVarint32;
            return copyFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i3, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(int i3, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            this.pos = i3 + 1;
            return bArr[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i3) {
            int i4 = this.pos;
            if (i3 > this.bufferSize - i4 || i3 <= 0) {
                return readRawBytesSlowPath(i3, false);
            }
            int i5 = i3 + i4;
            this.pos = i5;
            return Arrays.copyOfRange(this.buffer, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            int i3 = this.pos;
            if (this.bufferSize - i3 < 4) {
                refillBuffer(4);
                i3 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i3 + 4;
            return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            int i3 = this.pos;
            if (this.bufferSize - i3 < 8) {
                refillBuffer(8);
                i3 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i3 + 8;
            return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.bufferSize
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.buffer
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.pos = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.readRawVarint64SlowPath()
                int r1 = (int) r0
                return r1
            L70:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.StreamDecoder.readRawVarint32():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        
            if (r2[r0] < 0) goto L40;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long readRawVarint64() {
            /*
                Method dump skipped, instructions count: 192
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.StreamDecoder.readRawVarint64():long");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Ascii.DEL) << i3;
                if ((readRawByte() & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i3 = this.bufferSize;
                int i4 = this.pos;
                if (readRawVarint32 <= i3 - i4) {
                    String str = new String(this.buffer, i4, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(readRawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.pos, readRawVarint32, Internal.UTF_8);
            this.pos += readRawVarint32;
            return str2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            byte[] readRawBytesSlowPath;
            int readRawVarint32 = readRawVarint32();
            int i3 = this.pos;
            int i4 = this.bufferSize;
            if (readRawVarint32 <= i4 - i3 && readRawVarint32 > 0) {
                readRawBytesSlowPath = this.buffer;
                this.pos = i3 + readRawVarint32;
            } else {
                if (readRawVarint32 == 0) {
                    return "";
                }
                if (readRawVarint32 <= i4) {
                    refillBuffer(readRawVarint32);
                    readRawBytesSlowPath = this.buffer;
                    this.pos = readRawVarint32 + 0;
                } else {
                    readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32, false);
                }
                i3 = 0;
            }
            return Utf8.decodeUtf8(readRawBytesSlowPath, i3, readRawVarint32);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i3, MessageLite.Builder builder) {
            readGroup(i3, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i3);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i3);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i3) {
            int i4 = this.bufferSize;
            int i5 = this.pos;
            if (i3 > i4 - i5 || i3 < 0) {
                skipRawBytesSlowPath(i3);
            } else {
                this.pos = i5 + i3;
            }
        }
    }

    private static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z3) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            this.limit = byteBuffer.limit() + addressOffset;
            long position = addressOffset + byteBuffer.position();
            this.pos = position;
            this.startPos = position;
            this.immutable = z3;
        }

        private int bufferPos(long j3) {
            return (int) (j3 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j3 = this.limit + this.bufferSizeAfterLimit;
            this.limit = j3;
            int i3 = (int) (j3 - this.startPos);
            int i4 = this.currentLimit;
            if (i3 <= i4) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i5 = i3 - i4;
            this.bufferSizeAfterLimit = i5;
            this.limit = j3 - i5;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                long j3 = this.pos;
                this.pos = 1 + j3;
                if (UnsafeUtil.getByte(j3) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long j3, long j4) {
            int position = this.buffer.position();
            int limit = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            try {
                try {
                    byteBuffer.position(bufferPos(j3));
                    byteBuffer.limit(bufferPos(j4));
                    return this.buffer.slice();
                } catch (IllegalArgumentException e3) {
                    InvalidProtocolBufferException truncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                    truncatedMessage.initCause(e3);
                    throw truncatedMessage;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i3) {
            if (this.lastTag != i3) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
            this.enableAliasing = z3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i3 = this.currentLimit;
            if (i3 == Integer.MAX_VALUE) {
                return -1;
            }
            return i3 - getTotalBytesRead();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(int i3) {
            this.currentLimit = i3;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int i3) {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i3 + getTotalBytesRead();
            int i4 = this.currentLimit;
            if (totalBytesRead > i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j3 = readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0L, j3);
                this.pos += j3;
                return ByteBuffer.wrap(bArr);
            }
            long j4 = this.pos;
            long j5 = readRawVarint32;
            ByteBuffer slice = slice(j4, j4 + j5);
            this.pos += j5;
            return slice;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j3 = this.pos;
                long j4 = readRawVarint32;
                ByteBuffer slice = slice(j3, j3 + j4);
                this.pos += j4;
                return ByteString.wrap(slice);
            }
            byte[] bArr = new byte[readRawVarint32];
            long j5 = readRawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j5);
            this.pos += j5;
            return ByteString.wrap(bArr);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i3, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(int i3, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return parsePartialFrom;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() {
            long j3 = this.pos;
            if (j3 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j3;
            return UnsafeUtil.getByte(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i3) {
            if (i3 < 0 || i3 > remaining()) {
                if (i3 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i3 == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[i3];
            long j3 = this.pos;
            long j4 = i3;
            slice(j3, j3 + j4).get(bArr);
            this.pos += j4;
            return bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            long j3 = this.pos;
            if (this.limit - j3 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + j3;
            return ((UnsafeUtil.getByte(j3 + 3) & UnsignedBytes.MAX_VALUE) << 24) | (UnsafeUtil.getByte(j3) & UnsignedBytes.MAX_VALUE) | ((UnsafeUtil.getByte(1 + j3) & UnsignedBytes.MAX_VALUE) << 8) | ((UnsafeUtil.getByte(2 + j3) & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            long j3 = this.pos;
            if (this.limit - j3 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + j3;
            return ((UnsafeUtil.getByte(j3 + 7) & 255) << 56) | (UnsafeUtil.getByte(j3) & 255) | ((UnsafeUtil.getByte(1 + j3) & 255) << 8) | ((UnsafeUtil.getByte(2 + j3) & 255) << 16) | ((UnsafeUtil.getByte(3 + j3) & 255) << 24) | ((UnsafeUtil.getByte(4 + j3) & 255) << 32) | ((UnsafeUtil.getByte(5 + j3) & 255) << 40) | ((UnsafeUtil.getByte(6 + j3) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4) < 0) goto L34;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() {
            /*
                r10 = this;
                long r0 = r10.pos
                long r2 = r10.limit
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L85
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r0)
                if (r0 < 0) goto L17
                r10.pos = r4
                return r0
            L17:
                long r6 = r10.limit
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L21
                goto L85
            L21:
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L2f
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L8b
            L2f:
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L3c:
                r6 = r4
                goto L8b
            L3e:
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L4e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L8b
            L4e:
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getByte(r4)
                if (r1 >= 0) goto L8b
            L85:
                long r0 = r10.readRawVarint64SlowPath()
                int r1 = (int) r0
                return r1
            L8b:
                r10.pos = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j3;
            long j4;
            long j5;
            int i3;
            long j6 = this.pos;
            if (this.limit != j6) {
                long j7 = j6 + 1;
                byte b4 = UnsafeUtil.getByte(j6);
                if (b4 >= 0) {
                    this.pos = j7;
                    return b4;
                }
                if (this.limit - j7 >= 9) {
                    long j8 = j7 + 1;
                    int i4 = b4 ^ (UnsafeUtil.getByte(j7) << 7);
                    if (i4 >= 0) {
                        long j9 = j8 + 1;
                        int i5 = i4 ^ (UnsafeUtil.getByte(j8) << Ascii.SO);
                        if (i5 >= 0) {
                            j3 = i5 ^ 16256;
                        } else {
                            j8 = j9 + 1;
                            int i6 = i5 ^ (UnsafeUtil.getByte(j9) << Ascii.NAK);
                            if (i6 < 0) {
                                i3 = i6 ^ (-2080896);
                            } else {
                                j9 = j8 + 1;
                                long j10 = i6 ^ (UnsafeUtil.getByte(j8) << 28);
                                if (j10 < 0) {
                                    long j11 = j9 + 1;
                                    long j12 = j10 ^ (UnsafeUtil.getByte(j9) << 35);
                                    if (j12 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j9 = j11 + 1;
                                        j10 = j12 ^ (UnsafeUtil.getByte(j11) << 42);
                                        if (j10 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j11 = j9 + 1;
                                            j12 = j10 ^ (UnsafeUtil.getByte(j9) << 49);
                                            if (j12 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j9 = j11 + 1;
                                                j3 = (j12 ^ (UnsafeUtil.getByte(j11) << 56)) ^ 71499008037633920L;
                                                if (j3 < 0) {
                                                    long j13 = 1 + j9;
                                                    if (UnsafeUtil.getByte(j9) >= 0) {
                                                        j8 = j13;
                                                        this.pos = j8;
                                                        return j3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j3 = j12 ^ j4;
                                    j8 = j11;
                                    this.pos = j8;
                                    return j3;
                                }
                                j5 = 266354560;
                                j3 = j10 ^ j5;
                            }
                        }
                        j8 = j9;
                        this.pos = j8;
                        return j3;
                    }
                    i3 = i4 ^ (-128);
                    j3 = i3;
                    this.pos = j8;
                    return j3;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Ascii.DEL) << i3;
                if ((readRawByte() & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return "";
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[readRawVarint32];
            long j3 = readRawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j3);
            String str = new String(bArr, Internal.UTF_8);
            this.pos += j3;
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                String decodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), readRawVarint32);
                this.pos += readRawVarint32;
                return decodeUtf8;
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i3, MessageLite.Builder builder) {
            readGroup(i3, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(int i3, CodedOutputStream codedOutputStream) {
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i3);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i3);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i3);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i3) {
            if (i3 >= 0 && i3 <= remaining()) {
                this.pos += i3;
            } else {
                if (i3 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static int decodeZigZag32(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long decodeZigZag64(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i3) {
        if (i3 > 0) {
            return inputStream == null ? newInstance(Internal.EMPTY_BYTE_ARRAY) : new StreamDecoder(inputStream, i3);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        return !UnsafeDirectNioDecoder.isSupported() ? newInstance(new IterableByteBufferInputStream(iterable)) : newInstance(iterable, false);
    }

    static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z3) {
        int i3 = 0;
        int i4 = 0;
        for (ByteBuffer byteBuffer : iterable) {
            i4 += byteBuffer.remaining();
            i3 = byteBuffer.hasArray() ? i3 | 1 : byteBuffer.isDirect() ? i3 | 2 : i3 | 4;
        }
        return i3 == 2 ? new IterableDirectByteBufferDecoder(iterable, i4, z3) : newInstance(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z3) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z3);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z3);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, remaining, true);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i3, int i4) {
        return newInstance(bArr, i3, i4, false);
    }

    static CodedInputStream newInstance(byte[] bArr, int i3, int i4, boolean z3) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i3, i4, z3);
        try {
            arrayDecoder.pushLimit(i4);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public static int readRawVarint32(int i3, InputStream inputStream) {
        if ((i3 & 128) == 0) {
            return i3;
        }
        int i4 = i3 & 127;
        int i5 = 7;
        while (i5 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i4 |= (read & 127) << i5;
            if ((read & 128) == 0) {
                return i4;
            }
            i5 += 7;
        }
        while (i5 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i4;
            }
            i5 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public abstract void checkLastTagWas(int i3);

    public void checkRecursionLimit() {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z3);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int i3);

    public abstract int pushLimit(int i3);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int i3, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readGroup(int i3, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int i3);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int i3, MessageLite.Builder builder);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i3) {
        if (i3 >= 0) {
            int i4 = this.recursionLimit;
            this.recursionLimit = i3;
            return i4;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i3);
    }

    public final int setSizeLimit(int i3) {
        if (i3 >= 0) {
            int i4 = this.sizeLimit;
            this.sizeLimit = i3;
            return i4;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i3);
    }

    final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i3);

    @Deprecated
    public abstract boolean skipField(int i3, CodedOutputStream codedOutputStream);

    public abstract void skipMessage();

    public abstract void skipMessage(CodedOutputStream codedOutputStream);

    public abstract void skipRawBytes(int i3);

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }
}
