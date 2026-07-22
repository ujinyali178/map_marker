package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.PemKeyType;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.signature.internal.SigUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.Key;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /root/release/classes.dex */
public final class SignaturePemKeysetReader implements KeysetReader {
    private List<PemKey> pemKeys;

    /* renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class Builder {
        private List<PemKey> pemKeys = new ArrayList();

        Builder() {
        }

        public Builder addPem(String str, PemKeyType pemKeyType) {
            PemKey pemKey = new PemKey(null);
            pemKey.reader = new BufferedReader(new StringReader(str));
            pemKey.type = pemKeyType;
            this.pemKeys.add(pemKey);
            return this;
        }

        public KeysetReader build() {
            return new SignaturePemKeysetReader(this.pemKeys);
        }
    }

    private static final class PemKey {
        BufferedReader reader;
        PemKeyType type;

        private PemKey() {
        }

        /* synthetic */ PemKey(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    SignaturePemKeysetReader(List<PemKey> list) {
        this.pemKeys = list;
    }

    private static KeyData convertEcPublicKey(PemKeyType pemKeyType, ECPublicKey eCPublicKey) {
        if (pemKeyType.algorithm.equals("ECDSA")) {
            return KeyData.newBuilder().setTypeUrl(new EcdsaVerifyKeyManager().getKeyType()).setValue(com.google.crypto.tink.proto.EcdsaPublicKey.newBuilder().setVersion(new EcdsaVerifyKeyManager().getVersion()).setParams(EcdsaParams.newBuilder().setHashType(getHashType(pemKeyType)).setCurve(getCurveType(pemKeyType)).setEncoding(EcdsaSignatureEncoding.DER).build()).setX(SigUtil.toUnsignedIntByteString(eCPublicKey.getW().getAffineX())).setY(SigUtil.toUnsignedIntByteString(eCPublicKey.getW().getAffineY())).build().toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
        }
        throw new IOException("unsupported EC signature algorithm: " + pemKeyType.algorithm);
    }

    private static KeyData convertRsaPublicKey(PemKeyType pemKeyType, RSAPublicKey rSAPublicKey) {
        RsaSsaPssPublicKey build;
        KeyData.Builder newBuilder;
        String keyType;
        if (pemKeyType.algorithm.equals("RSASSA-PKCS1-v1_5")) {
            build = RsaSsaPkcs1PublicKey.newBuilder().setVersion(new RsaSsaPkcs1VerifyKeyManager().getVersion()).setParams(RsaSsaPkcs1Params.newBuilder().setHashType(getHashType(pemKeyType)).build()).setE(SigUtil.toUnsignedIntByteString(rSAPublicKey.getPublicExponent())).setN(SigUtil.toUnsignedIntByteString(rSAPublicKey.getModulus())).build();
            newBuilder = KeyData.newBuilder();
            keyType = new RsaSsaPkcs1VerifyKeyManager().getKeyType();
        } else {
            if (!pemKeyType.algorithm.equals("RSASSA-PSS")) {
                throw new IOException("unsupported RSA signature algorithm: " + pemKeyType.algorithm);
            }
            build = RsaSsaPssPublicKey.newBuilder().setVersion(new RsaSsaPssVerifyKeyManager().getVersion()).setParams(RsaSsaPssParams.newBuilder().setSigHash(getHashType(pemKeyType)).setMgf1Hash(getHashType(pemKeyType)).setSaltLength(getDigestSizeInBytes(pemKeyType)).build()).setE(SigUtil.toUnsignedIntByteString(rSAPublicKey.getPublicExponent())).setN(SigUtil.toUnsignedIntByteString(rSAPublicKey.getModulus())).build();
            newBuilder = KeyData.newBuilder();
            keyType = new RsaSsaPssVerifyKeyManager().getKeyType();
        }
        return newBuilder.setTypeUrl(keyType).setValue(build.toByteString()).setKeyMaterialType(KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).build();
    }

    private static EllipticCurveType getCurveType(PemKeyType pemKeyType) {
        int i3 = pemKeyType.keySizeInBits;
        if (i3 == 256) {
            return EllipticCurveType.NIST_P256;
        }
        if (i3 == 384) {
            return EllipticCurveType.NIST_P384;
        }
        if (i3 == 521) {
            return EllipticCurveType.NIST_P521;
        }
        throw new IllegalArgumentException("unsupported curve for key size: " + pemKeyType.keySizeInBits);
    }

    private static int getDigestSizeInBytes(PemKeyType pemKeyType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.hash.ordinal()];
        if (i3 == 1) {
            return 32;
        }
        if (i3 == 2) {
            return 48;
        }
        if (i3 == 3) {
            return 64;
        }
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.hash.name());
    }

    private static HashType getHashType(PemKeyType pemKeyType) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.hash.ordinal()];
        if (i3 == 1) {
            return HashType.SHA256;
        }
        if (i3 == 2) {
            return HashType.SHA384;
        }
        if (i3 == 3) {
            return HashType.SHA512;
        }
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.hash.name());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private static Keyset.Key readKey(BufferedReader bufferedReader, PemKeyType pemKeyType) {
        KeyData convertEcPublicKey;
        Key readKey = pemKeyType.readKey(bufferedReader);
        if (readKey == null) {
            return null;
        }
        if (readKey instanceof RSAPublicKey) {
            convertEcPublicKey = convertRsaPublicKey(pemKeyType, (RSAPublicKey) readKey);
        } else {
            if (!(readKey instanceof ECPublicKey)) {
                return null;
            }
            convertEcPublicKey = convertEcPublicKey(pemKeyType, (ECPublicKey) readKey);
        }
        return Keyset.Key.newBuilder().setKeyData(convertEcPublicKey).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(OutputPrefixType.RAW).setKeyId(Random.randInt()).build();
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() {
        Keyset.Builder newBuilder = Keyset.newBuilder();
        for (PemKey pemKey : this.pemKeys) {
            while (true) {
                Keyset.Key readKey = readKey(pemKey.reader, pemKey.type);
                if (readKey != null) {
                    newBuilder.addKey(readKey);
                }
            }
        }
        if (newBuilder.getKeyCount() == 0) {
            throw new IOException("cannot find any key");
        }
        newBuilder.setPrimaryKeyId(newBuilder.getKey(0).getKeyId());
        return newBuilder.build();
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() {
        throw new UnsupportedOperationException();
    }
}
