package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface EciesAeadHkdfPublicKeyOrBuilder extends MessageLiteOrBuilder {
    EciesAeadHkdfParams getParams();

    int getVersion();

    ByteString getX();

    ByteString getY();

    boolean hasParams();
}
