package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
interface HpkeKem {
    byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey);

    HpkeKemEncapOutput encapsulate(byte[] bArr);

    byte[] getKemId();
}
