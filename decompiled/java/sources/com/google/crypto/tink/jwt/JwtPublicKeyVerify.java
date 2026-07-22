package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
public interface JwtPublicKeyVerify {
    VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator);
}
