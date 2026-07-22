package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface HkdfPrfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HkdfPrfParams getParams();

    int getVersion();

    boolean hasParams();
}
