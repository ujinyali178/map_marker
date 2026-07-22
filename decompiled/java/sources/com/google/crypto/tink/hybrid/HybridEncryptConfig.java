package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Config;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class HybridEncryptConfig {
    private HybridEncryptConfig() {
    }

    @Deprecated
    public static void registerStandardKeyTypes() {
        Config.register(HybridConfig.TINK_1_0_0);
    }
}
