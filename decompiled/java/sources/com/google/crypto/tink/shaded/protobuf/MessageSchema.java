package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.maps.R;
import com.google.android.gms.maps.model.PinConfig;
import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.kxml2.wap.Wbxml;
import sun.misc.Unsafe;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1, reason: invalid class name */
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i3, int i4, MessageLite messageLite, boolean z3, boolean z4, int[] iArr2, int i5, int i6, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i3;
        this.maxFieldNumber = i4;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z3;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z4;
        this.intArray = iArr2;
        this.checkInitializedCount = i5;
        this.repeatedFieldOffsetStart = i6;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t3, T t4, int i3) {
        return isFieldPresent(t3, i3) == isFieldPresent(t4, i3);
    }

    private static <T> boolean booleanAt(T t3, long j3) {
        return UnsafeUtil.getBoolean(t3, j3);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int decodeMapEntry(byte[] bArr, int i3, int i4, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) {
        int i5;
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
        int i6 = registers.int1;
        if (i6 < 0 || i6 > i4 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i7 = decodeVarint32 + i6;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (decodeVarint32 < i7) {
            int i8 = decodeVarint32 + 1;
            byte b4 = bArr[decodeVarint32];
            if (b4 < 0) {
                i5 = ArrayDecoders.decodeVarint32(b4, bArr, i8, registers);
                b4 = registers.int1;
            } else {
                i5 = i8;
            }
            int i9 = b4 >>> 3;
            int i10 = b4 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == metadata.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i5, i4, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                }
                decodeVarint32 = ArrayDecoders.skipField(b4, bArr, i5, i4, registers);
            } else if (i10 == metadata.keyType.getWireType()) {
                decodeVarint32 = decodeMapEntryValue(bArr, i5, i4, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                decodeVarint32 = ArrayDecoders.skipField(b4, bArr, i5, i4, registers);
            }
        }
        if (decodeVarint32 != i7) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i7;
    }

    private int decodeMapEntryValue(byte[] bArr, int i3, int i4, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        int decodeVarint64;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        int i5;
        long j3;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i3, registers);
                valueOf = Boolean.valueOf(registers.long1 != 0);
                registers.object1 = valueOf;
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i3, registers);
            case 3:
                valueOf2 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i3));
                registers.object1 = valueOf2;
                return i3 + 8;
            case 4:
            case 5:
                valueOf3 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i3));
                registers.object1 = valueOf3;
                return i3 + 4;
            case 6:
            case 7:
                valueOf2 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i3));
                registers.object1 = valueOf2;
                return i3 + 8;
            case 8:
                valueOf3 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i3));
                registers.object1 = valueOf3;
                return i3 + 4;
            case 9:
            case 10:
            case 11:
                decodeVarint64 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
                i5 = registers.int1;
                valueOf = Integer.valueOf(i5);
                registers.object1 = valueOf;
                return decodeVarint64;
            case 12:
            case 13:
                decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i3, registers);
                j3 = registers.long1;
                valueOf = Long.valueOf(j3);
                registers.object1 = valueOf;
                return decodeVarint64;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i3, i4, registers);
            case 15:
                decodeVarint64 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
                i5 = CodedInputStream.decodeZigZag32(registers.int1);
                valueOf = Integer.valueOf(i5);
                registers.object1 = valueOf;
                return decodeVarint64;
            case 16:
                decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i3, registers);
                j3 = CodedInputStream.decodeZigZag64(registers.long1);
                valueOf = Long.valueOf(j3);
                registers.object1 = valueOf;
                return decodeVarint64;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i3, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t3, long j3) {
        return UnsafeUtil.getDouble(t3, j3);
    }

    private boolean equals(T t3, T t4, int i3) {
        int typeAndOffsetAt = typeAndOffsetAt(i3);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t3, t4, i3) && Double.doubleToLongBits(UnsafeUtil.getDouble(t3, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t4, offset));
            case 1:
                return arePresentForEquals(t3, t4, i3) && Float.floatToIntBits(UnsafeUtil.getFloat(t3, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t4, offset));
            case 2:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getLong(t3, offset) == UnsafeUtil.getLong(t4, offset);
            case 3:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getLong(t3, offset) == UnsafeUtil.getLong(t4, offset);
            case 4:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getInt(t3, offset) == UnsafeUtil.getInt(t4, offset);
            case 5:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getLong(t3, offset) == UnsafeUtil.getLong(t4, offset);
            case 6:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getInt(t3, offset) == UnsafeUtil.getInt(t4, offset);
            case 7:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getBoolean(t3, offset) == UnsafeUtil.getBoolean(t4, offset);
            case 8:
                return arePresentForEquals(t3, t4, i3) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, offset), UnsafeUtil.getObject(t4, offset));
            case 9:
                return arePresentForEquals(t3, t4, i3) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, offset), UnsafeUtil.getObject(t4, offset));
            case 10:
                return arePresentForEquals(t3, t4, i3) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, offset), UnsafeUtil.getObject(t4, offset));
            case 11:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getInt(t3, offset) == UnsafeUtil.getInt(t4, offset);
            case 12:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getInt(t3, offset) == UnsafeUtil.getInt(t4, offset);
            case 13:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getInt(t3, offset) == UnsafeUtil.getInt(t4, offset);
            case 14:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getLong(t3, offset) == UnsafeUtil.getLong(t4, offset);
            case 15:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getInt(t3, offset) == UnsafeUtil.getInt(t4, offset);
            case 16:
                return arePresentForEquals(t3, t4, i3) && UnsafeUtil.getLong(t3, offset) == UnsafeUtil.getLong(t4, offset);
            case 17:
                return arePresentForEquals(t3, t4, i3) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, offset), UnsafeUtil.getObject(t4, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case PinConfig.BITMAP_LENGTH_DP /* 37 */:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, offset), UnsafeUtil.getObject(t4, offset));
            case ONEOF_TYPE_OFFSET /* 51 */:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case Wbxml.EXT_I_2 /* 66 */:
            case Wbxml.PI /* 67 */:
            case Wbxml.LITERAL_C /* 68 */:
                return isOneofCaseEqual(t3, t4, i3) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, offset), UnsafeUtil.getObject(t4, offset));
            default:
                return true;
        }
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i3, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i3);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i3)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i3)) == null) ? ub : (UB) filterUnknownEnumMap(i3, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i3, int i4, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i3));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i4, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t3, long j3) {
        return UnsafeUtil.getFloat(t3, j3);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i3) {
        return (Internal.EnumVerifier) this.objects[((i3 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i3) {
        return this.objects[(i3 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i3) {
        int i4 = (i3 / 3) * 2;
        Schema schema = (Schema) this.objects[i4];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i4 + 1]);
        this.objects[i4] = schemaFor;
        return schemaFor;
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01cd, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01df, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01f1, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0202, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0213, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0224, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0235, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0246, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        if (isOneofPresent(r17, r10, r5) != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0257, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0310, code lost:
    
        r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeGroupSize(r10, (com.google.crypto.tink.shaded.protobuf.MessageLite) r2.getObject(r17, r13), getMessageFieldSchema(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x030e, code lost:
    
        if ((r8 & r15) != 0) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x033b, code lost:
    
        if ((r8 & r15) != 0) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0344, code lost:
    
        if ((r8 & r15) != 0) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0369, code lost:
    
        if ((r8 & r15) != 0) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0378, code lost:
    
        if ((r8 & r15) != 0) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03a5, code lost:
    
        if ((r8 & r15) != 0) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
    
        if (isOneofPresent(r17, r10, r5) != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x033d, code lost:
    
        r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed64Size(r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        if (isOneofPresent(r17, r10, r5) != false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0346, code lost:
    
        r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed32Size(r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (isOneofPresent(r17, r10, r5) != false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x036b, code lost:
    
        r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r10, (com.google.crypto.tink.shaded.protobuf.ByteString) r2.getObject(r17, r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b8, code lost:
    
        if (isOneofPresent(r17, r10, r5) != false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x037a, code lost:
    
        r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessage(r10, r2.getObject(r17, r13), getMessageFieldSchema(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00de, code lost:
    
        if (isOneofPresent(r17, r10, r5) != false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x03a7, code lost:
    
        r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBoolSize(r10, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0173, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x025d, code lost:
    
        r4 = (com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10) + com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0259, code lost:
    
        r2.putInt(r17, r12, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0185, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0197, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a9, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01bb, code lost:
    
        if (r16.useCachedSizeField != false) goto L150;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getSerializedSizeProto2(T r17) {
        /*
            Method dump skipped, instructions count: 1198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.getSerializedSizeProto2(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x012a, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0214, code lost:
    
        r6 = (com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8) + com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0210, code lost:
    
        r2.putInt(r16, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x013c, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x014e, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0160, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0172, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0184, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0196, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01a8, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01b9, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01ca, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01db, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01ec, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01fd, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x020e, code lost:
    
        if (r15.useCachedSizeField != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0334, code lost:
    
        if ((r6 instanceof com.google.crypto.tink.shaded.protobuf.ByteString) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:
    
        if ((r6 instanceof com.google.crypto.tink.shaded.protobuf.ByteString) != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
    
        r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeStringSize(r8, (java.lang.String) r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getSerializedSizeProto3(T r16) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.getSerializedSizeProto3(java.lang.Object):int");
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t3));
    }

    private static <T> int intAt(T t3, long j3) {
        return UnsafeUtil.getInt(t3, j3);
    }

    private static boolean isEnforceUtf8(int i3) {
        return (i3 & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t3, int i3) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i3);
        long j3 = 1048575 & presenceMaskAndOffsetAt;
        if (j3 != 1048575) {
            return (UnsafeUtil.getInt(t3, j3) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int typeAndOffsetAt = typeAndOffsetAt(i3);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t3, offset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t3, offset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t3, offset) != 0;
            case 3:
                return UnsafeUtil.getLong(t3, offset) != 0;
            case 4:
                return UnsafeUtil.getInt(t3, offset) != 0;
            case 5:
                return UnsafeUtil.getLong(t3, offset) != 0;
            case 6:
                return UnsafeUtil.getInt(t3, offset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t3, offset);
            case 8:
                Object object = UnsafeUtil.getObject(t3, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t3, offset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t3, offset));
            case 11:
                return UnsafeUtil.getInt(t3, offset) != 0;
            case 12:
                return UnsafeUtil.getInt(t3, offset) != 0;
            case 13:
                return UnsafeUtil.getInt(t3, offset) != 0;
            case 14:
                return UnsafeUtil.getLong(t3, offset) != 0;
            case 15:
                return UnsafeUtil.getInt(t3, offset) != 0;
            case 16:
                return UnsafeUtil.getLong(t3, offset) != 0;
            case 17:
                return UnsafeUtil.getObject(t3, offset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean isFieldPresent(T t3, int i3, int i4, int i5, int i6) {
        return i4 == 1048575 ? isFieldPresent(t3, i3) : (i5 & i6) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i3, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i3)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i3, int i4) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i3));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!messageFieldSchema.isInitialized(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    private boolean isMapInitialized(T t3, int i3, int i4) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t3, offset(i3)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i4)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? r5 = 0;
        for (Object obj : forMapData.values()) {
            r5 = r5;
            if (r5 == 0) {
                r5 = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!r5.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t3, T t4, int i3) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i3) & 1048575;
        return UnsafeUtil.getInt(t3, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t4, presenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t3, int i3, int i4) {
        return UnsafeUtil.getInt(t3, (long) (presenceMaskAndOffsetAt(i4) & 1048575)) == i3;
    }

    private static boolean isRequired(int i3) {
        return (i3 & REQUIRED_MASK) != 0;
    }

    private static List<?> listAt(Object obj, long j3) {
        return (List) UnsafeUtil.getObject(obj, j3);
    }

    private static <T> long longAt(T t3, long j3) {
        return UnsafeUtil.getLong(t3, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:230:0x008d, code lost:
    
        r0 = r18.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0092, code lost:
    
        if (r0 >= r18.repeatedFieldOffsetStart) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0094, code lost:
    
        r4 = filterMapUnknownEnumValues(r21, r18.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x00aa, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x00ab, code lost:
    
        if (r4 == null) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x00ad, code lost:
    
        r7.setBuilderToMessage(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x00b0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0627 A[LOOP:2: B:35:0x0623->B:37:0x0627, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x05bd A[Catch: all -> 0x0615, TRY_LEAVE, TryCatch #6 {all -> 0x0615, blocks: (B:16:0x058e, B:43:0x05b7, B:45:0x05bd, B:58:0x05e5, B:59:0x05ea), top: B:15:0x058e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x05e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<UT, UB> r19, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<ET> r20, T r21, com.google.crypto.tink.shaded.protobuf.Reader r22, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r23) {
        /*
            Method dump skipped, instructions count: 1742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.mergeFromHelper(com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, java.lang.Object, com.google.crypto.tink.shaded.protobuf.Reader, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i3, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long offset = offset(typeAndOffsetAt(i3));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t3, T t4, int i3) {
        if (isFieldPresent(t4, i3)) {
            long offset = offset(typeAndOffsetAt(i3));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t4, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i3) + " is present but null: " + t4);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i3);
            if (!isFieldPresent(t3, i3)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(t3, offset, newInstance);
                } else {
                    unsafe.putObject(t3, offset, object);
                }
                setFieldPresent(t3, i3);
                return;
            }
            Object object2 = unsafe.getObject(t3, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(t3, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t3, T t4, int i3) {
        int numberAt = numberAt(i3);
        if (isOneofPresent(t4, numberAt, i3)) {
            long offset = offset(typeAndOffsetAt(i3));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t4, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i3) + " is present but null: " + t4);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i3);
            if (!isOneofPresent(t3, numberAt, i3)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(t3, offset, newInstance);
                } else {
                    unsafe.putObject(t3, offset, object);
                }
                setOneofPresent(t3, numberAt, i3);
                return;
            }
            Object object2 = unsafe.getObject(t3, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(t3, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t3, T t4, int i3) {
        int typeAndOffsetAt = typeAndOffsetAt(i3);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i3);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t4, i3)) {
                    UnsafeUtil.putDouble(t3, offset, UnsafeUtil.getDouble(t4, offset));
                    setFieldPresent(t3, i3);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t4, i3)) {
                    UnsafeUtil.putFloat(t3, offset, UnsafeUtil.getFloat(t4, offset));
                    setFieldPresent(t3, i3);
                    break;
                }
                break;
            case 2:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putLong(t3, offset, UnsafeUtil.getLong(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 3:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putLong(t3, offset, UnsafeUtil.getLong(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 4:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putInt(t3, offset, UnsafeUtil.getInt(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 5:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putLong(t3, offset, UnsafeUtil.getLong(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 6:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putInt(t3, offset, UnsafeUtil.getInt(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 7:
                if (isFieldPresent(t4, i3)) {
                    UnsafeUtil.putBoolean(t3, offset, UnsafeUtil.getBoolean(t4, offset));
                    setFieldPresent(t3, i3);
                    break;
                }
                break;
            case 8:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putObject(t3, offset, UnsafeUtil.getObject(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 9:
            case 17:
                mergeMessage(t3, t4, i3);
                break;
            case 10:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putObject(t3, offset, UnsafeUtil.getObject(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 11:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putInt(t3, offset, UnsafeUtil.getInt(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 12:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putInt(t3, offset, UnsafeUtil.getInt(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 13:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putInt(t3, offset, UnsafeUtil.getInt(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 14:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putLong(t3, offset, UnsafeUtil.getLong(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 15:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putInt(t3, offset, UnsafeUtil.getInt(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 16:
                if (!isFieldPresent(t4, i3)) {
                }
                UnsafeUtil.putLong(t3, offset, UnsafeUtil.getLong(t4, offset));
                setFieldPresent(t3, i3);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case PinConfig.BITMAP_LENGTH_DP /* 37 */:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t3, t4, offset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t3, t4, offset);
                break;
            case ONEOF_TYPE_OFFSET /* 51 */:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (!isOneofPresent(t4, numberAt, i3)) {
                }
                UnsafeUtil.putObject(t3, offset, UnsafeUtil.getObject(t4, offset));
                setOneofPresent(t3, numberAt, i3);
                break;
            case 60:
            case Wbxml.LITERAL_C /* 68 */:
                mergeOneofMessage(t3, t4, i3);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case Wbxml.EXT_I_2 /* 66 */:
            case Wbxml.PI /* 67 */:
                if (!isOneofPresent(t4, numberAt, i3)) {
                }
                UnsafeUtil.putObject(t3, offset, UnsafeUtil.getObject(t4, offset));
                setOneofPresent(t3, numberAt, i3);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t3, int i3) {
        Schema messageFieldSchema = getMessageFieldSchema(i3);
        long offset = offset(typeAndOffsetAt(i3));
        if (!isFieldPresent(t3, i3)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t3, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t3, int i3, int i4) {
        Schema messageFieldSchema = getMessageFieldSchema(i4);
        if (!isOneofPresent(t3, i3, i4)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t3, offset(typeAndOffsetAt(i4)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i3;
        boolean z3 = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i4++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = i4 > 0 ? new int[i4] : null;
        int[] iArr3 = i5 > 0 ? new int[i5] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fields.length) {
            FieldInfo fieldInfo2 = fields[i6];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i7, objArr);
            if (i8 < checkInitialized.length && checkInitialized[i8] == fieldNumber3) {
                checkInitialized[i8] = i7;
                i8++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i9] = i7;
                i9++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i3 = i7;
                iArr3[i10] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i10++;
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z3, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0250  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.crypto.tink.shaded.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.crypto.tink.shaded.protobuf.RawMessageInfo r34, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema r35, com.google.crypto.tink.shaded.protobuf.ListFieldSchema r36, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r37, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r38, com.google.crypto.tink.shaded.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instructions count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.crypto.tink.shaded.protobuf.RawMessageInfo, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema, com.google.crypto.tink.shaded.protobuf.ListFieldSchema, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, com.google.crypto.tink.shaded.protobuf.MapFieldSchema):com.google.crypto.tink.shaded.protobuf.MessageSchema");
    }

    private int numberAt(int i3) {
        return this.buffer[i3];
    }

    private static long offset(int i3) {
        return i3 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t3, long j3) {
        return ((Boolean) UnsafeUtil.getObject(t3, j3)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t3, long j3) {
        return ((Double) UnsafeUtil.getObject(t3, j3)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t3, long j3) {
        return ((Float) UnsafeUtil.getObject(t3, j3)).floatValue();
    }

    private static <T> int oneofIntAt(T t3, long j3) {
        return ((Integer) UnsafeUtil.getObject(t3, j3)).intValue();
    }

    private static <T> long oneofLongAt(T t3, long j3) {
        return ((Long) UnsafeUtil.getObject(t3, j3)).longValue();
    }

    private <K, V> int parseMapField(T t3, byte[] bArr, int i3, int i4, int i5, long j3, ArrayDecoders.Registers registers) {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i5);
        Object object = unsafe.getObject(t3, j3);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t3, j3, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i3, i4, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int parseOneofField(T t3, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, int i10, ArrayDecoders.Registers registers) {
        Object valueOf;
        Object valueOf2;
        int decodeVarint64;
        long j4;
        int i11;
        Object valueOf3;
        Object mutableOneofMessageFieldForMerge;
        int mergeMessageField;
        Unsafe unsafe = UNSAFE;
        long j5 = this.buffer[i10 + 2] & 1048575;
        switch (i9) {
            case ONEOF_TYPE_OFFSET /* 51 */:
                if (i7 == 1) {
                    valueOf = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i3));
                    unsafe.putObject(t3, j3, valueOf);
                    decodeVarint64 = i3 + 8;
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 52:
                if (i7 == 5) {
                    valueOf2 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i3));
                    unsafe.putObject(t3, j3, valueOf2);
                    decodeVarint64 = i3 + 4;
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 53:
            case 54:
                if (i7 == 0) {
                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i3, registers);
                    j4 = registers.long1;
                    valueOf3 = Long.valueOf(j4);
                    unsafe.putObject(t3, j3, valueOf3);
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 55:
            case 62:
                if (i7 == 0) {
                    decodeVarint64 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
                    i11 = registers.int1;
                    valueOf3 = Integer.valueOf(i11);
                    unsafe.putObject(t3, j3, valueOf3);
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 56:
            case 65:
                if (i7 == 1) {
                    valueOf = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i3));
                    unsafe.putObject(t3, j3, valueOf);
                    decodeVarint64 = i3 + 8;
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 57:
            case 64:
                if (i7 == 5) {
                    valueOf2 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i3));
                    unsafe.putObject(t3, j3, valueOf2);
                    decodeVarint64 = i3 + 4;
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 58:
                if (i7 == 0) {
                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i3, registers);
                    valueOf3 = Boolean.valueOf(registers.long1 != 0);
                    unsafe.putObject(t3, j3, valueOf3);
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 59:
                if (i7 == 2) {
                    decodeVarint64 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
                    int i12 = registers.int1;
                    if (i12 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t3, j3, valueOf3);
                        unsafe.putInt(t3, j5, i6);
                        return decodeVarint64;
                    }
                    if ((i8 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, decodeVarint64, decodeVarint64 + i12)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t3, j3, new String(bArr, decodeVarint64, i12, Internal.UTF_8));
                    decodeVarint64 += i12;
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 60:
                if (i7 == 2) {
                    mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t3, i6, i10);
                    mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i10), bArr, i3, i4, registers);
                    storeOneofMessageField(t3, i6, i10, mutableOneofMessageFieldForMerge);
                    return mergeMessageField;
                }
                return i3;
            case 61:
                if (i7 == 2) {
                    decodeVarint64 = ArrayDecoders.decodeBytes(bArr, i3, registers);
                    valueOf3 = registers.object1;
                    unsafe.putObject(t3, j3, valueOf3);
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case 63:
                if (i7 == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
                    int i13 = registers.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i10);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i13)) {
                        unsafe.putObject(t3, j3, Integer.valueOf(i13));
                        unsafe.putInt(t3, j5, i6);
                    } else {
                        getMutableUnknownFields(t3).storeField(i5, Long.valueOf(i13));
                    }
                    return decodeVarint32;
                }
                return i3;
            case Wbxml.EXT_I_2 /* 66 */:
                if (i7 == 0) {
                    decodeVarint64 = ArrayDecoders.decodeVarint32(bArr, i3, registers);
                    i11 = CodedInputStream.decodeZigZag32(registers.int1);
                    valueOf3 = Integer.valueOf(i11);
                    unsafe.putObject(t3, j3, valueOf3);
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case Wbxml.PI /* 67 */:
                if (i7 == 0) {
                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i3, registers);
                    j4 = CodedInputStream.decodeZigZag64(registers.long1);
                    valueOf3 = Long.valueOf(j4);
                    unsafe.putObject(t3, j3, valueOf3);
                    unsafe.putInt(t3, j5, i6);
                    return decodeVarint64;
                }
                return i3;
            case Wbxml.LITERAL_C /* 68 */:
                if (i7 == 3) {
                    mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t3, i6, i10);
                    mergeMessageField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i10), bArr, i3, i4, (i5 & (-8)) | 4, registers);
                    storeOneofMessageField(t3, i6, i10, mutableOneofMessageFieldForMerge);
                    return mergeMessageField;
                }
                return i3;
            default:
                return i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x023c, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x023e, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r1 = r19;
        r2 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02a7, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0283, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02a4, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0096. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseProto3Message(T r31, byte[] r32, int r33, int r34, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r35) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t3, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, long j3, int i9, long j4, ArrayDecoders.Registers registers) {
        int decodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t3, j4);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t3, j4, protobufList);
        }
        switch (i9) {
            case 18:
            case 35:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i3, protobufList, registers);
                }
                if (i7 == 1) {
                    return ArrayDecoders.decodeDoubleList(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i3, protobufList, registers);
                }
                if (i7 == 5) {
                    return ArrayDecoders.decodeFloatList(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case PinConfig.BITMAP_LENGTH_DP /* 37 */:
            case 38:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.decodeVarint64List(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.decodeVarint32List(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i3, protobufList, registers);
                }
                if (i7 == 1) {
                    return ArrayDecoders.decodeFixed64List(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i3, protobufList, registers);
                }
                if (i7 == 5) {
                    return ArrayDecoders.decodeFixed32List(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
            case 42:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.decodeBoolList(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                if (i7 == 2) {
                    long j5 = j3 & 536870912;
                    Internal.ProtobufList protobufList2 = protobufList;
                    return j5 == 0 ? ArrayDecoders.decodeStringList(i5, bArr, i3, i4, protobufList2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i5, bArr, i3, i4, protobufList2, registers);
                }
                break;
            case 27:
                if (i7 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i8), i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 28:
                if (i7 == 2) {
                    return ArrayDecoders.decodeBytesList(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i7 == 2) {
                    decodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i3, protobufList, registers);
                } else if (i7 == 0) {
                    decodeVarint32List = ArrayDecoders.decodeVarint32List(i5, bArr, i3, i4, protobufList, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t3, i6, (List<Integer>) protobufList, getEnumFieldVerifier(i8), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return decodeVarint32List;
            case 33:
            case 47:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.decodeSInt32List(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i7 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.decodeSInt64List(i5, bArr, i3, i4, protobufList, registers);
                }
                break;
            case 49:
                if (i7 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i8), i5, bArr, i3, i4, protobufList, registers);
                }
                break;
        }
        return i3;
    }

    private int positionForFieldNumber(int i3) {
        if (i3 < this.minFieldNumber || i3 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i3, 0);
    }

    private int positionForFieldNumber(int i3, int i4) {
        if (i3 < this.minFieldNumber || i3 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i3, i4);
    }

    private int presenceMaskAndOffsetAt(int i3) {
        return this.buffer[i3 + 2];
    }

    private <E> void readGroupList(Object obj, long j3, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j3), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i3, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i3)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i3, Reader reader) {
        long offset;
        Object readBytes;
        if (isEnforceUtf8(i3)) {
            offset = offset(i3);
            readBytes = reader.readStringRequireUtf8();
        } else if (this.lite) {
            offset = offset(i3);
            readBytes = reader.readString();
        } else {
            offset = offset(i3);
            readBytes = reader.readBytes();
        }
        UnsafeUtil.putObject(obj, offset, readBytes);
    }

    private void readStringList(Object obj, int i3, Reader reader) {
        if (isEnforceUtf8(i3)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i3)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i3)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t3, int i3) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i3);
        long j3 = 1048575 & presenceMaskAndOffsetAt;
        if (j3 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t3, j3, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t3, j3));
    }

    private void setOneofPresent(T t3, int i3, int i4) {
        UnsafeUtil.putInt(t3, presenceMaskAndOffsetAt(i4) & 1048575, i3);
    }

    private int slowPositionForFieldNumber(int i3, int i4) {
        int length = (this.buffer.length / 3) - 1;
        while (i4 <= length) {
            int i5 = (length + i4) >>> 1;
            int i6 = i5 * 3;
            int numberAt = numberAt(i6);
            if (i3 == numberAt) {
                return i6;
            }
            if (i3 < numberAt) {
                length = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.crypto.tink.shaded.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.crypto.tink.shaded.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L25
            com.google.crypto.tink.shaded.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r4 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
        L1e:
            long r5 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r5
        L23:
            r3 = 0
            goto L67
        L25:
            com.google.crypto.tink.shaded.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r4 = (int) r2
            int r2 = r0.id()
            boolean r3 = r0.isList()
            if (r3 != 0) goto L5a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L5a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L4c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L51
        L4c:
            long r5 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r5
        L51:
            int r3 = r8.getPresenceMask()
            int r3 = java.lang.Integer.numberOfTrailingZeros(r3)
            goto L67
        L5a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L62
            r0 = 0
            goto L23
        L62:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            goto L1e
        L67:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L78
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L79
        L78:
            r6 = 0
        L79:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L81
            r1 = 268435456(0x10000000, float:2.524355E-29)
        L81:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r4
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r3 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto Lb9
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto Laa
            int r10 = r10 + 1
            r11[r10] = r9
            goto Ld6
        Laa:
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ld6
            int r10 = r10 + 1
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            goto Ld6
        Lb9:
            if (r9 == 0) goto Lc4
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            goto Ld6
        Lc4:
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ld6
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.storeFieldData(com.google.crypto.tink.shaded.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t3, int i3, Object obj) {
        UNSAFE.putObject(t3, offset(typeAndOffsetAt(i3)), obj);
        setFieldPresent(t3, i3);
    }

    private void storeOneofMessageField(T t3, int i3, int i4, Object obj) {
        UNSAFE.putObject(t3, offset(typeAndOffsetAt(i4)), obj);
        setOneofPresent(t3, i3, i4);
    }

    private static int type(int i3) {
        return (i3 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i3) {
        return this.buffer[i3 + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:228:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto2(T r18, com.google.crypto.tink.shaded.protobuf.Writer r19) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:267:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto3(T r13, com.google.crypto.tink.shaded.protobuf.Writer r14) {
        /*
            Method dump skipped, instructions count: 1488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:267:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, com.google.crypto.tink.shaded.protobuf.Writer r12) {
        /*
            Method dump skipped, instructions count: 1490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i3, Object obj, int i4) {
        if (obj != null) {
            writer.writeMap(i3, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i4)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i3, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i3, (String) obj);
        } else {
            writer.writeBytes(i3, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t3), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T t3, T t4) {
        int length = this.buffer.length;
        for (int i3 = 0; i3 < length; i3 += 3) {
            if (!equals(t3, t4, i3)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t3).equals(this.unknownFieldSchema.getFromMessage(t4))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t3).equals(this.extensionSchema.getExtensions(t4));
        }
        return true;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T t3) {
        return this.proto3 ? getSerializedSizeProto3(t3) : getSerializedSizeProto2(t3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00cc, code lost:
    
        if (r3 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e4, code lost:
    
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e0, code lost:
    
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00de, code lost:
    
        if (r3 != null) goto L68;
     */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int hashCode(T r9) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T t3) {
        int i3;
        int i4;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < this.checkInitializedCount) {
            int i8 = this.intArray[i7];
            int numberAt = numberAt(i8);
            int typeAndOffsetAt = typeAndOffsetAt(i8);
            int i9 = this.buffer[i8 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i5) {
                if (i10 != 1048575) {
                    i6 = UNSAFE.getInt(t3, i10);
                }
                i4 = i6;
                i3 = i10;
            } else {
                i3 = i5;
                i4 = i6;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t3, i8, i3, i4, i11)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t3, numberAt, i8) && !isInitialized(t3, typeAndOffsetAt, getMessageFieldSchema(i8))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t3, typeAndOffsetAt, i8)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t3, typeAndOffsetAt, i8)) {
                    return false;
                }
            } else if (isFieldPresent(t3, i8, i3, i4, i11) && !isInitialized(t3, typeAndOffsetAt, getMessageFieldSchema(i8))) {
                return false;
            }
            i7++;
            i5 = i3;
            i6 = i4;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t3).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T t3) {
        if (isMutable(t3)) {
            if (t3 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t3;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i3 = 0; i3 < length; i3 += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i3);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    switch (type) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case R.styleable.MapAttrs_zOrderOnTop /* 25 */:
                        case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.listFieldSchema.makeImmutableListAt(t3, offset);
                            break;
                        case 50:
                            Unsafe unsafe = UNSAFE;
                            Object object = unsafe.getObject(t3, offset);
                            if (object != null) {
                                unsafe.putObject(t3, offset, this.mapFieldSchema.toImmutable(object));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                if (isFieldPresent(t3, i3)) {
                    getMessageFieldSchema(i3).makeImmutable(UNSAFE.getObject(t3, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t3);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t3);
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        checkMutable(t3);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t3, reader, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t3, T t4) {
        checkMutable(t3);
        t4.getClass();
        for (int i3 = 0; i3 < this.buffer.length; i3 += 3) {
            mergeSingleField(t3, t4, i3);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t3, t4);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t3, t4);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T t3, byte[] bArr, int i3, int i4, ArrayDecoders.Registers registers) {
        if (this.proto3) {
            parseProto3Message(t3, bArr, i3, i4, registers);
        } else {
            parseProto2Message(t3, bArr, i3, i4, 0, registers);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:97:0x008e. Please report as an issue. */
    int parseProto2Message(T t3, byte[] bArr, int i3, int i4, int i5, ArrayDecoders.Registers registers) {
        Unsafe unsafe;
        int i6;
        MessageSchema<T> messageSchema;
        int i7;
        int i8;
        int i9;
        int i10;
        T t4;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        byte[] bArr2;
        long j3;
        int decodeVarint64;
        Unsafe unsafe2;
        T t5;
        long j4;
        int i22;
        long j5;
        long j6;
        int i23;
        int i24;
        MessageSchema<T> messageSchema2 = this;
        T t6 = t3;
        byte[] bArr3 = bArr;
        int i25 = i4;
        int i26 = i5;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(t3);
        Unsafe unsafe3 = UNSAFE;
        int i27 = i3;
        int i28 = -1;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 1048575;
        while (true) {
            if (i27 < i25) {
                int i33 = i27 + 1;
                byte b4 = bArr3[i27];
                if (b4 < 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(b4, bArr3, i33, registers2);
                    i11 = registers2.int1;
                    i33 = decodeVarint32;
                } else {
                    i11 = b4;
                }
                int i34 = i11 >>> 3;
                int i35 = i11 & 7;
                int positionForFieldNumber = i34 > i28 ? messageSchema2.positionForFieldNumber(i34, i29 / 3) : messageSchema2.positionForFieldNumber(i34);
                if (positionForFieldNumber == -1) {
                    i12 = i34;
                    i13 = i33;
                    i8 = i11;
                    i14 = i31;
                    i15 = i32;
                    unsafe = unsafe3;
                    i6 = i26;
                    i16 = 0;
                } else {
                    int i36 = messageSchema2.buffer[positionForFieldNumber + 1];
                    int type = type(i36);
                    long offset = offset(i36);
                    int i37 = i11;
                    if (type <= 17) {
                        int i38 = messageSchema2.buffer[positionForFieldNumber + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i32) {
                            if (i32 != 1048575) {
                                unsafe3.putInt(t6, i32, i31);
                            }
                            i18 = i40;
                            i17 = unsafe3.getInt(t6, i40);
                        } else {
                            i17 = i31;
                            i18 = i32;
                        }
                        switch (type) {
                            case 0:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 1) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    UnsafeUtil.putDouble(t6, offset, ArrayDecoders.decodeDouble(bArr2, i33));
                                    i27 = i33 + 8;
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 1:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 5) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    UnsafeUtil.putFloat(t6, offset, ArrayDecoders.decodeFloat(bArr2, i33));
                                    i27 = i33 + 4;
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                j3 = offset;
                                if (i35 != 0) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i33, registers2);
                                    unsafe2 = unsafe3;
                                    t5 = t3;
                                    j4 = registers2.long1;
                                    unsafe2.putLong(t5, j3, j4);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i27 = decodeVarint64;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 0) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    i27 = ArrayDecoders.decodeVarint32(bArr2, i33, registers2);
                                    i22 = registers2.int1;
                                    j5 = offset;
                                    unsafe3.putInt(t6, j5, i22);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 1) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    unsafe3.putLong(t3, offset, ArrayDecoders.decodeFixed64(bArr2, i33));
                                    i27 = i33 + 8;
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 5) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    unsafe3.putInt(t6, offset, ArrayDecoders.decodeFixed32(bArr2, i33));
                                    i27 = i33 + 4;
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 7:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 0) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    i27 = ArrayDecoders.decodeVarint64(bArr2, i33, registers2);
                                    UnsafeUtil.putBoolean(t6, offset, registers2.long1 != 0);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 8:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                j6 = offset;
                                if (i35 != 2) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    i27 = (ENFORCE_UTF8_MASK & i36) == 0 ? ArrayDecoders.decodeString(bArr2, i33, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i33, registers2);
                                    unsafe3.putObject(t6, j6, registers2.object1);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 9:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                if (i35 != 2) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    Object mutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t6, i19);
                                    i27 = ArrayDecoders.mergeMessageField(mutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i19), bArr, i33, i4, registers);
                                    messageSchema2.storeMessageField(t6, i19, mutableMessageFieldForMerge);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 10:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                j6 = offset;
                                if (i35 != 2) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    i27 = ArrayDecoders.decodeBytes(bArr2, i33, registers2);
                                    unsafe3.putObject(t6, j6, registers2.object1);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 12:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                j5 = offset;
                                if (i35 != 0) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    i27 = ArrayDecoders.decodeVarint32(bArr2, i33, registers2);
                                    i22 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i19);
                                    if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i22)) {
                                        getMutableUnknownFields(t3).storeField(i21, Long.valueOf(i22));
                                        i29 = i19;
                                        i31 = i17;
                                        i30 = i21;
                                        i28 = i12;
                                        i26 = i5;
                                        bArr3 = bArr2;
                                        i32 = i20;
                                    }
                                    unsafe3.putInt(t6, j5, i22);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                j5 = offset;
                                if (i35 != 0) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    i27 = ArrayDecoders.decodeVarint32(bArr2, i33, registers2);
                                    i22 = CodedInputStream.decodeZigZag32(registers2.int1);
                                    unsafe3.putInt(t6, j5, i22);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 16:
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                bArr2 = bArr;
                                if (i35 != 0) {
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    j3 = offset;
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i33, registers2);
                                    j4 = CodedInputStream.decodeZigZag64(registers2.long1);
                                    unsafe2 = unsafe3;
                                    t5 = t3;
                                    unsafe2.putLong(t5, j3, j4);
                                    i31 = i17 | i39;
                                    i26 = i5;
                                    i27 = decodeVarint64;
                                    i29 = i19;
                                    i30 = i21;
                                    i28 = i12;
                                    bArr3 = bArr2;
                                    i32 = i20;
                                }
                            case 17:
                                if (i35 != 3) {
                                    i12 = i34;
                                    i19 = positionForFieldNumber;
                                    i20 = i18;
                                    i21 = i37;
                                    i15 = i20;
                                    i13 = i33;
                                    i16 = i19;
                                    unsafe = unsafe3;
                                    i14 = i17;
                                    i8 = i21;
                                    i6 = i5;
                                    break;
                                } else {
                                    Object mutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t6, positionForFieldNumber);
                                    i27 = ArrayDecoders.mergeGroupField(mutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(positionForFieldNumber), bArr, i33, i4, (i34 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t6, positionForFieldNumber, mutableMessageFieldForMerge2);
                                    i31 = i17 | i39;
                                    i32 = i18;
                                    i26 = i5;
                                    i29 = positionForFieldNumber;
                                    i30 = i37;
                                    i28 = i34;
                                    bArr3 = bArr;
                                }
                            default:
                                i12 = i34;
                                i19 = positionForFieldNumber;
                                i20 = i18;
                                i21 = i37;
                                i15 = i20;
                                i13 = i33;
                                i16 = i19;
                                unsafe = unsafe3;
                                i14 = i17;
                                i8 = i21;
                                i6 = i5;
                                break;
                        }
                    } else {
                        i12 = i34;
                        i15 = i32;
                        i14 = i31;
                        if (type == 27) {
                            if (i35 == 2) {
                                Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe3.getObject(t6, offset);
                                if (!protobufList.isModifiable()) {
                                    int size = protobufList.size();
                                    protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe3.putObject(t6, offset, protobufList);
                                }
                                i27 = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(positionForFieldNumber), i37, bArr, i33, i4, protobufList, registers);
                                i29 = positionForFieldNumber;
                                i30 = i37;
                                i32 = i15;
                                i31 = i14;
                                i28 = i12;
                                bArr3 = bArr;
                                i26 = i5;
                            } else {
                                i23 = i33;
                                unsafe = unsafe3;
                                i16 = positionForFieldNumber;
                                i24 = i37;
                                i6 = i5;
                                i13 = i23;
                            }
                        } else if (type <= 49) {
                            int i41 = i33;
                            unsafe = unsafe3;
                            i16 = positionForFieldNumber;
                            i24 = i37;
                            i27 = parseRepeatedField(t3, bArr, i33, i4, i37, i12, i35, positionForFieldNumber, i36, type, offset, registers);
                            if (i27 != i41) {
                                messageSchema2 = this;
                                t6 = t3;
                                bArr3 = bArr;
                                i25 = i4;
                                i26 = i5;
                                registers2 = registers;
                                i32 = i15;
                                i31 = i14;
                                i29 = i16;
                                i30 = i24;
                                i28 = i12;
                                unsafe3 = unsafe;
                            } else {
                                i6 = i5;
                                i13 = i27;
                            }
                        } else {
                            i23 = i33;
                            unsafe = unsafe3;
                            i16 = positionForFieldNumber;
                            i24 = i37;
                            if (type != 50) {
                                i27 = parseOneofField(t3, bArr, i23, i4, i24, i12, i35, i36, type, offset, i16, registers);
                                if (i27 != i23) {
                                    messageSchema2 = this;
                                    t6 = t3;
                                    bArr3 = bArr;
                                    i25 = i4;
                                    i26 = i5;
                                    registers2 = registers;
                                    i32 = i15;
                                    i31 = i14;
                                    i29 = i16;
                                    i30 = i24;
                                    i28 = i12;
                                    unsafe3 = unsafe;
                                } else {
                                    i6 = i5;
                                    i13 = i27;
                                }
                            } else if (i35 == 2) {
                                i27 = parseMapField(t3, bArr, i23, i4, i16, offset, registers);
                                if (i27 != i23) {
                                    messageSchema2 = this;
                                    t6 = t3;
                                    bArr3 = bArr;
                                    i25 = i4;
                                    i26 = i5;
                                    registers2 = registers;
                                    i32 = i15;
                                    i31 = i14;
                                    i29 = i16;
                                    i30 = i24;
                                    i28 = i12;
                                    unsafe3 = unsafe;
                                } else {
                                    i6 = i5;
                                    i13 = i27;
                                }
                            } else {
                                i6 = i5;
                                i13 = i23;
                            }
                        }
                        i8 = i24;
                    }
                }
                if (i8 != i6 || i6 == 0) {
                    i27 = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i8, bArr, i13, i4, getMutableUnknownFields(t3), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i8, bArr, i13, i4, t3, this.defaultInstance, this.unknownFieldSchema, registers);
                    t6 = t3;
                    bArr3 = bArr;
                    i25 = i4;
                    i30 = i8;
                    messageSchema2 = this;
                    registers2 = registers;
                    i32 = i15;
                    i31 = i14;
                    i29 = i16;
                    i28 = i12;
                    unsafe3 = unsafe;
                    i26 = i6;
                } else {
                    i10 = 1048575;
                    messageSchema = this;
                    i7 = i13;
                    i9 = i15;
                    i31 = i14;
                }
            } else {
                int i42 = i32;
                unsafe = unsafe3;
                i6 = i26;
                messageSchema = messageSchema2;
                i7 = i27;
                i8 = i30;
                i9 = i42;
                i10 = 1048575;
            }
        }
        if (i9 != i10) {
            t4 = t3;
            unsafe.putInt(t4, i9, i31);
        } else {
            t4 = t3;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i43 = messageSchema.checkInitializedCount; i43 < messageSchema.repeatedFieldOffsetStart; i43++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(t3, messageSchema.intArray[i43], unknownFieldSetLite, messageSchema.unknownFieldSchema, t3);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t4, unknownFieldSetLite);
        }
        if (i6 == 0) {
            if (i7 != i4) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i7 > i4 || i8 != i6) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i7;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T t3, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t3, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t3, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t3, writer);
        }
    }
}
