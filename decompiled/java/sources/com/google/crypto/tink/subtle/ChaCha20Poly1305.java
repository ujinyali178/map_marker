package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
public final class ChaCha20Poly1305 implements Aead {
    private final InsecureNonceChaCha20Poly1305 cipher;

    public ChaCha20Poly1305(byte[] bArr) {
        this.cipher = new InsecureNonceChaCha20Poly1305(bArr);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        if (bArr.length < 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] copyOf = Arrays.copyOf(bArr, 12);
        return this.cipher.decrypt(ByteBuffer.wrap(bArr, 12, bArr.length - 12), copyOf, bArr2);
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12 + 16);
        byte[] randBytes = Random.randBytes(12);
        allocate.put(randBytes);
        this.cipher.encrypt(allocate, randBytes, bArr, bArr2);
        return allocate.array();
    }
}
