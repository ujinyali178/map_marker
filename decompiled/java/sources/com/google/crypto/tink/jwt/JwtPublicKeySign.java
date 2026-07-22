package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
public interface JwtPublicKeySign {
    String signAndEncode(RawJwt rawJwt);
}
