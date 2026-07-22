package com.google.crypto.tink.prf;

import com.google.errorprone.annotations.Immutable;
import java.util.Map;

@Immutable
/* loaded from: /root/release/classes.dex */
public abstract class PrfSet {
    public byte[] computePrimary(byte[] bArr, int i3) {
        return getPrfs().get(Integer.valueOf(getPrimaryId())).compute(bArr, i3);
    }

    public abstract Map<Integer, Prf> getPrfs();

    public abstract int getPrimaryId();
}
