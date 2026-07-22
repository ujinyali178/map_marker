package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.subtle.Bytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: /root/release/classes.dex */
abstract class InsecureNonceChaCha20Base {
    private final int initialCounter;
    int[] key;

    public InsecureNonceChaCha20Base(byte[] bArr, int i3) {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.key = ChaCha20Util.toIntArray(bArr);
        this.initialCounter = i3;
    }

    private void process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (bArr.length != nonceSizeInBytes()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + nonceSizeInBytes());
        }
        int remaining = byteBuffer2.remaining();
        int i3 = (remaining / 64) + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            ByteBuffer chacha20Block = chacha20Block(bArr, this.initialCounter + i4);
            if (i4 == i3 - 1) {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, remaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, 64);
            }
        }
    }

    ByteBuffer chacha20Block(byte[] bArr, int i3) {
        int[] createInitialState = createInitialState(ChaCha20Util.toIntArray(bArr), i3);
        int[] iArr = (int[]) createInitialState.clone();
        ChaCha20Util.shuffleState(iArr);
        for (int i4 = 0; i4 < createInitialState.length; i4++) {
            createInitialState[i4] = createInitialState[i4] + iArr[i4];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    abstract int[] createInitialState(int[] iArr, int i3);

    public byte[] decrypt(byte[] bArr, ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        process(bArr, allocate, byteBuffer);
        return allocate.array();
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(bArr, ByteBuffer.wrap(bArr2));
    }

    public void encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        process(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr2.length);
        encrypt(allocate, bArr, bArr2);
        return allocate.array();
    }

    abstract int nonceSizeInBytes();
}
