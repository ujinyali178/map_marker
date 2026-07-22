package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: /root/release/classes.dex */
class PrivateKeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyManagerImpl<PrimitiveT, KeyProtoT> implements PrivateKeyManager<PrimitiveT> {
    private final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyManager;
    private final KeyTypeManager<PublicKeyProtoT> publicKeyManager;

    public PrivateKeyManagerImpl(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, KeyTypeManager<PublicKeyProtoT> keyTypeManager, Class<PrimitiveT> cls) {
        super(privateKeyTypeManager, cls);
        this.privateKeyManager = privateKeyTypeManager;
        this.publicKeyManager = keyTypeManager;
    }

    @Override // com.google.crypto.tink.PrivateKeyManager
    public KeyData getPublicKeyData(ByteString byteString) {
        try {
            KeyProtoT parseKey = this.privateKeyManager.parseKey(byteString);
            this.privateKeyManager.validateKey(parseKey);
            PublicKeyProtoT publicKey = this.privateKeyManager.getPublicKey(parseKey);
            this.publicKeyManager.validateKey(publicKey);
            return KeyData.newBuilder().setTypeUrl(this.publicKeyManager.getKeyType()).setValue(publicKey.toByteString()).setKeyMaterialType(this.publicKeyManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e3) {
            throw new GeneralSecurityException("expected serialized proto of type ", e3);
        }
    }
}
