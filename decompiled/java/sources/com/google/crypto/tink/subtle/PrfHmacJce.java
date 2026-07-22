package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

@Immutable
/* loaded from: /root/release/classes.dex */
public final class PrfHmacJce implements Prf {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private final String algorithm;
    private final Key key;
    private final ThreadLocal<Mac> localMac;
    private final int maxOutputLength;

    public PrfHmacJce(String str, Key key) {
        int i3;
        ThreadLocal<Mac> threadLocal = new ThreadLocal<Mac>() { // from class: com.google.crypto.tink.subtle.PrfHmacJce.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public Mac initialValue() {
                try {
                    Mac engineFactory = EngineFactory.MAC.getInstance(PrfHmacJce.this.algorithm);
                    engineFactory.init(PrfHmacJce.this.key);
                    return engineFactory;
                } catch (GeneralSecurityException e3) {
                    throw new IllegalStateException(e3);
                }
            }
        };
        this.localMac = threadLocal;
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.algorithm = str;
        this.key = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                i3 = 20;
                break;
            case "HMACSHA224":
                i3 = 28;
                break;
            case "HMACSHA256":
                i3 = 32;
                break;
            case "HMACSHA384":
                i3 = 48;
                break;
            case "HMACSHA512":
                i3 = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        this.maxOutputLength = i3;
        threadLocal.get();
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] bArr, int i3) {
        if (i3 > this.maxOutputLength) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.localMac.get().update(bArr);
        return Arrays.copyOf(this.localMac.get().doFinal(), i3);
    }

    public int getMaxOutputLength() {
        return this.maxOutputLength;
    }
}
