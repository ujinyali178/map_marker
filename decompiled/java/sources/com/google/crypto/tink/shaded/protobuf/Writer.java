package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    FieldOrder fieldOrder();

    void writeBool(int i3, boolean z3);

    void writeBoolList(int i3, List<Boolean> list, boolean z3);

    void writeBytes(int i3, ByteString byteString);

    void writeBytesList(int i3, List<ByteString> list);

    void writeDouble(int i3, double d3);

    void writeDoubleList(int i3, List<Double> list, boolean z3);

    @Deprecated
    void writeEndGroup(int i3);

    void writeEnum(int i3, int i4);

    void writeEnumList(int i3, List<Integer> list, boolean z3);

    void writeFixed32(int i3, int i4);

    void writeFixed32List(int i3, List<Integer> list, boolean z3);

    void writeFixed64(int i3, long j3);

    void writeFixed64List(int i3, List<Long> list, boolean z3);

    void writeFloat(int i3, float f3);

    void writeFloatList(int i3, List<Float> list, boolean z3);

    @Deprecated
    void writeGroup(int i3, Object obj);

    @Deprecated
    void writeGroup(int i3, Object obj, Schema schema);

    @Deprecated
    void writeGroupList(int i3, List<?> list);

    @Deprecated
    void writeGroupList(int i3, List<?> list, Schema schema);

    void writeInt32(int i3, int i4);

    void writeInt32List(int i3, List<Integer> list, boolean z3);

    void writeInt64(int i3, long j3);

    void writeInt64List(int i3, List<Long> list, boolean z3);

    <K, V> void writeMap(int i3, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map);

    void writeMessage(int i3, Object obj);

    void writeMessage(int i3, Object obj, Schema schema);

    void writeMessageList(int i3, List<?> list);

    void writeMessageList(int i3, List<?> list, Schema schema);

    void writeMessageSetItem(int i3, Object obj);

    void writeSFixed32(int i3, int i4);

    void writeSFixed32List(int i3, List<Integer> list, boolean z3);

    void writeSFixed64(int i3, long j3);

    void writeSFixed64List(int i3, List<Long> list, boolean z3);

    void writeSInt32(int i3, int i4);

    void writeSInt32List(int i3, List<Integer> list, boolean z3);

    void writeSInt64(int i3, long j3);

    void writeSInt64List(int i3, List<Long> list, boolean z3);

    @Deprecated
    void writeStartGroup(int i3);

    void writeString(int i3, String str);

    void writeStringList(int i3, List<String> list);

    void writeUInt32(int i3, int i4);

    void writeUInt32List(int i3, List<Integer> list, boolean z3);

    void writeUInt64(int i3, long j3);

    void writeUInt64List(int i3, List<Long> list, boolean z3);
}
