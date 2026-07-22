package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.subtle.AesGcmSiv;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesGcmSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: /root/release/classes.dex */
public final class AesGcmSivKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.AesGcmSivKey> {
    AesGcmSivKeyManager() {
        super(com.google.crypto.tink.proto.AesGcmSivKey.class, new PrimitiveFactory<Aead, com.google.crypto.tink.proto.AesGcmSivKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Aead getPrimitive(com.google.crypto.tink.proto.AesGcmSivKey aesGcmSivKey) {
                return new AesGcmSiv(aesGcmSivKey.getKeyValue().toByteArray());
            }
        });
    }

    public static final KeyTemplate aes128GcmSivTemplate() {
        return createKeyTemplate(16, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate aes256GcmSivTemplate() {
        return createKeyTemplate(32, KeyTemplate.OutputPrefixType.TINK);
    }

    private static boolean canUseAesGcmSive() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<AesGcmSivKeyFormat> createKeyFormat(int i3, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(AesGcmSivKeyFormat.newBuilder().setKeySize(i3).build(), outputPrefixType);
    }

    private static KeyTemplate createKeyTemplate(int i3, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.create(new AesGcmSivKeyManager().getKeyType(), AesGcmSivKeyFormat.newBuilder().setKeySize(i3).build().toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate rawAes128GcmSivTemplate() {
        return createKeyTemplate(16, KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate rawAes256GcmSivTemplate() {
        return createKeyTemplate(32, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z3) {
        if (canUseAesGcmSive()) {
            Registry.registerKeyManager(new AesGcmSivKeyManager(), z3);
            AesGcmSivProtoSerialization.register();
        }
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, com.google.crypto.tink.proto.AesGcmSivKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesGcmSivKeyFormat, com.google.crypto.tink.proto.AesGcmSivKey>(AesGcmSivKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.AesGcmSivKey createKey(AesGcmSivKeyFormat aesGcmSivKeyFormat) {
                return com.google.crypto.tink.proto.AesGcmSivKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(aesGcmSivKeyFormat.getKeySize()))).setVersion(AesGcmSivKeyManager.this.getVersion()).build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public com.google.crypto.tink.proto.AesGcmSivKey deriveKey(AesGcmSivKeyFormat aesGcmSivKeyFormat, InputStream inputStream) {
                Validators.validateVersion(aesGcmSivKeyFormat.getVersion(), AesGcmSivKeyManager.this.getVersion());
                byte[] bArr = new byte[aesGcmSivKeyFormat.getKeySize()];
                try {
                    KeyTypeManager.KeyFactory.readFully(inputStream, bArr);
                    return com.google.crypto.tink.proto.AesGcmSivKey.newBuilder().setKeyValue(ByteString.copyFrom(bArr)).setVersion(AesGcmSivKeyManager.this.getVersion()).build();
                } catch (IOException e3) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e3);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesGcmSivKeyFormat>> keyFormats() {
                HashMap hashMap = new HashMap();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                hashMap.put("AES128_GCM_SIV", AesGcmSivKeyManager.createKeyFormat(16, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                hashMap.put("AES128_GCM_SIV_RAW", AesGcmSivKeyManager.createKeyFormat(16, outputPrefixType2));
                hashMap.put("AES256_GCM_SIV", AesGcmSivKeyManager.createKeyFormat(32, outputPrefixType));
                hashMap.put("AES256_GCM_SIV_RAW", AesGcmSivKeyManager.createKeyFormat(32, outputPrefixType2));
                return Collections.unmodifiableMap(hashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesGcmSivKeyFormat parseKeyFormat(ByteString byteString) {
                return AesGcmSivKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesGcmSivKeyFormat aesGcmSivKeyFormat) {
                Validators.validateAesKeySize(aesGcmSivKeyFormat.getKeySize());
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public com.google.crypto.tink.proto.AesGcmSivKey parseKey(ByteString byteString) {
        return com.google.crypto.tink.proto.AesGcmSivKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(com.google.crypto.tink.proto.AesGcmSivKey aesGcmSivKey) {
        Validators.validateVersion(aesGcmSivKey.getVersion(), getVersion());
        Validators.validateAesKeySize(aesGcmSivKey.getKeyValue().size());
    }
}
