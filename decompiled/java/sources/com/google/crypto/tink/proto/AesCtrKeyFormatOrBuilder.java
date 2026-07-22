package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface AesCtrKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCtrParams getParams();

    boolean hasParams();
}
