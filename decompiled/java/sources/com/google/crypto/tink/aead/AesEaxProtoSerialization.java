package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.AesEaxParameters;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
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
final class AesEaxProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesEaxKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesEaxParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesEaxKey";
    private static final Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.aead.AesEaxProtoSerialization$1, reason: invalid class name */
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
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.aead.a
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                ProtoParametersSerialization serializeParameters;
                serializeParameters = AesEaxProtoSerialization.serializeParameters((AesEaxParameters) parameters);
                return serializeParameters;
            }
        }, AesEaxParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.aead.b
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                AesEaxParameters parseParameters;
                parseParameters = AesEaxProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
                return parseParameters;
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.aead.c
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
                ProtoKeySerialization serializeKey;
                serializeKey = AesEaxProtoSerialization.serializeKey((AesEaxKey) key, secretKeyAccess);
                return serializeKey;
            }
        }, AesEaxKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.aead.d
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                AesEaxKey parseKey;
                parseKey = AesEaxProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
                return parseKey;
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private AesEaxProtoSerialization() {
    }

    private static AesEaxParams getProtoParams(AesEaxParameters aesEaxParameters) {
        if (aesEaxParameters.getTagSizeBytes() == 16) {
            return AesEaxParams.newBuilder().setIvSize(aesEaxParameters.getIvSizeBytes()).build();
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(aesEaxParameters.getTagSizeBytes())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesEaxKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
        }
        try {
            com.google.crypto.tink.proto.AesEaxKey parseFrom = com.google.crypto.tink.proto.AesEaxKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (parseFrom.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesEaxKey.builder().setParameters(AesEaxParameters.builder().setKeySizeBytes(parseFrom.getKeyValue().size()).setIvSizeBytes(parseFrom.getParams().getIvSize()).setTagSizeBytes(16).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).build()).setKeyBytes(SecretBytes.copyFrom(parseFrom.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesEaxParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            try {
                AesEaxKeyFormat parseFrom = AesEaxKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
                return AesEaxParameters.builder().setKeySizeBytes(parseFrom.getKeySize()).setIvSizeBytes(parseFrom.getParams().getIvSize()).setTagSizeBytes(16).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).build();
            } catch (InvalidProtocolBufferException e3) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e3);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
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
    public static ProtoKeySerialization serializeKey(AesEaxKey aesEaxKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.create(TYPE_URL, com.google.crypto.tink.proto.AesEaxKey.newBuilder().setParams(getProtoParams(aesEaxKey.getParameters())).setKeyValue(ByteString.copyFrom(aesEaxKey.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).build().toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(aesEaxKey.getParameters().getVariant()), aesEaxKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesEaxParameters aesEaxParameters) {
        return ProtoParametersSerialization.create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesEaxKeyFormat.newBuilder().setParams(getProtoParams(aesEaxParameters)).setKeySize(aesEaxParameters.getKeySizeBytes()).build().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(aesEaxParameters.getVariant())).build());
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesEaxParameters.Variant variant) {
        if (AesEaxParameters.Variant.TINK.equals(variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesEaxParameters.Variant.CRUNCHY.equals(variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesEaxParameters.Variant.NO_PREFIX.equals(variant)) {
            return OutputPrefixType.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesEaxParameters.Variant toVariant(OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return AesEaxParameters.Variant.TINK;
        }
        if (i3 == 2 || i3 == 3) {
            return AesEaxParameters.Variant.CRUNCHY;
        }
        if (i3 == 4) {
            return AesEaxParameters.Variant.NO_PREFIX;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }
}
