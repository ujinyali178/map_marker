package com.google.crypto.tink.tinkkey;

import com.google.errorprone.annotations.Immutable;

@Immutable
@Deprecated
/* loaded from: /root/release/classes.dex */
public final class KeyAccess {
    private final boolean canAccessSecret;

    private KeyAccess(boolean z3) {
        this.canAccessSecret = z3;
    }

    public static KeyAccess publicAccess() {
        return new KeyAccess(false);
    }

    static KeyAccess secretAccess() {
        return new KeyAccess(true);
    }

    public boolean canAccessSecret() {
        return this.canAccessSecret;
    }
}
