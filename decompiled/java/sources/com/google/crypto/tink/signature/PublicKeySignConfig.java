package com.google.crypto.tink.signature;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class PublicKeySignConfig {
    private PublicKeySignConfig() {
    }

    @Deprecated
    public static void registerStandardKeyTypes() {
        SignatureConfig.register();
    }
}
