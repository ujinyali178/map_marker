package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: /root/release/classes.dex */
public interface EncryptedKeysetOrBuilder extends MessageLiteOrBuilder {
    ByteString getEncryptedKeyset();

    KeysetInfo getKeysetInfo();

    boolean hasKeysetInfo();
}
