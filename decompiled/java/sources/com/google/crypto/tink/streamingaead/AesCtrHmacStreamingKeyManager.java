package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKey;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.AesCtrHmacStreaming;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class AesCtrHmacStreamingKeyManager extends KeyTypeManager<AesCtrHmacStreamingKey> {
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private static final int NONCE_PREFIX_IN_BYTES = 7;

    /* renamed from: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    AesCtrHmacStreamingKeyManager() {
        super(AesCtrHmacStreamingKey.class, new PrimitiveFactory<StreamingAead, AesCtrHmacStreamingKey>(StreamingAead.class) { // from class: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public StreamingAead getPrimitive(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) {
                return new AesCtrHmacStreaming(aesCtrHmacStreamingKey.getKeyValue().toByteArray(), StreamingAeadUtil.toHmacAlgo(aesCtrHmacStreamingKey.getParams().getHkdfHashType()), aesCtrHmacStreamingKey.getParams().getDerivedKeySize(), StreamingAeadUtil.toHmacAlgo(aesCtrHmacStreamingKey.getParams().getHmacParams().getHash()), aesCtrHmacStreamingKey.getParams().getHmacParams().getTagSize(), aesCtrHmacStreamingKey.getParams().getCiphertextSegmentSize(), 0);
            }
        });
    }

    public static final KeyTemplate aes128CtrHmacSha2561MBTemplate() {
        HashType hashType = HashType.SHA256;
        return createKeyTemplate(16, hashType, 16, hashType, 32, 1048576);
    }

    public static final KeyTemplate aes128CtrHmacSha2564KBTemplate() {
        HashType hashType = HashType.SHA256;
        return createKeyTemplate(16, hashType, 16, hashType, 32, 4096);
    }

    public static final KeyTemplate aes256CtrHmacSha2561MBTemplate() {
        HashType hashType = HashType.SHA256;
        return createKeyTemplate(32, hashType, 32, hashType, 32, 1048576);
    }

    public static final KeyTemplate aes256CtrHmacSha2564KBTemplate() {
        HashType hashType = HashType.SHA256;
        return createKeyTemplate(32, hashType, 32, hashType, 32, 4096);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCtrHmacStreamingKeyFormat createKeyFormat(int i3, HashType hashType, int i4, HashType hashType2, int i5, int i6) {
        return AesCtrHmacStreamingKeyFormat.newBuilder().setParams(AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(i6).setDerivedKeySize(i4).setHkdfHashType(hashType).setHmacParams(HmacParams.newBuilder().setHash(hashType2).setTagSize(i5).build()).build()).setKeySize(i3).build();
    }

    private static KeyTemplate createKeyTemplate(int i3, HashType hashType, int i4, HashType hashType2, int i5, int i6) {
        return KeyTemplate.create(new AesCtrHmacStreamingKeyManager().getKeyType(), createKeyFormat(i3, hashType, i4, hashType2, i5, i6).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z3) {
        Registry.registerKeyManager(new AesCtrHmacStreamingKeyManager(), z3);
    }

    private static void validateHmacParams(HmacParams hmacParams) {
        if (hmacParams.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i3 = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hmacParams.getHash().ordinal()];
        if (i3 == 1) {
            if (hmacParams.getTagSize() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i3 == 2) {
            if (hmacParams.getTagSize() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i3 != 3) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (hmacParams.getTagSize() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
        Validators.validateAesKeySize(aesCtrHmacStreamingParams.getDerivedKeySize());
        if (aesCtrHmacStreamingParams.getHkdfHashType() != HashType.SHA1 && aesCtrHmacStreamingParams.getHkdfHashType() != HashType.SHA256 && aesCtrHmacStreamingParams.getHkdfHashType() != HashType.SHA512) {
            throw new GeneralSecurityException("Invalid HKDF hash type: " + aesCtrHmacStreamingParams.getHkdfHashType().getNumber());
        }
        if (aesCtrHmacStreamingParams.getHmacParams().getHash() == HashType.UNKNOWN_HASH) {
            throw new GeneralSecurityException("unknown HMAC hash type");
        }
        validateHmacParams(aesCtrHmacStreamingParams.getHmacParams());
        if (aesCtrHmacStreamingParams.getCiphertextSegmentSize() < aesCtrHmacStreamingParams.getDerivedKeySize() + aesCtrHmacStreamingParams.getHmacParams().getTagSize() + 2 + 7) {
            throw new GeneralSecurityException("ciphertext_segment_size must be at least (derived_key_size + tag_size + NONCE_PREFIX_IN_BYTES + 2)");
        }
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesCtrHmacStreamingKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey>(AesCtrHmacStreamingKeyFormat.class) { // from class: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesCtrHmacStreamingKey createKey(AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat) {
                return AesCtrHmacStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesCtrHmacStreamingKeyFormat.getKeySize()))).setParams(aesCtrHmacStreamingKeyFormat.getParams()).setVersion(AesCtrHmacStreamingKeyManager.this.getVersion()).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesCtrHmacStreamingKeyFormat>> keyFormats() {
                HashMap hashMap = new HashMap();
                HashType hashType = HashType.SHA256;
                AesCtrHmacStreamingKeyFormat createKeyFormat = AesCtrHmacStreamingKeyManager.createKeyFormat(16, hashType, 16, hashType, 32, 4096);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("AES128_CTR_HMAC_SHA256_4KB", new KeyTypeManager.KeyFactory.KeyFormat(createKeyFormat, outputPrefixType));
                hashMap.put("AES128_CTR_HMAC_SHA256_1MB", new KeyTypeManager.KeyFactory.KeyFormat(AesCtrHmacStreamingKeyManager.createKeyFormat(16, hashType, 16, hashType, 32, 1048576), outputPrefixType));
                hashMap.put("AES256_CTR_HMAC_SHA256_4KB", new KeyTypeManager.KeyFactory.KeyFormat(AesCtrHmacStreamingKeyManager.createKeyFormat(32, hashType, 32, hashType, 32, 4096), outputPrefixType));
                hashMap.put("AES256_CTR_HMAC_SHA256_1MB", new KeyTypeManager.KeyFactory.KeyFormat(AesCtrHmacStreamingKeyManager.createKeyFormat(32, hashType, 32, hashType, 32, 1048576), outputPrefixType));
                return Collections.unmodifiableMap(hashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesCtrHmacStreamingKeyFormat parseKeyFormat(ByteString byteString) {
                return AesCtrHmacStreamingKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat) {
                if (aesCtrHmacStreamingKeyFormat.getKeySize() < 16) {
                    throw new GeneralSecurityException("key_size must be at least 16 bytes");
                }
                AesCtrHmacStreamingKeyManager.validateParams(aesCtrHmacStreamingKeyFormat.getParams());
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public AesCtrHmacStreamingKey parseKey(ByteString byteString) {
        return AesCtrHmacStreamingKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) {
        Validators.validateVersion(aesCtrHmacStreamingKey.getVersion(), getVersion());
        if (aesCtrHmacStreamingKey.getKeyValue().size() < 16) {
            throw new GeneralSecurityException("key_value must have at least 16 bytes");
        }
        if (aesCtrHmacStreamingKey.getKeyValue().size() < aesCtrHmacStreamingKey.getParams().getDerivedKeySize()) {
            throw new GeneralSecurityException("key_value must have at least as many bits as derived keys");
        }
        validateParams(aesCtrHmacStreamingKey.getParams());
    }
}
