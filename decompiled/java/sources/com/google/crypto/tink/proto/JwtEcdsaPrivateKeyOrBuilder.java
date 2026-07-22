package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface JwtEcdsaPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    JwtEcdsaPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}
