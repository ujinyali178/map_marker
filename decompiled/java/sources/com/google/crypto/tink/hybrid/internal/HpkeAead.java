package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
interface HpkeAead {
    byte[] getAeadId();

    int getKeyLength();

    int getNonceLength();

    byte[] open(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    byte[] seal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);
}
