package com.google.crypto.tink.shaded.protobuf;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.BinaryReader$1, reason: invalid class name */
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z3) {
            super(null);
            this.bufferIsImmutable = z3;
            this.buffer = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        private byte readByte() {
            int i3 = this.pos;
            if (i3 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i3 + 1;
            return bArr[i3];
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private int readLittleEndian32() {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i3 = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i3 + 4;
            return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        private long readLittleEndian64() {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int i3 = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i3 + 8;
            return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private int readVarint32() {
            int i3;
            int i4 = this.pos;
            int i5 = this.limit;
            if (i5 == i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 >= 0) {
                this.pos = i6;
                return b4;
            }
            if (i5 - i6 < 9) {
                return (int) readVarint64SlowPath();
            }
            int i7 = i6 + 1;
            int i8 = b4 ^ (bArr[i6] << 7);
            if (i8 < 0) {
                i3 = i8 ^ (-128);
            } else {
                int i9 = i7 + 1;
                int i10 = i8 ^ (bArr[i7] << Ascii.SO);
                if (i10 >= 0) {
                    i3 = i10 ^ 16256;
                } else {
                    i7 = i9 + 1;
                    int i11 = i10 ^ (bArr[i9] << Ascii.NAK);
                    if (i11 < 0) {
                        i3 = i11 ^ (-2080896);
                    } else {
                        i9 = i7 + 1;
                        byte b5 = bArr[i7];
                        i3 = (i11 ^ (b5 << Ascii.FS)) ^ 266354560;
                        if (b5 < 0) {
                            i7 = i9 + 1;
                            if (bArr[i9] < 0) {
                                i9 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i9 + 1;
                                    if (bArr[i9] < 0) {
                                        i9 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i9 + 1;
                                            if (bArr[i9] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i7 = i9;
            }
            this.pos = i7;
            return i3;
        }

        private long readVarint64SlowPath() {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Ascii.DEL) << i3;
                if ((readByte() & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int i3) {
            if (i3 < 0 || i3 > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requirePosition(int i3) {
            if (this.pos != i3) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i3) {
            if (WireFormat.getTagWireType(this.tag) != i3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void skipBytes(int i3) {
            requireBytes(i3);
            this.pos += i3;
        }

        private void skipGroup() {
            int i3 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = i3;
        }

        private void skipVarint() {
            int i3 = this.limit;
            int i4 = this.pos;
            if (i3 - i4 >= 10) {
                byte[] bArr = this.buffer;
                int i5 = 0;
                while (i5 < 10) {
                    int i6 = i4 + 1;
                    if (bArr[i4] >= 0) {
                        this.pos = i6;
                        return;
                    } else {
                        i5++;
                        i4 = i6;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() {
            for (int i3 = 0; i3 < 10; i3++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int i3) {
            requireBytes(i3);
            if ((i3 & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed64Length(int i3) {
            requireBytes(i3);
            if ((i3 & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int getFieldNumber() {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void mergeGroupField(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            int i3 = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(t3, this, extensionRegistryLite);
                if (this.tag == this.endGroupTag) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i3;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void mergeMessageField(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i3 = this.limit;
            int i4 = this.pos + readVarint32;
            this.limit = i4;
            try {
                schema.mergeFrom(t3, this, extensionRegistryLite);
                if (this.pos == i4) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = i3;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public boolean readBool() {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readBoolList(List<Boolean> list) {
            int i3;
            int readVarint32;
            int i4;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        booleanArrayList.addBoolean(readBool());
                        if (isAtEnd()) {
                            return;
                        } else {
                            i4 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i4;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    booleanArrayList.addBoolean(readVarint32() != 0);
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Boolean.valueOf(readBool()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Boolean.valueOf(readVarint32() != 0));
                }
            }
            requirePosition(readVarint32);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public ByteString readBytes() {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            ByteString wrap = this.bufferIsImmutable ? ByteString.wrap(this.buffer, this.pos, readVarint32) : ByteString.copyFrom(this.buffer, this.pos, readVarint32);
            this.pos += readVarint32;
            return wrap;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readBytesList(List<ByteString> list) {
            int i3;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public double readDouble() {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readDoubleList(List<Double> list) {
            int i3;
            int i4;
            if (!(list instanceof DoubleArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = readVarint32();
                verifyPackedFixed64Length(readVarint32);
                int i5 = this.pos + readVarint32;
                while (this.pos < i5) {
                    list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                }
                return;
            }
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 1) {
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i4 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i4;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = readVarint32();
            verifyPackedFixed64Length(readVarint322);
            int i6 = this.pos + readVarint322;
            while (this.pos < i6) {
                doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readEnum() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readEnumList(List<Integer> list) {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readEnum()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    intArrayList.addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.addInt(readEnum());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readFixed32List(List<Integer> list) {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i5 = this.pos + readVarint32;
                    while (this.pos < i5) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readFixed32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i6 = this.pos + readVarint322;
                while (this.pos < i6) {
                    intArrayList.addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(readFixed32());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readFixed64List(List<Long> list) {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = readVarint32();
                verifyPackedFixed64Length(readVarint32);
                int i5 = this.pos + readVarint32;
                while (this.pos < i5) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.addLong(readFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i4 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i4;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = readVarint32();
            verifyPackedFixed64Length(readVarint322);
            int i6 = this.pos + readVarint322;
            while (this.pos < i6) {
                longArrayList.addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public float readFloat() {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readFloatList(List<Float> list) {
            int i3;
            int i4;
            if (!(list instanceof FloatArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i5 = this.pos + readVarint32;
                    while (this.pos < i5) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i6 = this.pos + readVarint322;
                while (this.pos < i6) {
                    floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                floatArrayList.addFloat(readFloat());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            int i3;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i4 = this.tag;
            do {
                list.add(readGroup(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == i4);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
            readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readInt32() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readInt32List(List<Integer> list) {
            int i3;
            int readVarint32;
            int i4;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readInt32());
                        if (isAtEnd()) {
                            return;
                        } else {
                            i4 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i4;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    intArrayList.addInt(readVarint32());
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Integer.valueOf(readVarint32()));
                }
            }
            requirePosition(readVarint32);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readInt64List(List<Long> list) {
            int i3;
            int readVarint32;
            int i4;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readInt64());
                        if (isAtEnd()) {
                            return;
                        } else {
                            i4 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i4;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    longArrayList.addLong(readVarint64());
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
            }
            requirePosition(readVarint32);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) {
            requireWireType(2);
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i3 = this.limit;
            this.limit = this.pos + readVarint32;
            try {
                Object obj = metadata.defaultKey;
                Object obj2 = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        obj = readField(metadata.keyType, null, null);
                    } else if (fieldNumber != 2) {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        obj2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                    }
                }
            } finally {
                this.limit = i3;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
            int i3;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int i4 = this.tag;
            do {
                list.add(readMessage(schema, extensionRegistryLite));
                if (isAtEnd()) {
                    return;
                } else {
                    i3 = this.pos;
                }
            } while (readVarint32() == i4);
            this.pos = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
            readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readSFixed32() {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSFixed32List(List<Integer> list) {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i5 = this.pos + readVarint32;
                    while (this.pos < i5) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readSFixed32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 2) {
                int readVarint322 = readVarint32();
                verifyPackedFixed32Length(readVarint322);
                int i6 = this.pos + readVarint322;
                while (this.pos < i6) {
                    intArrayList.addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(readSFixed32());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readSFixed64() {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSFixed64List(List<Long> list) {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint32 = readVarint32();
                verifyPackedFixed64Length(readVarint32);
                int i5 = this.pos + readVarint32;
                while (this.pos < i5) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.addLong(readSFixed64());
                    if (isAtEnd()) {
                        return;
                    } else {
                        i4 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i4;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readVarint322 = readVarint32();
            verifyPackedFixed64Length(readVarint322);
            int i6 = this.pos + readVarint322;
            while (this.pos < i6) {
                longArrayList.addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readSInt32() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSInt32List(List<Integer> list) {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readSInt32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                }
                return;
            }
            do {
                intArrayList.addInt(readSInt32());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readSInt64() {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readSInt64List(List<Long> list) {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(readSInt64()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                }
                return;
            }
            do {
                longArrayList.addLong(readSInt64());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public String readString() {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z3) {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (z3) {
                byte[] bArr = this.buffer;
                int i3 = this.pos;
                if (!Utf8.isValidUtf8(bArr, i3, i3 + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readStringList(List<String> list) {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z3) {
            int i3;
            int i4;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if (!(list instanceof LazyStringList) || z3) {
                do {
                    list.add(readStringInternal(z3));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.add(readBytes());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readStringListRequireUtf8(List<String> list) {
            readStringListInternal(list, true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public String readStringRequireUtf8() {
            return readStringInternal(true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public int readUInt32() {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readUInt32List(List<Integer> list) {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readUInt32()));
                    if (isAtEnd()) {
                        return;
                    } else {
                        i3 = this.pos;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readVarint322 = this.pos + readVarint32();
                while (this.pos < readVarint322) {
                    intArrayList.addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.addInt(readUInt32());
                if (isAtEnd()) {
                    return;
                } else {
                    i4 = this.pos;
                }
            } while (readVarint32() == this.tag);
            this.pos = i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public long readUInt64() {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public void readUInt64List(List<Long> list) {
            int i3;
            int readVarint32;
            int i4;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readUInt64());
                        if (isAtEnd()) {
                            return;
                        } else {
                            i4 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i4;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    longArrayList.addLong(readVarint64());
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (isAtEnd()) {
                            return;
                        } else {
                            i3 = this.pos;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i3;
                    return;
                }
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                readVarint32 = this.pos + readVarint32();
                while (this.pos < readVarint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
            }
            requirePosition(readVarint32);
        }

        public long readVarint64() {
            long j3;
            long j4;
            long j5;
            int i3;
            int i4 = this.pos;
            int i5 = this.limit;
            if (i5 == i4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i6 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 >= 0) {
                this.pos = i6;
                return b4;
            }
            if (i5 - i6 < 9) {
                return readVarint64SlowPath();
            }
            int i7 = i6 + 1;
            int i8 = b4 ^ (bArr[i6] << 7);
            if (i8 >= 0) {
                int i9 = i7 + 1;
                int i10 = i8 ^ (bArr[i7] << Ascii.SO);
                if (i10 >= 0) {
                    i7 = i9;
                    j3 = i10 ^ 16256;
                } else {
                    i7 = i9 + 1;
                    int i11 = i10 ^ (bArr[i9] << Ascii.NAK);
                    if (i11 < 0) {
                        i3 = i11 ^ (-2080896);
                    } else {
                        long j6 = i11;
                        int i12 = i7 + 1;
                        long j7 = j6 ^ (bArr[i7] << 28);
                        if (j7 >= 0) {
                            j5 = 266354560;
                        } else {
                            i7 = i12 + 1;
                            long j8 = j7 ^ (bArr[i12] << 35);
                            if (j8 < 0) {
                                j4 = -34093383808L;
                            } else {
                                i12 = i7 + 1;
                                j7 = j8 ^ (bArr[i7] << 42);
                                if (j7 >= 0) {
                                    j5 = 4363953127296L;
                                } else {
                                    i7 = i12 + 1;
                                    j8 = j7 ^ (bArr[i12] << 49);
                                    if (j8 < 0) {
                                        j4 = -558586000294016L;
                                    } else {
                                        int i13 = i7 + 1;
                                        long j9 = (j8 ^ (bArr[i7] << 56)) ^ 71499008037633920L;
                                        if (j9 < 0) {
                                            i7 = i13 + 1;
                                            if (bArr[i13] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                        } else {
                                            i7 = i13;
                                        }
                                        j3 = j9;
                                    }
                                }
                            }
                            j3 = j8 ^ j4;
                        }
                        j3 = j7 ^ j5;
                        i7 = i12;
                    }
                }
                this.pos = i7;
                return j3;
            }
            i3 = i8 ^ (-128);
            j3 = i3;
            this.pos = i7;
            return j3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Reader
        public boolean skipField() {
            int i3;
            int i4;
            if (isAtEnd() || (i3 = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i3);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            }
            if (tagWireType == 1) {
                i4 = 8;
            } else if (tagWireType == 2) {
                i4 = readVarint32();
            } else {
                if (tagWireType == 3) {
                    skipGroup();
                    return true;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                i4 = 4;
            }
            skipBytes(i4);
            return true;
        }
    }

    private BinaryReader() {
    }

    /* synthetic */ BinaryReader(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z3) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z3);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }
}
