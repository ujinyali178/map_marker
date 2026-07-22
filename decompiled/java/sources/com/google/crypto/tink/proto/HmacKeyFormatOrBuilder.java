package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface HmacKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HmacParams getParams();

    int getVersion();

    boolean hasParams();
}
