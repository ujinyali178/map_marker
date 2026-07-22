package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface AesEaxKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesEaxParams getParams();

    boolean hasParams();
}
