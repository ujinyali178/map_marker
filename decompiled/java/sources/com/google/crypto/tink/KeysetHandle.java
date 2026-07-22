package com.google.crypto.tink;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.LegacyProtoParameters;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.InternalKeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class KeysetHandle {
    private final MonitoringAnnotations annotations;
    private final List<Entry> entries;
    private final Keyset keyset;

    /* renamed from: com.google.crypto.tink.KeysetHandle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        static {
            int[] iArr = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr;
            try {
                iArr[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class Builder {
        private final List<Entry> entries = new ArrayList();

        public static final class Entry {

            @Nullable
            private Builder builder;
            private boolean isPrimary;

            @Nullable
            private final Key key;
            private KeyStatus keyStatus;

            @Nullable
            private final Parameters parameters;
            private KeyIdStrategy strategy;

            private Entry(Key key) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = key;
                this.parameters = null;
            }

            /* synthetic */ Entry(Key key, AnonymousClass1 anonymousClass1) {
                this(key);
            }

            private Entry(Parameters parameters) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = null;
                this.parameters = parameters;
            }

            /* synthetic */ Entry(Parameters parameters, AnonymousClass1 anonymousClass1) {
                this(parameters);
            }

            public KeyStatus getStatus() {
                return this.keyStatus;
            }

            public boolean isPrimary() {
                return this.isPrimary;
            }

            public Entry makePrimary() {
                Builder builder = this.builder;
                if (builder != null) {
                    builder.clearPrimary();
                }
                this.isPrimary = true;
                return this;
            }

            public Entry setStatus(KeyStatus keyStatus) {
                this.keyStatus = keyStatus;
                return this;
            }

            public Entry withFixedId(int i3) {
                this.strategy = KeyIdStrategy.fixedId(i3);
                return this;
            }

            public Entry withRandomId() {
                this.strategy = KeyIdStrategy.randomId();
                return this;
            }
        }

        private static class KeyIdStrategy {
            private static final KeyIdStrategy RANDOM_ID = new KeyIdStrategy();
            private final int fixedId;

            private KeyIdStrategy() {
                this.fixedId = 0;
            }

            private KeyIdStrategy(int i3) {
                this.fixedId = i3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy fixedId(int i3) {
                return new KeyIdStrategy(i3);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int getFixedId() {
                return this.fixedId;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static KeyIdStrategy randomId() {
                return RANDOM_ID;
            }
        }

        private static void checkIdAssignments(List<Entry> list) {
            for (int i3 = 0; i3 < list.size() - 1; i3++) {
                if (list.get(i3).strategy == KeyIdStrategy.RANDOM_ID && list.get(i3 + 1).strategy != KeyIdStrategy.RANDOM_ID) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimary() {
            Iterator<Entry> it = this.entries.iterator();
            while (it.hasNext()) {
                it.next().isPrimary = false;
            }
        }

        private static Keyset.Key createKeyFromParameters(Parameters parameters, int i3, KeyStatusType keyStatusType) {
            ProtoParametersSerialization serialization = parameters instanceof LegacyProtoParameters ? ((LegacyProtoParameters) parameters).getSerialization() : (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(parameters, ProtoParametersSerialization.class);
            return Keyset.Key.newBuilder().setKeyId(i3).setStatus(keyStatusType).setKeyData(Registry.newKeyData(serialization.getKeyTemplate())).setOutputPrefixType(serialization.getKeyTemplate().getOutputPrefixType()).build();
        }

        private static Keyset.Key createKeysetKeyFromBuilderEntry(Entry entry, int i3) {
            if (entry.key == null) {
                return createKeyFromParameters(entry.parameters, i3, KeysetHandle.serializeStatus(entry.getStatus()));
            }
            ProtoKeySerialization serialization = entry.key instanceof LegacyProtoKey ? ((LegacyProtoKey) entry.key).getSerialization(InsecureSecretKeyAccess.get()) : (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(entry.key, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
            Integer idRequirementOrNull = serialization.getIdRequirementOrNull();
            if (idRequirementOrNull == null || idRequirementOrNull.intValue() == i3) {
                return KeysetHandle.toKeysetKey(i3, KeysetHandle.serializeStatus(entry.getStatus()), serialization);
            }
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }

        private static int getNextIdFromBuilderEntry(Entry entry, Set<Integer> set) {
            if (entry.strategy != null) {
                return entry.strategy == KeyIdStrategy.RANDOM_ID ? randomIdNotInSet(set) : entry.strategy.getFixedId();
            }
            throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
        }

        private static int randomIdNotInSet(Set<Integer> set) {
            int i3 = 0;
            while (true) {
                if (i3 != 0 && !set.contains(Integer.valueOf(i3))) {
                    return i3;
                }
                i3 = com.google.crypto.tink.internal.Util.randKeyId();
            }
        }

        public Builder addEntry(Entry entry) {
            if (entry.builder != null) {
                throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
            }
            if (entry.isPrimary) {
                clearPrimary();
            }
            entry.builder = this;
            this.entries.add(entry);
            return this;
        }

        public KeysetHandle build() {
            Keyset.Builder newBuilder = Keyset.newBuilder();
            checkIdAssignments(this.entries);
            HashSet hashSet = new HashSet();
            Integer num = null;
            for (Entry entry : this.entries) {
                if (entry.keyStatus == null) {
                    throw new GeneralSecurityException("Key Status not set.");
                }
                int nextIdFromBuilderEntry = getNextIdFromBuilderEntry(entry, hashSet);
                if (hashSet.contains(Integer.valueOf(nextIdFromBuilderEntry))) {
                    throw new GeneralSecurityException("Id " + nextIdFromBuilderEntry + " is used twice in the keyset");
                }
                hashSet.add(Integer.valueOf(nextIdFromBuilderEntry));
                newBuilder.addKey(createKeysetKeyFromBuilderEntry(entry, nextIdFromBuilderEntry));
                if (entry.isPrimary) {
                    if (num != null) {
                        throw new GeneralSecurityException("Two primaries were set");
                    }
                    num = Integer.valueOf(nextIdFromBuilderEntry);
                }
            }
            if (num == null) {
                throw new GeneralSecurityException("No primary was set");
            }
            newBuilder.setPrimaryKeyId(num.intValue());
            return KeysetHandle.fromKeyset(newBuilder.build());
        }

        public Builder deleteAt(int i3) {
            this.entries.remove(i3);
            return this;
        }

        public Entry getAt(int i3) {
            return this.entries.get(i3);
        }

        @Deprecated
        public Entry removeAt(int i3) {
            return this.entries.remove(i3);
        }

        public int size() {
            return this.entries.size();
        }
    }

    @Immutable
    public static final class Entry {
        private final int id;
        private final boolean isPrimary;
        private final Key key;
        private final KeyStatus keyStatus;

        private Entry(Key key, KeyStatus keyStatus, int i3, boolean z3) {
            this.key = key;
            this.keyStatus = keyStatus;
            this.id = i3;
            this.isPrimary = z3;
        }

        /* synthetic */ Entry(Key key, KeyStatus keyStatus, int i3, boolean z3, AnonymousClass1 anonymousClass1) {
            this(key, keyStatus, i3, z3);
        }

        public int getId() {
            return this.id;
        }

        public Key getKey() {
            return this.key;
        }

        public KeyStatus getStatus() {
            return this.keyStatus;
        }

        public boolean isPrimary() {
            return this.isPrimary;
        }
    }

    private KeysetHandle(Keyset keyset, List<Entry> list) {
        this.keyset = keyset;
        this.entries = list;
        this.annotations = MonitoringAnnotations.EMPTY;
    }

    private KeysetHandle(Keyset keyset, List<Entry> list, MonitoringAnnotations monitoringAnnotations) {
        this.keyset = keyset;
        this.entries = list;
        this.annotations = monitoringAnnotations;
    }

    private static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset encryptedKeyset) {
        if (encryptedKeyset == null || encryptedKeyset.getEncryptedKeyset().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void assertEnoughKeyMaterial(Keyset keyset) {
        if (keyset == null || keyset.getKeyCount() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static void assertNoSecretKeyMaterial(Keyset keyset) {
        for (Keyset.Key key : keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", key.getKeyData().getKeyMaterialType().name(), key.getKeyData().getTypeUrl()));
            }
        }
    }

    @Deprecated
    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess keyAccess) {
        KeysetManager add = KeysetManager.withEmptyKeyset().add(keyHandle);
        add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return add.getKeysetHandle();
    }

    private static KeyData createPublicKeyData(KeyData keyData) {
        if (keyData.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
            throw new GeneralSecurityException("The keyset contains a non-private key");
        }
        KeyData publicKeyData = Registry.getPublicKeyData(keyData.getTypeUrl(), keyData.getValue());
        validate(publicKeyData);
        return publicKeyData;
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead aead, byte[] bArr) {
        try {
            Keyset parseFrom = Keyset.parseFrom(aead.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), bArr), ExtensionRegistryLite.getEmptyRegistry());
            assertEnoughKeyMaterial(parseFrom);
            return parseFrom;
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static EncryptedKeyset encrypt(Keyset keyset, Aead aead, byte[] bArr) {
        byte[] encrypt = aead.encrypt(keyset.toByteArray(), bArr);
        try {
            if (Keyset.parseFrom(aead.decrypt(encrypt, bArr), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset)) {
                return EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(encrypt)).setKeysetInfo(Util.getKeysetInfo(keyset)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private Entry entryByIndex(int i3) {
        if (this.entries.get(i3) != null) {
            return this.entries.get(i3);
        }
        throw new IllegalStateException("Keyset-Entry at position i has wrong status or key parsing failed");
    }

    static final KeysetHandle fromKeyset(Keyset keyset) {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset, getEntriesFromKeyset(keyset));
    }

    static final KeysetHandle fromKeysetAndAnnotations(Keyset keyset, MonitoringAnnotations monitoringAnnotations) {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset, getEntriesFromKeyset(keyset), monitoringAnnotations);
    }

    public static Builder.Entry generateEntryFromParameters(Parameters parameters) {
        return new Builder.Entry(parameters, (AnonymousClass1) null);
    }

    public static Builder.Entry generateEntryFromParametersName(String str) {
        if (Registry.keyTemplateMap().containsKey(str)) {
            return new Builder.Entry(MutableSerializationRegistry.globalInstance().parseParametersWithLegacyFallback(ProtoParametersSerialization.create(Registry.keyTemplateMap().get(str).getProto())), (AnonymousClass1) null);
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) {
        return newBuilder().addEntry(generateEntryFromParameters(new LegacyProtoParameters(ProtoParametersSerialization.create(keyTemplate.getProto()))).makePrimary().withRandomId()).build();
    }

    @Deprecated
    public static final KeysetHandle generateNew(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        return newBuilder().addEntry(generateEntryFromParameters(new LegacyProtoParameters(ProtoParametersSerialization.create(keyTemplate))).makePrimary().withRandomId()).build();
    }

    private static List<Entry> getEntriesFromKeyset(Keyset keyset) {
        ArrayList arrayList = new ArrayList(keyset.getKeyCount());
        for (Keyset.Key key : keyset.getKeyList()) {
            int keyId = key.getKeyId();
            try {
                arrayList.add(new Entry(MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(toProtoKeySerialization(key), InsecureSecretKeyAccess.get()), parseStatus(key.getStatus()), keyId, keyId == keyset.getPrimaryKeyId(), null));
            } catch (GeneralSecurityException unused) {
                arrayList.add(null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private <B> B getFullPrimitiveOrNull(Key key, Class<B> cls) {
        try {
            return (B) Registry.getFullPrimitive(key, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Nullable
    private static <B> B getLegacyPrimitiveOrNull(Keyset.Key key, Class<B> cls) {
        try {
            return (B) Registry.getPrimitive(key.getKeyData(), cls);
        } catch (GeneralSecurityException e3) {
            if (e3.getMessage().contains("No key manager found for key type ") || e3.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <B, P> P getPrimitiveWithKnownInputPrimitive(Class<P> cls, Class<B> cls2) {
        Util.validateKeyset(this.keyset);
        PrimitiveSet.Builder newBuilder = PrimitiveSet.newBuilder(cls2);
        newBuilder.setAnnotations(this.annotations);
        for (int i3 = 0; i3 < size(); i3++) {
            Keyset.Key key = this.keyset.getKey(i3);
            if (key.getStatus().equals(KeyStatusType.ENABLED)) {
                Object legacyPrimitiveOrNull = getLegacyPrimitiveOrNull(key, cls2);
                Object fullPrimitiveOrNull = this.entries.get(i3) != null ? getFullPrimitiveOrNull(this.entries.get(i3).getKey(), cls2) : null;
                if (key.getKeyId() == this.keyset.getPrimaryKeyId()) {
                    newBuilder.addPrimaryFullPrimitiveAndOptionalPrimitive(fullPrimitiveOrNull, legacyPrimitiveOrNull, key);
                } else {
                    newBuilder.addFullPrimitiveAndOptionalPrimitive(fullPrimitiveOrNull, legacyPrimitiveOrNull, key);
                }
            }
        }
        return (P) Registry.wrap(newBuilder.build(), cls);
    }

    public static Builder.Entry importKey(Key key) {
        Builder.Entry entry = new Builder.Entry(key, (AnonymousClass1) null);
        Integer idRequirementOrNull = key.getIdRequirementOrNull();
        if (idRequirementOrNull != null) {
            entry.withFixedId(idRequirementOrNull.intValue());
        }
        return entry;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(KeysetHandle keysetHandle) {
        Builder builder = new Builder();
        for (int i3 = 0; i3 < keysetHandle.size(); i3++) {
            Entry entryByIndex = keysetHandle.entryByIndex(i3);
            Builder.Entry withFixedId = importKey(entryByIndex.getKey()).withFixedId(entryByIndex.getId());
            withFixedId.setStatus(entryByIndex.getStatus());
            if (entryByIndex.isPrimary()) {
                withFixedId.makePrimary();
            }
            builder.addEntry(withFixedId);
        }
        return builder;
    }

    private static KeyStatus parseStatus(KeyStatusType keyStatusType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i3 == 1) {
            return KeyStatus.ENABLED;
        }
        if (i3 == 2) {
            return KeyStatus.DISABLED;
        }
        if (i3 == 3) {
            return KeyStatus.DESTROYED;
        }
        throw new GeneralSecurityException("Unknown key status");
    }

    public static final KeysetHandle read(KeysetReader keysetReader, Aead aead) {
        return readWithAssociatedData(keysetReader, aead, new byte[0]);
    }

    public static final KeysetHandle readNoSecret(KeysetReader keysetReader) {
        try {
            Keyset read = keysetReader.read();
            assertNoSecretKeyMaterial(read);
            return fromKeyset(read);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    @Deprecated
    public static final KeysetHandle readNoSecret(byte[] bArr) {
        try {
            Keyset parseFrom = Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            assertNoSecretKeyMaterial(parseFrom);
            return fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle readWithAssociatedData(KeysetReader keysetReader, Aead aead, byte[] bArr) {
        EncryptedKeyset readEncrypted = keysetReader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(readEncrypted);
        return fromKeyset(decrypt(readEncrypted, aead, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyStatusType serializeStatus(KeyStatus keyStatus) {
        if (KeyStatus.ENABLED.equals(keyStatus)) {
            return KeyStatusType.ENABLED;
        }
        if (KeyStatus.DISABLED.equals(keyStatus)) {
            return KeyStatusType.DISABLED;
        }
        if (KeyStatus.DESTROYED.equals(keyStatus)) {
            return KeyStatusType.DESTROYED;
        }
        throw new IllegalStateException("Unknown key status");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Keyset.Key toKeysetKey(int i3, KeyStatusType keyStatusType, ProtoKeySerialization protoKeySerialization) {
        return Keyset.Key.newBuilder().setKeyData(KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setStatus(keyStatusType).setKeyId(i3).setOutputPrefixType(protoKeySerialization.getOutputPrefixType()).build();
    }

    private static ProtoKeySerialization toProtoKeySerialization(Keyset.Key key) {
        try {
            return ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), key.getOutputPrefixType() == OutputPrefixType.RAW ? null : Integer.valueOf(key.getKeyId()));
        } catch (GeneralSecurityException e3) {
            throw new TinkBugException("Creating a protokey serialization failed", e3);
        }
    }

    private static void validate(KeyData keyData) {
        Registry.getPrimitive(keyData);
    }

    public Entry getAt(int i3) {
        if (i3 >= 0 && i3 < size()) {
            return entryByIndex(i3);
        }
        throw new IndexOutOfBoundsException("Invalid index " + i3 + " for keyset of size " + size());
    }

    @Deprecated
    public List<KeyHandle> getKeys() {
        ArrayList arrayList = new ArrayList();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            arrayList.add(new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    Keyset getKeyset() {
        return this.keyset;
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    public Entry getPrimary() {
        for (int i3 = 0; i3 < this.keyset.getKeyCount(); i3++) {
            if (this.keyset.getKey(i3).getKeyId() == this.keyset.getPrimaryKeyId()) {
                Entry entryByIndex = entryByIndex(i3);
                if (entryByIndex.getStatus() == KeyStatus.ENABLED) {
                    return entryByIndex;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no primary");
    }

    public <P> P getPrimitive(Class<P> cls) {
        Class<?> inputPrimitive = Registry.getInputPrimitive(cls);
        if (inputPrimitive != null) {
            return (P) getPrimitiveWithKnownInputPrimitive(cls, inputPrimitive);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    public KeysetHandle getPublicKeysetHandle() {
        if (this.keyset == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        Keyset.Builder newBuilder = Keyset.newBuilder();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            newBuilder.addKey(key.toBuilder().setKeyData(createPublicKeyData(key.getKeyData())).build());
        }
        newBuilder.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
        return fromKeyset(newBuilder.build());
    }

    @Deprecated
    public KeyHandle primaryKey() {
        int primaryKeyId = this.keyset.getPrimaryKeyId();
        for (Keyset.Key key : this.keyset.getKeyList()) {
            if (key.getKeyId() == primaryKeyId) {
                return new InternalKeyHandle(new ProtoKey(key.getKeyData(), KeyTemplate.fromProto(key.getOutputPrefixType())), key.getStatus(), key.getKeyId());
            }
        }
        throw new GeneralSecurityException("No primary key found in keyset.");
    }

    public int size() {
        return this.keyset.getKeyCount();
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    public void write(KeysetWriter keysetWriter, Aead aead) {
        writeWithAssociatedData(keysetWriter, aead, new byte[0]);
    }

    public void writeNoSecret(KeysetWriter keysetWriter) {
        assertNoSecretKeyMaterial(this.keyset);
        keysetWriter.write(this.keyset);
    }

    public void writeWithAssociatedData(KeysetWriter keysetWriter, Aead aead, byte[] bArr) {
        keysetWriter.write(encrypt(this.keyset, aead, bArr));
    }
}
