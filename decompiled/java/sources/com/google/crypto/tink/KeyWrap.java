package com.google.crypto.tink;

/* loaded from: /root/release/classes.dex */
public interface KeyWrap {
    byte[] unwrap(byte[] bArr);

    byte[] wrap(byte[] bArr);
}
