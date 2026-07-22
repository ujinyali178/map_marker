package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeysetHandle;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class HybridDecryptFactory {
    private HybridDecryptFactory() {
    }

    @Deprecated
    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle) {
        HybridDecryptWrapper.register();
        return (HybridDecrypt) keysetHandle.getPrimitive(HybridDecrypt.class);
    }
}
