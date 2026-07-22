package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
public interface ChunkedMac {
    ChunkedMacComputation createComputation();

    ChunkedMacVerification createVerification(byte[] bArr);
}
