package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    ExtensionSchema() {
    }

    abstract int extensionNumber(Map.Entry<?, ?> entry);

    abstract Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i3);

    abstract FieldSet<T> getExtensions(Object obj);

    abstract FieldSet<T> getMutableExtensions(Object obj);

    abstract boolean hasExtensions(MessageLite messageLite);

    abstract void makeImmutable(Object obj);

    abstract <UT, UB> UB parseExtension(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema);

    abstract void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet);

    abstract void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet);

    abstract void serializeExtension(Writer writer, Map.Entry<?, ?> entry);

    abstract void setExtensions(Object obj, FieldSet<T> fieldSet);
}
