package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.mac.internal.ChunkedHmacImpl;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /root/release/classes.dex */
public final class HmacKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.HmacKey> {
    private static final PrimitiveConstructor<HmacKey, ChunkedMac> CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: com.google.crypto.tink.mac.f
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(Key key) {
            return new ChunkedHmacImpl((HmacKey) key);
        }
    }, HmacKey.class, ChunkedMac.class);
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;

    /* renamed from: com.google.crypto.tink.mac.HmacKeyManager$3, reason: invalid class name */
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
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public HmacKeyManager() {
        super(com.google.crypto.tink.proto.HmacKey.class, new PrimitiveFactory<Mac, com.google.crypto.tink.proto.HmacKey>(Mac.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Mac getPrimitive(com.google.crypto.tink.proto.HmacKey hmacKey) {
                HashType hash = hmacKey.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.getKeyValue().toByteArray(), "HMAC");
                int tagSize = hmacKey.getParams().getTagSize();
                int i3 = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
                if (i3 == 1) {
                    return new PrfMac(new PrfHmacJce("HMACSHA1", secretKeySpec), tagSize);
                }
                if (i3 == 2) {
                    return new PrfMac(new PrfHmacJce("HMACSHA224", secretKeySpec), tagSize);
                }
                if (i3 == 3) {
                    return new PrfMac(new PrfHmacJce("HMACSHA256", secretKeySpec), tagSize);
                }
                if (i3 == 4) {
                    return new PrfMac(new PrfHmacJce("HMACSHA384", secretKeySpec), tagSize);
                }
                if (i3 == 5) {
                    return new PrfMac(new PrfHmacJce("HMACSHA512", secretKeySpec), tagSize);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<HmacKeyFormat> createKeyFormat(int i3, int i4, HashType hashType, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(HmacKeyFormat.newBuilder().setParams(HmacParams.newBuilder().setHash(hashType).setTagSize(i4).build()).setKeySize(i3).build(), outputPrefixType);
    }

    private static KeyTemplate createTemplate(int i3, int i4, HashType hashType) {
        return KeyTemplate.create(new HmacKeyManager().getKeyType(), HmacKeyFormat.newBuilder().setParams(HmacParams.newBuilder().setHash(hashType).setTagSize(i4).build()).setKeySize(i3).build().toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate hmacSha256HalfDigestTemplate() {
        return createTemplate(32, 16, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha256Template() {
        return createTemplate(32, 32, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha512HalfDigestTemplate() {
        return createTemplate(64, 32, HashType.SHA512);
    }

    public static final KeyTemplate hmacSha512Template() {
        return createTemplate(64, 64, HashType.SHA512);
    }

    public static void register(boolean z3) {
        Registry.registerKeyManager(new HmacKeyManager(), z3);
        HmacProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(HmacParams hmacParams) {
        if (hmacParams.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i3 = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hmacParams.getHash().ordinal()];
        if (i3 == 1) {
            if (hmacParams.getTagSize() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i3 == 2) {
            if (hmacParams.getTagSize() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i3 == 3) {
            if (hmacParams.getTagSize() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i3 == 4) {
            if (hmacParams.getTagSize() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i3 != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (hmacParams.getTagSize() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, com.google.crypto.tink.proto.HmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacKeyFormat, com.google.crypto.tink.proto.HmacKey>(HmacKeyFormat.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.HmacKey createKey(HmacKeyFormat hmacKeyFormat) {
                return com.google.crypto.tink.proto.HmacKey.newBuilder().setVersion(HmacKeyManager.this.getVersion()).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(hmacKeyFormat.getKeySize()))).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.HmacKey deriveKey(HmacKeyFormat hmacKeyFormat, InputStream inputStream) {
                Validators.validateVersion(hmacKeyFormat.getVersion(), HmacKeyManager.this.getVersion());
                byte[] bArr = new byte[hmacKeyFormat.getKeySize()];
                try {
                    KeyTypeManager.KeyFactory.readFully(inputStream, bArr);
                    return com.google.crypto.tink.proto.HmacKey.newBuilder().setVersion(HmacKeyManager.this.getVersion()).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(bArr)).build();
                } catch (IOException e3) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e3);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<HmacKeyFormat>> keyFormats() {
                HashMap hashMap = new HashMap();
                HashType hashType = HashType.SHA256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                hashMap.put("HMAC_SHA256_128BITTAG", HmacKeyManager.createKeyFormat(32, 16, hashType, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("HMAC_SHA256_128BITTAG_RAW", HmacKeyManager.createKeyFormat(32, 16, hashType, outputPrefixType2));
                hashMap.put("HMAC_SHA256_256BITTAG", HmacKeyManager.createKeyFormat(32, 32, hashType, outputPrefixType));
                hashMap.put("HMAC_SHA256_256BITTAG_RAW", HmacKeyManager.createKeyFormat(32, 32, hashType, outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                hashMap.put("HMAC_SHA512_128BITTAG", HmacKeyManager.createKeyFormat(64, 16, hashType2, outputPrefixType));
                hashMap.put("HMAC_SHA512_128BITTAG_RAW", HmacKeyManager.createKeyFormat(64, 16, hashType2, outputPrefixType2));
                hashMap.put("HMAC_SHA512_256BITTAG", HmacKeyManager.createKeyFormat(64, 32, hashType2, outputPrefixType));
                hashMap.put("HMAC_SHA512_256BITTAG_RAW", HmacKeyManager.createKeyFormat(64, 32, hashType2, outputPrefixType2));
                hashMap.put("HMAC_SHA512_512BITTAG", HmacKeyManager.createKeyFormat(64, 64, hashType2, outputPrefixType));
                hashMap.put("HMAC_SHA512_512BITTAG_RAW", HmacKeyManager.createKeyFormat(64, 64, hashType2, outputPrefixType2));
                return Collections.unmodifiableMap(hashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HmacKeyFormat parseKeyFormat(ByteString byteString) {
                return HmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(HmacKeyFormat hmacKeyFormat) {
                if (hmacKeyFormat.getKeySize() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                HmacKeyManager.validateParams(hmacKeyFormat.getParams());
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public com.google.crypto.tink.proto.HmacKey parseKey(ByteString byteString) {
        return com.google.crypto.tink.proto.HmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(com.google.crypto.tink.proto.HmacKey hmacKey) {
        Validators.validateVersion(hmacKey.getVersion(), getVersion());
        if (hmacKey.getKeyValue().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        validateParams(hmacKey.getParams());
    }
}
