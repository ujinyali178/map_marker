package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* loaded from: /root/release/classes.dex */
final class KeyManagerRegistry {
    private static final Logger logger = Logger.getLogger(KeyManagerRegistry.class.getName());
    private final ConcurrentMap<String, KeyManagerContainer> keyManagerMap;

    private interface KeyManagerContainer {
        Class<?> getImplementingClass();

        <P> KeyManager<P> getKeyManager(Class<P> cls);

        KeyManager<?> getUntypedKeyManager();

        MessageLite parseKey(ByteString byteString);

        Class<?> publicKeyManagerClassOrNull();

        Set<Class<?>> supportedPrimitives();
    }

    KeyManagerRegistry() {
        this.keyManagerMap = new ConcurrentHashMap();
    }

    KeyManagerRegistry(KeyManagerRegistry keyManagerRegistry) {
        this.keyManagerMap = new ConcurrentHashMap(keyManagerRegistry.keyManagerMap);
    }

    private static <T> T checkNotNull(T t3) {
        t3.getClass();
        return t3;
    }

    private static <P> KeyManagerContainer createContainerFor(final KeyManager<P> keyManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.1
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return KeyManager.this.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) {
                if (KeyManager.this.getPrimitiveClass().equals(cls)) {
                    return KeyManager.this;
                }
                throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                return KeyManager.this;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public MessageLite parseKey(ByteString byteString) {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return Collections.singleton(KeyManager.this.getPrimitiveClass());
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyManagerContainer createContainerFor(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.2
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return KeyTypeManager.this.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) {
                try {
                    return new KeyManagerImpl(KeyTypeManager.this, cls);
                } catch (IllegalArgumentException e3) {
                    throw new GeneralSecurityException("Primitive type not supported", e3);
                }
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                KeyTypeManager keyTypeManager2 = KeyTypeManager.this;
                return new KeyManagerImpl(keyTypeManager2, keyTypeManager2.firstSupportedPrimitiveClass());
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public MessageLite parseKey(ByteString byteString) {
                MessageLite parseKey = KeyTypeManager.this.parseKey(byteString);
                KeyTypeManager.this.validateKey(parseKey);
                return parseKey;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return KeyTypeManager.this.supportedPrimitives();
            }
        };
    }

    private static <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> KeyManagerContainer createPrivateKeyContainerFor(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.3
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return PrivateKeyTypeManager.this.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) {
                try {
                    return new PrivateKeyManagerImpl(PrivateKeyTypeManager.this, keyTypeManager, cls);
                } catch (IllegalArgumentException e3) {
                    throw new GeneralSecurityException("Primitive type not supported", e3);
                }
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                PrivateKeyTypeManager privateKeyTypeManager2 = PrivateKeyTypeManager.this;
                return new PrivateKeyManagerImpl(privateKeyTypeManager2, keyTypeManager, privateKeyTypeManager2.firstSupportedPrimitiveClass());
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [com.google.crypto.tink.shaded.protobuf.MessageLite] */
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public MessageLite parseKey(ByteString byteString) {
                ?? parseKey = PrivateKeyTypeManager.this.parseKey(byteString);
                PrivateKeyTypeManager.this.validateKey(parseKey);
                return parseKey;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return keyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return PrivateKeyTypeManager.this.supportedPrimitives();
            }
        };
    }

    private synchronized KeyManagerContainer getKeyManagerContainerOrThrow(String str) {
        if (!this.keyManagerMap.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return this.keyManagerMap.get(str);
    }

    private <P> KeyManager<P> getKeyManagerInternal(String str, Class<P> cls) {
        KeyManagerContainer keyManagerContainerOrThrow = getKeyManagerContainerOrThrow(str);
        if (cls == null) {
            return (KeyManager<P>) keyManagerContainerOrThrow.getUntypedKeyManager();
        }
        if (keyManagerContainerOrThrow.supportedPrimitives().contains(cls)) {
            return keyManagerContainerOrThrow.getKeyManager(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + keyManagerContainerOrThrow.getImplementingClass() + ", supported primitives: " + toCommaSeparatedString(keyManagerContainerOrThrow.supportedPrimitives()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
    
        r5.keyManagerMap.putIfAbsent(r0, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized <P> void registerKeyManagerContainer(com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer r6, boolean r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.crypto.tink.KeyManager r0 = r6.getUntypedKeyManager()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r0.getKeyType()     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer> r1 = r5.keyManagerMap     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L6f
            com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer r1 = (com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer) r1     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L60
            java.lang.Class r2 = r1.getImplementingClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.Class r3 = r6.getImplementingClass()     // Catch: java.lang.Throwable -> L6f
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L6f
            if (r2 == 0) goto L22
            goto L60
        L22:
            java.util.logging.Logger r7 = com.google.crypto.tink.KeyManagerRegistry.logger     // Catch: java.lang.Throwable -> L6f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r2.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r3 = "Attempted overwrite of a registered key manager for key type "
            r2.append(r3)     // Catch: java.lang.Throwable -> L6f
            r2.append(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6f
            r7.warning(r2)     // Catch: java.lang.Throwable -> L6f
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "typeUrl (%s) is already registered with %s, cannot be re-registered with %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6f
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L6f
            r0 = 1
            java.lang.Class r1 = r1.getImplementingClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6f
            r3[r0] = r1     // Catch: java.lang.Throwable -> L6f
            r0 = 2
            java.lang.Class r6 = r6.getImplementingClass()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L6f
            r3[r0] = r6     // Catch: java.lang.Throwable -> L6f
            java.lang.String r6 = java.lang.String.format(r2, r3)     // Catch: java.lang.Throwable -> L6f
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L6f
            throw r7     // Catch: java.lang.Throwable -> L6f
        L60:
            if (r7 != 0) goto L68
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer> r7 = r5.keyManagerMap     // Catch: java.lang.Throwable -> L6f
            r7.putIfAbsent(r0, r6)     // Catch: java.lang.Throwable -> L6f
            goto L6d
        L68:
            java.util.concurrent.ConcurrentMap<java.lang.String, com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer> r7 = r5.keyManagerMap     // Catch: java.lang.Throwable -> L6f
            r7.put(r0, r6)     // Catch: java.lang.Throwable -> L6f
        L6d:
            monitor-exit(r5)
            return
        L6f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.KeyManagerRegistry.registerKeyManagerContainer(com.google.crypto.tink.KeyManagerRegistry$KeyManagerContainer, boolean):void");
    }

    private static String toCommaSeparatedString(Set<Class<?>> set) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (Class<?> cls : set) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(cls.getCanonicalName());
            z3 = false;
        }
        return sb.toString();
    }

    @Deprecated
    <P> KeyManager<P> getKeyManager(String str) {
        return getKeyManagerInternal(str, null);
    }

    <P> KeyManager<P> getKeyManager(String str, Class<P> cls) {
        return getKeyManagerInternal(str, (Class) checkNotNull(cls));
    }

    KeyManager<?> getUntypedKeyManager(String str) {
        return getKeyManagerContainerOrThrow(str).getUntypedKeyManager();
    }

    boolean isEmpty() {
        return this.keyManagerMap.isEmpty();
    }

    MessageLite parseKeyData(KeyData keyData) {
        return getKeyManagerContainerOrThrow(keyData.getTypeUrl()).parseKey(keyData.getValue());
    }

    synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, KeyTypeManager<PublicKeyProtoT> keyTypeManager) {
        Class<?> publicKeyManagerClassOrNull;
        TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus = privateKeyTypeManager.fipsStatus();
        TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus2 = keyTypeManager.fipsStatus();
        if (!fipsStatus.isCompatible()) {
            throw new GeneralSecurityException("failed to register key manager " + privateKeyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        if (!fipsStatus2.isCompatible()) {
            throw new GeneralSecurityException("failed to register key manager " + keyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        String keyType = privateKeyTypeManager.getKeyType();
        String keyType2 = keyTypeManager.getKeyType();
        if (this.keyManagerMap.containsKey(keyType) && this.keyManagerMap.get(keyType).publicKeyManagerClassOrNull() != null && (publicKeyManagerClassOrNull = this.keyManagerMap.get(keyType).publicKeyManagerClassOrNull()) != null && !publicKeyManagerClassOrNull.getName().equals(keyTypeManager.getClass().getName())) {
            logger.warning("Attempted overwrite of a registered key manager for key type " + keyType + " with inconsistent public key type " + keyType2);
            throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", privateKeyTypeManager.getClass().getName(), publicKeyManagerClassOrNull.getName(), keyTypeManager.getClass().getName()));
        }
        registerKeyManagerContainer(createPrivateKeyContainerFor(privateKeyTypeManager, keyTypeManager), true);
        registerKeyManagerContainer(createContainerFor(keyTypeManager), false);
    }

    synchronized <P> void registerKeyManager(KeyManager<P> keyManager) {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
        }
        registerKeyManagerContainer(createContainerFor(keyManager), false);
    }

    synchronized <KeyProtoT extends MessageLite> void registerKeyManager(KeyTypeManager<KeyProtoT> keyTypeManager) {
        if (!keyTypeManager.fipsStatus().isCompatible()) {
            throw new GeneralSecurityException("failed to register key manager " + keyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        registerKeyManagerContainer(createContainerFor(keyTypeManager), false);
    }

    boolean typeUrlExists(String str) {
        return this.keyManagerMap.containsKey(str);
    }
}
