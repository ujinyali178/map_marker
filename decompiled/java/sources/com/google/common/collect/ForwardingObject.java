package com.google.common.collect;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class ForwardingObject {
    protected ForwardingObject() {
    }

    protected abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
