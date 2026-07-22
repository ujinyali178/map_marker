package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeysetHandle;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class HybridEncryptFactory {
    private HybridEncryptFactory() {
    }

    @Deprecated
    public static HybridEncrypt getPrimitive(KeysetHandle keysetHandle) {
        HybridEncryptWrapper.register();
        return (HybridEncrypt) keysetHandle.getPrimitive(HybridEncrypt.class);
    }
}
