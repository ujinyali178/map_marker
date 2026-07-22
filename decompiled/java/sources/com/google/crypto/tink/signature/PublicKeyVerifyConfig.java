package com.google.crypto.tink.signature;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class PublicKeyVerifyConfig {
    private PublicKeyVerifyConfig() {
    }

    @Deprecated
    public static void registerStandardKeyTypes() {
        SignatureConfig.register();
    }
}
