package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
public final class Registry {
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final AtomicReference<KeyManagerRegistry> keyManagerRegistry = new AtomicReference<>(new KeyManagerRegistry());
    private static final ConcurrentMap<String, KeyDeriverContainer> keyDeriverMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyTemplate> keyTemplateMap = new ConcurrentHashMap();

    private interface KeyDeriverContainer {
        KeyData deriveKey(ByteString byteString, InputStream inputStream);
    }

    private Registry() {
    }

    @Deprecated
    public static synchronized void addCatalogue(String str, Catalogue<?> catalogue) {
        synchronized (Registry.class) {
            if (str == null) {
                throw new IllegalArgumentException("catalogueName must be non-null.");
            }
            if (catalogue == null) {
                throw new IllegalArgumentException("catalogue must be non-null.");
            }
            ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
            Locale locale = Locale.US;
            if (concurrentMap.containsKey(str.toLowerCase(locale))) {
                if (!catalogue.getClass().getName().equals(concurrentMap.get(str.toLowerCase(locale)).getClass().getName())) {
                    logger.warning("Attempted overwrite of a catalogueName catalogue for name " + str);
                    throw new GeneralSecurityException("catalogue for name " + str + " has been already registered");
                }
            }
            concurrentMap.put(str.toLowerCase(locale), catalogue);
        }
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer createDeriverFor(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyDeriverContainer() { // from class: com.google.crypto.tink.Registry.1
            /* JADX WARN: Unknown type variable: KeyProtoT in type: com.google.crypto.tink.internal.KeyTypeManager$KeyFactory<KeyFormatProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite, KeyProtoT> */
            private <KeyFormatProtoT extends MessageLite> MessageLite deriveKeyWithFactory(ByteString byteString, InputStream inputStream, KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) {
                try {
                    KeyFormatProtoT parseKeyFormat = keyFactory.parseKeyFormat(byteString);
                    keyFactory.validateKeyFormat(parseKeyFormat);
                    return keyFactory.deriveKey(parseKeyFormat, inputStream);
                } catch (InvalidProtocolBufferException e3) {
                    throw new GeneralSecurityException("parsing key format failed in deriveKey", e3);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyDeriverContainer
            public KeyData deriveKey(ByteString byteString, InputStream inputStream) {
                return KeyData.newBuilder().setTypeUrl(KeyTypeManager.this.getKeyType()).setValue(deriveKeyWithFactory(byteString, inputStream, KeyTypeManager.this.keyFactory()).toByteString()).setKeyMaterialType(KeyTypeManager.this.keyMaterialType()).build();
            }
        };
    }

    static synchronized KeyData deriveKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, InputStream inputStream) {
        KeyData deriveKey;
        synchronized (Registry.class) {
            String typeUrl = keyTemplate.getTypeUrl();
            ConcurrentMap<String, KeyDeriverContainer> concurrentMap = keyDeriverMap;
            if (!concurrentMap.containsKey(typeUrl)) {
                throw new GeneralSecurityException("No keymanager registered or key manager cannot derive keys for " + typeUrl);
            }
            deriveKey = concurrentMap.get(typeUrl).deriveKey(keyTemplate.getValue(), inputStream);
        }
        return deriveKey;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
    
        r5 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (com.google.crypto.tink.Registry.keyTemplateMap.containsKey(r5.getKey()) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0089, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted to register a new key template " + r5.getKey() + " from an existing key manager of type " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
    
        r3 = r4.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0096, code lost:
    
        if (r3.hasNext() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0098, code lost:
    
        r4 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (com.google.crypto.tink.Registry.keyTemplateMap.containsKey(r4.getKey()) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c7, code lost:
    
        throw new java.security.GeneralSecurityException("Attempted overwrite of a registered key template " + r4.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0042, code lost:
    
        if (com.google.crypto.tink.Registry.keyManagerRegistry.get().typeUrlExists(r3) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0044, code lost:
    
        r4 = r4.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized <KeyProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite, KeyFormatProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite> void ensureKeyManagerInsertable(java.lang.String r3, java.util.Map<java.lang.String, com.google.crypto.tink.internal.KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> r4, boolean r5) {
        /*
            java.lang.Class<com.google.crypto.tink.Registry> r0 = com.google.crypto.tink.Registry.class
            monitor-enter(r0)
            if (r5 == 0) goto L34
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Boolean> r1 = com.google.crypto.tink.Registry.newKeyAllowedMap     // Catch: java.lang.Throwable -> L31
            boolean r2 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto L34
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L31
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L1a
            goto L34
        L1a:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r5.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = "New keys are already disallowed for key type "
            r5.append(r1)     // Catch: java.lang.Throwable -> L31
            r5.append(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L31
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L31
            throw r4     // Catch: java.lang.Throwable -> L31
        L31:
            r3 = move-exception
            goto Lc8
        L34:
            if (r5 == 0) goto Lca
            java.util.concurrent.atomic.AtomicReference<com.google.crypto.tink.KeyManagerRegistry> r5 = com.google.crypto.tink.Registry.keyManagerRegistry     // Catch: java.lang.Throwable -> L31
            java.lang.Object r5 = r5.get()     // Catch: java.lang.Throwable -> L31
            com.google.crypto.tink.KeyManagerRegistry r5 = (com.google.crypto.tink.KeyManagerRegistry) r5     // Catch: java.lang.Throwable -> L31
            boolean r5 = r5.typeUrlExists(r3)     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L8a
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L31
        L4c:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto Lca
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L31
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L31
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyTemplate> r1 = com.google.crypto.tink.Registry.keyTemplateMap     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = r5.getKey()     // Catch: java.lang.Throwable -> L31
            boolean r1 = r1.containsKey(r2)     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L65
            goto L4c
        L65:
            java.security.GeneralSecurityException r4 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r1.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = "Attempted to register a new key template "
            r1.append(r2)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> L31
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L31
            r1.append(r5)     // Catch: java.lang.Throwable -> L31
            java.lang.String r5 = " from an existing key manager of type "
            r1.append(r5)     // Catch: java.lang.Throwable -> L31
            r1.append(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L31
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L31
            throw r4     // Catch: java.lang.Throwable -> L31
        L8a:
            java.util.Set r3 = r4.entrySet()     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L31
        L92:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto Lca
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L31
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L31
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyTemplate> r5 = com.google.crypto.tink.Registry.keyTemplateMap     // Catch: java.lang.Throwable -> L31
            java.lang.Object r1 = r4.getKey()     // Catch: java.lang.Throwable -> L31
            boolean r5 = r5.containsKey(r1)     // Catch: java.lang.Throwable -> L31
            if (r5 != 0) goto Lab
            goto L92
        Lab:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r5.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r1 = "Attempted overwrite of a registered key template "
            r5.append(r1)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r4 = r4.getKey()     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L31
            r5.append(r4)     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L31
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L31
            throw r3     // Catch: java.lang.Throwable -> L31
        Lc8:
            monitor-exit(r0)
            throw r3
        Lca:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.Registry.ensureKeyManagerInsertable(java.lang.String, java.util.Map, boolean):void");
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String str) {
        StringBuilder sb;
        String str2;
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
        Locale locale = Locale.US;
        Catalogue<?> catalogue = concurrentMap.get(str.toLowerCase(locale));
        if (catalogue != null) {
            return catalogue;
        }
        String format = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase(locale).startsWith("tinkaead")) {
            format = format + "Maybe call AeadConfig.register().";
        }
        if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
            sb = new StringBuilder();
            sb.append(format);
            str2 = "Maybe call DeterministicAeadConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
            sb = new StringBuilder();
            sb.append(format);
            str2 = "Maybe call StreamingAeadConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
            sb = new StringBuilder();
            sb.append(format);
            str2 = "Maybe call HybridConfig.register().";
        } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
            sb = new StringBuilder();
            sb.append(format);
            str2 = "Maybe call MacConfig.register().";
        } else {
            if (!str.toLowerCase(locale).startsWith("tinkpublickeysign") && !str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
                if (str.toLowerCase(locale).startsWith("tink")) {
                    sb = new StringBuilder();
                    sb.append(format);
                    str2 = "Maybe call TinkConfig.register().";
                }
                throw new GeneralSecurityException(format);
            }
            sb = new StringBuilder();
            sb.append(format);
            str2 = "Maybe call SignatureConfig.register().";
        }
        sb.append(str2);
        format = sb.toString();
        throw new GeneralSecurityException(format);
    }

    static <KeyT extends Key, P> P getFullPrimitive(KeyT keyt, Class<P> cls) {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(keyt, cls);
    }

    @Nullable
    public static Class<?> getInputPrimitive(Class<?> cls) {
        try {
            return MutablePrimitiveRegistry.globalInstance().getInputPrimitiveClass(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String str) {
        return keyManagerRegistry.get().getKeyManager(str);
    }

    public static <P> KeyManager<P> getKeyManager(String str, Class<P> cls) {
        return keyManagerRegistry.get().getKeyManager(str, cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData) {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, ByteString byteString) {
        return keyManagerRegistry.get().getKeyManager(str).getPrimitive(byteString);
    }

    public static <P> P getPrimitive(String str, ByteString byteString, Class<P> cls) {
        return keyManagerRegistry.get().getKeyManager(str, cls).getPrimitive(byteString);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, MessageLite messageLite) {
        return keyManagerRegistry.get().getKeyManager(str).getPrimitive(messageLite);
    }

    public static <P> P getPrimitive(String str, MessageLite messageLite, Class<P> cls) {
        return keyManagerRegistry.get().getKeyManager(str, cls).getPrimitive(messageLite);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr) {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    public static KeyData getPublicKeyData(String str, ByteString byteString) {
        KeyManager keyManager = getKeyManager(str);
        if (keyManager instanceof PrivateKeyManager) {
            return ((PrivateKeyManager) keyManager).getPublicKeyData(byteString);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    public static KeyManager<?> getUntypedKeyManager(String str) {
        return keyManagerRegistry.get().getUntypedKeyManager(str);
    }

    static synchronized Map<String, KeyTemplate> keyTemplateMap() {
        Map<String, KeyTemplate> unmodifiableMap;
        synchronized (Registry.class) {
            unmodifiableMap = Collections.unmodifiableMap(keyTemplateMap);
        }
        return unmodifiableMap;
    }

    public static synchronized List<String> keyTemplates() {
        List<String> unmodifiableList;
        synchronized (Registry.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(keyTemplateMap.keySet());
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public static synchronized MessageLite newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (!newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
            newKey = untypedKeyManager.newKey(keyTemplate.getValue());
        }
        return newKey;
    }

    public static synchronized MessageLite newKey(String str, MessageLite messageLite) {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(str);
            if (!newKeyAllowedMap.get(str).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + str);
            }
            newKey = keyManager.newKey(messageLite);
        }
        return newKey;
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) {
        KeyData newKeyData;
        synchronized (Registry.class) {
            newKeyData = newKeyData(keyTemplate.getProto());
        }
        return newKeyData;
    }

    public static synchronized KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (!newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
            newKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
        }
        return newKeyData;
    }

    static MessageLite parseKeyData(KeyData keyData) {
        return keyManagerRegistry.get().parseKeyData(keyData);
    }

    public static synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, KeyTypeManager<PublicKeyProtoT> keyTypeManager, boolean z3) {
        synchronized (Registry.class) {
            if (privateKeyTypeManager == null || keyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerAsymmetricKeyManagers(privateKeyTypeManager, keyTypeManager);
            String keyType = privateKeyTypeManager.getKeyType();
            String keyType2 = keyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, z3 ? privateKeyTypeManager.keyFactory().keyFormats() : Collections.emptyMap(), z3);
            ensureKeyManagerInsertable(keyType2, Collections.emptyMap(), false);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(privateKeyTypeManager));
                if (z3) {
                    registerKeyTemplates(privateKeyTypeManager.getKeyType(), privateKeyTypeManager.keyFactory().keyFormats());
                }
            }
            ConcurrentMap<String, Boolean> concurrentMap = newKeyAllowedMap;
            concurrentMap.put(keyType, Boolean.valueOf(z3));
            concurrentMap.put(keyType2, Boolean.FALSE);
            atomicReference.set(keyManagerRegistry2);
        }
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager) {
        synchronized (Registry.class) {
            registerKeyManager((KeyManager) keyManager, true);
        }
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager, boolean z3) {
        synchronized (Registry.class) {
            try {
                if (keyManager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
                KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
                keyManagerRegistry2.registerKeyManager(keyManager);
                if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
                    throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                }
                String keyType = keyManager.getKeyType();
                ensureKeyManagerInsertable(keyType, Collections.emptyMap(), z3);
                newKeyAllowedMap.put(keyType, Boolean.valueOf(z3));
                atomicReference.set(keyManagerRegistry2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(KeyTypeManager<KeyProtoT> keyTypeManager, boolean z3) {
        synchronized (Registry.class) {
            if (keyTypeManager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerKeyManager(keyTypeManager);
            String keyType = keyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, z3 ? keyTypeManager.keyFactory().keyFormats() : Collections.emptyMap(), z3);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(keyTypeManager));
                if (z3) {
                    registerKeyTemplates(keyType, keyTypeManager.keyFactory().keyFormats());
                }
            }
            newKeyAllowedMap.put(keyType, Boolean.valueOf(z3));
            atomicReference.set(keyManagerRegistry2);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String str, KeyManager<P> keyManager) {
        synchronized (Registry.class) {
            registerKeyManager(str, keyManager, true);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String str, KeyManager<P> keyManager, boolean z3) {
        synchronized (Registry.class) {
            try {
                if (keyManager == null) {
                    throw new IllegalArgumentException("key manager must be non-null.");
                }
                if (!str.equals(keyManager.getKeyType())) {
                    throw new GeneralSecurityException("Manager does not support key type " + str + ".");
                }
                registerKeyManager(keyManager, z3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static <KeyFormatProtoT extends MessageLite> void registerKeyTemplates(String str, Map<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> map) {
        for (Map.Entry<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> entry : map.entrySet()) {
            keyTemplateMap.put(entry.getKey(), KeyTemplate.create(str, entry.getValue().keyFormat.toByteArray(), entry.getValue().outputPrefixType));
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(PrimitiveWrapper<B, P> primitiveWrapper) {
        synchronized (Registry.class) {
            MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(primitiveWrapper);
        }
    }

    static synchronized void reset() {
        synchronized (Registry.class) {
            keyManagerRegistry.set(new KeyManagerRegistry());
            MutablePrimitiveRegistry.resetGlobalInstanceTestOnly();
            keyDeriverMap.clear();
            newKeyAllowedMap.clear();
            catalogueMap.clear();
            keyTemplateMap.clear();
        }
    }

    public static synchronized void restrictToFipsIfEmpty() {
        synchronized (Registry.class) {
            if (TinkFipsUtil.useOnlyFips()) {
                return;
            }
            if (!keyManagerRegistry.get().isEmpty()) {
                throw new GeneralSecurityException("Could not enable FIPS mode as Registry is not empty.");
            }
            TinkFipsUtil.setFipsRestricted();
        }
    }

    public static <P> P wrap(PrimitiveSet<P> primitiveSet) {
        return (P) wrap(primitiveSet, primitiveSet.getPrimitiveClass());
    }

    public static <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> cls) {
        return (P) MutablePrimitiveRegistry.globalInstance().wrap(primitiveSet, cls);
    }
}
