package com.google.crypto.tink.internal;

import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* loaded from: /root/release/classes.dex */
public abstract class PrimitiveFactory<PrimitiveT, KeyProtoT extends MessageLite> {
    private final Class<PrimitiveT> clazz;

    public PrimitiveFactory(Class<PrimitiveT> cls) {
        this.clazz = cls;
    }

    public abstract PrimitiveT getPrimitive(KeyProtoT keyprotot);

    final Class<PrimitiveT> getPrimitiveClass() {
        return this.clazz;
    }
}
