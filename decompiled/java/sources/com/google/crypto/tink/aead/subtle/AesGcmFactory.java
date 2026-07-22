package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

@Immutable
/* loaded from: /root/release/classes.dex */
public final class AesGcmFactory implements AeadFactory {
    private final int keySizeInBytes;

    public AesGcmFactory(int i3) {
        this.keySizeInBytes = validateAesKeySize(i3);
    }

    private static int validateAesKeySize(int i3) {
        if (i3 == 16 || i3 == 32) {
            return i3;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid AES key size, expected 16 or 32, but got %d", Integer.valueOf(i3)));
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public Aead createAead(byte[] bArr) {
        if (bArr.length == getKeySizeInBytes()) {
            return new AesGcmJce(bArr);
        }
        throw new GeneralSecurityException(String.format("Symmetric key has incorrect length; expected %s, but got %s", Integer.valueOf(getKeySizeInBytes()), Integer.valueOf(bArr.length)));
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public int getKeySizeInBytes() {
        return this.keySizeInBytes;
    }
}
