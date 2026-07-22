package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;

@Immutable
/* loaded from: /root/release/classes.dex */
interface HpkeKdf {
    byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i3);

    byte[] getKdfId();

    byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i3);

    byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3);
}
