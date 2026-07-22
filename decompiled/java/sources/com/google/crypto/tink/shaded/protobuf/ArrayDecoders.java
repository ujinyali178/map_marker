package com.google.crypto.tink.shaded.protobuf;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.WireFormat;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class ArrayDecoders {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ArrayDecoders$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    private ArrayDecoders() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r12.long1 == 0) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0013, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x000e, code lost:
    
        if (r12.long1 != 0) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r11.addBoolean(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r9 >= r10) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r0 = decodeVarint32(r8, r9, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r7 == r12.int1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r9 = decodeVarint64(r8, r0, r12);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0029 -> B:3:0x0010). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int decodeBoolList(int r7, byte[] r8, int r9, int r10, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList<?> r11, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r12) {
        /*
            com.google.crypto.tink.shaded.protobuf.BooleanArrayList r11 = (com.google.crypto.tink.shaded.protobuf.BooleanArrayList) r11
            int r9 = decodeVarint64(r8, r9, r12)
            long r0 = r12.long1
            r2 = 1
            r3 = 0
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L12
        L10:
            r0 = 1
            goto L13
        L12:
            r0 = 0
        L13:
            r11.addBoolean(r0)
            if (r9 >= r10) goto L2c
            int r0 = decodeVarint32(r8, r9, r12)
            int r1 = r12.int1
            if (r7 == r1) goto L21
            goto L2c
        L21:
            int r9 = decodeVarint64(r8, r0, r12)
            long r0 = r12.long1
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L12
            goto L10
        L2c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeBoolList(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    static int decodeBytes(byte[] bArr, int i3, Registers registers) {
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i4 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i4 == 0) {
            registers.object1 = ByteString.EMPTY;
            return decodeVarint32;
        }
        registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, i4);
        return decodeVarint32 + i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        if (r2 == r7.int1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r4 = decodeVarint32(r3, r0, r7);
        r0 = r7.int1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        if (r0 < 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r0 > (r3.length - r4)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r0 != 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0014, code lost:
    
        r6.add(com.google.crypto.tink.shaded.protobuf.ByteString.copyFrom(r3, r4, r0));
        r4 = r4 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        throw com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.truncatedMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        throw com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x001c, code lost:
    
        r6.add(com.google.crypto.tink.shaded.protobuf.ByteString.copyFrom(r3, r4, r0));
        r4 = r4 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        if (r0 == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        r6.add(com.google.crypto.tink.shaded.protobuf.ByteString.EMPTY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (r4 >= r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        r0 = decodeVarint32(r3, r4, r7);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0033 -> B:6:0x000e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int decodeBytesList(int r2, byte[] r3, int r4, int r5, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList<?> r6, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r7) {
        /*
            int r4 = decodeVarint32(r3, r4, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L46
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L41
            if (r0 != 0) goto L14
        Le:
            com.google.crypto.tink.shaded.protobuf.ByteString r0 = com.google.crypto.tink.shaded.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L1c
        L14:
            com.google.crypto.tink.shaded.protobuf.ByteString r1 = com.google.crypto.tink.shaded.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            int r4 = r4 + r0
        L1c:
            if (r4 >= r5) goto L40
            int r0 = decodeVarint32(r3, r4, r7)
            int r1 = r7.int1
            if (r2 == r1) goto L27
            goto L40
        L27:
            int r4 = decodeVarint32(r3, r0, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L3b
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L36
            if (r0 != 0) goto L14
            goto Le
        L36:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L3b:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        L40:
            return r4
        L41:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L46:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r2 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeBytesList(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    static double decodeDouble(byte[] bArr, int i3) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i3));
    }

    static int decodeDoubleList(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i4));
        int i6 = i4 + 8;
        while (i6 < i5) {
            int decodeVarint32 = decodeVarint32(bArr, i6, registers);
            if (i3 != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            i6 = decodeVarint32 + 8;
        }
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int decodeExtension(int r8, byte[] r9, int r10, int r11, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r12, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r13, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite, com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite> r14, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r15) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeExtension(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtendableMessage, com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$GeneratedExtension, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    static int decodeExtensionOrUnknownField(int i3, byte[] bArr, int i4, int i5, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i3 >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i3, bArr, i4, i5, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i3, bArr, i4, i5, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    static int decodeFixed32(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i3] & UnsignedBytes.MAX_VALUE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    static int decodeFixed32List(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i4));
        int i6 = i4 + 4;
        while (i6 < i5) {
            int decodeVarint32 = decodeVarint32(bArr, i6, registers);
            if (i3 != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            i6 = decodeVarint32 + 4;
        }
        return i6;
    }

    static long decodeFixed64(byte[] bArr, int i3) {
        return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
    }

    static int decodeFixed64List(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i4));
        int i6 = i4 + 8;
        while (i6 < i5) {
            int decodeVarint32 = decodeVarint32(bArr, i6, registers);
            if (i3 != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            i6 = decodeVarint32 + 8;
        }
        return i6;
    }

    static float decodeFloat(byte[] bArr, int i3) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i3));
    }

    static int decodeFloatList(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i4));
        int i6 = i4 + 4;
        while (i6 < i5) {
            int decodeVarint32 = decodeVarint32(bArr, i6, registers);
            if (i3 != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            i6 = decodeVarint32 + 4;
        }
        return i6;
    }

    static int decodeGroupField(Schema schema, byte[] bArr, int i3, int i4, int i5, Registers registers) {
        Object newInstance = schema.newInstance();
        int mergeGroupField = mergeGroupField(newInstance, schema, bArr, i3, i4, i5, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return mergeGroupField;
    }

    static int decodeGroupList(Schema schema, int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        int i6 = (i3 & (-8)) | 4;
        int decodeGroupField = decodeGroupField(schema, bArr, i4, i5, i6, registers);
        while (true) {
            protobufList.add(registers.object1);
            if (decodeGroupField >= i5) {
                break;
            }
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, registers);
            if (i3 != registers.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema, bArr, decodeVarint32, i5, i6, registers);
        }
        return decodeGroupField;
    }

    static int decodeMessageField(Schema schema, byte[] bArr, int i3, int i4, Registers registers) {
        Object newInstance = schema.newInstance();
        int mergeMessageField = mergeMessageField(newInstance, schema, bArr, i3, i4, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return mergeMessageField;
    }

    static int decodeMessageList(Schema<?> schema, int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        int decodeMessageField = decodeMessageField(schema, bArr, i4, i5, registers);
        while (true) {
            protobufList.add(registers.object1);
            if (decodeMessageField >= i5) {
                break;
            }
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (i3 != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, i5, registers);
        }
        return decodeMessageField;
    }

    static int decodePackedBoolList(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint32List(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] bArr, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i4) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == i4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodeSInt32List(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i4, registers);
        while (true) {
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
            if (decodeVarint32 >= i5) {
                break;
            }
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i3 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
        }
        return decodeVarint32;
    }

    static int decodeSInt64List(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i4, registers);
        while (true) {
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
            if (decodeVarint64 >= i5) {
                break;
            }
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i3 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
        }
        return decodeVarint64;
    }

    static int decodeString(byte[] bArr, int i3, Registers registers) {
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i4 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        }
        registers.object1 = new String(bArr, decodeVarint32, i4, Internal.UTF_8);
        return decodeVarint32 + i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002e -> B:5:0x000c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int decodeStringList(int r4, byte[] r5, int r6, int r7, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList<?> r8, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r9) {
        /*
            int r6 = decodeVarint32(r5, r6, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L3f
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
        Lc:
            r8.add(r1)
            goto L1b
        L10:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.crypto.tink.shaded.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
        L17:
            r8.add(r2)
            int r6 = r6 + r0
        L1b:
            if (r6 >= r7) goto L3e
            int r0 = decodeVarint32(r5, r6, r9)
            int r2 = r9.int1
            if (r4 == r2) goto L26
            goto L3e
        L26:
            int r6 = decodeVarint32(r5, r0, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L39
            if (r0 != 0) goto L31
            goto Lc
        L31:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.crypto.tink.shaded.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            goto L17
        L39:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r4 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L3e:
            return r6
        L3f:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r4 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeStringList(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:5:0x000c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int decodeStringListRequireUtf8(int r5, byte[] r6, int r7, int r8, com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList<?> r9, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r10) {
        /*
            int r7 = decodeVarint32(r6, r7, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L59
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
        Lc:
            r9.add(r1)
            goto L23
        L10:
            int r2 = r7 + r0
            boolean r3 = com.google.crypto.tink.shaded.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L54
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.crypto.tink.shaded.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
        L1f:
            r9.add(r3)
            r7 = r2
        L23:
            if (r7 >= r8) goto L53
            int r0 = decodeVarint32(r6, r7, r10)
            int r2 = r10.int1
            if (r5 == r2) goto L2e
            goto L53
        L2e:
            int r7 = decodeVarint32(r6, r0, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L4e
            if (r0 != 0) goto L39
            goto Lc
        L39:
            int r2 = r7 + r0
            boolean r3 = com.google.crypto.tink.shaded.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L49
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.crypto.tink.shaded.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            goto L1f
        L49:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L4e:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        L53:
            return r7
        L54:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L59:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r5 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeStringListRequireUtf8(int, byte[], int, int, com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    static int decodeStringRequireUtf8(byte[] bArr, int i3, Registers registers) {
        int decodeVarint32 = decodeVarint32(bArr, i3, registers);
        int i4 = registers.int1;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i4 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        }
        registers.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i4);
        return decodeVarint32 + i4;
    }

    static int decodeUnknownField(int i3, byte[] bArr, int i4, int i5, UnknownFieldSetLite unknownFieldSetLite, Registers registers) {
        if (WireFormat.getTagFieldNumber(i3) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i3);
        if (tagWireType == 0) {
            int decodeVarint64 = decodeVarint64(bArr, i4, registers);
            unknownFieldSetLite.storeField(i3, Long.valueOf(registers.long1));
            return decodeVarint64;
        }
        if (tagWireType == 1) {
            unknownFieldSetLite.storeField(i3, Long.valueOf(decodeFixed64(bArr, i4)));
            return i4 + 8;
        }
        if (tagWireType == 2) {
            int decodeVarint32 = decodeVarint32(bArr, i4, registers);
            int i6 = registers.int1;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i6 > bArr.length - decodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            unknownFieldSetLite.storeField(i3, i6 == 0 ? ByteString.EMPTY : ByteString.copyFrom(bArr, decodeVarint32, i6));
            return decodeVarint32 + i6;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            unknownFieldSetLite.storeField(i3, Integer.valueOf(decodeFixed32(bArr, i4)));
            return i4 + 4;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        int i7 = (i3 & (-8)) | 4;
        int i8 = 0;
        while (true) {
            if (i4 >= i5) {
                break;
            }
            int decodeVarint322 = decodeVarint32(bArr, i4, registers);
            int i9 = registers.int1;
            i8 = i9;
            if (i9 == i7) {
                i4 = decodeVarint322;
                break;
            }
            int decodeUnknownField = decodeUnknownField(i8, bArr, decodeVarint322, i5, newInstance, registers);
            i8 = i9;
            i4 = decodeUnknownField;
        }
        if (i4 > i5 || i8 != i7) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        unknownFieldSetLite.storeField(i3, newInstance);
        return i4;
    }

    static int decodeVarint32(int i3, byte[] bArr, int i4, Registers registers) {
        int i5;
        int i6;
        int i7 = i3 & 127;
        int i8 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 < 0) {
            int i9 = i7 | ((b4 & Ascii.DEL) << 7);
            int i10 = i8 + 1;
            byte b5 = bArr[i8];
            if (b5 >= 0) {
                i5 = b5 << Ascii.SO;
            } else {
                i7 = i9 | ((b5 & Ascii.DEL) << 14);
                i8 = i10 + 1;
                byte b6 = bArr[i10];
                if (b6 >= 0) {
                    i6 = b6 << Ascii.NAK;
                } else {
                    i9 = i7 | ((b6 & Ascii.DEL) << 21);
                    i10 = i8 + 1;
                    byte b7 = bArr[i8];
                    if (b7 >= 0) {
                        i5 = b7 << Ascii.FS;
                    } else {
                        int i11 = i9 | ((b7 & Ascii.DEL) << 28);
                        while (true) {
                            int i12 = i10 + 1;
                            if (bArr[i10] >= 0) {
                                registers.int1 = i11;
                                return i12;
                            }
                            i10 = i12;
                        }
                    }
                }
            }
            registers.int1 = i9 | i5;
            return i10;
        }
        i6 = b4 << 7;
        registers.int1 = i7 | i6;
        return i8;
    }

    static int decodeVarint32(byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        byte b4 = bArr[i3];
        if (b4 < 0) {
            return decodeVarint32(b4, bArr, i4, registers);
        }
        registers.int1 = b4;
        return i4;
    }

    static int decodeVarint32List(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i4, registers);
        while (true) {
            intArrayList.addInt(registers.int1);
            if (decodeVarint32 >= i5) {
                break;
            }
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i3 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
        }
        return decodeVarint32;
    }

    static int decodeVarint64(long j3, byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        byte b4 = bArr[i3];
        long j4 = (j3 & 127) | ((b4 & Ascii.DEL) << 7);
        int i5 = 7;
        while (b4 < 0) {
            int i6 = i4 + 1;
            byte b5 = bArr[i4];
            i5 += 7;
            j4 |= (b5 & Ascii.DEL) << i5;
            i4 = i6;
            b4 = b5;
        }
        registers.long1 = j4;
        return i4;
    }

    static int decodeVarint64(byte[] bArr, int i3, Registers registers) {
        int i4 = i3 + 1;
        long j3 = bArr[i3];
        if (j3 < 0) {
            return decodeVarint64(j3, bArr, i4, registers);
        }
        registers.long1 = j3;
        return i4;
    }

    static int decodeVarint64List(int i3, byte[] bArr, int i4, int i5, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i4, registers);
        while (true) {
            longArrayList.addLong(registers.long1);
            if (decodeVarint64 >= i5) {
                break;
            }
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i3 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
        }
        return decodeVarint64;
    }

    static int mergeGroupField(Object obj, Schema schema, byte[] bArr, int i3, int i4, int i5, Registers registers) {
        int parseProto2Message = ((MessageSchema) schema).parseProto2Message(obj, bArr, i3, i4, i5, registers);
        registers.object1 = obj;
        return parseProto2Message;
    }

    static int mergeMessageField(Object obj, Schema schema, byte[] bArr, int i3, int i4, Registers registers) {
        int i5 = i3 + 1;
        int i6 = bArr[i3];
        if (i6 < 0) {
            i5 = decodeVarint32(i6, bArr, i5, registers);
            i6 = registers.int1;
        }
        int i7 = i5;
        if (i6 < 0 || i6 > i4 - i7) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i8 = i6 + i7;
        schema.mergeFrom(obj, bArr, i7, i8, registers);
        registers.object1 = obj;
        return i8;
    }

    static int skipField(int i3, byte[] bArr, int i4, int i5, Registers registers) {
        if (WireFormat.getTagFieldNumber(i3) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i3);
        if (tagWireType == 0) {
            return decodeVarint64(bArr, i4, registers);
        }
        if (tagWireType == 1) {
            return i4 + 8;
        }
        if (tagWireType == 2) {
            return decodeVarint32(bArr, i4, registers) + registers.int1;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                return i4 + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i6 = (i3 & (-8)) | 4;
        int i7 = 0;
        while (i4 < i5) {
            i4 = decodeVarint32(bArr, i4, registers);
            i7 = registers.int1;
            if (i7 == i6) {
                break;
            }
            i4 = skipField(i7, bArr, i4, i5, registers);
        }
        if (i4 > i5 || i7 != i6) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i4;
    }
}
