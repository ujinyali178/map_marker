package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.jwt.JwtFormat;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import com.google.crypto.tink.subtle.Validators;
import com.google.gson.JsonObject;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Optional;

/* loaded from: /root/release/classes.dex */
class JwtRsaSsaPkcs1VerifyKeyManager extends KeyTypeManager<JwtRsaSsaPkcs1PublicKey> {

    /* renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPkcs1Algorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = iArr;
            try {
                iArr[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public JwtRsaSsaPkcs1VerifyKeyManager() {
        super(JwtRsaSsaPkcs1PublicKey.class, new PrimitiveFactory<JwtPublicKeyVerifyInternal, JwtRsaSsaPkcs1PublicKey>(JwtPublicKeyVerifyInternal.class) { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager.1
            @Override // com.google.crypto.tink.internal.PrimitiveFactory
            public JwtPublicKeyVerifyInternal getPrimitive(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
                final RsaSsaPkcs1VerifyJce rsaSsaPkcs1VerifyJce = new RsaSsaPkcs1VerifyJce(JwtRsaSsaPkcs1VerifyKeyManager.createPublicKey(jwtRsaSsaPkcs1PublicKey), JwtRsaSsaPkcs1VerifyKeyManager.hashForPkcs1Algorithm(jwtRsaSsaPkcs1PublicKey.getAlgorithm()));
                final String name = jwtRsaSsaPkcs1PublicKey.getAlgorithm().name();
                final Optional of = jwtRsaSsaPkcs1PublicKey.hasCustomKid() ? Optional.of(jwtRsaSsaPkcs1PublicKey.getCustomKid().getValue()) : Optional.empty();
                return new JwtPublicKeyVerifyInternal() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager.1.1
                    @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerifyInternal
                    public VerifiedJwt verifyAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) {
                        JwtFormat.Parts splitSignedCompact = JwtFormat.splitSignedCompact(str);
                        rsaSsaPkcs1VerifyJce.verify(splitSignedCompact.signatureOrMac, splitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                        JsonObject parseJson = JsonUtil.parseJson(splitSignedCompact.header);
                        JwtFormat.validateHeader(name, optional, of, parseJson);
                        return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(parseJson), splitSignedCompact.payload));
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RSAPublicKey createPublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        return (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, jwtRsaSsaPkcs1PublicKey.getN().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PublicKey.getE().toByteArray())));
    }

    public static Enums.HashType hashForPkcs1Algorithm(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm) {
        int i3 = AnonymousClass2.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[jwtRsaSsaPkcs1Algorithm.ordinal()];
        if (i3 == 1) {
            return Enums.HashType.SHA256;
        }
        if (i3 == 2) {
            return Enums.HashType.SHA384;
        }
        if (i3 == 3) {
            return Enums.HashType.SHA512;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtRsaSsaPkcs1Algorithm.name());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public JwtRsaSsaPkcs1PublicKey parseKey(ByteString byteString) {
        return JwtRsaSsaPkcs1PublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        Validators.validateVersion(jwtRsaSsaPkcs1PublicKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, jwtRsaSsaPkcs1PublicKey.getN().toByteArray()).bitLength());
        Validators.validateRsaPublicExponent(new BigInteger(1, jwtRsaSsaPkcs1PublicKey.getE().toByteArray()));
    }
}
