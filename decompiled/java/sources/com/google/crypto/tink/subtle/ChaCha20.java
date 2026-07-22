package com.google.crypto.tink.subtle;

import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: /root/release/classes.dex */
class ChaCha20 implements IndCpaCipher {
    static final int NONCE_LENGTH_IN_BYTES = 12;
    private final InsecureNonceChaCha20 cipher;

    ChaCha20(byte[] bArr, int i3) {
        this.cipher = new InsecureNonceChaCha20(bArr, i3);
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(byte[] bArr) {
        if (bArr.length < 12) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.cipher.decrypt(Arrays.copyOf(bArr, 12), ByteBuffer.wrap(bArr, 12, bArr.length - 12));
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 12);
        byte[] randBytes = Random.randBytes(12);
        allocate.put(randBytes);
        this.cipher.encrypt(allocate, randBytes, bArr);
        return allocate.array();
    }
}
