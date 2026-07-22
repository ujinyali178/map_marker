package com.google.crypto.tink;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
final class Util {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Util() {
    }

    public static KeysetInfo.KeyInfo getKeyInfo(Keyset.Key key) {
        return KeysetInfo.KeyInfo.newBuilder().setTypeUrl(key.getKeyData().getTypeUrl()).setStatus(key.getStatus()).setOutputPrefixType(key.getOutputPrefixType()).setKeyId(key.getKeyId()).build();
    }

    public static KeysetInfo getKeysetInfo(Keyset keyset) {
        KeysetInfo.Builder primaryKeyId = KeysetInfo.newBuilder().setPrimaryKeyId(keyset.getPrimaryKeyId());
        Iterator<Keyset.Key> it = keyset.getKeyList().iterator();
        while (it.hasNext()) {
            primaryKeyId.addKeyInfo(getKeyInfo(it.next()));
        }
        return primaryKeyId.build();
    }

    public static byte[] readAll(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[UserVerificationMethods.USER_VERIFY_ALL];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void validateKey(Keyset.Key key) {
        if (!key.hasKeyData()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(key.getKeyId())));
        }
        if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(key.getKeyId())));
        }
        if (key.getStatus() == KeyStatusType.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(key.getKeyId())));
        }
    }

    public static void validateKeyset(Keyset keyset) {
        int primaryKeyId = keyset.getPrimaryKeyId();
        int i3 = 0;
        boolean z3 = false;
        boolean z4 = true;
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getStatus() == KeyStatusType.ENABLED) {
                validateKey(key);
                if (key.getKeyId() == primaryKeyId) {
                    if (z3) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z3 = true;
                }
                if (key.getKeyData().getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z4 = false;
                }
                i3++;
            }
        }
        if (i3 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z3 && !z4) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
