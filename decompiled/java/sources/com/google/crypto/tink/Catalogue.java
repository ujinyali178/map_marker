package com.google.crypto.tink;

@Deprecated
/* loaded from: /root/release/classes.dex */
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i3);

    PrimitiveWrapper<?, P> getPrimitiveWrapper();
}
