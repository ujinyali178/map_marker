package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;

/* loaded from: /root/release/classes.dex */
public interface KeysetReader {
    Keyset read();

    EncryptedKeyset readEncrypted();
}
