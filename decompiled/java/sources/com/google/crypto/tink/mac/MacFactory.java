package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Mac;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class MacFactory {
    private MacFactory() {
    }

    @Deprecated
    public static Mac getPrimitive(KeysetHandle keysetHandle) {
        MacWrapper.register();
        return (Mac) keysetHandle.getPrimitive(Mac.class);
    }
}
