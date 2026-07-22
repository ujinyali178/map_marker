package com.google.crypto.tink.subtle;

import com.google.crypto.tink.hybrid.subtle.AeadOrDaead;

/* loaded from: /root/release/classes.dex */
public interface EciesAeadHkdfDemHelper {
    AeadOrDaead getAeadOrDaead(byte[] bArr);

    int getSymmetricKeySizeInBytes();
}
