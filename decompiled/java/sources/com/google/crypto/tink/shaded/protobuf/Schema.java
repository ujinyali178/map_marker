package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
interface Schema<T> {
    boolean equals(T t3, T t4);

    int getSerializedSize(T t3);

    int hashCode(T t3);

    boolean isInitialized(T t3);

    void makeImmutable(T t3);

    void mergeFrom(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t3, T t4);

    void mergeFrom(T t3, byte[] bArr, int i3, int i4, ArrayDecoders.Registers registers);

    T newInstance();

    void writeTo(T t3, Writer writer);
}
