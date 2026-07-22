package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: /root/release/classes.dex */
public final class NoSecretKeysetHandle {
    private NoSecretKeysetHandle() {
    }

    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) {
        try {
            Keyset parseFrom = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            validate(parseFrom);
            return KeysetHandle.fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle read(KeysetReader keysetReader) {
        Keyset read = keysetReader.read();
        validate(read);
        return KeysetHandle.fromKeyset(read);
    }

    private static void validate(Keyset keyset) {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}
