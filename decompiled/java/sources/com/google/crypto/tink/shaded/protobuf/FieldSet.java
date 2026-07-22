package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.FieldSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        private Builder() {
            this(SmallSortedMap.newFieldMap(16));
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.fields = smallSortedMap;
            this.isMutable = true;
        }

        private FieldSet<T> buildImpl(boolean z3) {
            if (this.fields.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.isMutable = false;
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (this.hasNestedBuilders) {
                smallSortedMap = FieldSet.cloneAllFieldsMap(smallSortedMap, false);
                replaceBuilders(smallSortedMap, z3);
            }
            FieldSet<T> fieldSet = new FieldSet<>(smallSortedMap, null);
            ((FieldSet) fieldSet).hasLazyField = this.hasLazyField;
            return fieldSet;
        }

        private void ensureIsMutable() {
            if (this.isMutable) {
                return;
            }
            this.fields = FieldSet.cloneAllFieldsMap(this.fields, true);
            this.isMutable = true;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.cloneAllFieldsMap(((FieldSet) fieldSet).fields, true));
            ((Builder) builder).hasLazyField = ((FieldSet) fieldSet).hasLazyField;
            return builder;
        }

        private void mergeFromField(Map.Entry<T, Object> entry) {
            SmallSortedMap<T, Object> smallSortedMap;
            Object cloneIfMutable;
            Object fieldAllowBuilders;
            T key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).getValue();
            }
            if (key.isRepeated()) {
                List list = (List) getFieldAllowBuilders(key);
                if (list == null) {
                    list = new ArrayList();
                    this.fields.put((SmallSortedMap<T, Object>) key, (T) list);
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    list.add(FieldSet.cloneIfMutable(it.next()));
                }
                return;
            }
            if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || (fieldAllowBuilders = getFieldAllowBuilders(key)) == null) {
                smallSortedMap = this.fields;
                cloneIfMutable = FieldSet.cloneIfMutable(value);
            } else if (fieldAllowBuilders instanceof MessageLite.Builder) {
                key.internalMergeFrom((MessageLite.Builder) fieldAllowBuilders, (MessageLite) value);
                return;
            } else {
                cloneIfMutable = key.internalMergeFrom(((MessageLite) fieldAllowBuilders).toBuilder(), (MessageLite) value).build();
                smallSortedMap = this.fields;
            }
            smallSortedMap.put((SmallSortedMap<T, Object>) key, (T) cloneIfMutable);
        }

        private static Object replaceBuilder(Object obj, boolean z3) {
            if (!(obj instanceof MessageLite.Builder)) {
                return obj;
            }
            MessageLite.Builder builder = (MessageLite.Builder) obj;
            return z3 ? builder.buildPartial() : builder.build();
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T t3, Object obj, boolean z3) {
            if (obj == null || t3.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (!t3.isRepeated()) {
                return replaceBuilder(obj, z3);
            }
            if (!(obj instanceof List)) {
                throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
            }
            List list = (List) obj;
            for (int i3 = 0; i3 < list.size(); i3++) {
                Object obj2 = list.get(i3);
                Object replaceBuilder = replaceBuilder(obj2, z3);
                if (replaceBuilder != obj2) {
                    if (list == obj) {
                        list = new ArrayList(list);
                    }
                    list.set(i3, replaceBuilder);
                }
            }
            return list;
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> smallSortedMap, boolean z3) {
            for (int i3 = 0; i3 < smallSortedMap.getNumArrayEntries(); i3++) {
                replaceBuilders(smallSortedMap.getArrayEntryAt(i3), z3);
            }
            Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
            while (it.hasNext()) {
                replaceBuilders(it.next(), z3);
            }
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean z3) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue(), z3));
        }

        private void verifyType(T t3, Object obj) {
            if (FieldSet.isValidType(t3.getLiteType(), obj)) {
                return;
            }
            if (t3.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE || !(obj instanceof MessageLite.Builder)) {
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t3.getNumber()), t3.getLiteType().getJavaType(), obj.getClass().getName()));
            }
        }

        public void addRepeatedField(T t3, Object obj) {
            List list;
            ensureIsMutable();
            if (!t3.isRepeated()) {
                throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            verifyType(t3, obj);
            Object fieldAllowBuilders = getFieldAllowBuilders(t3);
            if (fieldAllowBuilders == null) {
                list = new ArrayList();
                this.fields.put((SmallSortedMap<T, Object>) t3, (T) list);
            } else {
                list = (List) fieldAllowBuilders;
            }
            list.add(obj);
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        public void clearField(T t3) {
            ensureIsMutable();
            this.fields.remove(t3);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }

        public Map<T, Object> getAllFields() {
            if (!this.hasLazyField) {
                return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
            }
            SmallSortedMap cloneAllFieldsMap = FieldSet.cloneAllFieldsMap(this.fields, false);
            if (this.fields.isImmutable()) {
                cloneAllFieldsMap.makeImmutable();
            } else {
                replaceBuilders(cloneAllFieldsMap, true);
            }
            return cloneAllFieldsMap;
        }

        public Object getField(T t3) {
            return replaceBuilders(t3, getFieldAllowBuilders(t3), true);
        }

        Object getFieldAllowBuilders(T t3) {
            Object obj = this.fields.get(t3);
            return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
        }

        public Object getRepeatedField(T t3, int i3) {
            if (this.hasNestedBuilders) {
                ensureIsMutable();
            }
            return replaceBuilder(getRepeatedFieldAllowBuilders(t3, i3), true);
        }

        Object getRepeatedFieldAllowBuilders(T t3, int i3) {
            if (!t3.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(t3);
            if (fieldAllowBuilders != null) {
                return ((List) fieldAllowBuilders).get(i3);
            }
            throw new IndexOutOfBoundsException();
        }

        public int getRepeatedFieldCount(T t3) {
            if (!t3.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(t3);
            if (fieldAllowBuilders == null) {
                return 0;
            }
            return ((List) fieldAllowBuilders).size();
        }

        public boolean hasField(T t3) {
            if (t3.isRepeated()) {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
            return this.fields.get(t3) != null;
        }

        public boolean isInitialized() {
            for (int i3 = 0; i3 < this.fields.getNumArrayEntries(); i3++) {
                if (!FieldSet.isInitialized(this.fields.getArrayEntryAt(i3))) {
                    return false;
                }
            }
            Iterator<Map.Entry<T, Object>> it = this.fields.getOverflowEntries().iterator();
            while (it.hasNext()) {
                if (!FieldSet.isInitialized(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public void mergeFrom(FieldSet<T> fieldSet) {
            ensureIsMutable();
            for (int i3 = 0; i3 < ((FieldSet) fieldSet).fields.getNumArrayEntries(); i3++) {
                mergeFromField(((FieldSet) fieldSet).fields.getArrayEntryAt(i3));
            }
            Iterator it = ((FieldSet) fieldSet).fields.getOverflowEntries().iterator();
            while (it.hasNext()) {
                mergeFromField((Map.Entry) it.next());
            }
        }

        public void setField(T t3, Object obj) {
            ensureIsMutable();
            if (!t3.isRepeated()) {
                verifyType(t3, obj);
            } else {
                if (!(obj instanceof List)) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                ArrayList arrayList = new ArrayList((List) obj);
                for (Object obj2 : arrayList) {
                    verifyType(t3, obj2);
                    this.hasNestedBuilders = this.hasNestedBuilders || (obj2 instanceof MessageLite.Builder);
                }
                obj = arrayList;
            }
            if (obj instanceof LazyField) {
                this.hasLazyField = true;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            this.fields.put((SmallSortedMap<T, Object>) t3, (T) obj);
        }

        public void setRepeatedField(T t3, int i3, Object obj) {
            ensureIsMutable();
            if (!t3.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            Object fieldAllowBuilders = getFieldAllowBuilders(t3);
            if (fieldAllowBuilders == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(t3, obj);
            ((List) fieldAllowBuilders).set(i3, obj);
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.fields = smallSortedMap;
        makeImmutable();
    }

    /* synthetic */ FieldSet(SmallSortedMap smallSortedMap, AnonymousClass1 anonymousClass1) {
        this(smallSortedMap);
    }

    private FieldSet(boolean z3) {
        this(SmallSortedMap.newFieldMap(0));
        makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> smallSortedMap, boolean z3) {
        SmallSortedMap<T, Object> newFieldMap = SmallSortedMap.newFieldMap(16);
        for (int i3 = 0; i3 < smallSortedMap.getNumArrayEntries(); i3++) {
            cloneFieldEntry(newFieldMap, smallSortedMap.getArrayEntryAt(i3), z3);
        }
        Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            cloneFieldEntry(newFieldMap, it.next(), z3);
        }
        return newFieldMap;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z3) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        } else if (z3 && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
            return;
        }
        map.put(key, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int computeElementSize(WireFormat.FieldType fieldType, int i3, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i3);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        int i3 = 0;
        List list = (List) obj;
        if (fieldDescriptorLite.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i3 += computeElementSizeNoTag(liteType, it.next());
            }
            return CodedOutputStream.computeTagSize(number) + i3 + CodedOutputStream.computeUInt32SizeNoTag(i3);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i3 += computeElementSize(liteType, number, it2.next());
        }
        return i3;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
            return computeFieldSize(key, value);
        }
        boolean z3 = value instanceof LazyField;
        int number = entry.getKey().getNumber();
        return z3 ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(number, (LazyField) value) : CodedOutputStream.computeMessageSetExtensionSize(number, (MessageLite) value);
    }

    static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z3) {
        if (z3) {
            return 2;
        }
        return fieldType.getWireType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        boolean isRepeated = key.isRepeated();
        Object value = entry.getValue();
        if (!isRepeated) {
            return isMessageFieldValueInitialized(value);
        }
        Iterator it = ((List) value).iterator();
        while (it.hasNext()) {
            if (!isMessageFieldValueInitialized(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMessageFieldValueInitialized(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidType(WireFormat.FieldType fieldType, Object obj) {
        Internal.checkNotNull(obj);
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof ByteString) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof Internal.EnumLite);
            case 9:
                return (obj instanceof MessageLite) || (obj instanceof LazyField);
            default:
                return false;
        }
    }

    private void mergeFromField(Map.Entry<T, Object> entry) {
        SmallSortedMap<T, Object> smallSortedMap;
        Object cloneIfMutable;
        Object field;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object field2 = getField(key);
            if (field2 == null) {
                field2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field2).add(cloneIfMutable(it.next()));
            }
            this.fields.put((SmallSortedMap<T, Object>) key, (T) field2);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || (field = getField(key)) == null) {
            smallSortedMap = this.fields;
            cloneIfMutable = cloneIfMutable(value);
        } else {
            cloneIfMutable = key.internalMergeFrom(((MessageLite) field).toBuilder(), (MessageLite) value).build();
            smallSortedMap = this.fields;
        }
        smallSortedMap.put((SmallSortedMap<T, Object>) key, (T) cloneIfMutable);
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder<>((AnonymousClass1) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z3) {
        return WireFormat.readPrimitiveField(codedInputStream, fieldType, z3 ? WireFormat.Utf8Validation.STRICT : WireFormat.Utf8Validation.LOOSE);
    }

    private void verifyType(T t3, Object obj) {
        if (!isValidType(t3.getLiteType(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t3.getNumber()), t3.getLiteType().getJavaType(), obj.getClass().getName()));
        }
    }

    static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i3, Object obj) {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i3, (MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i3, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeStringNoTag((String) obj);
                    return;
                }
                break;
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
                break;
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            case 18:
                codedOutputStream.writeEnumNoTag(obj instanceof Internal.EnumLite ? ((Internal.EnumLite) obj).getNumber() : ((Integer) obj).intValue());
                return;
            default:
                return;
        }
        codedOutputStream.writeBytesNoTag((ByteString) obj);
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            if (obj instanceof LazyField) {
                writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
                return;
            } else {
                writeElement(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!fieldDescriptorLite.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                writeElement(codedOutputStream, liteType, number, it.next());
            }
            return;
        }
        codedOutputStream.writeTag(number, 2);
        int i3 = 0;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i3 += computeElementSizeNoTag(liteType, it2.next());
        }
        codedOutputStream.writeUInt32NoTag(i3);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            writeElementNoTag(codedOutputStream, liteType, it3.next());
        }
    }

    private void writeMessageSetTo(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
            writeField(key, entry.getValue(), codedOutputStream);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
    }

    public void addRepeatedField(T t3, Object obj) {
        List list;
        if (!t3.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(t3, obj);
        Object field = getField(t3);
        if (field == null) {
            list = new ArrayList();
            this.fields.put((SmallSortedMap<T, Object>) t3, (T) list);
        } else {
            list = (List) field;
        }
        list.add(obj);
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T t3) {
        this.fields.remove(t3);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FieldSet<T> m10clone() {
        FieldSet<T> newFieldSet = newFieldSet();
        for (int i3 = 0; i3 < this.fields.getNumArrayEntries(); i3++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i3);
            newFieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
            newFieldSet.setField(entry.getKey(), entry.getValue());
        }
        newFieldSet.hasLazyField = this.hasLazyField;
        return newFieldSet;
    }

    Iterator<Map.Entry<T, Object>> descendingIterator() {
        return this.hasLazyField ? new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator()) : this.fields.descendingEntrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.fields.equals(((FieldSet) obj).fields);
        }
        return false;
    }

    public Map<T, Object> getAllFields() {
        if (!this.hasLazyField) {
            return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
        }
        SmallSortedMap cloneAllFieldsMap = cloneAllFieldsMap(this.fields, false);
        if (this.fields.isImmutable()) {
            cloneAllFieldsMap.makeImmutable();
        }
        return cloneAllFieldsMap;
    }

    public Object getField(T t3) {
        Object obj = this.fields.get(t3);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public int getMessageSetSerializedSize() {
        int i3 = 0;
        for (int i4 = 0; i4 < this.fields.getNumArrayEntries(); i4++) {
            i3 += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i4));
        }
        Iterator<Map.Entry<T, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            i3 += getMessageSetSerializedSize(it.next());
        }
        return i3;
    }

    public Object getRepeatedField(T t3, int i3) {
        if (!t3.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(t3);
        if (field != null) {
            return ((List) field).get(i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(T t3) {
        if (!t3.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(t3);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public int getSerializedSize() {
        int i3 = 0;
        for (int i4 = 0; i4 < this.fields.getNumArrayEntries(); i4++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i4);
            i3 += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
            i3 += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return i3;
    }

    public boolean hasField(T t3) {
        if (t3.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(t3) != null;
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        for (int i3 = 0; i3 < this.fields.getNumArrayEntries(); i3++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i3))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!isInitialized(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        return this.hasLazyField ? new LazyField.LazyIterator(this.fields.entrySet().iterator()) : this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        for (int i3 = 0; i3 < this.fields.getNumArrayEntries(); i3++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i3);
            if (arrayEntryAt.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) arrayEntryAt.getValue()).makeImmutable();
            }
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public void mergeFrom(FieldSet<T> fieldSet) {
        for (int i3 = 0; i3 < fieldSet.fields.getNumArrayEntries(); i3++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i3));
        }
        Iterator<Map.Entry<T, Object>> it = fieldSet.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField(it.next());
        }
    }

    public void setField(T t3, Object obj) {
        if (!t3.isRepeated()) {
            verifyType(t3, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                verifyType(t3, it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((SmallSortedMap<T, Object>) t3, (T) obj);
    }

    public void setRepeatedField(T t3, int i3, Object obj) {
        if (!t3.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(t3);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(t3, obj);
        ((List) field).set(i3, obj);
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) {
        for (int i3 = 0; i3 < this.fields.getNumArrayEntries(); i3++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i3), codedOutputStream);
        }
        Iterator<Map.Entry<T, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            writeMessageSetTo(it.next(), codedOutputStream);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i3 = 0; i3 < this.fields.getNumArrayEntries(); i3++) {
            Map.Entry<T, Object> arrayEntryAt = this.fields.getArrayEntryAt(i3);
            writeField(arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
        }
        for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries()) {
            writeField(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }
}
