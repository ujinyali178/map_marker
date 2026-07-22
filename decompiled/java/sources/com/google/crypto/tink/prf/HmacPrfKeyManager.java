package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacPrfKey;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.PrfHmacJce;
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
public final class HmacPrfKeyManager extends KeyTypeManager<HmacPrfKey> {
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;

    /* renamed from: com.google.crypto.tink.prf.HmacPrfKeyManager$3, reason: invalid class name */
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

    public HmacPrfKeyManager() {
        super(HmacPrfKey.class, new PrimitiveFactory<Prf, HmacPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Prf getPrimitive(HmacPrfKey hmacPrfKey) {
                HashType hash = hmacPrfKey.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacPrfKey.getKeyValue().toByteArray(), "HMAC");
                int i3 = AnonymousClass3.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
                if (i3 == 1) {
                    return new PrfHmacJce("HMACSHA1", secretKeySpec);
                }
                if (i3 == 2) {
                    return new PrfHmacJce("HMACSHA224", secretKeySpec);
                }
                if (i3 == 3) {
                    return new PrfHmacJce("HMACSHA256", secretKeySpec);
                }
                if (i3 == 4) {
                    return new PrfHmacJce("HMACSHA384", secretKeySpec);
                }
                if (i3 == 5) {
                    return new PrfHmacJce("HMACSHA512", secretKeySpec);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    private static KeyTemplate createTemplate(int i3, HashType hashType) {
        return KeyTemplate.create(new HmacPrfKeyManager().getKeyType(), HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().setHash(hashType).build()).setKeySize(i3).build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate hmacSha256Template() {
        return createTemplate(32, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha512Template() {
        return createTemplate(64, HashType.SHA512);
    }

    public static void register(boolean z3) {
        Registry.registerKeyManager(new HmacPrfKeyManager(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(HmacPrfParams hmacPrfParams) {
        if (hmacPrfParams.getHash() != HashType.SHA1 && hmacPrfParams.getHash() != HashType.SHA224 && hmacPrfParams.getHash() != HashType.SHA256 && hmacPrfParams.getHash() != HashType.SHA384 && hmacPrfParams.getHash() != HashType.SHA512) {
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, HmacPrfKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacPrfKeyFormat, HmacPrfKey>(HmacPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HmacPrfKey createKey(HmacPrfKeyFormat hmacPrfKeyFormat) {
                return HmacPrfKey.newBuilder().setVersion(HmacPrfKeyManager.this.getVersion()).setParams(hmacPrfKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(hmacPrfKeyFormat.getKeySize()))).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HmacPrfKey deriveKey(HmacPrfKeyFormat hmacPrfKeyFormat, InputStream inputStream) {
                Validators.validateVersion(hmacPrfKeyFormat.getVersion(), HmacPrfKeyManager.this.getVersion());
                byte[] bArr = new byte[hmacPrfKeyFormat.getKeySize()];
                try {
                    KeyTypeManager.KeyFactory.readFully(inputStream, bArr);
                    return HmacPrfKey.newBuilder().setVersion(HmacPrfKeyManager.this.getVersion()).setParams(hmacPrfKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(bArr)).build();
                } catch (IOException e3) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e3);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<HmacPrfKeyFormat>> keyFormats() {
                HashMap hashMap = new HashMap();
                HmacPrfKeyFormat build = HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().setHash(HashType.SHA256).build()).setKeySize(32).build();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("HMAC_SHA256_PRF", new KeyTypeManager.KeyFactory.KeyFormat(build, outputPrefixType));
                hashMap.put("HMAC_SHA512_PRF", new KeyTypeManager.KeyFactory.KeyFormat(HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().setHash(HashType.SHA512).build()).setKeySize(64).build(), outputPrefixType));
                return Collections.unmodifiableMap(hashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HmacPrfKeyFormat parseKeyFormat(ByteString byteString) {
                return HmacPrfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(HmacPrfKeyFormat hmacPrfKeyFormat) {
                if (hmacPrfKeyFormat.getKeySize() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                HmacPrfKeyManager.validateParams(hmacPrfKeyFormat.getParams());
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public HmacPrfKey parseKey(ByteString byteString) {
        return HmacPrfKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(HmacPrfKey hmacPrfKey) {
        Validators.validateVersion(hmacPrfKey.getVersion(), getVersion());
        if (hmacPrfKey.getKeyValue().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        validateParams(hmacPrfKey.getParams());
    }
}
