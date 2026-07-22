package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.jwt.JwtFormat;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.Validators;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* loaded from: /root/release/classes.dex */
class JwtEcdsaVerifyKeyManager extends KeyTypeManager<JwtEcdsaPublicKey> {

    /* renamed from: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;

        static {
            int[] iArr = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr;
            try {
                iArr[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class JwtPublicKeyVerifyFactory extends PrimitiveFactory<JwtPublicKeyVerifyInternal, JwtEcdsaPublicKey> {
        public JwtPublicKeyVerifyFactory() {
            super(JwtPublicKeyVerifyInternal.class);
        }

        @Override // com.google.crypto.tink.internal.PrimitiveFactory
        public JwtPublicKeyVerifyInternal getPrimitive(JwtEcdsaPublicKey jwtEcdsaPublicKey) {
            final EcdsaVerifyJce ecdsaVerifyJce = new EcdsaVerifyJce(EllipticCurves.getEcPublicKey(JwtEcdsaVerifyKeyManager.getCurve(jwtEcdsaPublicKey.getAlgorithm()), jwtEcdsaPublicKey.getX().toByteArray(), jwtEcdsaPublicKey.getY().toByteArray()), JwtEcdsaVerifyKeyManager.hashForEcdsaAlgorithm(jwtEcdsaPublicKey.getAlgorithm()), EllipticCurves.EcdsaEncoding.IEEE_P1363);
            final String name = jwtEcdsaPublicKey.getAlgorithm().name();
            final Optional of = jwtEcdsaPublicKey.hasCustomKid() ? Optional.of(jwtEcdsaPublicKey.getCustomKid().getValue()) : Optional.empty();
            return new JwtPublicKeyVerifyInternal() { // from class: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager.JwtPublicKeyVerifyFactory.1
                @Override // com.google.crypto.tink.jwt.JwtPublicKeyVerifyInternal
                public VerifiedJwt verifyAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) {
                    JwtFormat.Parts splitSignedCompact = JwtFormat.splitSignedCompact(str);
                    ecdsaVerifyJce.verify(splitSignedCompact.signatureOrMac, splitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
                    JsonObject parseJson = JsonUtil.parseJson(splitSignedCompact.header);
                    JwtFormat.validateHeader(name, optional, of, parseJson);
                    return jwtValidator.validate(RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(parseJson), splitSignedCompact.payload));
                }
            };
        }
    }

    public JwtEcdsaVerifyKeyManager() {
        super(JwtEcdsaPublicKey.class, new JwtPublicKeyVerifyFactory());
    }

    static final EllipticCurves.CurveType getCurve(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i3 == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i3 == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i3 == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtEcdsaAlgorithm.name());
    }

    public static Enums.HashType hashForEcdsaAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[jwtEcdsaAlgorithm.ordinal()];
        if (i3 == 1) {
            return Enums.HashType.SHA256;
        }
        if (i3 == 2) {
            return Enums.HashType.SHA384;
        }
        if (i3 == 3) {
            return Enums.HashType.SHA512;
        }
        throw new GeneralSecurityException("unknown algorithm " + jwtEcdsaAlgorithm.name());
    }

    static final void validateEcdsaAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) {
        hashForEcdsaAlgorithm(jwtEcdsaAlgorithm);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
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
    public JwtEcdsaPublicKey parseKey(ByteString byteString) {
        return JwtEcdsaPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public void validateKey(JwtEcdsaPublicKey jwtEcdsaPublicKey) {
        Validators.validateVersion(jwtEcdsaPublicKey.getVersion(), getVersion());
        validateEcdsaAlgorithm(jwtEcdsaPublicKey.getAlgorithm());
    }
}
