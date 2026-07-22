package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* loaded from: /root/release/classes.dex */
final class AesCmacProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesCmacKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesCmacParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCmacKey";
    private static final Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.mac.AesCmacProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        Bytes bytesFromPrintableAscii = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.mac.b
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                ProtoParametersSerialization serializeParameters;
                serializeParameters = AesCmacProtoSerialization.serializeParameters((AesCmacParameters) parameters);
                return serializeParameters;
            }
        }, AesCmacParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.mac.c
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                AesCmacParameters parseParameters;
                parseParameters = AesCmacProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
                return parseParameters;
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.mac.d
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                ProtoKeySerialization serializeKey;
                serializeKey = AesCmacProtoSerialization.serializeKey((AesCmacKey) key, secretKeyAccess);
                return serializeKey;
            }
        }, AesCmacKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.mac.e
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                AesCmacKey parseKey;
                parseKey = AesCmacProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
                return parseKey;
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private AesCmacProtoSerialization() {
    }

    private static AesCmacParams getProtoParams(AesCmacParameters aesCmacParameters) {
        return AesCmacParams.newBuilder().setTagSize(aesCmacParameters.getCryptographicTagSizeBytes()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCmacKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
        try {
            com.google.crypto.tink.proto.AesCmacKey parseFrom = com.google.crypto.tink.proto.AesCmacKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (parseFrom.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesCmacKey.builder().setParameters(AesCmacParameters.builder().setKeySizeBytes(parseFrom.getKeyValue().size()).setTagSizeBytes(parseFrom.getParams().getTagSize()).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).build()).setAesKeyBytes(SecretBytes.copyFrom(parseFrom.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCmacParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            try {
                AesCmacKeyFormat parseFrom = AesCmacKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
                return AesCmacParameters.builder().setKeySizeBytes(parseFrom.getKeySize()).setTagSizeBytes(parseFrom.getParams().getTagSize()).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).build();
            } catch (InvalidProtocolBufferException e3) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e3);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
    }

    public static void register() {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(KEY_PARSER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesCmacKey aesCmacKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.create(TYPE_URL, com.google.crypto.tink.proto.AesCmacKey.newBuilder().setParams(getProtoParams(aesCmacKey.getParameters())).setKeyValue(ByteString.copyFrom(aesCmacKey.getAesKey().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toOutputPrefixType(aesCmacKey.getParameters().getVariant()), aesCmacKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesCmacParameters aesCmacParameters) {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesCmacKeyFormat.newBuilder().setParams(getProtoParams(aesCmacParameters)).setKeySize(aesCmacParameters.getKeySizeBytes()).build().toByteString()).setOutputPrefixType(toOutputPrefixType(aesCmacParameters.getVariant())).build());
    }

    private static OutputPrefixType toOutputPrefixType(AesCmacParameters.Variant variant) {
        if (AesCmacParameters.Variant.TINK.equals(variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesCmacParameters.Variant.CRUNCHY.equals(variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesCmacParameters.Variant.NO_PREFIX.equals(variant)) {
            return OutputPrefixType.RAW;
        }
        if (AesCmacParameters.Variant.LEGACY.equals(variant)) {
            return OutputPrefixType.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesCmacParameters.Variant toVariant(OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return AesCmacParameters.Variant.TINK;
        }
        if (i3 == 2) {
            return AesCmacParameters.Variant.CRUNCHY;
        }
        if (i3 == 3) {
            return AesCmacParameters.Variant.LEGACY;
        }
        if (i3 == 4) {
            return AesCmacParameters.Variant.NO_PREFIX;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }
}
