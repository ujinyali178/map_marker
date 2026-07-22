package com.google.crypto.tink.jwt;

/* loaded from: /root/release/classes.dex */
public final class JwtMacConfig {
    public static final String JWT_HMAC_TYPE_URL = new JwtHmacKeyManager().getKeyType();

    private JwtMacConfig() {
    }

    public static void register() {
        JwtHmacKeyManager.register(true);
        JwtMacWrapper.register();
    }
}
