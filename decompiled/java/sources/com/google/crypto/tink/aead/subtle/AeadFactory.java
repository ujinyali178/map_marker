package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
public interface AeadFactory {
    Aead createAead(byte[] bArr);

    int getKeySizeInBytes();
}
