package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.util.Optional;

@Immutable
/* loaded from: /root/release/classes.dex */
public interface JwtPublicKeySignInternal {
    String signAndEncodeWithKid(RawJwt rawJwt, Optional<String> optional);
}
