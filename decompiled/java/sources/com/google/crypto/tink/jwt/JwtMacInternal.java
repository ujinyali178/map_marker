package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.util.Optional;

@Immutable
/* loaded from: /root/release/classes.dex */
interface JwtMacInternal {
    String computeMacAndEncodeWithKid(RawJwt rawJwt, Optional<String> optional);

    VerifiedJwt verifyMacAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional);
}
