package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.util.List;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class CodedInputStreamReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;
    private final CodedInputStream input;
    private int nextTag = 0;
    private int tag;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.CodedInputStreamReader$1, reason: invalid class name */
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

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.checkNotNull(codedInputStream, "input");
        this.input = codedInputStream2;
        codedInputStream2.wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.wrapper;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private <T> void mergeGroupFieldInternal(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
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

    private <T> void mergeMessageFieldInternal(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        int readUInt32 = this.input.readUInt32();
        CodedInputStream codedInputStream = this.input;
        if (codedInputStream.recursionDepth >= codedInputStream.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = codedInputStream.pushLimit(readUInt32);
        this.input.recursionDepth++;
        schema.mergeFrom(t3, this, extensionRegistryLite);
        this.input.checkLastTagWas(0);
        r5.recursionDepth--;
        this.input.popLimit(pushLimit);
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
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        T newInstance = schema.newInstance();
        mergeGroupFieldInternal(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        T newInstance = schema.newInstance();
        mergeMessageFieldInternal(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private void requirePosition(int i3) {
        if (this.input.getTotalBytesRead() != i3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void requireWireType(int i3) {
        if (WireFormat.getTagWireType(this.tag) != i3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void verifyPackedFixed32Length(int i3) {
        if ((i3 & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void verifyPackedFixed64Length(int i3) {
        if ((i3 & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int getFieldNumber() {
        int i3 = this.nextTag;
        if (i3 != 0) {
            this.tag = i3;
            this.nextTag = 0;
        } else {
            this.tag = this.input.readTag();
        }
        int i4 = this.tag;
        if (i4 == 0 || i4 == this.endGroupTag) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.getTagFieldNumber(i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void mergeGroupField(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        requireWireType(3);
        mergeGroupFieldInternal(t3, schema, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void mergeMessageField(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        requireWireType(2);
        mergeMessageFieldInternal(t3, schema, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean readBool() {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readBoolList(List<Boolean> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    booleanArrayList.addBoolean(this.input.readBool());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                booleanArrayList.addBoolean(this.input.readBool());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.input.readBool()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Boolean.valueOf(this.input.readBool()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public ByteString readBytes() {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readBytesList(List<ByteString> list) {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(readBytes());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public double readDouble() {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readDoubleList(List<Double> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof DoubleArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 1) {
                do {
                    list.add(Double.valueOf(this.input.readDouble()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt32 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt32);
            int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
            do {
                list.add(Double.valueOf(this.input.readDouble()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 1) {
            do {
                doubleArrayList.addDouble(this.input.readDouble());
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag2 = this.input.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int readUInt322 = this.input.readUInt32();
        verifyPackedFixed64Length(readUInt322);
        int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
        do {
            doubleArrayList.addDouble(this.input.readDouble());
        } while (this.input.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readEnum() {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readEnumList(List<Integer> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    intArrayList.addInt(this.input.readEnum());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readEnum());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.input.readEnum()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Integer.valueOf(this.input.readEnum()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readFixed32() {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readFixed32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Integer.valueOf(this.input.readFixed32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.input.readFixed32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                intArrayList.addInt(this.input.readFixed32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.addInt(this.input.readFixed32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readFixed64() {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readFixed64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 1) {
                do {
                    list.add(Long.valueOf(this.input.readFixed64()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt32 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt32);
            int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
            do {
                list.add(Long.valueOf(this.input.readFixed64()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 1) {
            do {
                longArrayList.addLong(this.input.readFixed64());
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag2 = this.input.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int readUInt322 = this.input.readUInt32();
        verifyPackedFixed64Length(readUInt322);
        int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
        do {
            longArrayList.addLong(this.input.readFixed64());
        } while (this.input.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public float readFloat() {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readFloatList(List<Float> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof FloatArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Float.valueOf(this.input.readFloat()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.input.readFloat()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                floatArrayList.addFloat(this.input.readFloat());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            floatArrayList.addFloat(this.input.readFloat());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
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
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i3 = this.tag;
        do {
            list.add(readGroup(schema, extensionRegistryLite));
            if (this.input.isAtEnd() || this.nextTag != 0) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == i3);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    @Deprecated
    public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
        readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readInt32() {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readInt32List(List<Integer> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    intArrayList.addInt(this.input.readInt32());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.input.readInt32()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Integer.valueOf(this.input.readInt32()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readInt64() {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readInt64List(List<Long> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    longArrayList.addLong(this.input.readInt64());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                longArrayList.addLong(this.input.readInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Long.valueOf(this.input.readInt64()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Long.valueOf(this.input.readInt64()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <K, V> void readMap(java.util.Map<K, V> r8, com.google.crypto.tink.shaded.protobuf.MapEntryLite.Metadata<K, V> r9, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r10) {
        /*
            r7 = this;
            r0 = 2
            r7.requireWireType(r0)
            com.google.crypto.tink.shaded.protobuf.CodedInputStream r1 = r7.input
            int r1 = r1.readUInt32()
            com.google.crypto.tink.shaded.protobuf.CodedInputStream r2 = r7.input
            int r1 = r2.pushLimit(r1)
            K r2 = r9.defaultKey
            V r3 = r9.defaultValue
        L14:
            int r4 = r7.getFieldNumber()     // Catch: java.lang.Throwable -> L66
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5d
            com.google.crypto.tink.shaded.protobuf.CodedInputStream r5 = r7.input     // Catch: java.lang.Throwable -> L66
            boolean r5 = r5.isAtEnd()     // Catch: java.lang.Throwable -> L66
            if (r5 == 0) goto L26
            goto L5d
        L26:
            r5 = 1
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L48
            if (r4 == r0) goto L3b
            boolean r4 = r7.skipField()     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            if (r4 == 0) goto L35
            goto L14
        L35:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r4 = new com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            r4.<init>(r6)     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            throw r4     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
        L3b:
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r4 = r9.valueType     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            V r5 = r9.defaultValue     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            java.lang.Object r3 = r7.readField(r4, r5, r10)     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            goto L14
        L48:
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r4 = r9.keyType     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            r5 = 0
            java.lang.Object r2 = r7.readField(r4, r5, r5)     // Catch: com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50 java.lang.Throwable -> L66
            goto L14
        L50:
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L66
            if (r4 == 0) goto L57
            goto L14
        L57:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r8 = new com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L66
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L66
            throw r8     // Catch: java.lang.Throwable -> L66
        L5d:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L66
            com.google.crypto.tink.shaded.protobuf.CodedInputStream r8 = r7.input
            r8.popLimit(r1)
            return
        L66:
            r8 = move-exception
            com.google.crypto.tink.shaded.protobuf.CodedInputStream r9 = r7.input
            r9.popLimit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStreamReader.readMap(java.util.Map, com.google.crypto.tink.shaded.protobuf.MapEntryLite$Metadata, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite):void");
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
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i3 = this.tag;
        do {
            list.add(readMessage(schema, extensionRegistryLite));
            if (this.input.isAtEnd() || this.nextTag != 0) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == i3);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
        readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readSFixed32() {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSFixed32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Integer.valueOf(this.input.readSFixed32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.input.readSFixed32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                intArrayList.addInt(this.input.readSFixed32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.addInt(this.input.readSFixed32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readSFixed64() {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSFixed64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 1) {
                do {
                    list.add(Long.valueOf(this.input.readSFixed64()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt32 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt32);
            int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
            do {
                list.add(Long.valueOf(this.input.readSFixed64()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 1) {
            do {
                longArrayList.addLong(this.input.readSFixed64());
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag2 = this.input.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int readUInt322 = this.input.readUInt32();
        verifyPackedFixed64Length(readUInt322);
        int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
        do {
            longArrayList.addLong(this.input.readSFixed64());
        } while (this.input.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readSInt32() {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSInt32List(List<Integer> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    intArrayList.addInt(this.input.readSInt32());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readSInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.input.readSInt32()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Integer.valueOf(this.input.readSInt32()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readSInt64() {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readSInt64List(List<Long> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    longArrayList.addLong(this.input.readSInt64());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                longArrayList.addLong(this.input.readSInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Long.valueOf(this.input.readSInt64()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Long.valueOf(this.input.readSInt64()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public String readString() {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readStringList(List<String> list) {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z3) {
        int readTag;
        int readTag2;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (!(list instanceof LazyStringList) || z3) {
            do {
                list.add(z3 ? readStringRequireUtf8() : readString());
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.add(readBytes());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readStringListRequireUtf8(List<String> list) {
        readStringListInternal(list, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public String readStringRequireUtf8() {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public int readUInt32() {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readUInt32List(List<Integer> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    intArrayList.addInt(this.input.readUInt32());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readUInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Integer.valueOf(this.input.readUInt32()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Integer.valueOf(this.input.readUInt32()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public long readUInt64() {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public void readUInt64List(List<Long> list) {
        int readTag;
        int totalBytesRead;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 0) {
                do {
                    longArrayList.addLong(this.input.readUInt64());
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = this.input.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                longArrayList.addLong(this.input.readUInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        } else {
            int tagWireType2 = WireFormat.getTagWireType(this.tag);
            if (tagWireType2 == 0) {
                do {
                    list.add(Long.valueOf(this.input.readUInt64()));
                    if (this.input.isAtEnd()) {
                        return;
                    } else {
                        readTag = this.input.readTag();
                    }
                } while (readTag == this.tag);
                this.nextTag = readTag;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                list.add(Long.valueOf(this.input.readUInt64()));
            } while (this.input.getTotalBytesRead() < totalBytesRead);
        }
        requirePosition(totalBytesRead);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return this.input.shouldDiscardUnknownFields();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public boolean skipField() {
        int i3;
        if (this.input.isAtEnd() || (i3 = this.tag) == this.endGroupTag) {
            return false;
        }
        return this.input.skipField(i3);
    }
}
