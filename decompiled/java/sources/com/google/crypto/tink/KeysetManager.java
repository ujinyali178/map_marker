package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyStatusTypeProtoConverter;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: /root/release/classes.dex */
public final class KeysetManager {
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder builder) {
        this.keysetBuilder = builder;
    }

    private synchronized Keyset.Key createKeysetKey(KeyData keyData, OutputPrefixType outputPrefixType) {
        int newKeyId;
        newKeyId = newKeyId();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return Keyset.Key.newBuilder().setKeyData(keyData).setKeyId(newKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
    }

    private synchronized boolean keyIdExists(int i3) {
        boolean z3;
        Iterator<Keyset.Key> it = this.keysetBuilder.getKeyList().iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            }
            if (it.next().getKeyId() == i3) {
                z3 = true;
                break;
            }
        }
        return z3;
    }

    private synchronized Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        return createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());
    }

    private synchronized int newKeyId() {
        int randKeyId;
        do {
            randKeyId = com.google.crypto.tink.internal.Util.randKeyId();
        } while (keyIdExists(randKeyId));
        return randKeyId;
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager(keysetHandle.getKeyset().toBuilder());
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) {
        addNewKey(keyTemplate.getProto(), false);
        return this;
    }

    @Deprecated
    public synchronized KeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        addNewKey(keyTemplate, false);
        return this;
    }

    public synchronized KeysetManager add(KeyHandle keyHandle) {
        try {
            try {
                ProtoKey protoKey = (ProtoKey) keyHandle.getKey(com.google.crypto.tink.tinkkey.SecretKeyAccess.insecureSecretAccess());
                if (keyIdExists(keyHandle.getId())) {
                    throw new GeneralSecurityException("Trying to add a key with an ID already contained in the keyset.");
                }
                this.keysetBuilder.addKey(Keyset.Key.newBuilder().setKeyData(protoKey.getProtoKey()).setKeyId(keyHandle.getId()).setStatus(KeyStatusTypeProtoConverter.toProto(keyHandle.getStatus())).setOutputPrefixType(KeyTemplate.toProto(protoKey.getOutputPrefixType())).build());
            } catch (ClassCastException e3) {
                throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized KeysetManager add(KeyHandle keyHandle, KeyAccess keyAccess) {
        return add(keyHandle);
    }

    @Deprecated
    public synchronized int addNewKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean z3) {
        Keyset.Key newKey;
        newKey = newKey(keyTemplate);
        this.keysetBuilder.addKey(newKey);
        if (z3) {
            this.keysetBuilder.setPrimaryKeyId(newKey.getKeyId());
        }
        return newKey.getKeyId();
    }

    public synchronized KeysetManager delete(int i3) {
        if (i3 == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot delete the primary key");
        }
        for (int i4 = 0; i4 < this.keysetBuilder.getKeyCount(); i4++) {
            if (this.keysetBuilder.getKey(i4).getKeyId() == i3) {
                this.keysetBuilder.removeKey(i4);
            }
        }
        throw new GeneralSecurityException("key not found: " + i3);
        return this;
    }

    public synchronized KeysetManager destroy(int i3) {
        if (i3 == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot destroy the primary key");
        }
        for (int i4 = 0; i4 < this.keysetBuilder.getKeyCount(); i4++) {
            Keyset.Key key = this.keysetBuilder.getKey(i4);
            if (key.getKeyId() == i3) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED && key.getStatus() != KeyStatusType.DESTROYED) {
                    throw new GeneralSecurityException("cannot destroy key with id " + i3);
                }
                this.keysetBuilder.setKey(i4, key.toBuilder().setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
            }
        }
        throw new GeneralSecurityException("key not found: " + i3);
        return this;
    }

    public synchronized KeysetManager disable(int i3) {
        if (i3 == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot disable the primary key");
        }
        for (int i4 = 0; i4 < this.keysetBuilder.getKeyCount(); i4++) {
            Keyset.Key key = this.keysetBuilder.getKey(i4);
            if (key.getKeyId() == i3) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                    throw new GeneralSecurityException("cannot disable key with id " + i3);
                }
                this.keysetBuilder.setKey(i4, key.toBuilder().setStatus(KeyStatusType.DISABLED).build());
            }
        }
        throw new GeneralSecurityException("key not found: " + i3);
        return this;
    }

    public synchronized KeysetManager enable(int i3) {
        for (int i4 = 0; i4 < this.keysetBuilder.getKeyCount(); i4++) {
            Keyset.Key key = this.keysetBuilder.getKey(i4);
            if (key.getKeyId() == i3) {
                KeyStatusType status = key.getStatus();
                KeyStatusType keyStatusType = KeyStatusType.ENABLED;
                if (status != keyStatusType && key.getStatus() != KeyStatusType.DISABLED) {
                    throw new GeneralSecurityException("cannot enable key with id " + i3);
                }
                this.keysetBuilder.setKey(i4, key.toBuilder().setStatus(keyStatusType).build());
            }
        }
        throw new GeneralSecurityException("key not found: " + i3);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() {
        return KeysetHandle.fromKeyset(this.keysetBuilder.build());
    }

    @Deprecated
    public synchronized KeysetManager promote(int i3) {
        return setPrimary(i3);
    }

    @Deprecated
    public synchronized KeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        addNewKey(keyTemplate, true);
        return this;
    }

    public synchronized KeysetManager setPrimary(int i3) {
        for (int i4 = 0; i4 < this.keysetBuilder.getKeyCount(); i4++) {
            Keyset.Key key = this.keysetBuilder.getKey(i4);
            if (key.getKeyId() == i3) {
                if (!key.getStatus().equals(KeyStatusType.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i3);
                }
                this.keysetBuilder.setPrimaryKeyId(i3);
            }
        }
        throw new GeneralSecurityException("key not found: " + i3);
        return this;
    }
}
