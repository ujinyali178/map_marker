package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* loaded from: /root/release/classes.dex */
public final class StreamingAeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_1MB;
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_4KB;
    public static final KeyTemplate AES128_GCM_HKDF_1MB;
    public static final KeyTemplate AES128_GCM_HKDF_4KB;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_1MB;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_4KB;
    public static final KeyTemplate AES256_GCM_HKDF_1MB;
    public static final KeyTemplate AES256_GCM_HKDF_4KB;

    static {
        HashType hashType = HashType.SHA256;
        AES128_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(16, hashType, 16, hashType, 32, 4096);
        AES128_CTR_HMAC_SHA256_1MB = createAesCtrHmacStreamingKeyTemplate(16, hashType, 16, hashType, 32, 1048576);
        AES256_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(32, hashType, 32, hashType, 32, 4096);
        AES256_CTR_HMAC_SHA256_1MB = createAesCtrHmacStreamingKeyTemplate(32, hashType, 32, hashType, 32, 1048576);
        AES128_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(16, hashType, 16, 4096);
        AES128_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(16, hashType, 16, 1048576);
        AES256_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(32, hashType, 32, 4096);
        AES256_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(32, hashType, 32, 1048576);
    }

    private StreamingAeadKeyTemplates() {
    }

    public static KeyTemplate createAesCtrHmacStreamingKeyTemplate(int i3, HashType hashType, int i4, HashType hashType2, int i5, int i6) {
        return KeyTemplate.newBuilder().setValue(AesCtrHmacStreamingKeyFormat.newBuilder().setParams(AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(i6).setDerivedKeySize(i4).setHkdfHashType(hashType).setHmacParams(HmacParams.newBuilder().setHash(hashType2).setTagSize(i5).build()).build()).setKeySize(i3).build().toByteString()).setTypeUrl(new AesCtrHmacStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    public static KeyTemplate createAesGcmHkdfStreamingKeyTemplate(int i3, HashType hashType, int i4, int i5) {
        return KeyTemplate.newBuilder().setValue(AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(i3).setParams(AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(i5).setDerivedKeySize(i4).setHkdfHashType(hashType).build()).build().toByteString()).setTypeUrl(new AesGcmHkdfStreamingKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }
}
