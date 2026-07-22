package com.google.crypto.tink;

/* loaded from: /root/release/classes.dex */
public interface PrimitiveWrapper<B, P> {
    Class<B> getInputPrimitiveClass();

    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<B> primitiveSet);
}
