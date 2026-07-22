package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;

/* loaded from: /root/release/classes.dex */
public final class InsecureNonceXChaCha20Poly1305 extends InsecureNonceChaCha20Poly1305Base {
    public InsecureNonceXChaCha20Poly1305(byte[] bArr) {
        super(bArr);
    }

    @Override // com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Base
    public /* bridge */ /* synthetic */ byte[] decrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        return super.decrypt(byteBuffer, bArr, bArr2);
    }

    @Override // com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Base
    public /* bridge */ /* synthetic */ byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return super.decrypt(bArr, bArr2, bArr3);
    }

    @Override // com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Base
    public /* bridge */ /* synthetic */ void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super.encrypt(byteBuffer, bArr, bArr2, bArr3);
    }

    @Override // com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Base
    public /* bridge */ /* synthetic */ byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return super.encrypt(bArr, bArr2, bArr3);
    }

    @Override // com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Base
    InsecureNonceChaCha20Base newChaCha20Instance(byte[] bArr, int i3) {
        return new InsecureNonceXChaCha20(bArr, i3);
    }
}
