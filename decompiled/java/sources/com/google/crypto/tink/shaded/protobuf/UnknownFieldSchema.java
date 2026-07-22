package com.google.crypto.tink.shaded.protobuf;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class UnknownFieldSchema<T, B> {
    UnknownFieldSchema() {
    }

    abstract void addFixed32(B b4, int i3, int i4);

    abstract void addFixed64(B b4, int i3, long j3);

    abstract void addGroup(B b4, int i3, T t3);

    abstract void addLengthDelimited(B b4, int i3, ByteString byteString);

    abstract void addVarint(B b4, int i3, long j3);

    abstract B getBuilderFromMessage(Object obj);

    abstract T getFromMessage(Object obj);

    abstract int getSerializedSize(T t3);

    abstract int getSerializedSizeAsMessageSet(T t3);

    abstract void makeImmutable(Object obj);

    abstract T merge(T t3, T t4);

    final void mergeFrom(B b4, Reader reader) {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b4, reader)) {
        }
    }

    final boolean mergeOneFieldFrom(B b4, Reader reader) {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b4, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b4, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b4, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(b4, tagFieldNumber, reader.readFixed32());
            return true;
        }
        B newBuilder = newBuilder();
        int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
        mergeFrom(newBuilder, reader);
        if (makeTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b4, tagFieldNumber, toImmutable(newBuilder));
        return true;
    }

    abstract B newBuilder();

    abstract void setBuilderToMessage(Object obj, B b4);

    abstract void setToMessage(Object obj, T t3);

    abstract boolean shouldDiscardUnknownFields(Reader reader);

    abstract T toImmutable(B b4);

    abstract void writeAsMessageSetTo(T t3, Writer writer);

    abstract void writeTo(T t3, Writer writer);
}
