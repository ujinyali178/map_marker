package com.google.crypto.tink.tinkkey;

import com.google.errorprone.annotations.Immutable;

@Immutable
@Deprecated
/* loaded from: /root/release/classes.dex */
public final class SecretKeyAccess {
    private SecretKeyAccess() {
    }

    public static KeyAccess insecureSecretAccess() {
        return KeyAccess.secretAccess();
    }
}
