package com.google.crypto.tink.internal;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /root/release/classes.dex */
public abstract class KeyTypeManager<KeyProtoT extends MessageLite> {
    private final Class<KeyProtoT> clazz;
    private final Map<Class<?>, PrimitiveFactory<?, KeyProtoT>> factories;
    private final Class<?> firstPrimitiveClass;

    public static abstract class KeyFactory<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        private final Class<KeyFormatProtoT> clazz;

        public static final class KeyFormat<KeyFormatProtoT> {
            public KeyFormatProtoT keyFormat;
            public KeyTemplate.OutputPrefixType outputPrefixType;

            public KeyFormat(KeyFormatProtoT keyformatprotot, KeyTemplate.OutputPrefixType outputPrefixType) {
                this.keyFormat = keyformatprotot;
                this.outputPrefixType = outputPrefixType;
            }
        }

        public KeyFactory(Class<KeyFormatProtoT> cls) {
            this.clazz = cls;
        }

        protected static void readFully(InputStream inputStream, byte[] bArr) {
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int read = inputStream.read(bArr, i3, length - i3);
                if (read == -1) {
                    throw new GeneralSecurityException("Not enough pseudorandomness provided");
                }
                i3 += read;
            }
        }

        public abstract KeyProtoT createKey(KeyFormatProtoT keyformatprotot);

        public KeyProtoT deriveKey(KeyFormatProtoT keyformatprotot, InputStream inputStream) {
            throw new GeneralSecurityException("deriveKey not implemented for key of type " + this.clazz);
        }

        public final Class<KeyFormatProtoT> getKeyFormatClass() {
            return this.clazz;
        }

        public Map<String, KeyFormat<KeyFormatProtoT>> keyFormats() {
            return Collections.emptyMap();
        }

        public abstract KeyFormatProtoT parseKeyFormat(ByteString byteString);

        public abstract void validateKeyFormat(KeyFormatProtoT keyformatprotot);
    }

    @SafeVarargs
    protected KeyTypeManager(Class<KeyProtoT> cls, PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        this.clazz = cls;
        HashMap hashMap = new HashMap();
        for (PrimitiveFactory<?, KeyProtoT> primitiveFactory : primitiveFactoryArr) {
            if (hashMap.containsKey(primitiveFactory.getPrimitiveClass())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + primitiveFactory.getPrimitiveClass().getCanonicalName());
            }
            hashMap.put(primitiveFactory.getPrimitiveClass(), primitiveFactory);
        }
        this.firstPrimitiveClass = primitiveFactoryArr.length > 0 ? primitiveFactoryArr[0].getPrimitiveClass() : Void.class;
        this.factories = Collections.unmodifiableMap(hashMap);
    }

    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public final Class<?> firstSupportedPrimitiveClass() {
        return this.firstPrimitiveClass;
    }

    public final Class<KeyProtoT> getKeyClass() {
        return this.clazz;
    }

    public abstract String getKeyType();

    public final <P> P getPrimitive(KeyProtoT keyprotot, Class<P> cls) {
        PrimitiveFactory<?, KeyProtoT> primitiveFactory = this.factories.get(cls);
        if (primitiveFactory != null) {
            return (P) primitiveFactory.getPrimitive(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract int getVersion();

    public KeyFactory<?, KeyProtoT> keyFactory() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract KeyData.KeyMaterialType keyMaterialType();

    public abstract KeyProtoT parseKey(ByteString byteString);

    public final Set<Class<?>> supportedPrimitives() {
        return this.factories.keySet();
    }

    public abstract void validateKey(KeyProtoT keyprotot);
}
