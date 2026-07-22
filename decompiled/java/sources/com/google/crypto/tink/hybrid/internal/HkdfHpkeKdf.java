package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Immutable
/* loaded from: /root/release/classes.dex */
final class HkdfHpkeKdf implements HpkeKdf {
    private final String macAlgorithm;

    HkdfHpkeKdf(String str) {
        this.macAlgorithm = str;
    }

    private byte[] expand(byte[] bArr, byte[] bArr2, int i3) {
        Mac engineFactory = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (i3 > engineFactory.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i3];
        engineFactory.init(new SecretKeySpec(bArr, this.macAlgorithm));
        byte[] bArr4 = new byte[0];
        int i4 = 1;
        int i5 = 0;
        while (true) {
            engineFactory.update(bArr4);
            engineFactory.update(bArr2);
            engineFactory.update((byte) i4);
            bArr4 = engineFactory.doFinal();
            if (bArr4.length + i5 >= i3) {
                System.arraycopy(bArr4, 0, bArr3, i5, i3 - i5);
                return bArr3;
            }
            System.arraycopy(bArr4, 0, bArr3, i5, bArr4.length);
            i5 += bArr4.length;
            i4++;
        }
    }

    private byte[] extract(byte[] bArr, byte[] bArr2) {
        Mac engineFactory = EngineFactory.MAC.getInstance(this.macAlgorithm);
        if (bArr2 == null || bArr2.length == 0) {
            engineFactory.init(new SecretKeySpec(new byte[engineFactory.getMacLength()], this.macAlgorithm));
        } else {
            engineFactory.init(new SecretKeySpec(bArr2, this.macAlgorithm));
        }
        return engineFactory.doFinal(bArr);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] extractAndExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i3) {
        return expand(extract(HpkeUtil.labelIkm(str, bArr2, bArr4), bArr), HpkeUtil.labelInfo(str2, bArr3, bArr4, i3), i3);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] getKdfId() {
        String str = this.macAlgorithm;
        str.hashCode();
        switch (str) {
            case "HmacSha256":
                return HpkeUtil.HKDF_SHA256_KDF_ID;
            case "HmacSha384":
                return HpkeUtil.HKDF_SHA384_KDF_ID;
            case "HmacSha512":
                return HpkeUtil.HKDF_SHA512_KDF_ID;
            default:
                throw new GeneralSecurityException("Could not determine HPKE KDF ID");
        }
    }

    int getMacLength() {
        return Mac.getInstance(this.macAlgorithm).getMacLength();
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExpand(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i3) {
        return expand(bArr, HpkeUtil.labelInfo(str, bArr2, bArr3, i3), i3);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKdf
    public byte[] labeledExtract(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return extract(HpkeUtil.labelIkm(str, bArr2, bArr3), bArr);
    }
}
