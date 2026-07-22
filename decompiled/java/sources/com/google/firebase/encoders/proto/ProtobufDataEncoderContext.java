package com.google.firebase.encoders.proto;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    private final ObjectEncoder<Object> fallbackEncoder;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private OutputStream output;
    private final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final FieldDescriptor MAP_KEY_DESC = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();
    private static final FieldDescriptor MAP_VALUE_DESC = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();
    private static final ObjectEncoder<Map.Entry<Object, Object>> DEFAULT_MAP_ENCODER = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.a
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            ProtobufDataEncoderContext.lambda$static$0((Map.Entry) obj, objectEncoderContext);
        }
    };

    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.output = outputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    private static ByteBuffer allocateBuffer(int i3) {
        return ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long determineSize(ObjectEncoder<T> objectEncoder, T t3) {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.output;
            this.output = lengthCountingOutputStream;
            try {
                objectEncoder.encode(t3, this);
                this.output = outputStream;
                long length = lengthCountingOutputStream.getLength();
                lengthCountingOutputStream.close();
                return length;
            } catch (Throwable th) {
                this.output = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private <T> ProtobufDataEncoderContext doEncode(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t3, boolean z3) {
        long determineSize = determineSize(objectEncoder, t3);
        if (z3 && determineSize == 0) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
        writeVarInt64(determineSize);
        objectEncoder.encode(t3, this);
        return this;
    }

    private <T> ProtobufDataEncoderContext doEncode(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t3, boolean z3) {
        this.valueEncoderContext.resetContext(fieldDescriptor, z3);
        valueEncoder.encode(t3, this.valueEncoderContext);
        return this;
    }

    private static Protobuf getProtobuf(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Map.Entry entry, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(MAP_KEY_DESC, entry.getKey());
        objectEncoderContext.add(MAP_VALUE_DESC, entry.getValue());
    }

    private void writeVarInt32(int i3) {
        while (true) {
            long j3 = i3 & (-128);
            OutputStream outputStream = this.output;
            if (j3 == 0) {
                outputStream.write(i3 & 127);
                return;
            } else {
                outputStream.write((i3 & 127) | 128);
                i3 >>>= 7;
            }
        }
    }

    private void writeVarInt64(long j3) {
        while (true) {
            long j4 = (-128) & j3;
            OutputStream outputStream = this.output;
            if (j4 == 0) {
                outputStream.write(((int) j3) & 127);
                return;
            } else {
                outputStream.write((((int) j3) & 127) | 128);
                j3 >>>= 7;
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d3) {
        return add(fieldDescriptor, d3, true);
    }

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d3, boolean z3) {
        if (z3 && d3 == 0.0d) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
        this.output.write(allocateBuffer(8).putDouble(d3).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f3) {
        return add(fieldDescriptor, f3, true);
    }

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f3, boolean z3) {
        if (z3 && f3 == BitmapDescriptorFactory.HUE_RED) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
        this.output.write(allocateBuffer(4).putFloat(f3).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return add(fieldDescriptor, obj, true);
    }

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj, boolean z3) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z3 && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                doEncode((ObjectEncoder<FieldDescriptor>) DEFAULT_MAP_ENCODER, fieldDescriptor, (FieldDescriptor) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return add(fieldDescriptor, ((Double) obj).doubleValue(), z3);
        }
        if (obj instanceof Float) {
            return add(fieldDescriptor, ((Float) obj).floatValue(), z3);
        }
        if (obj instanceof Number) {
            return add(fieldDescriptor, ((Number) obj).longValue(), z3);
        }
        if (obj instanceof Boolean) {
            return add(fieldDescriptor, ((Boolean) obj).booleanValue(), z3);
        }
        if (!(obj instanceof byte[])) {
            ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
            if (objectEncoder != null) {
                return doEncode((ObjectEncoder<FieldDescriptor>) objectEncoder, fieldDescriptor, (FieldDescriptor) obj, z3);
            }
            ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
            return valueEncoder != null ? doEncode((ValueEncoder<FieldDescriptor>) valueEncoder, fieldDescriptor, (FieldDescriptor) obj, z3) : obj instanceof ProtoEnum ? add(fieldDescriptor, ((ProtoEnum) obj).getNumber()) : obj instanceof Enum ? add(fieldDescriptor, ((Enum) obj).ordinal()) : doEncode((ObjectEncoder<FieldDescriptor>) this.fallbackEncoder, fieldDescriptor, (FieldDescriptor) obj, z3);
        }
        byte[] bArr = (byte[]) obj;
        if (z3 && bArr.length == 0) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
        writeVarInt32(bArr.length);
        this.output.write(bArr);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, double d3) {
        return add(FieldDescriptor.of(str), d3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, int i3) {
        return add(FieldDescriptor.of(str), i3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, long j3) {
        return add(FieldDescriptor.of(str), j3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, Object obj) {
        return add(FieldDescriptor.of(str), obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String str, boolean z3) {
        return add(FieldDescriptor.of(str), z3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i3) {
        return add(fieldDescriptor, i3, true);
    }

    ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i3, boolean z3) {
        if (z3 && i3 == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int i4 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobuf.intEncoding().ordinal()];
        if (i4 == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32(i3);
        } else if (i4 == 2) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32((i3 << 1) ^ (i3 >> 31));
        } else if (i4 == 3) {
            writeVarInt32((protobuf.tag() << 3) | 5);
            this.output.write(allocateBuffer(4).putInt(i3).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long j3) {
        return add(fieldDescriptor, j3, true);
    }

    ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long j3, boolean z3) {
        if (z3 && j3 == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int i3 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobuf.intEncoding().ordinal()];
        if (i3 == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64(j3);
        } else if (i3 == 2) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64((j3 >> 63) ^ (j3 << 1));
        } else if (i3 == 3) {
            writeVarInt32((protobuf.tag() << 3) | 1);
            this.output.write(allocateBuffer(8).putLong(j3).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z3) {
        return add(fieldDescriptor, z3, true);
    }

    ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z3, boolean z4) {
        return add(fieldDescriptor, z3 ? 1 : 0, z4);
    }

    ProtobufDataEncoderContext encode(Object obj) {
        if (obj == null) {
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext inline(Object obj) {
        return encode(obj);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(String str) {
        return nested(FieldDescriptor.of(str));
    }
}
