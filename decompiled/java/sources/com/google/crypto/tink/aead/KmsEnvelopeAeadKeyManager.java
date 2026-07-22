package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KmsClients;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: /root/release/classes.dex */
public class KmsEnvelopeAeadKeyManager extends KeyTypeManager<KmsEnvelopeAeadKey> {
    KmsEnvelopeAeadKeyManager() {
        super(KmsEnvelopeAeadKey.class, new PrimitiveFactory<Aead, KmsEnvelopeAeadKey>(Aead.class) { // from class: com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public Aead getPrimitive(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) {
                String kekUri = kmsEnvelopeAeadKey.getParams().getKekUri();
                return new KmsEnvelopeAead(kmsEnvelopeAeadKey.getParams().getDekTemplate(), KmsClients.get(kekUri).getAead(kekUri));
            }
        });
    }

    static KmsEnvelopeAeadKeyFormat createKeyFormat(String str, KeyTemplate keyTemplate) {
        return KmsEnvelopeAeadKeyFormat.newBuilder().setDekTemplate(com.google.crypto.tink.proto.KeyTemplate.newBuilder().setTypeUrl(keyTemplate.getTypeUrl()).setValue(ByteString.copyFrom(keyTemplate.getValue())).build()).setKekUri(str).build();
    }

    public static KeyTemplate createKeyTemplate(String str, KeyTemplate keyTemplate) {
        return KeyTemplate.create(new KmsEnvelopeAeadKeyManager().getKeyType(), createKeyFormat(str, keyTemplate).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z3) {
        Registry.registerKeyManager(new KmsEnvelopeAeadKeyManager(), z3);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, KmsEnvelopeAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey>(KmsEnvelopeAeadKeyFormat.class) { // from class: com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public KmsEnvelopeAeadKey createKey(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
                return KmsEnvelopeAeadKey.newBuilder().setParams(kmsEnvelopeAeadKeyFormat).setVersion(KmsEnvelopeAeadKeyManager.this.getVersion()).build();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public KmsEnvelopeAeadKeyFormat parseKeyFormat(ByteString byteString) {
                return KmsEnvelopeAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
                if (kmsEnvelopeAeadKeyFormat.getKekUri().isEmpty() || !kmsEnvelopeAeadKeyFormat.hasDekTemplate()) {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
            }
        };
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.REMOTE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KmsEnvelopeAeadKey parseKey(ByteString byteString) {
        return KmsEnvelopeAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) {
        Validators.validateVersion(kmsEnvelopeAeadKey.getVersion(), getVersion());
    }
}
