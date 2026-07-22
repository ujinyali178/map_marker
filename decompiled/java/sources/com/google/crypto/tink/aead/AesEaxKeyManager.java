package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.AesEaxJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /root/release/classes.dex */
public final class AesEaxKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.AesEaxKey> {
    AesEaxKeyManager() {
        super(com.google.crypto.tink.proto.AesEaxKey.class, new PrimitiveFactory<Aead, com.google.crypto.tink.proto.AesEaxKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesEaxKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Aead getPrimitive(com.google.crypto.tink.proto.AesEaxKey aesEaxKey) {
                return new AesEaxJce(aesEaxKey.getKeyValue().toByteArray(), aesEaxKey.getParams().getIvSize());
            }
        });
    }

    public static final KeyTemplate aes128EaxTemplate() {
        return createKeyTemplate(16, 16, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate aes256EaxTemplate() {
        return createKeyTemplate(32, 16, KeyTemplate.OutputPrefixType.TINK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<AesEaxKeyFormat> createKeyFormat(int i3, int i4, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(AesEaxKeyFormat.newBuilder().setKeySize(i3).setParams(AesEaxParams.newBuilder().setIvSize(i4).build()).build(), outputPrefixType);
    }

    private static KeyTemplate createKeyTemplate(int i3, int i4, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new AesEaxKeyManager().getKeyType(), AesEaxKeyFormat.newBuilder().setKeySize(i3).setParams(AesEaxParams.newBuilder().setIvSize(i4).build()).build().toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate rawAes128EaxTemplate() {
        return createKeyTemplate(16, 16, KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate rawAes256EaxTemplate() {
        return createKeyTemplate(32, 16, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z3) {
        Registry.registerKeyManager(new AesEaxKeyManager(), z3);
        AesEaxProtoSerialization.register();
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, com.google.crypto.tink.proto.AesEaxKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesEaxKeyFormat, com.google.crypto.tink.proto.AesEaxKey>(AesEaxKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesEaxKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.AesEaxKey createKey(AesEaxKeyFormat aesEaxKeyFormat) {
                return com.google.crypto.tink.proto.AesEaxKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesEaxKeyFormat.getKeySize()))).setParams(aesEaxKeyFormat.getParams()).setVersion(AesEaxKeyManager.this.getVersion()).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesEaxKeyFormat>> keyFormats() {
                HashMap hashMap = new HashMap();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                hashMap.put("AES128_EAX", AesEaxKeyManager.createKeyFormat(16, 16, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("AES128_EAX_RAW", AesEaxKeyManager.createKeyFormat(16, 16, outputPrefixType2));
                hashMap.put("AES256_EAX", AesEaxKeyManager.createKeyFormat(32, 16, outputPrefixType));
                hashMap.put("AES256_EAX_RAW", AesEaxKeyManager.createKeyFormat(32, 16, outputPrefixType2));
                return Collections.unmodifiableMap(hashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesEaxKeyFormat parseKeyFormat(ByteString byteString) {
                return AesEaxKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesEaxKeyFormat aesEaxKeyFormat) {
                Validators.validateAesKeySize(aesEaxKeyFormat.getKeySize());
                if (aesEaxKeyFormat.getParams().getIvSize() != 12 && aesEaxKeyFormat.getParams().getIvSize() != 16) {
                    throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
                }
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public com.google.crypto.tink.proto.AesEaxKey parseKey(ByteString byteString) {
        return com.google.crypto.tink.proto.AesEaxKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(com.google.crypto.tink.proto.AesEaxKey aesEaxKey) {
        Validators.validateVersion(aesEaxKey.getVersion(), getVersion());
        Validators.validateAesKeySize(aesEaxKey.getKeyValue().size());
        if (aesEaxKey.getParams().getIvSize() != 12 && aesEaxKey.getParams().getIvSize() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
