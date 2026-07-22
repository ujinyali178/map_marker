package com.google.crypto.tink;

import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class PrimitiveSet<P> {
    private final MonitoringAnnotations annotations;
    private final boolean isMutable;
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<Prefix, List<Entry<P>>> primitives;

    public static class Builder<P> {
        private MonitoringAnnotations annotations;
        private Entry<P> primary;
        private final Class<P> primitiveClass;
        private ConcurrentMap<Prefix, List<Entry<P>>> primitives;

        private Builder(Class<P> cls) {
            this.primitives = new ConcurrentHashMap();
            this.primitiveClass = cls;
            this.annotations = MonitoringAnnotations.EMPTY;
        }

        private Builder<P> addPrimitive(@Nullable P p3, @Nullable P p4, Keyset.Key key, boolean z3) {
            if (this.primitives == null) {
                throw new IllegalStateException("addPrimitive cannot be called after build");
            }
            if (p3 == null && p4 == null) {
                throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
            }
            if (key.getStatus() != KeyStatusType.ENABLED) {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
            Entry<P> addEntryToMap = PrimitiveSet.addEntryToMap(p3, p4, key, this.primitives);
            if (z3) {
                if (this.primary != null) {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                this.primary = addEntryToMap;
            }
            return this;
        }

        public Builder<P> addFullPrimitiveAndOptionalPrimitive(@Nullable P p3, @Nullable P p4, Keyset.Key key) {
            return addPrimitive(p3, p4, key, false);
        }

        public Builder<P> addPrimaryFullPrimitiveAndOptionalPrimitive(@Nullable P p3, @Nullable P p4, Keyset.Key key) {
            return addPrimitive(p3, p4, key, true);
        }

        public Builder<P> addPrimaryPrimitive(P p3, Keyset.Key key) {
            return addPrimitive(null, p3, key, true);
        }

        public Builder<P> addPrimitive(P p3, Keyset.Key key) {
            return addPrimitive(null, p3, key, false);
        }

        public PrimitiveSet<P> build() {
            ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap = this.primitives;
            if (concurrentMap == null) {
                throw new IllegalStateException("build cannot be called twice");
            }
            PrimitiveSet<P> primitiveSet = new PrimitiveSet<>(concurrentMap, this.primary, this.annotations, this.primitiveClass);
            this.primitives = null;
            return primitiveSet;
        }

        public Builder<P> setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.primitives == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build");
            }
            this.annotations = monitoringAnnotations;
            return this;
        }
    }

    public static final class Entry<P> {

        @Nullable
        private final P fullPrimitive;
        private final byte[] identifier;
        private final Key key;
        private final int keyId;
        private final String keyType;
        private final OutputPrefixType outputPrefixType;

        @Nullable
        private final P primitive;
        private final KeyStatusType status;

        Entry(@Nullable P p3, @Nullable P p4, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType, int i3, String str, Key key) {
            this.fullPrimitive = p3;
            this.primitive = p4;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType;
            this.keyId = i3;
            this.keyType = str;
            this.key = key;
        }

        @Nullable
        public P getFullPrimitive() {
            return this.fullPrimitive;
        }

        @Nullable
        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public Key getKey() {
            return this.key;
        }

        public int getKeyId() {
            return this.keyId;
        }

        public String getKeyType() {
            return this.keyType;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        @Nullable
        public Parameters getParameters() {
            Key key = this.key;
            if (key == null) {
                return null;
            }
            return key.getParameters();
        }

        @Nullable
        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }
    }

    private static class Prefix implements Comparable<Prefix> {
        private final byte[] prefix;

        private Prefix(byte[] bArr) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        @Override // java.lang.Comparable
        public int compareTo(Prefix prefix) {
            byte[] bArr = this.prefix;
            int length = bArr.length;
            byte[] bArr2 = prefix.prefix;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i3 = 0;
            while (true) {
                byte[] bArr3 = this.prefix;
                if (i3 >= bArr3.length) {
                    return 0;
                }
                byte b4 = bArr3[i3];
                byte b5 = prefix.prefix[i3];
                if (b4 != b5) {
                    return b4 - b5;
                }
                i3++;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Prefix) {
                return Arrays.equals(this.prefix, ((Prefix) obj).prefix);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public String toString() {
            return Hex.encode(this.prefix);
        }
    }

    private PrimitiveSet(Class<P> cls) {
        this.primitives = new ConcurrentHashMap();
        this.primitiveClass = cls;
        this.annotations = MonitoringAnnotations.EMPTY;
        this.isMutable = true;
    }

    private PrimitiveSet(ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap, Entry<P> entry, MonitoringAnnotations monitoringAnnotations, Class<P> cls) {
        this.primitives = concurrentMap;
        this.primary = entry;
        this.primitiveClass = cls;
        this.annotations = monitoringAnnotations;
        this.isMutable = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <P> Entry<P> addEntryToMap(@Nullable P p3, @Nullable P p4, Keyset.Key key, ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap) {
        Integer valueOf = Integer.valueOf(key.getKeyId());
        if (key.getOutputPrefixType() == OutputPrefixType.RAW) {
            valueOf = null;
        }
        Entry<P> entry = new Entry<>(p3, p4, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId(), key.getKeyData().getTypeUrl(), MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), valueOf), InsecureSecretKeyAccess.get()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(entry);
        Prefix prefix = new Prefix(entry.getIdentifier());
        List<Entry<P>> put = concurrentMap.put(prefix, Collections.unmodifiableList(arrayList));
        if (put != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(put);
            arrayList2.add(entry);
            concurrentMap.put(prefix, Collections.unmodifiableList(arrayList2));
        }
        return entry;
    }

    public static <P> Builder<P> newBuilder(Class<P> cls) {
        return new Builder<>(cls);
    }

    @Deprecated
    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    @Deprecated
    public Entry<P> addPrimitive(P p3, Keyset.Key key) {
        if (!this.isMutable) {
            throw new IllegalStateException("addPrimitive cannot be called on an immutable primitive set");
        }
        if (key.getStatus() == KeyStatusType.ENABLED) {
            return addEntryToMap(null, p3, key, this.primitives);
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    @Nullable
    public Entry<P> getPrimary() {
        return this.primary;
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = this.primitives.get(new Prefix(bArr));
        return list != null ? list : Collections.emptyList();
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public boolean hasAnnotations() {
        return !this.annotations.toMap().isEmpty();
    }

    @Deprecated
    public void setPrimary(Entry<P> entry) {
        if (!this.isMutable) {
            throw new IllegalStateException("setPrimary cannot be called on an immutable primitive set");
        }
        if (entry == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (entry.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        if (getPrimitive(entry.getIdentifier()).isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.primary = entry;
    }
}
