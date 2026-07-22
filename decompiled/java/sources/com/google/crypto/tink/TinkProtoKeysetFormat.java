package com.google.crypto.tink;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: /root/release/classes.dex */
public final class TinkProtoKeysetFormat {
    private TinkProtoKeysetFormat() {
    }

    public static KeysetHandle parseEncryptedKeyset(byte[] bArr, Aead aead, byte[] bArr2) {
        try {
            return KeysetHandle.readWithAssociatedData(BinaryKeysetReader.withBytes(bArr), aead, bArr2);
        } catch (IOException unused) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }

    public static KeysetHandle parseKeyset(byte[] bArr, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess cannot be null");
        }
        try {
            return CleartextKeysetHandle.read(BinaryKeysetReader.withBytes(bArr));
        } catch (IOException unused) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }

    public static KeysetHandle parseKeysetWithoutSecret(byte[] bArr) {
        try {
            return KeysetHandle.readNoSecret(BinaryKeysetReader.withBytes(bArr));
        } catch (IOException unused) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }

    public static byte[] serializeEncryptedKeyset(KeysetHandle keysetHandle, Aead aead, byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keysetHandle.writeWithAssociatedData(BinaryKeysetWriter.withOutputStream(byteArrayOutputStream), aead, bArr);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new GeneralSecurityException("Serialize keyset failed");
        }
    }

    public static byte[] serializeKeyset(KeysetHandle keysetHandle, SecretKeyAccess secretKeyAccess) {
        if (secretKeyAccess == null) {
            throw new NullPointerException("SecretKeyAccess cannot be null");
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CleartextKeysetHandle.write(keysetHandle, BinaryKeysetWriter.withOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new GeneralSecurityException("Serialize keyset failed");
        }
    }

    public static byte[] serializeKeysetWithoutSecret(KeysetHandle keysetHandle) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            keysetHandle.writeNoSecret(BinaryKeysetWriter.withOutputStream(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new GeneralSecurityException("Serialize keyset failed");
        }
    }
}
