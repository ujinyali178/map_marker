package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
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
final class AesGcmProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesGcmKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesGcmParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    private static final Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.aead.AesGcmProtoSerialization$1, reason: invalid class name */
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
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.aead.e
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                ProtoParametersSerialization serializeParameters;
                serializeParameters = AesGcmProtoSerialization.serializeParameters((AesGcmParameters) parameters);
                return serializeParameters;
            }
        }, AesGcmParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.aead.f
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                AesGcmParameters parseParameters;
                parseParameters = AesGcmProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
                return parseParameters;
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.aead.g
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                ProtoKeySerialization serializeKey;
                serializeKey = AesGcmProtoSerialization.serializeKey((AesGcmKey) key, secretKeyAccess);
                return serializeKey;
            }
        }, AesGcmKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.aead.h
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                AesGcmKey parseKey;
                parseKey = AesGcmProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
                return parseKey;
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private AesGcmProtoSerialization() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
        }
        try {
            com.google.crypto.tink.proto.AesGcmKey parseFrom = com.google.crypto.tink.proto.AesGcmKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (parseFrom.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesGcmKey.builder().setParameters(AesGcmParameters.builder().setKeySizeBytes(parseFrom.getKeyValue().size()).setIvSizeBytes(12).setTagSizeBytes(16).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).build()).setKeyBytes(SecretBytes.copyFrom(parseFrom.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            try {
                return AesGcmParameters.builder().setKeySizeBytes(AesGcmKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getKeySize()).setIvSizeBytes(12).setTagSizeBytes(16).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).build();
            } catch (InvalidProtocolBufferException e3) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e3);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
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
    public static ProtoKeySerialization serializeKey(AesGcmKey aesGcmKey, @Nullable SecretKeyAccess secretKeyAccess) {
        validateParameters(aesGcmKey.getParameters());
        return ProtoKeySerialization.create(TYPE_URL, com.google.crypto.tink.proto.AesGcmKey.newBuilder().setKeyValue(ByteString.copyFrom(aesGcmKey.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(aesGcmKey.getParameters().getVariant()), aesGcmKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesGcmParameters aesGcmParameters) {
        validateParameters(aesGcmParameters);
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesGcmKeyFormat.newBuilder().setKeySize(aesGcmParameters.getKeySizeBytes()).build().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(aesGcmParameters.getVariant())).build());
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesGcmParameters.Variant variant) {
        if (AesGcmParameters.Variant.TINK.equals(variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesGcmParameters.Variant.CRUNCHY.equals(variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesGcmParameters.Variant.NO_PREFIX.equals(variant)) {
            return OutputPrefixType.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesGcmParameters.Variant toVariant(OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return AesGcmParameters.Variant.TINK;
        }
        if (i3 == 2 || i3 == 3) {
            return AesGcmParameters.Variant.CRUNCHY;
        }
        if (i3 == 4) {
            return AesGcmParameters.Variant.NO_PREFIX;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }

    private static void validateParameters(AesGcmParameters aesGcmParameters) {
        if (aesGcmParameters.getTagSizeBytes() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", Integer.valueOf(aesGcmParameters.getTagSizeBytes())));
        }
        if (aesGcmParameters.getIvSizeBytes() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", Integer.valueOf(aesGcmParameters.getIvSizeBytes())));
        }
    }
}
